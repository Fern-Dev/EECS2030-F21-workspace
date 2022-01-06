package model;

/*
 * Template of a unit of storage in the apple refurbished shop.
 */
public class Entry {
	private String serialNumber; // Ex. F9FDN4NKQ1GC (UNIQUE)
	private Product product; // reference type attribute
	
	public Entry(String serialNumber, Product product) {
		this.serialNumber = serialNumber;
		this.product = product;
	}

	public String getSerialNumber() {
		return this.serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	// Overloaded version of the setProduct mutator.
	public void setProduct(String model, double originalPrice) {
		//this.product = new Product(model, originalPrice);
		Product p = new Product(model, originalPrice);
		this.product = p;
	}
	
	public String toString() {
		return "[" + this.serialNumber + "]" + " " + this.product.toString();
	}
}
