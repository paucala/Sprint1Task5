package campionat;

public class Cotxe {
	private int force;
	private int maxSpeed;
	private String color;
	private int price;
	private int id;
	static private int nextId = 0;
	
	public Cotxe(int force, int maxSpeed, String color, int price) {
		this.force = force;
		this.maxSpeed = maxSpeed;
		this.color = color;
		this.price = price;
		this.id += nextId;
	}
	public int getForce() {
		return this.force;
	}
	public int getMaxSpeed() {
		return this.maxSpeed;
	}
	public String getColor() {
		return this.color;
	}
	public int getPrice() {
		return this.price;
	}
	public int getId() {
		return this.id;
	}
	public void setForce(int force) {
		this.force = force;
	}
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	public void setColor (String color) {
		this.color = color;
	}
	public void setPrice (int price) {
		this.price = price;
	}
	public String getDescription() {
		return "El cotxe " + this.id + " té una potència de " + this.force + " cavalls, arriba a " + this.maxSpeed 
				+ " km/h, és de color " + this.color + " i té un preu al mercat de " + this.price + " euros.";
	}

}
