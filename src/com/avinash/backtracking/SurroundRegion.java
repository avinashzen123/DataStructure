package com.avinash.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/surrounded-regions/
public class SurroundRegion {

	static class Pair<U, V> {
		U row;
		V col;
		Pair(U row, V col) {
			this.row = row;
			this.col = col;
		}
	}
	
	public void solve(char[][] board) {
		if (board == null || board.length == 0) return;
		int rows = board.length;
		int cols = board[0].length;
		List<Pair<Integer, Integer>> pairs = new ArrayList<>();
		for (int row = 0; row < rows; row++) {
			pairs.add(new Pair<>(row, 0));
			pairs.add(new Pair<>(row, cols -1));
		}
		for (int col = 0; col < cols; col++) {
			pairs.add(new Pair<>(0, col));
			pairs.add(new Pair<>(rows - 1, col));
		}
		pairs.stream().forEach(p -> dfs(board, p.row, p.col));
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				if (board[row][col] == 'O') {
					board[row][col] = 'X';
				}
				if (board[row][col] == 'E') {
					board[row][col] = 'O';
				}
			}
		}
	}
	
	private void dfs(char[][] board, int row, int col) {
		if (col < 0 || row < 0 || row >= board.length || col >= board[0].length || board[row][col] != 'O') {
			return;
		}
		board[row][col] = 'E';
		dfs(board, row + 1, col);
		dfs(board, row - 1, col);
		dfs(board, row, col + 1);
		dfs(board, row, col - 1);
	}

	public static void main(String[] args) {
		char[][] board = { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' },
				{ 'X', 'O', 'X', 'X' } };
		Arrays.stream(board).map(Arrays::toString).forEach(System.out::println);
		SurroundRegion region = new SurroundRegion();
		region.solve(board);
		System.out.println("---------------");
		Arrays.stream(board).map(Arrays::toString).forEach(System.out::println);
		
	}
}
