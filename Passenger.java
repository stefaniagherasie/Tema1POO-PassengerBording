package Tema1POO;

/**
 * Clasa Passenger reprezinta tipul de pasager care asteapta imbarcarea
 * in avion, specificandu-se caracteristicile individuale ale acestuia.
 * @author StefaniaGherasie 323CB
 */
public class Passenger {
	int age;
	String name, ID, ticket;
	boolean priority, specialNeeds;
	
	/**
	 * Seteaza ID-ul pasagerului.
	 * @param ID ID-ul entitatii de care apartine pasagerul: familie, grup, singur.
	 */
	void setID(String ID) {
		this.ID = ID;
	}
	
	/**
	 * Seteaza numele pasagerului.
	 * @param name Numele pasagerului.
	 */
	void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Seteaza varsta pasagerului.
	 * @param age Varsta pasagerului
	 */
	void setAge(int age) {
		this.age = age;
	}
	
	/**
	 * Seteaza tipul de bilet pe care il are pasagerul.
	 * @param ticket Tipul de bilet: 'b' - Business, 'p' - Premium, 'e' - Economic
	 */
	void setTicket(String ticket) {
		this.ticket = ticket;
	}
	
	/**
	 * Seteaza daca pasagerul are imbarcare prioritara.
	 * @param priority Imbarcarea prioritara.
	 */
	void setPriority(boolean priority) {
		this.priority = priority;
	}
	
	/**
	 * Seteaza daca pasagerul are nevoi speciale.
	 * @param specialNeeds Nevoi speciale
	 */
	void setSpecialNeeds(boolean specialNeeds) {
		this.specialNeeds = specialNeeds;
	}
	
	/**
	 * @return ID-ul entitatii de care apartine pasagerul: familie, grup, singur.
	 */
	String getID() {
		return ID;
	}
	
	/**
	 * Afla tipul entitatii din care face parte pasagerul:
	 * 		<li>'s' - single</li>
	 * 		<li>'f' - family</li>
	 * 		<li>'g' - group</li>
	 * @return Tipul entitatii de care apartine pasagerul: familie, grup, singur.
	 */
	String getType() {
		String type = getID();
		if((type.substring(0, 1)).equals("f") == true)
			return "family";
		else if((type.substring(0, 1)).equals("g") == true)
			return "group";
		else 
			return "single";
	}
	
	/**
	 * @return Numele pasagerului.
	 */
	String getName() {
		return name;
	}
	
	/**
	 * @return Varsta pasagerului.
	 */
	int getAge() {
		return age;
	}
	
	/**
	 * @return Tipul de bilet detinut.
	 */
	String getTicket() {
		return ticket;
	}
	
	/**
	 * @return Imbarcarea prioritara.
	 */
	boolean getPriority() {
		return priority;
	}
	
	/**
	 * @return Nevoi speciale.
	 */
	boolean getSpecialNeeds() {
		return specialNeeds;
	}

}
