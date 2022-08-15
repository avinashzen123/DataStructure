package com.avinash.backtracking;

public class HamiltonianCycleBackTracking {

	private int numOfVertexes;
	private int[] hamiltonianPath;
	private int[][] adjacencyMatrix;
	
	public HamiltonianCycleBackTracking(int[][] adjacencyMatrix) {
		this.adjacencyMatrix = adjacencyMatrix;
		this.numOfVertexes = adjacencyMatrix[0].length;
		this.hamiltonianPath = new int[numOfVertexes];
	}
	
	public void solve() {
		hamiltonianPath[0] = 0;
		if (findSolution(1)) {
			showResult();
		} else {
			System.out.println("There is no solution");
		}
	}
	
	private boolean findSolution (int position) {
		// If we have considered all the vertices so end of the algorithm
		if (position == this.numOfVertexes) {
			if (adjacencyMatrix[hamiltonianPath[position - 1]][hamiltonianPath[0]] == 1) {
				return true;
			} else {
				return false;
			}
		}
		
		//Try all the possible vertexes in the graphs
		for (int vertexIndex = 1; vertexIndex < numOfVertexes; vertexIndex++) {
			if (isValid(vertexIndex, position)) {
				// Include in the vertex in hamiltonian path
				hamiltonianPath[position] = vertexIndex;
				if (findSolution(position + 1)) {
					return true;
				} 
				// Backtrack
				// Here backtracking does nothing, we just consider another vertex
			}
		}
		return false;
	}
	
	private boolean isValid(int vertex, int actualPosition) {
		// First criteria, whether the two nodes are connected or not.
		if (adjacencyMatrix[hamiltonianPath[actualPosition - 1]][vertex] == 0) {
			return false;
		}
		for (int i = 0; i < actualPosition; i ++) {
			if (hamiltonianPath[i] == vertex) {
				return false;
			}
		}
		return true;
	}
	
	private void showResult() {
		System.out.println("Hamiltonian cycle exists");
		for (int i = 0; i < hamiltonianPath.length; i++) {
			System.out.print(hamiltonianPath[i] + " - ");
		}
		System.out.println(hamiltonianPath[0]);
	}
	
	public static void main(String[] args) {
		int[][] adjacencyMatrix = {
				{0,1,0,0,0,1},
				{1,0,1,0,0,0},
				{0,1,0,0,1,0},
				{0,0,0,0,1,1},
				{0,0,1,1,0,1},
				{1,0,0,1,1,0}
		};
		
		HamiltonianCycleBackTracking backTracking  = new HamiltonianCycleBackTracking(adjacencyMatrix);
		backTracking.solve();
	}
}
