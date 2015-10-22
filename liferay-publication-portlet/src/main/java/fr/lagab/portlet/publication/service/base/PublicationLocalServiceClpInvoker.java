package fr.lagab.portlet.publication.service.base;

import fr.lagab.portlet.publication.service.PublicationLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PublicationLocalServiceClpInvoker {
    private String _methodName0;
    private String[] _methodParameterTypes0;
    private String _methodName1;
    private String[] _methodParameterTypes1;
    private String _methodName2;
    private String[] _methodParameterTypes2;
    private String _methodName3;
    private String[] _methodParameterTypes3;
    private String _methodName4;
    private String[] _methodParameterTypes4;
    private String _methodName5;
    private String[] _methodParameterTypes5;
    private String _methodName6;
    private String[] _methodParameterTypes6;
    private String _methodName7;
    private String[] _methodParameterTypes7;
    private String _methodName8;
    private String[] _methodParameterTypes8;
    private String _methodName9;
    private String[] _methodParameterTypes9;
    private String _methodName10;
    private String[] _methodParameterTypes10;
    private String _methodName11;
    private String[] _methodParameterTypes11;
    private String _methodName12;
    private String[] _methodParameterTypes12;
    private String _methodName13;
    private String[] _methodParameterTypes13;
    private String _methodName14;
    private String[] _methodParameterTypes14;
    private String _methodName15;
    private String[] _methodParameterTypes15;
    private String _methodName16;
    private String[] _methodParameterTypes16;
    private String _methodName17;
    private String[] _methodParameterTypes17;
    private String _methodName18;
    private String[] _methodParameterTypes18;
    private String _methodName19;
    private String[] _methodParameterTypes19;
    private String _methodName114;
    private String[] _methodParameterTypes114;
    private String _methodName115;
    private String[] _methodParameterTypes115;
    private String _methodName120;
    private String[] _methodParameterTypes120;
    private String _methodName121;
    private String[] _methodParameterTypes121;
    private String _methodName122;
    private String[] _methodParameterTypes122;
    private String _methodName123;
    private String[] _methodParameterTypes123;
    private String _methodName124;
    private String[] _methodParameterTypes124;
    private String _methodName125;
    private String[] _methodParameterTypes125;
    private String _methodName126;
    private String[] _methodParameterTypes126;

    public PublicationLocalServiceClpInvoker() {
        _methodName0 = "addPublication";

        _methodParameterTypes0 = new String[] {
                "fr.lagab.portlet.publication.model.Publication"
            };

        _methodName1 = "createPublication";

        _methodParameterTypes1 = new String[] { "long" };

        _methodName2 = "deletePublication";

        _methodParameterTypes2 = new String[] { "long" };

        _methodName3 = "deletePublication";

        _methodParameterTypes3 = new String[] {
                "fr.lagab.portlet.publication.model.Publication"
            };

        _methodName4 = "dynamicQuery";

        _methodParameterTypes4 = new String[] {  };

        _methodName5 = "dynamicQuery";

        _methodParameterTypes5 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery"
            };

        _methodName6 = "dynamicQuery";

        _methodParameterTypes6 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
            };

        _methodName7 = "dynamicQuery";

        _methodParameterTypes7 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };

        _methodName8 = "dynamicQueryCount";

        _methodParameterTypes8 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery"
            };

        _methodName9 = "dynamicQueryCount";

        _methodParameterTypes9 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery",
                "com.liferay.portal.kernel.dao.orm.Projection"
            };

        _methodName10 = "fetchPublication";

        _methodParameterTypes10 = new String[] { "long" };

        _methodName11 = "fetchPublicationByUuidAndCompanyId";

        _methodParameterTypes11 = new String[] { "java.lang.String", "long" };

        _methodName12 = "fetchPublicationByUuidAndGroupId";

        _methodParameterTypes12 = new String[] { "java.lang.String", "long" };

        _methodName13 = "getPublication";

        _methodParameterTypes13 = new String[] { "long" };

        _methodName14 = "getPersistedModel";

        _methodParameterTypes14 = new String[] { "java.io.Serializable" };

        _methodName15 = "getPublicationByUuidAndCompanyId";

        _methodParameterTypes15 = new String[] { "java.lang.String", "long" };

        _methodName16 = "getPublicationByUuidAndGroupId";

        _methodParameterTypes16 = new String[] { "java.lang.String", "long" };

        _methodName17 = "getPublications";

        _methodParameterTypes17 = new String[] { "int", "int" };

        _methodName18 = "getPublicationsCount";

        _methodParameterTypes18 = new String[] {  };

        _methodName19 = "updatePublication";

        _methodParameterTypes19 = new String[] {
                "fr.lagab.portlet.publication.model.Publication"
            };

        _methodName114 = "getBeanIdentifier";

        _methodParameterTypes114 = new String[] {  };

        _methodName115 = "setBeanIdentifier";

        _methodParameterTypes115 = new String[] { "java.lang.String" };

        _methodName120 = "addPublication";

        _methodParameterTypes120 = new String[] {
                "long", "long", "long", "java.util.Date", "long",
                "java.lang.String", "java.lang.String", "java.lang.String",
                "long", "long", "int",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName121 = "updatePublication";

        _methodParameterTypes121 = new String[] {
                "long", "long", "java.lang.String", "java.lang.String",
                "java.lang.String", "com.liferay.portal.service.ServiceContext"
            };

        _methodName122 = "deletePublication";

        _methodParameterTypes122 = new String[] {
                "fr.lagab.portlet.publication.model.Publication"
            };

        _methodName123 = "updateAsset";

        _methodParameterTypes123 = new String[] {
                "long", "fr.lagab.portlet.publication.model.Publication",
                "long[][]", "java.lang.String[][]"
            };

        _methodName124 = "addResources";

        _methodParameterTypes124 = new String[] {
                "fr.lagab.portlet.publication.model.Publication", "boolean",
                "boolean"
            };

        _methodName125 = "addResources";

        _methodParameterTypes125 = new String[] {
                "fr.lagab.portlet.publication.model.Publication",
                "java.lang.String[][]", "java.lang.String[][]"
            };

        _methodName126 = "updateResources";

        _methodParameterTypes126 = new String[] {
                "fr.lagab.portlet.publication.model.Publication",
                "java.lang.String[][]", "java.lang.String[][]"
            };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName0.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
            return PublicationLocalServiceUtil.addPublication((fr.lagab.portlet.publication.model.Publication) arguments[0]);
        }

        if (_methodName1.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
            return PublicationLocalServiceUtil.createPublication(((Long) arguments[0]).longValue());
        }

        if (_methodName2.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
            return PublicationLocalServiceUtil.deletePublication(((Long) arguments[0]).longValue());
        }

        if (_methodName3.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
            return PublicationLocalServiceUtil.deletePublication((fr.lagab.portlet.publication.model.Publication) arguments[0]);
        }

        if (_methodName4.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
            return PublicationLocalServiceUtil.dynamicQuery();
        }

        if (_methodName5.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
            return PublicationLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName6.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
            return PublicationLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName7.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
            return PublicationLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[3]);
        }

        if (_methodName8.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
            return PublicationLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName9.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
            return PublicationLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                (com.liferay.portal.kernel.dao.orm.Projection) arguments[1]);
        }

        if (_methodName10.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
            return PublicationLocalServiceUtil.fetchPublication(((Long) arguments[0]).longValue());
        }

        if (_methodName11.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
            return PublicationLocalServiceUtil.fetchPublicationByUuidAndCompanyId((java.lang.String) arguments[0],
                ((Long) arguments[1]).longValue());
        }

        if (_methodName12.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
            return PublicationLocalServiceUtil.fetchPublicationByUuidAndGroupId((java.lang.String) arguments[0],
                ((Long) arguments[1]).longValue());
        }

        if (_methodName13.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
            return PublicationLocalServiceUtil.getPublication(((Long) arguments[0]).longValue());
        }

        if (_methodName14.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
            return PublicationLocalServiceUtil.getPersistedModel((java.io.Serializable) arguments[0]);
        }

        if (_methodName15.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
            return PublicationLocalServiceUtil.getPublicationByUuidAndCompanyId((java.lang.String) arguments[0],
                ((Long) arguments[1]).longValue());
        }

        if (_methodName16.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes16, parameterTypes)) {
            return PublicationLocalServiceUtil.getPublicationByUuidAndGroupId((java.lang.String) arguments[0],
                ((Long) arguments[1]).longValue());
        }

        if (_methodName17.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes17, parameterTypes)) {
            return PublicationLocalServiceUtil.getPublications(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName18.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes18, parameterTypes)) {
            return PublicationLocalServiceUtil.getPublicationsCount();
        }

        if (_methodName19.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes19, parameterTypes)) {
            return PublicationLocalServiceUtil.updatePublication((fr.lagab.portlet.publication.model.Publication) arguments[0]);
        }

        if (_methodName114.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes114, parameterTypes)) {
            return PublicationLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName115.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes115, parameterTypes)) {
            PublicationLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName120.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes120, parameterTypes)) {
            return PublicationLocalServiceUtil.addPublication(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue(),
                ((Long) arguments[2]).longValue(),
                (java.util.Date) arguments[3],
                ((Long) arguments[4]).longValue(),
                (java.lang.String) arguments[5],
                (java.lang.String) arguments[6],
                (java.lang.String) arguments[7],
                ((Long) arguments[8]).longValue(),
                ((Long) arguments[9]).longValue(),
                ((Integer) arguments[10]).intValue(),
                (com.liferay.portal.service.ServiceContext) arguments[11]);
        }

        if (_methodName121.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes121, parameterTypes)) {
            return PublicationLocalServiceUtil.updatePublication(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue(),
                (java.lang.String) arguments[2],
                (java.lang.String) arguments[3],
                (java.lang.String) arguments[4],
                (com.liferay.portal.service.ServiceContext) arguments[5]);
        }

        if (_methodName122.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes122, parameterTypes)) {
            return PublicationLocalServiceUtil.deletePublication((fr.lagab.portlet.publication.model.Publication) arguments[0]);
        }

        if (_methodName123.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes123, parameterTypes)) {
            PublicationLocalServiceUtil.updateAsset(((Long) arguments[0]).longValue(),
                (fr.lagab.portlet.publication.model.Publication) arguments[1],
                (long[]) arguments[2], (java.lang.String[]) arguments[3]);

            return null;
        }

        if (_methodName124.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes124, parameterTypes)) {
            PublicationLocalServiceUtil.addResources((fr.lagab.portlet.publication.model.Publication) arguments[0],
                ((Boolean) arguments[1]).booleanValue(),
                ((Boolean) arguments[2]).booleanValue());

            return null;
        }

        if (_methodName125.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes125, parameterTypes)) {
            PublicationLocalServiceUtil.addResources((fr.lagab.portlet.publication.model.Publication) arguments[0],
                (java.lang.String[]) arguments[1],
                (java.lang.String[]) arguments[2]);

            return null;
        }

        if (_methodName126.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes126, parameterTypes)) {
            PublicationLocalServiceUtil.updateResources((fr.lagab.portlet.publication.model.Publication) arguments[0],
                (java.lang.String[]) arguments[1],
                (java.lang.String[]) arguments[2]);

            return null;
        }

        throw new UnsupportedOperationException();
    }
}
