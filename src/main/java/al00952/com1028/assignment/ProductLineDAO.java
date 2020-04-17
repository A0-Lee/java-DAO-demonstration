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
public class ProductLineDAO extends AbstractDAO<ProductLine> {
	private ArrayList<ProductLine> allProductLines = new ArrayList<ProductLine>();

	public ProductLineDAO() {
		super();
		this.allProductLines = this.findAllObjectData();
	}

	@Override
	protected ArrayList<ProductLine> findAllObjectData() {
		try {
			ResultSet results = this.baseQuery.useTable("productlines");

			while (results.next()) {
				String productLine = results.getString("productLine");
				String textDescription = results.getString("textDescription");

				ProductLine newProductLine = new ProductLine(productLine, textDescription);

				this.allProductLines.add(newProductLine);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return this.allProductLines;
	}
	
	public ArrayList<ProductLine> getAllProductLines() {
		return this.allProductLines;
	}

}
