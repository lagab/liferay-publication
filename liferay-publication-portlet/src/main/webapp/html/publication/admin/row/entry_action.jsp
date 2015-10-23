<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ include file="/html/init.jsp" %>

<%
    /*String referringPortletResource = ParamUtil.getString(request, "referringPortletResource");*/

    ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

    Publication publication = null;

    if (row != null) {
        publication = (Publication)row.getObject();
    }
    else {
        publication = (Publication)request.getAttribute("view_entries.jsp-entry");
    }
%>

<span class="entry-action overlay">
	<liferay-ui:icon-menu direction="down" extended="<%= false %>" icon="<%= StringPool.BLANK %>" message="<%= StringPool.BLANK %>" showWhenSingleIcon="<%= true %>" triggerCssClass="btn">
        <c:if test="<%= PublicationPermission.contains(permissionChecker, publication, ActionKeys.UPDATE) %>">
            <portlet:renderURL var="editURL">
                <portlet:param name="mvcPath" value="/html/publication/admin/edit_publication.jsp" />
                <portlet:param name="redirect" value="<%= currentURL %>" />
                <portlet:param name="backURL" value="<%= currentURL %>" />
                <portlet:param name="referringPortletResource" value="<%= referringPortletResource %>" />
                <portlet:param name="groupId" value="<%= String.valueOf(publication.getGroupId()) %>" />
                <portlet:param name="entryId" value="<%= String.valueOf(publication.getId()) %>" />
            </portlet:renderURL>

            <liferay-ui:icon
                    image="edit"
                    url="<%= editURL %>"
                    />
        </c:if>


        <c:if test="<%= PublicationPermission.contains(permissionChecker, scopeGroupId, ActionKeys.PERMISSIONS) %>">
            <liferay-security:permissionsURL
                    modelResource="<%= Publication.class.getName() %>"
                    modelResourceDescription="<%= publication.getTitle() %>"
                    resourcePrimKey="<%= String.valueOf(publication.getPrimaryKey()) %>"
                    var="permissionsURL"
                    windowState="<%= LiferayWindowState.POP_UP.toString() %>"
                    />

            <liferay-ui:icon
                    image="permissions"
                    method="get"
                    url="<%= permissionsURL %>"
                    useDialog="<%= true %>"
                    />
        </c:if>

        <c:if test="<%= PublicationPermission.contains(permissionChecker, publication, ActionKeys.DELETE) %>">
            <portlet:actionURL var="deleteURL" name="deletePublication">
                <portlet:param name="<%= Constants.CMD %>" value="<%= TrashUtil.isTrashEnabled(scopeGroupId) ? Constants.MOVE_TO_TRASH : Constants.DELETE %>" />
                <portlet:param name="redirect" value="<%= currentURL %>" />
                <portlet:param name="groupId" value="<%= String.valueOf(publication.getGroupId()) %>" />
                <portlet:param name="entryId" value="<%= String.valueOf(publication.getId()) %>" />
            </portlet:actionURL>

            <liferay-ui:icon-delete
                    url="<%= deleteURL %>"
                    />
        </c:if>
    </liferay-ui:icon-menu>
</span>