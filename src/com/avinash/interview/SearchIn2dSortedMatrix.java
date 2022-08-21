package com.avinash.interview;

public class SearchIn2dSortedMatrix {

	public static boolean search(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0)
			return false;
		int numberOfRow = matrix.length;
		int numberOfCols = matrix[0].length;
		int start = 0;
		int end = numberOfCols * numberOfRow - 1;

		while (start <= end) {
			int mid = (start + end) / 2;
			int midRow = mid / numberOfCols;
			int midCol = mid % numberOfCols;

			if (matrix[midRow][midCol] == target) {
				return true;
			} else if (matrix[midRow][midCol] < target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[][] arr = new int[][] { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 } };
		System.out.println(search(arr, 16));
	}
}
