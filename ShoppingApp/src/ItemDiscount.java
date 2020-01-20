/**
 * This class performs discount calculation for selected items.
 *
 */
public class ItemDiscount {

	/*
	 * Instance variables
	 * discount - represents the discount percent. For example, discount of 10 means 10% discount. 
	 * qualifiedQuanity - represents the required quantity in order for the item to be qualified for discount. 
	 */
	private int discount;
	private int qualifiedQuantity;

	/**
	 * A constructor to initialize the two instance variables 
	 * @param -- discount
	 * @param -- qualifiedQuantity
	 */
	public ItemDiscount(int discount, int qualifiedQuantity) {
		this.discount = discount;
		this.qualifiedQuantity = qualifiedQuantity;
	}

	public double calculateDiscount(SalesItem salesItem) {
		//quantity of items or more == to qualifying item
		if (salesItem.getQuantity() >= qualifiedQuantity) {
			return salesItem.getPrice() * salesItem.getQuantity() * (discount/100.0); 
		}else {
			return 0.0;
		}
	}
}
