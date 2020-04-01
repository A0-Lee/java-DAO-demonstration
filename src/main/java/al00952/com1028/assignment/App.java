package al00952.com1028.assignment;

/**
 * This class is used to run the application and output all requirements. 
 * 
 * This will eventually contain the outputs for requirements 1, 2, 3 from Set H.
 * 
 * -- Set H --
 * Requirement 1 - List the products in each productline
 * Requirement 2 - Report the total payments by date
 * Requirement 3 - List the names of customers and their corresponding order number where the customer's order is > $25,000
 * 
 * @author Andy Lee
 *
 */
public class App {
	public static void main(String[] args) {
		// Requirement 1 Output
		System.out.println("Requirement 1:");
		ProductDAO requirement1 = new ProductDAO();
		requirement1.getProductsFromProductLines();
		
		// Requirement 2 Output
		System.out.println("Requirement 2:\n----------------------------------");
		PaymentDAO requirement2 = new PaymentDAO();
		requirement2.getTotalPaymentsbyDate();
		
		// Requirement 3 Output

	}
}
