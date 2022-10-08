package com.avinash.interview;

import java.util.Arrays;

public class FindThreeLargestNumber {
	
	public static int[] findThreeLargest(int[] nums) {
		int top = Integer.MIN_VALUE;
		int mid = Integer.MIN_VALUE;
		int last = Integer.MIN_VALUE;
		
		for (int i : nums) {
			if (i > top) {
				last = mid;
				mid = top;
				top = i;
				continue;
			}
			if (i > mid && i <= top) {
				last = mid;
				mid = i;
				continue;
			}
			if (i > last && i <= mid) {
				last = i; 
			}
		}
		return new int[] {last, mid, top};
	}
	
	public static void main(String[] args) {
		int[] result = findThreeLargest(new int[] {141,1, 17,-7,-17,-27, 18, 541, 8,7,7});
		System.out.println(Arrays.toString(result));
		
		int[] findThreeLargest = findThreeLargest(new int[] {7, 8, 55});
		System.out.println(Arrays.toString(findThreeLargest));
	}
}
                                                          