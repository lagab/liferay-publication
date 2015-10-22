package fr.lagab.portlet.publication.web.template;

import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.mobile.device.Device;
import com.liferay.portal.kernel.template.BaseTemplateHandler;
import com.liferay.portal.kernel.template.TemplateVariableCodeHandler;
import com.liferay.portal.kernel.template.TemplateVariableGroup;
import com.liferay.portal.kernel.templateparser.TemplateNode;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.Company;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.dynamicdatamapping.model.DDMStructure;
import com.liferay.portlet.dynamicdatamapping.service.DDMStructureLocalServiceUtil;
import fr.lagab.portlet.publication.model.Publication;
import fr.lagab.portlet.publication.web.util.PortletKeys;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * @author lagab
 * @since  21/10/15.
 */
public class PublicationTemplateHandler extends BaseTemplateHandler {

    @Override
    public String getClassName() {
        return Publication.class.getName();
    }

    @Override
    public String getName(Locale locale) {
        String portletTitle = PortalUtil.getPortletTitle(PortletKeys.PUBLICATION_PORTLET, locale);

        return portletTitle.concat(StringPool.SPACE).concat(LanguageUtil.get(locale, "template"));
    }

    @Override
    public String getResourceName() {
        return "fr.lagab.portlet.publication.web.template";
    }

    @Override
    public Map<String, TemplateVariableGroup> getTemplateVariableGroups(
            long classPK, String language, Locale locale) throws Exception {
        Map<String, TemplateVariableGroup> templateVariableGroups = new LinkedHashMap<String, TemplateVariableGroup>();

        //General Varibales
        TemplateVariableGroup templateVariableGroup = new TemplateVariableGroup("general-variables");

        templateVariableGroup.addVariable("portal-instance", Company.class, "company");
        templateVariableGroup.addVariable("portal-instance-id", null, "companyId");
        templateVariableGroup.addVariable("device", Device.class, "device");
        templateVariableGroup.addVariable("site-id", null, "groupId");
        templateVariableGroup.addVariable("view-mode", String.class, "viewMode");
        templateVariableGroups.put(templateVariableGroup.getLabel(), templateVariableGroup);

        //Structure variables
        if ( classPK > 0 ) {
            templateVariableGroup = new TemplateVariableGroup("fields");

            DDMStructure ddmStructure = DDMStructureLocalServiceUtil.getStructure(classPK);

            List<String> fieldNames = ddmStructure.getRootFieldNames();

            for (String fieldName : fieldNames) {
                if (fieldName.startsWith(StringPool.UNDERLINE)) {
                    continue;
                }

                String label = ddmStructure.getFieldLabel(fieldName, locale);
                String tip = ddmStructure.getFieldTip(fieldName, locale);
                String dataType = ddmStructure.getFieldDataType(fieldName);
                boolean repeatable = ddmStructure.getFieldRepeatable(fieldName);

                templateVariableGroup.addFieldVariable(
                        label, getFieldVariableClass(), fieldName, tip, dataType,
                        repeatable, getTemplateVariableCodeHandler());
            }

            templateVariableGroups.put(templateVariableGroup.getLabel(), templateVariableGroup);
        }

        //Utilities Variables
        templateVariableGroup = new TemplateVariableGroup("util");

        templateVariableGroup.addVariable("permission-checker", PermissionChecker.class, "permissionChecker");
        templateVariableGroup.addVariable("random-namespace", String.class, "randomNamespace");
        templateVariableGroup.addVariable("templates-path", String.class, "templatesPath");

        templateVariableGroups.put(templateVariableGroup.getLabel(), templateVariableGroup);



        return templateVariableGroups;
    }

    protected Class<?> getFieldVariableClass() {
        return TemplateNode.class;
    }

    protected TemplateVariableCodeHandler getTemplateVariableCodeHandler() {
        return _templateVariableCodeHandler;
    }

    private TemplateVariableCodeHandler _templateVariableCodeHandler =
            new DDMTemplateVariableCodeHandler("fr/lagab/publication/web/dependencies/template/");

}
