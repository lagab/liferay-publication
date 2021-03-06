package fr.lagab.portlet.publication.web.util.comparator;

import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import fr.lagab.portlet.publication.model.Publication;

/**
 * @author lagab
 * @since  21/10/15.
 */
public class PublicationModifiedDateComparator extends OrderByComparator{

    public static final String ORDER_BY_ASC = "modifiedDate ASC";

    public static final String ORDER_BY_DESC = "modifiedDate DESC";

    public static final String[] ORDER_BY_FIELDS = {"modifiedDate"};

    public PublicationModifiedDateComparator() {
        this(false);
    }

    public PublicationModifiedDateComparator(boolean ascending) {
        _ascending = ascending;
    }

    @Override
    public int compare(Object obj1, Object obj2) {
        Publication publication1 = (Publication)obj1;
        Publication publication2 = (Publication)obj2;

        int value = DateUtil.compareTo(
                publication1.getModifiedDate(), publication2.getModifiedDate());

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
