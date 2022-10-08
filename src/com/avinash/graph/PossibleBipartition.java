package com.avinash.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

// https://leetcode.com/problems/possible-bipartition/
public class PossibleBipartition {

	//https://youtu.be/nbgaEu-pvkU
	public boolean canBipartition(int n, int[][] dislikes) {
		Map<Integer, List<Integer>> dislikeMatrix = new HashMap<>();
		for (int[] dislike : dislikes) {
			if (!dislikeMatrix.containsKey(dislike[0])) {
				dislikeMatrix.put(dislike[0], new ArrayList<>());
			}
			if (!dislikeMatrix.containsKey(dislike[1])) {
				dislikeMatrix.put(dislike[1], new ArrayList<>());
			}
			dislikeMatrix.get(dislike[0]).add(dislike[1]);
			dislikeMatrix.get(dislike[1]).add(dislike[0]);
		}
		int[] color = new int[n + 1];
		Arrays.fill(color, -1);
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= n ; i++)  {
			if (color[i] == -1) {
				if (!bipartiteBFS(dislikeMatrix, color, queue, i)) {
					return false;
				}
			}
		}
		return true;
	}

	private boolean bipartiteBFS(Map<Integer, List<Integer>> dislikeMatrix, int[] color, Queue<Integer> queue, int i) {
		queue.add(i);
		while(!queue.isEmpty()) {
			Integer node = queue.poll();
			if (dislikeMatrix.containsKey(node)) {
				for (int dis: dislikeMatrix.get(node)) {
					if (color[dis] == -1) {
						color[dis] = 1 - color[node];
						queue.add(dis);
					} else {
						return false;
					}
				}	
			}
		}
		return true;
	}
	
	public boolean possibleBipartition(int n, int[][] dislikes) {
		Map<Integer, List<Integer>> dislikeMatrix = new HashMap<>();
		for (int[] dislike : dislikes) {
			if (!dislikeMatrix.containsKey(dislike[0])) {
				dislikeMatrix.put(dislike[0], new ArrayList<>());
			}
			if (!dislikeMatrix.containsKey(dislike[1])) {
				dislikeMatrix.put(dislike[1], new ArrayList<>());
			}
			dislikeMatrix.get(dislike[0]).add(dislike[1]);
			dislikeMatrix.get(dislike[1]).add(dislike[0]);
		}
		int[] parent = new int[n + 1];
		for (int i = 0; i < parent.length; i++) {
			parent[i] = -1;
		}
		parent[1] = 0;
		for (int i = 1; i < n; i++) {
			List<Integer> dislikeList = dislikeMatrix.get(i);
			for (Integer node : dislikeList) {
				if (parent[node] == parent[i] && parent[node] != -1 && parent[i] != -1 ) {
					return false;
				} else {
//					if (parent[node] == parent[i]) return false;
					parent[node] = parent[i] == 0 ? 1 : 0;
				}
			}
		}
		System.out.println(Arrays.toString(parent));
		int color1Count = 0;
		int color2Count = 0;
		for (int i = 1; i < parent.length; i++) {
			if (parent[i] == 0) {
				color1Count++;
			}
			if (parent[i] == 1) {
				color2Count++;
			}
		}
		return color1Count > 1 && color2Count > 1;
	}

	public static void main(String[] args) {
		boolean possibleBipartition = new PossibleBipartition().possibleBipartition(4,
				new int[][] { { 1, 2 }, { 1, 3 }, { 2, 4 } });
		System.out.println(possibleBipartition);

		boolean possibleBipartition2 = new PossibleBipartition().possibleBipartition(10,
				new int[][] { { 1, 2 }, { 3, 4 }, { 5, 6 }, { 6, 7 }, { 8, 9 }, { 7, 8 } });
		System.out.println(possibleBipartition2);

		boolean possibleBipartition3 = new PossibleBipartition().possibleBipartition(3,
				new int[][] { { 1, 2 }, { 1, 3 }, { 2, 3 } });
		System.out.println(possibleBipartition3);

		boolean possibleBipartition4 = new PossibleBipartition().possibleBipartition(5,
				new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 1, 5 } });
		System.out.println(possibleBipartition4);
		
		System.out.println(" -------- ");
		boolean canPartition = new PossibleBipartition().canBipartition(4,
				new int[][] { { 1, 2 }, { 1, 3 }, { 2, 4 } });
		System.out.println(canPartition);

		boolean canPartition1 = new PossibleBipartition().canBipartition(10,
				new int[][] { { 1, 2 }, { 3, 4 }, { 5, 6 }, { 6, 7 }, { 8, 9 }, { 7, 8 } });
		System.out.println(canPartition1);

		boolean canPartition2 = new PossibleBipartition().canBipartition(3,
				new int[][] { { 1, 2 }, { 1, 3 }, { 2, 3 } });
		System.out.println(canPartition2);

		boolean canPartition3 = new PossibleBipartition().canBipartition(5,
				new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 1, 5 } });
		System.out.println(canPartition3);
	}
}
