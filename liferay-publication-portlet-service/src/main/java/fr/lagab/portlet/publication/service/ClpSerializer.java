package fr.lagab.portlet.publication.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import fr.lagab.portlet.publication.model.PublicationClp;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;


public class ClpSerializer {
    private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
    private static String _servletContextName;
    private static boolean _useReflectionToTranslateThrowable = true;

    public static String getServletContextName() {
        if (Validator.isNotNull(_servletContextName)) {
            return _servletContextName;
        }

        synchronized (ClpSerializer.class) {
            if (Validator.isNotNull(_servletContextName)) {
                return _servletContextName;
            }

            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Class<?> portletPropsClass = classLoader.loadClass(
                        "com.liferay.util.portlet.PortletProps");

                Method getMethod = portletPropsClass.getMethod("get",
                        new Class<?>[] { String.class });

                String portletPropsServletContextName = (String) getMethod.invoke(null,
                        "liferay-publication-portlet-deployment-context");

                if (Validator.isNotNull(portletPropsServletContextName)) {
                    _servletContextName = portletPropsServletContextName;
                }
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info(
                        "Unable to locate deployment context from portlet properties");
                }
            }

            if (Validator.isNull(_servletContextName)) {
                try {
                    String propsUtilServletContextName = PropsUtil.get(
                            "liferay-publication-portlet-deployment-context");

                    if (Validator.isNotNull(propsUtilServletContextName)) {
                        _servletContextName = propsUtilServletContextName;
                    }
                } catch (Throwable t) {
                    if (_log.isInfoEnabled()) {
                        _log.info(
                            "Unable to locate deployment context from portal properties");
                    }
                }
            }

            if (Validator.isNull(_servletContextName)) {
                _servletContextName = "liferay-publication-portlet";
            }

