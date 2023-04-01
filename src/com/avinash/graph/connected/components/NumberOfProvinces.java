package com.avinash.graph.connected.components;

public class NumberOfProvinces {
	public int findCircleNum(int[][] isConnected) {
		int count = 0;
		boolean visited[] = new boolean[isConnected.length];
		for (int vertex = 0; vertex < isConnected.length; vertex++) {
			if (!visited[vertex]) {
				dfs(isConnected, visited, vertex);
				count ++;
			}
		}
		return count;
	}

	private void dfs(int[][] isConnected,  boolean[] visited, int vertex) {
		for (int targetVertex = 0; targetVertex < isConnected[vertex].length; targetVertex++) {
			if (isConnected[vertex][targetVertex] == 1 && !visited[targetVertex]) {
				visited[targetVertex] = true;
				dfs(isConnected, visited, targetVertex);
			}
		}
	}

	public static void main(String[] args) {
		int[][] array = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
		NumberOfProvinces numberOfProvinces = new NumberOfProvinces();
		System.out.println(numberOfProvinces.findCircleNum(array));
		
		int[][] array1 = {{1,0,0},{0,1,0},{0,0,1}};
		System.out.println(numberOfProvinces.findCircleNum(array1));
	}
}