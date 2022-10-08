package com.avinash.graph;

public class NumberOfWaysToTraverseGraph {
	public static int numberOfWaysToTraverseGraph(int height, int width) {
		int[][] graph = new int[height+1][width+1];
		for (int row = 1; row <= height; row++) {
			for (int col = 1; col <= width; col++) {
				if (col == 1 && row == 1) {
					graph[row][col] = 1;
				} else {
					int wayLeft = graph[row][col-1];
					int wayRight = graph[row -1][col];
					graph[row][col] = wayLeft + wayRight;
				}
			}
		}
		
		return graph[height][width];
	}
	
	public static void main(String[] args) {
		System.out.println(numberOfWaysToTraverseGraph(3, 4));
	}
}
