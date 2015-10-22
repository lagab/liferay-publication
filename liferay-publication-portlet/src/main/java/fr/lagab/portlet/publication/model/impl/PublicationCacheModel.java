package fr.lagab.portlet.publication.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import fr.lagab.portlet.publication.model.Publication;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Publication in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Publication
 * @generated
 */
public class PublicationCacheModel implements CacheModel<Publication>,
    Externalizable {
    public String uuid;
    public long id;
    public long groupId;
    public long companyId;
    public long userId;
    public String userName;
    public long createDate;
    public long modifiedDate;
    public long folderId;
    public String title;
    public String urlTitle;
    public String description;
    public String content;
    public long structureId;
    public long templateId;
    public int status;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(33);

        sb.append("{uuid=");
        sb.append(uuid);
        sb.append(", id=");
        sb.append(id);
        sb.append(", groupId=");
        sb.append(groupId);
        sb.append(", companyId=");
        sb.append(companyId);
        sb.append(", userId=");
        sb.append(userId);
        sb.append(", userName=");
        sb.append(userName);
        sb.append(", createDate=");
        sb.append(createDate);
        sb.append(", modifiedDate=");
        sb.append(modifiedDate);
        sb.append(", folderId=");
        sb.append(folderId);
        sb.append(", title=");
        sb.append(title);
        sb.append(", urlTitle=");
        sb.append(urlTitle);
        sb.append(", description=");
        sb.append(description);
        sb.append(", content=");
        sb.append(content);
        sb.append(", structureId=");
        sb.append(structureId);
        sb.append(", templateId=");
        sb.append(templateId);
        sb.append(", status=");
        sb.append(status);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Publication toEntityModel() {
        PublicationImpl publicationImpl = new PublicationImpl();

        if (uuid == null) {
            publicationImpl.setUuid(StringPool.BLANK);
        } else {
            publicationImpl.setUuid(uuid);
        }

        publicationImpl.setId(id);
        publicationImpl.setGroupId(groupId);
        publicationImpl.setCompanyId(companyId);
        publicationImpl.setUserId(userId);

        if (userName == null) {
            publicationImpl.setUserName(StringPool.BLANK);
        } else {
            publicationImpl.setUserName(userName);
        }

        if (createDate == Long.MIN_VALUE) {
            publicationImpl.setCreateDate(null);
        } else {
            publicationImpl.setCreateDate(new Date(createDate));
        }

        if (modifiedDate == Long.MIN_VALUE) {
            publicationImpl.setModifiedDate(null);
        } else {
            publicationImpl.setModifiedDate(new Date(modifiedDate));
        }

        publicationImpl.setFolderId(folderId);

        if (title == null) {
            publicationImpl.setTitle(StringPool.BLANK);
        } else {
            publicationImpl.setTitle(title);
        }

        if (urlTitle == null) {
            publicationImpl.setUrlTitle(StringPool.BLANK);
        } else {
            publicationImpl.setUrlTitle(urlTitle);
        }

        if (description == null) {
            publicationImpl.setDescription(StringPool.BLANK);
        } else {
            publicationImpl.setDescription(description);
        }

        if (content == null) {
            publicationImpl.setContent(StringPool.BLANK);
        } else {
            publicationImpl.setContent(content);
        }

        publicationImpl.setStructureId(structureId);
        publicationImpl.setTemplateId(templateId);
        publicationImpl.setStatus(status);

        publicationImpl.resetOriginalValues();

        return publicationImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        uuid = objectInput.readUTF();
        id = objectInput.readLong();
        groupId = objectInput.readLong();
        companyId = objectInput.readLong();
        userId = objectInput.readLong();
        userName = objectInput.readUTF();
        createDate = objectInput.readLong();
        modifiedDate = objectInput.readLong();
        folderId = objectInput.readLong();
        title = objectInput.readUTF();
        urlTitle = objectInput.readUTF();
        description = objectInput.readUTF();
        content = objectInput.readUTF();
        structureId = objectInput.readLong();
        templateId = objectInput.readLong();
        status = objectInput.readInt();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        if (uuid == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(uuid);
        }

        objectOutput.writeLong(id);
        objectOutput.writeLong(groupId);
        objectOutput.writeLong(companyId);
        objectOutput.writeLong(userId);

        if (userName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(userName);
        }

        objectOutput.writeLong(createDate);
        objectOutput.writeLong(modifiedDate);
        objectOutput.writeLong(folderId);

        if (title == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(title);
        }

        if (urlTitle == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(urlTitle);
        }

        if (description == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(description);
        }

        if (content == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(content);
        }

        objectOutput.writeLong(structureId);
        objectOutput.writeLong(templateId);
        objectOutput.writeInt(status);
    }
}
