package com.avinash.array;

public class PartitionDisjointSet {

	/*
	 * Given an integer array nums, partition it into two (contiguous) subarrays
	 * left and right so that:
	 * 
	 * Every element in left is less than or equal to every element in right. left
	 * and right are non-empty. left has the smallest possible size. Return the
	 * length of left after such a partitioning.
	 * 
	 * Test cases are generated such that partitioning exists.
	 *
	 * Input: nums = [5,0,3,8,6] Output: 3 Explanation: left = [5,0,3], right =
	 * [8,6]
	 * 
	 * 
	 * Input: nums = [1,1,1,0,6,12] Output: 4 Explanation: left = [1,1,1,0], right =
	 * [6,12]
	 * 
	 */
	public static int partitionDisjoint(int[] nums) {
		if (nums.length == 1)
			return 0;
		int left = 0;
		while (left < nums.length - 1) {
			if (nums[0] < nums[left + 1]) {
				break;
			}
			left++;
		}
//		System.out.println(left);
		int right = nums.length - 1;
		while (right > left) {
			if (nums[nums.length - 1] > nums[right - 1]) {
				break;
			}
			right--;
		}
		return Math.max(left, right);
	}
	
	public static void main(String[] args) {
		System.out.println(partitionDisjoint(new int[] {5,0,3,8,6})); // 3	
		System.out.println(partitionDisjoint(new int[] {1,1,1,0,6,12}));
	}

}
