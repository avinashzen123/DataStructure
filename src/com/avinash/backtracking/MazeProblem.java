package com.avinash.backtracking;

public class MazeProblem {
	private int[][] maze;
	// 0 value or 1 value - 1 represents path (solution)
	private int[][] solution;
	private int mazeSize;

	public MazeProblem(int[][] maze) {
		this.maze = maze;
		this.mazeSize = maze.length;
		this.solution = new int[mazeSize][mazeSize];
	}

	private void solve() {
		if (solveProblem(0, 0)) {
			showSolution();
		} else {
			System.out.println("There is no solution");
		}
	}

	private boolean solveProblem(int rowIndex, int colIndex) {
		// Whether we have reached the destination
		if (isFinished(rowIndex, colIndex)) {
			return true;
		}
		if (isValid(rowIndex, colIndex)) {
			// It is valid so it is part of solution
			solution[rowIndex][colIndex] = 1;
			// GOing right
			// GO forward in the horizontal direction
			// Note : we have to increment the colIndex to move horizontally
			if (solveProblem(rowIndex, colIndex + 1)) {
				return true;
			}
			// Going down
			// Go downward in vertical direction
			// Note : We have to increment the rowINdex to move vertically
			if (solveProblem(rowIndex + 1, colIndex)) {
				return true;
			}

			if (solveProblem(rowIndex - 1, colIndex)) {
				return true;
			}
			// Back track
			solution[rowIndex][colIndex] = 0;
		}
		return false;
	}

	private boolean isFinished(int rowIndex, int colIndex) {
		if (rowIndex == mazeSize - 1 && colIndex == mazeSize - 1) {
			solution[rowIndex][colIndex] = 1;
			return true;
		}
		return false;
	}

	private boolean isValid(int rowIndex, int colIndex) {
		// We are not able to move horizontally or vertically
		if (rowIndex < 0 || rowIndex >= mazeSize) {
			return false;
		}
		if (colIndex < 0 || colIndex >= mazeSize) {
			return false;
		}
		// We have to consider obstacle
		if (maze[rowIndex][colIndex] != 1) {
			return false;
		}
		return true;
	}

	private void showSolution() {
		for (int i = 0; i < mazeSize; i++) {
			for (int j = 0; j < mazeSize; j++) {
				if (solution[i][j] == 1) {
					System.out.print("S ");
				} else {
					System.out.print("- ");
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {

		int mazeTable[][] = { { 1, 1, 1, 1 }, { 1, 1, 0, 0 }, { 0, 1, 0, 1 }, { 1, 1, 1, 1 } };

		MazeProblem problem = new MazeProblem(mazeTable);
		problem.solve();
	}
}
