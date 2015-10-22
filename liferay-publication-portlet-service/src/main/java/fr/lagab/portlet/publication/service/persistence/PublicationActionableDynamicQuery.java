package fr.lagab.portlet.publication.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import fr.lagab.portlet.publication.model.Publication;
import fr.lagab.portlet.publication.service.PublicationLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class PublicationActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public PublicationActionableDynamicQuery() throws SystemException {
        setBaseLocalService(PublicationLocalServiceUtil.getService());
        setClass(Publication.class);

        setClassLoader(fr.lagab.portlet.publication.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
