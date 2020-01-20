/**
 * This assignment implements a bag collection using a linked list and, 
 * in order to focus on the linked list implementation details, 
 * the collection stores an object of only one data type (i.e., not generic).
 * 
 * Invariant of this LinkedListBag implementation:
 * 1. The elements in the bag are stored in a linked list.
 * 2. The head reference of the list is stored in the instance variable head.
 * 3. A linked list of length 1, head == tail.
 * 4. A linked list of length 0, both head and tail should be null
 * 5. The total number of elements in the list is stored in the instance variable manyItems.
 * 6. The tail should be the node holding the last element of the list.
 * 7. A list traversal beginning at the head of the list should visit the tail node last.
 *
 */
public class AirplaneLinkedBag {

	//instance variables
	private AirplaneNode head; // Head reference for the list
	private int manyItems; // Number of nodes in the list

	//two argument constructor
	/**
	 * instantiates a LinkListBag with a default size
	 */
	public AirplaneLinkedBag() {
		head = null;
		manyItems = 0;
	}

	/**
	 * This method returns the number of nodes in the list.
	 * @return manyItems total number of nodes in the list.
	 */
	public int size() {
		return manyItems;
	}


	/**
	 * This method displays the contents of the collection such that each element is displayed on one line. 
	 * Note that this method displays the list on the screen and does NOT return a String representation of the list.
	 */
	public void display() {

		AirplaneNode cursor = head;

		System.out.println("Name \t\t\t Year \t\t Lenght");
		System.out.println("------------------------------------------------");
		while (cursor != null) {
			System.out.println(cursor.getData());
			cursor = cursor.getLink();
		}
	}

	/**
	 * This method adds a Thing to the collection.
	 * @param element -- Airplane node to be added to the head of the list
	 */
	public void add(Airplane element) {
		if (isEmpty()) {
			this.head = new AirplaneNode(element, head);
			this.manyItems++;
		}else {
			AirplaneNode addingNode = head;
			addingNode.addAirplaneNodeAfter(element);
			manyItems++;
		}
	}

	/**
	 * This a method to add an element at a specific index in the collection assuming the first node (referenced by head) is at index 1. 
	 * If the index is greater than the collection length, then the element is added as the last element in the collection. 
	 * The method does not do anything if index is negative.
	 * @param index -- position where element is inserted.
	 * @param element -- Airplane node to be inserted in the specific position.
	 */
	public void add(int index, Airplane element) {
		AirplaneNode cursor = head;

		if (index == 1) {
			add(element);
		}else if(index < 0) {

		}else {
			for(int i = 1; i < index-1 && cursor.getLink() != null ; i++) {
				cursor = cursor.getLink();
			}
			AirplaneNode newElement = new AirplaneNode(element, cursor.getLink());
			cursor.setLink(newElement);
			manyItems++;
		}
	}


	/**
	 * This method removes one occurrence of the target from the list if any such Thing exists in the list. 
	 * The method returns true if an item is removed and false otherwise
	 * @param target -- Airplane node to search.
	 * @return True if an the target object and is removed and False when the target object is not found.
	 */
	public boolean remove(Airplane target){
		AirplaneNode targetNode = AirplaneNode.listSearch(this.head, target);
		if (targetNode == null)
			return false;
		else{
			Airplane headData = this.head.getData();
			targetNode.setData(headData);
			manyItems--;
			this.head = this.head.getLink();
			return true;	
		}
	}

	/**
	 * This method removes the element that is located at position index in the linked list 
	 * where the first node (referenced by head) is at index 1. 
	 * The method returns true if an item is removed and false if no element is removed because index is negative 
	 * or beyond the list length.
	 * @param index -- specific position where a node is removed
	 * @return True if an item is removed and False if no element is removed because index is negative 
	 */
	public boolean remove(int index) {
		int counter = 1;
		AirplaneNode cursor;

		if (index == 1) {
			head = head.getLink();
			manyItems--;
			return true;
		}

		for(cursor = head; cursor != null; cursor = cursor.getLink()) {
			if (counter == index) {//gets the previous node before the target
				cursor.setLink(cursor.getLink().getLink());
				manyItems--;
				return true;
			}
			counter++;
		}
		return false;
	}

