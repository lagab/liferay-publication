package fr.lagab.portlet.publication.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link fr.lagab.portlet.publication.service.http.PublicationServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see fr.lagab.portlet.publication.service.http.PublicationServiceSoap
 * @generated
 */
public class PublicationSoap implements Serializable {
    private String _uuid;
    private long _id;
    private long _groupId;
    private long _companyId;
    private long _userId;
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

    public PublicationSoap() {
    }

    public static PublicationSoap toSoapModel(Publication model) {
        PublicationSoap soapModel = new PublicationSoap();

        soapModel.setUuid(model.getUuid());
        soapModel.setId(model.getId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setUserId(model.getUserId());
        soapModel.setUserName(model.getUserName());
        soapModel.setCreateDate(model.getCreateDate());
        soapModel.setModifiedDate(model.getModifiedDate());
        soapModel.setFolderId(model.getFolderId());
        soapModel.setTitle(model.getTitle());
        soapModel.setUrlTitle(model.getUrlTitle());
        soapModel.setDescription(model.getDescription());
        soapModel.setContent(model.getContent());
        soapModel.setStructureId(model.getStructureId());
        soapModel.setTemplateId(model.getTemplateId());
        soapModel.setStatus(model.getStatus());

        return soapModel;
    }

    public static PublicationSoap[] toSoapModels(Publication[] models) {
        PublicationSoap[] soapModels = new PublicationSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static PublicationSoap[][] toSoapModels(Publication[][] models) {
        PublicationSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new PublicationSoap[models.length][models[0].length];
        } else {
            soapModels = new PublicationSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static PublicationSoap[] toSoapModels(List<Publication> models) {
        List<PublicationSoap> soapModels = new ArrayList<PublicationSoap>(models.size());

        for (Publication model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new PublicationSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _id;
    }

    public void setPrimaryKey(long pk) {
        setId(pk);
    }

    public String getUuid() {
        return _uuid;
    }

    public void setUuid(String uuid) {
        _uuid = uuid;
    }

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        _id = id;
    }

    public long getGroupId() {
        return _groupId;
    }

    public void setGroupId(long groupId) {
        _groupId = groupId;
    }

    public long getCompanyId() {
        return _companyId;
    }

    public void setCompanyId(long companyId) {
        _companyId = companyId;
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        _userId = userId;
    }

    public String getUserName() {
        return _userName;
    }

    public void setUserName(String userName) {
        _userName = userName;
    }

    public Date getCreateDate() {
        return _createDate;
    }

    public void setCreateDate(Date createDate) {
        _createDate = createDate;
    }

    public Date getModifiedDate() {
        return _modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        _modifiedDate = modifiedDate;
    }

    public long getFolderId() {
        return _folderId;
    }

    public void setFolderId(long folderId) {
        _folderId = folderId;
    }

    public String getTitle() {
        return _title;
    }

    public void setTitle(String title) {
        _title = title;
    }

    public String getUrlTitle() {
        return _urlTitle;
    }

    public void setUrlTitle(String urlTitle) {
        _urlTitle = urlTitle;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
    }

    public String getContent() {
        return _content;
    }

    public void setContent(String content) {
        _content = content;
    }

    public long getStructureId() {
        return _structureId;
    }

    public void setStructureId(long structureId) {
        _structureId = structureId;
    }

    public long getTemplateId() {
        return _templateId;
    }

    public void setTemplateId(long templateId) {
        _templateId = templateId;
    }

    public int getStatus() {
        return _status;
    }

    public void setStatus(int status) {
        _status = status;
    }
}
