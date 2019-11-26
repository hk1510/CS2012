package animalWar;

public abstract class Animal {
	private String name;
	private double weight;
	
	public Animal(double weight, String name) {
		this.name = name;
		this.weight = weight;
	}
	public String getName() {
		return name;
	}
	public double getWeight() {
		return weight;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public void eat(double weightInGrams) {
		weight = weight + weightInGrams;
	}
	
	public abstract void call();
}
