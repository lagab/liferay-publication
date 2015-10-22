package fr.lagab.portlet.publication.web.search;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.dynamicdatamapping.model.DDMStructure;
import com.liferay.portlet.dynamicdatamapping.model.DDMTemplate;
import com.liferay.portlet.dynamicdatamapping.service.DDMStructureLocalServiceUtil;
import com.liferay.portlet.dynamicdatamapping.service.DDMTemplateLocalServiceUtil;
import com.liferay.portlet.journal.model.JournalArticle;

import javax.portlet.PortletRequest;

/**
 * @author lagab
 * @since  21/10/15.
 */
public class PublicationDisplayTerms extends DisplayTerms {

    public static final String PUBLICATION_ID = "id";

    public static final String CONTENT = "content";
    public static final String DESCRIPTION = "description";
    public static final String FOLDER_ID = "folderId";
    public static final String GROUP_ID = "groupId";
    public static final String STRUCTURE_ID = "structureId";
    public static final String TEMPLATE_ID = "templateId";
    public static final String TITLE = "title";
    public static final String NAVIGATION = "navigation";


    protected String publicationId;
    protected String content;
    protected String description;
    protected long structureId;
    protected long templateId;
    protected String title;
    protected long folderId;
    protected long groupId;

    protected String navigation;



    public PublicationDisplayTerms(PortletRequest portletRequest) {
        super(portletRequest);
        publicationId = ParamUtil.getString(portletRequest, PUBLICATION_ID);
        content = ParamUtil.getString(portletRequest, CONTENT);
        description = ParamUtil.getString(portletRequest, DESCRIPTION);
        structureId = ParamUtil.getLong(portletRequest, STRUCTURE_ID);
        templateId = ParamUtil.getLong(portletRequest, TEMPLATE_ID);
        title = ParamUtil.getString(portletRequest, TITLE);
        folderId = ParamUtil.getLong(portletRequest, FOLDER_ID);
        navigation = ParamUtil.getString(portletRequest, NAVIGATION);

        groupId = setGroupId(portletRequest);
    }

    public long setGroupId(PortletRequest portletRequest) {
        groupId = ParamUtil.getLong(portletRequest, GROUP_ID);

        if (groupId != 0) {
            return groupId;
        }

        ThemeDisplay themeDisplay = (ThemeDisplay)portletRequest.getAttribute("LIFERAY_SHARED_THEME_DISPLAY");

        if (Validator.isNotNull(structureId) && structureId != 0 ) {
            DDMStructure ddmStructure = null;

            try {
                ddmStructure = DDMStructureLocalServiceUtil.fetchStructure(
                        themeDisplay.getSiteGroupId(),
                        PortalUtil.getClassNameId(JournalArticle.class),
                        StringUtil.valueOf(structureId));
            }
            catch (SystemException se) {
            }

            if (ddmStructure != null) {
                return 0;
            }
        }

        if (Validator.isNotNull(templateId) && templateId != 0 ) {
            DDMTemplate ddmTemplate = null;

            try {
                ddmTemplate = DDMTemplateLocalServiceUtil.fetchTemplate(
                        themeDisplay.getSiteGroupId(),
                        PortalUtil.getClassNameId(JournalArticle.class),
                        StringUtil.valueOf(templateId) );
            }
            catch (SystemException se) {
            }

            if (ddmTemplate != null) {
                return 0;
            }
        }

        return themeDisplay.getScopeGroupId();
    }

    public String getPublicationId() {
        return publicationId;
    }

    public String getContent() {
        return content;
    }

    public String getDescription() {
        return description;
    }

    public long getStructureId() {
        return structureId;
    }

    public long getTemplateId() {
        return templateId;
    }

    public String getTitle() {
        return title;
    }

    public long getFolderId() {
        return folderId;
    }

    public String getNavigation() {
        return navigation;
    }

    public boolean isNavigationRecent() {
        return (navigation.equals("recent"));
    }

    public long getGroupId() {
        return groupId;
    }
}
