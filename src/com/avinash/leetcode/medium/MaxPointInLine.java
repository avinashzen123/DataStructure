package com.avinash.leetcode.medium;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MaxPointInLine {

	public static int maxPoints(int[][] points) {
		if (points.length == 1)
			return 1;
		int result = 2;
		for (int i = 0; i < points.length; i++) {
			Map<Double, Integer> map = new HashMap<>();
			for (int j = 0; j < points.length; j++) {
				if (i != j) {
					map.merge(Math.atan2(points[j][1] - points[i][1], points[j][0] - points[i][0]), 1, Integer::sum);
				}
			}
			result = Math.max(result, Collections.max(map.values()) + 1);
		}
		return result;
	}

	public static void main(String[] args) {
		int[][] points = { { 1, 1 }, { 3, 2 }, { 5, 3 }, { 4, 1 }, { 2, 3 }, { 1, 4 } };
		System.out.println(maxPoints(points));
	}
}
