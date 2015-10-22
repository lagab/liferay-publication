package fr.lagab.portlet.publication.web.util;

import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.UnicodeFormatter;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.dynamicdatamapping.model.DDMStructure;
import com.liferay.portlet.dynamicdatamapping.storage.Field;
import com.liferay.portlet.dynamicdatamapping.storage.FieldConstants;
import com.liferay.portlet.dynamicdatamapping.storage.Fields;
import com.liferay.portlet.dynamicdatamapping.util.DDMUtil;
import fr.lagab.portlet.publication.model.Publication;
import fr.lagab.portlet.publication.web.util.comparator.PublicationCreateDateComparator;
import fr.lagab.portlet.publication.web.util.comparator.PublicationIDComparator;
import fr.lagab.portlet.publication.web.util.comparator.PublicationModifiedDateComparator;
import fr.lagab.portlet.publication.web.util.comparator.PublicationTitleComparator;
import fr.lagab.portlet.publication.web.util.converter.PublicationConverterUtil;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
/**
 * @author lagab
 * @since  21/10/15.
 */
public class PublicationUtil {
    /*public static void addAllReservedEls(
            Element rootElement, Map<String, String> tokens, Publication publication,
            String languageId, ThemeDisplay themeDisplay) {

    }*/

    public static OrderByComparator getPublicationOrderByComparator(
            String orderByCol, String orderByType) {

        boolean orderByAsc = false;

        if (orderByType.equals("asc")) {
            orderByAsc = true;
        }

        OrderByComparator orderByComparator = null;

        if (orderByCol.equals("create-date")) {
            orderByComparator = new PublicationCreateDateComparator(orderByAsc);
        }
        else if (orderByCol.equals("id")) {
            orderByComparator = new PublicationIDComparator(orderByAsc);
        }
        else if (orderByCol.equals("modified-date")) {
            orderByComparator = new PublicationModifiedDateComparator(orderByAsc);
        }
        else if (orderByCol.equals("title")) {
            orderByComparator = new PublicationTitleComparator(orderByAsc);
        }

        return orderByComparator;
    }

    public static Object[] getContentAndImages(
            DDMStructure ddmStructure, Locale locale,
            ServiceContext serviceContext)
            throws Exception {

        Fields fields = DDMUtil.getFields(ddmStructure.getStructureId(), serviceContext);

        Map<String, byte[]> images = getImages(fields, locale);


        return new Object[] {
                PublicationConverterUtil.getContent(ddmStructure, fields),
                images
        };
    }

    protected static Map<String, byte[]> getImages(Fields fields, Locale locale)
            throws Exception {

        Map<String, byte[]> images = new HashMap<String, byte[]>();

        for (Field field : fields) {
            String dataType = field.getDataType();

            if (!dataType.equals(FieldConstants.IMAGE)) {
                continue;
            }

            List<Serializable> values = field.getValues(locale);

            for (int i = 0; i < values.size(); i++) {
                String content = (String)values.get(i);

                if (content.equals("update")) {
                    continue;
                }

                StringBundler sb = new StringBundler(6);

                sb.append(StringPool.UNDERLINE);
                sb.append(field.getName());
                sb.append(StringPool.UNDERLINE);
                sb.append(i);
                sb.append(StringPool.UNDERLINE);
                sb.append(LanguageUtil.getLanguageId(locale));

                images.put(sb.toString(), UnicodeFormatter.hexToBytes(content));
            }
        }

        return images;
    }
}
