package al00952.com1028.assignment;

/**
 * Template for a Customer Object (i.e. a singular row with field data from the
 * 'customers' table).
 * 
 * This class is part of Requirement 3 (Set H).
 * 
 * @author Andy Lee
 *
 */
public class Customer {
	private int customerNumber;
	private String customerName;
	private String contactLastName;
	private String contactFirstName;
	private String phoneNumber;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String postalCode;
	private String country;
	private String salesRepEmployeeNumber;
	private double creditLimit;

	public Customer(int customerNumber, String customerName, String contactLastName, String contactFirstName,
			String phoneNumber, String addressLine1, String addressLine2, String city, String state, String postalCode,
			String country, String salesRepEmployeeNumber, double creditLimit) {
		this.customerNumber = customerNumber;
		this.customerName = customerName;
		this.contactLastName = contactLastName;
		this.contactFirstName = contactFirstName;
		this.phoneNumber = phoneNumber;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.country = country;
		this.salesRepEmployeeNumber = salesRepEmployeeNumber;
		this.creditLimit = creditLimit;
	}

	public int getCustomerNumber() {
		return customerNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public String getContactLastName() {
		return contactLastName;
	}

	public String getContactFirstName() {
		return contactFirstName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public String getCountry() {
		return country;
	}

	public String getSalesRepEmployeeNumber() {
		return salesRepEmployeeNumber;
	}

	public double getCreditLimit() {
		return creditLimit;
	}

}
