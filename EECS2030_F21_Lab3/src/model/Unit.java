package model;

public class Unit {
	
	private String function;
	private int[] diminsions;
	private String measurement = "feet";
	
	public Unit(String function, int width, int length) {
		this.function = function;
		this.diminsions = new int[] {width, length};
	}
	
	public String getFunction() {
		return this.function;
	}
	
	public int[] getDiminsions() {
		return this.diminsions;
	}
	
	public String toString() {
		if (this.measurement.equals("feet")) {
			return "A unit of " + this.diminsions[0] * this.diminsions[1] + " square feet (" + this.diminsions[0] + "' wide and " + this.diminsions[1] + "' long) functioning as " + this.function;
		} else {
			return "A unit of " + String.format("%.2f", (this.diminsions[0] * 0.3048) * (this.diminsions[1] * 0.3048)) + " square meters (" + String.format("%.2f", this.diminsions[0] * 0.3048) + " m wide and " + String.format("%.2f", this.diminsions[1] * 0.3048) + " m long) functioning as " + this.function;
		}
		
	}

	public void toogleMeasurement() {
		if (this.measurement.equals("feet")) {
			this.measurement = "meters";
		} else {
			this.measurement = "feet";
		}
	}
	
	public boolean equals(Object u2) {
		if (u2 == null) return false;
		if (this.getClass() != u2.getClass()) return false;
		
		Unit u = (Unit) u2;
		if (this.function.equals(u.function) && (this.diminsions[0] * this.diminsions[1] == u.diminsions[0] * u.diminsions[1])) {
			return true;
		} else {
			return false;
		}
	}
	
	
}
