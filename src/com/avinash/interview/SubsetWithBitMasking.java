package com.avinash.interview;

public class SubsetWithBitMasking {
	public static void main(String[] args) {
		showSubset(5);
	}
	// Not working
	// https://www.youtube.com/watch?v=4Mr9w0ve0y8&list=PL5DyztRVgtRVr1katnCAdGdp02nJrDHv6&index=4
	public static void showSubset(int total) {
		char arr[] = "ABCD".toCharArray();
		int numberOfElement = 3;
		while (total-- > 0) {
			int tot = 1 << numberOfElement;
			for (int mask = 0; mask < tot; mask++) {
				for (int i = 0; i < numberOfElement; i++) {
					int f = 1 << i;
					if ((numberOfElement & f) != 0) System.out.print(arr[i] + " ");
				}
			}
			System.out.println(" ");
		}
	}
}
