package com.avinash.interval;

import java.util.Arrays;

public class NonOverlappingInterval {
	public static int eraseOverlapIntervals1(int[][] intervals) {
		Arrays.sort(intervals, (i, j) -> i[0] - j[0]);
		int result = 0;
		int[] prevInterval = intervals[0];
		for (int i = 1; i < intervals.length; i++) {
			int[] curInterval = intervals[i];
			if (curInterval[0] >= prevInterval[1]) {
				prevInterval = curInterval;
			} else {
				result++;
				if (prevInterval[1] > curInterval[1]) {
					prevInterval = curInterval;
				}
			}
			
		}
		return result;
	}

	public static int eraseOverlapIntervals(int[][] intervals) {
		int intervalsRemoved = 0;

		Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));

		int[] prevInterval = intervals[0];

		for (int i = 1; i < intervals.length; i++) {
			int[] curInterval = intervals[i];
			if (curInterval[0] < prevInterval[1]) {
				// mark first interval to be removed
				intervalsRemoved++;
				// determine which interval to remove
				// remove the interval that ends last
				if (prevInterval[1] > curInterval[1]) {
					prevInterval = curInterval;
				}
			} else {
				prevInterval = intervals[i];
			}
		}
		return intervalsRemoved;
	}


	public static void main(String[] args) {
		int[][] intervals = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 } };
		System.out.println(eraseOverlapIntervals(intervals));
		System.out.println(eraseOverlapIntervals1(intervals));
	}

}
