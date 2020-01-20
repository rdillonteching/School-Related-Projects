/**
 * This assignment implements a Binary Search Tree. Data is stored in a recursive binary search tree data structure
 *
 */
public class Chocolate implements Comparable<Chocolate>{
	//instance variables
	private String name;
	private String category;
	private int cocoSolids;

	/**
	 * There argument constructor to initialize Chocolate object instance variables
	 * @param - name of a chocolate
	 * @param category of a chocolate
	 * @param cocoSolids - percent of cacoa solids in each chocolate
	 */
	public Chocolate(String name, String category, int cocoSolids) {
		this.name = name;
		this.category = category;
		this.cocoSolids = cocoSolids;
	}

	/**
	 * This method returns the name of a chocolate
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * The method sets the name of a chocolate
	 * @param - name of a chocolate
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This method gets the category of a chocolate
	 * @return category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * This method sets the category of a chocolate
	 * @param - category of the chocolate
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	public int getCocoSolids() {
		return cocoSolids;
	}

	public void setCocoSolids(int cocoSolids) {
		this.cocoSolids = cocoSolids;
	}

	/**
	 * Compares two types of chocolate by comparing their names. Results will reflect case
	 * insensitive alphabetical ordering.
	 * 
	 * @param - otherChocolate target chocolate Chocolate for comparison
	 * @return integer
	 */
	@Override
	public int compareTo(Chocolate otherChocolate) {
		if (this.name.compareToIgnoreCase(otherChocolate.name) == 0) {
			return 0;
		}else if (this.name.compareToIgnoreCase(otherChocolate.name) > 0) {
			return 1;
		}
		return -1;
	}


	public int deletecompareTo(Chocolate otherChocolate) {
		int cmp = this.name.toLowerCase().compareTo(otherChocolate.name.toLowerCase());
		return cmp;
	}
	/**
	 * This method considers two objects to be equal when they have the same name
	 * and category
	 * 
	 * @param - chocolate object to be compared
	 * @return True when two objects are equal and False when they are NOT
	 */
	public boolean equals(Chocolate chocolate) {

		return this.name.equalsIgnoreCase(chocolate.name) && this.cocoSolids == chocolate.cocoSolids;
	}


	/**
	 * This method returns a nicely formatted string separated by tabs
	 * @return output
	 */
	@Override
	public String toString() {
		String output = "";
		output += name + "\t\t" +   category + "\t\t"   + cocoSolids;
		return output;
	}

}
