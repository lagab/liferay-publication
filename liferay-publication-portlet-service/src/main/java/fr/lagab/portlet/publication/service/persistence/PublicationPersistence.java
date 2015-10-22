package fr.lagab.portlet.publication.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import fr.lagab.portlet.publication.model.Publication;

/**
 * The persistence interface for the publication service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PublicationPersistenceImpl
 * @see PublicationUtil
 * @generated
 */
public interface PublicationPersistence extends BasePersistence<Publication> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link PublicationUtil} to access the publication persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the publications where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the matching publications
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<fr.lagab.portlet.publication.model.Publication> findByUuid(
        java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<fr.lagab.portlet.publication.model.Publication> findByUuid(
        java.lang.String uuid, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<fr.lagab.portlet.publication.model.Publication> findByUuid(
        java.lang.String uuid, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first publication in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching publication
    * @throws fr.lagab.portlet.publication.NoSuchPublicationException if a matching publication could not be found
    * @throws SystemException if a system exception occurred
    */
    public fr.lagab.portlet.publication.model.Publication findByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            fr.lagab.portlet.publication.NoSuchPublicationException;

    /**
    * Returns the first publication in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching publication, or <code>null</code> if a matching publication could not be found
    * @throws SystemException if a system exception occurred
    */
    public fr.lagab.portlet.publication.model.Publication fetchByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last publication in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching publication
    * @throws fr.lagab.portlet.publication.NoSuchPublicationException if a matching publication could not be found
    * @throws SystemException if a system exception occurred
    */
    public fr.lagab.portlet.publication.model.Publication findByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            fr.lagab.portlet.publication.NoSuchPublicationException;

    /**
    * Returns the last publication in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching publication, or <code>null</code> if a matching publication could not be found
    * @throws SystemException if a system exception occurred
    */
    public fr.lagab.portlet.publication.model.Publication fetchByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public fr.lagab.portlet.publication.model.Publication[] findByUuid_PrevAndNext(
        long id, java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            fr.lagab.portlet.publication.NoSuchPublicationException;

    /**
    * Removes all the publications where uuid = &#63; from the database.
    *
    * @param uuid the uuid
    * @throws SystemException if a system exception occurred
    */
    public void removeByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of publications where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the number of matching publications
    * @throws SystemException if a system exception occurred
    */
    public int countByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the publication where uuid = &#63; and groupId = &#63; or throws a {@link fr.lagab.portlet.publication.NoSuchPublicationException} if it could not be found.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching publication
    * @throws fr.lagab.portlet.publication.NoSuchPublicationException if a matching publication could not be found
    * @throws SystemException if a system exception occurred
    */
    public fr.lagab.portlet.publication.model.Publication findByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException,
            fr.lagab.portlet.publication.NoSuchPublicationException;

    /**
    * Returns the publication where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching publication, or <code>null</code> if a matching publication could not be found
    * @throws SystemException if a system exception occurred
    */
    public fr.lagab.portlet.publication.model.Publication fetchByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the publication where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching publication, or <code>null</code> if a matching publication could not be found
    * @throws SystemException if a system exception occurred
    */
    public fr.lagab.portlet.publication.model.Publication fetchByUUID_G(
        java.lang.String uuid, long groupId, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the publication where uuid = &#63; and groupId = &#63; from the database.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the publication that was removed
    * @throws SystemException if a system exception occurred
    */
    public fr.lagab.portlet.publication.model.Publication removeByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException,
            fr.lagab.portlet.publication.NoSuchPublicationException;

    /**
    * Returns the number of publications where uuid = &#63; and groupId = &#63;.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the number of matching publications
    * @throws SystemException if a system exception occurred
    */
    public int countByUUID_G(java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the publications where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the matching publications
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<fr.lagab.portlet.publication.model.Publication> findByUuid_C(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<fr.lagab.portlet.publication.model.Publication> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<fr.lagab.portlet.publication.model.Publication> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public fr.lagab.portlet.publication.model.Publication findByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            fr.lagab.portlet.publication.NoSuchPublicationException;

    /**
    * Returns the first publication in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching publication, or <code>null</code> if a matching publication could not be found
    * @throws SystemException if a system exception occurred
    */
    public fr.lagab.portlet.publication.model.Publication fetchByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public fr.lagab.portlet.publication.model.Publication findByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            fr.lagab.portlet.publication.NoSuchPublicationException;

    /**
    * Returns the last publication in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching publication, or <code>null</code> if a matching publication could not be found
    * @throws SystemException if a system exception occurred
    */
    public fr.lagab.portlet.publication.model.Publication fetchByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public fr.lagab.portlet.publication.model.Publication[] findByUuid_C_PrevAndNext(
        long id, java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            fr.lagab.portlet.publication.NoSuchPublicationException;

    /**
    * Removes all the publications where uuid = &#63; and companyId = &#63; from the database.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByUuid_C(java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of publications where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the number of matching publications
    * @throws SystemException if a system exception occurred
    */
    public int countByUuid_C(java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the publications where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the matching publications
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<fr.lagab.portlet.publication.model.Publication> findByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<fr.lagab.portlet.publication.model.Publication> findByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<fr.lagab.portlet.publication.model.Publication> findByGroupId(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first publication in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching publication
    * @throws fr.lagab.portlet.publication.NoSuchPublicationException if a matching publication could not be found
    * @throws SystemException if a system exception occurred
    */
    public fr.lagab.portlet.publication.model.Publication findByGroupId_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            fr.lagab.portlet.publication.NoSuchPublicationException;

    /**
    * Returns the first publication in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching publication, or <code>null</code> if a matching publication could not be found
    * @throws SystemException if a system exception occurred
    */
    public fr.lagab.portlet.publication.model.Publication fetchByGroupId_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last publication in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching publication
    * @throws fr.lagab.portlet.publication.NoSuchPublicationException if a matching publication could not be found
    * @throws SystemException if a system exception occurred
    */
    public fr.lagab.portlet.publication.model.Publication findByGroupId_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            fr.lagab.portlet.publication.NoSuchPublicationException;

    /**
    * Returns the last publication in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching publication, or <code>null</code> if a matching publication could not be found
    * @throws SystemException if a system exception occurred
    */
    public fr.lagab.portlet.publication.model.Publication fetchByGroupId_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public fr.lagab.portlet.publication.model.Publication[] findByGroupId_PrevAndNext(
        long id, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            fr.lagab.portlet.publication.NoSuchPublicationException;

    /**
    * Removes all the publications where groupId = &#63; from the database.
    *
    * @param groupId the group ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of publications where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the number of matching publications
    * @throws SystemException if a system exception occurred
    */
    public int countByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the publications where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the matching publications
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<fr.lagab.portlet.publication.model.Publication> findByCompanyId(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<fr.lagab.portlet.publication.model.Publication> findByCompanyId(
        long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<fr.lagab.portlet.publication.model.Publication> findByCompanyId(
        long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first publication in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching publication
    * @throws fr.lagab.portlet.publication.NoSuchPublicationException if a matching publication could not be found
    * @throws SystemException if a system exception occurred
    */
    public fr.lagab.portlet.publication.model.Publication findByCompanyId_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            fr.lagab.portlet.publication.NoSuchPublicationException;

    /**
    * Returns the first publication in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching publication, or <code>null</code> if a matching publication could not be found
    * @throws SystemException if a system exception occurred
    */
    public fr.lagab.portlet.publication.model.Publication fetchByCompanyId_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last publication in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching publication
    * @throws fr.lagab.portlet.publication.NoSuchPublicationException if a matching publication could not be found
    * @throws SystemException if a system exception occurred
    */
    public fr.lagab.portlet.publication.model.Publication findByCompanyId_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            fr.lagab.portlet.publication.NoSuchPublicationException;

    /**
    * Returns the last publication in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching publication, or <code>null</code> if a matching publication could not be found
    * @throws SystemException if a system exception occurred
    */
    public fr.lagab.portlet.publication.model.Publication fetchByCompanyId_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public fr.lagab.portlet.publication.model.Publication[] findByCompanyId_PrevAndNext(
        long id, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            fr.lagab.portlet.publication.NoSuchPublicationException;

    /**
    * Removes all the publications where companyId = &#63; from the database.
    *
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByCompanyId(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of publications where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the number of matching publications
    * @throws SystemException if a system exception occurred
    */
    public int countByCompanyId(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the publications where structureId = &#63;.
    *
    * @param structureId the structure ID
    * @return the matching publications
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<fr.lagab.portlet.publication.model.Publication> findByStructureId(
        long structureId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<fr.lagab.portlet.publication.model.Publication> findByStructureId(
        long structureId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<fr.lagab.portlet.publication.model.Publication> findByStructureId(
        long structureId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first publication in the ordered set where structureId = &#63;.
    *
    * @param structureId the structure ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching publication
    * @throws fr.lagab.portlet.publication.NoSuchPublicationException if a matching publication could not be found
    * @throws SystemException if a system exception occurred
    */
    public fr.lagab.portlet.publication.model.Publication findByStructureId_First(
        long structureId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            fr.lagab.portlet.publication.NoSuchPublicationException;

    /**
    * Returns the first publication in the ordered set where structureId = &#63;.
    *
    * @param structureId the structure ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching publication, or <code>null</code> if a matching publication could not be found
    * @throws SystemException if a system exception occurred
    */
    public fr.lagab.portlet.publication.model.Publication fetchByStructureId_First(
        long structureId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last publication in the ordered set where structureId = &#63;.
    *
    * @param structureId the structure ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching publication
    * @throws fr.lagab.portlet.publication.NoSuchPublicationException if a matching publication could not be found
    * @throws SystemException if a system exception occurred
    */
    public fr.lagab.portlet.publication.model.Publication findByStructureId_Last(
        long structureId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            fr.lagab.portlet.publication.NoSuchPublicationException;

    /**
    * Returns the last publication in the ordered set where structureId = &#63;.
    *
    * @param structureId the structure ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching publication, or <code>null</code> if a matching publication could not be found
    * @throws SystemException if a system exception occurred
    */
    public fr.lagab.portlet.publication.model.Publication fetchByStructureId_Last(
        long structureId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public fr.lagab.portlet.publication.model.Publication[] findByStructureId_PrevAndNext(
        long id, long structureId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            fr.lagab.portlet.publication.NoSuchPublicationException;

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
    public java.util.List<fr.lagab.portlet.publication.model.Publication> findByStructureId(
        long[] structureIds)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<fr.lagab.portlet.publication.model.Publication> findByStructureId(
        long[] structureIds, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<fr.lagab.portlet.publication.model.Publication> findByStructureId(
        long[] structureIds, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the publications where structureId = &#63; from the database.
    *
    * @param structureId the structure ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByStructureId(long structureId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of publications where structureId = &#63;.
    *
    * @param structureId the structure ID
    * @return the number of matching publications
    * @throws SystemException if a system exception occurred
    */
    public int countByStructureId(long structureId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of publications where structureId = any &#63;.
    *
    * @param structureIds the structure IDs
    * @return the number of matching publications
    * @throws SystemException if a system exception occurred
    */
    public int countByStructureId(long[] structureIds)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the publications where templateId = &#63;.
    *
    * @param templateId the template ID
    * @return the matching publications
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<fr.lagab.portlet.publication.model.Publication> findByTemplateId(
        long templateId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<fr.lagab.portlet.publication.model.Publication> findByTemplateId(
        long templateId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<fr.lagab.portlet.publication.model.Publication> findByTemplateId(
        long templateId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first publication in the ordered set where templateId = &#63;.
    *
    * @param templateId the template ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching publication
    * @throws fr.lagab.portlet.publication.NoSuchPublicationException if a matching publication could not be found
    * @throws SystemException if a system exception occurred
    */
    public fr.lagab.portlet.publication.model.Publication findByTemplateId_First(
        long templateId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            fr.lagab.portlet.publication.NoSuchPublicationException;

    /**
    * Returns the first publication in the ordered set where templateId = &#63;.
    *
    * @param templateId the template ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching publication, or <code>null</code> if a matching publication could not be found
    * @throws SystemException if a system exception occurred
    */
    public fr.lagab.portlet.publication.model.Publication fetchByTemplateId_First(
        long templateId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last publication in the ordered set where templateId = &#63;.
    *
    * @param templateId the template ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching publication
    * @throws fr.lagab.portlet.publication.NoSuchPublicationException if a matching publication could not be found
    * @throws SystemException if a system exception occurred
    */
    public fr.lagab.portlet.publication.model.Publication findByTemplateId_Last(
        long templateId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            fr.lagab.portlet.publication.NoSuchPublicationException;

    /**
    * Returns the last publication in the ordered set where templateId = &#63;.
    *
    * @param templateId the template ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching publication, or <code>null</code> if a matching publication could not be found
    * @throws SystemException if a system exception occurred
    */
    public fr.lagab.portlet.publication.model.Publication fetchByTemplateId_Last(
        long templateId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public fr.lagab.portlet.publication.model.Publication[] findByTemplateId_PrevAndNext(
        long id, long templateId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            fr.lagab.portlet.publication.NoSuchPublicationException;

    /**
    * Removes all the publications where templateId = &#63; from the database.
    *
    * @param templateId the template ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByTemplateId(long templateId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of publications where templateId = &#63;.
    *
    * @param templateId the template ID
    * @return the number of matching publications
    * @throws SystemException if a system exception occurred
    */
    public int countByTemplateId(long templateId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the publications where groupId = &#63; and userId = &#63;.
    *
    * @param groupId the group ID
    * @param userId the user ID
    * @return the matching publications
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<fr.lagab.portlet.publication.model.Publication> findByG_U(
        long groupId, long userId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<fr.lagab.portlet.publication.model.Publication> findByG_U(
        long groupId, long userId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<fr.lagab.portlet.publication.model.Publication> findByG_U(
        long groupId, long userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public fr.lagab.portlet.publication.model.Publication findByG_U_First(
        long groupId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            fr.lagab.portlet.publication.NoSuchPublicationException;

    /**
    * Returns the first publication in the ordered set where groupId = &#63; and userId = &#63;.
    *
    * @param groupId the group ID
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching publication, or <code>null</code> if a matching publication could not be found
    * @throws SystemException if a system exception occurred
    */
    public fr.lagab.portlet.publication.model.Publication fetchByG_U_First(
        long groupId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public fr.lagab.portlet.publication.model.Publication findByG_U_Last(
        long groupId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            fr.lagab.portlet.publication.NoSuchPublicationException;

    /**
    * Returns the last publication in the ordered set where groupId = &#63; and userId = &#63;.
    *
    * @param groupId the group ID
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching publication, or <code>null</code> if a matching publication could not be found
    * @throws SystemException if a system exception occurred
    */
    public fr.lagab.portlet.publication.model.Publication fetchByG_U_Last(
        long groupId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public fr.lagab.portlet.publication.model.Publication[] findByG_U_PrevAndNext(
        long id, long groupId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            fr.lagab.portlet.publication.NoSuchPublicationException;

    /**
    * Removes all the publications where groupId = &#63; and userId = &#63; from the database.
    *
    * @param groupId the group ID
    * @param userId the user ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByG_U(long groupId, long userId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of publications where groupId = &#63; and userId = &#63;.
    *
    * @param groupId the group ID
    * @param userId the user ID
    * @return the number of matching publications
    * @throws SystemException if a system exception occurred
    */
    public int countByG_U(long groupId, long userId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the publications where groupId = &#63; and structureId = &#63;.
    *
    * @param groupId the group ID
    * @param structureId the structure ID
    * @return the matching publications
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<fr.lagab.portlet.publication.model.Publication> findByG_S(
        long groupId, long structureId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<fr.lagab.portlet.publication.model.Publication> findByG_S(
        long groupId, long structureId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<fr.lagab.portlet.publication.model.Publication> findByG_S(
        long groupId, long structureId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public fr.lagab.portlet.publication.model.Publication findByG_S_First(
        long groupId, long structureId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            fr.lagab.portlet.publication.NoSuchPublicationException;

    /**
    * Returns the first publication in the ordered set where groupId = &#63; and structureId = &#63;.
    *
    * @param groupId the group ID
    * @param structureId the structure ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching publication, or <code>null</code> if a matching publication could not be found
    * @throws SystemException if a system exception occurred
    */
    public fr.lagab.portlet.publication.model.Publication fetchByG_S_First(
        long groupId, long structureId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public fr.lagab.portlet.publication.model.Publication findByG_S_Last(
        long groupId, long structureId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            fr.lagab.portlet.publication.NoSuchPublicationException;

    /**
    * Returns the last publication in the ordered set where groupId = &#63; and structureId = &#63;.
    *
    * @param groupId the group ID
    * @param structureId the structure ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching publication, or <code>null</code> if a matching publication could not be found
    * @throws SystemException if a system exception occurred
    */
    public fr.lagab.portlet.publication.model.Publication fetchByG_S_Last(
        long groupId, long structureId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public fr.lagab.portlet.publication.model.Publication[] findByG_S_PrevAndNext(
        long id, long groupId, long structureId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            fr.lagab.portlet.publication.NoSuchPublicationException;

    /**
    * Removes all the publications where groupId = &#63; and structureId = &#63; from the database.
    *
    * @param groupId the group ID
    * @param structureId the structure ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByG_S(long groupId, long structureId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of publications where groupId = &#63; and structureId = &#63;.
    *
    * @param groupId the group ID
    * @param structureId the structure ID
    * @return the number of matching publications
    * @throws SystemException if a system exception occurred
    */
    public int countByG_S(long groupId, long structureId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the publications where groupId = &#63; and templateId = &#63;.
    *
    * @param groupId the group ID
    * @param templateId the template ID
    * @return the matching publications
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<fr.lagab.portlet.publication.model.Publication> findByG_T(
        long groupId, long templateId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<fr.lagab.portlet.publication.model.Publication> findByG_T(
        long groupId, long templateId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<fr.lagab.portlet.publication.model.Publication> findByG_T(
        long groupId, long templateId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public fr.lagab.portlet.publication.model.Publication findByG_T_First(
        long groupId, long templateId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            fr.lagab.portlet.publication.NoSuchPublicationException;

    /**
    * Returns the first publication in the ordered set where groupId = &#63; and templateId = &#63;.
    *
    * @param groupId the group ID
    * @param templateId the template ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching publication, or <code>null</code> if a matching publication could not be found
    * @throws SystemException if a system exception occurred
    */
    public fr.lagab.portlet.publication.model.Publication fetchByG_T_First(
        long groupId, long templateId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public fr.lagab.portlet.publication.model.Publication findByG_T_Last(
        long groupId, long templateId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            fr.lagab.portlet.publication.NoSuchPublicationException;

    /**
    * Returns the last publication in the ordered set where groupId = &#63; and templateId = &#63;.
    *
    * @param groupId the group ID
    * @param templateId the template ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching publication, or <code>null</code> if a matching publication could not be found
    * @throws SystemException if a system exception occurred
    */
    public fr.lagab.portlet.publication.model.Publication fetchByG_T_Last(
        long groupId, long templateId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public fr.lagab.portlet.publication.model.Publication[] findByG_T_PrevAndNext(
        long id, long groupId, long templateId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            fr.lagab.portlet.publication.NoSuchPublicationException;

    /**
    * Removes all the publications where groupId = &#63; and templateId = &#63; from the database.
    *
    * @param groupId the group ID
    * @param templateId the template ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByG_T(long groupId, long templateId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of publications where groupId = &#63; and templateId = &#63;.
    *
    * @param groupId the group ID
    * @param templateId the template ID
    * @return the number of matching publications
    * @throws SystemException if a system exception occurred
    */
    public int countByG_T(long groupId, long templateId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the publication in the entity cache if it is enabled.
    *
    * @param publication the publication
    */
    public void cacheResult(
        fr.lagab.portlet.publication.model.Publication publication);

    /**
    * Caches the publications in the entity cache if it is enabled.
    *
    * @param publications the publications
    */
    public void cacheResult(
        java.util.List<fr.lagab.portlet.publication.model.Publication> publications);

    /**
    * Creates a new publication with the primary key. Does not add the publication to the database.
    *
    * @param id the primary key for the new publication
    * @return the new publication
    */
    public fr.lagab.portlet.publication.model.Publication create(long id);

    /**
    * Removes the publication with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the publication
    * @return the publication that was removed
    * @throws fr.lagab.portlet.publication.NoSuchPublicationException if a publication with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public fr.lagab.portlet.publication.model.Publication remove(long id)
        throws com.liferay.portal.kernel.exception.SystemException,
            fr.lagab.portlet.publication.NoSuchPublicationException;

    public fr.lagab.portlet.publication.model.Publication updateImpl(
        fr.lagab.portlet.publication.model.Publication publication)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the publication with the primary key or throws a {@link fr.lagab.portlet.publication.NoSuchPublicationException} if it could not be found.
    *
    * @param id the primary key of the publication
    * @return the publication
    * @throws fr.lagab.portlet.publication.NoSuchPublicationException if a publication with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public fr.lagab.portlet.publication.model.Publication findByPrimaryKey(
        long id)
        throws com.liferay.portal.kernel.exception.SystemException,
            fr.lagab.portlet.publication.NoSuchPublicationException;

    /**
    * Returns the publication with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the publication
    * @return the publication, or <code>null</code> if a publication with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public fr.lagab.portlet.publication.model.Publication fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the publications.
    *
    * @return the publications
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<fr.lagab.portlet.publication.model.Publication> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<fr.lagab.portlet.publication.model.Publication> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<fr.lagab.portlet.publication.model.Publication> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the publications from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of publications.
    *
    * @return the number of publications
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
