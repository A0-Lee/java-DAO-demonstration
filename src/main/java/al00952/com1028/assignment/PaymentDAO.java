package al00952.com1028.assignment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

/**
 * Create a Data Access Object for the Payments class.
 * 
 * This class is part of Requirement 2 (Set H).
 * 
 * @author Andy Lee
 *
 */
public class PaymentDAO {
	private BaseQuery baseQuery;
	private ArrayList<Payment> allPayments;
	
	public PaymentDAO() {
		this.baseQuery = new BaseQuery("root", "password123");
		this.allPayments = new ArrayList<Payment>();
	}
	
	public ArrayList<String> getTotalPaymentsByDate() {
		// Populate this.allPayments and sort by Date
		this.sortAllPaymentsbyDate();
		
		ArrayList<String> totalPaymentsByDate = new ArrayList<String>();
		
		for (Payment payment : this.allPayments) {
			totalPaymentsByDate.add("Date:  " + payment.getPaymentDate() + "  CustomerNumber:  " + payment.getCustomerNumber() + "  Amount:  " + String.format("%1$8.2f", payment.getAmount()) + "  CheckNumber:  " + payment.getCheckNumber());
		}
		return totalPaymentsByDate;
	}
	
	public String printTotalPaymentsByDate() {
		
		StringBuffer buffer = new StringBuffer();
		for (String printPayments : this.getTotalPaymentsByDate()) {
			buffer.append(printPayments);
			buffer.append("\r\n");
		}
		System.out.println(buffer.toString());
		return buffer.toString();
	}
	
	public ArrayList<Payment> sortAllPaymentsbyDate() {
		Collections.sort(this.getAllPayments());
		return this.allPayments;
	}
	
	
	public ArrayList<Payment> getAllPayments() {
		
		try {
			ResultSet results = this.baseQuery.useTable("payments");
			
			while (results.next()) {
				int customerNumber = results.getInt("customerNumber");
				String checkNumber = results.getString("checkNumber");
				Date paymentDate = results.getDate("paymentDate");
				double amount = results.getDouble("amount");
				
				Payment newPayment = new Payment(customerNumber, checkNumber, paymentDate, amount);
				this.allPayments.add(newPayment);
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return this.allPayments;
		
	}

}
