package com.avinash.backtracking;

interface Constant {
	Integer BOARD_SIZE = 9;
	Integer MIN_NUMBER = 1;
	Integer MAX_NUMBER = 9;
	Integer BOX_SIZE = 3;
}

public class SudoKu {
	private int[][] sudokuTable;

	public SudoKu(int[][] sudokuTable) {
		this.sudokuTable = sudokuTable;
	}

	public void solveProblem() {
		if (solve(0, 0)) {
			showSolution();
		} else {
			System.out.println("there is no solution");
		}
	}

	private boolean solve(int rowIndex, int colIndex) {
		if (rowIndex == Constant.BOARD_SIZE) {
			colIndex++;
			// We considered all the cells - end of algorithm
			if (colIndex == Constant.BOARD_SIZE) {
				return true;
			} else {
				// Hop to the next column so reinitialize rowIndex = 0
				rowIndex = 0;
			}
		}
		// Skip filled cells
		if (sudokuTable[rowIndex][colIndex] != 0) {
			return solve(rowIndex + 1, colIndex);
		}

		// Consider all the number from 1-9
		for (int num = Constant.MIN_NUMBER; num <= Constant.MAX_NUMBER; ++num) {
			if (isValid(rowIndex, colIndex, num)) {
				sudokuTable[rowIndex][colIndex] = num;
				if (solve(rowIndex + 1, colIndex)) {
					return true;
				} else {
					// Back track
					sudokuTable[rowIndex][colIndex] = 0;
				}
			}
		}
		return false;
	}

	private boolean isValid(int rowIndex, int colIndex, int num) {
		// If the given number is already in the column : the number
		// Can not be part of solution
		for (int i = 0; i < Constant.BOARD_SIZE; i++) {
			if (sudokuTable[i][colIndex] == num) {
				return false;
			}
		}
		// If the number is already in the row: the number
		// Can not be part of solution.
		for (int j = 0; j < Constant.BOARD_SIZE; j++) {
			if (sudokuTable[rowIndex][j] == num) {
				return false;
			}
		}

		// If the given number is already in the box, the number
		// Can not be part of the solution.
		int boxRowOffSet = (rowIndex / 3) * Constant.BOX_SIZE;
		int boxColumnOffset = (colIndex / 3) * Constant.BOX_SIZE;
		for (int i = 0; i < Constant.BOX_SIZE; i++) {
			for (int j = 0; j < Constant.BOX_SIZE; j++) {
				if (sudokuTable[boxRowOffSet + i][boxColumnOffset + j] == num) {
					return false;
				}
			}
		}
		return true;
	}

	private void showSolution() {
		for (int i = 0; i < Constant.BOARD_SIZE; i++) {
			if (i % 3 == 0)
				System.out.println(" ");
			for (int j = 0; j < Constant.BOARD_SIZE; j++) {
				if (j % 3 == 0)
					System.out.print(" ");
				System.out.print(sudokuTable[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] sudokuTable = { 
				{ 3, 0, 6, 5, 0, 8, 4, 0, 0 }, 
				{ 5, 2, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 8, 7, 0, 0, 0, 0, 3, 1 }, 
				{ 0, 0, 3, 0, 1, 0, 0, 8, 0 }, 
				{ 9, 0, 0, 8, 6, 3, 0, 0, 5 },
				{ 0, 5, 0, 0, 9, 0, 6, 0, 0 }, 
				{ 1, 3, 0, 0, 0, 0, 2, 5, 0 }, 
				{ 0, 0, 0, 0, 0, 0, 0, 7, 4 },
				{ 0, 0, 5, 2, 0, 6, 3, 0, 0 } };

		SudoKu ku = new SudoKu(sudokuTable);
		ku.solveProblem();
	}
}
