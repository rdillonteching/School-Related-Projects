/**
 * This class defines the binary search tree variable(s) and methods.
 *
 * Invariant of this LinkedList Binary Search Tree implementation:
 * 1. a BST is a binary tree
 * 2. a BST does not hold duplicate keys
 * 3. Each data item in a BST has a key associated with it
 * 4. Keys in a BST must be comparable to each other, for any two keys
 * 5. x1 is greater than x2 ; x2 is greater than x1 ; x1 and x2 are equal
 * 6. For every node X in a BST the key in X is greater than every key in X's left subtree
 * 7. For every node X in a BST the key in X is less than every key in X's right subtree
 */
public class ChocolateBSTree {
	//instance variable
	private ChocolateBTNode root;

	/**
	 * No-argument constructor which initializes Tree instance variables
	 */
	public ChocolateBSTree() {
		this.root = null;
	}

	/**
	 * This method inserts a new "Thing" in the tree in the correct position; 
	 * preserves the properties of a binary search tree
	 * @param - cur current root node
	 * @param - chocolate "thing" that is added into the tree
	 */
	private void add(ChocolateBTNode cur, Chocolate chocolate)	{
		if (chocolate.compareTo(cur.getData()) <= 0) {
			if (cur.getLeft() != null) {
				add(cur.getLeft(), chocolate);
			}
			else {
				cur.setLeft(new ChocolateBTNode(chocolate));
			}
		}
		else if (chocolate.compareTo(cur.getData()) > 0) {
			if (cur.getRight() != null)
				add(cur.getRight(), chocolate);
			else
				cur.setRight(new ChocolateBTNode(chocolate));
		}
	}

	/**
	 * This method inserts a new "Thing" in the tree in the correct position
	 * @param - chocolate "thing" which is added to the tree
	 */
	public void add (Chocolate chocolate){
		if (root == null)
			root = new ChocolateBTNode(chocolate);
		else
			add(root, chocolate);
	}

	/**
	 * This method displays nodes in inorder, Left Child, Node, Right Child
	 * @param - cur current root node
	 */
	private void inorder(ChocolateBTNode cur)	{
		if (cur != null)	{
			inorder(cur.getLeft());
			System.out.println(
					cur.getData());
			inorder(cur.getRight());
		}
	}

	/**
	 * This method displays nodes in inorder, Left Child, Node, Right Child
	 * The method is also a public method that calls the private inorder method
	 */
	public void inorder()	{
		inorder(root);
	}

	/**
	 * This method displays nodes in postorder, Left Child, Right Child, Node
	 * @param - cur current root node
	 */
	private void postorder(ChocolateBTNode cur)	{
		if (cur != null)	{
			postorder(cur.getLeft());
			postorder(cur.getRight());	  
			System.out.println(
					cur.getData());		
		}
	}

	/**
	 * This method displays nodes in postorder, Left Child, Right Child, Node
	 * The method is also a public method that calls the private postorder method
	 */
	public void postorder()	{
		postorder(root);
	}

	/**
	 * This method displays nodes in pre-order, Node, Left Child, Right Child
	 * @param - cur current root node
	 */
	private void preorder(ChocolateBTNode cur)	{
		if (cur != null)	{
			System.out.println(
					cur.getData());
			preorder(cur.getLeft());
			preorder(cur.getRight());	  					
		}
	}

	/**
	 * This method displays nodes in pre-order, Node, Left Child, Right Child
	 * The method is also a public method that calls the private pre-order method
	 */
	public void preorder()	{
		preorder(root);
	}

	/**
	 * This methods returns the number of Nodes in the Tree
	 * @param - cur current root node
	 * @return count
	 */
	private int count(ChocolateBTNode cur){
		if (cur==null)
			return 0;
		return 1 + count(cur.getLeft()) + count(cur.getRight());
	}

	/**
	 *  This methods returns the number of Nodes in the Tree
	 *  The method is also a public method that calls the private count method
	 * @return count
	 */
	public int count(){
		return count(root);
	}

