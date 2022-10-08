package com.avinash.dynamic;

// https://youtu.be/ZI2z5pq0TqA
public class TrappingRainWater {
	public int solve(int[] heights) {
		// Less than 3 we can 
		if (heights.length < 3) return 0;
		
		int[] leftMax =new int[heights.length];
		int[] rightMax = new int[heights.length];
		leftMax[0] = 0;
		for (int i = 1; i < leftMax.length; i++) {
			leftMax[i] = Math.max(leftMax[i-1], heights[i-1]);
		}
		rightMax[rightMax.length - 1] = 0;
		for (int i = rightMax.length - 2; i >=0; i--) {
			rightMax[i] = Math.max(rightMax[i+1], heights[i+1]);
		}
		int trapped = 0;
		for (int i = 0; i < heights.length; i++) {
			if (Math.min(leftMax[i], rightMax[i]) > heights[i]) {
				trapped += Math.min(leftMax[i], rightMax[i]) - heights[i]; 
			}
		}
		return trapped;
	}
	
	public static void main(String[] args) {
//		int[] heights = {2,1,3,1,4};
		int[] heights = {4,1,3,1,5};
		TrappingRainWater rainWater = new TrappingRainWater();
		System.out.println(rainWater.solve(heights));
	}
}
