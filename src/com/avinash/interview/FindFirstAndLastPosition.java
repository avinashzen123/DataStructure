package com.avinash.interview;

import java.util.Arrays;

public class FindFirstAndLastPosition {
	public static int[] searchRange(int[] nums, int target) {
		if (nums.length == 1 && nums[0] == target) return new int[] {0,0};
		else if (nums.length == 2) {
			if (nums[0] == target && nums[1] != target) return new int[] {0,0};
			if (nums[0] != target && nums[1] == target) return new int[] {1,1};
			else if (nums[0] == target && nums[1] == target) return new int[] {0,1};
		}
		return searchRange(nums, target, 0, nums.length);
	}
	
	public static int[] searchRange(int[] nums, int target, int low, int high) {
//		System.out.println("Low " + low + "  High " + high);
		if (low >= high) return new int[] {-1,-1};
//		if (high <low) return new int[] {-1,-1};
		int middle = (low + high)/2;
		if (nums[middle] == target) {
			int startIndex = middle;
			while(startIndex - 1 >=0 && nums[startIndex - 1] == target) {
				startIndex--;
			}
			int endIndex = middle;
			while(endIndex + 1 < high && nums[endIndex + 1] == target) {
				endIndex ++;
			}
			return new int[] {startIndex, endIndex};
		} else if (nums[middle] > target) {
			return searchRange(nums, target, middle + 1, high);
		} else {
			return searchRange(nums, target, low, middle);
		}
	}
	
	public static void main(String[] args) {
		int[] data = {5,7,7,8,8,10};
		int target = 8;
		int[] searchRange = searchRange(data, target);
		System.out.println(Arrays.toString(searchRange));
		
		int[] data1 = {5,7,7,8,8,10};
		int target1 = 6;
		System.out.println(Arrays.toString(searchRange(data1, target1)));
		
		int[] data2 = {1,3};
		int target2 = 1;
		System.out.println(Arrays.toString(searchRange(data2, target2)));
		
		int[] data3 = {1,3};
		int target3 = 3;
		System.out.println(Arrays.toString(searchRange(data3, target3)));
		
		

		
	}
}
