package model;

public class StudentRecord {
	
	private String course_name;
	
	private Assessment[] assessments;
	private int noa;

	public StudentRecord(String course_name) {
		this.course_name = course_name;
		this.assessments = new Assessment[10];
	}

	public String getCourse() {
		return this.course_name;
	}

	public String getAssessmentReport() {
		String str = "Number of assessments in EECS2030: " + this.noa + " [";
		for (int i = 0; i < this.noa; i++) {
			if (i == this.noa - 1) {
				str += this.assessments[i].getReport();
			} else {
				str += this.assessments[i].getReport() + ", ";
			}
		}
		
		str += "]";
				
		return str;
	}

	public double getCompletionRate() {
		double total = 0;
		for (int i = 0; i < this.noa; i++) {
			total += this.assessments[i].getWeight();
		}
		return total;
	}

	public double getRawMarks() {
		double total = 0;
		for (int i = 0; i < this.noa; i++) {
			total += this.assessments[i].getWeight() * this.assessments[i].getMark();
		}
		return total;
	}

	public void addAssessment(String name, double weight, int mark) {
		this.assessments[this.noa] = new Assessment(name, weight, mark);
		this.noa++;
		
	}

	public void addAssessment(Assessment assessment) {
		this.assessments[this.noa] = assessment;
		this.noa++;
		
	}

	public void changeMarksOf(String name, int mark) {
		for (int i = 0; i < this.noa; i++) {
			if (this.assessments[i].getName().equals(name)) {
				this.assessments[i].setMarks(mark);
			}
		}
	}

	public void removeAssessment(String name) {
		boolean found = false;
		for (int i = 0; i < this.noa; i++) {
			if (this.assessments[i].getName().equals(name)) {
				found = true;
			}
		}
		
		if (!found) {
			return;
		}
		
		int counter = 0;
		Assessment[] new_assessment = new Assessment[this.noa - 1];
		for (int i = 0; i < this.noa; i++) {
			if (!this.assessments[i].getName().equals(name)) {
				new_assessment[counter] = this.assessments[i];
				counter++;
			}
		}
		this.assessments = new Assessment[10];
		for (int i = 0; i < new_assessment.length; i ++) {
			this.assessments[i] = new_assessment[i];
		}
		
		this.noa = counter;
	}

}
