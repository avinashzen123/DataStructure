package com.avinash.array.binarysearch;

// https://leetcode.com/problems/arranging-coins/description/
public class ArrangeCoins {

	static int arrangeCoins(int n) {
		int lo = 0;
		int  hi = n;
		
		while(lo <= hi) {
			int mid = lo + (hi -lo) / 2;
			int curr = mid * (mid + 1) / 2;
			if (curr == n) return mid;
			if (curr > n) {
				hi = mid - 1;
			} else{
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
