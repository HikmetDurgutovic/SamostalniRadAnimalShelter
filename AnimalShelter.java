package ba.bitcamp.hikmet.homework.animalshelter;

/**
 * Skloniste za pse I macke radi isklucivo na "prvi dosao, prvi usvojen" principu. Osoba koja zeli da usvoju
 * zivotinju ima pravo da bira koji vrstu zivotinje hoce (psa ili macku) u tom slucaju ce dobiti zivotinju tog
 * tipa koja je prva dosla u skloniste. Ako osoba koja usvaja zivotinju ne navede koji vrstu zivotinje koju
 * hoce da usvoju dobice zivotinju koja je najduze u sklonistu. Napisite strukturu podataka koja ce pomoci
 * pri odrzavanju ovog sistema, potrebno je da implementirate metode: enqueue, dequeueAny,
 * dequeueCat, dequeueDog.
 * 
 */

public class AnimalShelter {
	
	private Animal head;
	
	/**
	 * Constructor of object DogsAndCats
	 */
	public AnimalShelter() {
		head = null;
	}
	
	/**
	 * Method that puts a new object Animal into the queue
	 * @param type = Type of animal Dog or Cat	
	 * @param name = Name of the animal
	 */
	public void enquequeAnimal(String type, String name) {
		Animal newAnimal = new Animal(type, name);
		if (head == null) {
			head = newAnimal;
			return;
		}
		Animal current = head;
		while (current.next != null) {
			current = current.next;
		}
		newAnimal.previous = current;
		current.next = newAnimal;
	}
	
	/**
	 * Method that removes object Animal which has been the most on the list from it
	 */
	public void dequequeAny() {
		if (head == null) {
			throw new NullPointerException("List is empty");
		}
		Animal current = head;
		adoption(current);
		head = head.next;
		current = null;
	}
	
	/**
	 * Method that removes an object Animal type cat which has been most on the list
	 */
	public void dequequeCat() {
		if (head == null) {
			throw new NullPointerException("List is empty");
		}
		Animal current = head;
		if (head.type.equalsIgnoreCase("cat")) {
			dequequeAny();
			return;
		}
		while (!current.type.equalsIgnoreCase("cat") || current.next == null) {
			current = current.next;
		} //Move until "cat" is found or at the end of list
		Animal back = current.previous;
		Animal front = current.next;
		//If at the end of list
		if (front == null) {
			adoption(current);
			back.next = null;
			current = null;
			return;
		} 
		front.previous = back;
		back.next = front;
		adoption(current);
		current = null;
		
	}
	
	/**
	 * Method that removes an object Animal type dog which has been the most on the list
	 */
	public void dequequeDog() {
		if (head == null) {
			throw new NullPointerException("List is empty");
		}
		Animal current = head;
		if (head.type.equalsIgnoreCase("dog")) {
			dequequeAny();
			return;
		}
		while (!current.type.equalsIgnoreCase("dog") || current.next == null) {
			current = current.next;
		} //Move until "cat" is found or at the end of list
		Animal back = current.previous;
		Animal front = current.next;
		//If at the end of list
		if (front == null) {
			adoption(current);
			back.next = null;
			current = null;
			return;
		}
		front.previous = back;
		back.next = front;
		adoption(current);
		current = null;
		
	}
	
	/**
	 * Method prints contents of object Animal into the console
	 */
	public void print() {
		Animal current = head;
		while (current != null) {
			System.out.println("Type: " + current.type + " Name: " + current.name);
			current = current.next;
		}
	}
	
	/**
	 * Method prints the name and type of object Animal
	 * @param current
	 */
	private void adoption(Animal current) {
		System.out.println("You have adopted:\n" + current.type + ": " + current.name);
	}
	
	/**
	 * Class Animal
	 *
	 */
	private class Animal {
		private String type;
		private String name;
		private Animal previous;
		private Animal next;
		
		public Animal(String type, String name) {
			this.type = type;
			this.name = name;
			this.previous = null;
			this.next = null;
		}
	}

}
