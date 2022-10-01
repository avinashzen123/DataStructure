package com.avinash.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ZigZagTraversal {
	public static List<Integer> zigzagTraverse(List<List<Integer>> array) {
		// Write your code here.
		List<Integer> result = new ArrayList<>();
		int height = array.size() - 1;
		int width = array.get(0).size() - 1;
		int row = 0;
		int col = 0;
		boolean goingDown = true;
		while (!isOutOfBound(row, col, height, width)) {
			result.add(array.get(row).get(col));
			if (goingDown) {
				if (col == 0 || row == height) {
					goingDown = false;
					if (row == height) {
						col = col + 1;
					} else {
						row = row + 1;
					}
				} else {
					row = row + 1;
					col = col - 1;
				}
			} else {
				if (row == 0 || col == width) {
					goingDown = true;
					if (col == width) {
						row += 1;
					} else {
						col += 1;
					}
				} else {
					row -= 1;
					col += 1;
				}
			}
		}
		return result;
	}

	private static boolean isOutOfBound(int row, int col, int height, int width) {
		return row < 0 || row > height || col < 0 || col > width;
	}
	
	public static void main(String[] args) {
		int[][] array = {
		                 {1, 3, 4, 10},
		                 {2, 5, 9, 11},
		                 {6, 8, 12, 15},
		                 {7, 13, 14, 16}
		               };
		List<List<Integer>> list = new ArrayList<>();
		for (int[] ar : array) {
			list.add(Arrays.stream(ar).boxed().collect(Collectors.toList()));
		}
		System.out.println(zigzagTraverse(list));
	}
}
