package fr.lagab.portlet.publication.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PublicationStructureService}.
 *
 * @author Brian Wing Shun Chan
 * @see PublicationStructureService
 * @generated
 */
public class PublicationStructureServiceWrapper
    implements PublicationStructureService,
        ServiceWrapper<PublicationStructureService> {
    private PublicationStructureService _publicationStructureService;

    public PublicationStructureServiceWrapper(
        PublicationStructureService publicationStructureService) {
        _publicationStructureService = publicationStructureService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _publicationStructureService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _publicationStructureService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _publicationStructureService.invokeMethod(name, parameterTypes,
            arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public PublicationStructureService getWrappedPublicationStructureService() {
        return _publicationStructureService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedPublicationStructureService(
        PublicationStructureService publicationStructureService) {
        _publicationStructureService = publicationStructureService;
    }

    @Override
    public PublicationStructureService getWrappedService() {
        return _publicationStructureService;
    }

    @Override
    public void setWrappedService(
        PublicationStructureService publicationStructureService) {
        _publicationStructureService = publicationStructureService;
    }
}
