package universityProject;

import java.util.ArrayList;
import java.util.Scanner;

public class Student extends Person{
	private int cin;
	private ArrayList<Course> courses = new ArrayList<>();
	
	Scanner input = new Scanner(System.in);
	
	Student() {
		super();
		System.out.println("Enter the student's CIN: ");
		cin = input.nextInt();
		
	}
	
	Student(int cin, int streetNum, String streetName, String city, String state, String country, String name) {
		super(streetNum, streetName, city, state, country, name);
		this.cin = cin;
	}
	
	public int getCin() {
		return cin;
	}
	public void setCin(int cin) {
		this.cin = cin;
	}
	public ArrayList<Course> getCourses() {
		return courses;
	}

	public void add(Course course) {
		boolean courseAlreadyAdded = false;
		if (courses.size() > 0) {
			for(int i = 0; i < courses.size(); i++) {
				if (course.getCourseID().equals(courses.get(i).getCourseID())) {
					System.out.println("Student is already enrolled in that course.");
					courseAlreadyAdded = true;
				}
			}
			if(!courseAlreadyAdded) {
				courses.add(course);
			}
		}
		else {
			courses.add(course);
		}
		
		System.out.println("Course added!");
	}
	public void drop(Course course) {
		boolean removed = false;
		if (courses.size() > 0) {
			for(int i = 0; i < courses.size(); i++) {
				if (course.getCourseID().equals(courses.get(i).getCourseID())) {
					courses.remove(courses.get(i));
					System.out.println("Course removed!");
					removed = true;
				}
			}
			if(!removed) {
				System.out.println("Student was never enrolled in that class.");
			}
		}
		else {
			courses.remove(course);
		}
		
	}
	
	public String displayEnrolled() {
		String courseList = "";
		if(courses.size() > 0) {
			for(int i = 0; i < courses.size(); i++) {
				courseList += "\n" + courseList;
			}
		}
		else {
			courseList = "Student is not enrolled in any courses";
		}
		
		return courseList;
	}
	
	@Override
	public String toString() {
		return "Name: " + super.getName() + "\nCIN: "+ cin +"\nAddress: " + super.getAddress().toString() + "\nCourses Taking: " + displayEnrolled();
	}
	
}
