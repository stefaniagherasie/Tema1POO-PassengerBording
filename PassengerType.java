package Tema1POO;
import java.util.ArrayList;

/**
 * Clasa PassengerType este clasa de baza pentru tipurile de entitati
 * care se creeaza pentru structurarea pasagerilor: familie, grup sau singur. 
 * Se calculeaza scorul fiecarei entitati in functie de tipul acesteia.
 * @author StefaniaGherasie 323CB
 */
public class PassengerType {
	/**
	 * points reprezinta scorul entitatii.
	 */
	String ID;
	int points, numberOfMembers;
	
	/**
	 * Fiecare entitate are un vector de tipul Passenger in care se afla
	 * toti membrii entitatii respective.
	 */
	ArrayList<Passenger> passengers = new ArrayList<Passenger>();
	
	/**
	 * Adauga puncte in functie de tipul de bilet detinut:
	 * 		<li> Business - 35p</li>
	 * 		<li> Premium - 20p</li>
	 * 		<li> Economic - 0p</li>
	 * @param passenger Pasagerul pentru care se calculeaza scorul.
	 */
	void addPointsForTicket(Passenger passenger) {
		String ticket = new String(passenger.getTicket());
		if(ticket.equals("b") == true)
			points += 35;
		else if(ticket.equals("p") == true)
			points += 20;
	}
	
	/**
	 *  Adauga puncte daca pasagerul are imbarcare prioritara.
	 *  	<li>Imbarcare prioritara - 30p</li>
	 * @param passenger Pasagerul pentru care se calculeaza scorul.
	 */
	void addPointsForPriority(Passenger passenger) {
		boolean priority = passenger.getPriority();
		if(priority == true)
			points += 30;
	}
	
	/**
	 * Adauga puncte in functie de varsta pasagerului:
	 * 		<li>sub 2 ani - 20p</li>
	 * 		<li>sub 5 ani - 10p</li>
	 * 		<li>intre 5-10 ani - 5p</li>
	 * 		<li>intre 10-60 ani - 0p</li>
	 * 		<li>peste 60 ani - 15p</li>
	 * @param passenger Pasagerul pentru care se calculeaza scorul.
	 */
	void addPointsForAge(Passenger passenger) {
		int age = passenger.getAge();
		if(age >= 0 && age < 2)
			points += 20;
		else if(age >= 2 && age < 5)
			points += 10;
		else if(age >= 5 && age < 10)
			points += 5;
		else if(age >= 60)
			points += 15;
	}
	
	/**
	 * Adauga puncte daca pasagerul are nevoi speciale:
	 * 		<li>Nevoi speciale - 100p</li>
	 * @param passenger Pasagerul pentru care se calculeaza scorul.
	 */
	void addPointsForSpecialNeeds(Passenger passenger) {
		boolean specialNeeds = passenger.getSpecialNeeds();
		if(specialNeeds == true)
			points += 100;
	}
	
	/**
	 * Adauga puncte pentru tipul de entitate:
	 * 		<li>Familie - 10p</li>
	 * 		<li>Group - 5p</li>
	 * 		<li>Singur - 0p</li>
	 * Punctele pentru entiatate se adauga doar o singura data.
	 * @param passenger Pasagerul pentru care se calculeaza scorul.
	 */
	void addPointsForType(Passenger passenger) {
		String Type = passenger.getType();
		if(Type.equals("family") == true)
			points += 10;
		else if(Type.equals("group") == true)
			points += 5;
	}
	
	void deletePoints(Passenger passenger) {
		String ticket = new String(passenger.getTicket());
		if(ticket.equals("b") == true)
			points -= 35;
		else if(ticket.equals("p") == true)
			points -= 20;
		boolean priority = passenger.getPriority();
		if(priority == true)
			points -= 30;
		int age = passenger.getAge();
		if(age >= 0 && age < 2)
			points -= 20;
		else if(age >= 2 && age < 5)
			points -= 10;
		else if(age >= 5 && age < 10)
			points -= 5;
		else if(age >= 60)
			points -= 15;
		boolean specialNeeds = passenger.getSpecialNeeds();
		if(specialNeeds == true)
			points -= 100;
	}
	
	/**
	 * Cauta indexul la care se afla un pasager in vectorul de pasageri.
	 * @param persArray Vectorul de pasageri ai entitatii.
	 * @param passenger Pasagerul pentru care se cauta indexul.
	 * @return Indexul corespunzator sau -1 daca pasagerul nu exista in entitate.
	 */
	int findIndex(ArrayList<PassengerType> persArray, Passenger passenger) {
		int index = -1;
		for(int j = 0; j < persArray.size(); j++)
			if(((persArray.get(j)).ID).equals(passenger.ID) == true) 
				index = j;
		return index;
	}
}
