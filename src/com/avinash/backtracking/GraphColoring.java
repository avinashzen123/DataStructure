package com.avinash.backtracking;

public class GraphColoring {
	private int numOfVertices;
	private int numOfColors;
	private int[] colours;
	private int[][] graph;
	
	public GraphColoring(int[][] graph, int numOfColors) {
		this.graph = graph;
		this.numOfVertices = graph[0].length;
		this.colours = new int[numOfVertices];
		this.numOfColors = numOfColors;
	}
	
	public void solve() {
		if (solveProblem(0)) {
			showSolution();
		} else {
			System.out.println("There is no solution with this parameter");
		}
	}
	
	private boolean solveProblem(int nodeIndex) {
		// If we find a color to the last node: the problem is solve
		// This is the base case for recursion
		if (nodeIndex == numOfVertices) {
			return true;
		}
		//Try all colors (color index start with 1)
		for (int colorIndex = 1; colorIndex <= numOfColors; colorIndex++) {
			if (isColorValid(nodeIndex, colorIndex)) {
				colours[nodeIndex] = colorIndex;
				if (solveProblem(nodeIndex + 1)) {
					return true;
				}
				//Otherwise backtracking so increment color index
			}
		}
		return false;
	}
	
	private boolean isColorValid(int nodeIndex, int colorIndex) {
		for (int i = 0; i < numOfVertices; i++) {
			if (graph[nodeIndex][i] == 1 && colorIndex == colours[i]) {
				return false;
			}
		}
		return true;
	}
	
	private void showSolution() {
		for (int i = 0; i < colours.length; i++) {
			System.out.println("Node " + (i + 1) + " Has color index : " + colours[i]);
		}
	}
	
	public static void main(String[] args) {
		int [][] graph = {
				{0,1,1,1,0,0},
				{1,0,1,0,1,1},
				{1,1,0,1,0,1},
				{1,1,1,0,0,1},
				{1,0,1,1,0,0},
				{0,1,1,1,1,0}
				};
		GraphColoring coloring = new GraphColoring(graph, 4);
		coloring.solve();
	}
	
}
