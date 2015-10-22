package fr.lagab.portlet.publication.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import fr.lagab.portlet.publication.model.Publication;

import java.util.List;

/**
 * The persistence utility for the publication service. This utility wraps {@link PublicationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PublicationPersistence
 * @see PublicationPersistenceImpl
 * @generated
 */
public class PublicationUtil {
    private static PublicationPersistence _persistence;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(Publication publication) {
        getPersistence().clearCache(publication);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<Publication> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Publication> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Publication> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static Publication update(Publication publication)
        throws SystemException {
        return getPersistence().update(publication);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static Publication update(Publication publication,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(publication, serviceContext);
    }

    /**
    * Returns all the publications where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the matching publications
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<fr.lagab.portlet.publication.model.Publication> findByUuid(
        java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid);
    }

    /**
    * Returns a range of all the publications where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fr.lagab.portlet.publication.model.impl.PublicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param start the lower bound of the range of publications
    * @param end the upper bound of the range of publications (not inclusive)
    * @return the range of matching publications
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<fr.lagab.portlet.publication.model.Publication> findByUuid(
        java.lang.String uuid, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid, start, end);
    }

    /**
    * Returns an ordered range of all the publications where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fr.lagab.portlet.publication.model.impl.PublicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param start the lower bound of the range of publications
    * @param end the upper bound of the range of publications (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching publications
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<fr.lagab.portlet.publication.model.Publication> findByUuid(
        java.lang.String uuid, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid, start, end, orderByComparator);
    }

    /**
    * Returns the first publication in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching publication
    * @throws fr.lagab.portlet.publication.NoSuchPublicationException if a matching publication could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fr.lagab.portlet.publication.model.Publication findByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            fr.lagab.portlet.publication.NoSuchPublicationException {
        return getPersistence().findByUuid_First(uuid, orderByComparator);
    }

    /**
    * Returns the first publication in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching publication, or <code>null</code> if a matching publication could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fr.lagab.portlet.publication.model.Publication fetchByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUuid_First(uuid, orderByComparator);
    }

    /**
    * Returns the last publication in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching publication
    * @throws fr.lagab.portlet.publication.NoSuchPublicationException if a matching publication could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fr.lagab.portlet.publication.model.Publication findByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            fr.lagab.portlet.publication.NoSuchPublicationException {
        return getPersistence().findByUuid_Last(uuid, orderByComparator);
    }

    /**
    * Returns the last publication in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching publication, or <code>null</code> if a matching publication could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fr.lagab.portlet.publication.model.Publication fetchByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
    }

    /**
    * Returns the publications before and after the current publication in the ordered set where uuid = &#63;.
    *
    * @param id the primary key of the current publication
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next publication
    * @throws fr.lagab.portlet.publication.NoSuchPublicationException if a publication with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fr.lagab.portlet.publication.model.Publication[] findByUuid_PrevAndNext(
        long id, java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            fr.lagab.portlet.publication.NoSuchPublicationException {
        return getPersistence()
                   .findByUuid_PrevAndNext(id, uuid, orderByComparator);
    }

    /**
    * Removes all the publications where uuid = &#63; from the database.
    *
    * @param uuid the uuid
    * @throws SystemException if a system exception occurred
    */
    public static void removeByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByUuid(uuid);
    }

    /**
    * Returns the number of publications where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the number of matching publications
    * @throws SystemException if a system exception occurred
    */
    public static int countByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUuid(uuid);
    }

    /**
    * Returns the publication where uuid = &#63; and groupId = &#63; or throws a {@link fr.lagab.portlet.publication.NoSuchPublicationException} if it could not be found.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching publication
    * @throws fr.lagab.portlet.publication.NoSuchPublicationException if a matching publication could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fr.lagab.portlet.publication.model.Publication findByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException,
            fr.lagab.portlet.publication.NoSuchPublicationException {
        return getPersistence().findByUUID_G(uuid, groupId);
    }

    /**
    * Returns the publication where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching publication, or <code>null</code> if a matching publication could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fr.lagab.portlet.publication.model.Publication fetchByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUUID_G(uuid, groupId);
    }

    /**
    * Returns the publication where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching publication, or <code>null</code> if a matching publication could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fr.lagab.portlet.publication.model.Publication fetchByUUID_G(
        java.lang.String uuid, long groupId, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
    }

    /**
    * Removes the publication where uuid = &#63; and groupId = &#63; from the database.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the publication that was removed
    * @throws SystemException if a system exception occurred
    */
    public static fr.lagab.portlet.publication.model.Publication removeByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException,
            fr.lagab.portlet.publication.NoSuchPublicationException {
        return getPersistence().removeByUUID_G(uuid, groupId);
    }

