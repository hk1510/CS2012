package universityProject;

import java.util.ArrayList;

public class University {
	private ArrayList<Student> students = new ArrayList<>();
	private ArrayList<Course> courses = new ArrayList<>();
	private ArrayList<FacultyMember> facultyMembers = new ArrayList<>();
	
	public void menu() {
		addStudent();
		displayStudents();
	}
	public void addStudent() {
		Student newStudent = new Student();
		if (students.size() > 0) {
			for(int i = 0; i < students.size(); i++) {
				if (students.get(i).getCin() == newStudent.getCin()) {
					System.out.println("Student is already enrolled in the University.");
				}
				else {
					students.add(newStudent);
					System.out.println("Student has been enrolled.");
				}
			}
		}
		else {
			students.add(newStudent);
			System.out.println("Student has been enrolled.");
		}
		
	}
	public void addCourse() {
		
	}
	public void addFacultyMember() {
		
	}
	public void deleteStudent() {
		
	}
	public void deleteCourse() {
		
	}
	public void deleteFacultyMember() {
		
	}
	public void displayStudents() {
		if(students.size() > 0) {
			for(int i = 0; i < students.size(); i++) {
				System.out.println("Student "+ (i+1) + ":\n" + students.get(i).toString() + "\n");
			}
		}
		else {
			System.out.println("There are no students enrolled");
		}
		
	}
	public void displayCourses() {
		for(int i = 0; i < courses.size(); i++) {
			System.out.println(courses.get(i).toString() + "\n");
		}
	}
	public void displayFacultyMembers(ArrayList<FacultyMember> array) {
		for(int i = 0; i < facultyMembers.size(); i++) {
			System.out.println(facultyMembers.get(i).toString() + "\n");
		}
	}
}
