package model;

public class Assessment {
	
	private String name;
	private double weight;
	
	private int mark;
	
	private String status;

	public Assessment(String name, double weight) {
		this.name = name;
		this.weight = weight;
		
		this.status = "Assessment created: " + this.name + " accounts for " + String.format("%.3f", this.weight * 100) + " percents of the course.";
	}
	
	public Assessment(String name, double weight, int mark) {
		this.name = name;
		this.weight = weight;
		this.mark = mark;
		
		this.status = "Assessment created: " + this.name + " accounts for " + String.format("%.3f", this.weight * 100) + " percents of the course.";
	}
	
	public String toString() {
		return this.status;
	}
	
	public String getReport() {
		return this.name + " (weight: " + String.format("%.3f", this.weight * 100) + " percents; marks: " + this.mark + ")";
	}
	
	public String getName() {
		return this.name;
	}
	
	public double getWeight() {
		return this.weight;
	}
	
	public int getMark() {
		return this.mark;
	}

	public void setMarks(int mark) {
		this.status = "Marks of assessment " + this.name + " (accounting for " + String.format("%.3f", this.weight * 100) + " percents of the course) is changed from " + this.mark + " to " + mark + ".";
		this.mark = mark;
	}

	public void setWeight(double weight) {
		this.status = "Weight of assessment " + this.name + " (with marks " + this.mark + ") is changed from " + String.format("%.3f", this.weight * 100) + " percents to " + String.format("%.3f", weight * 100) + " percents.";
		this.weight = weight;
	}

}
