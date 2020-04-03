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
	private ArrayList<Payments> allPayments;
	
	public PaymentDAO() {
		this.baseQuery = new BaseQuery("root", "password123");
		this.allPayments = new ArrayList<Payments>();
	}
	
	public ArrayList<String> getTotalPaymentsByDate() {
		// Populate this.allPayments and sort by Date
		this.sortAllPaymentsbyDate();
		
		ArrayList<String> totalPaymentsByDate = new ArrayList<String>();
		
		for (Payments payment : this.allPayments) {
			totalPaymentsByDate.add("Date:  " + payment.getPaymentDate() + "  CustomerNumber:  " + payment.getCustomerNumber() + "  Amount:  " + String.format("%1$8.2f", payment.getAmount()) + "  CheckNumber:  " + payment.getCheckNumber());
		}
		return totalPaymentsByDate;
	}
	
	public String printTotalPaymentsByDate() {
		/*
		StringBuffer buffer = new StringBuffer();
		for (Payments payment : this.allPayments) {
			buffer.append("Date: ");
			buffer.append(payment.getPaymentDate());
			buffer.append("   CustomerNumber:  ");
			buffer.append(payment.getCustomerNumber());
			buffer.append("   Amount:  ");
			buffer.append(String.format("%1$10.2f", payment.getAmount()));
			buffer.append("   CheckNumber:  ");
			buffer.append(payment.getCheckNumber());
			buffer.append("\r\n");
	
		}
		System.out.println(buffer.toString());
		return buffer.toString();
		*/
		
		StringBuffer buffer = new StringBuffer();
		for (String printPayments : this.getTotalPaymentsByDate()) {
			buffer.append(printPayments);
			buffer.append("\r\n");
		}
		System.out.println(buffer.toString());
		return buffer.toString();
	}
	
	public ArrayList<Payments> sortAllPaymentsbyDate() {
		Collections.sort(this.getAllPayments());
		return this.allPayments;
	}
	
	
	public ArrayList<Payments> getAllPayments() {
		
		try {
			ResultSet results = this.baseQuery.useTable("payments");
			
			while (results.next()) {
				int customerNumber = results.getInt("customerNumber");
				String checkNumber = results.getString("checkNumber");
				Date paymentDate = results.getDate("paymentDate");
				double amount = results.getDouble("amount");
				
				Payments newPayment = new Payments(customerNumber, checkNumber, paymentDate, amount);
				this.allPayments.add(newPayment);
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return this.allPayments;
		
	}

}
