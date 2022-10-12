package com.avinash.array;

public class FindMinimumInRotatedArray {

	public static int findMin(int[] array) {
		int res = array[0];
		int left = 0; 
		int right = array.length - 1;
		while(left < right) {
			if (array[left] < array[right]) {
				res = Math.min(res, array[left]);
			}
			int middle = (left + right)/2;
			if (array[middle] > array[left]) {
				left = middle + 1;
			} else {
				right = middle - 1;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		System.out.println(findMin(new int[] {3, 4, 5, 1, 2}));
	}
}
