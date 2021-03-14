/***********************************
* File name: Rearrange.java
* Author: Jumagulyyev, Gurban
* Student ID: 216151268
* EECS login ID: gurb2k
************************************/

public class Rearrange
{

/**************************************************************
 * DO NOT ADD ANYTHING ABOVE THIS LINE EXCEPT YOUR STUDENT INFO
 ***************************************************************/

/* 
 * Rearrange the array so that all the negative numbers 
 * appear before all the non-negative numbers. 
 * n is the number of elements A contains.
 *
 * The running time of your algorithm must O( n ).
 * Add a brief description of how your algorithm works below.
 */

/* Brief description: ....................................

 */
 
public static void rearrangeArray( int[] A, int n )
{
	public static void rearangeHelper(int[] A, int n, int ni, int i) {
        if (i >= n) {
            // do nothing
        }

        else {
            if (isNegative(A[i])) {
                ni++;
                int tempValue = A[i];
                A[i] = A[ni];
                A[ni] = tempValue;
            }
            i++;
            rearangeHelper(A, n, ni, i);
        }

    }

boolean isNegative(int n) {
    if (n < 0)
        return true;
    return false;
}
      return rearrangHelper(int[] A, int n, int -1, int 0)
   // COMPLETE THIS METHOD.

   // DO NOT CHANGE the above method declaration.

   // You may define local variables inside this method. Do not use global variables.

   // You may add your own helper methods/subroutines to this file.
   
}  // end rearrangeArray

}  // end class

