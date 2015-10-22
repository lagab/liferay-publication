package fr.lagab.portlet.publication.service.impl;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import fr.lagab.portlet.publication.model.Publication;
import fr.lagab.portlet.publication.service.base.PublicationServiceBaseImpl;

import java.util.List;

/**
 * The implementation of the publication remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link fr.lagab.portlet.publication.service.PublicationService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see fr.lagab.portlet.publication.service.base.PublicationServiceBaseImpl
 * @see fr.lagab.portlet.publication.service.PublicationServiceUtil
 */
public class PublicationServiceImpl extends PublicationServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link fr.lagab.portlet.publication.service.PublicationServiceUtil} to access the publication remote service.
     */

    public int countPublication(long groupId)throws SystemException {
        return publicationPersistence.countByGroupId(groupId);
    }

    public int countAllPublication() throws SystemException {
        return publicationPersistence.countAll();
    }

    public int countPublication(long groupId, long userId)throws SystemException {
        if(userId <= 0){
            return publicationPersistence.countByGroupId(groupId);
        }else{
            return publicationPersistence.countByG_U(groupId,userId);
        }
    }

    public int countPublicationsByStructureId(long groupId, long structureId)throws SystemException {
        return publicationPersistence.countByG_S(groupId, structureId);
    }

    public List<Publication> getAllPublications() throws SystemException{
        return publicationPersistence.findAll();
    }

    public List<Publication> getAllPublications(int start, int end) throws SystemException{
        return publicationPersistence.findAll(start, end);
    }

    public List<Publication> getAllPublications(int start, int end, OrderByComparator obc) throws SystemException{
        return publicationPersistence.findAll(start, end,obc);
    }

    public List<Publication> getPublications(long groupId) throws SystemException{
        return publicationPersistence.findByGroupId(groupId);
    }

    public List<Publication> getPublications(long groupId, int start, int end) throws SystemException{
        return publicationPersistence.findByGroupId(groupId, start, end);
    }

    public List<Publication> getPublications(long groupId, int start, int end, OrderByComparator obc) throws SystemException{
        return publicationPersistence.findByGroupId(groupId, start, end, obc);
    }

    public List<Publication> getUserPublications(long groupId, long userId) throws SystemException{
        return publicationPersistence.findByG_U(groupId,userId);
    }
    public List<Publication> getUserPublications(long groupId, long userId, int start, int end) throws SystemException{
        return publicationPersistence.findByG_U(groupId, userId, start, end);
    }
    public List<Publication> getUserPublications(long groupId, long userId, int start, int end, OrderByComparator obc) throws SystemException{
        return publicationPersistence.findByG_U(groupId, userId, start, end, obc);
    }

    public Publication getPublication(long entryId) throws SystemException{
        return publicationPersistence.fetchByPrimaryKey(entryId);
    }

    public List<Publication> getPublicationsByStructureId(long groupId, long structureId) throws SystemException{
        return publicationPersistence.findByG_S(groupId, structureId);
    }
    public List<Publication> getPublicationsByStructureId(long groupId, long structureId, int start, int end) throws SystemException{
        return publicationPersistence.findByG_S(groupId, structureId, start, end);
    }
    public List<Publication> getPublicationsByStructureId(long groupId, long structureId, int start, int end, OrderByComparator obc) throws SystemException{
        return publicationPersistence.findByG_S(groupId, structureId, start, end, obc);
    }


}
