package fr.lagab.portlet.publication.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PublicationTemplateService}.
 *
 * @author Brian Wing Shun Chan
 * @see PublicationTemplateService
 * @generated
 */
public class PublicationTemplateServiceWrapper
    implements PublicationTemplateService,
        ServiceWrapper<PublicationTemplateService> {
    private PublicationTemplateService _publicationTemplateService;

    public PublicationTemplateServiceWrapper(
        PublicationTemplateService publicationTemplateService) {
        _publicationTemplateService = publicationTemplateService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _publicationTemplateService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _publicationTemplateService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _publicationTemplateService.invokeMethod(name, parameterTypes,
            arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public PublicationTemplateService getWrappedPublicationTemplateService() {
        return _publicationTemplateService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedPublicationTemplateService(
        PublicationTemplateService publicationTemplateService) {
        _publicationTemplateService = publicationTemplateService;
    }

    @Override
    public PublicationTemplateService getWrappedService() {
        return _publicationTemplateService;
    }

    @Override
    public void setWrappedService(
        PublicationTemplateService publicationTemplateService) {
        _publicationTemplateService = publicationTemplateService;
    }
}
