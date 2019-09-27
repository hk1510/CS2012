package universityProject;

import java.util.ArrayList;
import java.util.Scanner;

public class FacultyMember extends Person{
	private int employeeID;
	private ArrayList<Course> schedule;
	
	Scanner input = new Scanner(System.in);
	
	FacultyMember() {
		super();
		System.out.println("Enter the faculty member's employee ID");
		employeeID = input.nextInt();
	}
	FacultyMember(int employeeID, int streetNum, String streetName, String city, String state, String country, String name) {
		super(streetNum, streetName, city, state, country, name);
		this.employeeID = employeeID;
	}
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	public ArrayList<Course> getSchedule() {
		return schedule;
	}
	
	public void add(Course course) {
		boolean courseAlreadyAdded = false;
		for(int i = 0; i < schedule.size(); i++) {
			if (course.getCourseID().equals(schedule.get(i).getCourseID())) {
				System.out.println("Faculty member is already teaching that course.");
				courseAlreadyAdded = true;
			}
		}
		if(!courseAlreadyAdded) {
			schedule.add(course);
		}
		
		System.out.println("Course added!");
	}
	public void drop(Course course) {
		boolean removed = false;
		for(int i = 0; i < schedule.size(); i++) {
			if (course.getCourseID().equals(schedule.get(i).getCourseID())) {
				schedule.remove(schedule.get(i));
				System.out.println("Course removed!");
				removed = true;
			}
		}
		if(!removed) {
			System.out.println("Faculty member was never teaching that course.");
		}
		
	}
	public String toString() {
		return "Name: " + super.getName() + "\nAddress: " + super.getAddress().toString() + "\nCourse Teaching: " + schedule.toString();
	}
	
}
