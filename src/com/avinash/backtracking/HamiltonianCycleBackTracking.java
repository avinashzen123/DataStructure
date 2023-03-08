package com.avinash.backtracking;

import java.util.Arrays;

public class HamiltonianCycleBackTracking {

	/*
     * Utility function to check if the vertex v can be added to at index 'pos' int
     * the hamiltonian cycle
     * constructed so far stored in path[]
     */
    private boolean isSafe(int vertex, int graph[][], int path[], int pos) {
        /*
         * check if this vertex is and adjacent vertex of the previously
         * added vertex
         */
        if (graph[path[pos - 1]][vertex] == 0) {
            return false;
        }
        /*
         * Check if the vertex has already been included.
         * This step can be optimized by creating an array
         * of size V
         */
        for (int i = 0; i < pos; i++) {
            if (path[i] == vertex) {
                return false;
            }
        }
        return true;
    }

    private boolean hamCycleUtil(int graph[][], int path[], int pos) {
        if (pos == graph.length) {
            if (graph[path[pos - 1]][path[0]] == 1) {
                return true;
            }
            return false;
        }
        /*
         * Try different vertices as a next candidate in Hamiltonian
         * cycle. We don't try for 0 as we included 0 as starting point
         * in hamCycle()
         */
        for (int vertex = 1; vertex < graph.length; vertex++) {
            // Check if this vertex can be added to Hamiltonian cycle
            if (isSafe(vertex, graph, path, pos)) {
                path[pos] = vertex;
                if (hamCycleUtil(graph, path, pos + 1)) {
                    return true;
                }
                // IF adding vertex v does not lead to a solution the remove it
                path[pos] = -1;
            }
        }
        /*
         * If not vertex can be added to hamiltonian cycle constructed
         * so far the return false
         */
        return false;
    }

    public void hamCycle(int graph[][]) {
        int path[] = new int[graph.length];
        Arrays.fill(path, -1);
        path[0] = 0;
        if (hamCycleUtil(graph, path, 1)) {
            showResult(path);
        } else {
            System.out.println("No solution exist");
        }
    }

    private void showResult(int[] hamiltonianPath) {
        System.out.println("Hamiltonian cycle exists");
        for (int i = 0; i < hamiltonianPath.length; i++) {
            System.out.print(hamiltonianPath[i] + " - ");
        }
        System.out.println(hamiltonianPath[0]);
    }
	public static void main(String[] args) {
		int[][] adjacencyMatrix = { { 0, 1, 0, 0, 0, 1 }, { 1, 0, 1, 0, 0, 0 }, { 0, 1, 0, 0, 1, 0 },
				{ 0, 0, 0, 0, 1, 1 }, { 0, 0, 1, 1, 0, 1 }, { 1, 0, 0, 1, 1, 0 } };

		HamiltonianCycleBackTracking backTracking = new HamiltonianCycleBackTracking();
		backTracking.hamCycle(adjacencyMatrix);
	}
}
