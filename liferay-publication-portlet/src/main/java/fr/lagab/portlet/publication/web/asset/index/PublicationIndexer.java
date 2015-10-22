package fr.lagab.portlet.publication.web.asset.index;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.Property;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import fr.lagab.portlet.publication.model.Publication;
import fr.lagab.portlet.publication.service.PublicationLocalServiceUtil;
import fr.lagab.portlet.publication.service.persistence.PublicationActionableDynamicQuery;
import fr.lagab.portlet.publication.web.util.PortletKeys;

import java.util.Date;
import java.util.Locale;

import javax.portlet.PortletURL;
/**
 * @author lagab
 * @since  21/10/15.
 */
public class PublicationIndexer extends BaseIndexer {

    public static final String[] CLASS_NAMES = {Publication.class.getName()};

    public static final String PORTLET_ID = PortletKeys.PUBLICATION_PORTLET;

    public PublicationIndexer() {
        setFilterSearch(true);
        setPermissionAware(true);
    }

    @Override
    public String[] getClassNames() {
        return CLASS_NAMES;
    }

    @Override
    public String getPortletId() {
        return PORTLET_ID;
    }

    @Override
    protected void doDelete(Object obj) throws Exception {

        Publication publication = (Publication)obj;
        deleteDocument(publication.getCompanyId(), publication.getId());
    }

    @Override
    protected Document doGetDocument(Object obj) throws Exception {
        Publication publication = (Publication)obj;

        Document document = getBaseModelDocument(PORTLET_ID, publication);

        document.addUID(PORTLET_ID, publication.getPrimaryKey());

        document.addKeyword(Field.COMPANY_ID, publication.getCompanyId());
        document.addKeyword(Field.PORTLET_ID, PORTLET_ID);
        document.addNumber(Field.GROUP_ID, publication.getGroupId());
        document.addKeyword(Field.SCOPE_GROUP_ID, publication.getGroupId());
        document.addKeyword(Field.USER_ID, publication.getUserId());
        document.addNumber(Field.CLASS_PK, publication.getPrimaryKey());


        document.addText(Field.CONTENT, HtmlUtil.extractText(publication.getContent()));
        document.addText(Field.DESCRIPTION, publication.getDescription());
        document.addDate(Field.CREATE_DATE, publication.getCreateDate());
        document.addDate(Field.MODIFIED_DATE, publication.getModifiedDate());
        document.addDate(Field.PUBLISH_DATE, publication.getCreateDate());
        document.addText(Field.TITLE, publication.getTitle());
        document.addNumber("publicationFolder", publication.getFolderId());

        long[] assetCategoryIds =	AssetCategoryLocalServiceUtil.getCategoryIds(
                Publication.class.getName(), publication.getPrimaryKey());
        document.addKeyword(Field.ASSET_CATEGORY_IDS, assetCategoryIds);
        document.addKeyword(Field.ENTRY_CLASS_NAME, Publication.class.getName());
        document.addKeyword(Field.ENTRY_CLASS_PK, publication.getPrimaryKey());


        return document;
    }

    @Override
    protected Summary doGetSummary(
            Document document, Locale locale,
            String snippet, PortletURL portletURL) throws Exception {
        Locale snippetLocale = getSnippetLocale(document, locale);

        /*if (snippetLocale == null) {
            snippetLocale = LocaleUtil.fromLanguageId(document.get("defaultLanguageId"));
        }*/

        Summary summary = createSummary(document);

        summary.setMaxContentLength(200);

        return summary;
    }

    @Override
    protected void doReindex(Object obj) throws Exception {
        Publication publication = (Publication)obj;

        Document document = getDocument(publication);
        SearchEngineUtil.updateDocument(getSearchEngineId(), publication.getCompanyId(), document);


    }

    @Override
    protected void doReindex(String className, long classPK) throws Exception {

        Publication publication = PublicationLocalServiceUtil.getPublication(classPK);
        doReindex(publication);

    }

    @Override
    protected void doReindex(String[] ids) throws Exception {

        long companyId = GetterUtil.getLong(ids[0]);

        reindexEntries(companyId);

    }


    @Override
    protected String getPortletId(SearchContext searchContext) {
        return PORTLET_ID;
    }

    protected String getBasicContentSummary(
        Document document, Locale snippetLocale) {

        String prefix = Field.SNIPPET + StringPool.UNDERLINE;

        String content = document.get(snippetLocale, prefix + Field.DESCRIPTION, prefix + Field.CONTENT);

        if (Validator.isBlank(content)) {
            content = document.get(snippetLocale, Field.DESCRIPTION, Field.CONTENT);
        }

        if (content.length() > 200) {
            content = StringUtil.shorten(content, 200);
        }

        return content;
    }




    protected void reindexEntries(long companyId) throws PortalException, SystemException {

        ActionableDynamicQuery actionableDynamicQuery = new PublicationActionableDynamicQuery(){

            @Override
            protected void addCriteria(DynamicQuery dynamicQuery) {
                Property displayDateProperty = PropertyFactoryUtil.forName("createDate");

                dynamicQuery.add(displayDateProperty.lt(new Date()));
            }

            @Override
            protected void performAction(Object object) throws PortalException {
                Publication entry = (Publication)object;
                Document document = getDocument(entry);
                //System.out.println("add doc :"+document);
                addDocument(document);
            }

        };

        actionableDynamicQuery.setCompanyId(companyId);
        actionableDynamicQuery.setSearchEngineId(getSearchEngineId());

        actionableDynamicQuery.performActions();
    }

}
