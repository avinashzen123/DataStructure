package com.avinash.linkedlist;

public class FindDuplicateInArray {

	/*
	 * [ 1, 2, 3, 4, 4 ] [ -1,-2, -3, -4, .]
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
	public static int duplicateOnImmutableArray(int[] nums) {
		int fast = nums[0];
		int slow = nums[0];
		do {
			slow = nums[slow];
			fast = nums[nums[fast]];
		} while (slow != fast);
		int slow2 = nums[0];
		while (slow2 != slow) {
			slow2 = nums[slow2];
			slow = nums[slow];
			if (slow2 == slow)
				return slow;
		}
		return slow;
	}

	public static void main(String[] args) {
		System.out.println(duplicateOnImmutableArray(new int[] { 1, 2, 3, 4, 2 }));
		System.out.println(duplicateOnImmutableArray(new int[] { 2, 3, 1, 4, 4, 2 }));
	}
}
