package com.avinash.dynamic;

public class ContainerWIthMostWater {
	public static int maxArea(int[] height) {
		int result = 0;
		int left = 0;
		int right = height.length - 1;
		while (left < right) {
			int area = Math.abs(left - right) * Math.min(height[left], height[right]);
			result = Math.max(result, area);
			if (height[left] > height[right]) {
				right--;
			} else {
				left++;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(maxArea(new int[] {1,8,6,2,5,4,8,3,7}));
	}
}
