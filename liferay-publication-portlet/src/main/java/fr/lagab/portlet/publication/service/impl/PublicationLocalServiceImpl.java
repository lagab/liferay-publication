package fr.lagab.portlet.publication.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import fr.lagab.portlet.publication.model.Publication;
import fr.lagab.portlet.publication.service.base.PublicationLocalServiceBaseImpl;

import java.util.Date;

/**
 * The implementation of the publication local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link fr.lagab.portlet.publication.service.PublicationLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see fr.lagab.portlet.publication.service.base.PublicationLocalServiceBaseImpl
 * @see fr.lagab.portlet.publication.service.PublicationLocalServiceUtil
 */
public class PublicationLocalServiceImpl extends PublicationLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link fr.lagab.portlet.publication.service.PublicationLocalServiceUtil} to access the publication local service.
     */

    private static Log LOGGER = LogFactoryUtil.getLog(PublicationLocalServiceImpl.class.getName());

    public Publication addPublication(long companyId, long groupId, long userId, Date createDate, long folderId, String title, String content, String description,long structureId, long templateId, int status , ServiceContext serviceContext) throws SystemException, PortalException {
        long publication_id = counterLocalService.increment(Publication.class.getName());

        Publication publication = publicationPersistence.create(publication_id);

        User user = userPersistence.findByPrimaryKey(userId);
        publication.setNew(true);
        publication.setCompanyId(companyId);
        publication.setGroupId(groupId);
        publication.setUserId(userId);
        publication.setUserName(user.getFullName());
        publication.setCreateDate(createDate);
        publication.setModifiedDate(createDate);
        publication.setFolderId(folderId);
        publication.setTitle(title);

        publication.setDescription(description);
        publication.setContent(content);
        publication.setStructureId(structureId);
        publication.setTemplateId(templateId);
        publication.setStatus(status);

        publicationPersistence.update(publication);
        // Resources
        if (serviceContext.isAddGroupPermissions() || serviceContext.isAddGuestPermissions()) {

            addResources(publication, serviceContext.isAddGroupPermissions(), serviceContext.isAddGuestPermissions());
        }
        else {
            addResources(publication, serviceContext.getGroupPermissions(), serviceContext.getGuestPermissions());
        }

        // Asset
        updateAsset(userId, publication, serviceContext.getAssetCategoryIds(),serviceContext.getAssetTagNames());

        //Index
        Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(Publication.class.getName());
        indexer.reindex(publication);

        /**
         *TODO: dd social activity
         */

        return publication;
    }


    public Publication updatePublication(long publicationId, long userId, String title, String description, String content, ServiceContext serviceContext) throws SystemException, PortalException{

        // Entry

        Publication publication = publicationPersistence.fetchByPrimaryKey(publicationId);

        publication.setTitle(title);
        publication.setDescription(description);
        publication.setContent(content);
        publicationPersistence.update(publication);

        // Resources

        if ((serviceContext.getGroupPermissions() != null) || (serviceContext.getGuestPermissions() != null)) {

            updateResources(publication, serviceContext.getGroupPermissions(), serviceContext.getGuestPermissions());
        }

        // Asset
        updateAsset(userId, publication, serviceContext.getAssetCategoryIds(), serviceContext.getAssetTagNames());

        // Index
        Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(Publication.class.getName());
        indexer.reindex(publication);


        return publication;

    }

    @Override
    public Publication deletePublication(Publication publication) throws SystemException {
        if( publication.getFolderId() > 0 ){
            try {
                DLAppServiceUtil.deleteFolder(publication.getFolderId());
            } catch (PortalException e) {
                LOGGER.error(e);
            }
        }
        return super.deletePublication(publication);
    }

    public void updateAsset(long userId, Publication entry,long[] assetCategoryIds, String[] assetTagNames) throws SystemException, PortalException {
        boolean visible = true;

        String summary = HtmlUtil.extractText(StringUtil.shorten(entry.getDescription(), 500));
        assetEntryLocalService.updateEntry(
                userId, entry.getGroupId(), entry.getCreateDate(),
                entry.getModifiedDate(), Publication.class.getName(),
                entry.getId(), entry.getUuid(), 0, assetCategoryIds,
                assetTagNames, visible, null, null, null, ContentTypes.TEXT_HTML,
                entry.getTitle(), entry.getDescription(), summary, null, null, 0, 0,
                null, false);
    }

    public void addResources(Publication entry,boolean addGroupPermissions, boolean addGuestPermissions ) throws SystemException, PortalException{
        resourceLocalService.addResources(
                entry.getCompanyId(), entry.getGroupId(), entry.getUserId(),
                Publication.class.getName(), entry.getId(), false,
                addGroupPermissions, addGuestPermissions);
    }

    public void addResources(Publication entry, String[] groupPermissions, String[] guestPermissions ) throws SystemException, PortalException{
        resourceLocalService.addModelResources(
                entry.getCompanyId(), entry.getGroupId(), entry.getUserId(),
                Publication.class.getName(), entry.getId(),
                groupPermissions, guestPermissions);

    }

    public void updateResources(Publication entry, String[] groupPermissions, String[] guestPermissions) throws PortalException, SystemException {

        resourceLocalService.updateResources(
                entry.getCompanyId(), entry.getGroupId(),
                Publication.class.getName(), entry.getId(), groupPermissions,
                guestPermissions);
    }


}
