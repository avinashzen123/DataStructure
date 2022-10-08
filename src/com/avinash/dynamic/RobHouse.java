package com.avinash.dynamic;

//https://leetcode.com/problems/house-robber/
public class RobHouse {
	public static int robHouse(int[] array) {
		int rob1 = 0, rob2 = 0;
		for (int amount: array) {
			int temp = Math.max(amount + rob1, rob2);
			rob1 = rob2;
			rob2 = temp;
		}
		return rob2;
	}
	
	public static void main(String[] args) {
		System.out.println(robHouse(new int[] {1,2,3,1}));
	}
}
