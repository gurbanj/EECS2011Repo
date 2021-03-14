/***********************************
* EECS2011 - Assignment 3
* File name: AnotherListDeque.java
* Author: Jumagulyyev, Gurban
* Email: gurb2k@my.yorku.ca
* EECS username: gurb2k
************************************/


public class AnotherListDeque 
{

   protected DNode head, tail;  // head and tail contain actual data (int)

   protected int size;    // number of elements

   public AnotherListDeque()     // constructor: initialize an empty deque
   {
       head = tail = null;
       size = 0;
   }


    /**
     * Display the content of the deque
     *
     */
    public void printDeque( )
    {

	for ( DNode p = head; p != null; p = p.getNext() )
	    System.out.print( p.getElement() + " " );
	System.out.println();

    }


   // ***************************************
   // DO NOT MODIFY THE CODE ABOVE THIS LINE.
   // ADD YOUR CODE BELOW THIS LINE.
   //
   // ***************************************

   /**
     * Returns the number of items in this collection.
     * @return the number of items in this collection.
     */
    public int size( )
    {
        // COMPLETE THIS METHOD
      return size();   // replace this line with your code
    }


    /**
     * Returns true if this collection is empty.
     * @return true if this collection is empty.
     */ 
    public boolean isEmpty( )
    {
    	// COMPLETE THIS METHOD
    	if(size == 0) 
    	{
    		return true;
    	}

      return false;   // replace this line with your code
    }


    /**
     * Returns the first element of the deque
     * 
     */
    public int getFirst( ) throws EmptyDequeException
    {
    	// COMPLETE THIS METHOD 
    	if(isEmpty()) 
    	{
    		throw new EmptyDequeException("Deque is Empty");
    	}
    	

      return head.getElement();   // replace this line with your code       
    }


    /**
     * Returns the last element of the deque
     * 
     */
    public int getLast( ) throws EmptyDequeException
    {
    	// COMPLETE THIS METHOD
    	if(isEmpty()) 
    	{
    		throw new EmptyDequeException("Deque is Empty");
    	}

      return tail.getElement();   // replace this line with your code         
    }


    /**
     * Inserts e at the beginning (as the first element) of the deque
     * 
     */
    public void insertFirst( int e )
    {
    	// COMPLETE THIS METHOD  
    	
    	DNode nd = new DNode(e, null, head);

        if (isEmpty()) 
        {
          tail = nd;
        } 
        
        else 
        {
          head.setPrev(nd);
        }

        head = nd;
        
        size++;
        
      }


    /**
     * Inserts e at the end (as the last element) of the deque
     * 
     */
    public void insertLast( int e )
    {
    	// COMPLETE THIS METHOD 
    	 
    	DNode nd = new DNode(e, tail, null);
    	 
    	    if (isEmpty()) 
    	    {
    	      head=nd;
    	    } 
    	    
    	    else 
    	    {
    	      tail.setNext(nd);
    	    }

    	    tail=nd;
    	    
    	    size++;
    }


    /**
     * Removes and returns the first element of the deque
     * 
     */
    public int removeFirst( ) throws EmptyDequeException
    {
    	// COMPLETE THIS METHOD	
    	
    	if(isEmpty()) 
    	{
    		throw new EmptyDequeException("Deque is Empty");
    	}
    	
    	int tpNode = head.getElement();
    	
    	head = head.getNext(); 
    	head.setPrev(null);
      
    	size--;
    	
    	return tpNode;   // replace this line with your code	
    }


    /**
     * Removes and returns the last element of the deque
     * 
     */
    public int removeLast( ) throws EmptyDequeException
    {
    	// COMPLETE THIS METHOD	
    	
    	if(isEmpty()) 
    	{
    		throw new EmptyDequeException("Deque is Empty");
    	}
    	
    	int tpNode = tail.getElement();

    	tail = tail.getPrev();
    	tail.setNext(null);

    	size--;

    	return tpNode;
    }

} // end class
