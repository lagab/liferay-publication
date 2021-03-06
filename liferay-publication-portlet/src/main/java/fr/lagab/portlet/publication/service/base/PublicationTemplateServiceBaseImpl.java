package fr.lagab.portlet.publication.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.InfrastructureUtil;
import com.liferay.portal.service.BaseServiceImpl;
import com.liferay.portal.service.persistence.GroupPersistence;
import com.liferay.portal.service.persistence.ImagePersistence;
import com.liferay.portal.service.persistence.UserPersistence;

import com.liferay.portlet.dynamicdatamapping.service.persistence.DDMTemplatePersistence;

import fr.lagab.portlet.publication.service.PublicationTemplateService;
import fr.lagab.portlet.publication.service.persistence.PublicationPersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the publication template remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link fr.lagab.portlet.publication.service.impl.PublicationTemplateServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see fr.lagab.portlet.publication.service.impl.PublicationTemplateServiceImpl
 * @see fr.lagab.portlet.publication.service.PublicationTemplateServiceUtil
 * @generated
 */
public abstract class PublicationTemplateServiceBaseImpl extends BaseServiceImpl
    implements PublicationTemplateService, IdentifiableBean {
    @BeanReference(type = fr.lagab.portlet.publication.service.PublicationLocalService.class)
    protected fr.lagab.portlet.publication.service.PublicationLocalService publicationLocalService;
    @BeanReference(type = fr.lagab.portlet.publication.service.PublicationService.class)
    protected fr.lagab.portlet.publication.service.PublicationService publicationService;
    @BeanReference(type = PublicationPersistence.class)
    protected PublicationPersistence publicationPersistence;
    @BeanReference(type = fr.lagab.portlet.publication.service.PublicationStructureLocalService.class)
    @SuppressWarnings("deprecation")
    protected fr.lagab.portlet.publication.service.PublicationStructureLocalService publicationStructureLocalService;
    @BeanReference(type = fr.lagab.portlet.publication.service.PublicationStructureService.class)
    @SuppressWarnings("deprecation")
    protected fr.lagab.portlet.publication.service.PublicationStructureService publicationStructureService;
    @BeanReference(type = fr.lagab.portlet.publication.service.PublicationTemplateLocalService.class)
    @SuppressWarnings("deprecation")
    protected fr.lagab.portlet.publication.service.PublicationTemplateLocalService publicationTemplateLocalService;
    @BeanReference(type = fr.lagab.portlet.publication.service.PublicationTemplateService.class)
    @SuppressWarnings("deprecation")
    protected fr.lagab.portlet.publication.service.PublicationTemplateService publicationTemplateService;
    @BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
    protected com.liferay.counter.service.CounterLocalService counterLocalService;
    @BeanReference(type = com.liferay.portal.service.GroupLocalService.class)
    protected com.liferay.portal.service.GroupLocalService groupLocalService;
    @BeanReference(type = com.liferay.portal.service.GroupService.class)
    protected com.liferay.portal.service.GroupService groupService;
    @BeanReference(type = GroupPersistence.class)
    protected GroupPersistence groupPersistence;
    @BeanReference(type = com.liferay.portal.service.ImageLocalService.class)
    protected com.liferay.portal.service.ImageLocalService imageLocalService;
    @BeanReference(type = com.liferay.portal.service.ImageService.class)
    protected com.liferay.portal.service.ImageService imageService;
    @BeanReference(type = ImagePersistence.class)
    protected ImagePersistence imagePersistence;
    @BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
    protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
    @BeanReference(type = com.liferay.portal.service.UserLocalService.class)
    protected com.liferay.portal.service.UserLocalService userLocalService;
    @BeanReference(type = com.liferay.portal.service.UserService.class)
    protected com.liferay.portal.service.UserService userService;
    @BeanReference(type = UserPersistence.class)
    protected UserPersistence userPersistence;
    @BeanReference(type = com.liferay.portlet.dynamicdatamapping.service.DDMTemplateLocalService.class)
    protected com.liferay.portlet.dynamicdatamapping.service.DDMTemplateLocalService ddmTemplateLocalService;
    @BeanReference(type = com.liferay.portlet.dynamicdatamapping.service.DDMTemplateService.class)
    protected com.liferay.portlet.dynamicdatamapping.service.DDMTemplateService ddmTemplateService;
    @BeanReference(type = DDMTemplatePersistence.class)
    protected DDMTemplatePersistence ddmTemplatePersistence;
    private String _beanIdentifier;
    private ClassLoader _classLoader;
    private PublicationTemplateServiceClpInvoker _clpInvoker = new PublicationTemplateServiceClpInvoker();

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link fr.lagab.portlet.publication.service.PublicationTemplateServiceUtil} to access the publication template remote service.
     */

    /**
     * Returns the publication local service.
     *
     * @return the publication local service
     */
    public fr.lagab.portlet.publication.service.PublicationLocalService getPublicationLocalService() {
        return publicationLocalService;
    }

    /**
     * Sets the publication local service.
     *
     * @param publicationLocalService the publication local service
     */
    public void setPublicationLocalService(
        fr.lagab.portlet.publication.service.PublicationLocalService publicationLocalService) {
        this.publicationLocalService = publicationLocalService;
    }

    /**
     * Returns the publication remote service.
     *
     * @return the publication remote service
     */
    public fr.lagab.portlet.publication.service.PublicationService getPublicationService() {
        return publicationService;
    }

    /**
     * Sets the publication remote service.
     *
     * @param publicationService the publication remote service
     */
    public void setPublicationService(
        fr.lagab.portlet.publication.service.PublicationService publicationService) {
        this.publicationService = publicationService;
    }

    /**
     * Returns the publication persistence.
     *
     * @return the publication persistence
     */
    public PublicationPersistence getPublicationPersistence() {
        return publicationPersistence;
    }

    /**
     * Sets the publication persistence.
     *
     * @param publicationPersistence the publication persistence
     */
    public void setPublicationPersistence(
        PublicationPersistence publicationPersistence) {
        this.publicationPersistence = publicationPersistence;
    }

    /**
     * Returns the publication structure local service.
     *
     * @return the publication structure local service
     */
    @SuppressWarnings("deprecation")
    public fr.lagab.portlet.publication.service.PublicationStructureLocalService getPublicationStructureLocalService() {
        return publicationStructureLocalService;
    }

    /**
     * Sets the publication structure local service.
     *
     * @param publicationStructureLocalService the publication structure local service
     */
    @SuppressWarnings("deprecation")
    public void setPublicationStructureLocalService(
        fr.lagab.portlet.publication.service.PublicationStructureLocalService publicationStructureLocalService) {
        this.publicationStructureLocalService = publicationStructureLocalService;
    }

    /**
     * Returns the publication structure remote service.
     *
     * @return the publication structure remote service
     */
    @SuppressWarnings("deprecation")
    public fr.lagab.portlet.publication.service.PublicationStructureService getPublicationStructureService() {
        return publicationStructureService;
    }

    /**
     * Sets the publication structure remote service.
     *
     * @param publicationStructureService the publication structure remote service
     */
    @SuppressWarnings("deprecation")
    public void setPublicationStructureService(
        fr.lagab.portlet.publication.service.PublicationStructureService publicationStructureService) {
        this.publicationStructureService = publicationStructureService;
    }

    /**
     * Returns the publication template local service.
     *
     * @return the publication template local service
     */
    @SuppressWarnings("deprecation")
    public fr.lagab.portlet.publication.service.PublicationTemplateLocalService getPublicationTemplateLocalService() {
        return publicationTemplateLocalService;
    }

    /**
     * Sets the publication template local service.
     *
     * @param publicationTemplateLocalService the publication template local service
     */
    @SuppressWarnings("deprecation")
    public void setPublicationTemplateLocalService(
        fr.lagab.portlet.publication.service.PublicationTemplateLocalService publicationTemplateLocalService) {
        this.publicationTemplateLocalService = publicationTemplateLocalService;
    }

    /**
     * Returns the publication template remote service.
     *
     * @return the publication template remote service
     */
    @SuppressWarnings("deprecation")
    public fr.lagab.portlet.publication.service.PublicationTemplateService getPublicationTemplateService() {
        return publicationTemplateService;
    }

    /**
     * Sets the publication template remote service.
     *
     * @param publicationTemplateService the publication template remote service
     */
    @SuppressWarnings("deprecation")
    public void setPublicationTemplateService(
        fr.lagab.portlet.publication.service.PublicationTemplateService publicationTemplateService) {
        this.publicationTemplateService = publicationTemplateService;
    }

    /**
     * Returns the counter local service.
     *
     * @return the counter local service
     */
    public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
        return counterLocalService;
    }

    /**
     * Sets the counter local service.
     *
     * @param counterLocalService the counter local service
     */
    public void setCounterLocalService(
        com.liferay.counter.service.CounterLocalService counterLocalService) {
        this.counterLocalService = counterLocalService;
    }

    /**
     * Returns the group local service.
     *
     * @return the group local service
     */
    public com.liferay.portal.service.GroupLocalService getGroupLocalService() {
        return groupLocalService;
    }

    /**
     * Sets the group local service.
     *
     * @param groupLocalService the group local service
     */
    public void setGroupLocalService(
        com.liferay.portal.service.GroupLocalService groupLocalService) {
        this.groupLocalService = groupLocalService;
    }

    /**
     * Returns the group remote service.
     *
     * @return the group remote service
     */
    public com.liferay.portal.service.GroupService getGroupService() {
        return groupService;
    }

    /**
     * Sets the group remote service.
     *
     * @param groupService the group remote service
     */
    public void setGroupService(
        com.liferay.portal.service.GroupService groupService) {
        this.groupService = groupService;
    }

    /**
     * Returns the group persistence.
     *
     * @return the group persistence
     */
    public GroupPersistence getGroupPersistence() {
        return groupPersistence;
    }

    /**
     * Sets the group persistence.
     *
     * @param groupPersistence the group persistence
     */
    public void setGroupPersistence(GroupPersistence groupPersistence) {
        this.groupPersistence = groupPersistence;
    }

    /**
     * Returns the image local service.
     *
     * @return the image local service
     */
    public com.liferay.portal.service.ImageLocalService getImageLocalService() {
        return imageLocalService;
    }

    /**
     * Sets the image local service.
     *
     * @param imageLocalService the image local service
     */
    public void setImageLocalService(
        com.liferay.portal.service.ImageLocalService imageLocalService) {
        this.imageLocalService = imageLocalService;
    }

    /**
     * Returns the image remote service.
     *
     * @return the image remote service
     */
    public com.liferay.portal.service.ImageService getImageService() {
        return imageService;
    }

    /**
     * Sets the image remote service.
     *
     * @param imageService the image remote service
     */
    public void setImageService(
        com.liferay.portal.service.ImageService imageService) {
        this.imageService = imageService;
    }

    /**
     * Returns the image persistence.
     *
     * @return the image persistence
     */
    public ImagePersistence getImagePersistence() {
        return imagePersistence;
    }

    /**
     * Sets the image persistence.
     *
     * @param imagePersistence the image persistence
     */
    public void setImagePersistence(ImagePersistence imagePersistence) {
        this.imagePersistence = imagePersistence;
    }

    /**
     * Returns the resource local service.
     *
     * @return the resource local service
     */
    public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
        return resourceLocalService;
    }

    /**
     * Sets the resource local service.
     *
     * @param resourceLocalService the resource local service
     */
    public void setResourceLocalService(
        com.liferay.portal.service.ResourceLocalService resourceLocalService) {
        this.resourceLocalService = resourceLocalService;
    }

    /**
     * Returns the user local service.
     *
     * @return the user local service
     */
    public com.liferay.portal.service.UserLocalService getUserLocalService() {
        return userLocalService;
    }

    /**
     * Sets the user local service.
     *
     * @param userLocalService the user local service
     */
    public void setUserLocalService(
        com.liferay.portal.service.UserLocalService userLocalService) {
        this.userLocalService = userLocalService;
    }

    /**
     * Returns the user remote service.
     *
     * @return the user remote service
     */
    public com.liferay.portal.service.UserService getUserService() {
        return userService;
    }

    /**
     * Sets the user remote service.
     *
     * @param userService the user remote service
     */
    public void setUserService(
        com.liferay.portal.service.UserService userService) {
        this.userService = userService;
    }

    /**
     * Returns the user persistence.
     *
     * @return the user persistence
     */
    public UserPersistence getUserPersistence() {
        return userPersistence;
    }

    /**
     * Sets the user persistence.
     *
     * @param userPersistence the user persistence
     */
    public void setUserPersistence(UserPersistence userPersistence) {
        this.userPersistence = userPersistence;
    }

    /**
     * Returns the d d m template local service.
     *
     * @return the d d m template local service
     */
    public com.liferay.portlet.dynamicdatamapping.service.DDMTemplateLocalService getDDMTemplateLocalService() {
        return ddmTemplateLocalService;
    }

    /**
     * Sets the d d m template local service.
     *
     * @param ddmTemplateLocalService the d d m template local service
     */
    public void setDDMTemplateLocalService(
        com.liferay.portlet.dynamicdatamapping.service.DDMTemplateLocalService ddmTemplateLocalService) {
        this.ddmTemplateLocalService = ddmTemplateLocalService;
    }

    /**
     * Returns the d d m template remote service.
     *
     * @return the d d m template remote service
     */
    public com.liferay.portlet.dynamicdatamapping.service.DDMTemplateService getDDMTemplateService() {
        return ddmTemplateService;
    }

    /**
     * Sets the d d m template remote service.
     *
     * @param ddmTemplateService the d d m template remote service
     */
    public void setDDMTemplateService(
        com.liferay.portlet.dynamicdatamapping.service.DDMTemplateService ddmTemplateService) {
        this.ddmTemplateService = ddmTemplateService;
    }

    /**
     * Returns the d d m template persistence.
     *
     * @return the d d m template persistence
     */
    public DDMTemplatePersistence getDDMTemplatePersistence() {
        return ddmTemplatePersistence;
    }

    /**
     * Sets the d d m template persistence.
     *
     * @param ddmTemplatePersistence the d d m template persistence
     */
    public void setDDMTemplatePersistence(
        DDMTemplatePersistence ddmTemplatePersistence) {
        this.ddmTemplatePersistence = ddmTemplatePersistence;
    }

    public void afterPropertiesSet() {
        Class<?> clazz = getClass();

        _classLoader = clazz.getClassLoader();
    }

    public void destroy() {
    }

    /**
     * Returns the Spring bean ID for this bean.
     *
     * @return the Spring bean ID for this bean
     */
    @Override
    public String getBeanIdentifier() {
        return _beanIdentifier;
    }

    /**
     * Sets the Spring bean ID for this bean.
     *
     * @param beanIdentifier the Spring bean ID for this bean
     */
    @Override
    public void setBeanIdentifier(String beanIdentifier) {
        _beanIdentifier = beanIdentifier;
    }

    @Override
    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        Thread currentThread = Thread.currentThread();

        ClassLoader contextClassLoader = currentThread.getContextClassLoader();

        if (contextClassLoader != _classLoader) {
            currentThread.setContextClassLoader(_classLoader);
        }

        try {
            return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
        } finally {
            if (contextClassLoader != _classLoader) {
                currentThread.setContextClassLoader(contextClassLoader);
            }
        }
    }

    /**
     * Performs an SQL query.
     *
     * @param sql the sql query
     */
    protected void runSQL(String sql) throws SystemException {
        try {
            DataSource dataSource = InfrastructureUtil.getDataSource();

            SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
                    sql, new int[0]);

            sqlUpdate.update();
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
