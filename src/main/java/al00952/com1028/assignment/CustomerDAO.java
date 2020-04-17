package al00952.com1028.assignment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Create a Data Access Object for the Customer class.
 * 
 * This class is part of Requirement 3 (Set H).
 * 
 * @author Andy Lee
 */
public class CustomerDAO extends AbstractDAO<Customer> {
	private ArrayList<Customer> allCustomers = new ArrayList<Customer>();
	private ArrayList<String> resultsCustomerNames = new ArrayList<String>();
	private OrderDAO orderDAO = new OrderDAO();

	public CustomerDAO() {
		super();
		this.allCustomers = this.findAllObjectData();
		this.resultsCustomerNames = this.findCustomerNames();
	}

	private ArrayList<String> findCustomerNames() {
		ArrayList<Integer> resultsCustomerNumbers = this.orderDAO.getResultsCustomerNumber();
		ArrayList<String> resultsCustomerNames = new ArrayList<String>();

		for (int customerNumber : resultsCustomerNumbers) {
			for (Customer customer : this.allCustomers) {
				if (customer.getCustomerNumber() == customerNumber) {
					resultsCustomerNames.add(customer.getCustomerName());
				}
			}
		}
		return resultsCustomerNames;
	}

	@Override
	protected ArrayList<Customer> findAllObjectData() {
		try {
			ResultSet results = this.baseQuery.useTable("customers");

			while (results.next()) {
				int customerNumber = results.getInt("customerNumber");
				String customerName = results.getString("customerName");
				String contactLastName = results.getString("contactLastName");
				String contactFirstName = results.getString("contactFirstName");
				String phoneNumber = results.getString("phone");
				String addressLine1 = results.getString("addressLine1");
				String addressLine2 = results.getString("addressLine2");
				String city = results.getString("city");
				String state = results.getString("state");
				String postalCode = results.getString("postalCode");
				String country = results.getString("country");
				String salesRepEmployeeNumber = results.getString("salesRepEmployeeNumber");
				double creditLimit = results.getDouble("creditLimit");

				Customer newCustomer = new Customer(customerNumber, customerName, contactLastName, contactFirstName,
						phoneNumber, addressLine1, addressLine2, city, state, postalCode, country,
						salesRepEmployeeNumber, creditLimit);

				this.allCustomers.add(newCustomer);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return this.allCustomers;
	}
	
	public ArrayList<String> getResultsCustomerNames() {
		return resultsCustomerNames;
	}

}
