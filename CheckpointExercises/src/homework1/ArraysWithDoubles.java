package homework1;
import java.util.Scanner;


public class ArraysWithDoubles {

/* main() should call the input method, then send the array to the print method, then run each of the other 
 * methods, using the print method to print the current values after each method is done. After running 
 * the method that creates a new array, print out both the original array and the one returned by the method. 
 * If the two arrays contain the same values, the method that makes a copy and calculates the inverses is 
 * probably not correct. */	
	
	public static void main(String[] args) {
		//call the input method and store the returned value in a variable
		double[] array = initializeArray();
		//print the current values of the array
		System.out.println("\nArray: ");
		printArr(array);
		//call the method that prints the cubed values of the array
		System.out.println("\nCubing the values of the Array...");
		System.out.println("Cubed Array:");
		cubedArray(array);
		//print the current values of the array
		System.out.println("Original Array:");
		printArr(array);
		//call the method that changes values greater than 250 to 250
		System.out.println("\nChanging the values greater than 250 in the original array to 250...");
		maxValTwoFifty(array);
		//print the current values of the array
		System.out.println("Current values of original array:");
		printArr(array);
		//call the method that copies the values of the array and 
		//changes the values of the original array to their inverses
		System.out.println("\nCopying the values of the original array and changing "
							+ "the values of the original array to their inverses...");
		double[] copy = inverseCopy(array);
		//print the values of the original array
		System.out.println("Current values of original array:");
		printArr(array);
		//print the copied array
		System.out.println("Values of copied array:");
		printArr(copy);
	}
	
/* Write a method that creates an array of ten nonnegative doubles, initializes it with values 
 * taken from console input (ie, a Scanner from System.in) inside a loop, and returns a reference 
 * to the array. Validate the user input to make sure the program does not crash if the user enters 
 * invalid data. For each double you request, keep asking until the user enters a valid nonnegative double.*/

	public static double[] initializeArray() {
		//create a scanner
		Scanner input = new Scanner(System.in);
		//create an array to store the 10 non-negative doubles
		double[] array = new double[10];
		//Prompt the user for input
		System.out.println("Enter 10 nonnegative doubles one by one:");
		//for every index in the array
		for (int i = 0; i < array.length; i++) {
			do {
				//give a different prompt based on the double being prompted
				if(i == 0) {
					System.out.print("Enter the 1st double: ");
				}
				else if (i == 1) {
					System.out.print("Enter the 2nd double: ");
				}
				else if (i == 2) {
					System.out.print("Enter the 3rd double: ");
				}
				else {
					System.out.print("Enter the " + (i+1) + "th double: ");
				}
				//if the user has not entered a double
				if(!input.hasNextDouble()) {
					//store the user input in a string
					String str = input.next();
					//tell the user that the input was not a double
					System.out.println(str + " is not a double! ");
				}
				else {
					//store the user input
					double temp = input.nextDouble();
					//if the input is 0 exit the loop
					if (temp == 0) {
						break;
					}
					//if the input is negative, tell the user
					else if(temp < 0) {
						System.out.println("You entered a negative double!");
					}
					//if the input passes all validation, store it in the array
					else {
						array[i] = temp;
					}
					
				}
			}
			//repeat if the value of the item in the array is less than or equal to 0 
			//(it will be equal to 0 if the user inputs a string)
			while(array[i] <= 0);
		}
		//output the reference to the array
		return array;
	}

/* Write a void method that takes an array of doubles as its only parameter, calculates the cube of 
 * each value in the array, and prints out each result. This method should not change the values 
 * in the array. */	
	
	public static void cubedArray (double[] array) {
		//for all values in the array
		for (int i = 0; i < array.length; i++) {
			//print a bracket and a comma along with the first cubed value
			if (i == 0) {
				System.out.print("[ " + Math.pow(array[i], 3) + ", ");
			}
			//print only a bracket and a comma along with the last cubed value
			else if (i == array.length - 1) {
				System.out.print(Math.pow(array[i], 3) + " ]\n");
			}
			//print only a comma along with all cubed values other than the first and the last
			else {
				System.out.print(Math.pow(array[i], 3) + ", ");
			}
			
		}
		
	}

/* Write a method that takes an array of doubles as its only parameter and replaces any value exceeding 
 * 250 with the value 250. This method should be void; in other words it should not return anything. Be 
 * sure you understand how array references are sent to methods. */	
	
	public static void maxValTwoFifty(double[] array) {
		//for all values in the array
		for (int i = 0; i < array.length; i++) {
			//check if the value is greater than 250
			if (array[i] > 250) {
				//replace the value with 250
				array[i] = 250;
			}
			
		}
		
	}

/* Write a method that takes an array of doubles as its only parameter, copies the array, replaces each 
 * value in the old array with its inverse (1/x), and returns a reference to the new array. Be sure you 
 * understand the difference between copying an array and copying an array reference, or you will not do 
 * this part correctly. */	

	public static double[] inverseCopy(double[] array) {
		//create an array to copy values into
		double[] copy = new double[array.length];
		//for all values in the original array
		for(int i = 0; i < array.length; i++) {
			//set the value of the copy array to the corresponding value of the original array
			copy[i] = array[i];
		}
		//for all values in the original array
		for(int i = 0; i < array.length; i++) {
			//set the value to the reciprocal of the original value
			array[i] = 1/array[i];
		}
		//return a reference to the copied array
		return copy;
	}
	
// Write a void method that takes an array of doubles as its only parameter and prints out all the values.
	
	public static void printArr(double[] array) {
		//for all values in the array
		for (int i = 0; i < array.length; i++) {
			//print a bracket and a comma along with the first cubed value
			if (i == 0) {
				System.out.print("[ " + array[i] + ", ");
			}
			//print only a bracket along with the last cubed value
			else if (i == array.length - 1) {
				System.out.print(array[i] + " ]\n");
			}
			//print only a comma along with all cubed values other than the first and the last
			else {
				System.out.print(array[i] + ", ");
			}
			
		}
	}
}

