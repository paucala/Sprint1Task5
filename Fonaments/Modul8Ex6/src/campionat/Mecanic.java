package campionat;

public class Mecanic extends Treballador implements salary{
	private boolean highStudies;
	
	public Mecanic (String name, String surname, int age, int seniority, boolean highStudies) {
		super (name, surname, age, seniority);
		this.highStudies = highStudies;
	}
	public boolean getHighStudies() {
		return this.highStudies;
	}
	public void setHighStudies(boolean highStudies) {
		this.highStudies = highStudies;
	}
	public int setSalary() {
		int salary = super.getSalary() + (10000 * super.getSeniority());
		return salary;
	}
	public String getDescription() {
		if (this.highStudies == true) {
			return "El mecànic " + super.getName() + " " + super.getSurname() + ", de " + super.getAge() + " anys, porta " 
					+ super.getSeniority() + " anys a l'empresa, té estudis superiors i cobra " + this.setSalary() + " euros.";
		} else {
			return "El mecànic " + super.getName() + " " + super.getSurname() + ", de " + super.getAge() + " anys, porta " 
					+ super.getSeniority() + " anys a l'empresa, no té estudis superiors i cobra" + this.setSalary() + " euros.";
		}
		
	}

}
