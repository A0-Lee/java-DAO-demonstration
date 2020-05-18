package al00952.com1028.assignment;

/**
 * Creates a new object based on the Inner Join attributes for Requirement 3.
 * 
 * This class performs an inner join of the Customer and Order classes' attributes as well as
 * the orderTotal calculated from OrderDAO.
 * 
 * This class is part of Requirement 3 (Set H).
 * 
 * @author Andy Lee
 *
 */
public class InnerJoin {
	private int customerNumber;
	private String customerName;
	private int orderNumber;
	private double orderTotal;

	public InnerJoin(int customerNumber, String customerName, int orderNumber, double orderTotal) {
		this.customerNumber = customerNumber;
		this.customerName = customerName;
		this.orderNumber = orderNumber;
		this.orderTotal = orderTotal;
	}

	public int getCustomerNumber() {
		return customerNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public double getOrderTotal() {
		return orderTotal;
	}

}