	/**
	 * This method traverses the Tree and returns a reference to a 
	 * Thing with a search key that matches item's search key.  
	 * Returns null if not found.
	 * @param - cur current root node
	 * @param - coco search key
	 * @return chocolate object
	 */
	private Chocolate search(ChocolateBTNode cur, Chocolate coco) {
		if(cur== null)
			return null;
		if (coco.getName().compareTo(cur.getData().getName()) == 0)
			return cur.getData();
		else if (coco.getName().compareTo(cur.getData().getName()) < 0)
			return search(cur.getLeft(), coco);
		else
			return search(cur.getRight(), coco);     
	}

	/**
	 * This method traverses the Tree and returns a reference to a 
	 * Thing with a search key that matches item's search key.
	 * The method is also a public method that calls the private search method
	 * @param - chocolate search key
	 * @return chocolate object
	 */
	public Chocolate search(Chocolate chocolate){
		return search(root, chocolate);
	}

	/**
	 * This method returns the height (depth) of the Tree
	 * @param - cur current root node
	 * @return depth of the tree
	 */
	private int depth(ChocolateBTNode cur) {
		if (cur == null) 
			return 0; 
		else 
		{ 
			int leftDepth = depth(cur.getLeft()); 
			int rightDepth = depth(cur.getRight()); 

			/* use the larger one */
			if (leftDepth > rightDepth) 
				return (leftDepth + 1); 
			else 
				return (rightDepth + 1); 
		} 
	} 

	/**
	 * This method returns the height (depth) of the Tree
	 * The method is also a public method that calls the private depth method
	 * @return depth of the tree
	 */
	public int depth() {
		return depth(root);
	}	

	/**
	 * This method deletes a node from the tree
	 * code is used from: https://www.geeksforgeeks.org/binary-search-tree-set-2-delete/
	 * @param - cur root node
	 * @param - deleteKey key to be deleted if found
	 * @return cur root node
	 */
	private ChocolateBTNode delete(ChocolateBTNode cur, Chocolate deleteKey) 
	{ 
		//Base Case: If the tree is empty 
		if (cur == null)  return cur; 

		//Otherwise, recur down the tree 
		if (deleteKey.getName().compareTo(cur.getData().getName()) < 0) 
			cur.setLeft(delete(cur.getLeft(), deleteKey)); 
		else if (deleteKey.getName().compareTo(cur.getData().getName()) > 0) 
			cur.setRight(delete(cur.getRight(), deleteKey)); 

		// if key is same as root's key, then This is the node 
		// to be deleted 
		else
		{ 
			// node with only one child or no child 
			if (cur.getLeft() == null) 
				return cur.getRight(); 
			else if (cur.getRight() == null) 
				return cur.getLeft(); 

			// node with two children: Get the inorder successor (smallest 
			// in the right subtree) 
			cur.setData(minValue(cur.getRight())); 

			// Delete the inorder successor 
			cur.setRight(delete(cur.getRight(), cur.getData())); 
		} 

		return cur; 
	} 

	/**
	 * This method deletes a node from the tree
	 * The method is also a public method that calls the private delete method
	 * @param - chocolate
	 */
	// This method mainly calls deleteRec() 
	public void delete(Chocolate chocolate) 
	{ 
		root = delete(root, chocolate); 
	} 

	/**
	 * This method finds the min value of the node
	 * @param - root parent node
	 * @return minv
	 */
	public Chocolate minValue(ChocolateBTNode root) 
	{ 
		ChocolateBTNode cur = root;
		Chocolate minv = cur.getData(); 
		while (cur.getLeft() != null) 
		{ 
			minv = cur.getLeft().getData(); 
			cur = cur.getLeft(); 
		} 
		return minv; 
	}

	/**
	 * This method displays all the nodes in a BST tree
	 * @param - cur current root node
	 */
	private void display(ChocolateBTNode cur){
		if(cur!=null){
			display(cur.getLeft());
			System.out.println(cur.getData().toString());
			display(cur.getRight());
		}
	}

	/**
	 * This method displays all the nodes in a BST tree
	 * The method is also a public method that calls the private display method

	 */
	public void display() {
		display(root);
	}
}
