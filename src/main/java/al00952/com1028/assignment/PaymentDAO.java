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
public class PaymentDAO extends AbstractDAO<Payment> {
	private ArrayList<Payment> allPayments = new ArrayList<Payment>();
	private ArrayList<Payment> allPaymentsByDate = new ArrayList<Payment>();

	public PaymentDAO() {
		super();
		this.allPayments = this.findAllObjectData();
		this.allPaymentsByDate = this.sortAllPaymentsByDate();
	}

	@Override
	protected ArrayList<Payment> findAllObjectData() {
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
	
	public ArrayList<Payment> getAllPaymentsByDate() {
		return allPaymentsByDate;
	}
	
	private ArrayList<Payment> sortAllPaymentsByDate() {
		ArrayList<Payment> allPaymentsByDate = this.allPayments;
		Collections.sort(allPaymentsByDate);
		return allPaymentsByDate;
	}

}
