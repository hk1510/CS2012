package animalWar;

public class Mouse extends Prey{
	public Mouse(double weight, String name) {
		super(weight, name);
	}

	@Override
	public void flee() {
		System.out.println(this.getName() + " scurried away.");
	}

	@Override
	public void call() {
		System.out.println(this.getName() + " says 'squeak'");
	}
	
	@Override
	public String toString() {
		return this.getName() + " is a Mouse weighing " + this.getWeight() + " grams.";
	}
	
}
