package fr.lagab.portlet.publication.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PublicationTemplateLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PublicationTemplateLocalService
 * @generated
 */
public class PublicationTemplateLocalServiceWrapper
    implements PublicationTemplateLocalService,
        ServiceWrapper<PublicationTemplateLocalService> {
    private PublicationTemplateLocalService _publicationTemplateLocalService;

    public PublicationTemplateLocalServiceWrapper(
        PublicationTemplateLocalService publicationTemplateLocalService) {
        _publicationTemplateLocalService = publicationTemplateLocalService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _publicationTemplateLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _publicationTemplateLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _publicationTemplateLocalService.invokeMethod(name,
            parameterTypes, arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public PublicationTemplateLocalService getWrappedPublicationTemplateLocalService() {
        return _publicationTemplateLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedPublicationTemplateLocalService(
        PublicationTemplateLocalService publicationTemplateLocalService) {
        _publicationTemplateLocalService = publicationTemplateLocalService;
    }

    @Override
    public PublicationTemplateLocalService getWrappedService() {
        return _publicationTemplateLocalService;
    }

    @Override
    public void setWrappedService(
        PublicationTemplateLocalService publicationTemplateLocalService) {
        _publicationTemplateLocalService = publicationTemplateLocalService;
    }
}
