import java.text.DecimalFormat;
/**
 * This assignment uses the OOP concept of object composition (i.e., has a relationship between objects).
 * The Invoice class contains Items.
 * The item class represents an item that is being sold in a retail store (e.g., book or pencil).
 *
 */
public class Item {

	// instance variables
	private String name;
	private double weight;
	private double price;
	private int currentDiscount;

	// constructor to initialize all instance variables
	/**
	 * 
	 * @param name - item's name
	 * @param weight - item's weight
	 * @param price - item's price
	 */
	public Item(String name, double weight, double price) {
		
		this.name = name;
		this.weight = weight;
		this.price = price;
		currentDiscount = 0;
	}

	// Getters and Setters
	/**
	 * 
	 * @return name
	 */
	public String getName() {
		
		return name;
	}

	/**
	 * 
	 * @param name sets the item's name
	 */
	public void setName(String name) {
		
		this.name = name;
	}

	/**
	 * 
	 * @return weight
	 */
	public double getWeight() {
		
		return weight;
	}

	/**
	 * 
	 * @param weight sets the item's weight
	 */
	public void setWeight(double weight) {
		
		this.weight = weight;
	}

	/**
	 * 
	 * @return price
	 */
	public double getPrice() {
		
		return price;
	}

	/**
	 * 
	 * @param price sets the item's price
	 */
	public void setPrice(double price) {
		
		this.price = price;
	}

	/**
	 * 
	 * @return currentDiscount
	 */
	public int getCurrentDiscount() {
		
		return currentDiscount;

	}

	/**
	 * 
	 * @param itemDiscount sets the item's discount
	 */
	public void setCurrentDiscount(int itemDiscount) {
		
		this.currentDiscount = itemDiscount;
	}

	/**
	 * Method takes an amount and add that amount to the item's price. The amount
	 * can be positive or negative as an item's price may be increased or decreased.
	 * 
	 * @param amount adds amount of money to the item's price
	 * @return amount
	 */
	public double adjustPrice(double amount) {
		
		return this.price += amount;
	}

	/**
	 * Method that calculates and returns the discounted item's price after applying
	 * the current discount.
	 * @return discountedPrice
	 */
	public double priceAfterDiscount() {
		
		double discountRate = this.price * currentDiscount / 100;
		double discountedPrice = this.price - discountRate;
		return discountedPrice;
	}

	/**
	 * 
	 * @param item item being compared
	 * @return True if the points have the same name and and same weight False if
	 *         either the name or the weight differs or if both differ
	 */
	public boolean equals(Item item) {
		
		return this.name.equals(item.name) && this.weight == item.weight;
	}

	/**
	 * @return nicely formatted string description of the item
	 */
	@Override
	public String toString() {
		
		DecimalFormat dc = dcFormat();
		
		return name + "\t\t" + 
				weight + "oz\t\t$" + 
				dc.format(price) + "\t\n";
	}

	/**
	 * Method formats price
	 * @return dc
	 */
	public DecimalFormat dcFormat() {
		String pattern = "###,###.00";
		DecimalFormat dc = new DecimalFormat(pattern);
		return dc;
	}
}
