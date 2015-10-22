package fr.lagab.portlet.publication.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Publication. This utility wraps
 * {@link fr.lagab.portlet.publication.service.impl.PublicationLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see PublicationLocalService
 * @see fr.lagab.portlet.publication.service.base.PublicationLocalServiceBaseImpl
 * @see fr.lagab.portlet.publication.service.impl.PublicationLocalServiceImpl
 * @generated
 */
public class PublicationLocalServiceUtil {
    private static PublicationLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link fr.lagab.portlet.publication.service.impl.PublicationLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the publication to the database. Also notifies the appropriate model listeners.
    *
    * @param publication the publication
    * @return the publication that was added
    * @throws SystemException if a system exception occurred
    */
    public static fr.lagab.portlet.publication.model.Publication addPublication(
        fr.lagab.portlet.publication.model.Publication publication)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addPublication(publication);
    }

    /**
    * Creates a new publication with the primary key. Does not add the publication to the database.
    *
    * @param id the primary key for the new publication
    * @return the new publication
    */
    public static fr.lagab.portlet.publication.model.Publication createPublication(
        long id) {
        return getService().createPublication(id);
    }

    /**
    * Deletes the publication with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the publication
    * @return the publication that was removed
    * @throws PortalException if a publication with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fr.lagab.portlet.publication.model.Publication deletePublication(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deletePublication(id);
    }

    /**
    * Deletes the publication from the database. Also notifies the appropriate model listeners.
    *
    * @param publication the publication
    * @return the publication that was removed
    * @throws SystemException if a system exception occurred
    */
    public static fr.lagab.portlet.publication.model.Publication deletePublication(
        fr.lagab.portlet.publication.model.Publication publication)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deletePublication(publication);
    }

    public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return getService().dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery);
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
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
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
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery, projection);
    }

    public static fr.lagab.portlet.publication.model.Publication fetchPublication(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchPublication(id);
    }

    /**
    * Returns the publication with the matching UUID and company.
    *
    * @param uuid the publication's UUID
    * @param companyId the primary key of the company
    * @return the matching publication, or <code>null</code> if a matching publication could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fr.lagab.portlet.publication.model.Publication fetchPublicationByUuidAndCompanyId(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchPublicationByUuidAndCompanyId(uuid, companyId);
    }

    /**
    * Returns the publication matching the UUID and group.
    *
    * @param uuid the publication's UUID
    * @param groupId the primary key of the group
    * @return the matching publication, or <code>null</code> if a matching publication could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fr.lagab.portlet.publication.model.Publication fetchPublicationByUuidAndGroupId(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchPublicationByUuidAndGroupId(uuid, groupId);
    }

    /**
    * Returns the publication with the primary key.
    *
    * @param id the primary key of the publication
    * @return the publication
    * @throws PortalException if a publication with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fr.lagab.portlet.publication.model.Publication getPublication(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPublication(id);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
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
    public static fr.lagab.portlet.publication.model.Publication getPublicationByUuidAndCompanyId(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPublicationByUuidAndCompanyId(uuid, companyId);
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
    public static fr.lagab.portlet.publication.model.Publication getPublicationByUuidAndGroupId(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPublicationByUuidAndGroupId(uuid, groupId);
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
    public static java.util.List<fr.lagab.portlet.publication.model.Publication> getPublications(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getPublications(start, end);
    }

    /**
    * Returns the number of publications.
    *
    * @return the number of publications
    * @throws SystemException if a system exception occurred
    */
    public static int getPublicationsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getPublicationsCount();
    }

    /**
    * Updates the publication in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param publication the publication
    * @return the publication that was updated
    * @throws SystemException if a system exception occurred
    */
    public static fr.lagab.portlet.publication.model.Publication updatePublication(
        fr.lagab.portlet.publication.model.Publication publication)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updatePublication(publication);
    }

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

    public static fr.lagab.portlet.publication.model.Publication addPublication(
        long companyId, long groupId, long userId, java.util.Date createDate,
        long folderId, java.lang.String title, java.lang.String content,
        java.lang.String description, long structureId, long templateId,
        int status, com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .addPublication(companyId, groupId, userId, createDate,
            folderId, title, content, description, structureId, templateId,
            status, serviceContext);
    }

    public static fr.lagab.portlet.publication.model.Publication updatePublication(
        long publicationId, long userId, java.lang.String title,
        java.lang.String description, java.lang.String content,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .updatePublication(publicationId, userId, title,
            description, content, serviceContext);
    }

    public static void updateAsset(long userId,
        fr.lagab.portlet.publication.model.Publication entry,
        long[] assetCategoryIds, java.lang.String[] assetTagNames)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        getService().updateAsset(userId, entry, assetCategoryIds, assetTagNames);
    }

    public static void addResources(
        fr.lagab.portlet.publication.model.Publication entry,
        boolean addGroupPermissions, boolean addGuestPermissions)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        getService()
            .addResources(entry, addGroupPermissions, addGuestPermissions);
    }

    public static void addResources(
        fr.lagab.portlet.publication.model.Publication entry,
        java.lang.String[] groupPermissions, java.lang.String[] guestPermissions)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        getService().addResources(entry, groupPermissions, guestPermissions);
    }

    public static void updateResources(
        fr.lagab.portlet.publication.model.Publication entry,
        java.lang.String[] groupPermissions, java.lang.String[] guestPermissions)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        getService().updateResources(entry, groupPermissions, guestPermissions);
    }

    public static void clearService() {
        _service = null;
    }

    public static PublicationLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    PublicationLocalService.class.getName());

            if (invokableLocalService instanceof PublicationLocalService) {
                _service = (PublicationLocalService) invokableLocalService;
            } else {
                _service = new PublicationLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(PublicationLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(PublicationLocalService service) {
    }
}
