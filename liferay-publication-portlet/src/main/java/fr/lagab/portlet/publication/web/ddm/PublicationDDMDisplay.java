package fr.lagab.portlet.publication.web.ddm;


import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.template.TemplateConstants;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.dynamicdatamapping.model.DDMStructure;
import com.liferay.portlet.dynamicdatamapping.model.DDMTemplate;
import com.liferay.portlet.dynamicdatamapping.model.DDMTemplateConstants;
import com.liferay.portlet.dynamicdatamapping.service.DDMStructureLocalServiceUtil;
import com.liferay.portlet.dynamicdatamapping.util.BaseDDMDisplay;
import fr.lagab.portlet.publication.model.Publication;
import fr.lagab.portlet.publication.web.util.PortletKeys;
import fr.lagab.portlet.publication.web.util.PublicationPermission;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;



/**
 * @author lagab
 * @since  21/10/15.
 */
public class PublicationDDMDisplay extends BaseDDMDisplay {

    @Override
    public String getAvailableFields() {
        return "Liferay.FormBuilder.AVAILABLE_FIELDS.WCM_STRUCTURE";
    }


    @Override
    public String getEditTemplateBackURL(
            LiferayPortletRequest liferayPortletRequest,
            LiferayPortletResponse liferayPortletResponse, long classNameId,
            long classPK, String portletResource)
            throws Exception {

        String redirect = ParamUtil.getString(
                liferayPortletRequest, "redirect");

        if (Validator.isNull(redirect)) {
            return getViewTemplatesURL(
                    liferayPortletRequest, liferayPortletResponse, classNameId,
                    classPK);
        }

        return redirect;
    }

    @Override
    public String getPortletId() {
        return PortletKeys.PUBLICATION_PORTLET;
    }

    @Override
    public String getResourceName() {
        return PublicationPermission.RESOURCE_NAME;
    }

    @Override
    public String getStorageType() {
        return "xml";
    }

    @Override
    public String getStructureType() {
        return Publication.class.getName();
    }

    @Override
    public long getTemplateHandlerClassNameId(
            DDMTemplate template, long classNameId) {
        return PortalUtil.getClassNameId(Publication.class);
    }

    @Override
    public Set<String> getTemplateLanguageTypes() {
        return _templateLanguageTypes;
    }


    @Override
    public String getTemplateType() {
        return DDMTemplateConstants.TEMPLATE_TYPE_DISPLAY;
    }

    @Override
    public String getViewTemplatesBackURL(
            LiferayPortletRequest liferayPortletRequest,
            LiferayPortletResponse liferayPortletResponse, long classPK)
            throws Exception {

        if (classPK <= 0) {
            return StringPool.BLANK;
        }

        return super.getViewTemplatesBackURL(
                liferayPortletRequest, liferayPortletResponse, classPK);
    }

    @Override
    public Set<String> getViewTemplatesExcludedColumnNames() {
        return _viewTemplateExcludedColumnNames;
    }

    @Override
    public boolean isShowStructureSelector() {
        return true;
    }

    private static Set<String> _templateLanguageTypes =
            SetUtil.fromArray(
                    new String[] {
                            TemplateConstants.LANG_TYPE_FTL, TemplateConstants.LANG_TYPE_VM,
                            TemplateConstants.LANG_TYPE_XSL
                    });
    private static Set<String> _viewTemplateExcludedColumnNames =
            SetUtil.fromArray(new String[] {"mode"});

    @Override
    public long[] getTemplateClassPKs(
            long companyId, long classNameId, long classPK)
            throws Exception {


        if (classPK > 0) {
            return new long[] {classPK};
        }

        List<Long> classPKs = new ArrayList<Long>();

        classPKs.add(0L);

        List<DDMStructure> structures =
                DDMStructureLocalServiceUtil.getClassStructures(
                        companyId, PortalUtil.getClassNameId(getStructureType()));

        for (DDMStructure structure : structures) {
            classPKs.add(structure.getPrimaryKey());
        }


        return ArrayUtil.toLongArray(classPKs);
    }
}
