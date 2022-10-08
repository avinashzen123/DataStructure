package com.avinash.backtracking;

public class NQueenProblem {

	private int[][] chessTable;
	private int numOfQueues;
	
	public NQueenProblem(int numOfQueens) {
		this.numOfQueues = numOfQueens;
		this.chessTable = new int[numOfQueens][numOfQueens];
	}
	
	public void solve() {
		if (setQueen(0)) {
			printQueens();
		} else {
			System.out.println("There is no solution");
		}
	}
	
	public boolean setQueen(int colIndex) {
		if (colIndex == numOfQueues) {
			return true;
		}
		for (int rowIndex = 0; rowIndex < numOfQueues; rowIndex ++) {
			if (isPlaceValid(rowIndex, colIndex)) {
				//The location is valid (1 means there is a queen
				chessTable[rowIndex][colIndex] = 1; 
				
				//Solve the problem for next column
				if (setQueen(colIndex + 1)) {
					return true;
				} else {
					// Backtrack
					chessTable[rowIndex][colIndex] = 0;
				}
			}
		}
		// Can not fin a valid location (We have tried all the rows without success)
		// Have to change the position of already settled queens.
		return false;
	}
	
	private boolean isPlaceValid(int rowIndex, int colIndex) {
		// There can not be other queens in the same row
		for (int i = 0; i < colIndex; i++) {
			if (chessTable[rowIndex][i] == 1) {
				return false;
			}
		}
		// We do not have to check columns
		// Check the diagonal
		// Diagonal location from top left to bottom right
//		for (int i = rowIndex, j = colIndex; i >= 0 && j >= 0 ; i--, j--) {
//			if (chessTable[i][j] == 1) {
//				return false;
//			}
//		}
//		
//		// Diagonal from top right to bottom left
//		for (int i = rowIndex, j = colIndex; i < chessTable.length && j >= 0; i++, j--) {
//			if (chessTable[i][j] == 1) {
//				return false;
//			}
//		}
		
		for (int c = 0; c < chessTable.length; c++) {
            if (chessTable[rowIndex][c] == 1) {
                return false;
            }
        }
        for (int r = rowIndex, c = colIndex; r >= 0 && c < chessTable[0].length; r--, c ++) {
            if (chessTable[r][c] == 1) {
                return false;
            }
        }
        for (int r = rowIndex, c = colIndex; r < chessTable.length && c >= 0; r++, c--) {
            if (chessTable[r][c] == 1) {
                return false;
            }
        }
        for (int r = rowIndex, c = colIndex; r < chessTable.length && c < chessTable.length; r++, c++) {
            if (chessTable[r][c] == 1) {
                return false;
            }
        }
        for (int r = rowIndex, c = colIndex; r >= 0 && c >= 0; r--, c--) {
            if (chessTable[r][c] == 1) {
                return false;
            }
        }
		// The position (rowIndex, colIndex) is valid there is no collision.
		return true;
	}
	
	// 1 Represents Queen
	// 0 means that cell is empty
	public void printQueens() {
		for (int i = 0; i < chessTable.length; i++) {
			for (int j = 0; j < chessTable.length; j++) {
				if (chessTable[i][j] == 1) {
					System.out.print(" * ");
				} else {
					System.out.print(" - ");
				}
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		NQueenProblem nQueenProblem = new NQueenProblem(4);
		nQueenProblem.solve();
	}
}
