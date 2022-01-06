package model;

public class Student {
	
	protected String name;
	
	protected Course[] courses = new Course[0];
	protected int noc;
	
	public Student(String name) {
		this.name = name;
	}

	public Course[] getCourses() {
		return this.courses;
	}

	public double getTuition() {
		double cost = 0;
		
		for (int i = 0; i < this.noc; i++) {
			cost += this.courses[i].getFee();		
		}
		return cost;
	}

	public void register(Course course) {
		Course[] new_courses = new Course[this.noc + 1];
		
		for (int i = 0; i < this.noc + 1; i++) {
			if (i < this.noc) {
				new_courses[i] = this.courses[i];
			} else {
				new_courses[i] = course;
			}
		}
		
		this.noc++;
		this.courses = new_courses;
		
	}

	public void drop(Course course) {
		if (this.noc > 0) {
			Course[] new_courses = new Course[this.noc - 1];
			
			int counter = 0;
			for (int i = 0; i < this.noc; i ++) {
				if (!this.courses[i].equals(course)) {
					new_courses[counter++] = this.courses[i];
				}
			}
			
			this.noc--;
			this.courses = new_courses;
			
		}
	}

}
