<%@include file="/html/init.jsp"%>

<%

    String displayStyle = ParamUtil.getString(request, "displayStyle");

    if (Validator.isNull(displayStyle)) {
        displayStyle = portalPreferences.getValue(PortletKeys.PUBLICATION_PORTLET, "display-style", "descriptive");
    }
    else {
        boolean saveDisplayStyle = ParamUtil.getBoolean(request, "saveDisplayStyle");

        if (saveDisplayStyle && ArrayUtil.contains(displayViews, displayStyle)) {
            portalPreferences.setValue(PortletKeys.PUBLICATION_PORTLET, "display-style", displayStyle);
        }
    }

    if (!ArrayUtil.contains(displayViews, displayStyle)) {
        displayStyle = displayViews[0];
    }

    String ddmStructureName = LanguageUtil.get(pageContext, "basic-post");

    PortletURL portletURL = liferayPortletResponse.createRenderURL();

    portletURL.setParameter("struts_action", "/journal/view");

    int entryStart = ParamUtil.getInteger(request, "entryStart");
    int entryEnd = ParamUtil.getInteger(request, "entryEnd", SearchContainer.DEFAULT_DELTA);

    PublicationSearch searchContainer = new PublicationSearch(liferayPortletRequest, entryEnd / (entryEnd - entryStart), entryEnd - entryStart, portletURL);

    String orderByCol = ParamUtil.getString(request, "orderByCol");
    String orderByType = ParamUtil.getString(request, "orderByType");

    if (Validator.isNull(orderByCol)) {
        orderByCol = portalPreferences.getValue(PortletKeys.PUBLICATION_PORTLET, "order-by-col", "modified-date");
        orderByType = portalPreferences.getValue(PortletKeys.PUBLICATION_PORTLET, "order-by-type", "asc");
    }
    else {
        boolean saveOrderBy = ParamUtil.getBoolean(request, "saveOrderBy");

        if (saveOrderBy) {
            portalPreferences.setValue(PortletKeys.PUBLICATION_PORTLET, "order-by-col", orderByCol);
            portalPreferences.setValue(PortletKeys.PUBLICATION_PORTLET, "order-by-type", orderByType);
        }
    }

    OrderByComparator orderByComparator = PublicationUtil.getPublicationOrderByComparator(orderByCol, orderByType);

    searchContainer.setOrderByCol(orderByCol);
    searchContainer.setOrderByComparator(orderByComparator);
//searchContainer.setOrderByJS("javascript:" + liferayPortletResponse.getNamespace() + "sortEntries('" + folderId + "', 'orderKey', 'orderByType');");
    searchContainer.setOrderByType(orderByType);

    PublicationDisplayTerms displayTerms = (PublicationDisplayTerms)searchContainer.getDisplayTerms();
%>

<c:if test="<%= Validator.isNotNull(displayTerms.getStructureId()) %>">
    <aui:input name="<%= displayTerms.STRUCTURE_ID %>" type="hidden" value="<%= displayTerms.getStructureId() %>" />

    <%
        if ( displayTerms.getStructureId() != 0 ) {
            DDMStructure ddmStructure = null;

            try {
                ddmStructure = DDMStructureLocalServiceUtil.getStructure(themeDisplay.getSiteGroupId(), PortalUtil.getClassNameId(Publication.class), StringUtil.valueOf(displayTerms.getStructureId()), true);

                ddmStructureName = ddmStructure.getName(locale);
            }
            catch (NoSuchStructureException nsse) {
            }
        }
    %>

</c:if>

<c:if test="<%= Validator.isNotNull(displayTerms.getTemplateId()) %>">
    <aui:input name="<%= displayTerms.TEMPLATE_ID %>" type="hidden" value="<%= displayTerms.getTemplateId() %>" />
</c:if>

<c:if test="<%= portletName.equals(PortletKeys.PUBLICATION_PORTLET) && !((themeDisplay.getScopeGroupId() == themeDisplay.getCompanyGroupId()) && (Validator.isNotNull(displayTerms.getStructureId()) || Validator.isNotNull(displayTerms.getTemplateId()))) %>">
    <aui:input name="groupId" type="hidden" />
</c:if>

<%
    PublicationSearchTerms searchTerms = (PublicationSearchTerms)searchContainer.getSearchTerms();


    if (Validator.isNotNull(displayTerms.getStructureId())) {
        searchTerms.setStructureId(displayTerms.getStructureId());
    }

//searchTerms.setVersion(-1);

    if (displayTerms.isNavigationRecent()) {
        searchContainer.setOrderByCol("create-date");
        searchContainer.setOrderByType(orderByType);
    }

    boolean advancedSearch = ParamUtil.getBoolean(request, displayTerms.ADVANCED_SEARCH);

    String keywords = ParamUtil.getString(request, "keywords");

    int status = WorkflowConstants.STATUS_ANY;

    List results = null;
    int total = 0;
