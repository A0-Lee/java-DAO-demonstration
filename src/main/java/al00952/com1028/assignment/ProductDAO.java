package al00952.com1028.assignment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Create a Data Access Object for the Product Class.
 * 
 * This class is part of Requirement 1 (Set H).
 * 
 * @author Andy Lee
 */
public class ProductDAO {

	private BaseQuery baseQuery;
	private ArrayList<Product> allProducts;
	private ArrayList<ProductLine> allProductLines;

	public ProductDAO() {
		this.baseQuery = new BaseQuery("root", "password123");
		this.allProducts = new ArrayList<Product>();	
		this.allProductLines = new ProductLineDAO().getAllProductLines();
	}

	/**
	 * This method prints out the list of products in each product line.
	 * 
	 * @return an ArrayList containing ArrayList of Products (each ArrayList is a product line)
	 */
	public ArrayList<ArrayList<Product>> getProductsFromProductLines() {
		// This ArrayList stores all the productLines and its products 
		ArrayList<ArrayList<Product>> productsInProductLines = new ArrayList<ArrayList<Product>>();

		// Calls local method to populate this.allProducts
		this.getAllProducts();

		for (ProductLine productLine : this.allProductLines) {
			// This ArrayList stores all the products for a singular productLine
			ArrayList<Product> aProductLine = new ArrayList<Product>();
			Iterator<Product> itr = this.allProducts.iterator();
			while (itr.hasNext()) {
				Product product = itr.next();
				if (product.getProductLine().equals(productLine.getProductLine())) {
					aProductLine.add(product);
				}
			}
			productsInProductLines.add(aProductLine);
		}
		return productsInProductLines;
	}
	
	/**
	 * @return A String containing the Products in Each Product line
	 */
	public String printProductsFromProductLines() {
		StringBuffer buffer = new StringBuffer();
		int i = 0;
		
		for (ArrayList<Product> productLines : this.getProductsFromProductLines()) {
			buffer.append("------------- ");
			buffer.append(this.allProductLines.get(i).getProductLine());
			buffer.append(" -------------\r\n");
			for (Product product : productLines) {
				buffer.append(product.getProductName());
				buffer.append(" - [");
				buffer.append(product.getProductCode());
				buffer.append("]\r\n");
			}
			buffer.append("\r\n");
			i++;
		}
		
		System.out.println(buffer.toString());
		return buffer.toString();
		
	}
	
	/**
	 * This method creates a Product Object for each row in the products table.
	 */
	public ArrayList<Product> getAllProducts() {

		try {
			ResultSet results = this.baseQuery.useTable("products");

			// Creating Product Objects that is added to allProducts
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

}
