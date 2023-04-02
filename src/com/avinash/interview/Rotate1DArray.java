package com.avinash.interview;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/rotate-array/
 * 
 * Input: nums = [1,2,3,4,5,6,7], 
 * k = 3 
 * Output: [5,6,7,1,2,3,4] 
 * Explanation:
 * 
 * rotate 1 steps to the right: [7,1,2,3,4,5,6] 
 * rotate 2 steps to the right: [6,7,1,2,3,4,5] 
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 */
public class Rotate1DArray {
	
	static class BruteForce {
		// Time complexity : O (n * k)
		static void rotate(int[] nums, int k) {
			k %= nums.length;
			int previous = 0;
			for (int i = 0; i < k; i++) {
				previous = nums[nums.length - 1];
				for (int j = 0; j < nums.length; j++) {
					int temp = nums[j];
					nums[j] = previous;
					previous = temp;
				}
			}
		}
	}
	
	static class UsingArray {
		// Time complexity : O(n)
		static void rotate(int[] nums, int k) {
			int[] a = new int[nums.length];
			for (int i = 0; i < nums.length; i++) {
				a[(i + k) % nums.length] = nums[i];
			}
			for (int i = 0; i < nums.length; i++) {
				nums[i] = a[i];
			}
		}
	}
	
	static class UsingCyclicReplacement {
		static void rotate(int[] nums, int k) {
			k %= nums.length;
			int count = 0;
			for (int start = 0; count < nums.length; start++) {
				int current = start;
				int prev = nums[start];
				do {
					int next = (current + k) % nums.length;
					int temp = nums[next];
					nums[next] = prev;
					prev = temp;
					current = next;
					count++;
				} while(start != current);
		    }
		}
	}
	
	static class UsingReverse {
		static void rotateArray(int[] nums, int k) {
	        if (nums == null || nums.length == 0) return;
	        k%= nums.length;
	        reverse(nums, 0, nums.length - 1);
	        reverse(nums, 0, k  - 1);
	        reverse(nums, k, nums.length - 1);
	    }

		static void reverse(int[] nums, int i, int j) {
	        while(i < j) {
	            swap(nums, i, j);
	            i++;
	            j--;
	        }
	    }

		static void swap(int[] nums, int i, int j) {
	        int tmp = nums[i];
	        nums[i] = nums[j];
	        nums[j] = tmp;
	    }
	}

	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6,7};
		UsingReverse.rotateArray(array, 3);
		System.out.println(Arrays.toString(array));
		
		array = new int[] {1,2,3,4,5,6,7};
		BruteForce.rotate(array, 3);
		System.out.println(Arrays.toString(array));
		
		array = new int[] {1,2,3,4,5,6,7};
		UsingArray.rotate(array, 3);
		System.out.println(Arrays.toString(array));
		
		array = new int[] {1,2,3,4,5,6,7};
		UsingCyclicReplacement.rotate(array, 3);
		System.out.println(Arrays.toString(array));
	}
}