	//ignore this method, another one exists
	/**
	 * 
	 * @param target
	 * @return
	 */
	/*	public boolean remove(Airplane target) {
		AirplaneNode cursor = head;
		if (cursor.getData().equals(target)) {
			head = cursor.getLink();
			manyItems--;
			return true;
		}
		while (cursor.getLink() != null) {
			if (cursor.getLink().getData().equals(target)) {
				cursor.setLink(cursor.getLink().getLink());
				manyItems--;
				return true;
			}
			cursor = cursor.getLink();
		}
		return false;
	}*/

	/**
	 * This method counts and returns how many element in the collection fall in the range between start and end inclusive.
	 * @param -- start position to begin counting
	 * @param -- end position to stop counting
	 * @return counter which is the total number nodes that fall within the start and end range inclusive.
	 */
	public int countRange(Airplane start, Airplane end) {
		int counter = 0;
		AirplaneNode cursor = head;

		while (cursor != null) {
			if (cursor.getData().getName().compareTo(start.getName()) >= 0 && cursor.getData().getName().compareTo(end.getName()) <= 0) {
				counter++;
			}
			cursor = cursor.getLink();
		}
		return counter ;

	}

	/**
	 * This method returns the element of the node located at position index in the list or null 
	 * if index is past the end of the list. Note that this method does not remove the element from the list.
	 * @param -- index position at which to grab a node.
	 * @return Airplane node at a specific position.
	 */
	public Airplane grab(int index) {
		AirplaneNode cursor = head; 
		Airplane foundTarget = null;
		int counter = 1;

		while (cursor != null) {
			if (counter == index) {
				foundTarget = cursor.getData();
				return foundTarget;
			}
			counter++;
			cursor = cursor.getLink();
		}
		return foundTarget;
	}

	/**
	 * This method returns the index of the node that contains the target where the first node (referenced by head) is at index 1. 
	 * If the target is not found, the method returns -1 and if there is more than one occurrence, 
	 * then the method returns the index of the first occurrence.
	 * @param -- target at a specific index
	 * @return nodeIndex where the target is found
	 */
	public int indexOf(Airplane target) {
		AirplaneNode targetNode = AirplaneNode.listSearch(this.head, target);
		AirplaneNode cursor = head;
		int nodeIndex = 0;
		if (targetNode == null) {
			return nodeIndex;
		}else {
			while (cursor != null) {
				if(targetNode.getData().equals(target)) {
					//System.out.println("Returned Data from the search: " + targetNode.getData() + " Target data passed in is: " + target);
					nodeIndex++;
					return nodeIndex;
				}
				cursor = cursor.getLink();
			}
		}
		return nodeIndex;

		/*while(cursor != null) {
			if (cursor.getData().equals(target)) {
				nodeIndex++;	
				return nodeIndex;
			}

			cursor = cursor.getLink();
		}
		return nodeIndex;*/

	}

	/**
	 * This method replaces the Thing element at position index with the input element. 
	 * If index is negative or beyond the length of the list, then the method does not do anything.
	 * @param -- index where element is replaced with another element
	 * @param -- element to replace the element at the specified index
	 */
	public void set(int index, Airplane element) {
		AirplaneNode cursor = head;
		int nodeIndex = 0;

		while(cursor != null) {
			nodeIndex++;
			if (nodeIndex == index) {
				cursor.setData(element);
			}
			cursor = cursor.getLink();
		}
	}

	/**
	 * This method takes two Thing inputs, oldThing and newThing. 
	 * The method then searches the collection for an element that is equal to oldThing. 
	 * If found, the method replaces (only one occurrence of) oldThing with newThing while maintaining the linked list order 
	 * (i.e., don't delete and then re-insert). On the other hand, if oldThing is not found in the collection, the method does not do anything. 
	 * The method then returns true or false based on whether a replacement took place or not. 
	 * @param -- oldThing node that exist in the list
	 * @param -- newThing node which will replace the node that currently exist in the list
	 * @return True or False based on whether a replacement took place or not.
	 */
	public boolean replace(Airplane oldThing, Airplane newThing) {
		AirplaneNode cursor = head;

		if (head.getData().equals(oldThing)) {
			head.setData(newThing);
			return true;
		}
		while (cursor != null) {
			if (cursor.getData().equals(oldThing)) {

			}
			cursor = cursor.getLink();
		}
		return false;

	}

