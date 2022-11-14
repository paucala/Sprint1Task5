package campionat;

import java.util.ArrayList;
import java.util.Scanner;

public class MainCampionat {
	static ArrayList<Escuderia> escuderies = new ArrayList<Escuderia>();

	public static void main(String[] args) {
		String name = "", color  = "", surname = "", origenCountry  = "", resposta = "";
		int op = 0, x = 0, y = 0;
		int budget = 0, force = 0, maxSpeed = 0, price = 0, age = 0, seniority = 0, id = 0, weight = 0;
		boolean highStudies = false;
		float heigh = 0; 
		Scanner entry = new Scanner(System.in);
		
		do {
			System.out.println("SElecciona una opció: \n"
					+ "1. Crear escuderia \n"
					+ "2. Afegir cotxe \n"
					+ "3. Afegir pilot \n"
					+ "4. Afegir mecànic \n"
					+ "5. Mostrar escuderia \n"
					+ "6. Eliminar escuderia \n"
					+ "7. Eliminar cotxe \n"
					+ "8. Eliminar pilot \n"
					+ "9. Eliminar mecànic \n"
					+ "0. Sortir");
			op = entry.nextInt();
			entry.nextLine();
				while (op < 0 || op > 9) {
					System.out.println("La opció escollida no existeix, selecciona una altre opció: ");
					op = entry.nextInt();
					entry.nextLine();
				}
			switch (op) {
				case 1:
					System.out.println("Indica el nom de la nova escuderia");
					name = entry.nextLine();
					System.out.println("Indica el pressupost de la nova escuderia");
					budget = entry.nextInt();
					entry.nextLine();
					System.out.println("Indica el país d'origen de la nova escuderia");
					origenCountry = entry.nextLine();
					createEscuderia(name, budget, origenCountry);
					break;
				case 2:
					System.out.println("Indica el nom de la escuderia on vols inscriure el cotxe");
					name = entry.nextLine();
					x = searchEscuderia(name, x);
					while (x == -1) {
						System.out.println("No s'ha trobat la escuderia, torna a introduir el nom: ");
						name = entry.nextLine();
						x = searchEscuderia(name, x);
					}
					System.out.println("Indica la potencia del nou cotxe");
					force = entry.nextInt();
					System.out.println("Indica la velocitat màxima del nou cotxe");
					maxSpeed = entry.nextInt();
					entry.nextLine();
					System.out.println("Indica el color del nou cotxe");
					color = entry.nextLine();
					System.out.println("Indica el preu de mercat del nou cotxe");
					price = entry.nextInt();
					entry.nextLine();
					createCotxe(force, maxSpeed, color, price, x);					
					break;
				case 3:
					System.out.println("Indica el nom de la escuderia on vols inscriure el pilot");
					name = entry.nextLine();
					x = searchEscuderia(name, x);
					while (x == -1) {
						System.out.println("No s'ha trobat la escuderia, torna a introduir el nom: ");
						name = entry.nextLine();
						x = searchEscuderia(name, x);
					}
					System.out.println("Indica el nom del pilot");
					name = entry.nextLine();
					System.out.println("Indica el cognom del pilot");
					surname = entry.nextLine();
					System.out.println("Indica la edat del pilot");
					age = entry.nextInt();
					System.out.println("Indica l'antiguittat del pilot a l'escuderia");
					seniority = entry.nextInt();
					System.out.println("Indica l'alçada del pilot");
					heigh = entry.nextFloat();
					System.out.println("Indica el pes del pilot");
					weight = entry.nextInt();
					entry.nextLine();
					createPilot(name, surname, age, seniority, heigh, weight, x);
					break;
				case 4:
					System.out.println("Indica el nom de la escuderia on vols inscriure el mecànic");
					name = entry.nextLine();
					x = searchEscuderia(name, x);
					while (x == -1) {
						System.out.println("No s'ha trobat la escuderia, torna a introduir el nom: ");
						name = entry.nextLine();
						x = searchEscuderia(name, x);
					}
					System.out.println("Indica el nom del mecànic");
					name = entry.nextLine();
					System.out.println("Indica el cognom del mecànic");
					surname = entry.nextLine();
					System.out.println("Indica la edat del mecànic");
					age = entry.nextInt();
					System.out.println("Indica l'antiguittat del mecànic a l'escuderia");
					seniority = entry.nextInt();
					System.out.println("Té el mecànic estudis superiors? Si/No");
					resposta = entry.next();
						if (resposta.equalsIgnoreCase("Si")) {
							highStudies = true;
						} else {
							highStudies = false;
						}
					createMecanic(name, surname, age, seniority, highStudies, x);
					break;
				case 5:
					System.out.println("Indica el nom de la escuderia que vols mostrar");
					name = entry.nextLine();
					x = searchEscuderia(name, x);
					while (x == -1) {
						System.out.println("No s'ha trobat la escuderia, torna a introduir el nom: ");
						name = entry.nextLine();
						x = searchEscuderia(name, x);
					showEscuderia(name, x);
					}
					break;
				case 6:
					System.out.println("Indica el nom de la escuderia que vols eliminar");
					name = entry.nextLine();
					x = searchEscuderia(name, x);
					while (x == -1) {
						System.out.println("No s'ha trobat la escuderia, torna a introduir el nom: ");
						name = entry.nextLine();
						x = searchEscuderia(name, x);
					}
					escuderies.remove(x);
					System.out.println("Escuderia eliminada");
					break;
				case 7:
					System.out.println("Indica el nom de la escuderia a la que vols eliminar el cotxe");
					name = entry.nextLine();
					x = searchEscuderia(name, x);
					while (x == -1) {
						System.out.println("No s'ha trobat la escuderia, torna a introduir el nom: ");
						name = entry.nextLine();
						x = searchEscuderia(name, x);
					}
					System.out.println("Indica la id del cotxe que vols eliminar");
					id = entry.nextInt();
					y = searchCotxe(id, x, y);
					while (y == -1) {
						System.out.println("No s'ha trobat el cotxe, torna a introduir la id: ");
						id = entry.nextInt();
						y = searchCotxe(id, x, y);
					}
					escuderies.get(x).getCotxes().remove(y);
					System.out.println("Cotxe eliminat");
					break;
				case 8:
					System.out.println("Indica el nom de la escuderia a la que vols eliminar el pilot");
					name = entry.nextLine();
					x = searchEscuderia(name, x);
					while (x == -1) {
						System.out.println("No s'ha trobat la escuderia, torna a introduir el nom: ");
						name = entry.nextLine();
						x = searchEscuderia(name, x);
					}
					System.out.println("Indica el nom del pilot que vols eliminar");
					name = entry.nextLine();
					y = searchPilot(name, x, y);
					while (y == -1) {
						System.out.println("No s'ha trobat el pilot, torna a introduir el nom: ");
						name = entry.nextLine();
						y = searchPilot(name, x, y);
					}
					escuderies.get(x).getPilots().remove(y);
					System.out.println("Pilot eliminat");
					break;
				case 9:
					System.out.println("Indica el nom de la escuderia a la que vols eliminar el mecànic");
					name = entry.nextLine();
					x = searchEscuderia(name, x);
					while (x == -1) {
						System.out.println("No s'ha trobat la escuderia, torna a introduir el nom: ");
						name = entry.nextLine();
						x = searchEscuderia(name, x);
					}
					System.out.println("Indica el nom del mecànic que vols eliminar");
					name = entry.nextLine();
					y = searchMecanic(name, x, y);
					while (y == -1) {
						System.out.println("No s'ha trobat el mecànic, torna a introduir el nom: ");
						name = entry.nextLine();
						y = searchMecanic(name, x, y);
					}
					escuderies.get(x).getMecanics().remove(y);
					System.out.println("Mecànic eliminat");
					break;
			}
			
		} while (op != 0);

	}
	public static void createEscuderia(String name, int budget, String origenCountry) {
		Escuderia escuderia = new Escuderia(name, budget, origenCountry);
		escuderies.add(escuderia);
		System.out.println("Escuderia creada");
	}
	public static void createCotxe(int force, int maxSpeed, String color, int price, int x) {
		Cotxe cotxe = new Cotxe (force, maxSpeed, color, price);
		escuderies.get(x).getCotxes().add(cotxe);
		System.out.println("Cotxe creat amb la id " + cotxe.getId());
	}
	public static void createPilot(String name, String surname, int age, int seniority, float heigh, int weight, int x) {
		Pilot pilot = new Pilot (name, surname, age, seniority, heigh, weight);
		escuderies.get(x).getPilots().add(pilot);
		System.out.println("Pilot inscrit");
	}
	public static void createMecanic(String name, String surname, int age, int seniority, boolean highStudies, int x) {
		Mecanic mecanic = new Mecanic (name, surname, age, seniority, highStudies);
		escuderies.get(x).getMecanics().add(mecanic);
		System.out.println("Mecanic inscrit");
	}
	public static void showEscuderia (String name, int x) {
		escuderies.get(x).getDescription();
		for (Cotxe cotxe : escuderies.get(x).getCotxes()) {
			System.out.println(cotxe.getDescription());
		}
		for (Pilot pilot : escuderies.get(x).getPilots()) {
			System.out.println(pilot.getDescription());
		}
		for (Mecanic mecanic : escuderies.get(x).getMecanics()) {
			System.out.println(mecanic.getDescription());
		}
	}
	public static int searchEscuderia (String name, int x) {
		x = 0;
		int i = 0;
		boolean found = false;
		while (i < escuderies.size() && found == false) {
			if (name.equalsIgnoreCase(escuderies.get(x).getName())) {
				found = true;
			} else {
				x++;
				i++;
			}
		}
		if (found == true) {
			return x;
		} else {
			return x = -1;
		}
	}
	public static int searchCotxe (int id, int y, int x) {
		y = 0;
		int i = 0;
		boolean found = false;
		while (i < escuderies.get(x).getCotxes().size() && found == false) {
			if (id == (escuderies.get(x).getCotxes().get(y).getId())) {
				found = true;
			} else {
				y++;
				i++;
			}
		}
		if (found == true) {
			return y;
		} else {
			return y = -1;
		}
	}
	public static int searchPilot (String name, int y, int x) {
		y = 0;
		int i = 0;
		boolean found = false;
		while (i < escuderies.get(x).getPilots().size() && found == false) {
			if (name.equalsIgnoreCase(escuderies.get(x).getPilots().get(y).getName())) {
				found = true;
			} else {
				y++;
				i++;
			}
		}
		if (found == true) {
			return y;
		} else {
			return y = -1;
		}
	}
	public static int searchMecanic (String name, int y, int x) {
		y = 0;
		int i = 0;
		boolean found = false;
		while (i < escuderies.get(x).getMecanics().size() && found == false) {
			if (name.equalsIgnoreCase(escuderies.get(x).getMecanics().get(y).getName())) {
				found = true;
			} else {
				y++;
				i++;
			}
		}
		if (found == true) {
			return y;
		} else {
			return y = -1;
		}
	}

}
