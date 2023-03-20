package com.avinash.heap;

import java.util.Arrays;

public class MergeSortedArrays {

	static class UsingThreePointer {
		static void merge(int[] nums1, int m, int[] nums2, int n) {
			int[] nums1Copy = nums1.clone();
			int p1 = 0;
			int p2 = 0;
			
			for (int p = 0; p < m + n; p++) {
				if (p2 >= n || (p1 < m && nums1Copy[p1] < nums2[p2])) {
					nums1[p] = nums1Copy[p1++];
				} else {
					nums1[p] = nums2[p2++];
				}
			}
		}
		
		static void merge1(int[] nums1, int m, int[] nums2, int n) {
			int p1 = m - 1;
			int p2 = n - 1;
			for (int p = m + n - 1; p >= 0; p--) {
				if (p2 < 0) break;
				if (p1 >= 0 && nums1[p1] > nums2[p2]) {
					nums1[p] = nums1[p1--];
				} else {
					nums1[p] = nums2[p2--];
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] nums1 = {1,2,3,0,0,0};
		int m = 3;
		int[] nums2 = {2,5,6};
		int n = 3;
		UsingThreePointer.merge1(nums1, m, nums2, n);
		System.out.println(Arrays.toString(nums1));
		System.out.println(Arrays.toString(nums2));
	}
}
