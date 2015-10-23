package fr.lagab.portlet.publication.web;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Repository;
import com.liferay.portal.portletfilerepository.PortletFileRepositoryUtil;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.bookmarks.NoSuchFolderException;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.model.DLFolderConstants;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFolderServiceUtil;
import com.liferay.portlet.dynamicdatamapping.model.DDMStructure;
import com.liferay.portlet.dynamicdatamapping.service.DDMStructureLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import fr.lagab.portlet.publication.PublicationTitleException;
import fr.lagab.portlet.publication.model.Publication;
import fr.lagab.portlet.publication.service.PublicationLocalServiceUtil;
import fr.lagab.portlet.publication.web.util.PortletConstants;
import fr.lagab.portlet.publication.web.util.PortletKeys;
import fr.lagab.portlet.publication.web.util.PublicationUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;
import java.io.IOException;
import java.util.Date;
import java.util.Locale;

/**
 * @author lagab
 * @since 13/10/15.
 */
public class PublicationController extends MVCPortlet{

    private static Log LOGGER = LogFactoryUtil.getLog(PublicationController.class.getName());
    //private static final String _TEMP_FOLDER_NAME = Publication.class.getName();

    public void addPublication(ActionRequest actionRequest,ActionResponse actionResponse) throws IOException, PortalException, SystemException{

        //String cmd = ParamUtil.getString(actionRequest, Constants.CMD);


        UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
        long groupId = ParamUtil.getLong(uploadPortletRequest, "groupId");
        long companyId = ParamUtil.getLong(uploadPortletRequest, "companyId");
        long publicationId = ParamUtil.getLong(uploadPortletRequest, "publicationId");
        long structureId = ParamUtil.getLong(uploadPortletRequest, "ddmStructureId");
        long templateId = ParamUtil.getLong(uploadPortletRequest, "ddmTemplateId");
        int status = 1;
        String title = ParamUtil.getString(uploadPortletRequest, "title");
        String description = ParamUtil.getString(uploadPortletRequest, "description");
        Date createDate = new Date();
        ThemeDisplay themeDisplay =	(ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        companyId = themeDisplay.getCompanyId();
        long userId = themeDisplay.getUserId();
        String userName = themeDisplay.getUser().getScreenName();

        Publication publication = null;

        ServiceContext serviceContext = ServiceContextFactory.getInstance(Publication.class.getName(), uploadPortletRequest);

        long folderId = ParamUtil.getLong(uploadPortletRequest, "folderId");
        String defaultLanguageId = ParamUtil.getString(uploadPortletRequest, "defaultLanguageId");

        Locale defaultLocale = LocaleUtil.fromLanguageId(defaultLanguageId);
        String content = "";


        DDMStructure ddmStructure;

        if (Validator.isNotNull(structureId)) {

            ddmStructure = DDMStructureLocalServiceUtil.getStructure(
                    PortalUtil.getSiteGroupId(groupId),
                    PortalUtil.getClassNameId(Publication.class), StringUtil.valueOf(structureId),
                    true);
            try {
                Object[] contentAndImages = PublicationUtil.getContentAndImages(
                        ddmStructure, themeDisplay.getLocale(), serviceContext);
                content = (String)contentAndImages[0];
                LOGGER.info(content);
            } catch (Exception e) {
                LOGGER.error(e);
            }

        }



        String folderName = StringUtil.valueOf(CounterLocalServiceUtil.increment());


        if( folderId == 0 ){
            PortletPreferences prefs = actionRequest.getPreferences();
            long rootFolderId = GetterUtil.getLong(prefs.getValue("rootFolderId", StringUtil.valueOf(DLFolderConstants.DEFAULT_PARENT_FOLDER_ID)) );
            //folderId = generateFolder(rootFolderId,groupId,folderName,serviceContext);
        }
        actionRequest.setAttribute("folderId", folderId);
        actionRequest.setAttribute("repositoryId", groupId);
        String[] selectedFiles = ParamUtil.getParameterValues(uploadPortletRequest,"selectUploadedFileCheckbox");
        if(selectedFiles.length >0){
            LOGGER.debug("there are " + selectedFiles.length + " files to upload :");
            //addMultipleFileEntries(actionRequest, uploadPortletRequest, actionResponse);
        }else{
            LOGGER.debug("there are no files to upload");
        }

        validate(title,content,structureId, folderId);

        try {
            if (publicationId <= 0) {
                LOGGER.info("add publication");
                publication = PublicationLocalServiceUtil.addPublication(companyId,groupId, userId, createDate, folderId, title, content, description, structureId, templateId, status, serviceContext);

            } else {
                LOGGER.info("update publication");
                publication = PublicationLocalServiceUtil.updatePublication(publicationId, userId, title, description,content,serviceContext);

            }
            LOGGER.info(publication.getTitle());
        /*if( publicationId <= 0){
                    }else{
                    }
        LOGGER.info(publication.getTitle());*/
            SessionMessages.add(actionRequest, "publicationAdded");
            String redirect = ParamUtil.getString(uploadPortletRequest, "redirect");

            actionResponse.sendRedirect(redirect);
        }  catch (Exception e) {
                LOGGER.error(e);
                SessionErrors.add(actionRequest, e.getClass().getName());

                if (e instanceof PrincipalException) {

                    actionResponse.setRenderParameter("jspPage", "/html/publication/admin/edit_publication.jsp");
                }
                else {
                    actionResponse.setRenderParameter("jspPage", "/html/error.jsp");
                }
            }


    }

    protected long generateFolder( long rootFolderId, long repositoryId, String folderName, ServiceContext serviceContext) throws SystemException, PortalException {
        Folder parentFolder;

        if(rootFolderId == DLFolderConstants.DEFAULT_PARENT_FOLDER_ID ){
            Repository repository = PortletFileRepositoryUtil.addPortletRepository(repositoryId, PortletKeys.PUBLICATION_PORTLET, serviceContext);
            DLFolder relatedFolder = DLFolderServiceUtil.getFolder(repository.getDlFolderId());
            if(relatedFolder.isHidden()){
                relatedFolder.setHidden(false);
                relatedFolder.persist();
            }

            repositoryId = repository.getRepositoryId();
            parentFolder = getOrCreateFolder(repositoryId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, PortletConstants.BASIC_POST_FOLDERNAME, StringPool.BLANK, serviceContext);
            rootFolderId = parentFolder.getFolderId();

        }

        Folder folder=DLAppServiceUtil.addFolder(repositoryId, rootFolderId, folderName,StringPool.BLANK, serviceContext);

        return folder.getFolderId();

    }

    protected Folder getOrCreateFolder(long repositoryId,long parentFolderId,String folderName, String description, ServiceContext serviceContext) throws PortalException, SystemException{
        try{
            return DLAppServiceUtil.getFolder(repositoryId, parentFolderId, folderName);
        }catch(NoSuchFolderException e){
            return DLAppServiceUtil.addFolder(repositoryId, parentFolderId, folderName, description, serviceContext);
        }
    }

    protected void validate(String title, String content, long ddmStructureId, long folderId) throws PortalException, SystemException{

        if(title.isEmpty()){
            throw new PublicationTitleException();
        }
        if(folderId > 0){
            DLAppServiceUtil.getFolder(folderId);
        }

        if( ddmStructureId > 0 ){
            DDMStructureLocalServiceUtil.getStructure(ddmStructureId);
        }
    }


}
