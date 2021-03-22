package Tema1POO;
import java.util.ArrayList;

/**
 * Clasa Single reprezinta entitatea de pasager singur.
 * <br>Aceasta mosteneste clasa PassengerType.
 * @author StefaniaGherasie 323CB
 */
public class Single extends PassengerType {
	/**
	 * points reprezinta scorul pasagerului singur care incepe de la 0p.
	 */
	int points = 0, numberOfMembers;
	
	/**
	 * Vectorul entitatii. In cazul pasagerului singur 
	 * vectorul contine doar un element.
	 */
	ArrayList<Passenger> passengers = new ArrayList<Passenger>();
	
	/**
	 * Calculeaza scorul pasagerului singur si il adauga.
	 * @param passenger Pasagerul care trebuie adaugat.
	 */
	void addMember(Passenger passenger) {
		addPointsForAge(passenger);
		addPointsForSpecialNeeds(passenger);
		addPointsForTicket(passenger);
		addPointsForPriority(passenger);
		numberOfMembers++;
		if(numberOfMembers == 1) {
			addPointsForType(passenger);
		}
		passengers.add(passenger);
	} 
}
