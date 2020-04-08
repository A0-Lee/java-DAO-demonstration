package al00952.com1028.assignment;

/**
 * Template for a ProductLine Object (i.e. a singular row with field data from
 * the 'productlines' table).
 * 
 * This class is part of Requirement 1 (Set H).
 * 
 * NOTE: This class does not record the fields 'htmlDescription' and 'image'
 * from the table as they are not needed
 * 
 * @author Andy Lee
 *
 */
public class ProductLine {
	private String productLine;
	private String textDescription;

	public ProductLine(String productLine, String textDescription) {
		this.productLine = productLine;
		this.textDescription = textDescription;
	}

	public String getProductLine() {
		return productLine;
	}

	public String getTextDescription() {
		return textDescription;
	}

}
