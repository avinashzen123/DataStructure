package com.avinash.tree.binary.index.tree;

import java.util.Arrays;

public class InversionCountInArray {
	
	private static class TwoIterator {
		private static int getInvCount(int[] nums) {
			int invCount = 0;
			for (int i = 0; i < nums.length - 1; i++) {
				for (int j = i + 1; j < nums.length; j++) {
					if (nums[i] > nums[j]) {
						invCount++;
					}
				}
			}
			return invCount;
		}
	}
	
	private static class BinaryIndexTree {
		private int[] BITree;
		private int[] array;
		public BinaryIndexTree(int[] nums) {
			this.array = nums;
			this.BITree = new int[this.array.length + 1];
		}
		private int getSum(int index) {
			int sum = 0;
			while(index > 0) {
				sum += BITree[index];
				index -= (index & (-index));
			}
			return sum;
		}
		
		private void updateBIT(int n, int index, int val) {
			while(index <= n) {
				BITree[index] += val;
				index += (index & -index);
			}
		}
		
		private void convert(int[] arr, int n) {
			int[] temp = arr.clone();
			Arrays.sort(temp);
			for (int i = 0; i < n; i++) {
				arr[i] = lowerBound(temp, 0, n, arr[i] + 1);
			}
			
		}

		private int lowerBound(int[] temp, int low, int high, int element) {
			while (low < high) {
				int middle = low + (high - low)/2;
				if (element > temp[middle]) {
					low = middle + 1;
				} else {
					high = middle;
				}
			}
			return low;
		}
		
		private int getInvCount() {
			int invCount = 0;
			convert(this.array, this.array.length);
			System.out.println(Arrays.toString(this.array));
			for (int i = this.array.length - 1; i >= 0; i--) {
//			for (int i = 0; i < this.array.length ; i++) {
				System.out.println("Get sum of index this.array[i] - 1 " + (this.array[i] - 1) + " Value " + (this.array[i] - 1) + " " + getSum(this.array[i] - 1));
				int curSum = getSum(this.array[i] - 1);
				invCount += curSum;
				updateBIT(this.array.length, this.array[i], 1);
			}
			return invCount;
		}
	}
	
	private static class MergeSortImpl {
		/**
		 * 
		 * Time complexity : O(n * log n)
		 */
		private static int mergeSortAndCount(int[] arr, int low, int high) {
			int count = 0;
			if (low < high) {
				int middle = (low + high)/2;
				count += mergeSortAndCount(arr, low, middle);
				count += mergeSortAndCount(arr, middle + 1, high);
				count += mergeAndCount(arr, low, middle, high);
			}
			return count;
		}

		private static int mergeAndCount(int[] arr, int low, int middle, int high) {
			int[] left = Arrays.copyOfRange(arr, low, middle+1);
			int[] right = Arrays.copyOfRange(arr, middle+1, high + 1);
			
			int i = 0, j = 0, k = low, swaps = 0;
			while(i < left.length && j < right.length) {
				if (left[i] <= right[j]) {
					arr[k++] = left[i++];
				} else {
					arr[k++] = right[j++];
					swaps += (middle + 1) - (low + i);
				}
			}
			while(i < left.length) {
				arr[k++] = left[i++];
			}
			while (j < right.length) {
				arr[k++] = right[j++];
			}
			return swaps;
		}
	}
	
	public static void main(String[] args) {
		int [] arr = {8, 4, 2, 1};
		BinaryIndexTree invVount = new BinaryIndexTree(arr.clone());
		System.out.println("Number of inversions are " + invVount.getInvCount());
		System.out.println(invVount.getSum(3));
		System.out.println("Number of inversions are " + TwoIterator.getInvCount(new int[] {8, 4, 2, 1}));
		System.out.println("Number of inversions are " + MergeSortImpl.mergeSortAndCount(new int[] {8, 4, 2, 1}, 0, 3));
	}
	
	
}

