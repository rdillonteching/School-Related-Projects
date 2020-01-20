import java.text.DecimalFormat;
/**
 * This driver class tests the ShoppingApplication.
 *
 */
public class ShoppingDriver {
	public static void main(String[] args) {
		//format prices 
		DecimalFormat dc = new DecimalFormat("$###,##0.00");

		//instantiates a new cart with a capacity of 5
		Cart cart = new Cart(5);

		Book b1 = new Book("Brené Brown", 320, 1, 10, 20.00);

		Dictionary dic1 = new Dictionary("English", 300, "Oxford", 1664, 2, 4, 12.13);
		Dictionary dic2 = new Dictionary("Spanish", 300, "Webster", 2060, 2, 7, 1.00);

		AudioCD cd1 = new AudioCD("Live at Legends", 2, 3, 8, 6.99);
		AudioCD cd2 = new AudioCD("Christmas Album", 4, 3, 1, 10.63);

		//add items to cart
		cart.addItem(b1);
		cart.addItem(dic1);
		cart.addItem(dic2);
		cart.addItem(cd2);
		cart.addItem(cd1);

		//Display all the items in the cart
		System.out.println(cart.toString());

		//display item at the specific index
		System.out.println("Item at a specific index: ");
		System.out.println(cart.getAtIndex(3) + "\n");

		//Total Cost of the cart before discount
		System.out.println("Total Before Discounts: ");
		System.out.println("Subtotal: " + dc.format(cart.cartTotalCost()));
		System.out.println("-------------------------------\n");

		//Monthly discount on individual items
		double cartTotal = cart.cartTotalCost();
		double itemDiscountAfterPromo = 0;
		double monthlyPromoDiscount = 0;
		System.out.println("Monthly Promo per item");
		System.out.println("Code\t" + "Current Price \t" + "Promo applied \t" + "Quantity");
		for (int i = 0; i < cart.getCurrentNumItem(); i++) {
			System.out.print(cart.getItemList()[i].getCode() 
					+ "\t" + dc.format(cart.getItemList()[i].getPrice()) + "\t\t");
			cart.getItemList()[i].monthlyPromo();
			
			System.out.println(dc.format(cart.getItemList()[i].getPrice()) 
					+ "\t\t" + cart.getItemList()[i].getQuantity());
			
			itemDiscountAfterPromo += cart.getItemList()[i].getPrice() * cart.getItemList()[i].getQuantity();
		}
		monthlyPromoDiscount = cartTotal - itemDiscountAfterPromo;
		System.out.println("Total After Monthly Discounts: ");
		System.out.println("Promo Discount Amount: " + dc.format(monthlyPromoDiscount));
		System.out.println("Promo Subtotal: " + dc.format(cart.cartTotalCost()));
		System.out.println("-------------------------------\n");

		//Bulk discount applied to quantity of books 10 or more
		System.out.println("Total After Bulk Discount on Books: ");
		ItemDiscount idBooks = new ItemDiscount(15, 10);
		double bulkDiscountOnBooks =  idBooks.calculateDiscount(b1);
		System.out.println("Bulk Discount Amount: " + dc.format(bulkDiscountOnBooks));
		System.out.println("Bulk Subtotal: " + dc.format(cartTotal - bulkDiscountOnBooks ) + "\n");

		//Total Cost of the cart before discount
		System.out.println("Total After All Discounts: ");
		System.out.println("Subtotal: " + dc.format(cartTotal -(monthlyPromoDiscount + bulkDiscountOnBooks)));
		System.out.println("-------------------------------\n");

		//count the different types of item in the cart
		System.out.println("Item count\n" + "----------------");
		System.out.println("Dictionary: " + cart.countType(2));
		System.out.println("Book: " + cart.countType(1));
		System.out.println("AudioCD: " + cart.countType(3));
	}
}