	/**
	 * This method returns the sum of all the integer values of all things in the list  
	 * (remember that it was required that each "Thing" has an integer attribute).
	 * @return totalVal the sum of all the years of each node in the linked list.
	 */
	public int totalValue() {
		AirplaneNode cursor;
		int totalVal = 0;

		for (cursor = head; cursor != null; cursor = cursor.getLink()) {
			totalVal += cursor.getData().getYear();
		}
		return totalVal;

	}

	/**
	 * This method takes one "Thing" as input and returns as output a linked list that includes 
	 * all elements that are less than or equal to the input element. 
	 * Note that "Things" are ordered based on the compareTo()method from the Thing class.
	 * @param -- element being compared to the current list to find nodes less than or equal to it.
	 * @return lessThan the list of nodes the input node is less than.
	 */
	public AirplaneLinkedBag lessThan(Airplane element) {
		AirplaneNode cursor = head;
		AirplaneLinkedBag lessThan = new AirplaneLinkedBag();

		if (isEmpty()) {
			return lessThan; //so if the head is empty, don't need to traverse the LinkedList
		}

		while (cursor != null) {
			if (cursor.getData().getName().compareTo(element.getName()) < 0) {
				lessThan.add(cursor.getData());
			}
			cursor = cursor.getLink();
		}

		return lessThan;
	}

	/**
	 * This method takes one Thing as input and returns as output a linked list that includes 
	 * all elements that are greater than the input element. 
	 * Note that "Things" are ordered based on the compareTo() method from the Thing class.
	 * @param -- element being compared to the current list to find nodes greater than or equal to it.
	 * @return greaterThan the list of nodes the input node is less than.
	 */
	public AirplaneLinkedBag greaterThan(Airplane element) {
		AirplaneNode cursor = head;

		AirplaneLinkedBag greaterThan = new AirplaneLinkedBag();

		if (isEmpty()) {
			return greaterThan; //so if the head is empty, don't need to traverse the LinkedList
		}

		while (cursor != null) {
			if (cursor.getData().getName().compareTo(element.getName()) > 1) {
				greaterThan.add(cursor.getData());
			}
			cursor = cursor.getLink();
		}

		return greaterThan;

	}

	/**
	 * This method returns the maximum "Thing" in the linked list where things are ordered based on the compareTo() method.
	 * @return max the maximum node in the linked list.
	 */
	public Airplane getMax() {
		AirplaneNode cursor = head;
		Airplane max = head.getData();

		while (cursor != null) {
			if (max.compareTo(cursor.getData()) >= 1) {
				max = cursor.getData();
			}

			cursor = cursor.getLink();
		}

		return max;

	}

	/**
	 * This method returns the minimum "Thing" in the linked list where things are ordered based on the compareTo() method.
	 * @return min the minimum node in the linked list.
	 */
	public Airplane getMin() {
		AirplaneNode cursor = head;
		Airplane min = head.getData();

		while (cursor != null) {
			if (min.compareTo(cursor.getData()) == -1) { //this min method is returning the exact object as the max
				min = cursor.getData();
			}

			cursor = cursor.getLink();
		}

		return min;


	}


	/**
	 * This method adds an element to be the last element in the linked list
	 * @param -- element the element to add at the end of the list.
	 */
	public void addLast(Airplane element) {
		AirplaneNode cursor = head;

		if (head == null) {
			add(element);
		}else {
			while(cursor.getLink() != null) {
				cursor = cursor.getLink();
			}
			cursor.setLink(new AirplaneNode(element, null));
			manyItems++;
		}

	}

	/**
	 * This method removes the last node in the linked list
	 */
	public void removeLast() {
		AirplaneNode cursor = head;

		if (isEmpty()) {
			return;
		}

		while (cursor.getLink().getLink() != null) {
			cursor = cursor.getLink();
		}
		cursor.setLink(null);
		manyItems--;
	}

	/**
	 * This method is used as a helper method to check if the head is null.
	 * @return True when the head is null and False when the head is not null.
	 */
	public boolean isEmpty() {
		if(head == null)
			return true;
		return false;	
	}
} 
