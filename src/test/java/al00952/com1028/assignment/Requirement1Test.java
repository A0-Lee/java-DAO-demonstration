package al00952.com1028.assignment;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.Test;

/**
 * This class is used to run the test case for Requirement 1.
 * 
 * @author Andy Lee
 *
 */
public class Requirement1Test {

	@Test
	public void requirement1Test() {
		BaseQuery baseQuery = new BaseQuery();
		Requirement1Impl requirement1 = new Requirement1Impl();

		try {
			// This is needed as GROUP_CONCAT for Classic Cars exceeds the default 1024
			// character limit
			baseQuery.customSQLstatement("SET SESSION group_concat_max_len = 10000");
			ResultSet results = baseQuery.customSQLstatement(
					"SELECT productLine, GROUP_CONCAT(productCode, CONCAT(' - '), productName SEPARATOR '\n') AS uniqueProducts FROM products GROUP BY productLine");
			StringBuffer buffer = new StringBuffer();

			while (results.next()) {
				String productLine = results.getString("productLine");
				String uniqueProducts = results.getString("uniqueProducts");

				buffer.append("\n----------");
				buffer.append(productLine);
				buffer.append("----------\n");
				buffer.append(uniqueProducts);
				buffer.append("\n");
			}

			System.out.print("--------------------------------\nRequirement 1:\n--------------------------------");
			System.out.print(buffer.toString());

			assertEquals(buffer.toString(), requirement1.printMatchingRequirement());

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
