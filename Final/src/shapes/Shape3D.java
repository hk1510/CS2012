package shapes;

public abstract class Shape3D {
	protected double volume;
	public boolean isLargerThan(Shape3D shape) {
		return this.volume > shape.volume;
	}
	public double getVolume() {
		return volume;
	}
	public abstract Cube getEquivalentCube();
}
