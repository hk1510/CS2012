package universityProject;

import java.util.ArrayList;
import java.util.Scanner;

public class FacultyMember extends Person{
	private int employeeID;
	private ArrayList<Course> schedule = new ArrayList<>();
	private Scanner input = new Scanner(System.in);
	
	FacultyMember() {
		super();
		System.out.println("Enter the faculty member's employee ID (integer): ");
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
	
	public boolean add(Course course) {
		boolean courseAlreadyAdded = false;
		if(schedule.size() > 0) {
			for(int i = 0; i < schedule.size(); i++) {
				if (course.getCourseID().equals(schedule.get(i).getCourseID())) {
					System.out.println("Faculty member is already teaching that course.");
					courseAlreadyAdded = true;
				}
			}
			if(!courseAlreadyAdded) {
				schedule.add(course);
			}
		}
		else {
			schedule.add(course);
		}
		return !courseAlreadyAdded;
	}
	public void drop(int index) {
		schedule.remove(index);
	}
	public String displayTeaching() {
		String courseList = "";
		if(schedule.size() > 0) {
			for(int i = 0; i < schedule.size(); i++) {
				courseList += "\n\tCourse " + (i+1) + ":\n" + schedule.get(i).toString() + "\n"; 
			}
		}
		else {
			courseList = "Faculty is not teaching any courses.";
		}
		
		return courseList;
	}
	public String toString() {
		return "Name: " + super.getName() + "\nAddress: " + super.getAddress().toString() + "\nCourses Teaching: " + displayTeaching();
	}
	
}
