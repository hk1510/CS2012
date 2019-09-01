package checkpoint1;
import java.util.Scanner;
public class AreaOfATriangle {
	public static void main(String[] args) {
		double[][] points = new double[3][2];
		Scanner input = new Scanner(System.in);
		System.out.println("Enter three points in the form x1 y1 x2 y2 x3 y3:");
		for (int i = 0; i < points.length; i++) {
			for (int j = 0; j < points[i].length; j++) {
				points[i][j] = input.nextDouble();
			}
		}
		double area = getTriangleArea(points);
		if (area == 0) {
			System.out.println("The three points are on the same line");
		}
		else {
			System.out.println("The area is " + area);
		}
	}
	public static double getTriangleArea(double[][] points) {
		double side1 = Math.sqrt(Math.pow(points[0][0] - points[1][0], 2) + Math.pow(points[0][1] - points[1][1], 2));
		double side2 = Math.sqrt(Math.pow(points[1][0] - points[2][0], 2) + Math.pow(points[1][1] - points[2][1], 2));
		double side3 = Math.sqrt(Math.pow(points[0][0] - points[2][0], 2) + Math.pow(points[0][1] - points[2][1], 2));
		double s = (side1 + side2 + side3)/2;
		return Math.sqrt(s*(s-side1)*(s-side2)*(s-side3));
	}
}