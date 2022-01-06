package model;

public class ResidentStudent extends Student {
	
	public double rate;

	public ResidentStudent(String name) {
		super(name);
	}

	public void setPremiumRate(double rate) {
		this.rate = rate;
	}

	public double getPremiumRate() {
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
