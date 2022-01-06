package model;

public class Course {
	
	@SuppressWarnings("unused")
	private String name;
	private double fee;

	public Course(String name, double fee) {
		this.name = name;
		this.fee = fee;
	}

	public double getFee() {
		return this.fee;
	}

}
