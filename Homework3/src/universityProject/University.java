package universityProject;

import java.util.ArrayList;
import java.util.Scanner;

public class University {
	private ArrayList<Student> students = new ArrayList<>();
	private ArrayList<Course> courses = new ArrayList<>();
	private ArrayList<FacultyMember> facultyMembers = new ArrayList<>();
	private Scanner input = new Scanner(System.in);
	
	public void menu() {
		boolean exit = false;
		do {
			
			System.out.print("\nEnter one of the following numbers to choose their corresponding options: \n"
								+ "\t1 : Modify students (Add students, Remove students, Display current students, Modify student schedules)\n"
								+ "\t2 : Modify faculty members (Add faculty, Remove faculty, Display current faculty, Modify faculty schedules)\n"
								+ "\t3 : Modify courses (Add courses, Remove courses, Display current offered courses)\n"
								+ "\t4 : Exit \n"
								+ ">");
			
			if (input.hasNextInt()) {
				
				int modifyInt = input.nextInt();
				
				switch(modifyInt)
				{
				case 1:
					System.out.print("\nEnter one of the following numbers to choose their corresponding options: \n"
							+ "\t1 : Add student \n"
							+ "\t2 : Remove student \n"
							+ "\t3 : List current students \n"
							+ "\t4 : Modify student schedule (Add courses, remove courses, display current courses)\n"
							+ "\t5 : Go back \n"
							+ ">");					
					if(input.hasNextInt()) {
						modifyInt = input.nextInt();
						switch(modifyInt)
						{
						case 1:
							addStudent();
							break;
						case 2:
							deleteStudent();
							break;
						case 3:
							displayStudents();
							break;
						case 4:
							changeStudentSchedule();
							break;
						case 5:
							break;
						default:
							System.out.println("Invalid option.");
						}
					}
					else {
						System.out.println("Invalid option.");
						input.nextLine();
					}
					break;
				case 2:
					System.out.print("\nEnter one of the following numbers to choose their corresponding options: \n"
							+ "\t1 : Add faculty member \n"
							+ "\t2 : Remove faculty member \n"
							+ "\t3 : List current faculty members \n"
							+ "\t4 : Modify faculty member schedule (Add courses, remove courses, display current courses)\n"
							+ "\t5 : Go back \n"
							+ ">");					
					if(input.hasNextInt()) {
						modifyInt = input.nextInt();
						switch(modifyInt)
						{
						case 1:
							addFacultyMember();
							break;
						case 2:
							deleteFacultyMember();
							break;
						case 3:
							displayFacultyMembers();
							break;
						case 4:
							changeFacultySchedule();
							break;
						case 5:
							break;
						default:
							System.out.println("Invalid option.");
						}
					}
					else {
						System.out.println("Invalid option.");
						input.nextLine();
					}
					break;
				case 3:
					System.out.print("\nEnter one of the following numbers to choose their corresponding options: \n"
							+ "\t1 : Add course \n"
							+ "\t2 : Remove course \n"
							+ "\t3 : List current courses \n"
							+ "\t4 : Go back \n"
							+ ">");					
					if(input.hasNextInt()) {
						modifyInt = input.nextInt();
						switch(modifyInt)
						{
						case 1:
							addCourse();
							break;
						case 2:
							deleteCourse();
							break;
						case 3:
							displayCourses();
							break;
						case 4:
							break;
						default:
							System.out.println("Invalid option.");
						}
					}
					else {
						System.out.println("Invalid option.");
					}
					break;
				case 4:
					exit = true;
					break;
				default:
					System.out.println("Invalid option.");
					input.nextLine();
				}
			}
			else {
				System.out.println("Invalid option.");
				input.nextLine();
			}
		} while(!exit);
	}
	public void addStudent() {
		Student newStudent = new Student();
		boolean alreadyExists = false;
		if (students.size() > 0) {
			for(int i = 0; i < students.size(); i++) {
				if (students.get(i).getCin() == newStudent.getCin()) {
					System.out.println("CIN is already in use, student may already be enrolled in the university.");
					alreadyExists = true;
				}
			}
			if(!alreadyExists) {
				students.add(newStudent);
				System.out.println("Student has been enrolled.");
			}
		}
		else {
			students.add(newStudent);
			System.out.println("Student has been enrolled.");
		}
		
	}
	public void addCourse() {
		Course newCourse = new Course();
		boolean alreadyExists = false;
		if (courses.size() > 0) {
			for(int i = 0; i < courses.size(); i++) {
				if (courses.get(i).getCourseID() == newCourse.getCourseID()) {
					System.out.println("Course already exists.");
					alreadyExists = true;
				}
			}
			if(!alreadyExists) {
				courses.add(newCourse);
				System.out.println("Course has been added to the university.");
			}
		}
		else {
			courses.add(newCourse);
			System.out.println("Course has been added to the university");
		}
	}
	public void addFacultyMember() {
		FacultyMember newFacultyMember = new FacultyMember();
		boolean alreadyExists = false;
		if (facultyMembers.size() > 0) {
			for(int i = 0; i < facultyMembers.size(); i++) {
				if (facultyMembers.get(i).getEmployeeID() == newFacultyMember.getEmployeeID()) {
					System.out.println("Employee ID is already in use, faculty member may already be a part of the university.");
					alreadyExists = true;
				}
			}
			if(!alreadyExists) {
				facultyMembers.add(newFacultyMember);
				System.out.println("Faculty member has been added to the university.");
			}
		}
		else {
			facultyMembers.add(newFacultyMember);
			System.out.println("Faculty member has been added to the university.");
		}
	}
	public void deleteStudent() {
		displayStudents();
		if (students.size() == 0) {
			System.out.println("Unable to remove a student since there are no students enrolled.");
		}
		else {
			System.out.print("Enter which student you want to remove from the list above (1 for Student 1, etc.): ");
			int index = input.nextInt();
			if(index < 1 || index > students.size()) {
				System.out.println("Invalid student.");
			}
			else {
				students.remove(index - 1);
				System.out.println("Student has been removed.");
			}
		}
	}
	public void deleteCourse() {
		displayCourses();
		if (courses.size() == 0) {
			System.out.println("Unable to remove a course since there are no courses in the University.");
		}
		else {
			System.out.print("Enter which course you want to remove from the list above (1 for Course 1, etc.): ");
			int index = input.nextInt();
			if(index < 1 || index > courses.size()) {
				System.out.println("Invalid course.");
			}
			else {
				courses.remove(index - 1);
				System.out.println("Course has been removed.");
			}
		}
	}
	public void deleteFacultyMember() {
		displayFacultyMembers();
		if (facultyMembers.size() == 0) {
			System.out.println("Unable to remove a faculty member since there are no faculty members in the university.");
		}
		else {
			System.out.print("Enter which faculty member you want to remove from the list above (1 for Faculty 1, etc.): ");
			int index = input.nextInt();
			if(index < 1 || index > facultyMembers.size()) {
				System.out.println("Invalid faculty member.");
			}
			else {
				facultyMembers.remove(index - 1);
				System.out.println("Faculty member has been removed.");
			}
		}
	}
	public void displayStudents() {
		System.out.println("\nCurrent students enrolled: ");
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
		System.out.println("\nCurrent courses offered: ");
		if(courses.size() > 0) {
			for(int i = 0; i < courses.size(); i++) {
				System.out.println("\tCourse "+ (i+1) + ":\n" + courses.get(i).toString() + "\n");
			}
		}
		else {
			System.out.println("There are no courses offered.");
		}
	}
	public void displayFacultyMembers() {
		System.out.println("\nCurrent faculty: ");
		if(facultyMembers.size() > 0) {
			for(int i = 0; i < facultyMembers.size(); i++) {
				System.out.println("Faculty "+ (i+1) + ":\n" + facultyMembers.get(i).toString() + "\n");
			}
		}
		else {
			System.out.println("There are no faculty members.");
		}
	}
	public void changeStudentSchedule() {
		displayStudents();
		if (students.size() == 0) {
			System.out.println("There are no students enrolled.");
		}
		else {
			System.out.print("Enter which student's schedule you want to change from the list above (1 for Student 1, etc.): ");
			int index = input.nextInt();
			if(index < 1 || index > students.size()) {
				System.out.println("Invalid student.");
			}
			else {
				System.out.print("\nEnter one of the following numbers to choose their corresponding options: \n"
						+ "\t1 : Add course to student's schedule \n"
						+ "\t2 : Remove course from student's schedule \n"
						+ "\t3 : Show student's schedule \n"
						+ ">");					
				if(input.hasNextInt()) {
					int modifyInt = input.nextInt();
					switch(modifyInt)
					{
					case 1:
						displayCourses();
						if (courses.size() == 0) {
							System.out.println("Unable to update schedule since there are no courses in the University.");
						}
						else {
							System.out.print("Enter which course you want to add to the student's schedule from the list above (1 for Course 1, etc.): ");
							int courseIndex = input.nextInt();
							if(courseIndex < 1 || courseIndex > courses.size()) {
								System.out.println("Invalid course.");
							}
							else {
								if(students.get(index - 1).add(courses.get(courseIndex - 1))) {
									System.out.println("Course has been added to student's schedule.");
								}
							}
						}
						break;
					case 2:
						System.out.println(students.get(index - 1).displayEnrolled());
						if (students.get(index-1).getCourses().size() == 0) {
							System.out.println("Unable to remove a course since the student is not enrolled in any courses.");
						}
						else {
							System.out.print("Enter which course you want to remove from the student's schedule from the list above (1 for Course 1, etc.): ");
							int courseIndex = input.nextInt();
							if(courseIndex < 1 || courseIndex > students.get(index - 1).getCourses().size()) {
								System.out.println("Invalid course.");
							}
							else {
								students.get(index - 1).drop(courseIndex-1);
								System.out.println("Course has been removed from the student's schedule.");
							}
						}
						break;
					case 3:
						System.out.println("Student's schedule: ");
						System.out.println(students.get(index - 1).displayEnrolled());
						break;
					default:
						System.out.println("Invalid option.");
					}
				}
				else {
					System.out.println("Invalid option.");
				}
				
			}
		}
	}
	public void changeFacultySchedule() {
		displayFacultyMembers();
		if (facultyMembers.size() == 0) {
			System.out.println("There are no faculty members in the university.");
		}
		else {
			System.out.print("Enter which faculty member's schedule you want to change from the list above (1 for Faculty 1, etc.): ");
			int index = input.nextInt();
			if(index < 1 || index > facultyMembers.size()) {
				System.out.println("Invalid faculty.");
			}
			else {
				System.out.print("\nEnter one of the following numbers to choose their corresponding options: \n"
						+ "\t1 : Add course to faculty member's schedule \n"
						+ "\t2 : Remove course from faculty member's schedule \n"
						+ "\t3 : Show faculty member's schedule \n"
						+ ">");					
				if(input.hasNextInt()) {
					int modifyInt = input.nextInt();
					switch(modifyInt)
					{
					case 1:
						displayCourses();
						if (courses.size() == 0) {
							System.out.println("Unable to update schedule since there are no courses in the University.");
						}
						else {
							System.out.print("Enter which course you want to add to the faculty member's schedule from the list above (1 for Course 1, etc.): ");
							int courseIndex = input.nextInt();
							if(courseIndex < 1 || courseIndex > courses.size()) {
								System.out.println("Invalid course.");
							}
							else {
								if(facultyMembers.get(index - 1).add(courses.get(courseIndex - 1))) {
									System.out.println("Course has been added to facultyMember's schedule.");
								}
								
							}
						}
						break;
					case 2:
						System.out.println(facultyMembers.get(index - 1).displayTeaching());
						if (facultyMembers.get(index-1).getSchedule().size() == 0) {
							System.out.println("Unable to remove a course since the faculty member is not teaching any courses.");
						}
						else {
							System.out.print("Enter which course you want to remove from the faculty member's schedule from the list above (1 for Course 1, etc.): ");
							int courseIndex = input.nextInt();
							if(courseIndex < 1 || courseIndex > facultyMembers.get(index - 1).getSchedule().size()) {
								System.out.println("Invalid course.");
							}
							else {
								facultyMembers.get(index - 1).drop(courseIndex-1);
								System.out.println("Course has been removed from the faculty member's schedule.");
							}
						}
						break;
					case 3:
						System.out.println("Faculty member's schedule: ");
						System.out.println(facultyMembers.get(index - 1).displayTeaching());
						break;
					default:
						System.out.println("Invalid option.");
					}
				}
				else {
					System.out.println("Invalid option.");
				}
				
			}
		}
	}
}
