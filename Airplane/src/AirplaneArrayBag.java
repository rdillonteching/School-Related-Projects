/**
 * This assignment implements an ORDERED collection to manage a group of Airplanes
 * 
 * Invariant of this bag implementation:
 * 
 * 1- The number of items contained in the bag is stored 
 * in an instance variable called manyItems
 * 2- The bag entries are stored in an instance 
 * array variable called data, 
 * from position data[0] to position data[manyItems-1]
 */
public class AirplaneArrayBag extends ArraySequence {

	/**
	 * Constructor takes on input parameter that represents maximum number of elements.
	 * @param capacity - size
	 */
	public AirplaneArrayBag(int capacity) {
		super(capacity);
	}

	/**
	 * This insert method takes three input parameters and uses them to instantiate an Airplane object
	 * @param name - object name
	 * @param year - object year
	 * @param length - object length
	 */
	public void insert(String name, int year, double length) {
		Airplane airplane = new Airplane();
		airplane.setName(name);
		airplane.setYear(year);
		airplane.setLength(length);

		Airplane current = (Airplane) getCurrent();

		if (current == null) {
			addAfter(airplane);
		}else if (current.compareTo(airplane) < 0) {
			advance();
			addBefore(airplane);				
		}else if (current.compareTo(airplane) == 0) {
			advance();
			addAfter(airplane);			
		} else {
			while (current.compareTo(airplane) > 1) {
				advance();
				current = (Airplane) getCurrent();
			}
			addAfter(airplane);
			start();
		}
	}

	@Override
	/**
	 *@return This method returns a nicely formatted output string 
	 */
	public String toString() {
		String output = "";

		output += "Name \t\t\t Year \t\t Length" + "\n---------------------------------------------------\n";

		start();
		Airplane current = (Airplane) getCurrent();

		while (current != null) {
			output += current.toString();
			advance();
			current = (Airplane) getCurrent();
		}
		return output;
	}

	/**
	 * This method takes an input string and displays all objects that matches the string
	 * @param otherAirplaneName - target airplane
	 */
	public void display(String otherAirplaneName) {

		start();

		System.out.println(
				"Name \t\t\t Year \t\t Length" + "\n---------------------------------------------------\n");
		
		Airplane current = (Airplane) getCurrent();

		while (current != null) {
			if (current.getName().equalsIgnoreCase(otherAirplaneName)) {

				System.out.println(current.toString());

			}
			advance();
			current = (Airplane) getCurrent();
		}
	}

	/**
	 * This method takes as input a string and returns as output the count of objects matching the string
	 * @param otherAirplaneName - target airplane
	 */
	public void countOccurrences(String otherAirplaneName) {
		int count = 0;

		start();

		Airplane current = (Airplane) getCurrent();

		while (current != null) {
			if (current.getName().equalsIgnoreCase(otherAirplaneName)) {
				count += 1;
				System.out.println(current.toString() + "\nTotal number of " + current.getName() + " found: " + count);
			}
			advance();
			current = (Airplane) getCurrent();
		}
	}

	/**
	 * This method takes one input parameter - Airplane and returns true of false based on whether the collection contains one Aiprlane.
	 * @param otherAirplaneObject - target airplane
	 * @return True if an object matching the search key is found in the collection and if not, False
	 */
	public boolean contains(Airplane otherAirplaneObject) {
		start();

		Airplane current = (Airplane) getCurrent();

		while (current != null) {
			if (current.equals(otherAirplaneObject)) {
				return true;
			}
			advance();
			current = (Airplane) getCurrent();
		}
		return false;
	}

	/**
	 * This method calculates and returns the sum of years of all the Airplanes in the collection
	 * @return sum
	 */
	public int total() {

		int sum = 0;

		start();

		Airplane current = (Airplane) getCurrent();

		while (current != null) {
			sum += current.getYear();
			advance();
			current = (Airplane) getCurrent();
		}
		return sum;
	}

	/**
	 * This method takes as input two int values and counts how many objects in the list that have a value that lies in the given range.
	 * @param otherAirplaneYear - source airplane
	 * @param anotherAirplaneYear - target airplane
	 * @return count
	 */
	public int countRange(int otherAirplaneYear, int anotherAirplaneYear) {
		int count = 0;

		start();

		Airplane current = (Airplane) getCurrent();

		while (current != null) {
			if (current.getYear() >= otherAirplaneYear && current.getYear() <= anotherAirplaneYear) {
				count += 1;
			}
			advance();
			current = (Airplane) getCurrent();
		}
		return count;
	}

	/**
	 * This method searches the collection for the first object that equals the input object and deletes its occurrence if found
	 * @param otherAirplaneName - target airplane
	 * @return True if an object matching the search key is delete and if not, False
	 */
	public boolean delete(Airplane otherAirplaneName) {
		start();

		Airplane current = (Airplane) getCurrent();

		while (current != null) {
			if (current.getName().equalsIgnoreCase(otherAirplaneName.getName())) {
				removeCurrent();
				return true;
			}
			advance();
			current = (Airplane) getCurrent();
		}
		return false;
	}
}
