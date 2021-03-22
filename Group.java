package Tema1POO;
import java.util.ArrayList; 

/**
 * Clasa Group reprezinta entitatea de grup.
 * <br>Aceasta mosteneste clasa PassengerType.
 * @author StefaniaGherasie 323CB
 */
public class Group extends PassengerType {
	/**
	 * points reprezinta scorul grupului care incepe de la 5p.
	 */
	int points = 5, numberOfMembers;
	/**
	 * Vectorul cu pasageri care apartin aceluiasi grup.
	 */
	ArrayList<Passenger> passengers = new ArrayList<Passenger>();
	
	/**
	 * Adauga in vectorul grupului un pasager si adauga, in functie de 
	 * specificatiile acestuia, puncte grupului.
	 * @param passenger Pasagerul care trebuie adaugat grupului.
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
	