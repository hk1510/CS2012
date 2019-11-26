package animalWar;

public abstract class Prey extends Animal{

	public Prey(double weight, String name) {
		super(weight, name);
	}
	
	public abstract void flee();
}
