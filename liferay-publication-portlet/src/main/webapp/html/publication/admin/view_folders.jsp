<%@ include file="/html/init.jsp" %>

<%

    String browseBy = ParamUtil.getString(request, "browseBy");
    String structureId = ParamUtil.getString(request, "structureId");

    int entryStart = ParamUtil.getInteger(request, "entryStart");
    int entryEnd = ParamUtil.getInteger(request, "entryEnd", SearchContainer.DEFAULT_DELTA);

    int folderStart = ParamUtil.getInteger(request, "folderStart");
    int folderEnd = ParamUtil.getInteger(request, "folderEnd", SearchContainer.DEFAULT_DELTA);

    int total = 0;

    if (browseBy.equals("structure")) {
        total = DDMStructureLocalServiceUtil.getStructuresCount(PortalUtil.getSiteAndCompanyGroupIds(themeDisplay), PortalUtil.getClassNameId(Publication.class));
    }

    PortletURL portletURL = liferayPortletResponse.createRenderURL();

    portletURL.setParameter("struts_action", "/journal/view");

    SearchContainer searchContainer = new SearchContainer(liferayPortletRequest, null, null, "cur2", folderEnd / (folderEnd - folderStart), (folderEnd - folderStart), portletURL, null, null);

    searchContainer.setTotal(total);

    String parentTitle = StringPool.BLANK;

    if (browseBy.equals("structure")) {
        parentTitle = LanguageUtil.get(pageContext, "browse-by-structure");
    }
    else {
        parentTitle = LanguageUtil.get(pageContext, "home");
    }
%>

