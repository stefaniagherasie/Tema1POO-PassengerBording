# Tema1POO-PassengerBording
[Tema1 Programare Orientata pe Obiecte (2019-2020, seria CB)] 


Tema urmareste implementarea unei cozi de prioritate folosind structura de arbore
binar MaxHeap pentru a simula imbarcarea ordonata a unor pasageri intr-un avion in
functie de punctele pe care le obtin acestia in urma incadrarii lor in familii, grupuri sau 
persoane singure si in functie de niste specificatii pe care le au precum varsta, 
tipul de bilet detinut, daca detin imbarcare prioritara sau daca au nevoi speciale.



#### IMPLEMENTARE
Clasa ```Passenger``` reprezinta tipul pasager si atributele corespunzatoare. 

Clasa ```PassengerType``` este clasa de baza pentru tipurile ```Family```, ```Group``` si ```Single``` si 
reprezinta notiunea de entitate. Aceasta clasa retine un vector de tip ```Passenger``` in care 
sunt salvati pasagerii care apartin entitatii. Clasa implementeaza metode care adauga puncte
la scorul familiei/grupului/persoanei singure in functie de specificatiile fiecarui pasager.
Metoda ```findIndex``` este creata pentru a gasi indexul unde se afla pasagerul dat ca parametru 
in vectorul de pasageri ai entitatii.

Clasele ```Family```, ```Group``` si ```Single``` mostenesc clasa ```PassengerType``` si implemeteaza fiecare metode
prin care se adauga punctele aferente de familie/grup/persoana singura si adauga membrii la 
fiecare apel.

Clasa ```Heap``` implementeaza structura de coada de prioritate folosindu-se de MaxHeap. Heap are
un vector in care se adauga ordonat dupa regula de MaxHeap membrii(entitati).
- ```swap``` inverseaza 
doua elemente din arbore in functie de indexul lor. 
- ```arrangeHeap``` reordoneaza arborele astfel
incat sa se respecte regula de MaxHeap. 
- ```insert``` insereaza un element in Heap, initial 
pe ultima pozitie, in functie de prioritate interschimbandu-se valorile pana cand arborele 
este ordonat corect. 
- ```list``` este folosita pentru afisarea elementelor din heap la momentul 
respectiv si utilizeaza auxiliarul ```listHeap``` care listeaza recursiv fiecare element. Listarea
se face in preordine(Radacina-Stanga-Dreapta).
- ```embark``` extrage din arbore maximul,adica
elementul aflat pe prima pozitia in Heap. In locul lui se pune ultima frunza si se rearanjeaza
arborele.

In clasa ```Main``` se obtine numarul de pasageri
si apoi detaliile fiecarui pasager. Se testeaza
apoi carui tip de entitate apartine fiecare pasager si se adauga in vectorul de entitati 
corespunzator cu tipul. Daca familia/grupul nu este creat pana la acel moment, acesta se creaza cu
pasagerul curent pe prima pozitie, in caz contrar se adauga in continuarea vectorului aferentent
entitatii. <br>
Dupa structurarea pasagerilor, se creeaza un arbore ```Heap``` in care se intereaza entitatile in functie de prioritate. 
Conform comenzilor primite, se afiseaza prin list() elementele arborelui si se extrage prin
embark() maximul din coada.
