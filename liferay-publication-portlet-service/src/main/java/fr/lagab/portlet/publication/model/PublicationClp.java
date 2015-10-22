package fr.lagab.portlet.publication.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import fr.lagab.portlet.publication.service.ClpSerializer;
import fr.lagab.portlet.publication.service.PublicationLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class PublicationClp extends BaseModelImpl<Publication>
    implements Publication {
    private String _uuid;
    private long _id;
    private long _groupId;
    private long _companyId;
    private long _userId;
    private String _userUuid;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private long _folderId;
    private String _title;
    private String _urlTitle;
    private String _description;
    private String _content;
    private long _structureId;
    private long _templateId;
    private int _status;
    private BaseModel<?> _publicationRemoteModel;
    private Class<?> _clpSerializerClass = fr.lagab.portlet.publication.service.ClpSerializer.class;

    public PublicationClp() {
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
    public long getPrimaryKey() {
        return _id;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _id;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
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

    @Override
    public String getUuid() {
        return _uuid;
    }

    @Override
    public void setUuid(String uuid) {
        _uuid = uuid;

        if (_publicationRemoteModel != null) {
            try {
                Class<?> clazz = _publicationRemoteModel.getClass();

                Method method = clazz.getMethod("setUuid", String.class);

                method.invoke(_publicationRemoteModel, uuid);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getId() {
        return _id;
    }

    @Override
    public void setId(long id) {
        _id = id;

        if (_publicationRemoteModel != null) {
            try {
                Class<?> clazz = _publicationRemoteModel.getClass();

                Method method = clazz.getMethod("setId", long.class);

                method.invoke(_publicationRemoteModel, id);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getGroupId() {
        return _groupId;
    }

    @Override
    public void setGroupId(long groupId) {
        _groupId = groupId;

        if (_publicationRemoteModel != null) {
            try {
                Class<?> clazz = _publicationRemoteModel.getClass();

                Method method = clazz.getMethod("setGroupId", long.class);

                method.invoke(_publicationRemoteModel, groupId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getCompanyId() {
        return _companyId;
    }

    @Override
    public void setCompanyId(long companyId) {
        _companyId = companyId;

        if (_publicationRemoteModel != null) {
            try {
                Class<?> clazz = _publicationRemoteModel.getClass();

                Method method = clazz.getMethod("setCompanyId", long.class);

                method.invoke(_publicationRemoteModel, companyId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getUserId() {
        return _userId;
    }

    @Override
    public void setUserId(long userId) {
        _userId = userId;

        if (_publicationRemoteModel != null) {
            try {
                Class<?> clazz = _publicationRemoteModel.getClass();

                Method method = clazz.getMethod("setUserId", long.class);

                method.invoke(_publicationRemoteModel, userId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getUserUuid() throws SystemException {
        return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
    }

    @Override
    public void setUserUuid(String userUuid) {
        _userUuid = userUuid;
    }

    @Override
    public String getUserName() {
        return _userName;
    }

    @Override
    public void setUserName(String userName) {
        _userName = userName;

        if (_publicationRemoteModel != null) {
            try {
                Class<?> clazz = _publicationRemoteModel.getClass();

                Method method = clazz.getMethod("setUserName", String.class);

                method.invoke(_publicationRemoteModel, userName);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getCreateDate() {
        return _createDate;
    }

    @Override
    public void setCreateDate(Date createDate) {
        _createDate = createDate;

        if (_publicationRemoteModel != null) {
            try {
                Class<?> clazz = _publicationRemoteModel.getClass();

                Method method = clazz.getMethod("setCreateDate", Date.class);

                method.invoke(_publicationRemoteModel, createDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getModifiedDate() {
        return _modifiedDate;
    }

    @Override
    public void setModifiedDate(Date modifiedDate) {
        _modifiedDate = modifiedDate;

        if (_publicationRemoteModel != null) {
            try {
                Class<?> clazz = _publicationRemoteModel.getClass();

                Method method = clazz.getMethod("setModifiedDate", Date.class);

                method.invoke(_publicationRemoteModel, modifiedDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getFolderId() {
        return _folderId;
    }

    @Override
    public void setFolderId(long folderId) {
        _folderId = folderId;

        if (_publicationRemoteModel != null) {
            try {
                Class<?> clazz = _publicationRemoteModel.getClass();

                Method method = clazz.getMethod("setFolderId", long.class);

                method.invoke(_publicationRemoteModel, folderId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getTitle() {
        return _title;
    }

    @Override
    public void setTitle(String title) {
        _title = title;

        if (_publicationRemoteModel != null) {
            try {
                Class<?> clazz = _publicationRemoteModel.getClass();

                Method method = clazz.getMethod("setTitle", String.class);

                method.invoke(_publicationRemoteModel, title);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getUrlTitle() {
        return _urlTitle;
    }

    @Override
    public void setUrlTitle(String urlTitle) {
        _urlTitle = urlTitle;

        if (_publicationRemoteModel != null) {
            try {
                Class<?> clazz = _publicationRemoteModel.getClass();

                Method method = clazz.getMethod("setUrlTitle", String.class);

                method.invoke(_publicationRemoteModel, urlTitle);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getDescription() {
        return _description;
    }

    @Override
    public void setDescription(String description) {
        _description = description;

        if (_publicationRemoteModel != null) {
            try {
                Class<?> clazz = _publicationRemoteModel.getClass();

                Method method = clazz.getMethod("setDescription", String.class);

                method.invoke(_publicationRemoteModel, description);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getContent() {
        return _content;
    }

    @Override
    public void setContent(String content) {
        _content = content;

        if (_publicationRemoteModel != null) {
            try {
                Class<?> clazz = _publicationRemoteModel.getClass();

                Method method = clazz.getMethod("setContent", String.class);

                method.invoke(_publicationRemoteModel, content);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getStructureId() {
        return _structureId;
    }

    @Override
    public void setStructureId(long structureId) {
        _structureId = structureId;

        if (_publicationRemoteModel != null) {
            try {
                Class<?> clazz = _publicationRemoteModel.getClass();

                Method method = clazz.getMethod("setStructureId", long.class);

                method.invoke(_publicationRemoteModel, structureId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getTemplateId() {
        return _templateId;
    }

    @Override
    public void setTemplateId(long templateId) {
        _templateId = templateId;

        if (_publicationRemoteModel != null) {
            try {
                Class<?> clazz = _publicationRemoteModel.getClass();

                Method method = clazz.getMethod("setTemplateId", long.class);

                method.invoke(_publicationRemoteModel, templateId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getStatus() {
        return _status;
    }

    @Override
    public void setStatus(int status) {
        _status = status;

        if (_publicationRemoteModel != null) {
            try {
                Class<?> clazz = _publicationRemoteModel.getClass();

                Method method = clazz.getMethod("setStatus", int.class);

                method.invoke(_publicationRemoteModel, status);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public StagedModelType getStagedModelType() {
        return new StagedModelType(PortalUtil.getClassNameId(
                Publication.class.getName()));
    }

    public BaseModel<?> getPublicationRemoteModel() {
        return _publicationRemoteModel;
    }

    public void setPublicationRemoteModel(BaseModel<?> publicationRemoteModel) {
        _publicationRemoteModel = publicationRemoteModel;
    }

    public Object invokeOnRemoteModel(String methodName,
        Class<?>[] parameterTypes, Object[] parameterValues)
        throws Exception {
        Object[] remoteParameterValues = new Object[parameterValues.length];

        for (int i = 0; i < parameterValues.length; i++) {
            if (parameterValues[i] != null) {
                remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
            }
        }

        Class<?> remoteModelClass = _publicationRemoteModel.getClass();

        ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

        Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i].isPrimitive()) {
                remoteParameterTypes[i] = parameterTypes[i];
            } else {
                String parameterTypeName = parameterTypes[i].getName();

                remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
            }
        }

        Method method = remoteModelClass.getMethod(methodName,
                remoteParameterTypes);

        Object returnValue = method.invoke(_publicationRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            PublicationLocalServiceUtil.addPublication(this);
        } else {
            PublicationLocalServiceUtil.updatePublication(this);
        }
    }

    @Override
    public Publication toEscapedModel() {
        return (Publication) ProxyUtil.newProxyInstance(Publication.class.getClassLoader(),
            new Class[] { Publication.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        PublicationClp clone = new PublicationClp();

        clone.setUuid(getUuid());
        clone.setId(getId());
        clone.setGroupId(getGroupId());
        clone.setCompanyId(getCompanyId());
        clone.setUserId(getUserId());
        clone.setUserName(getUserName());
        clone.setCreateDate(getCreateDate());
        clone.setModifiedDate(getModifiedDate());
        clone.setFolderId(getFolderId());
        clone.setTitle(getTitle());
        clone.setUrlTitle(getUrlTitle());
        clone.setDescription(getDescription());
        clone.setContent(getContent());
        clone.setStructureId(getStructureId());
        clone.setTemplateId(getTemplateId());
        clone.setStatus(getStatus());

        return clone;
    }

    @Override
    public int compareTo(Publication publication) {
        long primaryKey = publication.getPrimaryKey();

        if (getPrimaryKey() < primaryKey) {
            return -1;
        } else if (getPrimaryKey() > primaryKey) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof PublicationClp)) {
            return false;
        }

        PublicationClp publication = (PublicationClp) obj;

        long primaryKey = publication.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    public Class<?> getClpSerializerClass() {
        return _clpSerializerClass;
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(33);

        sb.append("{uuid=");
        sb.append(getUuid());
        sb.append(", id=");
        sb.append(getId());
        sb.append(", groupId=");
        sb.append(getGroupId());
        sb.append(", companyId=");
        sb.append(getCompanyId());
        sb.append(", userId=");
        sb.append(getUserId());
        sb.append(", userName=");
        sb.append(getUserName());
        sb.append(", createDate=");
        sb.append(getCreateDate());
        sb.append(", modifiedDate=");
        sb.append(getModifiedDate());
        sb.append(", folderId=");
        sb.append(getFolderId());
        sb.append(", title=");
        sb.append(getTitle());
        sb.append(", urlTitle=");
        sb.append(getUrlTitle());
        sb.append(", description=");
        sb.append(getDescription());
        sb.append(", content=");
        sb.append(getContent());
        sb.append(", structureId=");
        sb.append(getStructureId());
        sb.append(", templateId=");
        sb.append(getTemplateId());
        sb.append(", status=");
        sb.append(getStatus());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(52);

        sb.append("<model><model-name>");
        sb.append("fr.lagab.portlet.publication.model.Publication");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>uuid</column-name><column-value><![CDATA[");
        sb.append(getUuid());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>groupId</column-name><column-value><![CDATA[");
        sb.append(getGroupId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>companyId</column-name><column-value><![CDATA[");
        sb.append(getCompanyId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userId</column-name><column-value><![CDATA[");
        sb.append(getUserId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userName</column-name><column-value><![CDATA[");
        sb.append(getUserName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>createDate</column-name><column-value><![CDATA[");
        sb.append(getCreateDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
        sb.append(getModifiedDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>folderId</column-name><column-value><![CDATA[");
        sb.append(getFolderId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>title</column-name><column-value><![CDATA[");
        sb.append(getTitle());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>urlTitle</column-name><column-value><![CDATA[");
        sb.append(getUrlTitle());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>description</column-name><column-value><![CDATA[");
        sb.append(getDescription());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>content</column-name><column-value><![CDATA[");
        sb.append(getContent());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>structureId</column-name><column-value><![CDATA[");
        sb.append(getStructureId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>templateId</column-name><column-value><![CDATA[");
        sb.append(getTemplateId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>status</column-name><column-value><![CDATA[");
        sb.append(getStatus());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
