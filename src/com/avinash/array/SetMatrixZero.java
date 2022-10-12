package com.avinash.array;

import java.util.Arrays;

public class SetMatrixZero {

	public void setZeroes(int[][] matrix) {
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[0].length; col++) {
				if (matrix[row][col] == 0) {
					matrix[row][col] = -1;
				}
			}
		}
		System.out.println("------------");
		Arrays.stream(matrix).map(Arrays::toString).forEach(System.out::println);
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[row].length; col++) {
				if (matrix[row][col] == -1) {
					makeColumnZero(matrix, col);
					makeRowZero(matrix, row);
				}
			}
		}
		
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[0].length; col++) {
				if (matrix[row][col] == -1) {
					matrix[row][col] = 0;
				}
			}
		}

	}

	private void makeColumnZero(int[][] matrix, int col) {
		for (int row = 0; row < matrix.length; row++) {
			matrix[row][col] = matrix[row][col] == -1 ? -1 : 0;
		}
	}

	private void makeRowZero(int[][] matrix, int row) {
		for (int col = 0; col < matrix[row].length; col++) {
			matrix[row][col] = matrix[row][col] == -1 ? -1 :0;
		}
	}
	
	public static void main(String[] args) {
		int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
		Arrays.stream(matrix).map(Arrays::toString).forEach(System.out::println);
		new SetMatrixZero().setZeroes(matrix);
		System.out.println("-----------");
		Arrays.stream(matrix).map(Arrays::toString).forEach(System.out::println);
	}
}
