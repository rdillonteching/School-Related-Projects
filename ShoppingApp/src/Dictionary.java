/**
 * This class is a subclass of Book 
 *
 */
public class Dictionary extends Book {

	//instance variables
	private String language;
	private int numDefinitions;

	//Constructor initializes all the dictionary's instance variables
	/**
	 * Constructor
	 * @param - language the language which the dictionary is translated to
	 * @param - numDefinitions the number of definitions in the dictionary
	 * @param - author of a book
	 * @param - numPages the number of pages in a book 
	 * @param - code that identifies a book
	 * @param - quantity of book
	 * @param - price how much a book cost
	 */
	public Dictionary(String language, int numDefinitions, String author, int numPages, 
			int code, int quantity, double price) {
		super(author, numPages, code, quantity, price);
		this.language = language;
		this.numDefinitions = numDefinitions;
	}

	/**
	 * This method returns the dictionary language
	 * @return language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * This method sets the dictionary language
	 * @param - language dictionary language
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * This method gets the number of definition in a dictionary
	 * @return numDefinitions
	 */
	public int getNumDefinitions() {
		return numDefinitions;
	}

	/**
	 * This method sets number of definition in a dictionary
	 * @param - numDefinitions number of definitions in the dictionary
	 */
	public void setNumDefinitions(int numDefinitions) {
		this.numDefinitions = numDefinitions;
	}

	/**
	 * This method returns the ratio of number of definitions per page
	 * @return ratio
	 */
	public double getRatio() {
		return numDefinitions/getNumPages();
	}

	/**
	 * This method adds the Dictionary's specific instance variables to the output string
	 * and displays the properties of Dictionary in a nicely formatted String
	 */
	@Override
	public String toString() {
		return super.toString() + String.format("%17s", language) + "\t"
				+ String.format("%11s", numDefinitions);
	}
}
