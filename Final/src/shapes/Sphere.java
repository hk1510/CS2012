package shapes;

public class Sphere extends Shape3D{
	private double radius;
	public Sphere(double radius) {
		this.radius = radius;
		this.volume = (4.0/3)*Math.PI*Math.pow(radius, 3);
	}
	public Cube getEquivalentCube() {
		return new Cube(Math.pow(this.volume, 1/3.0));
	}
	public String toString() {
		return "sphere with radius " + radius + " and volume " + volume;
	}
}
