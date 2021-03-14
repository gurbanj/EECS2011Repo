/***********************************
* EECS2011 - Assignment 3
* File name: ArrayDeque.java
* Author: Jumagulyyev, Gurban
* Email: gurb2k@my.yorku.ca
* EECS username: gurb2k
************************************/


public class ArrayDeque
{
   public static final int INIT_CAPACITY = 8;	// initial array capacity
   protected int capacity;  // current capacity of the array
   protected int front;     // index of the front element
   protected int rear;      // index of the rear element
   protected int[] A;	    // array deque

   public ArrayDeque( )      // constructor method
   {
      A = new int[ INIT_CAPACITY ];
      capacity = INIT_CAPACITY;
      front = rear = 0;
   }


    /**
     * Display the content of the deque
     * 
     */
    public void printDeque( )
    {
      for ( int i = front; i != rear; i = (i+1) % capacity )
	System.out.print( A[i] + " " );
      System.out.println();
    }


    /**
     * Display the content of the whole array
     *
     */
    public void printArray( )
    {
	for ( int i = 0; i < capacity; i++ )
	   System.out.print( A[i] + " " );
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

        // Hint: size can be computed from capacity, front and rear.
    	int sz = (rear+capacity-front)%capacity;

      return sz;   // replace this line with your code
    }


    /**
     * Returns true if this collection is empty.
     * @return true if this collection is empty.
     */ 
    public boolean isEmpty( )
    {
    	// COMPLETE THIS METHOD
    	if(front == rear) {
    		return true;
    	}

      return false;   // replace this line with your code
    }


    /**
     * Returns the first element of the deque
     * 
     */
    public int getFirst() throws EmptyDequeException
    {
    	// COMPLETE THIS METHOD
    	if(isEmpty()) {
    		throw new EmptyDequeException("Queue is Empty");
    	}
    	else {
    		return A[front];
    	}      
    }


    /**
     * Returns the last element of the deque
     * 
     */
    public int getLast( ) throws EmptyDequeException
    {
    	if(isEmpty()) {
    		throw new EmptyDequeException("Queue is Empty");
    	}
    	else {
    		return A[rear - 1];
    	}           // replace this line with your code         
    }


    /**
     * Inserts e at the beginning (as the first element) of the deque
     * 
     */
    public void insertFirst( int e )
    {
    	// COMPLETE THIS METHOD 
    	if (size() == capacity - 1) {
    		
    		capacity = capacity * 2;
    		int [] tempval = new int[capacity];
    		int k = 0;
    		for(int i=front; i<rear; i = (i+1)%capacity){
    			tempval[k+1] = A[i];
    			k = k + 1;
    		}
    		
    		rear = capacity/2;
    		A = tempval;     		
    		front = 0;
    		
    	}
    	else {
    		
    		int [] temparray = new int[capacity];
    		
    		for(int j=front; j<rear; j = (j+1)%capacity ) {
    			temparray[j+1] = A[j];
    		 }
    			
    		A = temparray;
    		rear = rear + 1;
    		
    	}
    	A[front] = e;
    }


    /**
     * Inserts e at the end (as the last element) of the deque
     * 
     */
    public void insertLast( int e )
    {
    	// COMPLETE THIS METHOD
    	if (this.size() == capacity-1) {
    		capacity = capacity*2;
    		
    		int [] temparray = new int[capacity];
    		int j = 0;
    		
    		for(int l=front; l<rear; l=(l+1)%capacity){
    			temparray[j] = A[l];
    			j++;
    		}
    		
    		front = 0;
    		A = temparray;
    		rear = capacity/2;
    		
    	}
    	else {
    		int [] temparray = new int[capacity];
    		
    		for(int g=front; g<rear; g=(g+1)%capacity ){
    			temparray[g] = A[g];
    		 }
    		
    			A = temparray;
    			rear = rear+1;
    			
    		}
    		A[rear-1] = e;
    }
    


    /**
     * Removes and returns the first element of the deque
     * 
     */
    public int removeFirst( ) throws EmptyDequeException
    {
    	// COMPLETE THIS METHOD	
    	
    	if(isEmpty()) { //exception throw
    		throw new EmptyDequeException("Queue is Empty");
     	}
    	
    	int chksz = capacity/4 + 1;
    	int rest; 
    	
    	if (this.size()<chksz && capacity>INIT_CAPACITY) {
    		
    		int [] temparr = new int[capacity/2];
    		int a = 0;
    		
    		for(int i=front; i<rear; i=(i+1)%capacity) {
    			temparr[a] = A[i+1];
    			a = a+1;
    		}
    		
    		rest = A[front];
     		A = temparr;
     		capacity /= 2;
     		
      	}
    	// normal case
    	else {
    		int [] temparr = new int[capacity];
    		
    		for(int j=front; j<rear; j=(j+1)%capacity) {
    			temparr[j] = A[j+1];
    	}
    		
    		rest = A[front];
    		A = temparr;
    		
    	}
    	
    	rear = rear - 1;
    	return rest;
    	
      }


    /**
     * Removes and returns the last element of the deque
     * 
     */
    public int removeLast( ) throws EmptyDequeException
    {
    	// COMPLETE THIS METHOD		
    	if(isEmpty()) {
    		throw new EmptyDequeException("Queue is Empty");
     	}
    	int chksz = capacity/4;
    	int rest; 
    	
    	if (this.size()<chksz && capacity>INIT_CAPACITY) {
    		int [] temparr = new int[capacity/2];
    		int l = 0;
    		
    		for(int k=front; k<rear; k=(k+1)%capacity) {
    			temparr[l] = A[k];
    			l = l+1;
    		}
    		
    		front = 0;
    		rest = A[rear-1];
     		A = temparr;
      	}
    	else {
    		int [] temparr = new int[capacity];
    		
    		for(int m=front; m<rear; m=(m+1)%capacity) {
    			temparr[m] = A[m];
    	}
    		
    		rest = A[rear-1];
    		A = temparr;
    		
    	}
    	
    	rear = rear-1;
    	return rest; 
    }

}  // end class
