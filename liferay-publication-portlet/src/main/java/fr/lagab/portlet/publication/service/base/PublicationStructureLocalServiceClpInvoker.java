package fr.lagab.portlet.publication.service.base;

import fr.lagab.portlet.publication.service.PublicationStructureLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PublicationStructureLocalServiceClpInvoker {
    private String _methodName38;
    private String[] _methodParameterTypes38;
    private String _methodName39;
    private String[] _methodParameterTypes39;

    public PublicationStructureLocalServiceClpInvoker() {
        _methodName38 = "getBeanIdentifier";

        _methodParameterTypes38 = new String[] {  };

        _methodName39 = "setBeanIdentifier";

        _methodParameterTypes39 = new String[] { "java.lang.String" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName38.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes38, parameterTypes)) {
            return PublicationStructureLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName39.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes39, parameterTypes)) {
            PublicationStructureLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        throw new UnsupportedOperationException();
    }
}
