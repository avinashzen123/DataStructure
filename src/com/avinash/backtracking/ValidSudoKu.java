package com.avinash.backtracking;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidSudoKu {
	public static boolean isSudoKuValid(char[][] board) {
		Map<Integer, Set<Character>> rows = new HashMap<>();
		Map<Integer, Set<Character>> cols = new HashMap<>();
		Map<String, Set<Character>> squares = new HashMap<>();
		
		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				Character currentValue = board[row][col];
				String boardPosition = "" + row / 3 + col / 3;
				if (!Character.isDigit(currentValue)) continue;
				if ((rows.get(row) != null && rows.get(row).contains(currentValue))
						|| (cols.get(col) != null && cols.get(col).contains(currentValue))
						|| (squares.get(boardPosition) != null && squares.get(boardPosition).contains(currentValue))) {
					return false;
				}
				if (rows.get(row)== null) {
					rows.put(row, new HashSet<>());
				}
				if (cols.get(col) == null) {
					cols.put(col, new HashSet<>());
				}
				if (squares.get(boardPosition) == null) {
					squares.put(boardPosition, new HashSet<>());
				}
				rows.get(row).add(currentValue);
				cols.get(col).add(currentValue);
				squares.get(boardPosition).add(currentValue);
			}
		}

		return true;
	}

	public static void main(String[] args) {
		char[][] board = {{'5','3','.','.','7','.','.','.','.'}
		,{'6','.','.','1','9','5','.','.','.'}
		,{'.','9','8','.','.','.','.','6','.'}
		,{'8','.','.','.','6','.','.','.','3'}
		,{'4','.','.','8','.','3','.','.','1'}
		,{'7','.','.','.','2','.','.','.','6'}
		,{'.','6','.','.','.','.','2','8','.'}
		,{'.','.','.','4','1','9','.','.','5'}
		,{'.','.','.','.','8','.','.','7','9'}};

//		char[][] board = {
//						{'8','3','.','.','7','.','.','.','.'},
//						{'6','.','.','1','9','5','.','.','.'},
//						{'.','9','8','.','.','.','.','6','.'},
//						{'8','.','.','.','6','.','.','.','3'},
//						{'4','.','.','8','.','3','.','.','1'},
//						{'7','.','.','.','2','.','.','.','6'},
//						{'.','6','.','.','.','.','2','8','.'},
//						{'.','.','.','4','1','9','.','.','5'},
//						{'.','.','.','.','8','.','.','7','9'}};


		
		System.out.println(isSudoKuValid(board));
	}
}
