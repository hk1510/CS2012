package checkpoint1;
import java.util.Scanner;
public class StrictlyIdenticalArrays {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number of elements in the first list followed by the elements of the first list:");
		int length = input.nextInt();
		int[] list1 = new int[length];
		for (int i = 0; i < length; i++) {
			list1[i] = input.nextInt();
		}
		System.out.println("Enter the number of elements in the second list followed by the elements of the second list:");
		length = input.nextInt();
		int[] list2 = new int[length];
		for (int i = 0; i < length; i++) {
			list2[i] = input.nextInt();
		}
		if (equals(list1, list2)) {
			System.out.println("The two lists are strictly identical");
		}
		else {
			System.out.println("The two lists are not strictly identical");
		}
	}
	public static boolean equals(int[] list1, int[] list2) {
		if (list1.length == list2.length) {
			for(int i = 0; i < list1.length; i++) {
				if (list1[i] != list2[i]) {
					return false;
				}
			}
			return true;
		}
		else {
			return false;
		}
		
	}
}
