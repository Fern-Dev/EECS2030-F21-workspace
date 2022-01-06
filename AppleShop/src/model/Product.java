package model;

/*
 * Template for individual apple product in the refurbished store.
 */
public class Product {
	
	/* attributes */
	private String model; // Ex. iPad Pro 12.9"
	private String finish; // Ex. Gold
	private int storage; // Ex. 256 GB
	private boolean hasCellularConnectivity; // Ex. True, (WIFI + Cellular)
	private double originalPrice; // Ex. $ 1789.00
	private double discountValue; // Ex. $ 200.00
	
	/* constructors */
	public Product() {
		// Default constructor.
	}
	
	public Product(String model, double originalPrice) {
		this.model = model;
		this.originalPrice = originalPrice;
		
	}
	
	/* accessors */
	public String getModel() {
		return this.model;
	}
	
	public String getFinish() {
		return this.finish;
	}
	
	public int getStorage() {
		return this.storage;
	}
	
	public boolean hasCellularConnectivity() {
		return this.hasCellularConnectivity;
	}
	
	public double getOriginalPrice() {
		return this.originalPrice;
	}
	
	public double getDiscountValue() {
		return this.discountValue;
	}
	
	public double getPrice() {
		double price = 0.0;
		
		price = this.originalPrice - this.discountValue;
		
		return price;
		
	}
	
	public String toString() {
		String s = "";
		
//		StringBuilder sb = new StringBuilder();
//		sb.append(model + " " + finish + " " + storage + "GB "
//				+ "(cellular connectivity: " + hasCellularConnectivity + "): $("
//				+ String.format("%.2f", originalPrice) + " - " + String.format("%.2f", discountValue) + ")");
//		
//		s = sb.toString();
		
		s += this.model + " " + this.finish + " " + this.storage + "GB "
				+ "(cellular connectivity: " + this.hasCellularConnectivity + "): $("
				+ String.format("%.2f", this.originalPrice) + " - " + String.format("%.2f", this.discountValue) + ")";
		
//		s = String.format("%s %s %dGB (cellular connectivity: %s): $(%.2f - %.2f)",
//				this.model, this.finish, this.storage, this.hasCellularConnectivity,
//				this.originalPrice, this.discountValue);
		
		return s;
	}
	
	/* mutators */
	public void setModel(String model) {
		this.model = model;
	}

	public void setFinish(String finish) {
		this.finish = finish;
	}

	public void setStorage(int storage) {
		this.storage = storage;
	}

	public void setHasCellularConnectivity(boolean hasCellularConnectivity) {
		this.hasCellularConnectivity = hasCellularConnectivity;
	}

	public void setOriginalPrice(double originalPrice) {
		this.originalPrice = originalPrice;
	}

	public void setDiscountValue(double discountValue) {
		this.discountValue = discountValue;
	}
}
