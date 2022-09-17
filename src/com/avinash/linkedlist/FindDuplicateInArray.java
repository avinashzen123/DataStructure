package com.avinash.linkedlist;

public class FindDuplicateInArray {

	/*
	 * [ 1, 2, 3, 4, 4 ]
	 * [ -1,-2, -3, -4, .]
	 */
	public static int duplicateOnMutableArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			int val = array[i];
			if (array[Math.abs(val)] < 0) {
				return Math.abs(val);
			}
			array[Math.abs(val)] = -array[Math.abs(val)];
		}
		return -1;
	}

	// https://www.youtube.com/watch?v=dfIqLxAf-8s
	public static int duplicateOnImmutableArray(int[] array) {
	
		return -1;
	}
	
	public static void main(String[] args) {
		System.out.println(duplicateOnMutableArray(new int[] { 1, 2, 3, 4, 2 }));
	}
}