%>

<c:choose>
    <c:when test='<%= displayTerms.getNavigation().equals("mine") || displayTerms.isNavigationRecent() %>'>

        <%
            long userId = 0;

            if (displayTerms.getNavigation().equals("mine")) {
                userId = themeDisplay.getUserId();
            }
            else if (!permissionChecker.isCompanyAdmin() || !permissionChecker.isGroupAdmin(scopeGroupId)) {
                status = WorkflowConstants.STATUS_APPROVED;
            }

            total = PublicationServiceUtil.countPublication(scopeGroupId, userId);

            searchContainer.setTotal(total);

            results = PublicationServiceUtil.getUserPublications(scopeGroupId, userId, searchContainer.getStart(), searchContainer.getEnd(), searchContainer.getOrderByComparator());
        %>

    </c:when>
    <c:when test="<%= Validator.isNotNull(displayTerms.getStructureId()) %>">

        <%
            total = PublicationServiceUtil.countPublicationsByStructureId(displayTerms.getGroupId(), searchTerms.getStructureId());

            searchContainer.setTotal(total);

            results = PublicationServiceUtil.getPublicationsByStructureId(displayTerms.getGroupId(), displayTerms.getStructureId(), searchContainer.getStart(), searchContainer.getEnd(), searchContainer.getOrderByComparator());
        %>

    </c:when>
    <c:when test="<%= Validator.isNotNull(displayTerms.getTemplateId()) %>">

        <%
            /*
            total = PublicationServiceUtil.searchCount(company.getCompanyId(), searchTerms.getGroupId(), searchTerms.getFolderIds(), JournalArticleConstants.CLASSNAME_ID_DEFAULT, searchTerms.getKeywords(), searchTerms.getVersionObj(), null, searchTerms.getStructureId(), searchTerms.getTemplateId(), searchTerms.getDisplayDateGT(), searchTerms.getDisplayDateLT(), searchTerms.getStatusCode(), searchTerms.getReviewDate());

            searchContainer.setTotal(total);

            results = PublicationServiceUtil.search(company.getCompanyId(), searchTerms.getGroupId(), searchTerms.getFolderIds(), JournalArticleConstants.CLASSNAME_ID_DEFAULT, searchTerms.getKeywords(), searchTerms.getVersionObj(), null, searchTerms.getStructureId(), searchTerms.getTemplateId(), searchTerms.getDisplayDateGT(), searchTerms.getDisplayDateLT(), searchTerms.getStatusCode(), searchTerms.getReviewDate(), searchContainer.getStart(), searchContainer.getEnd(), searchContainer.getOrderByComparator());
            */
        %>

    </c:when>
    <c:otherwise>

        <%

            total = PublicationServiceUtil.countPublication(scopeGroupId);

            searchContainer.setTotal(total);

            results = PublicationServiceUtil.getPublications(scopeGroupId, searchContainer.getStart(), searchContainer.getEnd(), searchContainer.getOrderByComparator());

        %>

    </c:otherwise>
</c:choose>

<%

    searchContainer.setResults(results);

    request.setAttribute("view.jsp-total", String.valueOf(total));

    request.setAttribute("view_entries.jsp-entryStart", String.valueOf(searchContainer.getStart()));
    request.setAttribute("view_entries.jsp-entryEnd", String.valueOf(searchContainer.getEnd()));
%>

<c:if test="<%= results.isEmpty() %>">
    <div class="entries-empty alert alert-info">
        <c:choose>
            <c:when test="<%= Validator.isNotNull(displayTerms.getStructureId()) %>">
                <c:if test="<%= total == 0 %>">
                    <liferay-ui:message arguments="<%= HtmlUtil.escape(ddmStructureName) %>" key="there-is-no-web-content-with-structure-x" />
                </c:if>
            </c:when>
            <c:otherwise>
                <c:if test="<%= total == 0 %>">
                    <liferay-ui:message key="no-post-was-found" />
                </c:if>
            </c:otherwise>
        </c:choose>
    </div>
</c:if>

