package fr.lagab.portlet.publication.web.util.converter;

import com.liferay.portal.kernel.security.pacl.permission.PortalRuntimePermission;
import com.liferay.portlet.dynamicdatamapping.model.DDMStructure;
import com.liferay.portlet.dynamicdatamapping.storage.Fields;
/**
 * @author lagab
 * @since  21/10/15.
 */
public class PublicationConverterUtil {
    public static String getContent(DDMStructure ddmStructure, Fields ddmFields) throws Exception {
        return getPublicationConverter().getContent(ddmStructure, ddmFields);
    }

    public static Fields getDDMFields(DDMStructure ddmStructure, String content) throws Exception {
        return getPublicationConverter().getDDMFields(ddmStructure, content);
    }

    public static String getDDMXSD(String journalXSD) throws Exception {
        return getPublicationConverter().getDDMXSD(journalXSD);
    }

    public static PublicationConverter getPublicationConverter() {
        PortalRuntimePermission.checkGetBeanProperty(PublicationConverterUtil.class);
        return _publicationConverter;
    }

    public static String getJournalXSD(String ddmXSD) throws Exception {
        return getPublicationConverter().getJournalXSD(ddmXSD);
    }

    public void setPublicationConverter(PublicationConverter publicationConverter) {
        PortalRuntimePermission.checkSetBeanProperty(getClass());
        _publicationConverter = publicationConverter;
    }

    private static PublicationConverter _publicationConverter;
}
