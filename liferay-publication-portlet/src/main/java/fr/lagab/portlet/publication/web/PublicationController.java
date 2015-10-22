package fr.lagab.portlet.publication.web;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import fr.lagab.portlet.publication.model.Publication;

/**
 * @author lagab
 * @since 13/10/15.
 */
public class PublicationController extends MVCPortlet{

    private static Log LOGGER = LogFactoryUtil.getLog(PublicationController.class.getName());
    private static final String _TEMP_FOLDER_NAME = Publication.class.getName();

}
