package com.avinash.backtracking;

public class NumOfIslands {

	public int numIslands(char[][] grid) {
		int count = 0;
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[0].length; col++) {
				if (grid[row][col] == '1') {
					count ++;
					dfs(grid, row, col);
				}
			}
		}
		return count;
	}
	
	private void dfs(char[][] grid, int row, int col) {
		if (col < 0 || row < 0 || col >= grid[0].length || row >= grid.length || grid[row][col] != '1') {
			return;
		}
		grid[row][col] = '0';
		dfs(grid, row + 1, col);
		dfs(grid, row - 1, col);
		dfs(grid, row, col + 1);
		dfs(grid, row, col - 1);
	}
	
	public static void main(String[] args) {
		char[][] grid = {
		        {'1','1','1','1','0'},
		        {'1','1','0','1','0'},
		        {'1','1','0','0','0'},
		        {'0','0','0','0','0'}
		};
		NumOfIslands islands = new NumOfIslands();
		System.out.println(islands.numIslands(grid));
	}
}
