package checkpoint1;
import java.util.Scanner;

public class OverloadedAverageMethod {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter 10 double values: ");
		double[] array = new double[10];
		for (int i = 0; i < array.length; i++) {
			array[i] = input.nextDouble();
		}
		System.out.println(average(array));
	}
	public static int average(int[] array) {
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum = sum + array[i];
		}
		return sum/array.length;
	}
	public static double average(double[] array) {
		double sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum = sum + array[i];
		}
		return sum/array.length;
	}
}
