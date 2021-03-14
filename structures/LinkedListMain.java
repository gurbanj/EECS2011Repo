/***********************************
* File name: LinkedListMain.java
************************************/

import java.util.Scanner;

public class LinkedListMain
{
	public static final int STOPVALUE = -999;

	public static void main( String[] args )
	{
		LinkedList myList = new LinkedList( );
		
		int k;
		Scanner input = new Scanner( System.in );
		
		// Get input from user to build a linked list
		k = input.nextInt( );
		while ( k != STOPVALUE )
   		{
      		myList.insert( k );
      		k = input.nextInt( );
   		} 
   		myList.printList( );
   		
   		// Get integer k from user
   		k = input.nextInt( );
   		System.out.print( k + " appears " + myList.numOfTimes( k ) + " time(s).");
   		System.out.println();
		
	}	  // end main
}  // end class LinkedListMain