package universityProject;

import java.util.Scanner;

public class Address {
	private int streetNum;
	private String streetName;
	private String city;
	private String state;
	private String country;
	
	Scanner input = new Scanner(System.in);
	
	public Address() {
		System.out.println("Enter the street number: ");
		streetNum = input.nextInt();
		input.nextLine();
		System.out.println("Enter the street name: ");
		streetName = input.nextLine();
		System.out.println("Enter the city name: ");
		city = input.nextLine();
		System.out.println("Enter the name of the State: ");
		state = input.nextLine();
		System.out.println("Enter the name of the country: ");
		country = input.nextLine();
		
	}
	
	Address(int streetNum, String streetName, String city, String state, String country) {
		this.streetNum = streetNum;
		this.streetName = streetName;
		this.city = city;
		this.state = state;
		this.country = country;
	}
	
	public int getStreetNumber() {
		return streetNum;
	}
	public String getStreetName() {
		return streetName;
	}
	public String getCity() {
		return city;
	}
	public String getState() {
		return state;
	}
	public String getCountry() {
		return country;
	}
	public void setStreetNumber(int streetNum) {
		this.streetNum = streetNum;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String toString() {
		return streetNum + " " + streetName + ", " + city + ", "
 + state + ", " + country;	
	}
}
