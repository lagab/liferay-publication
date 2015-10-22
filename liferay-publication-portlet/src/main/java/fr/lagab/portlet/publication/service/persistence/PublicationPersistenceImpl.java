package fr.lagab.portlet.publication.service.persistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import fr.lagab.portlet.publication.NoSuchPublicationException;
import fr.lagab.portlet.publication.model.Publication;
import fr.lagab.portlet.publication.model.impl.PublicationImpl;
import fr.lagab.portlet.publication.model.impl.PublicationModelImpl;
import fr.lagab.portlet.publication.service.persistence.PublicationPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the publication service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PublicationPersistence
 * @see PublicationUtil
 * @generated
 */
public class PublicationPersistenceImpl extends BasePersistenceImpl<Publication>
    implements PublicationPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link PublicationUtil} to access the publication persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = PublicationImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PublicationModelImpl.ENTITY_CACHE_ENABLED,
            PublicationModelImpl.FINDER_CACHE_ENABLED, PublicationImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PublicationModelImpl.ENTITY_CACHE_ENABLED,
            PublicationModelImpl.FINDER_CACHE_ENABLED, PublicationImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PublicationModelImpl.ENTITY_CACHE_ENABLED,
            PublicationModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(PublicationModelImpl.ENTITY_CACHE_ENABLED,
            PublicationModelImpl.FINDER_CACHE_ENABLED, PublicationImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
            new String[] {
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(PublicationModelImpl.ENTITY_CACHE_ENABLED,
            PublicationModelImpl.FINDER_CACHE_ENABLED, PublicationImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
            new String[] { String.class.getName() },
            PublicationModelImpl.UUID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(PublicationModelImpl.ENTITY_CACHE_ENABLED,
            PublicationModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_UUID_UUID_1 = "publication.uuid IS NULL";
    private static final String _FINDER_COLUMN_UUID_UUID_2 = "publication.uuid = ?";
    private static final String _FINDER_COLUMN_UUID_UUID_3 = "(publication.uuid IS NULL OR publication.uuid = '')";
    public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(PublicationModelImpl.ENTITY_CACHE_ENABLED,
            PublicationModelImpl.FINDER_CACHE_ENABLED, PublicationImpl.class,
            FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
            new String[] { String.class.getName(), Long.class.getName() },
            PublicationModelImpl.UUID_COLUMN_BITMASK |
            PublicationModelImpl.GROUPID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(PublicationModelImpl.ENTITY_CACHE_ENABLED,
            PublicationModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
            new String[] { String.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "publication.uuid IS NULL AND ";
    private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "publication.uuid = ? AND ";
    private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(publication.uuid IS NULL OR publication.uuid = '') AND ";
    private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "publication.groupId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(PublicationModelImpl.ENTITY_CACHE_ENABLED,
            PublicationModelImpl.FINDER_CACHE_ENABLED, PublicationImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
            new String[] {
                String.class.getName(), Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
        new FinderPath(PublicationModelImpl.ENTITY_CACHE_ENABLED,
            PublicationModelImpl.FINDER_CACHE_ENABLED, PublicationImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
            new String[] { String.class.getName(), Long.class.getName() },
            PublicationModelImpl.UUID_COLUMN_BITMASK |
            PublicationModelImpl.COMPANYID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(PublicationModelImpl.ENTITY_CACHE_ENABLED,
            PublicationModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
            new String[] { String.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "publication.uuid IS NULL AND ";
    private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "publication.uuid = ? AND ";
    private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(publication.uuid IS NULL OR publication.uuid = '') AND ";
    private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "publication.companyId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(PublicationModelImpl.ENTITY_CACHE_ENABLED,
            PublicationModelImpl.FINDER_CACHE_ENABLED, PublicationImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
        new FinderPath(PublicationModelImpl.ENTITY_CACHE_ENABLED,
            PublicationModelImpl.FINDER_CACHE_ENABLED, PublicationImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
            new String[] { Long.class.getName() },
            PublicationModelImpl.GROUPID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(PublicationModelImpl.ENTITY_CACHE_ENABLED,
            PublicationModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "publication.groupId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID =
        new FinderPath(PublicationModelImpl.ENTITY_CACHE_ENABLED,
            PublicationModelImpl.FINDER_CACHE_ENABLED, PublicationImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID =
        new FinderPath(PublicationModelImpl.ENTITY_CACHE_ENABLED,
            PublicationModelImpl.FINDER_CACHE_ENABLED, PublicationImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyId",
            new String[] { Long.class.getName() },
            PublicationModelImpl.COMPANYID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(PublicationModelImpl.ENTITY_CACHE_ENABLED,
            PublicationModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "publication.companyId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STRUCTUREID =
        new FinderPath(PublicationModelImpl.ENTITY_CACHE_ENABLED,
            PublicationModelImpl.FINDER_CACHE_ENABLED, PublicationImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStructureId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STRUCTUREID =
        new FinderPath(PublicationModelImpl.ENTITY_CACHE_ENABLED,
            PublicationModelImpl.FINDER_CACHE_ENABLED, PublicationImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStructureId",
            new String[] { Long.class.getName() },
            PublicationModelImpl.STRUCTUREID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_STRUCTUREID = new FinderPath(PublicationModelImpl.ENTITY_CACHE_ENABLED,
            PublicationModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStructureId",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_STRUCTUREID =
        new FinderPath(PublicationModelImpl.ENTITY_CACHE_ENABLED,
            PublicationModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByStructureId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_STRUCTUREID_STRUCTUREID_2 = "publication.structureId = ?";
    private static final String _FINDER_COLUMN_STRUCTUREID_STRUCTUREID_5 = "(" +
        removeConjunction(_FINDER_COLUMN_STRUCTUREID_STRUCTUREID_2) + ")";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TEMPLATEID =
        new FinderPath(PublicationModelImpl.ENTITY_CACHE_ENABLED,
            PublicationModelImpl.FINDER_CACHE_ENABLED, PublicationImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTemplateId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEMPLATEID =
        new FinderPath(PublicationModelImpl.ENTITY_CACHE_ENABLED,
            PublicationModelImpl.FINDER_CACHE_ENABLED, PublicationImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTemplateId",
            new String[] { Long.class.getName() },
            PublicationModelImpl.TEMPLATEID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_TEMPLATEID = new FinderPath(PublicationModelImpl.ENTITY_CACHE_ENABLED,
            PublicationModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTemplateId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_TEMPLATEID_TEMPLATEID_2 = "publication.templateId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_U = new FinderPath(PublicationModelImpl.ENTITY_CACHE_ENABLED,
            PublicationModelImpl.FINDER_CACHE_ENABLED, PublicationImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_U",
            new String[] {
                Long.class.getName(), Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_U = new FinderPath(PublicationModelImpl.ENTITY_CACHE_ENABLED,
            PublicationModelImpl.FINDER_CACHE_ENABLED, PublicationImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_U",
            new String[] { Long.class.getName(), Long.class.getName() },
            PublicationModelImpl.GROUPID_COLUMN_BITMASK |
            PublicationModelImpl.USERID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_G_U = new FinderPath(PublicationModelImpl.ENTITY_CACHE_ENABLED,
            PublicationModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_U",
            new String[] { Long.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_G_U_GROUPID_2 = "publication.groupId = ? AND ";
    private static final String _FINDER_COLUMN_G_U_USERID_2 = "publication.userId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_S = new FinderPath(PublicationModelImpl.ENTITY_CACHE_ENABLED,
            PublicationModelImpl.FINDER_CACHE_ENABLED, PublicationImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_S",
            new String[] {
                Long.class.getName(), Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_S = new FinderPath(PublicationModelImpl.ENTITY_CACHE_ENABLED,
            PublicationModelImpl.FINDER_CACHE_ENABLED, PublicationImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_S",
            new String[] { Long.class.getName(), Long.class.getName() },
            PublicationModelImpl.GROUPID_COLUMN_BITMASK |
            PublicationModelImpl.STRUCTUREID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_G_S = new FinderPath(PublicationModelImpl.ENTITY_CACHE_ENABLED,
            PublicationModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_S",
            new String[] { Long.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_G_S_GROUPID_2 = "publication.groupId = ? AND ";
    private static final String _FINDER_COLUMN_G_S_STRUCTUREID_2 = "publication.structureId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_T = new FinderPath(PublicationModelImpl.ENTITY_CACHE_ENABLED,
            PublicationModelImpl.FINDER_CACHE_ENABLED, PublicationImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_T",
            new String[] {
                Long.class.getName(), Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_T = new FinderPath(PublicationModelImpl.ENTITY_CACHE_ENABLED,
            PublicationModelImpl.FINDER_CACHE_ENABLED, PublicationImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_T",
            new String[] { Long.class.getName(), Long.class.getName() },
            PublicationModelImpl.GROUPID_COLUMN_BITMASK |
            PublicationModelImpl.TEMPLATEID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_G_T = new FinderPath(PublicationModelImpl.ENTITY_CACHE_ENABLED,
            PublicationModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_T",
            new String[] { Long.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_G_T_GROUPID_2 = "publication.groupId = ? AND ";
    private static final String _FINDER_COLUMN_G_T_TEMPLATEID_2 = "publication.templateId = ?";
    private static final String _SQL_SELECT_PUBLICATION = "SELECT publication FROM Publication publication";
    private static final String _SQL_SELECT_PUBLICATION_WHERE = "SELECT publication FROM Publication publication WHERE ";
    private static final String _SQL_COUNT_PUBLICATION = "SELECT COUNT(publication) FROM Publication publication";
    private static final String _SQL_COUNT_PUBLICATION_WHERE = "SELECT COUNT(publication) FROM Publication publication WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "publication.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Publication exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Publication exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(PublicationPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "uuid", "id"
            });
    private static Publication _nullPublication = new PublicationImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Publication> toCacheModel() {
                return _nullPublicationCacheModel;
            }
        };

    private static CacheModel<Publication> _nullPublicationCacheModel = new CacheModel<Publication>() {
            @Override
            public Publication toEntityModel() {
                return _nullPublication;
            }
        };

    public PublicationPersistenceImpl() {
        setModelClass(Publication.class);
    }

    /**
     * Returns all the publications where uuid = &#63;.
     *
     * @param uuid the uuid
     * @return the matching publications
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Publication> findByUuid(String uuid) throws SystemException {
        return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    @Override
    public List<Publication> findByUuid(String uuid, int start, int end)
        throws SystemException {
        return findByUuid(uuid, start, end, null);
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
    @Override
    public List<Publication> findByUuid(String uuid, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
            finderArgs = new Object[] { uuid };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
            finderArgs = new Object[] { uuid, start, end, orderByComparator };
        }

        List<Publication> list = (List<Publication>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Publication publication : list) {
                if (!Validator.equals(uuid, publication.getUuid())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_PUBLICATION_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_UUID_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(PublicationModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

                if (!pagination) {
                    list = (List<Publication>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Publication>(list);
                } else {
                    list = (List<Publication>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
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
    @Override
    public Publication findByUuid_First(String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchPublicationException, SystemException {
        Publication publication = fetchByUuid_First(uuid, orderByComparator);

        if (publication != null) {
            return publication;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchPublicationException(msg.toString());
    }

    /**
     * Returns the first publication in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching publication, or <code>null</code> if a matching publication could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Publication fetchByUuid_First(String uuid,
        OrderByComparator orderByComparator) throws SystemException {
        List<Publication> list = findByUuid(uuid, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Publication findByUuid_Last(String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchPublicationException, SystemException {
        Publication publication = fetchByUuid_Last(uuid, orderByComparator);

        if (publication != null) {
            return publication;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchPublicationException(msg.toString());
    }

    /**
     * Returns the last publication in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching publication, or <code>null</code> if a matching publication could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Publication fetchByUuid_Last(String uuid,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUuid(uuid);

        if (count == 0) {
            return null;
        }

        List<Publication> list = findByUuid(uuid, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Publication[] findByUuid_PrevAndNext(long id, String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchPublicationException, SystemException {
        Publication publication = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            Publication[] array = new PublicationImpl[3];

            array[0] = getByUuid_PrevAndNext(session, publication, uuid,
                    orderByComparator, true);

            array[1] = publication;

            array[2] = getByUuid_PrevAndNext(session, publication, uuid,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Publication getByUuid_PrevAndNext(Session session,
        Publication publication, String uuid,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_PUBLICATION_WHERE);

        boolean bindUuid = false;

        if (uuid == null) {
            query.append(_FINDER_COLUMN_UUID_UUID_1);
        } else if (uuid.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_UUID_UUID_3);
        } else {
            bindUuid = true;

            query.append(_FINDER_COLUMN_UUID_UUID_2);
        }

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(PublicationModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindUuid) {
            qPos.add(uuid);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(publication);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Publication> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the publications where uuid = &#63; from the database.
     *
     * @param uuid the uuid
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByUuid(String uuid) throws SystemException {
        for (Publication publication : findByUuid(uuid, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(publication);
        }
    }

    /**
     * Returns the number of publications where uuid = &#63;.
     *
     * @param uuid the uuid
     * @return the number of matching publications
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByUuid(String uuid) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

        Object[] finderArgs = new Object[] { uuid };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_PUBLICATION_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_UUID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
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
    @Override
    public Publication findByUUID_G(String uuid, long groupId)
        throws NoSuchPublicationException, SystemException {
        Publication publication = fetchByUUID_G(uuid, groupId);

        if (publication == null) {
            StringBundler msg = new StringBundler(6);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("uuid=");
            msg.append(uuid);

            msg.append(", groupId=");
            msg.append(groupId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchPublicationException(msg.toString());
        }

        return publication;
    }

    /**
     * Returns the publication where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the matching publication, or <code>null</code> if a matching publication could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Publication fetchByUUID_G(String uuid, long groupId)
        throws SystemException {
        return fetchByUUID_G(uuid, groupId, true);
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
    @Override
    public Publication fetchByUUID_G(String uuid, long groupId,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { uuid, groupId };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
                    finderArgs, this);
        }

        if (result instanceof Publication) {
            Publication publication = (Publication) result;

            if (!Validator.equals(uuid, publication.getUuid()) ||
                    (groupId != publication.getGroupId())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_SELECT_PUBLICATION_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_G_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_G_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_G_UUID_2);
            }

            query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

                qPos.add(groupId);

                List<Publication> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
                        finderArgs, list);
                } else {
                    Publication publication = list.get(0);

                    result = publication;

                    cacheResult(publication);

                    if ((publication.getUuid() == null) ||
                            !publication.getUuid().equals(uuid) ||
                            (publication.getGroupId() != groupId)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
                            finderArgs, publication);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (Publication) result;
        }
    }

    /**
     * Removes the publication where uuid = &#63; and groupId = &#63; from the database.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the publication that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Publication removeByUUID_G(String uuid, long groupId)
        throws NoSuchPublicationException, SystemException {
        Publication publication = findByUUID_G(uuid, groupId);

        return remove(publication);
    }

    /**
     * Returns the number of publications where uuid = &#63; and groupId = &#63;.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the number of matching publications
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByUUID_G(String uuid, long groupId)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

        Object[] finderArgs = new Object[] { uuid, groupId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_PUBLICATION_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_G_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_G_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_G_UUID_2);
            }

            query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

                qPos.add(groupId);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the publications where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @return the matching publications
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Publication> findByUuid_C(String uuid, long companyId)
        throws SystemException {
        return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
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
    @Override
    public List<Publication> findByUuid_C(String uuid, long companyId,
        int start, int end) throws SystemException {
        return findByUuid_C(uuid, companyId, start, end, null);
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
    @Override
    public List<Publication> findByUuid_C(String uuid, long companyId,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C;
            finderArgs = new Object[] { uuid, companyId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C;
            finderArgs = new Object[] {
                    uuid, companyId,
                    
                    start, end, orderByComparator
                };
        }

        List<Publication> list = (List<Publication>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Publication publication : list) {
                if (!Validator.equals(uuid, publication.getUuid()) ||
                        (companyId != publication.getCompanyId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(4 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(4);
            }

            query.append(_SQL_SELECT_PUBLICATION_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_C_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_C_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_C_UUID_2);
            }

            query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(PublicationModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

                qPos.add(companyId);

                if (!pagination) {
                    list = (List<Publication>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Publication>(list);
                } else {
                    list = (List<Publication>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
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
    @Override
    public Publication findByUuid_C_First(String uuid, long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchPublicationException, SystemException {
        Publication publication = fetchByUuid_C_First(uuid, companyId,
                orderByComparator);

        if (publication != null) {
            return publication;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(", companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchPublicationException(msg.toString());
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
    @Override
    public Publication fetchByUuid_C_First(String uuid, long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Publication> list = findByUuid_C(uuid, companyId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Publication findByUuid_C_Last(String uuid, long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchPublicationException, SystemException {
        Publication publication = fetchByUuid_C_Last(uuid, companyId,
                orderByComparator);

        if (publication != null) {
            return publication;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(", companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchPublicationException(msg.toString());
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
    @Override
    public Publication fetchByUuid_C_Last(String uuid, long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUuid_C(uuid, companyId);

        if (count == 0) {
            return null;
        }

        List<Publication> list = findByUuid_C(uuid, companyId, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Publication[] findByUuid_C_PrevAndNext(long id, String uuid,
        long companyId, OrderByComparator orderByComparator)
        throws NoSuchPublicationException, SystemException {
        Publication publication = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            Publication[] array = new PublicationImpl[3];

            array[0] = getByUuid_C_PrevAndNext(session, publication, uuid,
                    companyId, orderByComparator, true);

            array[1] = publication;

            array[2] = getByUuid_C_PrevAndNext(session, publication, uuid,
                    companyId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Publication getByUuid_C_PrevAndNext(Session session,
        Publication publication, String uuid, long companyId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_PUBLICATION_WHERE);

        boolean bindUuid = false;

        if (uuid == null) {
            query.append(_FINDER_COLUMN_UUID_C_UUID_1);
        } else if (uuid.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_UUID_C_UUID_3);
        } else {
            bindUuid = true;

            query.append(_FINDER_COLUMN_UUID_C_UUID_2);
        }

        query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(PublicationModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindUuid) {
            qPos.add(uuid);
        }

        qPos.add(companyId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(publication);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Publication> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the publications where uuid = &#63; and companyId = &#63; from the database.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByUuid_C(String uuid, long companyId)
        throws SystemException {
        for (Publication publication : findByUuid_C(uuid, companyId,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(publication);
        }
    }

    /**
     * Returns the number of publications where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @return the number of matching publications
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByUuid_C(String uuid, long companyId)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

        Object[] finderArgs = new Object[] { uuid, companyId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_PUBLICATION_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_C_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_C_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_C_UUID_2);
            }

            query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

                qPos.add(companyId);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the publications where groupId = &#63;.
     *
     * @param groupId the group ID
     * @return the matching publications
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Publication> findByGroupId(long groupId)
        throws SystemException {
        return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    @Override
    public List<Publication> findByGroupId(long groupId, int start, int end)
        throws SystemException {
        return findByGroupId(groupId, start, end, null);
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
    @Override
    public List<Publication> findByGroupId(long groupId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
            finderArgs = new Object[] { groupId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
            finderArgs = new Object[] { groupId, start, end, orderByComparator };
        }

        List<Publication> list = (List<Publication>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Publication publication : list) {
                if ((groupId != publication.getGroupId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_PUBLICATION_WHERE);

            query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(PublicationModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                if (!pagination) {
                    list = (List<Publication>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Publication>(list);
                } else {
                    list = (List<Publication>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
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
    @Override
    public Publication findByGroupId_First(long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchPublicationException, SystemException {
        Publication publication = fetchByGroupId_First(groupId,
                orderByComparator);

        if (publication != null) {
            return publication;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchPublicationException(msg.toString());
    }

    /**
     * Returns the first publication in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching publication, or <code>null</code> if a matching publication could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Publication fetchByGroupId_First(long groupId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Publication> list = findByGroupId(groupId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Publication findByGroupId_Last(long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchPublicationException, SystemException {
        Publication publication = fetchByGroupId_Last(groupId, orderByComparator);

        if (publication != null) {
            return publication;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchPublicationException(msg.toString());
    }

    /**
     * Returns the last publication in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching publication, or <code>null</code> if a matching publication could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Publication fetchByGroupId_Last(long groupId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByGroupId(groupId);

        if (count == 0) {
            return null;
        }

        List<Publication> list = findByGroupId(groupId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Publication[] findByGroupId_PrevAndNext(long id, long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchPublicationException, SystemException {
        Publication publication = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            Publication[] array = new PublicationImpl[3];

            array[0] = getByGroupId_PrevAndNext(session, publication, groupId,
                    orderByComparator, true);

            array[1] = publication;

            array[2] = getByGroupId_PrevAndNext(session, publication, groupId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Publication getByGroupId_PrevAndNext(Session session,
        Publication publication, long groupId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_PUBLICATION_WHERE);

        query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(PublicationModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(groupId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(publication);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Publication> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the publications where groupId = &#63; from the database.
     *
     * @param groupId the group ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByGroupId(long groupId) throws SystemException {
        for (Publication publication : findByGroupId(groupId,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(publication);
        }
    }

    /**
     * Returns the number of publications where groupId = &#63;.
     *
     * @param groupId the group ID
     * @return the number of matching publications
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByGroupId(long groupId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID;

        Object[] finderArgs = new Object[] { groupId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_PUBLICATION_WHERE);

            query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the publications where companyId = &#63;.
     *
     * @param companyId the company ID
     * @return the matching publications
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Publication> findByCompanyId(long companyId)
        throws SystemException {
        return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
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
    @Override
    public List<Publication> findByCompanyId(long companyId, int start, int end)
        throws SystemException {
        return findByCompanyId(companyId, start, end, null);
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
    @Override
    public List<Publication> findByCompanyId(long companyId, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID;
            finderArgs = new Object[] { companyId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID;
            finderArgs = new Object[] { companyId, start, end, orderByComparator };
        }

        List<Publication> list = (List<Publication>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Publication publication : list) {
                if ((companyId != publication.getCompanyId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_PUBLICATION_WHERE);

            query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(PublicationModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                if (!pagination) {
                    list = (List<Publication>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Publication>(list);
                } else {
                    list = (List<Publication>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
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
    @Override
    public Publication findByCompanyId_First(long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchPublicationException, SystemException {
        Publication publication = fetchByCompanyId_First(companyId,
                orderByComparator);

        if (publication != null) {
            return publication;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchPublicationException(msg.toString());
    }

    /**
     * Returns the first publication in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching publication, or <code>null</code> if a matching publication could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Publication fetchByCompanyId_First(long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Publication> list = findByCompanyId(companyId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Publication findByCompanyId_Last(long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchPublicationException, SystemException {
        Publication publication = fetchByCompanyId_Last(companyId,
                orderByComparator);

        if (publication != null) {
            return publication;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchPublicationException(msg.toString());
    }

    /**
     * Returns the last publication in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching publication, or <code>null</code> if a matching publication could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Publication fetchByCompanyId_Last(long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByCompanyId(companyId);

        if (count == 0) {
            return null;
        }

        List<Publication> list = findByCompanyId(companyId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Publication[] findByCompanyId_PrevAndNext(long id, long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchPublicationException, SystemException {
        Publication publication = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            Publication[] array = new PublicationImpl[3];

            array[0] = getByCompanyId_PrevAndNext(session, publication,
                    companyId, orderByComparator, true);

            array[1] = publication;

            array[2] = getByCompanyId_PrevAndNext(session, publication,
                    companyId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Publication getByCompanyId_PrevAndNext(Session session,
        Publication publication, long companyId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_PUBLICATION_WHERE);

        query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(PublicationModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(companyId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(publication);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Publication> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the publications where companyId = &#63; from the database.
     *
     * @param companyId the company ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByCompanyId(long companyId) throws SystemException {
        for (Publication publication : findByCompanyId(companyId,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(publication);
        }
    }

    /**
     * Returns the number of publications where companyId = &#63;.
     *
     * @param companyId the company ID
     * @return the number of matching publications
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByCompanyId(long companyId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_COMPANYID;

        Object[] finderArgs = new Object[] { companyId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_PUBLICATION_WHERE);

            query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the publications where structureId = &#63;.
     *
     * @param structureId the structure ID
     * @return the matching publications
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Publication> findByStructureId(long structureId)
        throws SystemException {
        return findByStructureId(structureId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
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
    @Override
    public List<Publication> findByStructureId(long structureId, int start,
        int end) throws SystemException {
        return findByStructureId(structureId, start, end, null);
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
    @Override
    public List<Publication> findByStructureId(long structureId, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STRUCTUREID;
            finderArgs = new Object[] { structureId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STRUCTUREID;
            finderArgs = new Object[] { structureId, start, end, orderByComparator };
        }

        List<Publication> list = (List<Publication>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Publication publication : list) {
                if ((structureId != publication.getStructureId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_PUBLICATION_WHERE);

            query.append(_FINDER_COLUMN_STRUCTUREID_STRUCTUREID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(PublicationModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(structureId);

                if (!pagination) {
                    list = (List<Publication>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Publication>(list);
                } else {
                    list = (List<Publication>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
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
    @Override
    public Publication findByStructureId_First(long structureId,
        OrderByComparator orderByComparator)
        throws NoSuchPublicationException, SystemException {
        Publication publication = fetchByStructureId_First(structureId,
                orderByComparator);

        if (publication != null) {
            return publication;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("structureId=");
        msg.append(structureId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchPublicationException(msg.toString());
    }

    /**
     * Returns the first publication in the ordered set where structureId = &#63;.
     *
     * @param structureId the structure ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching publication, or <code>null</code> if a matching publication could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Publication fetchByStructureId_First(long structureId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Publication> list = findByStructureId(structureId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Publication findByStructureId_Last(long structureId,
        OrderByComparator orderByComparator)
        throws NoSuchPublicationException, SystemException {
        Publication publication = fetchByStructureId_Last(structureId,
                orderByComparator);

        if (publication != null) {
            return publication;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("structureId=");
        msg.append(structureId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchPublicationException(msg.toString());
    }

    /**
     * Returns the last publication in the ordered set where structureId = &#63;.
     *
     * @param structureId the structure ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching publication, or <code>null</code> if a matching publication could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Publication fetchByStructureId_Last(long structureId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByStructureId(structureId);

        if (count == 0) {
            return null;
        }

        List<Publication> list = findByStructureId(structureId, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Publication[] findByStructureId_PrevAndNext(long id,
        long structureId, OrderByComparator orderByComparator)
        throws NoSuchPublicationException, SystemException {
        Publication publication = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            Publication[] array = new PublicationImpl[3];

            array[0] = getByStructureId_PrevAndNext(session, publication,
                    structureId, orderByComparator, true);

            array[1] = publication;

            array[2] = getByStructureId_PrevAndNext(session, publication,
                    structureId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Publication getByStructureId_PrevAndNext(Session session,
        Publication publication, long structureId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_PUBLICATION_WHERE);

        query.append(_FINDER_COLUMN_STRUCTUREID_STRUCTUREID_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(PublicationModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(structureId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(publication);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Publication> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
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
    @Override
    public List<Publication> findByStructureId(long[] structureIds)
        throws SystemException {
        return findByStructureId(structureIds, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
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
    @Override
    public List<Publication> findByStructureId(long[] structureIds, int start,
        int end) throws SystemException {
        return findByStructureId(structureIds, start, end, null);
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
    @Override
    public List<Publication> findByStructureId(long[] structureIds, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        if ((structureIds != null) && (structureIds.length == 1)) {
            return findByStructureId(structureIds[0], start, end,
                orderByComparator);
        }

        boolean pagination = true;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderArgs = new Object[] { StringUtil.merge(structureIds) };
        } else {
            finderArgs = new Object[] {
                    StringUtil.merge(structureIds),
                    
                    start, end, orderByComparator
                };
        }

        List<Publication> list = (List<Publication>) FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_STRUCTUREID,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Publication publication : list) {
                if (!ArrayUtil.contains(structureIds,
                            publication.getStructureId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = new StringBundler();

            query.append(_SQL_SELECT_PUBLICATION_WHERE);

            boolean conjunctionable = false;

            if ((structureIds == null) || (structureIds.length > 0)) {
                if (conjunctionable) {
                    query.append(WHERE_AND);
                }

                query.append(StringPool.OPEN_PARENTHESIS);

                for (int i = 0; i < structureIds.length; i++) {
                    query.append(_FINDER_COLUMN_STRUCTUREID_STRUCTUREID_5);

                    if ((i + 1) < structureIds.length) {
                        query.append(WHERE_OR);
                    }
                }

                query.append(StringPool.CLOSE_PARENTHESIS);

                conjunctionable = true;
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(PublicationModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (structureIds != null) {
                    qPos.add(structureIds);
                }

                if (!pagination) {
                    list = (List<Publication>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Publication>(list);
                } else {
                    list = (List<Publication>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_STRUCTUREID,
                    finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_STRUCTUREID,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the publications where structureId = &#63; from the database.
     *
     * @param structureId the structure ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByStructureId(long structureId) throws SystemException {
        for (Publication publication : findByStructureId(structureId,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(publication);
        }
    }

    /**
     * Returns the number of publications where structureId = &#63;.
     *
     * @param structureId the structure ID
     * @return the number of matching publications
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByStructureId(long structureId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_STRUCTUREID;

        Object[] finderArgs = new Object[] { structureId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_PUBLICATION_WHERE);

            query.append(_FINDER_COLUMN_STRUCTUREID_STRUCTUREID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(structureId);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of publications where structureId = any &#63;.
     *
     * @param structureIds the structure IDs
     * @return the number of matching publications
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByStructureId(long[] structureIds)
        throws SystemException {
        Object[] finderArgs = new Object[] { StringUtil.merge(structureIds) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_STRUCTUREID,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler();

            query.append(_SQL_COUNT_PUBLICATION_WHERE);

            boolean conjunctionable = false;

            if ((structureIds == null) || (structureIds.length > 0)) {
                if (conjunctionable) {
                    query.append(WHERE_AND);
                }

                query.append(StringPool.OPEN_PARENTHESIS);

                for (int i = 0; i < structureIds.length; i++) {
                    query.append(_FINDER_COLUMN_STRUCTUREID_STRUCTUREID_5);

                    if ((i + 1) < structureIds.length) {
                        query.append(WHERE_OR);
                    }
                }

                query.append(StringPool.CLOSE_PARENTHESIS);

                conjunctionable = true;
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (structureIds != null) {
                    qPos.add(structureIds);
                }

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_STRUCTUREID,
                    finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_STRUCTUREID,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the publications where templateId = &#63;.
     *
     * @param templateId the template ID
     * @return the matching publications
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Publication> findByTemplateId(long templateId)
        throws SystemException {
        return findByTemplateId(templateId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
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
    @Override
    public List<Publication> findByTemplateId(long templateId, int start,
        int end) throws SystemException {
        return findByTemplateId(templateId, start, end, null);
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
    @Override
    public List<Publication> findByTemplateId(long templateId, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEMPLATEID;
            finderArgs = new Object[] { templateId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TEMPLATEID;
            finderArgs = new Object[] { templateId, start, end, orderByComparator };
        }

        List<Publication> list = (List<Publication>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Publication publication : list) {
                if ((templateId != publication.getTemplateId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_PUBLICATION_WHERE);

            query.append(_FINDER_COLUMN_TEMPLATEID_TEMPLATEID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(PublicationModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(templateId);

                if (!pagination) {
                    list = (List<Publication>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Publication>(list);
                } else {
                    list = (List<Publication>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
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
    @Override
    public Publication findByTemplateId_First(long templateId,
        OrderByComparator orderByComparator)
        throws NoSuchPublicationException, SystemException {
        Publication publication = fetchByTemplateId_First(templateId,
                orderByComparator);

        if (publication != null) {
            return publication;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("templateId=");
        msg.append(templateId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchPublicationException(msg.toString());
    }

    /**
     * Returns the first publication in the ordered set where templateId = &#63;.
     *
     * @param templateId the template ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching publication, or <code>null</code> if a matching publication could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Publication fetchByTemplateId_First(long templateId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Publication> list = findByTemplateId(templateId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Publication findByTemplateId_Last(long templateId,
        OrderByComparator orderByComparator)
        throws NoSuchPublicationException, SystemException {
        Publication publication = fetchByTemplateId_Last(templateId,
                orderByComparator);

        if (publication != null) {
            return publication;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("templateId=");
        msg.append(templateId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchPublicationException(msg.toString());
    }

    /**
     * Returns the last publication in the ordered set where templateId = &#63;.
     *
     * @param templateId the template ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching publication, or <code>null</code> if a matching publication could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Publication fetchByTemplateId_Last(long templateId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByTemplateId(templateId);

        if (count == 0) {
            return null;
        }

        List<Publication> list = findByTemplateId(templateId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Publication[] findByTemplateId_PrevAndNext(long id, long templateId,
        OrderByComparator orderByComparator)
        throws NoSuchPublicationException, SystemException {
        Publication publication = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            Publication[] array = new PublicationImpl[3];

            array[0] = getByTemplateId_PrevAndNext(session, publication,
                    templateId, orderByComparator, true);

            array[1] = publication;

            array[2] = getByTemplateId_PrevAndNext(session, publication,
                    templateId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Publication getByTemplateId_PrevAndNext(Session session,
        Publication publication, long templateId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_PUBLICATION_WHERE);

        query.append(_FINDER_COLUMN_TEMPLATEID_TEMPLATEID_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(PublicationModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(templateId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(publication);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Publication> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the publications where templateId = &#63; from the database.
     *
     * @param templateId the template ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByTemplateId(long templateId) throws SystemException {
        for (Publication publication : findByTemplateId(templateId,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(publication);
        }
    }

    /**
     * Returns the number of publications where templateId = &#63;.
     *
     * @param templateId the template ID
     * @return the number of matching publications
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByTemplateId(long templateId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_TEMPLATEID;

        Object[] finderArgs = new Object[] { templateId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_PUBLICATION_WHERE);

            query.append(_FINDER_COLUMN_TEMPLATEID_TEMPLATEID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(templateId);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the publications where groupId = &#63; and userId = &#63;.
     *
     * @param groupId the group ID
     * @param userId the user ID
     * @return the matching publications
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Publication> findByG_U(long groupId, long userId)
        throws SystemException {
        return findByG_U(groupId, userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
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
    @Override
    public List<Publication> findByG_U(long groupId, long userId, int start,
        int end) throws SystemException {
        return findByG_U(groupId, userId, start, end, null);
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
    @Override
    public List<Publication> findByG_U(long groupId, long userId, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_U;
            finderArgs = new Object[] { groupId, userId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_U;
            finderArgs = new Object[] {
                    groupId, userId,
                    
                    start, end, orderByComparator
                };
        }

        List<Publication> list = (List<Publication>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Publication publication : list) {
                if ((groupId != publication.getGroupId()) ||
                        (userId != publication.getUserId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(4 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(4);
            }

            query.append(_SQL_SELECT_PUBLICATION_WHERE);

            query.append(_FINDER_COLUMN_G_U_GROUPID_2);

            query.append(_FINDER_COLUMN_G_U_USERID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(PublicationModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                qPos.add(userId);

                if (!pagination) {
                    list = (List<Publication>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Publication>(list);
                } else {
                    list = (List<Publication>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
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
    @Override
    public Publication findByG_U_First(long groupId, long userId,
        OrderByComparator orderByComparator)
        throws NoSuchPublicationException, SystemException {
        Publication publication = fetchByG_U_First(groupId, userId,
                orderByComparator);

        if (publication != null) {
            return publication;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("groupId=");
        msg.append(groupId);

        msg.append(", userId=");
        msg.append(userId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchPublicationException(msg.toString());
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
    @Override
    public Publication fetchByG_U_First(long groupId, long userId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Publication> list = findByG_U(groupId, userId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Publication findByG_U_Last(long groupId, long userId,
        OrderByComparator orderByComparator)
        throws NoSuchPublicationException, SystemException {
        Publication publication = fetchByG_U_Last(groupId, userId,
                orderByComparator);

        if (publication != null) {
            return publication;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("groupId=");
        msg.append(groupId);

        msg.append(", userId=");
        msg.append(userId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchPublicationException(msg.toString());
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
    @Override
    public Publication fetchByG_U_Last(long groupId, long userId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByG_U(groupId, userId);

        if (count == 0) {
            return null;
        }

        List<Publication> list = findByG_U(groupId, userId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Publication[] findByG_U_PrevAndNext(long id, long groupId,
        long userId, OrderByComparator orderByComparator)
        throws NoSuchPublicationException, SystemException {
        Publication publication = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            Publication[] array = new PublicationImpl[3];

            array[0] = getByG_U_PrevAndNext(session, publication, groupId,
                    userId, orderByComparator, true);

            array[1] = publication;

            array[2] = getByG_U_PrevAndNext(session, publication, groupId,
                    userId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Publication getByG_U_PrevAndNext(Session session,
        Publication publication, long groupId, long userId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_PUBLICATION_WHERE);

        query.append(_FINDER_COLUMN_G_U_GROUPID_2);

        query.append(_FINDER_COLUMN_G_U_USERID_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(PublicationModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(groupId);

        qPos.add(userId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(publication);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Publication> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the publications where groupId = &#63; and userId = &#63; from the database.
     *
     * @param groupId the group ID
     * @param userId the user ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByG_U(long groupId, long userId)
        throws SystemException {
        for (Publication publication : findByG_U(groupId, userId,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(publication);
        }
    }

    /**
     * Returns the number of publications where groupId = &#63; and userId = &#63;.
     *
     * @param groupId the group ID
     * @param userId the user ID
     * @return the number of matching publications
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByG_U(long groupId, long userId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_G_U;

        Object[] finderArgs = new Object[] { groupId, userId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_PUBLICATION_WHERE);

            query.append(_FINDER_COLUMN_G_U_GROUPID_2);

            query.append(_FINDER_COLUMN_G_U_USERID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                qPos.add(userId);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the publications where groupId = &#63; and structureId = &#63;.
     *
     * @param groupId the group ID
     * @param structureId the structure ID
     * @return the matching publications
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Publication> findByG_S(long groupId, long structureId)
        throws SystemException {
        return findByG_S(groupId, structureId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
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
    @Override
    public List<Publication> findByG_S(long groupId, long structureId,
        int start, int end) throws SystemException {
        return findByG_S(groupId, structureId, start, end, null);
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
    @Override
    public List<Publication> findByG_S(long groupId, long structureId,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_S;
            finderArgs = new Object[] { groupId, structureId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_S;
            finderArgs = new Object[] {
                    groupId, structureId,
                    
                    start, end, orderByComparator
                };
        }

        List<Publication> list = (List<Publication>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Publication publication : list) {
                if ((groupId != publication.getGroupId()) ||
                        (structureId != publication.getStructureId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(4 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(4);
            }

            query.append(_SQL_SELECT_PUBLICATION_WHERE);

            query.append(_FINDER_COLUMN_G_S_GROUPID_2);

            query.append(_FINDER_COLUMN_G_S_STRUCTUREID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(PublicationModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                qPos.add(structureId);

                if (!pagination) {
                    list = (List<Publication>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Publication>(list);
                } else {
                    list = (List<Publication>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
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
    @Override
    public Publication findByG_S_First(long groupId, long structureId,
        OrderByComparator orderByComparator)
        throws NoSuchPublicationException, SystemException {
        Publication publication = fetchByG_S_First(groupId, structureId,
                orderByComparator);

        if (publication != null) {
            return publication;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("groupId=");
        msg.append(groupId);

        msg.append(", structureId=");
        msg.append(structureId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchPublicationException(msg.toString());
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
    @Override
    public Publication fetchByG_S_First(long groupId, long structureId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Publication> list = findByG_S(groupId, structureId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Publication findByG_S_Last(long groupId, long structureId,
        OrderByComparator orderByComparator)
        throws NoSuchPublicationException, SystemException {
        Publication publication = fetchByG_S_Last(groupId, structureId,
                orderByComparator);

        if (publication != null) {
            return publication;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("groupId=");
        msg.append(groupId);

        msg.append(", structureId=");
        msg.append(structureId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchPublicationException(msg.toString());
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
    @Override
    public Publication fetchByG_S_Last(long groupId, long structureId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByG_S(groupId, structureId);

        if (count == 0) {
            return null;
        }

        List<Publication> list = findByG_S(groupId, structureId, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Publication[] findByG_S_PrevAndNext(long id, long groupId,
        long structureId, OrderByComparator orderByComparator)
        throws NoSuchPublicationException, SystemException {
        Publication publication = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            Publication[] array = new PublicationImpl[3];

            array[0] = getByG_S_PrevAndNext(session, publication, groupId,
                    structureId, orderByComparator, true);

            array[1] = publication;

            array[2] = getByG_S_PrevAndNext(session, publication, groupId,
                    structureId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Publication getByG_S_PrevAndNext(Session session,
        Publication publication, long groupId, long structureId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_PUBLICATION_WHERE);

        query.append(_FINDER_COLUMN_G_S_GROUPID_2);

        query.append(_FINDER_COLUMN_G_S_STRUCTUREID_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(PublicationModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(groupId);

        qPos.add(structureId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(publication);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Publication> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the publications where groupId = &#63; and structureId = &#63; from the database.
     *
     * @param groupId the group ID
     * @param structureId the structure ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByG_S(long groupId, long structureId)
        throws SystemException {
        for (Publication publication : findByG_S(groupId, structureId,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(publication);
        }
    }

    /**
     * Returns the number of publications where groupId = &#63; and structureId = &#63;.
     *
     * @param groupId the group ID
     * @param structureId the structure ID
     * @return the number of matching publications
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByG_S(long groupId, long structureId)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_G_S;

        Object[] finderArgs = new Object[] { groupId, structureId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_PUBLICATION_WHERE);

            query.append(_FINDER_COLUMN_G_S_GROUPID_2);

            query.append(_FINDER_COLUMN_G_S_STRUCTUREID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                qPos.add(structureId);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the publications where groupId = &#63; and templateId = &#63;.
     *
     * @param groupId the group ID
     * @param templateId the template ID
     * @return the matching publications
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Publication> findByG_T(long groupId, long templateId)
        throws SystemException {
        return findByG_T(groupId, templateId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
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
    @Override
    public List<Publication> findByG_T(long groupId, long templateId,
        int start, int end) throws SystemException {
        return findByG_T(groupId, templateId, start, end, null);
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
    @Override
    public List<Publication> findByG_T(long groupId, long templateId,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_T;
            finderArgs = new Object[] { groupId, templateId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_T;
            finderArgs = new Object[] {
                    groupId, templateId,
                    
                    start, end, orderByComparator
                };
        }

        List<Publication> list = (List<Publication>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Publication publication : list) {
                if ((groupId != publication.getGroupId()) ||
                        (templateId != publication.getTemplateId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(4 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(4);
            }

            query.append(_SQL_SELECT_PUBLICATION_WHERE);

            query.append(_FINDER_COLUMN_G_T_GROUPID_2);

            query.append(_FINDER_COLUMN_G_T_TEMPLATEID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(PublicationModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                qPos.add(templateId);

                if (!pagination) {
                    list = (List<Publication>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Publication>(list);
                } else {
                    list = (List<Publication>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
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
    @Override
    public Publication findByG_T_First(long groupId, long templateId,
        OrderByComparator orderByComparator)
        throws NoSuchPublicationException, SystemException {
        Publication publication = fetchByG_T_First(groupId, templateId,
                orderByComparator);

        if (publication != null) {
            return publication;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("groupId=");
        msg.append(groupId);

        msg.append(", templateId=");
        msg.append(templateId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchPublicationException(msg.toString());
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
    @Override
    public Publication fetchByG_T_First(long groupId, long templateId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Publication> list = findByG_T(groupId, templateId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Publication findByG_T_Last(long groupId, long templateId,
        OrderByComparator orderByComparator)
        throws NoSuchPublicationException, SystemException {
        Publication publication = fetchByG_T_Last(groupId, templateId,
                orderByComparator);

        if (publication != null) {
            return publication;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("groupId=");
        msg.append(groupId);

        msg.append(", templateId=");
        msg.append(templateId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchPublicationException(msg.toString());
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
    @Override
    public Publication fetchByG_T_Last(long groupId, long templateId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByG_T(groupId, templateId);

        if (count == 0) {
            return null;
        }

        List<Publication> list = findByG_T(groupId, templateId, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Publication[] findByG_T_PrevAndNext(long id, long groupId,
        long templateId, OrderByComparator orderByComparator)
        throws NoSuchPublicationException, SystemException {
        Publication publication = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            Publication[] array = new PublicationImpl[3];

            array[0] = getByG_T_PrevAndNext(session, publication, groupId,
                    templateId, orderByComparator, true);

            array[1] = publication;

            array[2] = getByG_T_PrevAndNext(session, publication, groupId,
                    templateId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Publication getByG_T_PrevAndNext(Session session,
        Publication publication, long groupId, long templateId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_PUBLICATION_WHERE);

        query.append(_FINDER_COLUMN_G_T_GROUPID_2);

        query.append(_FINDER_COLUMN_G_T_TEMPLATEID_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(PublicationModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(groupId);

        qPos.add(templateId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(publication);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Publication> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the publications where groupId = &#63; and templateId = &#63; from the database.
     *
     * @param groupId the group ID
     * @param templateId the template ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByG_T(long groupId, long templateId)
        throws SystemException {
        for (Publication publication : findByG_T(groupId, templateId,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(publication);
        }
    }

    /**
     * Returns the number of publications where groupId = &#63; and templateId = &#63;.
     *
     * @param groupId the group ID
     * @param templateId the template ID
     * @return the number of matching publications
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByG_T(long groupId, long templateId)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_G_T;

        Object[] finderArgs = new Object[] { groupId, templateId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_PUBLICATION_WHERE);

            query.append(_FINDER_COLUMN_G_T_GROUPID_2);

            query.append(_FINDER_COLUMN_G_T_TEMPLATEID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                qPos.add(templateId);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Caches the publication in the entity cache if it is enabled.
     *
     * @param publication the publication
     */
    @Override
    public void cacheResult(Publication publication) {
        EntityCacheUtil.putResult(PublicationModelImpl.ENTITY_CACHE_ENABLED,
            PublicationImpl.class, publication.getPrimaryKey(), publication);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
            new Object[] { publication.getUuid(), publication.getGroupId() },
            publication);

        publication.resetOriginalValues();
    }

    /**
     * Caches the publications in the entity cache if it is enabled.
     *
     * @param publications the publications
     */
    @Override
    public void cacheResult(List<Publication> publications) {
        for (Publication publication : publications) {
            if (EntityCacheUtil.getResult(
                        PublicationModelImpl.ENTITY_CACHE_ENABLED,
                        PublicationImpl.class, publication.getPrimaryKey()) == null) {
                cacheResult(publication);
            } else {
                publication.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all publications.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(PublicationImpl.class.getName());
        }

        EntityCacheUtil.clearCache(PublicationImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the publication.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Publication publication) {
        EntityCacheUtil.removeResult(PublicationModelImpl.ENTITY_CACHE_ENABLED,
            PublicationImpl.class, publication.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(publication);
    }

    @Override
    public void clearCache(List<Publication> publications) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Publication publication : publications) {
            EntityCacheUtil.removeResult(PublicationModelImpl.ENTITY_CACHE_ENABLED,
                PublicationImpl.class, publication.getPrimaryKey());

            clearUniqueFindersCache(publication);
        }
    }

    protected void cacheUniqueFindersCache(Publication publication) {
        if (publication.isNew()) {
            Object[] args = new Object[] {
                    publication.getUuid(), publication.getGroupId()
                };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
                publication);
        } else {
            PublicationModelImpl publicationModelImpl = (PublicationModelImpl) publication;

            if ((publicationModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        publication.getUuid(), publication.getGroupId()
                    };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
                    Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
                    publication);
            }
        }
    }

    protected void clearUniqueFindersCache(Publication publication) {
        PublicationModelImpl publicationModelImpl = (PublicationModelImpl) publication;

        Object[] args = new Object[] {
                publication.getUuid(), publication.getGroupId()
            };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

        if ((publicationModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
            args = new Object[] {
                    publicationModelImpl.getOriginalUuid(),
                    publicationModelImpl.getOriginalGroupId()
                };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
        }
    }

    /**
     * Creates a new publication with the primary key. Does not add the publication to the database.
     *
     * @param id the primary key for the new publication
     * @return the new publication
     */
    @Override
    public Publication create(long id) {
        Publication publication = new PublicationImpl();

        publication.setNew(true);
        publication.setPrimaryKey(id);

        String uuid = PortalUUIDUtil.generate();

        publication.setUuid(uuid);

        return publication;
    }

    /**
     * Removes the publication with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the publication
     * @return the publication that was removed
     * @throws fr.lagab.portlet.publication.NoSuchPublicationException if a publication with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Publication remove(long id)
        throws NoSuchPublicationException, SystemException {
        return remove((Serializable) id);
    }

    /**
     * Removes the publication with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the publication
     * @return the publication that was removed
     * @throws fr.lagab.portlet.publication.NoSuchPublicationException if a publication with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Publication remove(Serializable primaryKey)
        throws NoSuchPublicationException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Publication publication = (Publication) session.get(PublicationImpl.class,
                    primaryKey);

            if (publication == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchPublicationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(publication);
        } catch (NoSuchPublicationException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Publication removeImpl(Publication publication)
        throws SystemException {
        publication = toUnwrappedModel(publication);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(publication)) {
                publication = (Publication) session.get(PublicationImpl.class,
                        publication.getPrimaryKeyObj());
            }

            if (publication != null) {
                session.delete(publication);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (publication != null) {
            clearCache(publication);
        }

        return publication;
    }

    @Override
    public Publication updateImpl(
        fr.lagab.portlet.publication.model.Publication publication)
        throws SystemException {
        publication = toUnwrappedModel(publication);

        boolean isNew = publication.isNew();

        PublicationModelImpl publicationModelImpl = (PublicationModelImpl) publication;

        if (Validator.isNull(publication.getUuid())) {
            String uuid = PortalUUIDUtil.generate();

            publication.setUuid(uuid);
        }

        Session session = null;

        try {
            session = openSession();

            if (publication.isNew()) {
                session.save(publication);

                publication.setNew(false);
            } else {
                session.merge(publication);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !PublicationModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((publicationModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        publicationModelImpl.getOriginalUuid()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
                    args);

                args = new Object[] { publicationModelImpl.getUuid() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
                    args);
            }

            if ((publicationModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        publicationModelImpl.getOriginalUuid(),
                        publicationModelImpl.getOriginalCompanyId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
                    args);

                args = new Object[] {
                        publicationModelImpl.getUuid(),
                        publicationModelImpl.getCompanyId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
                    args);
            }

            if ((publicationModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        publicationModelImpl.getOriginalGroupId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
                    args);

                args = new Object[] { publicationModelImpl.getGroupId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
                    args);
            }

            if ((publicationModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        publicationModelImpl.getOriginalCompanyId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
                    args);

                args = new Object[] { publicationModelImpl.getCompanyId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
                    args);
            }

            if ((publicationModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STRUCTUREID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        publicationModelImpl.getOriginalStructureId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STRUCTUREID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STRUCTUREID,
                    args);

                args = new Object[] { publicationModelImpl.getStructureId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STRUCTUREID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STRUCTUREID,
                    args);
            }

            if ((publicationModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEMPLATEID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        publicationModelImpl.getOriginalTemplateId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TEMPLATEID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEMPLATEID,
                    args);

                args = new Object[] { publicationModelImpl.getTemplateId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TEMPLATEID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEMPLATEID,
                    args);
            }

            if ((publicationModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_U.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        publicationModelImpl.getOriginalGroupId(),
                        publicationModelImpl.getOriginalUserId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_U, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_U,
                    args);

                args = new Object[] {
                        publicationModelImpl.getGroupId(),
                        publicationModelImpl.getUserId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_U, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_U,
                    args);
            }

            if ((publicationModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_S.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        publicationModelImpl.getOriginalGroupId(),
                        publicationModelImpl.getOriginalStructureId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_S, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_S,
                    args);

                args = new Object[] {
                        publicationModelImpl.getGroupId(),
                        publicationModelImpl.getStructureId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_S, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_S,
                    args);
            }

            if ((publicationModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_T.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        publicationModelImpl.getOriginalGroupId(),
                        publicationModelImpl.getOriginalTemplateId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_T, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_T,
                    args);

                args = new Object[] {
                        publicationModelImpl.getGroupId(),
                        publicationModelImpl.getTemplateId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_T, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_T,
                    args);
            }
        }

        EntityCacheUtil.putResult(PublicationModelImpl.ENTITY_CACHE_ENABLED,
            PublicationImpl.class, publication.getPrimaryKey(), publication);

        clearUniqueFindersCache(publication);
        cacheUniqueFindersCache(publication);

        return publication;
    }

    protected Publication toUnwrappedModel(Publication publication) {
        if (publication instanceof PublicationImpl) {
            return publication;
        }

        PublicationImpl publicationImpl = new PublicationImpl();

        publicationImpl.setNew(publication.isNew());
        publicationImpl.setPrimaryKey(publication.getPrimaryKey());

        publicationImpl.setUuid(publication.getUuid());
        publicationImpl.setId(publication.getId());
        publicationImpl.setGroupId(publication.getGroupId());
        publicationImpl.setCompanyId(publication.getCompanyId());
        publicationImpl.setUserId(publication.getUserId());
        publicationImpl.setUserName(publication.getUserName());
        publicationImpl.setCreateDate(publication.getCreateDate());
        publicationImpl.setModifiedDate(publication.getModifiedDate());
        publicationImpl.setFolderId(publication.getFolderId());
        publicationImpl.setTitle(publication.getTitle());
        publicationImpl.setUrlTitle(publication.getUrlTitle());
        publicationImpl.setDescription(publication.getDescription());
        publicationImpl.setContent(publication.getContent());
        publicationImpl.setStructureId(publication.getStructureId());
        publicationImpl.setTemplateId(publication.getTemplateId());
        publicationImpl.setStatus(publication.getStatus());

        return publicationImpl;
    }

    /**
     * Returns the publication with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the publication
     * @return the publication
     * @throws fr.lagab.portlet.publication.NoSuchPublicationException if a publication with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Publication findByPrimaryKey(Serializable primaryKey)
        throws NoSuchPublicationException, SystemException {
        Publication publication = fetchByPrimaryKey(primaryKey);

        if (publication == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchPublicationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return publication;
    }

    /**
     * Returns the publication with the primary key or throws a {@link fr.lagab.portlet.publication.NoSuchPublicationException} if it could not be found.
     *
     * @param id the primary key of the publication
     * @return the publication
     * @throws fr.lagab.portlet.publication.NoSuchPublicationException if a publication with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Publication findByPrimaryKey(long id)
        throws NoSuchPublicationException, SystemException {
        return findByPrimaryKey((Serializable) id);
    }

    /**
     * Returns the publication with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the publication
     * @return the publication, or <code>null</code> if a publication with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Publication fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Publication publication = (Publication) EntityCacheUtil.getResult(PublicationModelImpl.ENTITY_CACHE_ENABLED,
                PublicationImpl.class, primaryKey);

        if (publication == _nullPublication) {
            return null;
        }

        if (publication == null) {
            Session session = null;

            try {
                session = openSession();

                publication = (Publication) session.get(PublicationImpl.class,
                        primaryKey);

                if (publication != null) {
                    cacheResult(publication);
                } else {
                    EntityCacheUtil.putResult(PublicationModelImpl.ENTITY_CACHE_ENABLED,
                        PublicationImpl.class, primaryKey, _nullPublication);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(PublicationModelImpl.ENTITY_CACHE_ENABLED,
                    PublicationImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return publication;
    }

    /**
     * Returns the publication with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the publication
     * @return the publication, or <code>null</code> if a publication with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Publication fetchByPrimaryKey(long id) throws SystemException {
        return fetchByPrimaryKey((Serializable) id);
    }

    /**
     * Returns all the publications.
     *
     * @return the publications
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Publication> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    public List<Publication> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
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
    @Override
    public List<Publication> findAll(int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
            finderArgs = FINDER_ARGS_EMPTY;
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
            finderArgs = new Object[] { start, end, orderByComparator };
        }

        List<Publication> list = (List<Publication>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_PUBLICATION);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_PUBLICATION;

                if (pagination) {
                    sql = sql.concat(PublicationModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Publication>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Publication>(list);
                } else {
                    list = (List<Publication>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the publications from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Publication publication : findAll()) {
            remove(publication);
        }
    }

    /**
     * Returns the number of publications.
     *
     * @return the number of publications
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_PUBLICATION);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    @Override
    protected Set<String> getBadColumnNames() {
        return _badColumnNames;
    }

    /**
     * Initializes the publication persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.fr.lagab.portlet.publication.model.Publication")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Publication>> listenersList = new ArrayList<ModelListener<Publication>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Publication>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(PublicationImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
