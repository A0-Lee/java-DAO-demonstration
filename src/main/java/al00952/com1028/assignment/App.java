package al00952.com1028.assignment;

/**
 * This class is used to run the application. 
 * 
 * This will eventually contain the outputs for Requirements 1, 2, 3 from Set H.
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
		ProductDAO requirement1 = new ProductDAO();
		requirement1.getProductsFromProductLines();

	}
}
