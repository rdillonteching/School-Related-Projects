import java.text.DecimalFormat;

/**
 * This assignment uses inheritance and polymorphism to implement a Java shopping application.
 *
 */
public abstract class SalesItem {

	//instance variables
	private int code;
	private int quantity;
	private double price;
	
	/**
	 * Constructor initializes the three instance variables.
	 * @param - code unique item identifier
	 * @param - quantity count of each
	 * @param - price cost per item
	 */
	public SalesItem(int code, int quantity, double price) {
		this.code = code;
		this.quantity = quantity;
		this.price = price;
	}

	//getters and setters
	/**
	 * This method returns an item's code
	 * @return code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * This method sets an item's code
	 * @param - code
	 */
	public void setCode(int code) {
		this.code = code;
	}

	/**
	 * This method returns an item's quantity
	 * @return quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * This method sets an item's quantity
	 * @param - quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * This method returns an item's price
	 * @return price
	 */
	public double getPrice() {
		DecimalFormat dc = dcFormat();
		dc.format(price);
		return price;
	}

	/**
	 * This method set's an item's price
	 * @param - price
	 */
	public void setPrice(double price) {
		DecimalFormat dc = dcFormat();
		dc.format(price);
		this.price = price;
	}
	
	/**
	 * This method returns the total cost of an item
	 * @return price * quantity
	 */
	public double itemTotalCost() { //add decimal format here
		return price * quantity;	
	}
	
	/**
	 * This method is an abstract method that is used to apply a monthly discount
	 * to an item where the discount is dependent on the type of the item
	 */
	public abstract void monthlyPromo();
	
	/**
	 * This method displays the Sale items specific instance variables 
	 * in a nicely formatted String
	 */
	@Override
	public String toString() {
		DecimalFormat dc = dcFormat();
		return String.format("%1s", code) + "\t" 
				+ String.format("%10s", dc.format(price)) + "\t"
				+ String.format("%1s", quantity);
	}
		
	/**
	 * Method formats price
	 * @return dc
	 */
	private DecimalFormat dcFormat() {
		String pattern = "$###,##0.00";
		DecimalFormat dc = new DecimalFormat(pattern);
		return dc;
	}
}
