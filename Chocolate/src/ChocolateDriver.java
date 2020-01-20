/**
 * This driver class tests the Chocolate, Node and Tree classes.
 *
 */
public class ChocolateDriver {

	public static void main(String[] args) {

		//chocolate
		Chocolate c1 = new Chocolate("HersheyBar", "Milk Chocolate", 25);
		Chocolate c2 = new Chocolate("Toblerone", "Dark Chocolate", 15);
		Chocolate c3 = new Chocolate("KitKat", "White Chocolate", 47);
		Chocolate c4 = new Chocolate("Bounty", "Milk Chocolate", 14);
		Chocolate c5 = new Chocolate("Crunchie", "Milk Chocolate", 12);
		Chocolate c6 = new Chocolate("Aero", "Milk Chocolate", 10);
		Chocolate c7 = new Chocolate("La Fama", "Milk Chocolate", 8);
		Chocolate c8 = new Chocolate("Vosges Haut", "Milk Chocolate", 3);
		Chocolate c9 = new Chocolate("Ghirardelli", "Dark Chocolate", 15);
		Chocolate c10 = new Chocolate("Nestlé", "White Chocolate", 11);
		Chocolate c11 = new Chocolate("Milka", "Milk Chocolate", 30);
		Chocolate c12 = new Chocolate("Green-Black", "Milk Chocolate", 1);
		Chocolate c13 = new Chocolate("Godiva", "White Chocolate", 10);
		Chocolate c14 = new Chocolate("Theo", "Milk Chocolate", 8);
		Chocolate c15 = new Chocolate("Mars", "Dark Chocolate", 62);
		Chocolate c16 = new Chocolate("Patchi", "White Chocolate", 21);
		Chocolate c17 = new Chocolate("Guylian", "Milk Chocolate", 14);
		Chocolate c18 = new Chocolate("Cadbury", "Dark Chocolate", 12);
		Chocolate c19 = new Chocolate("Lindt-Sprüngli", "Dark Chocolate", 5);
		Chocolate c20 = new Chocolate("Ferrero", "White Chocolate", 8);

		//Chocolate object not added to the tree to test search 
		Chocolate c21 = new Chocolate("Taza", "White Chocolate", 8);


		//declare and instantiate a Binary Search Tree		
		ChocolateBSTree myChocolateBSTree = new ChocolateBSTree();

		//adds chocolate nodes to the tree
		myChocolateBSTree.add(c1);
		myChocolateBSTree.add(c2);
		myChocolateBSTree.add(c3);
		myChocolateBSTree.add(c4);
		myChocolateBSTree.add(c5);
		myChocolateBSTree.add(c6);
		myChocolateBSTree.add(c7);
		myChocolateBSTree.add(c8);
		myChocolateBSTree.add(c9);
		myChocolateBSTree.add(c10);
		myChocolateBSTree.add(c11);
		myChocolateBSTree.add(c12);
		myChocolateBSTree.add(c13);
		myChocolateBSTree.add(c14);
		myChocolateBSTree.add(c15);
		myChocolateBSTree.add(c16);
		myChocolateBSTree.add(c17);
		myChocolateBSTree.add(c18);
		myChocolateBSTree.add(c19);
		myChocolateBSTree.add(c20);

		System.out.println("Size of tree before deletion: "+ myChocolateBSTree.count() +"\n");

		System.out.println("****Original tree order starts****");
		myChocolateBSTree.display();
		System.out.println("****Original tree order ends****\n");

		System.out.println("Inorder: ");
		myChocolateBSTree.inorder(); //LNR

		System.out.println("\nPreorder: ");
		myChocolateBSTree.preorder(); //NLR

		System.out.println("\nPostorder: ");
		myChocolateBSTree.postorder(); //LRN	
		
		System.out.println("\nNode deleted: " + c7.toString());
		myChocolateBSTree.delete(c7);
		System.out.println("Size of tree after deletion: "+ myChocolateBSTree.count());

		System.out.println("\n****Tree order after deletion starts****");
		myChocolateBSTree.display();
		System.out.println("****Tree order after deletion ends****\n");

		System.out.println("Is the " + c21.toString() + " in the tree? " + myChocolateBSTree.search(c21));
		System.out.println("The tree contains " + myChocolateBSTree.search(c1));

		System.out.println("Depth of the tree " + myChocolateBSTree.depth());
	}
}
