package checkpoint4demo2;

public class Engine implements Cloneable{
	private double displacement;
	private String type;
	
	public Engine(double displacement, String type) {
		super();
		this.displacement = displacement;
		this.type = type;
	}
	
	public Engine clone() {
		String newType = new String(type);
		return new Engine(displacement, newType);
		
	}
	
	public boolean equals(Object other) {
		if(other == this) return true;
		if(other == null) return false;
		if(! (other instanceof Engine)) return false;
		Engine otherEngine = (Engine) other;
		if(this.displacement == otherEngine.displacement && this.type.equals(otherEngine.type)) return true;
		return false;		
	}

	@Override
	public String toString() {
		return "Engine [displacement=" + displacement + ", type=" + type + "]";
	} 
	
	
	
}
