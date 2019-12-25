package shapes;

public class Driver {
	public static void main(String[] args) {
		Cube cube = new Cube(5);
		Sphere sphere = new Sphere(7);
		System.out.println(cube.toString());
		System.out.println(sphere.toString());
		System.out.println(cube.getEquivalentCube());
		System.out.println(sphere.getEquivalentCube());
	}
}
