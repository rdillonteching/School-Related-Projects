/**
 * This assignment implements an ORDERED collection to manage a group of Airplanes
 *
 */
public class Airplane implements Comparable<Airplane> {

	// instance variables
	private String name;
	private int year;
	private double length;
	
	//three args constructor
	/**
	 * @param name - Airplane object name
	 * @param year - Airplane object year
	 * @param length - Airplane object length
	 */
	public Airplane(String name, int year, double length) {
		this.name = name;
		this.year = year;
		this.length = length;
	}
	
	//no-args constructor
	public Airplane() {
	}

	// getters and setters
	/**
	 * @return name gets object name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name - sets object name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return year gets object year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @param year - sets object year
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * @return length gets object length
	 */
	public double getLength() {
		return length;
	}

	/**
	 * 
	 * @param length - sets object length
	 */
	public void setLength(double length) {
		this.length = length;
	}

	/**
	 * @return This method returns a nicely formatted string separated by tabs
	 */
	public String toString() {

		String output = "";
		
		output += this.name + "\t\t" + this.year + "\t\t" + this.length + "\n";
		
		return output;
	}

	/**
	 * This method considers two objects to be equal when they have the same name
	 * and year
	 * 
	 * @param airplane - takes input object of type Airplane
	 * @return True when two objects are equal and False when they are NOT
	 */
	public boolean equals(Airplane airplane) {

		return this.name.equalsIgnoreCase(airplane.name) && this.year == airplane.year;
	}

	/**
	 * Compares two Airplanes by comparing their names. Results will reflect case
	 * insensitive alphabetical ordering.
	 * 
	 * @param otherAirplane - target airplane
	 * 
	 * 				Airplane for comparison
	 * @return int
	 */
	// * -1 if this.name < otherAirplane.name 0, if this.name == otherAirplane.name, +1 if this.name > otherAirplane.name
	@Override
	public int compareTo(Airplane otherAirplane) {
		if (this.name.compareToIgnoreCase(otherAirplane.name) == 0) {
			/*
			 * if (this.year == otherAirplane.year) { if (this.length ==
			 * otherAirplane.length) { return 0; } else if (this.length >
			 * otherAirplane.length) { return 1; } else { return -1; } } else if (this.year
			 * > otherAirplane.year) { return 1; } else { return -1; }
			 * 
			 * }
			 */
		} else if (this.name.compareToIgnoreCase(otherAirplane.name) > 1) {
			return 1;
		}

		return -1;
	}
}