    /**
    * Returns the number of publications where uuid = &#63; and groupId = &#63;.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the number of matching publications
    * @throws SystemException if a system exception occurred
    */
    public static int countByUUID_G(java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUUID_G(uuid, groupId);
    }

    /**
    * Returns all the publications where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the matching publications
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<fr.lagab.portlet.publication.model.Publication> findByUuid_C(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid_C(uuid, companyId);
    }

    /**
    * Returns a range of all the publications where uuid = &#63; and companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fr.lagab.portlet.publication.model.impl.PublicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param start the lower bound of the range of publications
    * @param end the upper bound of the range of publications (not inclusive)
    * @return the range of matching publications
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<fr.lagab.portlet.publication.model.Publication> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid_C(uuid, companyId, start, end);
    }

    /**
    * Returns an ordered range of all the publications where uuid = &#63; and companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fr.lagab.portlet.publication.model.impl.PublicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param start the lower bound of the range of publications
    * @param end the upper bound of the range of publications (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching publications
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<fr.lagab.portlet.publication.model.Publication> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
    }

    /**
    * Returns the first publication in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching publication
    * @throws fr.lagab.portlet.publication.NoSuchPublicationException if a matching publication could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fr.lagab.portlet.publication.model.Publication findByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            fr.lagab.portlet.publication.NoSuchPublicationException {
        return getPersistence()
                   .findByUuid_C_First(uuid, companyId, orderByComparator);
    }

    /**
    * Returns the first publication in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching publication, or <code>null</code> if a matching publication could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fr.lagab.portlet.publication.model.Publication fetchByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
    }

    /**
    * Returns the last publication in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching publication
    * @throws fr.lagab.portlet.publication.NoSuchPublicationException if a matching publication could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fr.lagab.portlet.publication.model.Publication findByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            fr.lagab.portlet.publication.NoSuchPublicationException {
        return getPersistence()
                   .findByUuid_C_Last(uuid, companyId, orderByComparator);
    }

    /**
    * Returns the last publication in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching publication, or <code>null</code> if a matching publication could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fr.lagab.portlet.publication.model.Publication fetchByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
    }

    /**
    * Returns the publications before and after the current publication in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param id the primary key of the current publication
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next publication
    * @throws fr.lagab.portlet.publication.NoSuchPublicationException if a publication with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fr.lagab.portlet.publication.model.Publication[] findByUuid_C_PrevAndNext(
        long id, java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            fr.lagab.portlet.publication.NoSuchPublicationException {
        return getPersistence()
                   .findByUuid_C_PrevAndNext(id, uuid, companyId,
            orderByComparator);
    }

    /**
    * Removes all the publications where uuid = &#63; and companyId = &#63; from the database.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByUuid_C(java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByUuid_C(uuid, companyId);
    }

    /**
    * Returns the number of publications where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the number of matching publications
    * @throws SystemException if a system exception occurred
    */
    public static int countByUuid_C(java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUuid_C(uuid, companyId);
    }

