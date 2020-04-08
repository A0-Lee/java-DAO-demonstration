package al00952.com1028.assignment;

/**
 * This class is used to run the application and output all requirements. 
 * 
 * This will eventually contain the outputs for requirements 1, 2, 3 from Set H.
 * 
 * -- Set H --
 * Requirement 1 - List the products in each product line
 * Requirement 2 - Report the total payments by date
 * Requirement 3 - List the names of customers and their corresponding order number where the customer's order is > $25,000
 * 
 * @author Andy Lee
 *
 */
public class App {
	public static void main(String[] args) {
		// Requirement 1 Output
		System.out.println("Requirement 1:\n----------------------------------");
		System.out.println("Products in each Productline with productCode:\n----------------------------------");
		ProductDAO requirement1 = new ProductDAO();
		requirement1.printProductsFromProductLines();
		
		// Requirement 2 Output
		System.out.println("Requirement 2:\n----------------------------------");
		System.out.println("Payments sorted by Date:\n----------------------------------");
		PaymentDAO requirement2 = new PaymentDAO();
		requirement2.printTotalPaymentsByDate();
		
		// Requirement 3 Output
		System.out.println("Requirement 3:\n----------------------------------");
		System.out.println("Customers with Orders greater than $25000:\n----------------------------------");
	
		OrderDAO o = new OrderDAO();
		System.out.println(o.getResultsCustomerNumber());



	}
}
