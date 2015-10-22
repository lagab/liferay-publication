package fr.lagab.portlet.publication.web.util.converter;

import com.liferay.portlet.dynamicdatamapping.model.DDMStructure;
import com.liferay.portlet.dynamicdatamapping.storage.Fields;

/**
 * @author lagab
 * @since  21/10/15.
 */
public interface PublicationConverter {
    public String getContent(DDMStructure ddmStructure, Fields ddmFields) throws Exception;

    public Fields getDDMFields(DDMStructure ddmStructure, String content) throws Exception;

    public String getDDMXSD(String journalXSD) throws Exception;

    public String getJournalXSD(String ddmXSD) throws Exception;
}
