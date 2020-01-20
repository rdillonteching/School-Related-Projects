/**
 * This assignment implements a bag collection using a linked list and, 
 * in order to focus on the linked list implementation details, 
 * the collection stores an object of only one data type (i.e., not generic).
 *
 */
public class AirplaneNode {

	//instance variables
	private Airplane data;
	private AirplaneNode link;

	/**
	 * A constructor that takes two input parameters and use them to initialize the two instance variables.
	 * @param -- data part of the node that holds the data 
	 * @param -- link part of the node that holds a reference to the next node
	 */
	public AirplaneNode(Airplane data, AirplaneNode link) {
		this.data = data;
		this.link = link;
	}

	//getters and setters
	/**
	 * This method returns data
	 * @return data stored in the node.
	 */
	public Airplane getData() {
		return this.data;
	}

	/**
	 * This method sets the data
	 * @param -- data to be set on node to.
	 */
	public void setData(Airplane data) {
		this.data = data;
	}

	/**
	 * This method returns the link to a node reference
	 * @return link to the node reference
	 */
	public AirplaneNode getLink() {
		return this.link;
	}

	/**
	 * This method sets the link to the reference of a node
	 * @param -- link to the reference of a node
	 */
	public void setLink(AirplaneNode link) {
		this.link = link;
	}

	/**
	 * This method adds a node after the current node
	 * @param -- airplane node to be added after the current node
	 */
	public void addAirplaneNodeAfter(Airplane airplane) {
		this.link = new AirplaneNode(airplane,this.link);
	}

	/**
	 * This method removes the node after the current node
	 */
	public void removedAirplaneNodeAfter() {
		link = link.link;
	}

	/**
	 * This method displays the data of all the nodes in a given linked list 
	 * @param -- list of nodes in a linked list
	 */
	public static void display(AirplaneNode list) {
		AirplaneNode cursor = list;

		while (cursor != null) {
			System.out.println(cursor.data);
			cursor = cursor.getLink();
		}
	}

	/**
	 * This method list the position of a node starting at the head
	 * @param -- head of the list
	 * @param -- position of the node
	 * @return cursor node 
	 */
	public static AirplaneNode listPosition(AirplaneNode head, int position) {
		AirplaneNode cursor;
		int i;

		if (position <= 0) 
			throw new IllegalArgumentException("position is not positive.\");");

		cursor = head;
		for (i = 1; (i < position) && (cursor != null); i++)
			cursor = cursor.link;

		return cursor;
	}

	/**
	 * This method returns the size of the linked list beginning at the head
	 * @param -- head of the linked list
	 * @return answer which is the number of the total nodes in the linked list
	 */
	public static int listLenght(AirplaneNode head) {
		AirplaneNode cursor;
		int answer;

		answer = 0;
		for(cursor = head; cursor != null; cursor = cursor.link)
			answer++;
		return answer;
	}

	/**
	 * This method searches a linked list starting at the head for a specific target.
	 * @param -- head of the linked list.
	 * @param -- target to search for in the linked list.
	 * @return target if found and null otherwise.
	 */
	public static AirplaneNode listSearch(AirplaneNode head, Airplane target) {
		AirplaneNode cursor;

		for(cursor = head; cursor != null; cursor = cursor.link)
			if (target == cursor.data)
				return cursor;

		return null;			
	}
}
