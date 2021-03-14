/***********************************
* CSE2011 - Assignment 2 
* File name: kthsmallest.java
* Author: Jumagulyyev, Gurban
* Email: gurb2k@my.yorku.ca
* CSE number: 216151268
************************************/

public class match {

	/*
	 * EXHAUSTIVE ALGORITHM Returns index i if array A contains an element A[i] such
	 * that A[i] = i. If there exist many of such elements, return the index of any
	 * one of them. Returns -1 if there exists no element A[i] such that A[i] == i.
	 * n is the number of elements A contains.
	 *
	 * The running time of your algorithm is O(N). You may add a brief explanation
	 * here if you wish.
	 */

public static int match_exh(int[] A, int n) {
		
		// COMPLETE THIS METHOD.

		// You may define local variables inside this method.
	int res = 0;
		// You may add your own methods/subroutines to this file.
	for (int i = 0; i < A.length; i++) {
		if (A[i] == i) {
			res = i;
			break;
		} 
		else {
			res = -1;
		}
		
	}
		return res;
	
} // end match_exh

	/*
	 * DIVIDE-AND-CONQUER ALGORITHM Returns index i if array A contains an element
	 * A[i] such that A[i] = i. If there exist many of such elements, return the
	 * index of any one of them. Returns -1 if there exists no element A[i] such
	 * that A[i] == i. n is the number of elements A contains.
	 *
	 * The running time of your algorithm is O(log N). You may add a brief
	 * explanation here if you wish.
	 */

public static int match_dac(int[] A, int n) {
	return match_dacHelp(A, 0, n - 1, n); }
		// COMPLETE THIS METHOD.
		
		// You may define local variables inside this method.

		// You may add your own methods/subroutines to this file.
public static int match_dacHelp(int[] A, int j, int k, int n) {

	int mid = (j + k)/2;

	if (A[mid] == mid) {
		return mid;
	} 
	else if (mid < j || mid > k) {
		return -1;
	} 
	else if (A[mid] > mid) {
		return match_dacHelp(A, j, mid - 1, n);
	} 
	else {
		return match_dacHelp(A, mid + 1, k, n);
		}
	}// end match_dac
	

} // end class
