/** 
 * This class uses a linked implementation to define the Node for the binary search tree.
 *
 */
public class ChocolateBTNode {

	//instance variables
	private Chocolate data;
	private ChocolateBTNode leftReference;
	private ChocolateBTNode rightReference;

	/**
	 * One argument constructor which initializes Node object instance variables
	 * @param - data references a chocolate object
	 */
	public ChocolateBTNode(Chocolate data) {
		this.data = data;
		this.leftReference = null;
		this.rightReference = null;
	}

	/**
	 * This method returns the data for a chocolate object 
	 * @return data
	 */
	public Chocolate getData() {
		return data;
	}

	/**
	 * This method sets the data for a chocolate object
	 * @param - data references chocolate object
	 */
	public void setData(Chocolate data) {
		this.data = data;
	}

	/**
	 * This method sets the left Node reference
	 * @param - left references the left child of a parent node
	 */
	public void setLeft(ChocolateBTNode left) {
		this.leftReference = left;
	}

	/**
	 * This method sets the right Node reference
	 * @param - right references the right child of a parent node
	 */
	public void setRight(ChocolateBTNode right) {
		this.rightReference = right;
	}

	/**
	 * This method gets the Right reference of a parent Node
	 * @return rightReference
	 */
	public ChocolateBTNode getRight() {

		return rightReference;
	}

	/**
	 * This method gets the Left reference of a parent Node
	 * @return leftReference
	 */
	public ChocolateBTNode getLeft() {

		return leftReference;
	}

	/**
	 * This boolean method returns True when a Node left and right references are null
	 * @return leftReference and rightReference Nodes
	 */
	public boolean isLeaf() {
		return (leftReference == null) && (rightReference == null);
	}
}
