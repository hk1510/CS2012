package animalWar;

public class Bird extends Prey{
	public Bird(double weight, String name) {
		super(weight, name);
	}

	@Override
	public void flee() {
		System.out.println(this.getName() + " flew away.");
	}

	@Override
	public void call() {
		System.out.println(this.getName() + " says 'cheep cheep'");
	}
	
	@Override
	public String toString() {
		return this.getName() + " is a Bird weighing " + this.getWeight() + " grams.";
	}
}
