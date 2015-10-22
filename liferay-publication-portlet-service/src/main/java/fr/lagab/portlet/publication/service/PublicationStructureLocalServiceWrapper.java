package fr.lagab.portlet.publication.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PublicationStructureLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PublicationStructureLocalService
 * @generated
 */
public class PublicationStructureLocalServiceWrapper
    implements PublicationStructureLocalService,
        ServiceWrapper<PublicationStructureLocalService> {
    private PublicationStructureLocalService _publicationStructureLocalService;

    public PublicationStructureLocalServiceWrapper(
        PublicationStructureLocalService publicationStructureLocalService) {
        _publicationStructureLocalService = publicationStructureLocalService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _publicationStructureLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _publicationStructureLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _publicationStructureLocalService.invokeMethod(name,
            parameterTypes, arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public PublicationStructureLocalService getWrappedPublicationStructureLocalService() {
        return _publicationStructureLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedPublicationStructureLocalService(
        PublicationStructureLocalService publicationStructureLocalService) {
        _publicationStructureLocalService = publicationStructureLocalService;
    }

    @Override
    public PublicationStructureLocalService getWrappedService() {
        return _publicationStructureLocalService;
    }

    @Override
    public void setWrappedService(
        PublicationStructureLocalService publicationStructureLocalService) {
        _publicationStructureLocalService = publicationStructureLocalService;
    }
}
