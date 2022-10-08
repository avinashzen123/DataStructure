package com.avinash.traversal.topologicalorder.shortestpath;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class TopologicalSort {

	public static List<Integer> topologicalSort(List<Integer> jobs, List<Integer[]> deps) {
		Map<Integer, List<Integer>> graph = new HashMap<>();
		int[] indegree;
		Queue<Integer> queue = new LinkedList<>();
		List<Integer> result = new LinkedList<>();
		int visitedNodes = 0;

		if (jobs.get(0) == 0) {
			indegree = new int[jobs.size()];
		} else {
			indegree = new int[jobs.size() + 1];
		}
		for (Integer[] dep : deps) {
			graph.computeIfAbsent(dep[1], x -> new ArrayList<>()).add(dep[0]);
			indegree[dep[0]]++;
		}
		for (int index = 0; index < indegree.length; index++) {
			if (jobs.get(0) != 0 && index == 0)
				continue;
			if (indegree[index] == 0) {
				queue.add(index);
			}
		}
		while (!queue.isEmpty()) {
			visitedNodes++;
			Integer curNode = queue.poll();
			result.add(curNode);
			for (Integer next : graph.getOrDefault(curNode, new ArrayList<>())) {
				if (--indegree[next] == 0) {
					queue.add(next);
				}
			}
		}
		Collections.reverse(result);
		System.out.println(result);
		return visitedNodes == jobs.size() ? result : new ArrayList<>();
	}

	public static void main(String[] args) {
		List<Integer> jobs = List.of(1, 2, 3, 4);
		List<Integer[]> deps = List.of(new Integer[] { 1, 2 }, new Integer[] { 1, 3 }, new Integer[] { 3, 2 },
				new Integer[] { 4, 2 }, new Integer[] { 4, 3 });
		topologicalSort(jobs, deps);

		deps = List.of(new Integer[] { 3, 1 }, new Integer[] { 8, 1 }, new Integer[] { 8, 7 }, new Integer[] { 5, 7 },
				new Integer[] { 5, 2 }, new Integer[] { 1, 4 }, new Integer[] { 1, 6 }, new Integer[] { 1, 2 },
				new Integer[] { 7, 6 });
		jobs = List.of(1, 2, 3, 4, 5, 6, 7, 8);
		topologicalSort(jobs, deps);
	}
}
