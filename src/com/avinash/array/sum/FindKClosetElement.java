package com.avinash.array.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//https://leetcode.com/problems/find-k-closest-elements/editorial/
public class FindKClosetElement {

	static class UsingSorting {
		// Time complexity : O(N⋅log⁡(N)+k⋅log⁡(k))
		static List<Integer> findClosestElements(int[] arr, int k, int x) {

			List<Integer> list = Arrays.stream(arr).boxed()
					.sorted((i, j) -> Integer.compare(Math.abs(i - x), Math.abs(j - x)))
					.sorted(Comparator.naturalOrder()).toList();
			return list.subList(0, k);
		}
	}

	static class BinarySearchWithSlidingWindow {
		static List<Integer> findClosestElements(int[] arr, int k, int x) {
//			if (k == arr.length) {
//				return Arrays.stream(arr).boxed().toList();
//			}
//			int lo = 0;
//			int hi = arr.length - 1;
//			while (lo < hi) {
//				int mid = lo + (hi - lo) / 2;
//				if (arr[mid] >= x) {
//					hi = mid;
//				} else {
//					lo = mid + 1;
//				}
//			}
//			System.out.println("Low " + lo + " hi " + hi);
//			// Initialise sliding window
//			lo--;
//			hi = lo + 1;
//			
//			while (hi - lo + 1 < k) {
//				if (lo == -1) {
//					hi++;
//				} else {
//					if (hi == arr.length || Math.abs(arr[lo] - x) <= Math.abs(arr[hi] - x)) {
//						lo--;
//					} else {
//						hi++;
//					}
//				}
//			}
//			if (lo < 0) {
//	            lo = 0;
//	            hi += Math.abs(lo) + 1;
//	        }
//			System.out.println("Low " + lo + " hi " + hi);
//			return Arrays.stream(Arrays.copyOfRange(arr, lo, hi + 1)).boxed().toList();

			List<Integer> result = new ArrayList<Integer>();

			// Base case
			if (arr.length == k) {
				for (int i = 0; i < k; i++) {
					result.add(arr[i]);
				}

				return result;
			}

			// Binary search to find the closest element
			int lo = 0;
			int hi = arr.length;
			int mid = 0;
			while (lo < hi) {
				mid = (lo + hi) / 2;
				if (arr[mid] >= x) {
					hi = mid;
				} else {
					lo = mid + 1;
				}
			}

			// Initialize our sliding window's bounds
			lo -= 1;
			hi = lo + 1;

			// While the window size is less than k
			while (hi - lo - 1 < k) {
				// Be careful to not go out of bounds
				if (lo == -1) {
					hi += 1;
					continue;
				}

				// Expand the window towards the side with the closer number
				// Be careful to not go out of bounds with the pointers
				if (hi == arr.length || Math.abs(arr[lo] - x) <= Math.abs(arr[hi] - x)) {
					lo -= 1;
				} else {
					hi += 1;
				}
			}

			// Build and return the window
			for (int i = lo + 1; i < hi; i++) {
				result.add(arr[i]);
			}

			return result;
		}
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		int k = 4;
		int x = 3;
		System.out.println(UsingSorting.findClosestElements(arr, k, x));
		System.out.println(UsingSorting.findClosestElements(new int[] { 1, 1, 1, 10, 10, 10 }, 1, 9));
	}
}
