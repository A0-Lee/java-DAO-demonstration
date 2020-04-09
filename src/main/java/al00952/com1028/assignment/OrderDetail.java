package al00952.com1028.assignment;

/**
 * Template for an OrderDetail Object (i.e. a singular row with field data from
 * the 'orderdetails' table).
 * 
 * This class is part of Requirement 3 (Set H).
 * 
 * @author Andy Lee
 *
 */
public class OrderDetail {
	private int orderNumber;
	private String productCode;
	private int quantityOrdered;
	private double priceEach;
	private int orderLineNumber;

	public OrderDetail(int orderNumber, String productCode, int quantityOrdered, double priceEach,
			int orderLineNumber) {
		this.orderNumber = orderNumber;
		this.productCode = productCode;
		this.quantityOrdered = quantityOrdered;
		this.priceEach = priceEach;
		this.orderLineNumber = orderLineNumber;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public String getProductCode() {
		return productCode;
	}

	public int getQuantityOrdered() {
		return quantityOrdered;
	}

	public double getPriceEach() {
		return priceEach;
	}

	public int getOrderLineNumber() {
		return orderLineNumber;
	}

}
