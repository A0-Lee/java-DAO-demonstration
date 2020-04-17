package al00952.com1028.assignment;

import java.util.ArrayList;

/**
 * This class is used to output Requirement 1 to console.
 * 
 * Requirement 1 - List the Products in each ProductLine (Set H).
 * 
 * @author Andy Lee
 * 
 */
public class Requirement1Impl implements Requirement {
	private ProductDAO productDAO;
	private ProductLineDAO productLineDAO;

	public Requirement1Impl() {
		this.productDAO = new ProductDAO();
		this.productLineDAO = new ProductLineDAO();
	}

	public String printMatchingRequirement() {
		ArrayList<Product> allProducts = this.productDAO.getAllProducts();
		ArrayList<ProductLine> allProductLines = this.productLineDAO.getAllProductLines();
		StringBuffer buffer = new StringBuffer();

		for (ProductLine productLine : allProductLines) {
			buffer.append("\n----------");
			buffer.append(productLine.getProductLine());
			buffer.append("----------\n");

			for (Product product : allProducts) {
				if (product.getProductLine().contentEquals(productLine.getProductLine())) {
					buffer.append(product.getProductCode());
					buffer.append(" - ");
					buffer.append(product.getProductName());
					buffer.append("\n");
				}
			}
		}
		return buffer.toString();
	}

	public static void main(String[] args) {
		Requirement1Impl requirement1 = new Requirement1Impl();
		System.out.print(requirement1.printMatchingRequirement());
	}

}
