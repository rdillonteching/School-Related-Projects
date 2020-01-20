/**
 * This is a subclass of the SalesItem class
 */
public class Book extends SalesItem {

	//instant variables
	private String author;
	private int numPages;
	private final double MONTHLYPROMO = 0.03;

	//Constructor takes five inputs parameters to initialize all the instance variables
	/**
	 * Constructor
	 * @param -- author author's name
	 * @param -- numPages number of pages in a book
	 * @param -- code identification code
	 * @param -- quantity number of book items
	 * @param -- price the price of a book
	 */
	public Book(String author, int numPages, int code, int quantity, double price) {
		super(code, quantity, price);
		this.author = author;
		this.numPages = numPages;
	}

	//getters and setters
	/**
	 * This method returns an author
	 * @return author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * This method sets the author
	 * @param - author the author of a book
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * This method returns the number of pages in a book
	 * @return numPages
	 */
	public int getNumPages() {
		return numPages;
	}

	/**
	 * This method set the number of pages in a book
	 * @param - numPages total pages in a book
	 */
	public void setNumPages(int numPages) {
		this.numPages = numPages;
	}

	/**
	 * This method applies a 3% price reduction for a book 
	 */
	@Override
	public void monthlyPromo() {
		setPrice(getPrice() - (getPrice() * MONTHLYPROMO));
	}


	public double getMONTHLYPROMO() {
		return MONTHLYPROMO;
	}
	/**
	 * This method adds the book's specific instance variables to the output string
	 * and displays the properties of Book into a nicely formatted String
	 */
	@Override
	public String toString() {
		return super.toString() + String.format("%22s", author) + "\t"
				+ String.format("%14s", numPages);
	}
}