<div id="<portlet:namespace />listViewContainer">
    <div id="<portlet:namespace />folderContainer">
        <aui:nav cssClass="nav-list well">
            <c:if test="<%= Validator.isNotNull(parentTitle) %>">
                <li class="nav-header">
                    <%= parentTitle %>
                </li>
            </c:if>

            <c:choose>
                <c:when test='<%= !browseBy.equals("structure") %>'>
                    <liferay-portlet:renderURL varImpl="viewArticlesHomeURL">
                        <portlet:param name="struts_action" value="/journal/view" />
                        <portlet:param name="entryStart" value="0" />
                        <portlet:param name="entryEnd" value="<%= String.valueOf(entryEnd - entryStart) %>" />
                        <portlet:param name="folderStart" value="0" />
                        <portlet:param name="folderEnd" value="<%= String.valueOf(folderEnd - folderStart) %>" />
                    </liferay-portlet:renderURL>

                    <%
                        String navigation = ParamUtil.getString(request, "navigation", "home");


                        Map<String, Object> dataView = new HashMap<String, Object>();

                        dataView.put("navigation", "home");
                        dataView.put("title", LanguageUtil.get(pageContext, "home"));
                    %>

                    <liferay-ui:app-view-navigation-entry
                            dataView="<%= dataView %>"
                            entryTitle='<%= LanguageUtil.get(pageContext, "home") %>'
                            iconImage="icon-home"
                            selected='<%= (navigation.equals("home") && Validator.isNull(structureId) )%>'
                            viewURL="<%= viewArticlesHomeURL.toString() %>"
                            />

                    <liferay-portlet:renderURL varImpl="viewRecentArticlesURL">
                        <portlet:param name="struts_action" value="/journal/view" />
                        <portlet:param name="navigation" value="recent" />
                        <portlet:param name="entryStart" value="0" />
                        <portlet:param name="entryEnd" value="<%= String.valueOf(entryEnd - entryStart) %>" />
                        <portlet:param name="folderStart" value="0" />
                        <portlet:param name="folderEnd" value="<%= String.valueOf(folderEnd - folderStart) %>" />
                    </liferay-portlet:renderURL>

                    <%
                        dataView = new HashMap<String, Object>();

                        dataView.put("navigation", "recent");
                    %>

                    <liferay-ui:app-view-navigation-entry
                            dataView="<%= dataView %>"
                            entryTitle='<%= LanguageUtil.get(pageContext, "recent") %>'
                            iconImage="icon-time"
                            selected='<%= navigation.equals("recent") %>'
                            viewURL="<%= viewRecentArticlesURL.toString() %>"
                            />

                    <c:if test="<%= themeDisplay.isSignedIn() %>">
                        <liferay-portlet:renderURL varImpl="viewMyArticlesURL">
                            <portlet:param name="struts_action" value="/journal/view" />
                            <portlet:param name="navigation" value="mine" />
                            <portlet:param name="entryStart" value="0" />
                            <portlet:param name="entryEnd" value="<%= String.valueOf(entryEnd - entryStart) %>" />
                            <portlet:param name="folderStart" value="0" />
                            <portlet:param name="folderEnd" value="<%= String.valueOf(folderEnd - folderStart) %>" />
                        </liferay-portlet:renderURL>

                        <%
                            dataView = new HashMap<String, Object>();

                            dataView.put("navigation", "mine");
                        %>

                        <liferay-ui:app-view-navigation-entry
                                dataView="<%= dataView %>"
                                entryTitle='<%= LanguageUtil.get(pageContext, "mine") %>'
                                iconImage="icon-user"
                                selected='<%= navigation.equals("mine") %>'
                                viewURL="<%= viewMyArticlesURL.toString() %>"
                                />
                    </c:if>

                    <c:if test="<%= DDMStructureLocalServiceUtil.getStructuresCount(PortalUtil.getSiteAndCompanyGroupIds(themeDisplay), PortalUtil.getClassNameId(Publication.class)) > 0 %>">
                        <liferay-portlet:renderURL varImpl="filterDDMStructureArticlesURL">
                            <portlet:param name="struts_action" value="/journal/view" />
                            <portlet:param name="browseBy" value="structure" />
                            <portlet:param name="entryStart" value="0" />
                            <portlet:param name="entryEnd" value="<%= String.valueOf(entryEnd - entryStart) %>" />
                        </liferay-portlet:renderURL>

                        <%
                            dataView = new HashMap<String, Object>();

                            dataView.put("browse-by", "structure");
                            dataView.put("view-entries", Boolean.FALSE);
                            dataView.put("view-folders", Boolean.TRUE);
                        %>

                        <liferay-ui:app-view-navigation-entry
                                cssClass="folder structure"
                                dataView="<%= dataView %>"
                                entryTitle='<%= LanguageUtil.get(pageContext, "browse-by-structure") %>'
                                iconImage="icon-tasks"
                                selected='<%= browseBy.equals("structure") %>'
                                viewURL="<%= filterDDMStructureArticlesURL.toString() %>"
                                />
                    </c:if>
                </c:when>
                <c:when test='<%= browseBy.equals("structure") %>'>
                    <liferay-portlet:renderURL varImpl="viewURL">
                        <portlet:param name="struts_action" value="/journal/view" />
                        <portlet:param name="structureId" value="<%= String.valueOf(0) %>" />
                        <portlet:param name="entryStart" value="0" />
                        <portlet:param name="entryEnd" value="<%= String.valueOf(entryEnd - entryStart) %>" />
                    </liferay-portlet:renderURL>

                    <%
                        Map<String, Object> dataView = new HashMap<String, Object>();
                    %>

                    <liferay-ui:app-view-navigation-entry
                            dataView="<%= dataView %>"
                            entryTitle='<%= LanguageUtil.get(pageContext, "up") %>'
                            iconImage="icon-level-up"
                            viewURL="<%= viewURL.toString() %>"
                            />

                    <c:if test="<%= total > 0 %>">
                        <c:if test="<%= searchContainer.getStart() == 0 %>">
                            <liferay-portlet:renderURL varImpl="viewBasicDDMStructureArticlesURL">
                                <portlet:param name="struts_action" value="/journal/view" />
                                <portlet:param name="browseBy" value="structure" />
                                <portlet:param name="structureId" value="0" />
                                <portlet:param name="entryStart" value="0" />
                                <portlet:param name="entryEnd" value="<%= String.valueOf(entryEnd - entryStart) %>" />
                            </liferay-portlet:renderURL>

                            <%
                                dataView = new HashMap<String, Object>();

                                dataView.put("browse-by", "structure");
                                dataView.put("structure-id", 0);
                            %>

                            <liferay-ui:app-view-navigation-entry
                                    cssClass="folder structure"
                                    dataView="<%= dataView %>"
                                    entryTitle='<%= LanguageUtil.get(pageContext, "basic-post") %>'
                                    iconImage="icon-tasks"
                                    selected='<%= structureId.equals("0") %>'
                                    viewURL="<%= viewBasicDDMStructureArticlesURL.toString() %>"
                                    />
                        </c:if>

                        <%
                            List<DDMStructure> ddmStructures = DDMStructureLocalServiceUtil.getStructures(PortalUtil.getSiteAndCompanyGroupIds(themeDisplay), PortalUtil.getClassNameId(Publication.class), searchContainer.getStart(), searchContainer.getEnd());

                            for (DDMStructure ddmStructure : ddmStructures) {
                        %>

                        <liferay-portlet:renderURL varImpl="viewDDMStructureArticlesURL">
                            <portlet:param name="struts_action" value="/journal/view" />
                            <portlet:param name="browseBy" value="structure" />
                            <portlet:param name="structureId" value="<%= ddmStructure.getStructureKey() %>" />
                            <portlet:param name="entryStart" value="0" />
                            <portlet:param name="entryEnd" value="<%= String.valueOf(entryEnd - entryStart) %>" />
                        </liferay-portlet:renderURL>

                        <%
                            dataView = new HashMap<String, Object>();

                            dataView.put("browse-by", "structure");
                            dataView.put("structure-id", ddmStructure.getStructureKey());
                        %>

                        <liferay-ui:app-view-navigation-entry
                                cssClass="folder structure"
                                dataView="<%= dataView %>"
                                entryTitle="<%= HtmlUtil.escape(ddmStructure.getName(locale)) %>"
                                iconImage="icon-tasks"
                                selected="<%= structureId.equals(ddmStructure.getStructureKey()) %>"
                                viewURL="<%= viewDDMStructureArticlesURL.toString() %>"
                                />

                        <%
                            }
                        %>

                    </c:if>
                </c:when>
                <c:otherwise>
                    <liferay-portlet:renderURL varImpl="viewURL">
                        <portlet:param name="struts_action" value="/journal/view" />
                        <portlet:param name="entryStart" value="0" />
                        <portlet:param name="entryEnd" value="<%= String.valueOf(entryEnd - entryStart) %>" />
                    </liferay-portlet:renderURL>

                    <%
                        Map<String, Object> dataView = new HashMap<String, Object>();

                        dataView.put("view-folders", Boolean.TRUE);
                    %>

                    <liferay-ui:app-view-navigation-entry
                            dataView="<%= dataView %>"
                            entryTitle='<%= LanguageUtil.get(pageContext, "up") %>'
                            iconImage="icon-level-up"
                            viewURL="<%= viewURL.toString() %>"
                            />

                </c:otherwise>
            </c:choose>
        </aui:nav>
    </div>
</div>

<aui:script>
    Liferay.fire(
    '<portlet:namespace />pageLoaded',
    {
        pagination: {
        name: 'folderPagination',
        state: {
            page: <%= (total == 0) ? 0 : searchContainer.getCur() %>,
            rowsPerPage: <%= searchContainer.getDelta() %>,
            total: <%= total %>
        }
    }
    }
    );
</aui:script>