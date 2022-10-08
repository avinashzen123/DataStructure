package com.avinash.interview;

public class CanJumpGreedy {

	public static boolean canJump(int[] nums) {
		int goal = nums.length - 1;
		for (int i = nums.length - 1; i >=0; i--) {
			if (nums[i] + i >= goal) {
				goal = i;
			}
		}
		return goal == 0;
	}
	
	public static void main(String[] args) {
		System.out.println(canJump(new int[] {2,3,1,1,4}));
		System.out.println(canJump(new int[] {3,2,1,0,4}));
	}
}
