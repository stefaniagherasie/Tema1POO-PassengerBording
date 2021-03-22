package Tema1POO;
import java.io.*;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 * Clasa Heap implementeaza notiunea de MaxHeap cu elemente de tip familie,
 * grup sau singur si este folosita drept coada de prioritati pentru a adauga
 * ordonat pasagerii in avion.
 * @author StefaniaGherasie 323CB
 *
 */
public class Heap {
	
	/**
	 * Vectorul cu elemente de tip PassengerType prin intermediul caruia
	 * este reprezentat MaxHeap-ul.
	 */
	ArrayList<PassengerType> heap = new ArrayList<PassengerType>();
	int size;
	
	/**
	 * Variabila statica care contorizeaza de cate ori a fost apelata metoda list().
	 * Folosita in metoda list() pentru afisarea controlata a separatorului de linie.
	 */
	static int numList = 0;
	
	/**
	 * Variabila statica care contorizeaza cate elemente au fost afisate.
	 * Folosita in metoda listHeap() pentru afisarea controlata spatiului dintre elemente.
	 */
	static int numListHeap = 0;
	
	/**
	 * Constructor fara parametrii. Heap-ul este gol.
	 */
	Heap() {
		this.size = 0;
	}
	
	/**
	 * @param index
	 * @return Parintele indexului dat.
	 */
	public int parent(int index) {
		if(index == 0)
			return 0;
		else if(index % 2 == 0)
			return (index / 2 - 1);
		else 
			return (index / 2);
	}
	
	/**
	 * @param index
	 * @return Fiul drept al indexului.
	 */
	public int rightChild(int index) {
		return (2 * index + 2);
	}
	
	/**
	 * @param index
	 * @return Fiul stang al indexului.
	 */
	public int leftChild(int index) {
		return (2 * index + 1);
	}
	
	/**
	 * @param index
	 * @return Indexul reprezinta o frunza.
	 */
	public boolean isLeaf(int index) {
		if(index >= (size / 2) && index <= size)
			return true;
		else 
			return false;
	}
	
	/**
	 * Inverseaza 2 elemente din Heap folosind indexul lor.
	 * @param index1 
	 * @param index2
	 */
	public void swap(int index1, int index2) {
		PassengerType aux = new PassengerType();
		
		aux = heap.get(index1);
		heap.set(index1, heap.get(index2));
		heap.set(index2 , aux);
	}
	
	/**
	 * Aranjeaza Heap-ul astfel incat sa respecte regula de MaxHeap.
	 * Metoda recursiva
	 * @param index
	 */
	public void arrangeHeap(int index) {
		/*conditia de iesire din recursivitate*/
		if(isLeaf(index)) 
			return;
		
		int leftValue = 0, rightValue = 0;
		int currentValue = heap.get(index).points;
		boolean isLeft = false, isRight = false;
		
		/*testeaza daca exista fiul stang*/
		if(leftChild(index) < size) {
			isLeft = true;
			leftValue = heap.get(leftChild(index)).points;
		}
		
		/*testeaza daca exista fiul drept*/
		if(rightChild(index) < size) {
			isRight = true;
			rightValue = heap.get(rightChild(index)).points;
		}
		
		/*cazul in care ambii fii exista si sunt mai mari decat radacina*/
		if(isLeft == isRight == true && leftValue > currentValue && 
											rightValue > currentValue ) {
			/*fiul stang este cel mai mare*/
			if(leftValue >= rightValue) {
				/*interschimbarea fiului cu radacina si apelarea recursiva 
				 * pentru fiul stang*/
				swap(index, leftChild(index));
				arrangeHeap(leftChild(index));
			}
			/*fiul drept este cel mai mare*/
			else {
				/*interschimbarea fiului cu radacina si apelarea recursiva 
				 * pentru fiul drept*/
				swap(index, rightChild(index));
				arrangeHeap(rightChild(index));
			}
		}
		
		/*doar fiul stang este mai mare*/
		else if(isLeft == true && leftValue > currentValue) {
			/*interschimbarea fiului cu radacina si apelarea recursiva pentru fiul stang*/
			swap(index, leftChild(index));
			arrangeHeap(leftChild(index));
		}
		
		/*doar fiul drept este mai mare*/
		else if(isRight == true && rightValue > currentValue) {
			/*interschimbarea fiului cu radacina si apelarea recursiva pentru fiul drept*/
			swap(index, rightChild(index));
			arrangeHeap(rightChild(index));
		}
		
	}
	
	/**
	 * Insereaza in Heap elementul dat in functie de prioritate.
	 * @param element Elementul tip PassengerType de adaugat in Heap.
	 * @param priority Prioritatea elementului.
	 */
	public void insert(PassengerType element, int priority) {
		int current = heap.size();
		size++;
		
		/*adaugarea elementului in Heap.*/
		heap.add(element);
		
		/*interschimbare in functie de prioritate astfel incat 
		 * Heap-ul sa fie ordonat*/
		while(priority > heap.get(parent(current)).points) {
			swap(current, parent(current));
			current = parent(current);
			priority = heap.get(current).points;
		}
	}
	
	/**
	 * Listeaza recursiv toate elementele din Heap.
	 * <br>Listarea se face in pre-ordine(Radacina, Stanga, Dreapta).
	 * @throws IOException Eroare la scrierea in fisier.
	 */
	public void list() throws IOException {
		/*scrierea in fisierului de iesire*/
		File outputFile = new File("queue.out");
		FileWriter output = new FileWriter(outputFile, true);
		
		/*afiseaza separatorul de linie daca este cazul*/
		if(numList >= 1)
			output.write(System.lineSeparator());
		numList++;

		/*apeleaza functie care afiseaza toate elementele din Heap*/
		listHeap(0, output);
		output.close();	
	}
	
	/**
	 * Functie auxiliara pentru listarea elementelor din Heap.
	 * @param index Indexul de la care se incepe listarea
	 * @param output Fisierul de iesire.
	 * @throws IOException Eroare la scrierea in fisier.
	 */
	public void listHeap(int index, FileWriter output) throws IOException{
		/*conditia de iesire din recursivitate*/
		if(index >= size)
			return;
		
		/*listarea elementului curent si a spatiului separator daca trebuie*/
		if(numListHeap == size - 1) {
			output.write((heap.get(index)).ID);
			numListHeap = 0;
		}
		else {
			output.write((heap.get(index)).ID + " ");
			numListHeap++;
		}
		
		/*apelul recursiv pentru arborele drept si stang*/
		listHeap(leftChild(index), output);
		listHeap(rightChild(index), output);
	}
	
	/**
	 * Extrage maximul din Heap si reordoneaza arborele.
	 */
	public void embark() {
		/*se pune in locul radacinii ultima frunza din arbore*/
		heap.set(0, heap.get(heap.size() - 1));
		/*se sterge ultima frunza si se scade dimensiunea arborelui*/
		heap.remove(--size);

		/*se rearanjeaza Heap-ul*/
		arrangeHeap(0);
	}
	
	/**
	 * Sterge entitatea pers din Heap
	 * @param pers Entitatea care trebuie stearsa
	 */
	public void delete(PassengerType pers) {
		int index = -1;
		for(int i = 0; i < heap.size(); i++)
			if((heap.get(i).ID).equals(pers.ID)) {
				index = i;
				break;
			}
		heap.set(index, heap.get(heap.size() - 1));
		heap.remove(--size);
		arrangeHeap(index);
	}
	
}