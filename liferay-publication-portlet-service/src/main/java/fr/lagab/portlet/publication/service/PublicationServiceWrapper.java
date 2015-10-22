package fr.lagab.portlet.publication.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PublicationService}.
 *
 * @author Brian Wing Shun Chan
 * @see PublicationService
 * @generated
 */
public class PublicationServiceWrapper implements PublicationService,
    ServiceWrapper<PublicationService> {
    private PublicationService _publicationService;

    public PublicationServiceWrapper(PublicationService publicationService) {
        _publicationService = publicationService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _publicationService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _publicationService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _publicationService.invokeMethod(name, parameterTypes, arguments);
    }

    @Override
    public int countPublication(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _publicationService.countPublication(groupId);
    }

    @Override
    public int countAllPublication()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _publicationService.countAllPublication();
    }

    @Override
    public int countPublication(long groupId, long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _publicationService.countPublication(groupId, userId);
    }

    @Override
    public int countPublicationsByStructureId(long groupId, long structureId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _publicationService.countPublicationsByStructureId(groupId,
            structureId);
    }

    @Override
    public java.util.List<fr.lagab.portlet.publication.model.Publication> getAllPublications()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _publicationService.getAllPublications();
    }

    @Override
    public java.util.List<fr.lagab.portlet.publication.model.Publication> getAllPublications(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _publicationService.getAllPublications(start, end);
    }

    @Override
    public java.util.List<fr.lagab.portlet.publication.model.Publication> getAllPublications(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _publicationService.getAllPublications(start, end, obc);
    }

    @Override
    public java.util.List<fr.lagab.portlet.publication.model.Publication> getPublications(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _publicationService.getPublications(groupId);
    }

    @Override
    public java.util.List<fr.lagab.portlet.publication.model.Publication> getPublications(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _publicationService.getPublications(groupId, start, end);
    }

    @Override
    public java.util.List<fr.lagab.portlet.publication.model.Publication> getPublications(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _publicationService.getPublications(groupId, start, end, obc);
    }

    @Override
    public java.util.List<fr.lagab.portlet.publication.model.Publication> getUserPublications(
        long groupId, long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _publicationService.getUserPublications(groupId, userId);
    }

    @Override
    public java.util.List<fr.lagab.portlet.publication.model.Publication> getUserPublications(
        long groupId, long userId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _publicationService.getUserPublications(groupId, userId, start,
            end);
    }

    @Override
    public java.util.List<fr.lagab.portlet.publication.model.Publication> getUserPublications(
        long groupId, long userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _publicationService.getUserPublications(groupId, userId, start,
            end, obc);
    }

    @Override
    public fr.lagab.portlet.publication.model.Publication getPublication(
        long entryId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _publicationService.getPublication(entryId);
    }

    @Override
    public java.util.List<fr.lagab.portlet.publication.model.Publication> getPublicationsByStructureId(
        long groupId, long structureId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _publicationService.getPublicationsByStructureId(groupId,
            structureId);
    }

    @Override
    public java.util.List<fr.lagab.portlet.publication.model.Publication> getPublicationsByStructureId(
        long groupId, long structureId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _publicationService.getPublicationsByStructureId(groupId,
            structureId, start, end);
    }

    @Override
    public java.util.List<fr.lagab.portlet.publication.model.Publication> getPublicationsByStructureId(
        long groupId, long structureId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _publicationService.getPublicationsByStructureId(groupId,
            structureId, start, end, obc);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public PublicationService getWrappedPublicationService() {
        return _publicationService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedPublicationService(
        PublicationService publicationService) {
        _publicationService = publicationService;
    }

    @Override
    public PublicationService getWrappedService() {
        return _publicationService;
    }

    @Override
    public void setWrappedService(PublicationService publicationService) {
        _publicationService = publicationService;
    }
}
