/***********************************
* CSE2011 - Assignment 2 
* File name: symm.java
* Author: Jumagulyyev, Gurban
* Email: gurb2k@my.yorku.ca
* CSE number: 216151268
************************************/

public class symm
{


/* 
 * Returns true if array A is symmetric.
 * Returns false otherwise.
 * n is the number of elements A contains.
 *
 * The running time of your algorithm is O(  ).
 * You may add a brief explanation here if you wish.
 */

public static boolean symmetric( int[] A, int n )
{
	return symmHelp(A, n, 0);
	}
   // COMPLETE THIS METHOD.

   // You may define local variables inside this method.

   // You may add your own methods/subroutines to this file.
public static boolean symmHelp(int[] A, int n, int j) {
	if(j > n/2) {
		return true;
	}
	else if (A[j] != A[n-1-j]) {
		return false;
	}
	else {
		return symmHelp(A, n, j+1);
	}
}  // end symmetric


}  // end class

