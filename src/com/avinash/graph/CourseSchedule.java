package com.avinash.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import lombok.Data;

public class CourseSchedule {

	/*
	 * https://leetcode.com/problems/course-schedule/
	 * 
	 * Input: numCourses = 2,
	 * 
	 * prerequisites = [[1,0]]
	 * 
	 * Output: true Explanation: There are a total of 2 courses to take. To take
	 * course 1 you should have finished course 0. So it is possible.
	 * 
	 * Input: numCourses = 2,
	 * 
	 * prerequisites = [[1,0],[0,1]]
	 * 
	 * Output: false
	 * 
	 * Explanation: There are a total of 2 courses to take. To take course 1 you
	 * should have finished course 0, and to take course 0 you should also have
	 * finished course 1. So it is impossible.
	 * 
	 */
	public static boolean canFinish(int numCourses, int[][] prerequisites) {
		List<List<Integer>> courseAdjacencies = new ArrayList<>();
		for (int i = 0; i < numCourses; i++) {
			courseAdjacencies.add(new ArrayList<>());
		}
		for (int i = 0; i < prerequisites.length; i++) {
			courseAdjacencies.get(prerequisites[i][0]).add(prerequisites[i][1]);
		}
		Set<Integer> visited = new HashSet<>();
		for (int index = 0; index < numCourses; index++) {
			if (!isCycle(courseAdjacencies, visited, index)) {
				return false;
			}
		}

		return true;
	}

	private static boolean isCycle(List<List<Integer>> adjacencies, Set<Integer> visited, int curr) {
		if (visited.contains(curr))
			return false;
		if (adjacencies.get(curr).size() == 0)
			return true;
		visited.add(curr);
		for (int prereqisite : adjacencies.get(curr)) {
			if (!isCycle(adjacencies, visited, prereqisite)) {
				return false;
			}
		}
		visited.remove(curr);
		return true;
	}

	// https://leetcode.com/problems/course-schedule-ii/
	public static int[] courseOrder2(int numCourses, int[][] prerequisites) {
		Map<Integer, List<Integer>> adjList = new HashMap<>();
		int[] indegree = new int[numCourses];
		int[] topologicalOrder = new int[numCourses];

		for (int i = 0; i < prerequisites.length; i++) {
			int post = prerequisites[i][0];
			int pre = prerequisites[i][1];
			List<Integer> list = adjList.getOrDefault(pre, new ArrayList<>());
			list.add(post);
			adjList.put(i, list);
			indegree[post]++;
		}
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < numCourses; i++) {
			if (indegree[i] == 0) {
				queue.add(i);
			}
		}
		int count = 0;
		while (!queue.isEmpty()) {
			int node = queue.poll();
			topologicalOrder[count++] = node;
			if (adjList.containsKey(node)) {
				for (Integer neighbor : adjList.get(node)) {
					indegree[neighbor]--;
					if (indegree[neighbor] == 0) {
						queue.add(neighbor);
					}
				}
			}
		}
		System.out.println(Arrays.toString(topologicalOrder));
		// If count != number of vertices it means graphs is not directed acyclic graph
		if (count == numCourses) {
			return topologicalOrder;
		}

		return new int[0];

	}

	public static void main(String[] args) {
//		System.out.println(canFinish(2, new int[][] { { 1, 0 }, { 0, 1 } }));
//		System.out.println(canFinish(2, new int[][] { { 1, 0 } }));
		System.out.println(canFinish(5, new int[][] { { 1, 4 }, { 2, 4 }, { 3, 1 }, { 3, 2 } }));
		System.out.println(courseOrder2(5, new int[][] { { 1, 4 }, { 2, 4 }, { 3, 1 }, { 3, 2 } }));
		System.out.println(courseOrder2(4, new int[][] { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } }));

	}
}
