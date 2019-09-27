package universityProject;

import java.util.Scanner;

public class Person {
	
	private String name;
	private Address address;
	
	
	
	Person() {
		Scanner input = new Scanner(System.in);	
		System.out.println("Enter the name: ");
		name = input.nextLine();
		address = new Address();
	}
	Person(int streetNum, String streetName, String city, String state, String country, String name) {
		this.name = name;
		address = new Address(streetNum, streetName, city, state, country);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public String toString() {
		return "Name: " + getName() + "Address: " + address.toString();
	}
}
