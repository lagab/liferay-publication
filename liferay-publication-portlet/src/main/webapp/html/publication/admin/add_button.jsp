<%@ include file="/html/init.jsp" %>
<%

    List<DDMStructure> ddmStructures = DDMStructureLocalServiceUtil.getStructures(PortalUtil.getSiteAndCompanyGroupIds(themeDisplay), PortalUtil.getClassNameId(Publication.class));

%>

<aui:nav-item dropdown="<%= PublicationPermission.contains(permissionChecker, scopeGroupId, PortletKeys.ADD_PUBLICATION) %>" id="addButtonContainer" label="add">

    <c:if test="<%= true %>">
        <liferay-portlet:renderURL var="addArticleURL" windowState="<%= LiferayWindowState.MAXIMIZED.toString() %>">
            <portlet:param name="jspPage" value="/html/publication/admin/edit_publication.jsp" />
            <portlet:param name="redirect" value="<%= currentURL %>" />
            <portlet:param name="groupId" value="<%= String.valueOf(scopeGroupId) %>" />
        </liferay-portlet:renderURL>

        <aui:nav-item href="<%= addArticleURL %>" label="basic-post" />

        <%
            List<DDMTemplate> ddmTemplates;
            for (DDMStructure ddmStructure : ddmStructures) {
                ddmTemplates = new ArrayList<DDMTemplate>();

                ddmTemplates.addAll(DDMTemplateServiceUtil.getTemplates(ddmStructure.getGroupId(), PortalUtil.getClassNameId(DDMStructure.class), ddmStructure.getStructureId()));

                if(ddmTemplates.size()>0){
                %>

                <liferay-portlet:renderURL var="addPostURL" windowState="<%= LiferayWindowState.MAXIMIZED.toString() %>">
                    <portlet:param name="jspPage" value="/html/publication/admin/edit_publication.jsp" />
                    <portlet:param name="redirect" value="<%= currentURL %>" />
                    <portlet:param name="groupId" value="<%= String.valueOf(scopeGroupId) %>" />
                    <portlet:param name="structureId" value="<%= ddmStructure.getStructureKey() %>" />
                </liferay-portlet:renderURL>

                <aui:nav-item href="<%= addPostURL %>" label="<%= HtmlUtil.escape(ddmStructure.getName(themeDisplay.getLocale())) %>" />

                <%
                }
            }
        %>

    </c:if>
</aui:nav-item>