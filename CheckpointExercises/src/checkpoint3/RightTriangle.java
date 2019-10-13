package checkpoint3;

public class RightTriangle {
	private double side1;
	private double side2;
	private double side3;
	
	RightTriangle (double side1, double side2, double side3) {
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}
	
	public void checkValidSides () throws InvalidRightTriangleException{
		double max = side3;
		double otherside1 = side2;
		double otherside2 = side1;
		if (side1 > side3) {
			max = side1;
			otherside1 = side2;
			otherside2 = side3;
			if(side2 > side1) {
				max = side2;
				otherside1 = side1;
				otherside2 = side3;
			}
		}
		else if(side2 > side3) {
			max = side2;
			otherside1 = side1;
			otherside2 = side3;
			if (side1 > side2) {
				max = side1;
				otherside1 = side2;
				otherside2 = side3;
			}
		}
		
		if (max != Math.sqrt(Math.pow(otherside1, 2) + Math.pow(otherside2, 2))) {
			throw new InvalidRightTriangleException("The sides of the triangle are not valid!");
		}
	}

}
