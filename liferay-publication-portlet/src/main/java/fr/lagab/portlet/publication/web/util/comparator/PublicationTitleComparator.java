package fr.lagab.portlet.publication.web.util.comparator;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringUtil;
import fr.lagab.portlet.publication.model.Publication;

/**
 * @author lagab
 * @since  21/10/15.
 */
public class PublicationTitleComparator extends OrderByComparator{

    public static final String ORDER_BY_ASC = "title ASC";

    public static final String ORDER_BY_DESC = "title DESC";

    public static final String[] ORDER_BY_FIELDS = {"title"};

    public PublicationTitleComparator() {
        this(false);
    }

    public PublicationTitleComparator(boolean ascending) {
        _ascending = ascending;
    }

    @Override
    public int compare(Object obj1, Object obj2) {
        Publication publication1 = (Publication)obj1;
        Publication publication2 = (Publication)obj2;

        String title1 = StringUtil.toLowerCase(publication1.getTitle());
        String title2 = StringUtil.toLowerCase(publication2.getTitle());

        int value = title1.compareTo(title2);

        if (_ascending) {
            return value;
        }
        else {
            return -value;
        }
    }

    @Override
    public String getOrderBy() {
        if (_ascending) {
            return ORDER_BY_ASC;
        }
        else {
            return ORDER_BY_DESC;
        }
    }

    @Override
    public String[] getOrderByFields() {
        return ORDER_BY_FIELDS;
    }

    @Override
    public boolean isAscending() {
        return _ascending;
    }

    private boolean _ascending;
}
