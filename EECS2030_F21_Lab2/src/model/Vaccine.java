package model;

public class Vaccine {
	
	private String codename;
	private String type;
	private String manufacturer;

	public Vaccine(String codename, String type, String manufacturer) {
		this.codename = codename;
		this.type = type;
		this.manufacturer = manufacturer;
	}
	
	public String getCodename() {
		return this.codename;
	}
	
	public String getType() {
		return this.type;
	}
	
	public String getManufaturer() {
		return this.manufacturer;
	}
	
	public boolean isRecognized() {
		if (this.codename.equals("mRNA-1273") || this.codename.equals("BNT162b2") || this.codename.equals("Ad26.COV2.S") || this.codename.equals("AZD1222")) {
			return true;
		} else {
			return false;
		}
	}
	
	public String toString() {
		if (this.isRecognized()) {
		return "Recognized vaccine: " + this.codename + " (" + this.type + "; " +  this.manufacturer + ")";
		
		} else {
			return "Unrecognized vaccine: " + this.codename + " (" + this.type + "; " +  this.manufacturer + ")";
		}
	}
}
