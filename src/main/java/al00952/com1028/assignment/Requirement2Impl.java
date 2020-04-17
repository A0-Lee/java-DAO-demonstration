package al00952.com1028.assignment;

import java.util.ArrayList;

/**
 * This class is used to output Requirement 2 to console.
 * 
 * Requirement 2 - Report the total Payments by Date (Set H).
 * 
 * @author Andy Lee
 * 
 */
public class Requirement2Impl implements Requirement {
	private PaymentDAO paymentDAO;

	public Requirement2Impl() {
		this.paymentDAO = new PaymentDAO();
	}

	public String printMatchingRequirement() {
		ArrayList<Payment> allPaymentsByDate = paymentDAO.getAllPaymentsByDate();
		StringBuffer buffer = new StringBuffer();

		for (Payment payment : allPaymentsByDate) {
			buffer.append("Date: ");
			buffer.append(payment.getPaymentDate());
			buffer.append("  CustomerNumber: ");
			buffer.append(payment.getCustomerNumber());
			buffer.append("  Amount: ");
			buffer.append(String.format("%1$9.2f", payment.getAmount()));
			buffer.append("  CheckNumber: ");
			buffer.append(payment.getCheckNumber());
			buffer.append("\n");
		}
		return buffer.toString();
	}

	public static void main(String[] args) {
		Requirement2Impl requirement2 = new Requirement2Impl();
		System.out.print(requirement2.printMatchingRequirement());
	}

}
