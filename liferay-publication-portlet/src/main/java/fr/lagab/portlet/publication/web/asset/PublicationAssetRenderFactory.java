package fr.lagab.portlet.publication.web.asset;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Tuple;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.model.AssetRenderer;
import com.liferay.portlet.asset.model.BaseAssetRendererFactory;
import com.liferay.portlet.dynamicdatamapping.model.DDMStructure;
import com.liferay.portlet.dynamicdatamapping.service.DDMStructureLocalServiceUtil;
import fr.lagab.portlet.publication.model.Publication;
import fr.lagab.portlet.publication.service.PublicationLocalServiceUtil;
import fr.lagab.portlet.publication.web.util.PortletKeys;
import fr.lagab.portlet.publication.web.util.PublicationPermission;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

/**
 * @author lagab
 * @since  21/10/15.
 */
public class PublicationAssetRenderFactory extends BaseAssetRendererFactory{

    public static final String CLASS_NAME = Publication.class.getName();
    public static final String TYPE = "publication";

    @Override
    public AssetRenderer getAssetRenderer(long classPK) throws PortalException,
            SystemException {
        Publication publication = PublicationLocalServiceUtil.getPublication(classPK);

        return new PublicationAssetRenderer(publication);
    }

    @Override
    public AssetRenderer getAssetRenderer(long classPK, int type)
            throws PortalException, SystemException {
        Publication publication = PublicationLocalServiceUtil.getPublication(classPK);
        return new PublicationAssetRenderer(publication);

    }

    @Override
    public String getClassName() {
        return CLASS_NAME;
    }

    @Override
    public String getType() {
        return TYPE;
    }
    @Override
    public String getTypeName(Locale locale, boolean hasSubtypes) {

        if(hasSubtypes){
            return LanguageUtil.get(locale, "basic-post");
        }

        return super.getTypeName(locale, false);
    }

    @Override
    public PortletURL getURLAdd(
            LiferayPortletRequest liferayPortletRequest,
            LiferayPortletResponse liferayPortletResponse)
            throws PortalException, SystemException {

        ThemeDisplay themeDisplay =
                (ThemeDisplay)liferayPortletRequest.getAttribute(
                        com.liferay.portal.kernel.util.WebKeys.THEME_DISPLAY);

        if (!PublicationPermission.contains(
                themeDisplay.getPermissionChecker(), themeDisplay.getScopeGroupId(), ActionKeys.ADD_ENTRY)) {

            return null;
        }

        PortletURL portletURL = PortalUtil.getControlPanelPortletURL(
                liferayPortletRequest, PortletKeys.PUBLICATION_PORTLET, 0,
                PortletRequest.RENDER_PHASE);

        //PortletURL portletURL = liferayPortletResponse.createRenderURL(PortletKeys.PUBLICATION_PORTLET);
        portletURL.setParameter("jspPage", "/html/publication/admin/edit_publication.jsp");
        if(liferayPortletRequest.getPreferences().getValue("queryName0","").equals("assetCategories")){
            portletURL.setParameter("cats_selected", StringUtil.merge(
                    liferayPortletRequest.getPreferences().getValues("queryValues0",StringPool.EMPTY_ARRAY),
                    StringPool.COMMA));
        }
        System.out.println(portletURL.toString());

        return portletURL;
    }


    @Override
    public int getClassTypeFieldNamesCount(long classTypeId, Locale locale) throws Exception {

        DDMStructure ddmStructure =	DDMStructureLocalServiceUtil.getDDMStructure(classTypeId);

        List<Tuple> fieldNames = getDDMStructureFieldNames(ddmStructure, locale);
        return fieldNames.size();
    }

    @Override
    public Map<Long, String> getClassTypes(long[] groupIds, Locale locale)
            throws Exception {

        Map<Long, String> classTypes = new HashMap<Long, String>();

        for (long groupId : groupIds) {
            List<DDMStructure> ddmStructures =
                    DDMStructureLocalServiceUtil.getStructures(groupId,
                            PortalUtil.getClassNameId(Publication.class.getName()));

            for (DDMStructure ddmStructure : ddmStructures) {
                classTypes.put(ddmStructure.getStructureId(),ddmStructure.getName(locale));
            }
        }

        return classTypes;
    }

    @Override
    public List<Tuple> getClassTypeFieldNames(long classTypeId, Locale locale, int start, int end) throws Exception {

        DDMStructure ddmStructure = DDMStructureLocalServiceUtil.getDDMStructure(classTypeId);

        List<Tuple> fieldNames = getDDMStructureFieldNames(ddmStructure, locale);

        return ListUtil.subList(fieldNames, start, end);
    }


    /*public boolean hasViewPermission(PermissionChecker permissionChecker)	throws PortalException, SystemException {
        //TODO
        return true;
    }*/

    @Override
    public boolean hasPermission(PermissionChecker permissionChecker,
                                 long classPK, String actionId) throws Exception {
        return super.hasPermission(permissionChecker, classPK, actionId);
    }
    @Override
    public boolean isLinkable() {
        return _LINKABLE;
    }

    @Override
    protected String getIconPath(ThemeDisplay themeDisplay) {
        return themeDisplay.getPathThemeImages() + "/common/history.png";
    }

    private static final boolean _LINKABLE = true;
}