<%
    for (int i = 0; i < results.size(); i++) {
        Object result = results.get(i);

        Publication curArticle = null;
        curArticle = (Publication)result;
        curArticle = curArticle.toEscapedModel();

%>

<c:choose>
    <c:when test="<%= curArticle != null %>">
        <c:choose>
            <c:when test='<%= !displayStyle.equals("list") %>'>

                <%
                    PortletURL tempRowURL = liferayPortletResponse.createRenderURL();

                    tempRowURL.setParameter("struts_action", "/journal/edit_article");
                    tempRowURL.setParameter("redirect", currentURL);
                    tempRowURL.setParameter("groupId", String.valueOf(curArticle.getGroupId()));
                    tempRowURL.setParameter("folderId", String.valueOf(curArticle.getFolderId()));
                    tempRowURL.setParameter("articleId", String.valueOf(curArticle.getId()));

                    request.setAttribute("view_entries.jsp-entry", curArticle);

                    request.setAttribute("view_entries.jsp-tempRowURL", tempRowURL);
                %>

                <c:choose>
                    <c:when test='<%= displayStyle.equals("icon") %>'>
                        <jsp:include page="/html/publication/admin/row/view_entry_icon.jsp" />
                    </c:when>
                    <c:otherwise>
                        <jsp:include page="/html/publication/admin/row/view_entry_descriptive.jsp" />
                    </c:otherwise>
                </c:choose>
            </c:when>
            <c:otherwise>
                <liferay-util:buffer var="articleTitle">

                    <%
                        PortletURL rowURL = liferayPortletResponse.createRenderURL();

                        rowURL.setParameter("struts_action", "/journal/edit_article");
                        rowURL.setParameter("redirect", currentURL);
                        rowURL.setParameter("groupId", String.valueOf(curArticle.getGroupId()));
                        rowURL.setParameter("folderId", String.valueOf(curArticle.getFolderId()));
                        rowURL.setParameter("articleId", String.valueOf(curArticle.getId()));

                        if (!permissionChecker.isCompanyAdmin() || !permissionChecker.isGroupAdmin(scopeGroupId)) {
                            status = WorkflowConstants.STATUS_APPROVED;
                        }

                        rowURL.setParameter("status", String.valueOf(status));
                    %>

                    <liferay-ui:icon
                            cssClass="entry-display-style selectable"
                            image="../file_system/small/html"
                            label="<%= true %>"
                            message="<%= curArticle.getTitle() %>"
                            method="get"
                            url="<%= rowURL.toString() %>"
                            />

                    <c:if test="<%= curArticle.getGroupId() != scopeGroupId %>">
                        <small class="group-info">
                            <dl>

                                <%
                                    Group group = GroupLocalServiceUtil.getGroup(curArticle.getGroupId());
                                %>

                                <c:if test="<%= !group.isLayout() || (group.getParentGroupId() != scopeGroupId) %>">
                                    <dt>
                                        <liferay-ui:message key="site" />:
                                    </dt>

                                    <dd>

                                        <%
                                            String groupDescriptiveName = null;

                                            if (group.isLayout()) {
                                                Group parentGroup = group.getParentGroup();

                                                groupDescriptiveName = parentGroup.getDescriptiveName(locale);
                                            }
                                            else {
                                                groupDescriptiveName = group.getDescriptiveName(locale);
                                            }
                                        %>

                                        <%= HtmlUtil.escape(groupDescriptiveName) %>
                                    </dd>
                                </c:if>

                                <c:if test="<%= group.isLayout() %>">
                                    <dt>
                                        <liferay-ui:message key="scope" />:
                                    </dt>

                                    <dd>
                                        <%= group.getDescriptiveName(locale) %>
                                    </dd>
                                </c:if>
                            </dl>
                        </small>
                    </c:if>
                </liferay-util:buffer>

                <%
                    List resultRows = searchContainer.getResultRows();

                    ResultRow row = new ResultRow(curArticle, curArticle.getId(), i);

                    row.setClassName("entry-display-style");

                    Map<String, Object> data = new HashMap<String, Object>();

                    data.put("draggable", PublicationPermission.contains(permissionChecker, curArticle, ActionKeys.DELETE) || PublicationPermission.contains(permissionChecker, curArticle, ActionKeys.UPDATE));
                    data.put("title", curArticle.getTitle());

                    row.setData(data);
                %>

                <%@ include file="/html/publication/admin/publication_columns.jsp" %>

                <%

                    // Add result row

                    resultRows.add(row);
                %>

            </c:otherwise>
        </c:choose>
    </c:when>

</c:choose>

<%
    }
%>

<c:if test='<%= displayStyle.equals("list") %>'>
    <liferay-ui:search-iterator paginate="<%= false %>" searchContainer="<%= searchContainer %>" />
</c:if>

<aui:script>
    Liferay.fire(
    '<portlet:namespace />pageLoaded',
    {
        pagination: {
            name: 'entryPagination',
            state: {
                page: <%= (total == 0) ? 0 : searchContainer.getCur() %>,
                rowsPerPage: <%= searchContainer.getDelta() %>,
                total: <%= total %>
            }
        }
    }
    );
</aui:script>

<%!
    private static Log _log = LogFactoryUtil.getLog("html.publication.admin.view_entries_jsp");
%>