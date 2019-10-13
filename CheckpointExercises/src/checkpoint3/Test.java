package checkpoint3;

public class Test {
	public static void main(String args[]) {
		RightTriangle triangle = new RightTriangle(3, 4, 5);
		RightTriangle triangle1 = new RightTriangle(1, 2, 3);
		try {
			triangle.checkValidSides();
		} catch (InvalidRightTriangleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			triangle1.checkValidSides();
		} catch (InvalidRightTriangleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
