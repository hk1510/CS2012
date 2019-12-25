package shapes;

public class Cube extends Shape3D{
	private double side;
	public Cube(double side) {
		this.side = side;
		this.volume = Math.pow(side, 3);
	}
	public Cube getEquivalentCube() {
		return this;
	}
	public String toString() {
		return "cube with side " + side + " and volume " + volume;
	}
}
