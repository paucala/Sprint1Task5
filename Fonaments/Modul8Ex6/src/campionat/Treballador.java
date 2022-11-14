package campionat;

abstract class Treballador {
// nom, el primer cognom, l’edat, 	el temps que porten a l’escuderia i el sou.
	private String name;
	private String surname;
	private int age;
	private int seniority;
	private int salary;
	
	public Treballador (String name, String surname, int age, int seniority) {
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.seniority = seniority;
		this.salary = 50000;
	}
	public String getName() {
		return this.name;
	}
	public String getSurname() {
		return this.surname;
	}
	public int getAge() {
		return this.age;
	}
	public int getSeniority() {
		return this.seniority;
	}
	public int getSalary() {
		return this.salary;
	}
	public void setName(String name) {
		this.name = name;
	}
	abstract String getDescription();
}
