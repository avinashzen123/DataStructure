package com.avinash.array.binarysearch;

// https://leetcode.com/problems/arranging-coins/description/
/**
 * You have n coins and you want to build a staircase with these coins. The
 * staircase consists of k rows where the ith row has exactly i coins. The last
 * row of the staircase may be incomplete.
 * 
 * Given the integer n, return the number of complete rows of the staircase you
 * will build.
 * 
 * Input: n = 5
 * 
 * Output: 2
 * 
 * Explanation: Because the 3rd row is incomplete, we return 2.
 * 
 */
public class ArrangeCoins {

	static int arrangeCoins(int n) {
		int lo = 0;
		int hi = n;

		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			int curr = (mid * (mid + 1)) / 2;
			if (curr == n)
				return mid;
			if (curr > n) {
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}
		}
//		System.out.println(lo);
		return hi;
	}

	public static void main(String[] args) {
		System.out.println(arrangeCoins(8));
	}

}
