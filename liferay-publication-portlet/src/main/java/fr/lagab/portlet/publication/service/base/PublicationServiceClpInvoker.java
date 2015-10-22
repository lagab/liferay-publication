package fr.lagab.portlet.publication.service.base;

import fr.lagab.portlet.publication.service.PublicationServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PublicationServiceClpInvoker {
    private String _methodName94;
    private String[] _methodParameterTypes94;
    private String _methodName95;
    private String[] _methodParameterTypes95;
    private String _methodName100;
    private String[] _methodParameterTypes100;
    private String _methodName101;
    private String[] _methodParameterTypes101;
    private String _methodName102;
    private String[] _methodParameterTypes102;
    private String _methodName103;
    private String[] _methodParameterTypes103;
    private String _methodName104;
    private String[] _methodParameterTypes104;
    private String _methodName105;
    private String[] _methodParameterTypes105;
    private String _methodName106;
    private String[] _methodParameterTypes106;
    private String _methodName107;
    private String[] _methodParameterTypes107;
    private String _methodName108;
    private String[] _methodParameterTypes108;
    private String _methodName109;
    private String[] _methodParameterTypes109;
    private String _methodName110;
    private String[] _methodParameterTypes110;
    private String _methodName111;
    private String[] _methodParameterTypes111;
    private String _methodName112;
    private String[] _methodParameterTypes112;
    private String _methodName113;
    private String[] _methodParameterTypes113;
    private String _methodName114;
    private String[] _methodParameterTypes114;
    private String _methodName115;
    private String[] _methodParameterTypes115;
    private String _methodName116;
    private String[] _methodParameterTypes116;

    public PublicationServiceClpInvoker() {
        _methodName94 = "getBeanIdentifier";

        _methodParameterTypes94 = new String[] {  };

        _methodName95 = "setBeanIdentifier";

        _methodParameterTypes95 = new String[] { "java.lang.String" };

        _methodName100 = "countPublication";

        _methodParameterTypes100 = new String[] { "long" };

        _methodName101 = "countAllPublication";

        _methodParameterTypes101 = new String[] {  };

        _methodName102 = "countPublication";

        _methodParameterTypes102 = new String[] { "long", "long" };

        _methodName103 = "countPublicationsByStructureId";

        _methodParameterTypes103 = new String[] { "long", "long" };

        _methodName104 = "getAllPublications";

        _methodParameterTypes104 = new String[] {  };

        _methodName105 = "getAllPublications";

        _methodParameterTypes105 = new String[] { "int", "int" };

        _methodName106 = "getAllPublications";

        _methodParameterTypes106 = new String[] {
                "int", "int", "com.liferay.portal.kernel.util.OrderByComparator"
            };

        _methodName107 = "getPublications";

        _methodParameterTypes107 = new String[] { "long" };

        _methodName108 = "getPublications";

        _methodParameterTypes108 = new String[] { "long", "int", "int" };

        _methodName109 = "getPublications";

        _methodParameterTypes109 = new String[] {
                "long", "int", "int",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };

        _methodName110 = "getUserPublications";

        _methodParameterTypes110 = new String[] { "long", "long" };

        _methodName111 = "getUserPublications";

        _methodParameterTypes111 = new String[] { "long", "long", "int", "int" };

        _methodName112 = "getUserPublications";

        _methodParameterTypes112 = new String[] {
                "long", "long", "int", "int",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };

        _methodName113 = "getPublication";

        _methodParameterTypes113 = new String[] { "long" };

        _methodName114 = "getPublicationsByStructureId";

        _methodParameterTypes114 = new String[] { "long", "long" };

        _methodName115 = "getPublicationsByStructureId";

        _methodParameterTypes115 = new String[] { "long", "long", "int", "int" };

        _methodName116 = "getPublicationsByStructureId";

        _methodParameterTypes116 = new String[] {
                "long", "long", "int", "int",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName94.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes94, parameterTypes)) {
            return PublicationServiceUtil.getBeanIdentifier();
        }

        if (_methodName95.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes95, parameterTypes)) {
            PublicationServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName100.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes100, parameterTypes)) {
            return PublicationServiceUtil.countPublication(((Long) arguments[0]).longValue());
        }

        if (_methodName101.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes101, parameterTypes)) {
            return PublicationServiceUtil.countAllPublication();
        }

        if (_methodName102.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes102, parameterTypes)) {
            return PublicationServiceUtil.countPublication(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue());
        }

        if (_methodName103.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes103, parameterTypes)) {
            return PublicationServiceUtil.countPublicationsByStructureId(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue());
        }

        if (_methodName104.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes104, parameterTypes)) {
            return PublicationServiceUtil.getAllPublications();
        }

        if (_methodName105.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes105, parameterTypes)) {
            return PublicationServiceUtil.getAllPublications(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName106.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes106, parameterTypes)) {
            return PublicationServiceUtil.getAllPublications(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[2]);
        }

        if (_methodName107.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes107, parameterTypes)) {
            return PublicationServiceUtil.getPublications(((Long) arguments[0]).longValue());
        }

        if (_methodName108.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes108, parameterTypes)) {
            return PublicationServiceUtil.getPublications(((Long) arguments[0]).longValue(),
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName109.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes109, parameterTypes)) {
            return PublicationServiceUtil.getPublications(((Long) arguments[0]).longValue(),
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[3]);
        }

        if (_methodName110.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes110, parameterTypes)) {
            return PublicationServiceUtil.getUserPublications(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue());
        }

        if (_methodName111.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes111, parameterTypes)) {
            return PublicationServiceUtil.getUserPublications(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue(),
                ((Integer) arguments[2]).intValue(),
                ((Integer) arguments[3]).intValue());
        }

        if (_methodName112.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes112, parameterTypes)) {
            return PublicationServiceUtil.getUserPublications(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue(),
                ((Integer) arguments[2]).intValue(),
                ((Integer) arguments[3]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[4]);
        }

        if (_methodName113.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes113, parameterTypes)) {
            return PublicationServiceUtil.getPublication(((Long) arguments[0]).longValue());
        }

        if (_methodName114.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes114, parameterTypes)) {
            return PublicationServiceUtil.getPublicationsByStructureId(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue());
        }

        if (_methodName115.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes115, parameterTypes)) {
            return PublicationServiceUtil.getPublicationsByStructureId(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue(),
                ((Integer) arguments[2]).intValue(),
                ((Integer) arguments[3]).intValue());
        }

        if (_methodName116.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes116, parameterTypes)) {
            return PublicationServiceUtil.getPublicationsByStructureId(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue(),
                ((Integer) arguments[2]).intValue(),
                ((Integer) arguments[3]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[4]);
        }

        throw new UnsupportedOperationException();
    }
}
