package fr.lagab.portlet.publication.web.search;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.util.StringPool;
import fr.lagab.portlet.publication.model.Publication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

/**
 * @author lagab
 * @since  21/10/15.
 */
public class PublicationSearch extends SearchContainer<Publication>{

    static List<String> headerNames = new ArrayList<String>();
    static Map<String, String> orderableHeaders = new HashMap<String, String>();

    static {
        headerNames.add("id");
        headerNames.add("title");
        headerNames.add("modified-date");
        headerNames.add("create-date");
        headerNames.add("author");
        headerNames.add(StringPool.BLANK);

        orderableHeaders.put("id", "id");
        orderableHeaders.put("title", "title");
        orderableHeaders.put("create-date", "create-date");
        orderableHeaders.put("modified-date", "modified-date");
    }

    public PublicationSearch(PortletRequest portletRequest, int cur, int delta,PortletURL iteratorURL){

        super(
                portletRequest, new PublicationDisplayTerms(portletRequest),
                new PublicationSearchTerms(portletRequest), DEFAULT_CUR_PARAM, cur,
                delta, iteratorURL, headerNames, null);
    }

    public PublicationSearch(PortletRequest portletRequest, PortletURL iteratorURL) {

        this(portletRequest, 0, DEFAULT_DELTA, iteratorURL);
    }

}