            return _servletContextName;
        }
    }

    public static Object translateInput(BaseModel<?> oldModel) {
        Class<?> oldModelClass = oldModel.getClass();

        String oldModelClassName = oldModelClass.getName();

        if (oldModelClassName.equals(PublicationClp.class.getName())) {
            return translateInputPublication(oldModel);
        }

        return oldModel;
    }

    public static Object translateInput(List<Object> oldList) {
        List<Object> newList = new ArrayList<Object>(oldList.size());

        for (int i = 0; i < oldList.size(); i++) {
            Object curObj = oldList.get(i);

            newList.add(translateInput(curObj));
        }

        return newList;
    }

    public static Object translateInputPublication(BaseModel<?> oldModel) {
        PublicationClp oldClpModel = (PublicationClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getPublicationRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInput(Object obj) {
        if (obj instanceof BaseModel<?>) {
            return translateInput((BaseModel<?>) obj);
        } else if (obj instanceof List<?>) {
            return translateInput((List<Object>) obj);
        } else {
            return obj;
        }
    }

    public static Object translateOutput(BaseModel<?> oldModel) {
        Class<?> oldModelClass = oldModel.getClass();

        String oldModelClassName = oldModelClass.getName();

        if (oldModelClassName.equals(
                    "fr.lagab.portlet.publication.model.impl.PublicationImpl")) {
            return translateOutputPublication(oldModel);
        } else if (oldModelClassName.endsWith("Clp")) {
            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Method getClpSerializerClassMethod = oldModelClass.getMethod(
                        "getClpSerializerClass");

                Class<?> oldClpSerializerClass = (Class<?>) getClpSerializerClassMethod.invoke(oldModel);

                Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

                Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
                        BaseModel.class);

                Class<?> oldModelModelClass = oldModel.getModelClass();

                Method getRemoteModelMethod = oldModelClass.getMethod("get" +
                        oldModelModelClass.getSimpleName() + "RemoteModel");

                Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

                BaseModel<?> newModel = (BaseModel<?>) translateOutputMethod.invoke(null,
                        oldRemoteModel);

                return newModel;
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info("Unable to translate " + oldModelClassName, t);
                }
            }
        }

        return oldModel;
    }

    public static Object translateOutput(List<Object> oldList) {
        List<Object> newList = new ArrayList<Object>(oldList.size());

        for (int i = 0; i < oldList.size(); i++) {
            Object curObj = oldList.get(i);

            newList.add(translateOutput(curObj));
        }

        return newList;
    }

    public static Object translateOutput(Object obj) {
        if (obj instanceof BaseModel<?>) {
            return translateOutput((BaseModel<?>) obj);
        } else if (obj instanceof List<?>) {
            return translateOutput((List<Object>) obj);
        } else {
            return obj;
        }
    }

    public static Throwable translateThrowable(Throwable throwable) {
        if (_useReflectionToTranslateThrowable) {
            try {
                UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

                objectOutputStream.writeObject(throwable);

                objectOutputStream.flush();
                objectOutputStream.close();

                UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
                        0, unsyncByteArrayOutputStream.size());

                Thread currentThread = Thread.currentThread();

                ClassLoader contextClassLoader = currentThread.getContextClassLoader();

                ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
                        contextClassLoader);

                throwable = (Throwable) objectInputStream.readObject();

                objectInputStream.close();

                return throwable;
            } catch (SecurityException se) {
                if (_log.isInfoEnabled()) {
                    _log.info("Do not use reflection to translate throwable");
                }

                _useReflectionToTranslateThrowable = false;
            } catch (Throwable throwable2) {
                _log.error(throwable2, throwable2);

                return throwable2;
            }
        }

        Class<?> clazz = throwable.getClass();

        String className = clazz.getName();

        if (className.equals(PortalException.class.getName())) {
            return new PortalException();
        }

        if (className.equals(SystemException.class.getName())) {
            return new SystemException();
        }

        if (className.equals(
                    "fr.lagab.portlet.publication.DuplicateFolderNameException")) {
            return new fr.lagab.portlet.publication.DuplicateFolderNameException();
        }

        if (className.equals(
                    "fr.lagab.portlet.publication.DuplicatePublicationIdException")) {
            return new fr.lagab.portlet.publication.DuplicatePublicationIdException();
        }

        if (className.equals(
                    "fr.lagab.portlet.publication.DuplicateStructureElementException")) {
            return new fr.lagab.portlet.publication.DuplicateStructureElementException();
        }

        if (className.equals(
                    "fr.lagab.portlet.publication.DuplicateStructureIdException")) {
            return new fr.lagab.portlet.publication.DuplicateStructureIdException();
        }

        if (className.equals(
                    "fr.lagab.portlet.publication.DuplicateTemplateIdException")) {
            return new fr.lagab.portlet.publication.DuplicateTemplateIdException();
        }

        if (className.equals("fr.lagab.portlet.publication.FolderNameException")) {
            return new fr.lagab.portlet.publication.FolderNameException();
        }

        if (className.equals(
                    "fr.lagab.portlet.publication.NoSuchStructureException")) {
            return new fr.lagab.portlet.publication.NoSuchStructureException();
        }

        if (className.equals(
                    "fr.lagab.portlet.publication.NoSuchTemplateException")) {
            return new fr.lagab.portlet.publication.NoSuchTemplateException();
        }

        if (className.equals(
                    "fr.lagab.portlet.publication.PublicationContentException")) {
            return new fr.lagab.portlet.publication.PublicationContentException();
        }

        if (className.equals(
                    "fr.lagab.portlet.publication.PublicationContentSizeException")) {
            return new fr.lagab.portlet.publication.PublicationContentSizeException();
        }

        if (className.equals(
                    "fr.lagab.portlet.publication.PublicationTitleException")) {
            return new fr.lagab.portlet.publication.PublicationTitleException();
        }

        if (className.equals(
                    "fr.lagab.portlet.publication.RequiredStructureException")) {
            return new fr.lagab.portlet.publication.RequiredStructureException();
        }

        if (className.equals(
                    "fr.lagab.portlet.publication.RequiredTemplateException")) {
            return new fr.lagab.portlet.publication.RequiredTemplateException();
        }

        if (className.equals(
                    "fr.lagab.portlet.publication.StructureIdException")) {
            return new fr.lagab.portlet.publication.StructureIdException();
        }

        if (className.equals(
                    "fr.lagab.portlet.publication.StructureInheritanceException")) {
            return new fr.lagab.portlet.publication.StructureInheritanceException();
        }

        if (className.equals(
                    "fr.lagab.portlet.publication.StructureNameException")) {
            return new fr.lagab.portlet.publication.StructureNameException();
        }

        if (className.equals(
                    "fr.lagab.portlet.publication.StructureXsdException")) {
            return new fr.lagab.portlet.publication.StructureXsdException();
        }

        if (className.equals("fr.lagab.portlet.publication.TemplateIdException")) {
            return new fr.lagab.portlet.publication.TemplateIdException();
        }

        if (className.equals(
                    "fr.lagab.portlet.publication.TemplateNameException")) {
            return new fr.lagab.portlet.publication.TemplateNameException();
        }

        if (className.equals(
                    "fr.lagab.portlet.publication.TemplateXslException")) {
            return new fr.lagab.portlet.publication.TemplateXslException();
        }

        if (className.equals(
                    "fr.lagab.portlet.publication.NoSuchPublicationException")) {
            return new fr.lagab.portlet.publication.NoSuchPublicationException();
        }

        return throwable;
    }

    public static Object translateOutputPublication(BaseModel<?> oldModel) {
        PublicationClp newModel = new PublicationClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setPublicationRemoteModel(oldModel);

        return newModel;
    }
}
