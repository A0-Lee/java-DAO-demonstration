package al00952.com1028.assignment;

/**
 * Template for a Product Object (i.e. a singular row with field data from the
 * 'products' table)
 * 
 * This class is part of Requirement 1 (Set H).
 * 
 * @author Andy Lee
 *
 */
public class Product {
	private String productCode;
	private String productName;
	private String productLine;
	private String productScale;
	private String productVendor;
	private String productDescription;
	private int quantityInStock;
	private double buyPrice;
	private double MSRP;

	public Product(String productCode, String productName, String productLine, String productScale,
			String productVendor, String productDescription, int quantityInStock, double buyPrice, double MSRP) {
		this.productCode = productCode;
		this.productName = productName;
		this.productLine = productLine;
		this.productScale = productScale;
		this.productVendor = productVendor;
		this.productDescription = productDescription;
		this.quantityInStock = quantityInStock;
		this.buyPrice = buyPrice;
		this.MSRP = MSRP;
	}

	public int getQuantityInStock() {
		return quantityInStock;
	}

	public double getBuyPrice() {
		return buyPrice;
	}

	public double getMSRP() {
		return MSRP;
	}

	public String getProductCode() {
		return productCode;
	}

	public String getProductName() {
		return productName;
	}

	public String getProductLine() {
		return productLine;
	}

	public String getProductScale() {
		return productScale;
	}

	public String getProductVendor() {
		return productVendor;
	}

	public String getProductDescription() {
		return productDescription;
	}

}
