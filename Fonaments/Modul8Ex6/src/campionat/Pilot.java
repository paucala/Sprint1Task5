package campionat;

public class Pilot extends Treballador implements salary{
	private float heigh;
	private int weight;
	
	public Pilot (String name, String surname, int age, int seniority, float heigh, int weight) {
		super (name, surname, age, seniority);
		this.heigh = heigh;
		this.weight = weight;
	}

	public float getHeigh() {
		return heigh;
	}

	public void setHeigh(int heigh) {
		this.heigh = heigh;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int setSalary() {
		int salary = super.getSalary() + (10000 * super.getSeniority()) + 50000;
		return salary;
	}
	public String getDescription() {
		return "El pilot " + super.getName() + " " + super.getSurname() + ", de " + super.getAge() + " anys, porta " 
					+ super.getSeniority() + " anys a l'empresa. Fa " + this.heigh + " metres, pesa " + this.weight
					+ " kg i cobra " + this.setSalary() + " euros.";
	}
	

}
