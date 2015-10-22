package fr.lagab.portlet.publication.model;

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Publication}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Publication
 * @generated
 */
public class PublicationWrapper implements Publication,
    ModelWrapper<Publication> {
    private Publication _publication;

    public PublicationWrapper(Publication publication) {
        _publication = publication;
    }

    @Override
    public Class<?> getModelClass() {
        return Publication.class;
    }

    @Override
    public String getModelClassName() {
        return Publication.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("uuid", getUuid());
        attributes.put("id", getId());
        attributes.put("groupId", getGroupId());
        attributes.put("companyId", getCompanyId());
        attributes.put("userId", getUserId());
        attributes.put("userName", getUserName());
        attributes.put("createDate", getCreateDate());
        attributes.put("modifiedDate", getModifiedDate());
        attributes.put("folderId", getFolderId());
        attributes.put("title", getTitle());
        attributes.put("urlTitle", getUrlTitle());
        attributes.put("description", getDescription());
        attributes.put("content", getContent());
        attributes.put("structureId", getStructureId());
        attributes.put("templateId", getTemplateId());
        attributes.put("status", getStatus());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        String uuid = (String) attributes.get("uuid");

        if (uuid != null) {
            setUuid(uuid);
        }

        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        Long groupId = (Long) attributes.get("groupId");

        if (groupId != null) {
            setGroupId(groupId);
        }

        Long companyId = (Long) attributes.get("companyId");

        if (companyId != null) {
            setCompanyId(companyId);
        }

        Long userId = (Long) attributes.get("userId");

        if (userId != null) {
            setUserId(userId);
        }

        String userName = (String) attributes.get("userName");

        if (userName != null) {
            setUserName(userName);
        }

        Date createDate = (Date) attributes.get("createDate");

        if (createDate != null) {
            setCreateDate(createDate);
        }

        Date modifiedDate = (Date) attributes.get("modifiedDate");

        if (modifiedDate != null) {
            setModifiedDate(modifiedDate);
        }

        Long folderId = (Long) attributes.get("folderId");

        if (folderId != null) {
            setFolderId(folderId);
        }

        String title = (String) attributes.get("title");

        if (title != null) {
            setTitle(title);
        }

        String urlTitle = (String) attributes.get("urlTitle");

        if (urlTitle != null) {
            setUrlTitle(urlTitle);
        }

        String description = (String) attributes.get("description");

        if (description != null) {
            setDescription(description);
        }

        String content = (String) attributes.get("content");

        if (content != null) {
            setContent(content);
        }

        Long structureId = (Long) attributes.get("structureId");

        if (structureId != null) {
            setStructureId(structureId);
        }

        Long templateId = (Long) attributes.get("templateId");

        if (templateId != null) {
            setTemplateId(templateId);
        }

        Integer status = (Integer) attributes.get("status");

        if (status != null) {
            setStatus(status);
        }
    }

    /**
    * Returns the primary key of this publication.
    *
    * @return the primary key of this publication
    */
    @Override
    public long getPrimaryKey() {
        return _publication.getPrimaryKey();
    }

    /**
    * Sets the primary key of this publication.
    *
    * @param primaryKey the primary key of this publication
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _publication.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the uuid of this publication.
    *
    * @return the uuid of this publication
    */
    @Override
    public java.lang.String getUuid() {
        return _publication.getUuid();
    }

    /**
    * Sets the uuid of this publication.
    *
    * @param uuid the uuid of this publication
    */
    @Override
    public void setUuid(java.lang.String uuid) {
        _publication.setUuid(uuid);
    }

    /**
    * Returns the ID of this publication.
    *
    * @return the ID of this publication
    */
    @Override
    public long getId() {
        return _publication.getId();
    }

    /**
    * Sets the ID of this publication.
    *
    * @param id the ID of this publication
    */
    @Override
    public void setId(long id) {
        _publication.setId(id);
    }

    /**
    * Returns the group ID of this publication.
    *
    * @return the group ID of this publication
    */
    @Override
    public long getGroupId() {
        return _publication.getGroupId();
    }

    /**
    * Sets the group ID of this publication.
    *
    * @param groupId the group ID of this publication
    */
    @Override
    public void setGroupId(long groupId) {
        _publication.setGroupId(groupId);
    }

    /**
    * Returns the company ID of this publication.
    *
    * @return the company ID of this publication
    */
    @Override
    public long getCompanyId() {
        return _publication.getCompanyId();
    }

    /**
    * Sets the company ID of this publication.
    *
    * @param companyId the company ID of this publication
    */
    @Override
    public void setCompanyId(long companyId) {
        _publication.setCompanyId(companyId);
    }

    /**
    * Returns the user ID of this publication.
    *
    * @return the user ID of this publication
    */
    @Override
    public long getUserId() {
        return _publication.getUserId();
    }

    /**
    * Sets the user ID of this publication.
    *
    * @param userId the user ID of this publication
    */
    @Override
    public void setUserId(long userId) {
        _publication.setUserId(userId);
    }

    /**
    * Returns the user uuid of this publication.
    *
    * @return the user uuid of this publication
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _publication.getUserUuid();
    }

    /**
    * Sets the user uuid of this publication.
    *
    * @param userUuid the user uuid of this publication
    */
    @Override
    public void setUserUuid(java.lang.String userUuid) {
        _publication.setUserUuid(userUuid);
    }

    /**
    * Returns the user name of this publication.
    *
    * @return the user name of this publication
    */
    @Override
    public java.lang.String getUserName() {
        return _publication.getUserName();
    }

    /**
    * Sets the user name of this publication.
    *
    * @param userName the user name of this publication
    */
    @Override
    public void setUserName(java.lang.String userName) {
        _publication.setUserName(userName);
    }

    /**
    * Returns the create date of this publication.
    *
    * @return the create date of this publication
    */
    @Override
    public java.util.Date getCreateDate() {
        return _publication.getCreateDate();
    }

    /**
    * Sets the create date of this publication.
    *
    * @param createDate the create date of this publication
    */
    @Override
    public void setCreateDate(java.util.Date createDate) {
        _publication.setCreateDate(createDate);
    }

    /**
    * Returns the modified date of this publication.
    *
    * @return the modified date of this publication
    */
    @Override
    public java.util.Date getModifiedDate() {
        return _publication.getModifiedDate();
    }

    /**
    * Sets the modified date of this publication.
    *
    * @param modifiedDate the modified date of this publication
    */
    @Override
    public void setModifiedDate(java.util.Date modifiedDate) {
        _publication.setModifiedDate(modifiedDate);
    }

    /**
    * Returns the folder ID of this publication.
    *
    * @return the folder ID of this publication
    */
    @Override
    public long getFolderId() {
        return _publication.getFolderId();
    }

    /**
    * Sets the folder ID of this publication.
    *
    * @param folderId the folder ID of this publication
    */
    @Override
    public void setFolderId(long folderId) {
        _publication.setFolderId(folderId);
    }

    /**
    * Returns the title of this publication.
    *
    * @return the title of this publication
    */
    @Override
    public java.lang.String getTitle() {
        return _publication.getTitle();
    }

    /**
    * Sets the title of this publication.
    *
    * @param title the title of this publication
    */
    @Override
    public void setTitle(java.lang.String title) {
        _publication.setTitle(title);
    }

    /**
    * Returns the url title of this publication.
    *
    * @return the url title of this publication
    */
    @Override
    public java.lang.String getUrlTitle() {
        return _publication.getUrlTitle();
    }

    /**
    * Sets the url title of this publication.
    *
    * @param urlTitle the url title of this publication
    */
    @Override
    public void setUrlTitle(java.lang.String urlTitle) {
        _publication.setUrlTitle(urlTitle);
    }

    /**
    * Returns the description of this publication.
    *
    * @return the description of this publication
    */
    @Override
    public java.lang.String getDescription() {
        return _publication.getDescription();
    }

    /**
    * Sets the description of this publication.
    *
    * @param description the description of this publication
    */
    @Override
    public void setDescription(java.lang.String description) {
        _publication.setDescription(description);
    }

    /**
    * Returns the content of this publication.
    *
    * @return the content of this publication
    */
    @Override
    public java.lang.String getContent() {
        return _publication.getContent();
    }

    /**
    * Sets the content of this publication.
    *
    * @param content the content of this publication
    */
    @Override
    public void setContent(java.lang.String content) {
        _publication.setContent(content);
    }

    /**
    * Returns the structure ID of this publication.
    *
    * @return the structure ID of this publication
    */
    @Override
    public long getStructureId() {
        return _publication.getStructureId();
    }

    /**
    * Sets the structure ID of this publication.
    *
    * @param structureId the structure ID of this publication
    */
    @Override
    public void setStructureId(long structureId) {
        _publication.setStructureId(structureId);
    }

    /**
    * Returns the template ID of this publication.
    *
    * @return the template ID of this publication
    */
    @Override
    public long getTemplateId() {
        return _publication.getTemplateId();
    }

    /**
    * Sets the template ID of this publication.
    *
    * @param templateId the template ID of this publication
    */
    @Override
    public void setTemplateId(long templateId) {
        _publication.setTemplateId(templateId);
    }

    /**
    * Returns the status of this publication.
    *
    * @return the status of this publication
    */
    @Override
    public int getStatus() {
        return _publication.getStatus();
    }

    /**
    * Sets the status of this publication.
    *
    * @param status the status of this publication
    */
    @Override
    public void setStatus(int status) {
        _publication.setStatus(status);
    }

    @Override
    public boolean isNew() {
        return _publication.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _publication.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _publication.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _publication.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _publication.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _publication.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _publication.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _publication.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _publication.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _publication.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _publication.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new PublicationWrapper((Publication) _publication.clone());
    }

    @Override
    public int compareTo(
        fr.lagab.portlet.publication.model.Publication publication) {
        return _publication.compareTo(publication);
    }

    @Override
    public int hashCode() {
        return _publication.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<fr.lagab.portlet.publication.model.Publication> toCacheModel() {
        return _publication.toCacheModel();
    }

    @Override
    public fr.lagab.portlet.publication.model.Publication toEscapedModel() {
        return new PublicationWrapper(_publication.toEscapedModel());
    }

    @Override
    public fr.lagab.portlet.publication.model.Publication toUnescapedModel() {
        return new PublicationWrapper(_publication.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _publication.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _publication.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _publication.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof PublicationWrapper)) {
            return false;
        }

        PublicationWrapper publicationWrapper = (PublicationWrapper) obj;

        if (Validator.equals(_publication, publicationWrapper._publication)) {
            return true;
        }

        return false;
    }

    @Override
    public StagedModelType getStagedModelType() {
        return _publication.getStagedModelType();
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Publication getWrappedPublication() {
        return _publication;
    }

    @Override
    public Publication getWrappedModel() {
        return _publication;
    }

    @Override
    public void resetOriginalValues() {
        _publication.resetOriginalValues();
    }
}
