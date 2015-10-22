<%--
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@ include file="/html/init.jsp" %>

<%
    boolean canAddPublication = PublicationPermission.contains(themeDisplay.getPermissionChecker(),themeDisplay.getScopeGroupId(), PortletKeys.ADD_PUBLICATION);
    boolean showHeader = true;
    String defaultLanguageId = LocaleUtil.toLanguageId(themeDisplay.getSiteDefaultLocale());
%>
<c:if test="<%= canAddPublication %>">
    <%
        String redirect = ParamUtil.getString(request, "redirect");
        String backURL = ParamUtil.getString(request, "backURL");

        Publication publication = null;

        String publicationId = ParamUtil.getString(renderRequest, "entryId");

        if(Validator.isNotNull(publicationId)) {
            publication = PublicationServiceUtil.getPublication(Long.parseLong(publicationId));
        }
        long groupId = BeanParamUtil.getLong(publication, request, "groupId", scopeGroupId);

        long folderId = ParamUtil.getLong(request, "folderId", 0);

        long classPK = GetterUtil.getLong(publicationId);

        request.setAttribute("edit_article.jsp-redirect", redirect);

        if(request.getParameter("cats_selected") != null){
            relatedCategoryId = request.getParameter("cats_selected");
        }


        String structureId = BeanParamUtil.getString(publication, request, "structureId");

        DDMStructure ddmStructure = null;

        long ddmStructureId = ParamUtil.getLong(request, "ddmStructureId");

        if (ddmStructureId > 0) {
            try {
                ddmStructure = DDMStructureLocalServiceUtil.getStructure(ddmStructureId);

            }
            catch (NoSuchStructureException nsse) {
                _log.error(nsse);
            }
        }
        else if (Validator.isNotNull(structureId)) {
            try {
                ddmStructure = DDMStructureLocalServiceUtil.getStructure(themeDisplay.getSiteGroupId(), PortalUtil.getClassNameId(Publication.class), structureId, true);
                ddmStructureId = ddmStructure.getStructureId();
            }
            catch (NoSuchStructureException nsse) {
                _log.error(nsse);
            }
        }

        String templateId = BeanParamUtil.getString(publication, request, "templateId");

        DDMTemplate ddmTemplate = null;

        long ddmTemplateId = GetterUtil.getLong(templateId);

        if (ddmTemplateId > 0) {
            try {
                ddmTemplate = DDMTemplateLocalServiceUtil.getTemplate(ddmTemplateId);
                ddmTemplateId = ddmTemplate.getTemplateId();
            }
            catch (NoSuchTemplateException nste) {
                _log.error(nste);
            }
        }
        else if (Validator.isNotNull(templateId)) {
            try {
                ddmTemplate = DDMTemplateLocalServiceUtil.getTemplate(groupId, PortalUtil.getClassNameId(DDMStructure.class), templateId, true);
                ddmTemplateId = ddmTemplate.getTemplateId();
                System.out.println(ddmTemplate);
            }
            catch (NoSuchStructureException nste) {
                _log.error(nste);
            }
        }

        request.setAttribute("edit_publication.jsp-structure", ddmStructure);
        request.setAttribute("edit_publication.jsp-template", ddmTemplate);
        request.setAttribute("edit_publication.jsp-folderId", folderId);
    %>
    <div class="article-form <%= ((publication != null) && !publication.isNew()) ? "publication-form-edit" : "publication-form-add" %>">
        <c:if test="<%= showHeader %>">
            <%@ include file="/html/publication/admin/publication_header.jsp" %>
        </c:if>

        <aui:form enctype="multipart/form-data" method="post" name="fm2">
            <input name="groupId" type="hidden" value="" />
            <input name="publicationId" type="hidden" value="" />
            <input name="version" type="hidden" value="" />
            <input name="title" type="hidden" value="" />
            <input name="xml" type="hidden" value="" />
        </aui:form>

        <portlet:actionURL var="editPublicationActionURL"  name="editPublication">
            <portlet:param name="mvcPath" value="/html/publication_admin/edit_publication.jsp" />
            <portlet:param name="<%= Constants.CMD %>" value="<%= ((publication == null) || Validator.isNull(publication.getId())) ? Constants.ADD : Constants.UPDATE %>" />
        </portlet:actionURL>

        <portlet:renderURL var="editPublicationRenderURL" windowState="<%= WindowState.MAXIMIZED.toString() %>">
            <portlet:param name="struts_action" value="/journal/edit_article" />
            <portlet:param name="mvcPath" value="/html/publication_admin/edit_publication.jsp" />
        </portlet:renderURL>

        <aui:form action="<%= editPublicationActionURL %>" cssClass="lfr-dynamic-form" enctype="multipart/form-data" method="post" name="fm1" onSubmit='<%= renderResponse.getNamespace() + "submitForm(event);" %>'>
            <aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= ((publication == null) || Validator.isNull(publication.getId())) ? Constants.ADD : Constants.UPDATE %>"/>
            <aui:input name="redirect" type="hidden" value="<%= redirect %>" />
            <aui:input name="backURL" type="hidden" value="<%= backURL %>" />
            <aui:input name="groupId" type="hidden" value="<%= groupId %>" />
            <aui:input name="folderId" type="hidden" value="<%= folderId %>" />
            <aui:input name="classPK" type="hidden" value="<%= classPK %>" />
            <aui:input name="publicationId" type="hidden" value="<%= publicationId %>" />

            <aui:input name="languageId" type="hidden" value="<%= defaultLanguageId %>" />
            <aui:input name="publicationURL" type="hidden" value="<%= editPublicationRenderURL %>" />
            <aui:input name="ddmStructureId" type="hidden" value="<%= ddmStructureId %>"/>

            <aui:model-context bean="<%= publication %>" defaultLanguageId="<%= defaultLanguageId %>" model="<%= Publication.class %>" />

            <liferay-ui:error exception="<%= NoSuchRepositoryEntryException.class %>" message="post-title-required" />
            <div class="publication-wrapper" id="<portlet:namespace />PublicationWrapper">
                <div class="journal-article-wrapper-content">
                    <div class="form-section">
                        <div class="field categories-selector <%= Validator.equals(relatedCategoryId, StringPool.BLANK) ? StringPool.BLANK : "hide" %>">
                            <label>Categories</label>
                            <%
                                String curCategoryIds ="";
                                if(Validator.equals(relatedCategoryId, StringPool.BLANK)){
                                    List<AssetCategory> categories = AssetCategoryServiceUtil.getCategories(Publication.class.getName(), classPK);
                                    curCategoryIds = ListUtil.toString(categories, AssetCategory.CATEGORY_ID_ACCESSOR);

                                }else{
                                    curCategoryIds = relatedCategoryId;
                                }
                            %>
                            <liferay-ui:asset-categories-selector curCategoryIds="<%= curCategoryIds %>" />
                        </div>
                        <liferay-ui:error exception="<%= PublicationTitleException.class %>" message="post-title-required" />
                        <jsp:include page="/html/publication/admin/form.jsp" />

                    </div>

                </div>

                <aui:button-row cssClass="publication-button-row">

                    <%
                        boolean hasSavePermission = false;

                        if (publication != null) {
                            hasSavePermission = PublicationPermission.contains(permissionChecker, publication, ActionKeys.UPDATE);
                        }
                        else {
                            hasSavePermission = PublicationPermission.contains(permissionChecker, groupId, "ADD_PUBLICATION");
                        }

                    %>
                    <c:if test="<%= hasSavePermission %>">
                        <aui:button name="publishButton" onClick='<%= renderResponse.getNamespace() + "publishArticle()" %>' type="submit"/>
                    </c:if>
                    <aui:button href="<%= redirect %>" type="cancel" />
                </aui:button-row>
            </div>
        </aui:form>
    </div>
</c:if>
<%!
    private static Log _log = LogFactoryUtil.getLog("html.publication.admin.edit_publication_jsp");
%>