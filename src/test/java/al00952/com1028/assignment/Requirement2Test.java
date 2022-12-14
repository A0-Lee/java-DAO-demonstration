package al00952.com1028.assignment;

import static org.junit.Assert.*;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

/**
 * This class is used to run the test case for Requirement 2.
 * 
 * @author Andy Lee
 *
 */
public class Requirement2Test {

	@Test
	public void requirement2Test() {
		BaseQuery baseQuery = new BaseQuery();
		Requirement2Impl requirement2 = new Requirement2Impl();

		try {
			ResultSet results = baseQuery.customSQLstatement(
					"SELECT customerNumber, checkNumber, paymentDate, amount FROM payments ORDER BY paymentDate");
			StringBuffer buffer = new StringBuffer();

			while (results.next()) {
				int customerNumber = results.getInt("customerNumber");
				String checkNumber = results.getString("checkNumber");
				Date paymentDate = results.getDate("paymentDate");
				double amount = results.getDouble("amount");

				buffer.append("Date: ");
				buffer.append(paymentDate);
				buffer.append("  CustomerNumber: ");
				buffer.append(customerNumber);
				buffer.append("  Amount: ");
				buffer.append(String.format("%1$9.2f", amount));
				buffer.append("  CheckNumber: ");
				buffer.append(checkNumber);
				buffer.append("\n");
			}

			System.out.print("\n--------------------------------\nRequirement 2:\n--------------------------------\n");
			System.out.print(buffer.toString());

			assertEquals(buffer.toString(), requirement2.printMatchingRequirement());

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
