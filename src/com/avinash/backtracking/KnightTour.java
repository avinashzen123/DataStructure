package com.avinash.backtracking;

public class KnightTour {
	private int[][] chessTable;
	private int boardSize;
	private int[] xMoves = { 2, 1, -1, -2, -2, -1, 1, 2 };
	private int[] yMoves = { 1, 2, 2, 1, -1, -2, -2, -1 };

	public KnightTour(int boardSize) {
		this.boardSize = boardSize;
		this.chessTable = new int[boardSize][boardSize];
		initializeChessTable();
	}

	private void initializeChessTable() {
		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				chessTable[i][j] = Integer.MIN_VALUE;
			}
		}
	}

	public void solve() {
		// Initial value (0,0)
		chessTable[0][0] = 0;
		if (solveProblem(1, 0, 0)) {
			showSolution();
		} else {
			System.out.println("There is no solution");
		}
	}

	public boolean solveProblem(int stepCount, int x, int y) {
		// base condition
		// this when we have considered all cells of the chess board
		if (stepCount == boardSize * boardSize) {
			return true;
		}
		for (int moveIndex = 0; moveIndex < xMoves.length; moveIndex++) {
			int nextX = x + xMoves[moveIndex];
			int nextY = y + yMoves[moveIndex];

			if (isValid(nextX, nextY)) {
				chessTable[nextX][nextY] = stepCount;
				if (solveProblem(stepCount + 1, nextX, nextY)) {
					return true;
				}
				// Can not solve problem so we backtrack
				// Remove from solution "Backtracking"
				chessTable[nextX][nextY] = Integer.MIN_VALUE;
			}
		}
		return false;
	}

	private boolean isValid(int x, int y) {
		// Can not leave the board horizontally and vertically
		if (x < 0 || x >= boardSize)
			return false;
		if (y < 0 || y >= boardSize)
			return false;
		return chessTable[x][y] == Integer.MIN_VALUE;
	}

	private void showSolution() {
		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				System.out.print(this.chessTable[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		KnightTour knightTour = new KnightTour(8);
		knightTour.solve();
	}
}
