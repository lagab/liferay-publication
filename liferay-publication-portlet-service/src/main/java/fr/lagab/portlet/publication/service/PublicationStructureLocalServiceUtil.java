package fr.lagab.portlet.publication.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for PublicationStructure. This utility wraps
 * {@link fr.lagab.portlet.publication.service.impl.PublicationStructureLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see PublicationStructureLocalService
 * @see fr.lagab.portlet.publication.service.base.PublicationStructureLocalServiceBaseImpl
 * @see fr.lagab.portlet.publication.service.impl.PublicationStructureLocalServiceImpl
 * @generated
 */
public class PublicationStructureLocalServiceUtil {
    private static PublicationStructureLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link fr.lagab.portlet.publication.service.impl.PublicationStructureLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

    public static void clearService() {
        _service = null;
    }

    public static PublicationStructureLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    PublicationStructureLocalService.class.getName());

            if (invokableLocalService instanceof PublicationStructureLocalService) {
                _service = (PublicationStructureLocalService) invokableLocalService;
            } else {
                _service = new PublicationStructureLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(PublicationStructureLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(PublicationStructureLocalService service) {
    }
}
