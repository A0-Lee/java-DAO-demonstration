package al00952.com1028.assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * This class is used to establish a database connection to your local SQL
 * server. 
 * 
 * This assumes the mySQL ClassicModels database is already installed on
 * your end.
 * 
 * NOTE: Change BaseQuery parameter values to fit your mySQL credentials (i.e.
 * my username and password is 'root' and 'password123', but yours may be different)
 * 
 * @author Provided by Santanu Dash
 * @author Modified by Andy Lee
 *
 */
public class BaseQuery {
	protected Connection con;
	private final String db = "jdbc:mysql://localhost:3306/classicmodels?serverTimezone=GMT";

	public BaseQuery(String uname, String pwd) {
		try {
			// Class.forName("com.mysql.jdbc.Driver");
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			con = DriverManager.getConnection(db, uname, pwd);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	protected ResultSet useTable(String tableName) throws SQLException {
		String query = "select * from " + tableName;
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery(query);
		return rs;
	}
	
	// This method is used for JUnit Test Cases only - verifies correct data retrieval from ClassicModels DB
	protected ResultSet customSQLstatement(String query) throws SQLException {
		ResultSet rs = con.createStatement().executeQuery(query);
		return rs;
	}

}
