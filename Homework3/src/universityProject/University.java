package universityProject;

import java.util.ArrayList;
import java.util.Scanner;

public class University {
	private ArrayList<Student> students = new ArrayList<>();
	private ArrayList<Course> courses = new ArrayList<>();
	private ArrayList<FacultyMember> facultyMembers = new ArrayList<>();
	private Scanner input = new Scanner(System.in);
	
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
		Course newCourse = new Course();
		if (courses.size() > 0) {
			for(int i = 0; i < courses.size(); i++) {
				if (courses.get(i).getCourseID() == newCourse.getCourseID()) {
					System.out.println("Course already exists.");
				}
				else {
					courses.add(newCourse);
					System.out.println("Course has been added to the university.");
				}
			}
		}
		else {
			courses.add(newCourse);
			System.out.println("Course has been added to the university");
		}
	}
	public void addFacultyMember() {
		FacultyMember newFacultyMember = new FacultyMember();
		if (facultyMembers.size() > 0) {
			for(int i = 0; i < facultyMembers.size(); i++) {
				if (facultyMembers.get(i).getEmployeeID() == newFacultyMember.getEmployeeID()) {
					System.out.println("Course already exists.");
				}
				else {
					facultyMembers.add(newFacultyMember);
					System.out.println("Faculty member has been added to the university.");
				}
			}
		}
		else {
			facultyMembers.add(newFacultyMember);
			System.out.println("Faculty member has been added to the university");
		}
	}
	public void deleteStudent() {
		System.out.println("Current students enrolled: ");
		displayStudents();
		System.out.println("Enter the CIN of the student you want to remove:");
		int cin = input.nextInt();
		if (students.size() == 0) {
			System.out.println("There are no students enrolled.");
		}
		else {
			for (int i = 0; i < students.size(); i++) {
				if (students.get(i).getCin() == cin) {
					students.remove(i);
					System.out.println("Student has been removed.");
				}
			}
		}
	}
	public void deleteCourse() {
		System.out.println("Current list of courses in the University: ");
		displayCourses();
		System.out.println("Enter the courseID of the course you want to remove:");
		String courseID = input.nextLine();
		if (courses.size() == 0) {
			System.out.println("There are no courses in the University.");
		}
		else {
			for (int i = 0; i < courses.size(); i++) {
				if (courses.get(i).getCourseID() == courseID) {
					courses.remove(i);
					System.out.println("Course has been removed.");
				}
			}
		}
	}
	public void deleteFacultyMember() {
		System.out.println("Current faculty members: ");
		displayFacultyMembers();
		System.out.println("Enter the employee id of the faculty member you want to remove:");
		int employeeID = input.nextInt();
		if (facultyMembers.size() == 0) {
			System.out.println("There are no faculty members in the university.");
		}
		else {
			for (int i = 0; i < facultyMembers.size(); i++) {
				if (facultyMembers.get(i).getEmployeeID() == employeeID) {
					students.remove(i);
					System.out.println("Student has been removed.");
				}
			}
		}
	}
	public void displayStudents() {
		if(students.size() > 0) {
			for(int i = 0; i < students.size(); i++) {
				System.out.println("Student "+ (i+1) + ":\n" + students.get(i).toString() + "\n");
			}
		}
		else {
			System.out.println("There are no students enrolled.");
		}
		
	}
	public void displayCourses() {
		if(courses.size() > 0) {
			for(int i = 0; i < courses.size(); i++) {
				System.out.println("Course "+ (i+1) + ":\n" + courses.get(i).toString() + "\n");
			}
		}
		else {
			System.out.println("There are no courses offered.");
		}
	}
	public void displayFacultyMembers() {
		if(facultyMembers.size() > 0) {
			for(int i = 0; i < facultyMembers.size(); i++) {
				System.out.println("Faculty "+ (i+1) + ":\n" + facultyMembers.get(i).toString() + "\n");
			}
		}
		else {
			System.out.println("There are no faculty members.");
		}
	}
}
