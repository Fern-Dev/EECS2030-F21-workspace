package model;

public class NonResidentStudent extends Student {
	
	public double rate;

	public NonResidentStudent(String name) {
		super(name);
	}

	public void setDiscountRate(double rate) {
		this.rate = rate;
	}

	public double getDiscountRate() {
		return this.rate;
	}
	
	public double getTuition() {
		double cost = 0;
		
		for (int i = 0; i < super.noc; i++) {
			cost += super.courses[i].getFee() * this.rate;		
		}
		return cost;
	}
	
	

}
