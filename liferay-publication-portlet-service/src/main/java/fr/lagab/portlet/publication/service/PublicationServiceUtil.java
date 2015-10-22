package fr.lagab.portlet.publication.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for Publication. This utility wraps
 * {@link fr.lagab.portlet.publication.service.impl.PublicationServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see PublicationService
 * @see fr.lagab.portlet.publication.service.base.PublicationServiceBaseImpl
 * @see fr.lagab.portlet.publication.service.impl.PublicationServiceImpl
 * @generated
 */
public class PublicationServiceUtil {
    private static PublicationService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link fr.lagab.portlet.publication.service.impl.PublicationServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public static java.lang.String getBeanIdentifier() {
        return getService().getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public static void setBeanIdentifier(java.lang.String beanIdentifier) {
        getService().setBeanIdentifier(beanIdentifier);
    }

    public static java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return getService().invokeMethod(name, parameterTypes, arguments);
    }

    public static int countPublication(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().countPublication(groupId);
    }

    public static int countAllPublication()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().countAllPublication();
    }

    public static int countPublication(long groupId, long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().countPublication(groupId, userId);
    }

    public static int countPublicationsByStructureId(long groupId,
        long structureId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().countPublicationsByStructureId(groupId, structureId);
    }

    public static java.util.List<fr.lagab.portlet.publication.model.Publication> getAllPublications()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getAllPublications();
    }

    public static java.util.List<fr.lagab.portlet.publication.model.Publication> getAllPublications(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getAllPublications(start, end);
    }

    public static java.util.List<fr.lagab.portlet.publication.model.Publication> getAllPublications(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getAllPublications(start, end, obc);
    }

    public static java.util.List<fr.lagab.portlet.publication.model.Publication> getPublications(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getPublications(groupId);
    }

    public static java.util.List<fr.lagab.portlet.publication.model.Publication> getPublications(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getPublications(groupId, start, end);
    }

    public static java.util.List<fr.lagab.portlet.publication.model.Publication> getPublications(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getPublications(groupId, start, end, obc);
    }

    public static java.util.List<fr.lagab.portlet.publication.model.Publication> getUserPublications(
        long groupId, long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getUserPublications(groupId, userId);
    }

    public static java.util.List<fr.lagab.portlet.publication.model.Publication> getUserPublications(
        long groupId, long userId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getUserPublications(groupId, userId, start, end);
    }

    public static java.util.List<fr.lagab.portlet.publication.model.Publication> getUserPublications(
        long groupId, long userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getUserPublications(groupId, userId, start, end, obc);
    }

    public static fr.lagab.portlet.publication.model.Publication getPublication(
        long entryId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getPublication(entryId);
    }

    public static java.util.List<fr.lagab.portlet.publication.model.Publication> getPublicationsByStructureId(
        long groupId, long structureId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getPublicationsByStructureId(groupId, structureId);
    }

    public static java.util.List<fr.lagab.portlet.publication.model.Publication> getPublicationsByStructureId(
        long groupId, long structureId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .getPublicationsByStructureId(groupId, structureId, start,
            end);
    }

    public static java.util.List<fr.lagab.portlet.publication.model.Publication> getPublicationsByStructureId(
        long groupId, long structureId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .getPublicationsByStructureId(groupId, structureId, start,
            end, obc);
    }

    public static void clearService() {
        _service = null;
    }

    public static PublicationService getService() {
        if (_service == null) {
            InvokableService invokableService = (InvokableService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    PublicationService.class.getName());

            if (invokableService instanceof PublicationService) {
                _service = (PublicationService) invokableService;
            } else {
                _service = new PublicationServiceClp(invokableService);
            }

            ReferenceRegistry.registerReference(PublicationServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(PublicationService service) {
    }
}
