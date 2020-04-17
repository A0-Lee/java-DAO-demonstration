package al00952.com1028.assignment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Create a Data Access Object for the Product Class.
 * 
 * This class is part of Requirement 1 (Set H).
 * 
 * @author Andy Lee
 */
public class ProductDAO extends AbstractDAO<Product> {
	private ArrayList<Product> allProducts = new ArrayList<Product>();

	public ProductDAO() {
		super();
		this.allProducts = findAllObjectData();
	}
	
	@Override
	protected ArrayList<Product> findAllObjectData() {
		try {
			ResultSet results = this.baseQuery.useTable("products");

			while (results.next()) {
				String productCode = results.getString("productCode");
				String productName = results.getString("productName");
				String productLine = results.getString("productLine");
				String productScale = results.getString("productScale");
				String productVendor = results.getString("productVendor");
				String productDescription = results.getString("productDescription");
				int quantityInStock = results.getInt("quantityInStock");
				double buyPrice = results.getDouble("buyPrice");
				double MSRP = results.getDouble("MSRP");

				Product newProduct = new Product(productCode, productName, productLine, productScale, productVendor,
						productDescription, quantityInStock, buyPrice, MSRP);

				this.allProducts.add(newProduct);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return this.allProducts;
	}
	
	public ArrayList<Product> getAllProducts() {
		return allProducts;
	}

}
