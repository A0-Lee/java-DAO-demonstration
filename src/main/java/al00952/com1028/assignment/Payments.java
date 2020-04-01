package al00952.com1028.assignment;

import java.util.Date;

/**
 * Template for a Payment Object (i.e. a singular row with field data from the
 * 'payments' table).
 * 
 * This class is part of Requirement 2 (Set H).
 * 
 * @author Andy Lee
 *
 */
public class Payments implements Comparable<Payments> {
	private int customerNumber;
	private String checkNumber;
	private Date paymentDate;
	private double amount;

	public Payments(int customerNumber, String checkNumber, Date paymentDate, double amount) {
		this.customerNumber = customerNumber;
		this.checkNumber = checkNumber;
		this.paymentDate = paymentDate;
		this.amount = amount;
	}

	public int getCustomerNumber() {
		return customerNumber;
	}

	public String getCheckNumber() {
		return checkNumber;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public double getAmount() {
		return amount;
	}

	public int compareTo(Payments payment) {
		return this.getPaymentDate().compareTo(payment.getPaymentDate());
	}

}
