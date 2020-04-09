package al00952.com1028.assignment;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

/**
 * This class is used to run the test case for Requirement 3.
 * 
 * @author Andy Lee
 *
 */
public class Requirement3Test {

	@Test
	public void requirement3Test() {
		BaseQuery baseQuery = new BaseQuery();
		Requirement3 requirement3 = new Requirement3();
		
		try {
			ResultSet results = baseQuery.customSQLstatement(
					"SELECT customers.customerName, customers.customerNumber, orderDetails.orderNumber, SUM(orderDetails.priceEach * orderDetails.quantityOrdered) AS orderTotal FROM customers INNER JOIN orders ON orders.customerNumber = customers.customerNumber INNER JOIN orderDetails ON orderDetails.orderNumber = orders.orderNumber GROUP BY orderNumber HAVING orderTotal > 25000");

			StringBuffer buffer = new StringBuffer();

			while (results.next()) {
				String customerName = results.getString("customers.customerName");
				int customerNumber = results.getInt("customers.customerNumber");
				int orderNumber = results.getInt("orderDetails.orderNumber");
				double orderTotal = results.getDouble("orderTotal");

				buffer.append("CustomerNumber: ");
				buffer.append(customerNumber);
				buffer.append("  ");
				buffer.append("OrderNumber: ");
				buffer.append(orderNumber);
				buffer.append("  ");
				buffer.append("OrderTotal: ");
				buffer.append(String.format("%1$8.2f", orderTotal));
				buffer.append("  ");
				buffer.append("CustomerName: ");
				buffer.append(customerName);
				buffer.append("\n");
			}

			System.out.print("\n--------------------------------\nRequirement 3:\n--------------------------------\n");
			System.out.print(buffer.toString());

			assertEquals(buffer.toString(), requirement3.printMatchingRequirements());

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
