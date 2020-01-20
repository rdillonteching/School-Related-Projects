/**
 * The class test the Invoice and Item classes.
 *
 */
public class InvoiceDriver {

	public static void main(String[] args) {
		//instantiating objects of type invoice
		Invoice invoice1 = new Invoice("John");
		Invoice invoice2 = new Invoice("Rose");
		
		//add 3 items to invoice1
		invoice1.addItem("Bread", 15.99, 1.0); //index 0
		invoice1.addItem("Milk", 24.0, 4.1); //index 1
		invoice1.addItem("Eggs", 5.60, 2.40); //index 2

		//apply discounts to items1 and item2
		invoice1.applyDiscount(0, 10); //item1 at index 0
		invoice1.applyDiscount(1, 20); //item2 at index 1
		
		//adjust the price of item3 by increasing the price by $2
		invoice1.adjustPrice(2, 2); //item3 at index 2
		
		//add 2 items to invoice2
		invoice2.addItem("Butter", 9.99, 1.0); //index 0
		invoice2.addItem("Jam", 10.0, 4.1); //index 1
		
		//apply discounts to item1 and item2
		invoice2.applyDiscount(0, 10); //item1 at index 0
		invoice2.applyDiscount(1, 20); //item2 at index 1
		
		//adjust the price of item1 by decreasing the price by $3
		invoice2.adjustPrice(0, -3);


		//invoke toString() method on invoices to print the contents 
		System.out.println(invoice1.toString());
		System.out.println(invoice2.toString());
		
		System.out.println("Additonal tests of other aspects of the program");
		//instantiate an object of type invoice
		Invoice invoice3 = new Invoice("David");
		invoice3.addItem("Hat", 3.50, 1.0);
		invoice3.addItem("Shirt", 8.25, 2.5);
		invoice3.addItem("Pants", 11.82, 3.0);
		invoice3.addItem("Skirt", 24.91, 1.75);
		invoice3.addItem("Bag", 60.66, 4.20);
		invoice3.addItem("Soap", 1.50, 1.0);
		
		//apply a discount to item5
		invoice3.applyDiscount(4, 5);
		
		//adjust prices for item4 and item5
		invoice3.adjustPrice(3, -4.91); //index 3
		invoice3.adjustPrice(4, 3.00); //index 4
		
		System.out.println(invoice3.toString());
		
		//creates an item to test the methods in the Item class
		Item item1 = new Item("Water", 8, 1.25);
		item1.setPrice(2.0);
		item1.setCurrentDiscount(5);
		double discountedPrice = item1.priceAfterDiscount();
		System.out.println(item1.getName() + " cost after " + item1.getCurrentDiscount() + "% discount:\t$" + String.format("%.2f", discountedPrice) + "\n");
		//System.out.format("double : %.2f", discountedPrice);
				
		//creates an item to test the methods in the Item class
		Item item2 = new Item("Book", .05, 12.99);
		item2.setName("Pencil");
		item2.setWeight(0.1);
		item2.setPrice(1.0);
		item2.adjustPrice(0.89);
		System.out.println(item2.toString());
		
		System.out.println("Is " + item1.getName() + " the same as a " + item2.getName() + "? " + item1.equals(item2) + ".");
		
	}
}
