package com.avinash.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {

	public static List<int[]> insert(int[][] intervals, int[] newInterval) {
		List<int[]> mergedInterval = new ArrayList<>();
		int i = 0;
		while (i < intervals.length && intervals[i][1] < newInterval[0]) {
			mergedInterval.add(intervals[i++]);
		}
		newInterval[0] = intervals[i][0];
		while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
			newInterval[1] = Math.max(intervals[i++][1], newInterval[1]);
		}
		mergedInterval.add(newInterval);
		while (i < intervals.length) {
			mergedInterval.add(intervals[i++]);
		}
		return mergedInterval;
	}

	public static void main(String[] args) {
		List<int[]> result = insert(new int[][] { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } },
				new int[] { 4, 8 });
		result.stream().map(Arrays::toString).forEach(System.out::println);

	}
}
