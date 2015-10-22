package fr.lagab.portlet.publication.web;

import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;

/**
 * @author lagab
 * @since 13/10/15.
 */
public class PublicationConfiguration extends DefaultConfigurationAction{

@Override
public void processAction(PortletConfig portletConfig,
        ActionRequest actionRequest, ActionResponse actionResponse)
        throws Exception {
        String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

        if (cmd.equals(Constants.UPDATE)) {
            String[] values = StringUtil.split(
            ParamUtil.getString(actionRequest, "categoryId"));
            if(values.length >= 0){
                this.setPreference(actionRequest, "categoryId", values);
            }
        }
            super.processAction(portletConfig, actionRequest, actionResponse);
        }
}
