package fr.lagab.portlet.publication.web.search;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;

import javax.portlet.PortletRequest;

/**
 * @author lagab
 * @since  21/10/15.
 */
public class PublicationSearchTerms extends PublicationDisplayTerms {

    public PublicationSearchTerms(PortletRequest portletRequest) {
        super(portletRequest);
        publicationId = DAOParamUtil.getString(portletRequest, PUBLICATION_ID);
        content = DAOParamUtil.getString(portletRequest, CONTENT);
        description = DAOParamUtil.getString(portletRequest, DESCRIPTION);
        structureId = DAOParamUtil.getLong(portletRequest, STRUCTURE_ID);
        templateId = DAOParamUtil.getLong(portletRequest, TEMPLATE_ID);
        title = DAOParamUtil.getString(portletRequest, TITLE);

        groupId = setGroupId(portletRequest);
    }

    public void setPublicationId(String publicationId) {
        this.publicationId = publicationId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public void setStructureId(long structureId) {
        this.structureId = structureId;
    }

}

