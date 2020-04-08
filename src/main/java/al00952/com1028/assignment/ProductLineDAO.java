package al00952.com1028.assignment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Create a Data Access Object for the ProductLines class.
 * 
 * This class is part of Requirement 1 (Set H).
 * 
 * @author Andy Lee
 *
 */
public class ProductLineDAO {
	
	private BaseQuery baseQuery;
	private ArrayList<ProductLine> productLines;
	
	public ProductLineDAO() {
		this.baseQuery = new BaseQuery("root", "password123");
		this.productLines = new ArrayList<ProductLine>();
	}
	
	/**
	 * This method gets all the rows from the SQL table "productlines" from the ClassicModels database
	 * @return An ArrayList of ProductLines Objects 
	 */
	public ArrayList<ProductLine> getAllProductLines() {
		
		try {
			ResultSet results = this.baseQuery.useTable("productlines");
			
			while (results.next()) {
				String productLine = results.getString("productLine");
				String textDescription = results.getString("textDescription");
				
				ProductLine newProductLine = new ProductLine(productLine, textDescription);
				this.productLines.add(newProductLine);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return this.productLines;
		
	}

	public ArrayList<ProductLine> getProductLines() {
		return productLines;
	}
	
}
