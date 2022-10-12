package com.avinash.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class NetworkDelay {

	/**
	 * 
	 * https://leetcode.com/problems/network-delay-time/submissions/
	 * 
	 * https://www.youtube.com/watch?v=EaphyqKU4PQ
	 * 
	 * You are given a network of n nodes, labeled from 1 to n. You are also given
	 * times, a list of travel times as directed edges times[i] = (ui, vi, wi),
	 * where ui is the source node, vi is the target node, and wi is the time it
	 * takes for a signal to travel from source to target.
	 * 
	 * We will send a signal from a given node k. Return the minimum time it takes
	 * for all the n nodes to receive the signal. If it is impossible for all the n
	 * nodes to receive the signal, return -1.
	 * 
	 * Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2 Output: 2 Example 2:
	 * 
	 * Input: times = [[1,2,1]], n = 2, k = 1 Output: 1
	 * 
	 * @param times
	 * @param n
	 * @param k
	 * @return
	 */
	public static int networkDelayTime(int[][] times, int n, int k) {
		Map<Integer, List<int[]>> edges = new HashMap<>();
		for (int[] time : times) {
			edges.computeIfAbsent(time[0], x -> new ArrayList<>()).add(new int[] { time[1], time[2] });
		}
		PriorityQueue<int[]> queue = new PriorityQueue<>((i, j) -> i[1] - j[1]);
		Set<Integer> visited = new HashSet<>();
		int time = 0;
		queue.add(new int[] { k, 0 });
		while (!queue.isEmpty()) {
			int[] edge = queue.poll();
			if (!visited.contains(edge[0])) {
				visited.add(edge[0]);
				time = Math.max(time, edge[1]);
				for (int[] nextEdge : edges.getOrDefault(edge[0], new ArrayList<>())) {
					if (!visited.contains(nextEdge[0])) {
						queue.add(new int[] { nextEdge[0], nextEdge[1] + edge[1] });
					}
				}
			}
		}
		System.out.println(time + " " + visited.size());
		return visited.size() == n ? time : -1;
	}

	public static void main(String[] args) {
		int[][] times = { { 2, 1, 1 }, { 2, 3, 1 }, { 3, 4, 1 } };
		int numNode = 4;
		int startNode = 2;
		System.out.println(networkDelayTime(times, numNode, startNode));
	}
}