    /**
    * Returns all the publications where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the matching publications
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<fr.lagab.portlet.publication.model.Publication> findByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByGroupId(groupId);
    }

    /**
    * Returns a range of all the publications where groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fr.lagab.portlet.publication.model.impl.PublicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param start the lower bound of the range of publications
    * @param end the upper bound of the range of publications (not inclusive)
    * @return the range of matching publications
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<fr.lagab.portlet.publication.model.Publication> findByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByGroupId(groupId, start, end);
    }

    /**
    * Returns an ordered range of all the publications where groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fr.lagab.portlet.publication.model.impl.PublicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param start the lower bound of the range of publications
    * @param end the upper bound of the range of publications (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching publications
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<fr.lagab.portlet.publication.model.Publication> findByGroupId(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByGroupId(groupId, start, end, orderByComparator);
    }

    /**
    * Returns the first publication in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching publication
    * @throws fr.lagab.portlet.publication.NoSuchPublicationException if a matching publication could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fr.lagab.portlet.publication.model.Publication findByGroupId_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            fr.lagab.portlet.publication.NoSuchPublicationException {
        return getPersistence().findByGroupId_First(groupId, orderByComparator);
    }

    /**
    * Returns the first publication in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching publication, or <code>null</code> if a matching publication could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fr.lagab.portlet.publication.model.Publication fetchByGroupId_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
    }

    /**
    * Returns the last publication in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching publication
    * @throws fr.lagab.portlet.publication.NoSuchPublicationException if a matching publication could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fr.lagab.portlet.publication.model.Publication findByGroupId_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            fr.lagab.portlet.publication.NoSuchPublicationException {
        return getPersistence().findByGroupId_Last(groupId, orderByComparator);
    }

    /**
    * Returns the last publication in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching publication, or <code>null</code> if a matching publication could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fr.lagab.portlet.publication.model.Publication fetchByGroupId_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
    }

    /**
    * Returns the publications before and after the current publication in the ordered set where groupId = &#63;.
    *
    * @param id the primary key of the current publication
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next publication
    * @throws fr.lagab.portlet.publication.NoSuchPublicationException if a publication with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fr.lagab.portlet.publication.model.Publication[] findByGroupId_PrevAndNext(
        long id, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            fr.lagab.portlet.publication.NoSuchPublicationException {
        return getPersistence()
                   .findByGroupId_PrevAndNext(id, groupId, orderByComparator);
    }

    /**
    * Removes all the publications where groupId = &#63; from the database.
    *
    * @param groupId the group ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByGroupId(groupId);
    }

    /**
    * Returns the number of publications where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the number of matching publications
    * @throws SystemException if a system exception occurred
    */
    public static int countByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByGroupId(groupId);
    }

    /**
    * Returns all the publications where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the matching publications
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<fr.lagab.portlet.publication.model.Publication> findByCompanyId(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCompanyId(companyId);
    }

    /**
    * Returns a range of all the publications where companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fr.lagab.portlet.publication.model.impl.PublicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param companyId the company ID
    * @param start the lower bound of the range of publications
    * @param end the upper bound of the range of publications (not inclusive)
    * @return the range of matching publications
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<fr.lagab.portlet.publication.model.Publication> findByCompanyId(
        long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCompanyId(companyId, start, end);
    }

    /**
    * Returns an ordered range of all the publications where companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fr.lagab.portlet.publication.model.impl.PublicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param companyId the company ID
    * @param start the lower bound of the range of publications
    * @param end the upper bound of the range of publications (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching publications
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<fr.lagab.portlet.publication.model.Publication> findByCompanyId(
        long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCompanyId(companyId, start, end, orderByComparator);
    }

    /**
    * Returns the first publication in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching publication
    * @throws fr.lagab.portlet.publication.NoSuchPublicationException if a matching publication could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fr.lagab.portlet.publication.model.Publication findByCompanyId_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            fr.lagab.portlet.publication.NoSuchPublicationException {
        return getPersistence()
                   .findByCompanyId_First(companyId, orderByComparator);
    }

    /**
    * Returns the first publication in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching publication, or <code>null</code> if a matching publication could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fr.lagab.portlet.publication.model.Publication fetchByCompanyId_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByCompanyId_First(companyId, orderByComparator);
    }

    /**
    * Returns the last publication in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching publication
    * @throws fr.lagab.portlet.publication.NoSuchPublicationException if a matching publication could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fr.lagab.portlet.publication.model.Publication findByCompanyId_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            fr.lagab.portlet.publication.NoSuchPublicationException {
        return getPersistence()
                   .findByCompanyId_Last(companyId, orderByComparator);
    }

    /**
    * Returns the last publication in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching publication, or <code>null</code> if a matching publication could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fr.lagab.portlet.publication.model.Publication fetchByCompanyId_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByCompanyId_Last(companyId, orderByComparator);
    }

    /**
    * Returns the publications before and after the current publication in the ordered set where companyId = &#63;.
    *
    * @param id the primary key of the current publication
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next publication
    * @throws fr.lagab.portlet.publication.NoSuchPublicationException if a publication with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fr.lagab.portlet.publication.model.Publication[] findByCompanyId_PrevAndNext(
        long id, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            fr.lagab.portlet.publication.NoSuchPublicationException {
        return getPersistence()
                   .findByCompanyId_PrevAndNext(id, companyId, orderByComparator);
    }

    /**
    * Removes all the publications where companyId = &#63; from the database.
    *
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByCompanyId(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByCompanyId(companyId);
    }

    /**
    * Returns the number of publications where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the number of matching publications
    * @throws SystemException if a system exception occurred
    */
    public static int countByCompanyId(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByCompanyId(companyId);
    }

    /**
    * Returns all the publications where structureId = &#63;.
    *
    * @param structureId the structure ID
    * @return the matching publications
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<fr.lagab.portlet.publication.model.Publication> findByStructureId(
        long structureId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByStructureId(structureId);
    }

    /**
    * Returns a range of all the publications where structureId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fr.lagab.portlet.publication.model.impl.PublicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param structureId the structure ID
    * @param start the lower bound of the range of publications
    * @param end the upper bound of the range of publications (not inclusive)
    * @return the range of matching publications
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<fr.lagab.portlet.publication.model.Publication> findByStructureId(
        long structureId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByStructureId(structureId, start, end);
    }

    /**
    * Returns an ordered range of all the publications where structureId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fr.lagab.portlet.publication.model.impl.PublicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param structureId the structure ID
    * @param start the lower bound of the range of publications
    * @param end the upper bound of the range of publications (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching publications
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<fr.lagab.portlet.publication.model.Publication> findByStructureId(
        long structureId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByStructureId(structureId, start, end, orderByComparator);
    }

    /**
    * Returns the first publication in the ordered set where structureId = &#63;.
    *
    * @param structureId the structure ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching publication
    * @throws fr.lagab.portlet.publication.NoSuchPublicationException if a matching publication could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fr.lagab.portlet.publication.model.Publication findByStructureId_First(
        long structureId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            fr.lagab.portlet.publication.NoSuchPublicationException {
        return getPersistence()
                   .findByStructureId_First(structureId, orderByComparator);
    }

    /**
    * Returns the first publication in the ordered set where structureId = &#63;.
    *
    * @param structureId the structure ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching publication, or <code>null</code> if a matching publication could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fr.lagab.portlet.publication.model.Publication fetchByStructureId_First(
        long structureId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByStructureId_First(structureId, orderByComparator);
    }

    /**
    * Returns the last publication in the ordered set where structureId = &#63;.
    *
    * @param structureId the structure ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching publication
    * @throws fr.lagab.portlet.publication.NoSuchPublicationException if a matching publication could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fr.lagab.portlet.publication.model.Publication findByStructureId_Last(
        long structureId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            fr.lagab.portlet.publication.NoSuchPublicationException {
        return getPersistence()
                   .findByStructureId_Last(structureId, orderByComparator);
    }

    /**
    * Returns the last publication in the ordered set where structureId = &#63;.
    *
    * @param structureId the structure ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching publication, or <code>null</code> if a matching publication could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fr.lagab.portlet.publication.model.Publication fetchByStructureId_Last(
        long structureId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByStructureId_Last(structureId, orderByComparator);
    }

    /**
    * Returns the publications before and after the current publication in the ordered set where structureId = &#63;.
    *
    * @param id the primary key of the current publication
    * @param structureId the structure ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next publication
    * @throws fr.lagab.portlet.publication.NoSuchPublicationException if a publication with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fr.lagab.portlet.publication.model.Publication[] findByStructureId_PrevAndNext(
        long id, long structureId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            fr.lagab.portlet.publication.NoSuchPublicationException {
        return getPersistence()
                   .findByStructureId_PrevAndNext(id, structureId,
            orderByComparator);
    }

    /**
    * Returns all the publications where structureId = any &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fr.lagab.portlet.publication.model.impl.PublicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param structureIds the structure IDs
    * @return the matching publications
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<fr.lagab.portlet.publication.model.Publication> findByStructureId(
        long[] structureIds)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByStructureId(structureIds);
    }

    /**
    * Returns a range of all the publications where structureId = any &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fr.lagab.portlet.publication.model.impl.PublicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param structureIds the structure IDs
    * @param start the lower bound of the range of publications
    * @param end the upper bound of the range of publications (not inclusive)
    * @return the range of matching publications
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<fr.lagab.portlet.publication.model.Publication> findByStructureId(
        long[] structureIds, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByStructureId(structureIds, start, end);
    }

    /**
    * Returns an ordered range of all the publications where structureId = any &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fr.lagab.portlet.publication.model.impl.PublicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param structureIds the structure IDs
    * @param start the lower bound of the range of publications
    * @param end the upper bound of the range of publications (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching publications
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<fr.lagab.portlet.publication.model.Publication> findByStructureId(
        long[] structureIds, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByStructureId(structureIds, start, end,
            orderByComparator);
    }

    /**
    * Removes all the publications where structureId = &#63; from the database.
    *
    * @param structureId the structure ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByStructureId(long structureId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByStructureId(structureId);
    }

    /**
    * Returns the number of publications where structureId = &#63;.
    *
    * @param structureId the structure ID
    * @return the number of matching publications
    * @throws SystemException if a system exception occurred
    */
    public static int countByStructureId(long structureId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByStructureId(structureId);
    }

    /**
    * Returns the number of publications where structureId = any &#63;.
    *
    * @param structureIds the structure IDs
    * @return the number of matching publications
    * @throws SystemException if a system exception occurred
    */
    public static int countByStructureId(long[] structureIds)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByStructureId(structureIds);
    }

    /**
    * Returns all the publications where templateId = &#63;.
    *
    * @param templateId the template ID
    * @return the matching publications
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<fr.lagab.portlet.publication.model.Publication> findByTemplateId(
        long templateId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByTemplateId(templateId);
    }

    /**
    * Returns a range of all the publications where templateId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fr.lagab.portlet.publication.model.impl.PublicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param templateId the template ID
    * @param start the lower bound of the range of publications
    * @param end the upper bound of the range of publications (not inclusive)
    * @return the range of matching publications
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<fr.lagab.portlet.publication.model.Publication> findByTemplateId(
        long templateId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByTemplateId(templateId, start, end);
    }

    /**
    * Returns an ordered range of all the publications where templateId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fr.lagab.portlet.publication.model.impl.PublicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param templateId the template ID
    * @param start the lower bound of the range of publications
    * @param end the upper bound of the range of publications (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching publications
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<fr.lagab.portlet.publication.model.Publication> findByTemplateId(
        long templateId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByTemplateId(templateId, start, end, orderByComparator);
    }

    /**
    * Returns the first publication in the ordered set where templateId = &#63;.
    *
    * @param templateId the template ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching publication
    * @throws fr.lagab.portlet.publication.NoSuchPublicationException if a matching publication could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fr.lagab.portlet.publication.model.Publication findByTemplateId_First(
        long templateId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            fr.lagab.portlet.publication.NoSuchPublicationException {
        return getPersistence()
                   .findByTemplateId_First(templateId, orderByComparator);
    }

    /**
    * Returns the first publication in the ordered set where templateId = &#63;.
    *
    * @param templateId the template ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching publication, or <code>null</code> if a matching publication could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fr.lagab.portlet.publication.model.Publication fetchByTemplateId_First(
        long templateId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByTemplateId_First(templateId, orderByComparator);
    }

    /**
    * Returns the last publication in the ordered set where templateId = &#63;.
    *
    * @param templateId the template ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching publication
    * @throws fr.lagab.portlet.publication.NoSuchPublicationException if a matching publication could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fr.lagab.portlet.publication.model.Publication findByTemplateId_Last(
        long templateId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            fr.lagab.portlet.publication.NoSuchPublicationException {
        return getPersistence()
                   .findByTemplateId_Last(templateId, orderByComparator);
    }

    /**
    * Returns the last publication in the ordered set where templateId = &#63;.
    *
    * @param templateId the template ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching publication, or <code>null</code> if a matching publication could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fr.lagab.portlet.publication.model.Publication fetchByTemplateId_Last(
        long templateId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByTemplateId_Last(templateId, orderByComparator);
    }

    /**
    * Returns the publications before and after the current publication in the ordered set where templateId = &#63;.
    *
    * @param id the primary key of the current publication
    * @param templateId the template ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next publication
    * @throws fr.lagab.portlet.publication.NoSuchPublicationException if a publication with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fr.lagab.portlet.publication.model.Publication[] findByTemplateId_PrevAndNext(
        long id, long templateId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            fr.lagab.portlet.publication.NoSuchPublicationException {
        return getPersistence()
                   .findByTemplateId_PrevAndNext(id, templateId,
            orderByComparator);
    }

    /**
    * Removes all the publications where templateId = &#63; from the database.
    *
    * @param templateId the template ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByTemplateId(long templateId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByTemplateId(templateId);
    }

    /**
    * Returns the number of publications where templateId = &#63;.
    *
    * @param templateId the template ID
    * @return the number of matching publications
    * @throws SystemException if a system exception occurred
    */
    public static int countByTemplateId(long templateId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByTemplateId(templateId);
    }

    /**
    * Returns all the publications where groupId = &#63; and userId = &#63;.
    *
    * @param groupId the group ID
    * @param userId the user ID
    * @return the matching publications
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<fr.lagab.portlet.publication.model.Publication> findByG_U(
        long groupId, long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByG_U(groupId, userId);
    }

    /**
    * Returns a range of all the publications where groupId = &#63; and userId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fr.lagab.portlet.publication.model.impl.PublicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param userId the user ID
    * @param start the lower bound of the range of publications
    * @param end the upper bound of the range of publications (not inclusive)
    * @return the range of matching publications
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<fr.lagab.portlet.publication.model.Publication> findByG_U(
        long groupId, long userId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByG_U(groupId, userId, start, end);
    }

    /**
    * Returns an ordered range of all the publications where groupId = &#63; and userId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fr.lagab.portlet.publication.model.impl.PublicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param userId the user ID
    * @param start the lower bound of the range of publications
    * @param end the upper bound of the range of publications (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching publications
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<fr.lagab.portlet.publication.model.Publication> findByG_U(
        long groupId, long userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByG_U(groupId, userId, start, end, orderByComparator);
    }

    /**
    * Returns the first publication in the ordered set where groupId = &#63; and userId = &#63;.
    *
    * @param groupId the group ID
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching publication
    * @throws fr.lagab.portlet.publication.NoSuchPublicationException if a matching publication could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fr.lagab.portlet.publication.model.Publication findByG_U_First(
        long groupId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            fr.lagab.portlet.publication.NoSuchPublicationException {
        return getPersistence()
                   .findByG_U_First(groupId, userId, orderByComparator);
    }

    /**
    * Returns the first publication in the ordered set where groupId = &#63; and userId = &#63;.
    *
    * @param groupId the group ID
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching publication, or <code>null</code> if a matching publication could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fr.lagab.portlet.publication.model.Publication fetchByG_U_First(
        long groupId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByG_U_First(groupId, userId, orderByComparator);
    }

    /**
    * Returns the last publication in the ordered set where groupId = &#63; and userId = &#63;.
    *
    * @param groupId the group ID
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching publication
    * @throws fr.lagab.portlet.publication.NoSuchPublicationException if a matching publication could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fr.lagab.portlet.publication.model.Publication findByG_U_Last(
        long groupId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            fr.lagab.portlet.publication.NoSuchPublicationException {
        return getPersistence()
                   .findByG_U_Last(groupId, userId, orderByComparator);
    }

    /**
    * Returns the last publication in the ordered set where groupId = &#63; and userId = &#63;.
    *
    * @param groupId the group ID
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching publication, or <code>null</code> if a matching publication could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fr.lagab.portlet.publication.model.Publication fetchByG_U_Last(
        long groupId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByG_U_Last(groupId, userId, orderByComparator);
    }

    /**
    * Returns the publications before and after the current publication in the ordered set where groupId = &#63; and userId = &#63;.
    *
    * @param id the primary key of the current publication
    * @param groupId the group ID
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next publication
    * @throws fr.lagab.portlet.publication.NoSuchPublicationException if a publication with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fr.lagab.portlet.publication.model.Publication[] findByG_U_PrevAndNext(
        long id, long groupId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            fr.lagab.portlet.publication.NoSuchPublicationException {
        return getPersistence()
                   .findByG_U_PrevAndNext(id, groupId, userId, orderByComparator);
    }

    /**
    * Removes all the publications where groupId = &#63; and userId = &#63; from the database.
    *
    * @param groupId the group ID
    * @param userId the user ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByG_U(long groupId, long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByG_U(groupId, userId);
    }

    /**
    * Returns the number of publications where groupId = &#63; and userId = &#63;.
    *
    * @param groupId the group ID
    * @param userId the user ID
    * @return the number of matching publications
    * @throws SystemException if a system exception occurred
    */
    public static int countByG_U(long groupId, long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByG_U(groupId, userId);
    }

    /**
    * Returns all the publications where groupId = &#63; and structureId = &#63;.
    *
    * @param groupId the group ID
    * @param structureId the structure ID
    * @return the matching publications
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<fr.lagab.portlet.publication.model.Publication> findByG_S(
        long groupId, long structureId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByG_S(groupId, structureId);
    }

    /**
    * Returns a range of all the publications where groupId = &#63; and structureId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fr.lagab.portlet.publication.model.impl.PublicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param structureId the structure ID
    * @param start the lower bound of the range of publications
    * @param end the upper bound of the range of publications (not inclusive)
    * @return the range of matching publications
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<fr.lagab.portlet.publication.model.Publication> findByG_S(
        long groupId, long structureId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByG_S(groupId, structureId, start, end);
    }

    /**
    * Returns an ordered range of all the publications where groupId = &#63; and structureId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fr.lagab.portlet.publication.model.impl.PublicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param structureId the structure ID
    * @param start the lower bound of the range of publications
    * @param end the upper bound of the range of publications (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching publications
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<fr.lagab.portlet.publication.model.Publication> findByG_S(
        long groupId, long structureId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByG_S(groupId, structureId, start, end,
            orderByComparator);
    }

    /**
    * Returns the first publication in the ordered set where groupId = &#63; and structureId = &#63;.
    *
    * @param groupId the group ID
    * @param structureId the structure ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching publication
    * @throws fr.lagab.portlet.publication.NoSuchPublicationException if a matching publication could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fr.lagab.portlet.publication.model.Publication findByG_S_First(
        long groupId, long structureId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            fr.lagab.portlet.publication.NoSuchPublicationException {
        return getPersistence()
                   .findByG_S_First(groupId, structureId, orderByComparator);
    }

    /**
    * Returns the first publication in the ordered set where groupId = &#63; and structureId = &#63;.
    *
    * @param groupId the group ID
    * @param structureId the structure ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching publication, or <code>null</code> if a matching publication could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fr.lagab.portlet.publication.model.Publication fetchByG_S_First(
        long groupId, long structureId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByG_S_First(groupId, structureId, orderByComparator);
    }

    /**
    * Returns the last publication in the ordered set where groupId = &#63; and structureId = &#63;.
    *
    * @param groupId the group ID
    * @param structureId the structure ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching publication
    * @throws fr.lagab.portlet.publication.NoSuchPublicationException if a matching publication could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fr.lagab.portlet.publication.model.Publication findByG_S_Last(
        long groupId, long structureId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            fr.lagab.portlet.publication.NoSuchPublicationException {
        return getPersistence()
                   .findByG_S_Last(groupId, structureId, orderByComparator);
    }

    /**
    * Returns the last publication in the ordered set where groupId = &#63; and structureId = &#63;.
    *
    * @param groupId the group ID
    * @param structureId the structure ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching publication, or <code>null</code> if a matching publication could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fr.lagab.portlet.publication.model.Publication fetchByG_S_Last(
        long groupId, long structureId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByG_S_Last(groupId, structureId, orderByComparator);
    }

    /**
    * Returns the publications before and after the current publication in the ordered set where groupId = &#63; and structureId = &#63;.
    *
    * @param id the primary key of the current publication
    * @param groupId the group ID
    * @param structureId the structure ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next publication
    * @throws fr.lagab.portlet.publication.NoSuchPublicationException if a publication with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fr.lagab.portlet.publication.model.Publication[] findByG_S_PrevAndNext(
        long id, long groupId, long structureId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            fr.lagab.portlet.publication.NoSuchPublicationException {
        return getPersistence()
                   .findByG_S_PrevAndNext(id, groupId, structureId,
            orderByComparator);
    }

    /**
    * Removes all the publications where groupId = &#63; and structureId = &#63; from the database.
    *
    * @param groupId the group ID
    * @param structureId the structure ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByG_S(long groupId, long structureId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByG_S(groupId, structureId);
    }

    /**
    * Returns the number of publications where groupId = &#63; and structureId = &#63;.
    *
    * @param groupId the group ID
    * @param structureId the structure ID
    * @return the number of matching publications
    * @throws SystemException if a system exception occurred
    */
    public static int countByG_S(long groupId, long structureId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByG_S(groupId, structureId);
    }

    /**
    * Returns all the publications where groupId = &#63; and templateId = &#63;.
    *
    * @param groupId the group ID
    * @param templateId the template ID
    * @return the matching publications
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<fr.lagab.portlet.publication.model.Publication> findByG_T(
        long groupId, long templateId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByG_T(groupId, templateId);
    }

    /**
    * Returns a range of all the publications where groupId = &#63; and templateId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fr.lagab.portlet.publication.model.impl.PublicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param templateId the template ID
    * @param start the lower bound of the range of publications
    * @param end the upper bound of the range of publications (not inclusive)
    * @return the range of matching publications
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<fr.lagab.portlet.publication.model.Publication> findByG_T(
        long groupId, long templateId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByG_T(groupId, templateId, start, end);
    }

    /**
    * Returns an ordered range of all the publications where groupId = &#63; and templateId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fr.lagab.portlet.publication.model.impl.PublicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param templateId the template ID
    * @param start the lower bound of the range of publications
    * @param end the upper bound of the range of publications (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching publications
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<fr.lagab.portlet.publication.model.Publication> findByG_T(
        long groupId, long templateId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByG_T(groupId, templateId, start, end, orderByComparator);
    }

    /**
    * Returns the first publication in the ordered set where groupId = &#63; and templateId = &#63;.
    *
    * @param groupId the group ID
    * @param templateId the template ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching publication
    * @throws fr.lagab.portlet.publication.NoSuchPublicationException if a matching publication could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fr.lagab.portlet.publication.model.Publication findByG_T_First(
        long groupId, long templateId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            fr.lagab.portlet.publication.NoSuchPublicationException {
        return getPersistence()
                   .findByG_T_First(groupId, templateId, orderByComparator);
    }

    /**
    * Returns the first publication in the ordered set where groupId = &#63; and templateId = &#63;.
    *
    * @param groupId the group ID
    * @param templateId the template ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching publication, or <code>null</code> if a matching publication could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fr.lagab.portlet.publication.model.Publication fetchByG_T_First(
        long groupId, long templateId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByG_T_First(groupId, templateId, orderByComparator);
    }

    /**
    * Returns the last publication in the ordered set where groupId = &#63; and templateId = &#63;.
    *
    * @param groupId the group ID
    * @param templateId the template ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching publication
    * @throws fr.lagab.portlet.publication.NoSuchPublicationException if a matching publication could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fr.lagab.portlet.publication.model.Publication findByG_T_Last(
        long groupId, long templateId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            fr.lagab.portlet.publication.NoSuchPublicationException {
        return getPersistence()
                   .findByG_T_Last(groupId, templateId, orderByComparator);
    }

    /**
    * Returns the last publication in the ordered set where groupId = &#63; and templateId = &#63;.
    *
    * @param groupId the group ID
    * @param templateId the template ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching publication, or <code>null</code> if a matching publication could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fr.lagab.portlet.publication.model.Publication fetchByG_T_Last(
        long groupId, long templateId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByG_T_Last(groupId, templateId, orderByComparator);
    }

    /**
    * Returns the publications before and after the current publication in the ordered set where groupId = &#63; and templateId = &#63;.
    *
    * @param id the primary key of the current publication
    * @param groupId the group ID
    * @param templateId the template ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next publication
    * @throws fr.lagab.portlet.publication.NoSuchPublicationException if a publication with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fr.lagab.portlet.publication.model.Publication[] findByG_T_PrevAndNext(
        long id, long groupId, long templateId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            fr.lagab.portlet.publication.NoSuchPublicationException {
        return getPersistence()
                   .findByG_T_PrevAndNext(id, groupId, templateId,
            orderByComparator);
    }

    /**
    * Removes all the publications where groupId = &#63; and templateId = &#63; from the database.
    *
    * @param groupId the group ID
    * @param templateId the template ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByG_T(long groupId, long templateId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByG_T(groupId, templateId);
    }

    /**
    * Returns the number of publications where groupId = &#63; and templateId = &#63;.
    *
    * @param groupId the group ID
    * @param templateId the template ID
    * @return the number of matching publications
    * @throws SystemException if a system exception occurred
    */
    public static int countByG_T(long groupId, long templateId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByG_T(groupId, templateId);
    }

    /**
    * Caches the publication in the entity cache if it is enabled.
    *
    * @param publication the publication
    */
    public static void cacheResult(
        fr.lagab.portlet.publication.model.Publication publication) {
        getPersistence().cacheResult(publication);
    }

    /**
    * Caches the publications in the entity cache if it is enabled.
    *
    * @param publications the publications
    */
    public static void cacheResult(
        java.util.List<fr.lagab.portlet.publication.model.Publication> publications) {
        getPersistence().cacheResult(publications);
    }

    /**
    * Creates a new publication with the primary key. Does not add the publication to the database.
    *
    * @param id the primary key for the new publication
    * @return the new publication
    */
    public static fr.lagab.portlet.publication.model.Publication create(long id) {
        return getPersistence().create(id);
    }

    /**
    * Removes the publication with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the publication
    * @return the publication that was removed
    * @throws fr.lagab.portlet.publication.NoSuchPublicationException if a publication with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fr.lagab.portlet.publication.model.Publication remove(long id)
        throws com.liferay.portal.kernel.exception.SystemException,
            fr.lagab.portlet.publication.NoSuchPublicationException {
        return getPersistence().remove(id);
    }

    public static fr.lagab.portlet.publication.model.Publication updateImpl(
        fr.lagab.portlet.publication.model.Publication publication)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(publication);
    }

    /**
    * Returns the publication with the primary key or throws a {@link fr.lagab.portlet.publication.NoSuchPublicationException} if it could not be found.
    *
    * @param id the primary key of the publication
    * @return the publication
    * @throws fr.lagab.portlet.publication.NoSuchPublicationException if a publication with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fr.lagab.portlet.publication.model.Publication findByPrimaryKey(
        long id)
        throws com.liferay.portal.kernel.exception.SystemException,
            fr.lagab.portlet.publication.NoSuchPublicationException {
        return getPersistence().findByPrimaryKey(id);
    }

    /**
    * Returns the publication with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the publication
    * @return the publication, or <code>null</code> if a publication with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fr.lagab.portlet.publication.model.Publication fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(id);
    }

    /**
    * Returns all the publications.
    *
    * @return the publications
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<fr.lagab.portlet.publication.model.Publication> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<fr.lagab.portlet.publication.model.Publication> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the publications.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fr.lagab.portlet.publication.model.impl.PublicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of publications
    * @param end the upper bound of the range of publications (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of publications
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<fr.lagab.portlet.publication.model.Publication> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the publications from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of publications.
    *
    * @return the number of publications
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static PublicationPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (PublicationPersistence) PortletBeanLocatorUtil.locate(fr.lagab.portlet.publication.service.ClpSerializer.getServletContextName(),
                    PublicationPersistence.class.getName());

            ReferenceRegistry.registerReference(PublicationUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(PublicationPersistence persistence) {
    }
}
