package fr.lagab.portlet.publication.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PublicationLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PublicationLocalService
 * @generated
 */
public class PublicationLocalServiceWrapper implements PublicationLocalService,
    ServiceWrapper<PublicationLocalService> {
    private PublicationLocalService _publicationLocalService;

    public PublicationLocalServiceWrapper(
        PublicationLocalService publicationLocalService) {
        _publicationLocalService = publicationLocalService;
    }

    /**
    * Adds the publication to the database. Also notifies the appropriate model listeners.
    *
    * @param publication the publication
    * @return the publication that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public fr.lagab.portlet.publication.model.Publication addPublication(
        fr.lagab.portlet.publication.model.Publication publication)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _publicationLocalService.addPublication(publication);
    }

    /**
    * Creates a new publication with the primary key. Does not add the publication to the database.
    *
    * @param id the primary key for the new publication
    * @return the new publication
    */
    @Override
    public fr.lagab.portlet.publication.model.Publication createPublication(
        long id) {
        return _publicationLocalService.createPublication(id);
    }

    /**
    * Deletes the publication with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the publication
    * @return the publication that was removed
    * @throws PortalException if a publication with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public fr.lagab.portlet.publication.model.Publication deletePublication(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _publicationLocalService.deletePublication(id);
    }

    /**
    * Deletes the publication from the database. Also notifies the appropriate model listeners.
    *
    * @param publication the publication
    * @return the publication that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public fr.lagab.portlet.publication.model.Publication deletePublication(
        fr.lagab.portlet.publication.model.Publication publication)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _publicationLocalService.deletePublication(publication);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _publicationLocalService.dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _publicationLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fr.lagab.portlet.publication.model.impl.PublicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _publicationLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fr.lagab.portlet.publication.model.impl.PublicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _publicationLocalService.dynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _publicationLocalService.dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _publicationLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public fr.lagab.portlet.publication.model.Publication fetchPublication(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return _publicationLocalService.fetchPublication(id);
    }

    /**
    * Returns the publication with the matching UUID and company.
    *
    * @param uuid the publication's UUID
    * @param companyId the primary key of the company
    * @return the matching publication, or <code>null</code> if a matching publication could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public fr.lagab.portlet.publication.model.Publication fetchPublicationByUuidAndCompanyId(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _publicationLocalService.fetchPublicationByUuidAndCompanyId(uuid,
            companyId);
    }

    /**
    * Returns the publication matching the UUID and group.
    *
    * @param uuid the publication's UUID
    * @param groupId the primary key of the group
    * @return the matching publication, or <code>null</code> if a matching publication could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public fr.lagab.portlet.publication.model.Publication fetchPublicationByUuidAndGroupId(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _publicationLocalService.fetchPublicationByUuidAndGroupId(uuid,
            groupId);
    }

    /**
    * Returns the publication with the primary key.
    *
    * @param id the primary key of the publication
    * @return the publication
    * @throws PortalException if a publication with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public fr.lagab.portlet.publication.model.Publication getPublication(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _publicationLocalService.getPublication(id);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _publicationLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns the publication with the matching UUID and company.
    *
    * @param uuid the publication's UUID
    * @param companyId the primary key of the company
    * @return the matching publication
    * @throws PortalException if a matching publication could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public fr.lagab.portlet.publication.model.Publication getPublicationByUuidAndCompanyId(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _publicationLocalService.getPublicationByUuidAndCompanyId(uuid,
            companyId);
    }

    /**
    * Returns the publication matching the UUID and group.
    *
    * @param uuid the publication's UUID
    * @param groupId the primary key of the group
    * @return the matching publication
    * @throws PortalException if a matching publication could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public fr.lagab.portlet.publication.model.Publication getPublicationByUuidAndGroupId(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _publicationLocalService.getPublicationByUuidAndGroupId(uuid,
            groupId);
    }

    /**
    * Returns a range of all the publications.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fr.lagab.portlet.publication.model.impl.PublicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of publications
    * @param end the upper bound of the range of publications (not inclusive)
    * @return the range of publications
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<fr.lagab.portlet.publication.model.Publication> getPublications(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _publicationLocalService.getPublications(start, end);
    }

    /**
    * Returns the number of publications.
    *
    * @return the number of publications
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getPublicationsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _publicationLocalService.getPublicationsCount();
    }

    /**
    * Updates the publication in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param publication the publication
    * @return the publication that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public fr.lagab.portlet.publication.model.Publication updatePublication(
        fr.lagab.portlet.publication.model.Publication publication)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _publicationLocalService.updatePublication(publication);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _publicationLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _publicationLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _publicationLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    @Override
    public fr.lagab.portlet.publication.model.Publication addPublication(
        long companyId, long groupId, long userId, java.util.Date createDate,
        long folderId, java.lang.String title, java.lang.String content,
        java.lang.String description, long structureId, long templateId,
        int status, com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _publicationLocalService.addPublication(companyId, groupId,
            userId, createDate, folderId, title, content, description,
            structureId, templateId, status, serviceContext);
    }

    @Override
    public fr.lagab.portlet.publication.model.Publication updatePublication(
        long publicationId, long userId, java.lang.String title,
        java.lang.String description, java.lang.String content,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _publicationLocalService.updatePublication(publicationId,
            userId, title, description, content, serviceContext);
    }

    @Override
    public void updateAsset(long userId,
        fr.lagab.portlet.publication.model.Publication entry,
        long[] assetCategoryIds, java.lang.String[] assetTagNames)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        _publicationLocalService.updateAsset(userId, entry, assetCategoryIds,
            assetTagNames);
    }

    @Override
    public void addResources(
        fr.lagab.portlet.publication.model.Publication entry,
        boolean addGroupPermissions, boolean addGuestPermissions)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        _publicationLocalService.addResources(entry, addGroupPermissions,
            addGuestPermissions);
    }

    @Override
    public void addResources(
        fr.lagab.portlet.publication.model.Publication entry,
        java.lang.String[] groupPermissions, java.lang.String[] guestPermissions)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        _publicationLocalService.addResources(entry, groupPermissions,
            guestPermissions);
    }

    @Override
    public void updateResources(
        fr.lagab.portlet.publication.model.Publication entry,
        java.lang.String[] groupPermissions, java.lang.String[] guestPermissions)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        _publicationLocalService.updateResources(entry, groupPermissions,
            guestPermissions);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public PublicationLocalService getWrappedPublicationLocalService() {
        return _publicationLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedPublicationLocalService(
        PublicationLocalService publicationLocalService) {
        _publicationLocalService = publicationLocalService;
    }

    @Override
    public PublicationLocalService getWrappedService() {
        return _publicationLocalService;
    }

    @Override
    public void setWrappedService(
        PublicationLocalService publicationLocalService) {
        _publicationLocalService = publicationLocalService;
    }
}
