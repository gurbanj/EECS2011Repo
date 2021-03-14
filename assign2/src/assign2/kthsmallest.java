/***********************************
* CSE2011 - Assignment 2 
* File name: kthsmallest.java
* Author: Jumagulyyev, Gurban
* Email: gurb2k@my.yorku.ca
* CSE number: 216151268
************************************/


public class kthsmallest {

public static final int MaxSize = 500;

/*
 * Return the value of the kth smallest element of array A.
 * n is the number of elements A contains, and k <= n.
 * The running time of your algorithm must be O(n).
 *
 */

public static int find_kth_smallest( int[] A, int n, int k ) {
	return find_kth_smallestHelp(A, 0, n - 1, k); 
	}
   // COMPLETE THIS METHOD.

   // You may define local variables inside this method.

   // You may add your own methods/subroutines to this file.
static int find_kth_smallestHelp(int[] A, int lower, int h, int k) {

	int part = randomPart(A, lower, h);
	
	if(part-lower == k-1) {
		return A[part];
	}
	
	if(part-lower > k-1) {
		return find_kth_smallestHelp(A, lower, part - 1, k);
	}
	return find_kth_smallestHelp(A, part + 1, h, k - part + lower - 1);

   /* Note 1:
    * During the partitioning process, array elements may be swapped and moved around.
    * DO NOT modify the content of array A.  Copy it to a temporary array B and work on B instead.
    */

   /* Note 2:
    * DO NOT SORT THE WHOLE ARRAY and then return B[k-1].  That would take O(nlogn) time.
    * If you do that, your program will get zero point.
    */

}// end find_kth_smallest

public static void swapper(int[] A, int i, int j) {
	int temporary = A[i];
	
	A[i] = A[j];
	A[j] = temporary;
}

public static int quickSortPart(int[] A, int l, int h) {
	int first = l;
	int last = A[h];
	
	for(int j = l; j <= h-1; j++) {
		if(A[j] <= last) {
			swapper(A, first, j);
			first++;
		}
	}
	swapper(A, first, h );
	return first;
}

public static int randomPart(int[] A, int j, int k) {
	int nombre = k - j + 1;
	int pivot = (int)(Math.random())*(nombre-1);
	swapper(A, pivot + j, k);
	
	return quickSortPart(A, j, k);
}

} // end class