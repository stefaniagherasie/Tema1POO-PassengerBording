package Tema1POO;

import java.io.*;
import java.util.ArrayList; 

/**
 * Programul implementeaza un mecanism de ordonare a pasagerilor care
 * asteapta imbarcarea intr-un avion, tinandu-se cont de anumite beneficii.
 * <br>Implementarea se face folosind MaxHeap pentru coada de prioritate si
 * utilizeaza notiunile de Mostenire si Polimorfism.
 * 
 * @author StefaniaGherasie 323CB
 *
 */
public class Main {

	/**
	 * @param args
	 * @throws IOException Eroare la citirea sau scrierea in fisier.
	 */
	public static void main(String[] args) throws IOException {
		/*Vector in care se salveaza toate entitatile in ordinea citirii lor*/
		ArrayList<PassengerType> persArray = new ArrayList<PassengerType>();
		int index;
		
		/*Fisierul de intrare*/
		File input = new File("queue.in");
		BufferedReader bufferR = new BufferedReader(new FileReader(input));
		/*Fisierul de iesire*/
		File outputFile = new File("queue.out");
		FileWriter output = new FileWriter(outputFile);
		output.close();	
		
		/*Extragere numar de pasageri*/
		int passengerNumber = Integer.parseInt(bufferR.readLine());
		
		for(int i = 1; i <= passengerNumber; i++) {
			/*Obtinere detalii pentru fiecare pasager*/
			String passengerDetails = bufferR.readLine();
			String[] details = passengerDetails.split(" ", 0);
			
			/*Setare atribute pasager*/
			Passenger passenger = new Passenger();
			passenger.setID(details[0]);
			passenger.setName(details[1]);
			passenger.setAge(Integer.parseInt(details[2]));
			passenger.setTicket(details[3]);
			passenger.setPriority(Boolean.parseBoolean(details[4]));
			passenger.setSpecialNeeds(Boolean.parseBoolean(details[5]));
			
			/*Pasagerul apartine unei familii*/
			if((passenger.getType()).equals("family") == true){
				PassengerType family = new Family();
				index = family.findIndex(persArray, passenger);
				
				/*Familia nu exista deja*/
				if(index != -1)
					((Family)(persArray.get(index))).addMember(passenger);
				/*Familia este existenta*/
				else {
					persArray.add((Family)(family));
					(family).ID = new String(passenger.ID);
					((Family)(family)).addMember(passenger);			
				}
			}
			
			/*Pasagerul apartine unui grup*/
			if((passenger.getType()).equals("group") == true) {
				PassengerType group = new Group();
				index = group.findIndex(persArray, passenger);
				
				/*Grupul nu exista deja*/
				if(index != -1)
					((Group)(persArray.get(index))).addMember(passenger);
				/*Grupul este existent*/
				else {
					persArray.add((Group)(group));
					(group).ID = new String(passenger.ID);
					((Group)(group)).addMember(passenger);			
				}			
			}
			
			/*Pasagerul este singur*/
			if((passenger.getType()).equals("single") == true) {
				PassengerType single = new Single();
				index = single.findIndex(persArray, passenger);
				
				persArray.add((Single)(single));
				single.ID = new String(passenger.ID);
				((Single)(single)).addMember(passenger);
			}
		}
			
		String command;
		/*Creere Heap*/
		Heap heap = new Heap();

		/*Citirea comenzilor*/
		while((command = bufferR.readLine()) != null) {
			String[] argument = command.split(" ", 0);
			/*Comanda insert care adauga o entitate in Heap*/
			if((argument[0]).equals("insert") == true) {
				for(int j = 0; j < persArray.size(); j++)
					if((argument[1]).equals((persArray.get(j)).ID) == true)
						heap.insert((persArray.get(j)), (persArray.get(j)).points);
			}
			
			/*Comanda list care afiseaza elementele Heap-ului */
			else if((argument[0]).equals("list") == true) 
				heap.list();
			
			/*Comanda embark care extrage maximul din Heap*/
			else if((argument[0]).equals("embark") == true) 
				heap.embark();
			
			/*Comanda delete care sterge pasagerul pers din Heap*/
			else if((argument[0]).equals("delete") == true)
				if(argument.length == 2) {
					PassengerType pers = new PassengerType();
					pers.ID = argument[1];
					heap.delete(pers);
				}
		}
		
		bufferR.close();		
	}
}
