import java.text.DecimalFormat;

/**
 * This invoice class represents an invoice or a receipt.
 *
 */
public class Invoice {

	// instance variables
	private String customer;
	private Item[] items;
	private int numItems;

	// constructor
	/**
	 * Constructor takes as input cutomer's name and creates an invoice by recording
	 * cutomer's name and instantiate an array of items.
	 * 
	 * @param customer - name of customer
	 */
	public Invoice(String customer) {
		
		this.customer = customer;
		items = new Item[5]; // followed the example from the Shape class
		numItems = 0;
	}

	/**
	 * Method calculates and returns the total cost of the invoice which is the sum of all the items in the invoice.
	 * @return totalCost 
	 *
	 */
	public double getTotal() {
		
		double totalCost = 0;

		for (int numItems = 0; numItems < items.length; numItems++) {
			if (items[numItems] == null) {
				totalCost += 0;
			} else {
				Item anItem = items[numItems];
				totalCost += anItem.getPrice();
			}
		}
		return totalCost;
	}

	/**
	 * Method calculates and returns the discounted total which is the sum of prices after applying the discount.
	 * @return discountedTotal 
	 */
	public double getDiscountedTotal() {
		
		double discountedTotal = 0;

		for (int numItems = 0; numItems < items.length; numItems++) {
			if (items[numItems] != null) {
				discountedTotal += items[numItems].priceAfterDiscount();
			}
		}
		return discountedTotal;
	}

	/**
	 * Method calculates and returns the total weight of all items in the invoice.
	 * @return totalWeight 
	 */
	public double getTotalWeight() {
		
		double totalWeight = 0;
		
		for (int numItems = 0; numItems < items.length; numItems++) {
			if (items[numItems] != null) {
				totalWeight += items[numItems].getWeight();
			}
		}
		return totalWeight;
	}

	/**
	 * Method takes three inputs 
	 * @param name - item's name
	 * @param price - item's price 
	 * @param weight - item's weight
	 * and creates an object of type Item. The method adds the object to the next
	 * available items array location. And displays an error message if an item
	 * cannot be added if the invoice already has five items.
	 */
	public void addItem(String name, double price, double weight) {
		
		Item item = new Item(name, weight, price);
		
		if (numItems < items.length) {
			items[numItems++] = item;
		} else {
			System.err.println("Error! The maximum of " + numItems + " items for " + customer + " 's invoice has been reached.");
		}
	}

	/**
	 * Method takes two inputs 
	 * @param itemNum item index between 0 and 4
	 * @param priceAdjustment adjusts the price of the given item number
	 * and adjust the price of the given item. It displays an error message if the input itemNum is invalid.
	 */

	public void adjustPrice(int itemNum, double priceAdjustment) {
		
		double adjustedPrice = 0;
		
		if (itemNum >= 0 && itemNum <= 4) {
			if (items[itemNum] != null) {
				Item item = items[itemNum];
				adjustedPrice = item.getPrice() + priceAdjustment;
				item.setPrice(adjustedPrice);
			}
		} else {
			System.err.println("Error! This item doesn't exist.");
		}
	}

	/**
	 * Method sets the currentDiscount of one of the invoice's items. It takes two inputs, 
	 * @param itemNum - item index between 0 and 4
	 * @param discount - set's the specified item's discount
	 * It then sets the specified item's discount to the input 'discount' value. 
	 * And displays an error message if the input itemNum is invalid.
	 */
	public void applyDiscount(int itemNum, int discount) {
		
		if (itemNum >= 0 && itemNum <= 4) {
			if (items[itemNum] != null) {
				Item item = items[itemNum];
				item.setCurrentDiscount(discount);
			}
		} else {
			System.err.println("Error! This item doesn't exist.");
		}
	}

	/**
	 * Method is a static method, which calculates the amount of sales tax to be
	 * paid. It takes two inputs 
	 * @param cost - total cost to be taxed
	 * @param taxRate - current tax rate
	 * and calculates and the amount of tax to be paid.
	 * @return tax
	 */
	public static double calculateTax(double cost, double taxRate) {
		
		double tax = (cost * taxRate) / 100;
		return tax;
	}

	/**
	 * Method that returns a string representation of the invoice that includes:
	 * customer's name, details of the invoice's items, total weight of all items in
	 * the invoice, the amount of tax to be paid, the overall cost
	 */
	@Override
	public String toString() {
		
		DecimalFormat dc = dcFormat();

		String output = "";
		output += "*********Invoice**********" + "\n" + 
				"Cutomer's Name: " + this.customer + "\n"
				+ "Name: \t\t Weight: \t Price: \n";

		//details of invoice's items
		for (int numItems = 0; numItems < items.length; numItems++) {
			if (items[numItems] != null) {
				Item anItem = items[numItems];
				output += "" + anItem;
			}
		}
		output += "\n";
		double totalSavings = getTotal() - getDiscountedTotal(); 
		double taxes = calculateTax(getDiscountedTotal(), 4.5);
		double finalTotal = getDiscountedTotal() + taxes;
		output += "Weight: \t" + getTotalWeight() + "oz\n"; //total weight
		output += "Subtotal: \t\t\t$" + dc.format(getTotal()) + "\n"; //invoice total before discount
		output += "Total after discount: \t\t$" + dc.format(getDiscountedTotal()) + "\n"; //invoice total after discount
		output += "You saved: \t\t\t$" + dc.format(totalSavings) + "\n"; //totaled saved
		output += "Taxes: \t\t\t\t$" + dc.format(taxes) + "\n"; //taxes based on discounted total
		output += "Total: \t\t\t\t$" + dc.format(finalTotal) + "\n"; //overall cost which is equal to discounted total + tax

		output += "\n";

		return output;
	}

	/**
	 * Method formats price
	 * @return dc
	 */
	private DecimalFormat dcFormat() {
		String pattern = "###,###.00";
		DecimalFormat dc = new DecimalFormat(pattern);
		return dc;
	}
}
