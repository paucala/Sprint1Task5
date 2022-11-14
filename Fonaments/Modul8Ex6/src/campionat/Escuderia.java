package campionat;

import java.util.ArrayList;

public class Escuderia {
//el nom, el pressupost que tenen i el país d’origen.
	private String name;
	private int budget;
	private String origenCountry;
	private ArrayList<Cotxe> cotxes;
	private ArrayList<Mecanic> mecanics;
	private ArrayList<Pilot> pilots;
	
	public Escuderia(String name, int budget, String origenCountry) {
		this.name = name;
		this.budget = budget;
		this.origenCountry = origenCountry;
		this.cotxes = new ArrayList<Cotxe>();
		this.mecanics = new ArrayList<Mecanic>();
		this.pilots = new ArrayList<Pilot>();
	}
	public String getName() {
		return this.name;
	}
	public int getBudget() {
		return this.budget;
	}
	public String getOrigenCountry() {
		return this.origenCountry;
	}
	public ArrayList<Cotxe> getCotxes() {
		return this.cotxes;
	}
	public ArrayList<Mecanic> getMecanics() {
		return this.mecanics;
	}
	public ArrayList<Pilot> getPilots() {
		return this.pilots;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setBudget(int budget) {
		this.budget = budget;
	}
	public void setOrigenCountry(int country) {
		this.origenCountry = origenCountry;
	}
	public void createCotxe(int force, int maxSpeed, String color, int price) {
		Cotxe car = new Cotxe(force, maxSpeed, color, price);
		this.cotxes.add(car);
	}
	public String getDescription() {
		return "L'escuderia " + this.name + " té un pressupost de " + this.budget + " milions i prové de " + this.origenCountry + 
				". Aquesta escuderia té " + this.cotxes.size() + " cotxes. \n"
				+ "Mostrem els cotxes i els treballadors a continuació: ";				
	}
	
}
