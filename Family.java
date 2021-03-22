package Tema1POO;
import java.util.ArrayList;

/**
 * Clasa Family reprezinta entitatea de familie.
 * <br>Aceasta mosteneste clasa PassengerType.
 * @author StefaniaGherasie 323CB
 */
public class Family extends PassengerType {
	/**
	 * points reprezinta scorul scorul familiei care incepe de la 10p.
	 */
	int points = 10, numberOfMembers;
	/**
	 * Vectorul cu pasageri care apartin aceleiasi familii.
	 */
	ArrayList<Passenger> passengers = new ArrayList<Passenger>();

	/**
	 * Adauga in vectorul familiei un pasager si adauga, in functie de 
	 * specificatiile acestuia, puncte familiei.
	 * @param passenger Pasagerul care trebuie adaugat familiei.
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
