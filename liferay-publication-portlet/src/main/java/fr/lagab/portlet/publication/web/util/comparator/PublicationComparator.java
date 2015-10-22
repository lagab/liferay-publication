package fr.lagab.portlet.publication.web.util.comparator;

import com.liferay.portal.kernel.util.OrderByComparator;

/**
 * @author lagab
 * @since  21/10/15.
 */
public class PublicationComparator extends OrderByComparator{

    public static final String ORDER_BY_ASC = "createDate ASC";

    public static final String ORDER_BY_DESC = "createDate DESC";

    public static final String[] ORDER_BY_FIELDS = {"createDate"};

    public PublicationComparator() {
        this(false);
    }

    public PublicationComparator(boolean ascending) {
        _ascending = ascending;
    }

    @Override
    public int compare(Object obj1, Object obj2) {
        return 0;
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

    protected boolean _ascending;

}
