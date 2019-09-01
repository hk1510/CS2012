package checkpoint1;
import java.util.Scanner;
public class MarkovMatrix {
	public static void main (String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a 3 x 3 matrix of double values:");
		double[][] matrix = new double[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				matrix[i][j] = input.nextDouble();
			}
		}
		if (isMarkovMatrix(matrix))
			System.out.println("It is a markov matrix");
		else
			System.out.println("It is not a markov matrix");
	}
	public static boolean isMarkovMatrix (double[][] m) {
		for (int i = 0; i < 3; i++) {
			double sum = 0;
			for (int j = 0; j < 3; j++) {
				sum = sum + m[j][i];
				if (m[j][i] < 0)
					return false;
			}
			if (sum != 1.0)
				return false;
		}
		
		return true;
	}
}
