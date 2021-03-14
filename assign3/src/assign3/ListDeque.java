/***********************************
* EECS2011 - Assignment 3
* File name: ListDeque.java
* Author: Jumagulyyev, Gurban
* Email: gurb2k@my.yorku.ca
* EECS username: gurb2k
************************************/


public class ListDeque 
{

   protected DNode header, trailer;  // dummy nodes

   protected int size;    // number of elements

   public ListDeque()     // constructor: initialize an empty deque
   {
      header = new DNode( 0, null, null );
      trailer = new DNode( 0, null, null );
      header.setNext(trailer);  // make header point to trailer
      trailer.setPrev(header);  // make trailer point to header
      size = 0;
   }


    /**
     * Display the content of the deque
     *
     */
    public void printDeque( )
    {
	for ( DNode p = header.getNext(); p != trailer; p = p.getNext() )
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

      return size;   // replace this line with your code
    }


    /**
     * Returns true if this collection is empty.
     * @return true if this collection is empty.
     */ 
    public boolean isEmpty( )
    {
    	// COMPLETE THIS METHOD
    	if(size == 0) {
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
    	if(isEmpty()) {
    		throw new EmptyDequeException("Deque is Empty");
    	}

      return header.getNext().getElement();   // replace this line with your code       
    }


    /**
     * Returns the last element of the deque
     * 
     */
    public int getLast( ) throws EmptyDequeException
    {
    	// COMPLETE THIS METHOD   
    	if(isEmpty()) {
    		throw new EmptyDequeException("Deque is Empty");
    	}

      return trailer.getPrev().getElement();   // replace this line with your code         
    }


    /**
     * Inserts e at the beginning (as the first element) of the deque
     * 
     */
    public void insertFirst( int e )
    {
    	// COMPLETE THIS METHOD 
    	DNode newNode = new DNode(e, header, header.getNext());
    	DNode nextNode = newNode.getNext();
    	
    	header.setNext(newNode);
    	
    	nextNode.setPrev(newNode);
    	
    	size++;
    }


    /**
     * Inserts e at the end (as the last element) of the deque
     * 
     */
    public void insertLast( int e )
    {
    	// COMPLETE THIS METHOD   
    	DNode lastNode = new DNode(e, trailer.getPrev(), trailer);
    	
    	trailer.getPrev().setNext(lastNode);
        trailer.setPrev(lastNode);
        
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
    	
    	DNode nd= header.getNext();
        DNode nxtnd= nd.getNext();
        DNode prvnd= header;

        
        prvnd.setNext(nxtnd);
        nxtnd.setPrev(prvnd);
        
        size--;
        
        return nd.getElement();
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
        DNode nxtnd= trailer;
    	DNode nd= trailer.getPrev();
        DNode prvnd= nd.getPrev();
        
        prvnd.setNext(nxtnd);
        nxtnd.setPrev(prvnd);
        
        size--;
        
        return nd.getElement();
    }


} // end class
