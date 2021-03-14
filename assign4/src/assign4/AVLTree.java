/***********************************
* EECS2011 - Assignment 4
* File name: AVLTree.java
* Author: Jumagulyyev, Gurban
* Email: gurb2k@my.yorku.ca
* CSE number: 216151268
************************************/


/**  Implementation of an AVL tree. */
public class AVLTree extends BinarySearchTree implements Dictionary {

  public AVLTree(Comparator c)  { super(c); }

  public AVLTree() { super(); }

  /** Nested class for the nodes of an AVL tree. */ 
  protected static class AVLNode extends BTNode {

    protected int height;  // we add a height field to a BTNode

    /** Preferred constructor */
    AVLNode(Object element, BTPosition parent,
	    BTPosition left, BTPosition right) {
      super(element, parent, left, right);
      height = 0;
      if (left != null) 
        height = Math.max(height, 1 + ((AVLNode) left).getHeight());
      if (right != null) 
        height = Math.max(height, 1 + ((AVLNode) right).getHeight());
    } // we assume that the parent will revise its height if needed

    public void setHeight(int h) { height = h; }

    public int getHeight() { return height; }
  }


  /**
    * Print the content of the tree root.
    */
  public void printRoot() {
     System.out.println("printRoot: " + value(left(root())).toString() + " "
        +  value(root()).toString() + " " + value(right(root())).toString());
  }


  /**
    * Print the the tree using preorder traversal.
    */
  public void preorderPrint(Position v) {
      if (isInternal(v))
         System.out.print( value(v).toString() + " " );
      if (hasLeft(v)) preorderPrint(left(v));
      if (hasRight(v)) preorderPrint(right(v));
  }


  /** Creates a new binary search tree node (overrides super's version). */
  protected BTPosition createNode(Object element, BTPosition parent,
              BTPosition left, BTPosition right) {
    return new AVLNode(element,parent,left,right);  // now use AVL nodes
  }


  /** Returns the height of a node (call back to an AVLNode). */
  protected int height(Position p)  {
    return ((AVLNode) p).getHeight();
  }


  /** Sets the height of an internal node (call back to an AVLNode). */
  protected void setHeight(Position p)  { // called only if p is internal
    ((AVLNode) p).setHeight(1+Math.max(height(left(p)), height(right(p))));
  }


  /** Returns whether a node has balance factor between -1 and 1. */
  protected boolean isBalanced(Position p)  {
    int bf = height(left(p)) - height(right(p));
    return ((-1 <= bf) &&  (bf <= 1));
  }


  /** Returns a child of p with height no smaller than that of the other child 
    */
  protected Position tallerChild(Position p)  {
    if (height(left(p)) > height(right(p))) return left(p);
    else if (height(left(p)) < height(right(p))) return right(p);
    // equal height children - break tie using parent's type
    if (isRoot(p)) return left(p);
    if (p == left(parent(p))) return left(p);
    else return right(p);
  }


  /**
    * Insert a new element into the AVL tree.
    */
  public Entry insert(Object k, Object v) throws InvalidKeyException  {
    Entry toReturn = super.insert(k, v); // calls our new createNode method
    rebalance(actionPos); // rebalance up from the insertion position
    return toReturn;
  }


  /**
    * Remove an element from the AVL tree.
    */
  public Entry remove(Entry ent) throws InvalidEntryException {
    Entry toReturn = super.remove(ent);
    if (toReturn != null)   // we actually removed something
      rebalance(actionPos);  // rebalance up the tree
    return toReturn;
  }


  /**  
    * Rebalance method called by insert and remove.  Traverses the path from 
    * zPos to the root. For each node encountered, we recompute its height 
    * and perform a trinode restructuring if it's unbalanced.
    */
  protected void rebalance(Position zPos) {
    if(isInternal(zPos))
       setHeight(zPos);
    while (!isRoot(zPos)) {  // traverse up the tree towards the root
      zPos = parent(zPos);
      setHeight(zPos);
      if (!isBalanced(zPos)) { 
	// Perform a trinode restructuring starting from zPos's tallest grandchild
        Position xPos =  tallerChild(tallerChild(zPos));
        zPos = restructure(xPos); // tri-node restructure 
        setHeight(left(zPos));  // recompute heights
        setHeight(right(zPos));
        setHeight(zPos);
      }
    }
  } 





   // ***************************************
   // DO NOT MODIFY THE CODE ABOVE THIS LINE.
   // ADD YOUR CODE BELOW THIS LINE.
   //
   // ***************************************


  /** 
   * Perform a trinode restructuring starting from x, z's tallest grandchild.
   * Input: xPos, position of (pointer to) x
   * Output: position of (pointer to) the new root of the subtree that was restructured.
   */
  protected Position restructure( Position xPos ) {

	// COMPLETE THIS METHOD

	// You may add your own method(s) to this file.
	  Position aPosition = parent(xPos);
	  Position bPosition = parent(aPosition);

	  BTPosition i;
	  BTPosition j;
	  BTPosition k;
	  BTPosition temp1;
	  BTPosition temp2;
	  BTPosition temp3;
	  BTPosition temp4;
	  BTPosition nodeA = (BTPosition)bPosition;
	  BTPosition nodeB = (BTPosition)aPosition;
	  BTPosition nodeC = (BTPosition)xPos;
			  
	  if((aPosition==left(bPosition)) && (xPos==left(aPosition))) {
		  i = nodeC;
		  j = nodeB;
		  k = nodeA;
		  temp1 = i.getLeft();
		  temp2 = i.getRight();
		  temp3 = j.getRight();
		  temp4 = k.getRight();
	  }
	  else if(((aPosition==right(bPosition))) && (xPos==left(aPosition))) {
		  i = nodeA;
		  j = nodeC;
		  k = nodeB;
		  temp1 = i.getLeft();
		  temp2 = j.getLeft();
		  temp3 = j.getRight();
		  temp4 = k.getRight();
	  }
	  else if(((aPosition==right(bPosition))) && (xPos==right(aPosition))) {
		  i = nodeB;
		  j = nodeC;
		  k = nodeA;
		  temp1 = i.getLeft();
		  temp2 = j.getLeft();
		  temp3 = j.getRight();
		  temp4 = k.getRight();
	  } 

	  else {
		  i = nodeA;
		  j = nodeB;
		  k = nodeC;
		  temp1 = i.getLeft();
		  temp2 = j.getLeft();
		  temp3 = k.getLeft();
		  temp4 = k.getRight();
	  }
		  		 
	  if(isRoot(bPosition)) {
		  root = j;
		  j.setParent(null);
	  }
	  else {	  
		  BTPosition tree = (BTPosition)parent(bPosition);
	  
		  if(bPosition==right(tree)) {
			  j.setParent(tree);
			  tree.setRight(j);
		  }  
		  else {
			  j.setParent(tree);
			  tree.setLeft(j);
		  }
	  }
		  
	  j.setLeft(i);
	 
	  i.setParent(j);
	  
	  j.setRight(k);
	  
	  k.setParent(j);
		  
	  i.setLeft(temp1);
	  
	  temp1.setParent(i);
		  
	  i.setRight(temp2);
	  
	  temp2.setParent(i);
		  
	  k.setLeft(temp3);
	  
	  temp3.setParent(k);
		  		  
	  k.setRight(temp4);
	  
	  temp4.setParent(k);
		  
	  return j;	// replace this line with your code

  } // restructure
  
} // end AVLTree class
