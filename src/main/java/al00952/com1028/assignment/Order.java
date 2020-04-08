package al00952.com1028.assignment;

import java.sql.Date;

/**
 * Template for an Order Object (i.e. a singular row with field data from the 'orders' table).
 * 
 * This class is part of Requirement 3 (Set H).
 * 
 * @author Andy Lee
 *
 */
public class Order {
	private int orderNumber;
	private Date orderDate;
	private Date requiredDate;
	private Date shippedDate;
	private String status;
	private String comments;
	private int customerNumber;
	
	public Order(int orderNumber, Date orderDate, Date requiredDate, Date shippedDate, String status, String comments, int customerNumber) {
		this.orderNumber = orderNumber;
		this.orderDate = orderDate;
		this.requiredDate = requiredDate;
		this.shippedDate = shippedDate;
		this.status = status;
		this.comments = comments;
		this.customerNumber = customerNumber;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public Date getRequiredDate() {
		return requiredDate;
	}

	public Date getShippedDate() {
		return shippedDate;
	}

	public String getStatus() {
		return status;
	}

	public String getComments() {
		return comments;
	}

	public int getCustomerNumber() {
		return customerNumber;
	}

}
