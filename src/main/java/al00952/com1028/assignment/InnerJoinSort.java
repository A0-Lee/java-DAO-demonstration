package al00952.com1028.assignment;

import java.util.Comparator;

/**
 * Used to sort InnerJoin Objects in an ArrayList via their customerNumber
 * attribute.
 * 
 * This class is part of Requirement 3 (Set H).
 * 
 * @author Andy Lee
 *
 */
public class InnerJoinSort implements Comparator<InnerJoin> {

	public int compare(InnerJoin o1, InnerJoin o2) {
		return o1.getCustomerNumber() - o2.getCustomerNumber();
	}

}
