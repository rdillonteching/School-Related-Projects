import java.text.DecimalFormat;

/**
 * This is a collection class of SalesItems
 * 
 *  Invariant of this Cart implementation:
 * 
 * 1- The number of items contained in the cart is stored 
 * in an instance variable called currentNumItem
 * 2- The cart entries are stored in an instance 
 * array variable called itemList,
 * from position data[0] to position data[currentNumItem-1]
 *
 */
public class Cart {

	//price formatter
	DecimalFormat df = new DecimalFormat("$###,##0.00");

	//instance variables
	SalesItem[] itemList;	
	private int currentNumItem;
	private final int BOOKTYPE = 1;
	private final int DICTIONARYTYPE = 2;
	private final int AUDIOCDTYPE = 3;

	/**
	 * This method returns a list of sale items
	 * @return itemList
	 */
	public SalesItem[] getItemList() {
		return itemList;
	}

	/**
	 * This method assigns a list of sales items
	 * @param - itemList items for sale
	 */
	public void setItemList(SalesItem[] itemList) {
		this.itemList = itemList;
	}

	/**
	 * This method returns the count of elements in the array
	 * @return currentNumItem
	 */
	public int getCurrentNumItem() {
		return currentNumItem;
	}
	
	/**
	 * This constructor set the maximum size of a cart
	 * @param - maxNumCartItems
	 */
	public Cart(int maxNumCartItems) {
		itemList = new SalesItem[maxNumCartItems];
		this.currentNumItem = 0;
	}

	/**
	 * This method adds sale items to a cart
	 * @param - item
	 */
	public void addItem(SalesItem item) {
		if (!(item instanceof SalesItem)) {
			System.out.println("Item type is not SalesItem!");
		}else {
			itemList[currentNumItem] = item;
			currentNumItem++;
		}
	}

	/**
	 * This method calculates the total cost of sale items in a cart
	 * @return cartTotal
	 */
	public double cartTotalCost() {
		double cartTotal = 0;
		if (currentNumItem == 0) {
			System.out.println("Cart is empty!");
		}else {
			for (int i = 0; i < itemList.length; i++) {
				cartTotal += itemList[i].getPrice() * itemList[i].getQuantity();
			}
		}
		return cartTotal;
	}

	public SalesItem getAtIndex(int item) {
		if (currentNumItem == 0) {
			System.out.println("Cart is empty!");
		}else if (item > currentNumItem) {
			System.out.println("Item doesn't exist!");
		}else {
			for (int i = 0; i < currentNumItem; i++) {
				if (item == i) {
					return itemList[i];
				}
			}
		}
		return null;
	}

	/**
	 * This method counts the total quantity of each item in the cart
	 * @param - countItemType
	 * @return counter
	 */
	public int countType(int countItemType) {
		int counter = 0;
		if (currentNumItem == 0) {
			System.out.println("Cart is empty!");
			return counter;
		}else {
			if (countItemType == BOOKTYPE) {
				for (int i = 0; i < currentNumItem; i++) {
					if (itemList[i].getClass().getName().equals("Book")) {
						counter++;
					}
				}
				return counter;
			}else if (countItemType == DICTIONARYTYPE) {
				for (int i = 0; i < currentNumItem; i++) {
					if (itemList[i].getClass().getName().equals("Dictionary")) {
						counter++;
					}
				}
				return counter;
			}else if (countItemType == AUDIOCDTYPE) {
				for (int i = 0; i < currentNumItem; i++) {
					if (itemList[i].getClass().getName().equals("AudioCD")) {
						counter++;
					}
				}
				return counter;
			}
		}
		return counter;
	}

	/**
	 * This method displays the properties of the items in a 
	 * in a nicely formatted String
	 */
	@Override
	public String toString() {
		System.out.println("***** Shopping Cart Details ******");
		String output = "";	
		if(currentNumItem == 0){
			System.out.println("Cart is empty!");
		}else {
			if (Cart.this.BOOKTYPE == 1 && countType(1) > 0) {
				output += "Book Description\n";
				output += "----------------\n";
				output += String.format("%1s",  "Code") + "\t"
						+ String.format("%11s",  "Price ") + "\t"
						+ String.format("%8s",  "Quantity") + "\t"
						+ String.format("%6s", "Author") + "\t\t"
						+ String.format("%9s", "Pages" + "\n");
				for(int i = 0; i < currentNumItem; i++)
					if(itemList[i].getCode() == 1) {
						output += itemList[i] + "\n";
					}
			}if (Cart.this.AUDIOCDTYPE == 3 && countType(3) > 0) {
				output += "\nAudioCD Description\n";
				output += "----------------\n";
				output += String.format(String.format("%1s",  "Code") + "\t"
						+ String.format("%11s",  "Price ") + "\t"
						+ String.format("%8s",  "Quantity") + "\t"
						+ String.format("%6s", "Label") + "\t\t"
						+ String.format("%15s", " Play Time" + "\n"));
				for(int i = 0; i < currentNumItem; i++)
					if(itemList[i].getCode() == 3) {
						output += itemList[i] + "\n";
					}
			} if (Cart.this.DICTIONARYTYPE == 2 && countType(2) > 0) {
				output += "\nDictionary Description\n";
				output += "----------------\n";
				output += String.format("%1s",  "Code") + "\t"
						+ String.format("%11s",  "Price ") + "\t"
						+ String.format("%8s",  "Quantity") + "\t"
						+ String.format("%6s", "Author") + "\t\t"
						+ String.format("%9s", "   Pages" + "\t"
								+ String.format("%8s", "Language") + "\t"
								+ String.format("%8s", "Definitions") + "\n");
				for(int i = 0; i < currentNumItem; i++)
					if(itemList[i].getCode() == 2) {
						output += itemList[i] + "\n";
					}
			}
		}
		return output;
	}
}

