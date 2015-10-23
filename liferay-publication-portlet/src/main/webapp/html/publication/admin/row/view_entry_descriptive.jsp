<%@ page import="java.util.Date" %>
<%@ include file="/html/init.jsp" %>

<%
    Publication entry = (Publication)request.getAttribute("view_entries.jsp-entry");

    PortletURL tempRowURL = (PortletURL)request.getAttribute("view_entries.jsp-tempRowURL");

    Publication latestApprovedArticleVersion = null;

    Date createDate = entry.getCreateDate();

    String productImageURL = renderRequest.getContextPath()+"/images/default_image_product.jpg";

    request.setAttribute("liferay-ui:app-view-entry:actionJsp","/html/publication/admin/row/entry_action.jsp");
    request.setAttribute("liferay-ui:app-view-entry:assetCategoryClassName",Publication.class.getName());
    request.setAttribute("liferay-ui:app-view-entry:assetCategoryClassPK",entry.getPrimaryKey());
    request.setAttribute("liferay-ui:app-view-entry:assetTagClassName",Publication.class.getName());
    request.setAttribute("liferay-ui:app-view-entry:assetTagClassPK",entry.getPrimaryKey());
    request.setAttribute("liferay-ui:app-view-entry:author",entry.getUserName());
    request.setAttribute("liferay-ui:app-view-entry:createDate",createDate);
    request.setAttribute("liferay-ui:app-view-entry:status",entry.getStatus());
    request.setAttribute("liferay-ui:app-view-entry:description",entry.getDescription());
    request.setAttribute("liferay-ui:app-view-entry:displayStyle","descriptive");
    request.setAttribute("liferay-ui:app-view-entry:groupId",entry.getGroupId());
    request.setAttribute("liferay-ui:app-view-entry:modifiedDate",entry.getModifiedDate());
    request.setAttribute("liferay-ui:app-view-entry:rowCheckerId",String.valueOf(entry.getId()));
    request.setAttribute("liferay-ui:app-view-entry:rowCheckerName",Publication.class.getSimpleName());
    request.setAttribute("liferay-ui:app-view-entry:showCheckbox",PublicationPermission.contains(permissionChecker, entry, ActionKeys.DELETE) || PublicationPermission.contains(permissionChecker, entry, ActionKeys.UPDATE));
    request.setAttribute("liferay-ui:app-view-entry:thumbnailDivStyle","height: 136px; width: 136px;");
    request.setAttribute("liferay-ui:app-view-entry:thumbnailSrc",productImageURL);
    request.setAttribute("liferay-ui:app-view-entry:thumbnailStyle","max-height: 128px; max-width: 128px;");
    request.setAttribute("liferay-ui:app-view-entry:title",entry.getTitle());
    request.setAttribute("liferay-ui:app-view-entry:url",tempRowURL.toString());
%>
<jsp:include page="/html/publication/admin/taglib/app-view-entry.jsp" />
