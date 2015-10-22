<%@ page import="com.liferay.portal.kernel.util.UnicodeProperties" %>
<%@ page import="com.liferay.portal.model.LayoutConstants" %>
<%@ page import="com.liferay.portal.model.Layout" %>
<%@ page import="com.liferay.portal.service.LayoutLocalServiceUtil" %>
<%@ page import="com.liferay.portal.model.LayoutTypePortletConstants" %>
<%@ page import="com.liferay.portlet.dynamicdatamapping.storage.Fields" %>
<%@ page import="fr.lagab.portlet.publication.web.util.converter.PublicationConverterUtil" %>
<%@ include file="/html/init.jsp" %>
form
<%
    Publication publication = (Publication)request.getAttribute("PUBLICATION");
    long groupId = BeanParamUtil.getLong(publication, request, "groupId", scopeGroupId);

    long ddmStructureGroupId = groupId;
    String ddmStructureName = LanguageUtil.get(pageContext, "default");
    String ddmStructureDescription = StringPool.BLANK;
    String structureId = StringPool.BLANK;

    DDMStructure ddmStructure = (DDMStructure)request.getAttribute("edit_publication.jsp-structure");



    if (ddmStructure != null) {
        structureId = ddmStructure.getStructureKey();

        ddmStructureGroupId = ddmStructure.getGroupId();
        ddmStructureName = ddmStructure.getName(locale);
        ddmStructureDescription = ddmStructure.getDescription(locale);
    }

    List<DDMTemplate> ddmTemplates = new ArrayList<DDMTemplate>();

    if (ddmStructure != null) {
        ddmTemplates.addAll(DDMTemplateServiceUtil.getTemplates(ddmStructureGroupId, PortalUtil.getClassNameId(DDMStructure.class), ddmStructure.getStructureId()));

        if (groupId != ddmStructureGroupId) {
            ddmTemplates.addAll(DDMTemplateServiceUtil.getTemplates(groupId, PortalUtil.getClassNameId(DDMStructure.class), ddmStructure.getStructureId()));
        }
    }

    long templateId = 0;

    DDMTemplate ddmTemplate = (DDMTemplate)request.getAttribute("edit_article.jsp-template");

    if (ddmTemplate != null) {
        templateId = ddmTemplate.getTemplateId();
    }
    else if (!ddmTemplates.isEmpty()) {
        ddmTemplate = ddmTemplates.get(0);

        templateId = ddmTemplate.getTemplateId();
    }

    String defaultLanguageId = ParamUtil.getString(request, "defaultLanguageId");

    String toLanguageId = ParamUtil.getString(request, "toLanguageId");
    String content = null;

    boolean preselectCurrentLayout = false;

    if (publication != null) {
        content = ParamUtil.getString(request, "content");

        if (Validator.isNull(content)) {
            content = publication.getContent();
        }

        /*if (Validator.isNotNull(toLanguageId)) {
            content = PublicationImpl.getContentByLocale(content, Validator.isNotNull(structureId), toLanguageId);
        }
        else {
            content = PublicationImpl.getContentByLocale(content, Validator.isNotNull(structureId), defaultLanguageId);
        }*/
    }
    else {
        content = ParamUtil.getString(request, "content");

        UnicodeProperties typeSettingsProperties = layout.getTypeSettingsProperties();

        long refererPlid = ParamUtil.getLong(request, "refererPlid", LayoutConstants.DEFAULT_PLID);

        if (refererPlid > 0) {
            Layout refererLayout = LayoutLocalServiceUtil.getLayout(refererPlid);

            typeSettingsProperties = refererLayout.getTypeSettingsProperties();

            String defaultAssetPublisherPortletId = typeSettingsProperties.getProperty(LayoutTypePortletConstants.DEFAULT_ASSET_PUBLISHER_PORTLET_ID);

            if (Validator.isNotNull(defaultAssetPublisherPortletId)) {
                preselectCurrentLayout = true;
            }
        }
    }
%>
<aui:input name="ddmTemplateId" type="hidden" value="<%= templateId %>" />
<div class="field-container">
    <div class="publication-component-container">
        <aui:input name="title">
            <aui:validator name="required" />
        </aui:input>


        <liferay-ui:error exception="<%= NoSuchRepositoryEntryException.class %>" message="post-related-folder-doesnt-exist" />
        <!-- < jsp:include page="/html/publication_admin/document_uploader.jsp" /> -->
        <!-- All custom fields -->
        <c:choose>
            <c:when test="<%= ddmStructure == null %>"><!-- No structure selected -->
                <aui:input cssClass="lfr-textarea-container span12" style="" label="description" name="description" type="textarea" />
            </c:when>
            <c:otherwise>
                <aui:input name="description" type="hidden" />
                <%
                    Fields ddmFields = null;

                    if ((publication != null) && Validator.isNotNull(publication.getStructureId()) && Validator.isNotNull(content)) {
                        ddmFields = PublicationConverterUtil.getDDMFields(ddmStructure, content);
                    }

                    String requestedLanguageId = defaultLanguageId;

                    if (Validator.isNotNull(toLanguageId)) {
                        requestedLanguageId = toLanguageId;
                    }
                %>

                <liferay-ddm:html
                        classNameId="<%= PortalUtil.getClassNameId(DDMStructure.class) %>"
                        classPK="<%= ddmStructure.getStructureId() %>"
                        fields="<%= ddmFields %>"
                        repeatable="<%= Validator.isNull(toLanguageId) %>"
                        requestedLocale="<%= LocaleUtil.fromLanguageId(requestedLanguageId) %>"
                        />

            </c:otherwise>
        </c:choose>
    </div>
</div>