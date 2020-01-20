/**
 * Driver class to test ALL the methods that are implemented in the ThingNode class and the ThingLinkedBag class.
 */
public class AirplaneLinkedBagDriver {

	public static void main(String[] args) {

		AirplaneLinkedBag list = new AirplaneLinkedBag();

		Airplane a1 = new Airplane("Airbus A380", 1989, 125);
		Airplane a2 = new Airplane("Chengdu J-20", 1970, 163.54);
		Airplane a3 = new Airplane("Boeing 747", 2005, 260.2);
		Airplane a4 = new Airplane("Sukhoi Su-57", 2005, 33.33);		
		Airplane a5 = new Airplane("Voyager Compos", 1980, 116.1);
		Airplane a6 = new Airplane("Dassault Rafale", 2001, 73);
		Airplane a7 = new Airplane("Zenith Pro", 2001, 73);


		//initial list size is 0		
		System.out.println("Size when the list is first created is: " + list.size() + "\n");

		System.out.println("Initial List of elements: ");
		list.add(a1);		
		list.add(a2);		
		list.add(a3);
		list.add(a4);
		list.add(a5);
		list.add(a6);
		list.add(a7);
		list.display();

		//after adding 7 airplanes, the size is 7
		System.out.println("The current size is: " + list.size() + "\n");

		//add element at a specific index
		Airplane a8 = new Airplane("Hafner AR.III", 1933, 36.8);
		list.add(3, a8);
		System.out.println("Adding element at a specific position:");	
		System.out.print("The current size is: " + list.size() + "\n");
		list.display();

		System.out.println("Element to be removed is: " + a1.getName() + " " + list.remove(a1)); //removes an element
		System.out.print("The current size is: " + list.size() + "\n");
		list.display();

		System.out.println("Removes element at poistion 4: " + list.remove(4)); //removes element at a specific index
		System.out.print("The current size is: " + list.size() + "\n");
		list.display();

		System.out.println("Count the range: " + list.countRange(a6, a5) + "\n");

		System.out.println("Grabs an element at a specific position: \n" + list.grab(3));

		System.out.println("Element at index: " + list.indexOf(a5) + " is " + a5.getName() + "\n");

		System.out.println("Set an index to an element: " + a2.getName());
		list.set(4, a2);
		list.display();

		Airplane a9 = new Airplane("Mitsubishi", 1847, 350.0);
		System.out.println("Replace an old element with a new element: " + a5.getName() +  " with new element " + a9.getName() + "\n");
		list.replace(a5, a9);

		System.out.println("Sum of all the years: " + list.totalValue() + "\n");

		AirplaneLinkedBag lessThanList = list.lessThan(a7);
		System.out.print("Elements less than: \n");
		lessThanList.display();

		AirplaneLinkedBag greaterThanList = list.greaterThan(a1);
		System.out.print("Elements greater than: \n");
		greaterThanList.display();

		System.out.println("Displaying the minimum and maximum elements:");
		System.out.println("Max: " + list.getMax());
		System.out.println("Min: " + list.getMin());	

		System.out.println("Adds an element to the end of the list: ");
		list.addLast(a1);
		System.out.println("Element added to the end of the list: " + a1.getName());
		list.display();

		System.out.println("Removes the last element in the list:");
		list.removeLast();
		list.display();


	}

}
