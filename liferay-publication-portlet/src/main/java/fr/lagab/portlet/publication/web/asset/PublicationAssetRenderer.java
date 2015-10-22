package fr.lagab.portlet.publication.web.asset;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.trash.TrashRenderer;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portlet.asset.model.BaseAssetRenderer;
import fr.lagab.portlet.publication.model.Publication;
import fr.lagab.portlet.publication.web.util.PortletKeys;
import fr.lagab.portlet.publication.web.util.PublicationPermission;

import java.util.Date;
import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.WindowState;

/**
 * @author lagab
 * @since  21/10/15.
 */
public class PublicationAssetRenderer  extends BaseAssetRenderer implements TrashRenderer{

    private Publication _publication;

    public static long getClassPK(Publication publication) {

        return publication.getPrimaryKey();

    }

    public PublicationAssetRenderer(Publication publication){
        _publication = publication;
    }

    public String render(RenderRequest renderRequest,
                         RenderResponse renderResponse, String template) throws Exception {

        if (template.equals(TEMPLATE_FULL_CONTENT) || template.equals(TEMPLATE_ABSTRACT) ) {
            return "/html/publication/asset/" + template + ".jsp";
        }
        else{
            return null;
        }

    }

    @Override
    public String getClassName() {
        return Publication.class.getName();
    }

    @Override
    public long getClassPK() {
        return getClassPK(_publication);
    }

    @Override
    public long getGroupId() {
        return _publication.getGroupId();
    }

    @Override
    public String getSummary(Locale locale) {
        String content = _publication.getDescription();
        return content.replaceAll("(\r\n|\n)", "<br />");
    }

    @Override
    public String getTitle(Locale locale) {
        if(_publication.getTitle().equals("")){
            return "Publication sans titre";
        }
        return _publication.getTitle();
    }

    @Override
    public long getUserId() {
        return _publication.getUserId();
    }

    @Override
    public String getUserName() {
        return _publication.getUserName();
    }

    @Override
    public String getUuid() {
        return _publication.getUuid();
    }

    @Override
    public boolean hasViewPermission(PermissionChecker permissionChecker) throws PortalException, SystemException {
        return PublicationPermission.contains(permissionChecker,_publication, ActionKeys.VIEW);
    }

    @Override
    public String getViewInContextMessage() {
        return "view";
    }

    @Override
    public String getDiscussionPath() {
        return "edit_publication_discussion";
    }

    public Publication getPublication(){
        return _publication;
    }

    @Override
    public Date getDisplayDate() {
        return _publication.getCreateDate();
    }

    public String getType() {
        return PublicationAssetRenderFactory.TYPE;
    }
    @Override
    public boolean hasEditPermission(PermissionChecker permissionChecker) throws PortalException, SystemException {

        return PublicationPermission.contains(permissionChecker, _publication, ActionKeys.UPDATE);
    }

    public boolean hasDeletePermission(PermissionChecker permissionChecker) {
        return PublicationPermission.contains(permissionChecker, _publication, ActionKeys.DELETE);
    }

    @Override
    public PortletURL getURLEdit(LiferayPortletRequest liferayPortletRequest,
                                 LiferayPortletResponse liferayPortletResponse) throws Exception {

        PortletURL portletURL = liferayPortletResponse.createLiferayPortletURL(
                getControlPanelPlid(liferayPortletRequest), PortletKeys.PUBLICATION_PORTLET,
                PortletRequest.RENDER_PHASE);

        portletURL.setParameter("mvcPath", "/html/admin/edit_publication.jsp");
        portletURL.setParameter("entryId", String.valueOf(_publication.getId()));

        return portletURL;
    }

    @Override
    public PortletURL getURLView(LiferayPortletResponse liferayPortletResponse,
            WindowState windowState) throws Exception {
        PortletURL urlView = super.getURLView(liferayPortletResponse, windowState);
        //urlView.setWindowState(WindowState.MAXIMIZED);
        return urlView;
    }
    @Override
    public String getURLViewInContext(
            LiferayPortletRequest liferayPortletRequest,
            LiferayPortletResponse liferayPortletResponse,
            String noSuchEntryRedirect) throws Exception {

        return getURLViewInContext(
                liferayPortletRequest, noSuchEntryRedirect, "/blogs/find_entry",
                "entryId", _publication.getId());

        //return super.getURLViewInContext(liferayPortletRequest, liferayPortletResponse,noSuchEntryRedirect);
    }

    @Override
    public String getPortletId() {
        return PortletKeys.PUBLICATION_PORTLET;
    }

    @Override
    public boolean isConvertible() {
        return true;
    }

    @Override
    public boolean isDisplayable() {
        return true;
    }
}
