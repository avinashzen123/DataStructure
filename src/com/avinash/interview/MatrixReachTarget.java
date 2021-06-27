package com.avinash.interview;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MatrixReachTarget {
	public static int count = 0;
	public static void main(String[] args) {
//		int[][] matrix = { { 1, 1, 0 }, { 0, 1, 0 }, { 1, 2, 0 } };
//		int[][] matrix = { { 1, 0, 1, 0 }, { 1, 1, 1, 0 }, { 0, 0, 2, 0 } };
        int matrix[][] = { 
        		{ 2, 3, 0, 1 },
                { 3, 0, 3, 3 },
                { 2, 3, 3, 3 },
                { 0, 3, 3, 3 } };
		int[][] path = new int[matrix.length][];
		IntStream.range(0, matrix.length).forEach(i -> path[i] = new int[matrix[i].length]);
		Arrays.stream(path).forEach(arr -> Arrays.fill(arr, 0));
		findPath(matrix, path, 0, 0);
		System.out.print(Arrays.stream(path).map(arr -> Arrays.toString(arr)).collect(Collectors.joining("\n")));
		System.out.println(count);
	}

	public static int[][] findPath(int[][] matrix, int[][] path, int i, int j) {
		if (i < 0 || j < 0 || i >= matrix.length || j >= matrix.length) {
			return path;
		}
		count++;
		if (matrix[i][j] == 0 ) {
			return null;
		}
		if (findPath(matrix, path, i + 1, j) != null) {
			path[i][j] = path[i][j] + 1;
		}

		if (findPath(matrix, path, i, j + 1) != null) {
			path[i][j] = path[i][j] + 1;
		}

		return path;
	}
}
