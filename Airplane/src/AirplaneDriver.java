/**
 * This is the driver class use to test the other classes
 *
 */
public class AirplaneDriver {

	public static void main(String[] args) {
		
		//declare, instantiate and initialize an Array object
		AirplaneArrayBag airplaneArrayBag = new AirplaneArrayBag(10);
		
		//invoke insert method
		airplaneArrayBag.insert("Airbus A380-800", 1989, 125);
		airplaneArrayBag.insert("Boeing 747-8i", 2005, 260.2);
		airplaneArrayBag.insert("Sukhoi Su-57", 2005, 33.33);
		airplaneArrayBag.insert("Dassault Rafale", 2001, 73);
		airplaneArrayBag.insert("Chengdu J-20", 1970, 163.54);
	
		//Total objects in the collection
		System.out.println("Number of objects in the collection: " + airplaneArrayBag.size() + "\n");
		
		//prints the objects in the collection
		System.out.println(airplaneArrayBag.toString());
		
		//prints list of objects based on a search key
		System.out.println("Displaying a list of objects based on a search key: ");
		airplaneArrayBag.display("Sukhoi Su-57");
		
		//counts the number of objects based on a search key
		System.out.println("Displaying a list of objects based on a search key: ");
		airplaneArrayBag.countOccurrences("Boeing 747-8i");
		System.out.println();
		
		//declare and instantiate an object of type Airplane
		Airplane a1 = new Airplane("Airbus A380-800", 1989, 125);
		//prints true or false if an element exists in the collection or NOT
		System.out.println("Object exists in the array? " + airplaneArrayBag.contains(a1));
		System.out.println();
	
		//prints the sum of all the years of in the collection
		System.out.println("The total sum of the years: " + airplaneArrayBag.total());
		System.out.println();
		
		//counts the number of elements that lies within a given range; inclusive
		System.out.println("Number of objects that lies in a given range: " + airplaneArrayBag.countRange(2001, 2005));
		
		//prints true or false if an object is deleted or NOT
		System.out.println("Successfully deleted an object: " + airplaneArrayBag.delete(a1));
	}

}
