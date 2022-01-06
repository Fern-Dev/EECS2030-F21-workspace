package model;

public class StudentManagementSystem {
	
	private Student[] students = new Student[0];
	private int nos;

	public Student[] getStudents() {
		return this.students;
	}

	public void addStudent(Student student) {
		Student[] new_students = new Student[this.nos + 1];
		
		for (int i = 0; i < this.nos + 1; i++) {
			if (i < this.nos) {
				new_students[i] = this.students[i];
			} else {
				new_students[i] = student;
			}
		}
		
		this.nos++;
		this.students = new_students;
		
	}

	public void registerAll(Course course) {
		for (int i = 0; i < this.nos; i ++) {
			this.students[i].register(course);
		}
	}

}
