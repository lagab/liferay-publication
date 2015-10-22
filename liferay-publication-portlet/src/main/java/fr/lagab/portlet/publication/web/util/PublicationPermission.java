package fr.lagab.portlet.publication.web.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.staging.permission.StagingPermissionUtil;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;
import fr.lagab.portlet.publication.model.Publication;

/**
 * @author lagab
 * @since  21/10/15.
 */
public class PublicationPermission {
    public static final String RESOURCE_NAME = "fr.lagab.portlet.publication.model.Publication";

    public static void check(
            PermissionChecker permissionChecker, long groupId, String actionId)
            throws PortalException {

        if (!contains(permissionChecker, groupId, actionId)) {
            throw new PrincipalException();
        }
    }

    public static boolean contains(
            PermissionChecker permissionChecker, long groupId, String actionId) {

        Boolean hasPermission = StagingPermissionUtil.hasPermission(
                permissionChecker, groupId, RESOURCE_NAME, groupId,
                PortletKeys.PUBLICATION_PORTLET, actionId);

        if (hasPermission != null) {
            return hasPermission.booleanValue();
        }

        return permissionChecker.hasPermission(
                groupId, RESOURCE_NAME, groupId, actionId);
    }

    public static boolean contains(PermissionChecker permissionChecker, Publication publication, String actionId) {
        Boolean hasPermission = permissionChecker.hasPermission(
                publication.getGroupId(), Publication.class.getName(), publication.getId(),
                actionId);

        if (permissionChecker.hasOwnerPermission(
                publication.getCompanyId(), Publication.class.getName(),
                publication.getId(), publication.getUserId(), actionId)) {
            return true;
        }

        return hasPermission;
    }
}
