package fr.lagab.portlet.publication.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import fr.lagab.portlet.publication.service.PublicationServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link fr.lagab.portlet.publication.service.PublicationServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link fr.lagab.portlet.publication.model.PublicationSoap}.
 * If the method in the service utility returns a
 * {@link fr.lagab.portlet.publication.model.Publication}, that is translated to a
 * {@link fr.lagab.portlet.publication.model.PublicationSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PublicationServiceHttp
 * @see fr.lagab.portlet.publication.model.PublicationSoap
 * @see fr.lagab.portlet.publication.service.PublicationServiceUtil
 * @generated
 */
public class PublicationServiceSoap {
    private static Log _log = LogFactoryUtil.getLog(PublicationServiceSoap.class);

    public static int countPublication(long groupId) throws RemoteException {
        try {
            int returnValue = PublicationServiceUtil.countPublication(groupId);

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static int countAllPublication() throws RemoteException {
        try {
            int returnValue = PublicationServiceUtil.countAllPublication();

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static int countPublication(long groupId, long userId)
        throws RemoteException {
        try {
            int returnValue = PublicationServiceUtil.countPublication(groupId,
                    userId);

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static int countPublicationsByStructureId(long groupId,
        long structureId) throws RemoteException {
        try {
            int returnValue = PublicationServiceUtil.countPublicationsByStructureId(groupId,
                    structureId);

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static fr.lagab.portlet.publication.model.PublicationSoap[] getAllPublications()
        throws RemoteException {
        try {
            java.util.List<fr.lagab.portlet.publication.model.Publication> returnValue =
                PublicationServiceUtil.getAllPublications();

            return fr.lagab.portlet.publication.model.PublicationSoap.toSoapModels(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static fr.lagab.portlet.publication.model.PublicationSoap[] getAllPublications(
        int start, int end) throws RemoteException {
        try {
            java.util.List<fr.lagab.portlet.publication.model.Publication> returnValue =
                PublicationServiceUtil.getAllPublications(start, end);

            return fr.lagab.portlet.publication.model.PublicationSoap.toSoapModels(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static fr.lagab.portlet.publication.model.PublicationSoap[] getAllPublications(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws RemoteException {
        try {
            java.util.List<fr.lagab.portlet.publication.model.Publication> returnValue =
                PublicationServiceUtil.getAllPublications(start, end, obc);

            return fr.lagab.portlet.publication.model.PublicationSoap.toSoapModels(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static fr.lagab.portlet.publication.model.PublicationSoap[] getPublications(
        long groupId) throws RemoteException {
        try {
            java.util.List<fr.lagab.portlet.publication.model.Publication> returnValue =
                PublicationServiceUtil.getPublications(groupId);

            return fr.lagab.portlet.publication.model.PublicationSoap.toSoapModels(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static fr.lagab.portlet.publication.model.PublicationSoap[] getPublications(
        long groupId, int start, int end) throws RemoteException {
        try {
            java.util.List<fr.lagab.portlet.publication.model.Publication> returnValue =
                PublicationServiceUtil.getPublications(groupId, start, end);

            return fr.lagab.portlet.publication.model.PublicationSoap.toSoapModels(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static fr.lagab.portlet.publication.model.PublicationSoap[] getPublications(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws RemoteException {
        try {
            java.util.List<fr.lagab.portlet.publication.model.Publication> returnValue =
                PublicationServiceUtil.getPublications(groupId, start, end, obc);

            return fr.lagab.portlet.publication.model.PublicationSoap.toSoapModels(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static fr.lagab.portlet.publication.model.PublicationSoap[] getUserPublications(
        long groupId, long userId) throws RemoteException {
        try {
            java.util.List<fr.lagab.portlet.publication.model.Publication> returnValue =
                PublicationServiceUtil.getUserPublications(groupId, userId);

            return fr.lagab.portlet.publication.model.PublicationSoap.toSoapModels(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static fr.lagab.portlet.publication.model.PublicationSoap[] getUserPublications(
        long groupId, long userId, int start, int end)
        throws RemoteException {
        try {
            java.util.List<fr.lagab.portlet.publication.model.Publication> returnValue =
                PublicationServiceUtil.getUserPublications(groupId, userId,
                    start, end);

            return fr.lagab.portlet.publication.model.PublicationSoap.toSoapModels(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static fr.lagab.portlet.publication.model.PublicationSoap[] getUserPublications(
        long groupId, long userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws RemoteException {
        try {
            java.util.List<fr.lagab.portlet.publication.model.Publication> returnValue =
                PublicationServiceUtil.getUserPublications(groupId, userId,
                    start, end, obc);

            return fr.lagab.portlet.publication.model.PublicationSoap.toSoapModels(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static fr.lagab.portlet.publication.model.PublicationSoap getPublication(
        long entryId) throws RemoteException {
        try {
            fr.lagab.portlet.publication.model.Publication returnValue = PublicationServiceUtil.getPublication(entryId);

            return fr.lagab.portlet.publication.model.PublicationSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static fr.lagab.portlet.publication.model.PublicationSoap[] getPublicationsByStructureId(
        long groupId, long structureId) throws RemoteException {
        try {
            java.util.List<fr.lagab.portlet.publication.model.Publication> returnValue =
                PublicationServiceUtil.getPublicationsByStructureId(groupId,
                    structureId);

            return fr.lagab.portlet.publication.model.PublicationSoap.toSoapModels(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static fr.lagab.portlet.publication.model.PublicationSoap[] getPublicationsByStructureId(
        long groupId, long structureId, int start, int end)
        throws RemoteException {
        try {
            java.util.List<fr.lagab.portlet.publication.model.Publication> returnValue =
                PublicationServiceUtil.getPublicationsByStructureId(groupId,
                    structureId, start, end);

            return fr.lagab.portlet.publication.model.PublicationSoap.toSoapModels(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static fr.lagab.portlet.publication.model.PublicationSoap[] getPublicationsByStructureId(
        long groupId, long structureId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws RemoteException {
        try {
            java.util.List<fr.lagab.portlet.publication.model.Publication> returnValue =
                PublicationServiceUtil.getPublicationsByStructureId(groupId,
                    structureId, start, end, obc);

            return fr.lagab.portlet.publication.model.PublicationSoap.toSoapModels(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }
}
