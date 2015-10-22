package fr.lagab.portlet.publication.web.util.comparator;

import fr.lagab.portlet.publication.model.Publication;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
/**
 * @author lagab
 * @since  21/10/15.
 */
public class PublicationCreateDateComparator extends PublicationComparator{

    public static final String ORDER_BY_ASC = "createDate ASC";

    public static final String ORDER_BY_DESC = "createDate DESC";

    public static final String[] ORDER_BY_FIELDS = {"createDate"};

    public PublicationCreateDateComparator() {
        super();
    }
    public PublicationCreateDateComparator(boolean ascending) {
        super(ascending);
    }


    @Override
    public int compare(Object obj1, Object obj2) {
        Publication publication1 = (Publication)obj1;
        Publication publication2 = (Publication)obj2;

        int value = DateUtil.compareTo(
                publication1.getCreateDate(), publication2.getCreateDate());

        if (_ascending) {
            return value;
        }
        else {
            return -value;
        }
    }


}
