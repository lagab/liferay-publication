package fr.lagab.portlet.publication.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import fr.lagab.portlet.publication.service.ClpSerializer;
import fr.lagab.portlet.publication.service.PublicationLocalServiceUtil;
import fr.lagab.portlet.publication.service.PublicationServiceUtil;
import fr.lagab.portlet.publication.service.PublicationStructureLocalServiceUtil;
import fr.lagab.portlet.publication.service.PublicationStructureServiceUtil;
import fr.lagab.portlet.publication.service.PublicationTemplateLocalServiceUtil;
import fr.lagab.portlet.publication.service.PublicationTemplateServiceUtil;


public class ClpMessageListener extends BaseMessageListener {
    public static String getServletContextName() {
        return ClpSerializer.getServletContextName();
    }

    @Override
    protected void doReceive(Message message) throws Exception {
        String command = message.getString("command");
        String servletContextName = message.getString("servletContextName");

        if (command.equals("undeploy") &&
                servletContextName.equals(getServletContextName())) {
            PublicationLocalServiceUtil.clearService();

            PublicationServiceUtil.clearService();
            PublicationStructureLocalServiceUtil.clearService();

            PublicationStructureServiceUtil.clearService();
            PublicationTemplateLocalServiceUtil.clearService();

            PublicationTemplateServiceUtil.clearService();
        }
    }
}
