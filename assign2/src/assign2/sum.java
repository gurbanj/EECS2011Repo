/***********************************
* CSE2011 - Assignment 2 
* File name: sum.java
* Author: Jumagulyyev, Gurban
* Email: gurb2k@my.yorku.ca
* CSE number: 216151268
************************************/


public class sum {


/*
 * EXHAUSTIVE ALGORITHM
 * Returns true if array A contains two elements whose sum is k.
 * Returns false otherwise.
 * n is the number of elements A contains.
 *
 * The running time of your algorithm is O(  ).
 * You may add a brief explanation here if you wish.
 */

public static boolean sum_exh( int[] A, int n, int k )
{
	for(int x = 0; x < n; x++) {
		for(int g = 0; g < n; g++) {
			if(A[x] + A[g] == k && A[x] != A[g]) {
				return true;
			}
		}
	}
	return false;
   // COMPLETE THIS METHOD.

   // You may define local variables inside this method.

   // You may add your own methods/subroutines to this file.

}  // end sum_exh





/*
 * RECURSIVE ALGORITHM
 * Returns true if array A contains two elements whose sum is k.
 * Returns false otherwise.
 * n is the number of elements A contains.
 *
 * The running time of your algorithm is O(  ).
 * You may add a brief explanation here if you wish.
 */

public static boolean sum_rec( int[] A, int n, int k )
{
	return sum_recHelp(A, 0, A.length-1, k);
   // COMPLETE THIS METHOD.

   // You may define local variables inside this method.

   // You may add your own methods/subroutines to this file.

}  // end sum_rec
public static boolean sum_recHelp(int[] A, int j, int g, int k) {
	if (j >= g) {
		return false;
	}
	else if (A[j] + A[g] == k) {
		return true;
	}
	else if (A[j] + A[g] < k) {
		return sum_recHelp(A, j+1, g, k);
	}
	else {
		return sum_recHelp(A, j, g-1, k);
	}
}

} // end class
