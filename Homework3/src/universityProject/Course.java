package universityProject;

import java.util.Scanner;

public class Course {
	
	private String courseID;
	private int units;
	private Scanner input = new Scanner(System.in);
	
	Course() {
		System.out.println("Enter the course identifier: ");
		courseID = input.nextLine();
		System.out.println("Enter the number of units for the course: ");
		setUnits(input.nextInt());
	}
	
	Course(String courseID, int units) {
		this.courseID = courseID;
		this.setUnits(units);
	}
	
	public String getCourseID() {
		return courseID;
	}
	
	public void setCourseID(String courseIdentifier) {
		this.courseID = courseIdentifier;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}
	public String toString() {
		return "\tCourse ID: " + courseID + "\n\tUnits: " + units; 
	}
}
