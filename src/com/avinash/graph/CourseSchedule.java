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
		int indegree[] = new int[numCourses];
		Queue<Integer> queue = new LinkedList<>();
		int courseOrder[] = new int[numCourses];
		int count = 0;
		
		for (int i = 0; i < numCourses; i++) {
			adjList.put(i, new ArrayList<>());
		}
		
		for (int edge[] : prerequisites) {
			int course = edge[0];
			int coursePrereq = edge[1];
			indegree[course]++;
			adjList.get(coursePrereq).add(course);
		}
		for (int i = 0; i < numCourses; i++) {
			if (indegree[i] == 0) {
				queue.add(i);
			}
		}
		while(!queue.isEmpty()) {
			int course = queue.poll();
			courseOrder[count++] = course;
			if (adjList.containsKey(course)) {
				for (int neighbour : adjList.get(course)) {
					indegree[neighbour]--;
					if (indegree[neighbour] == 0) {
						queue.add(neighbour);
					}
				}
			}
		}
		if (count == numCourses) return courseOrder;
		return new int[] {};
	}
	
	//https://leetcode.com/problems/course-schedule-iii/solution/
	public static int course3() {
		return -1;
	}

	public static void main(String[] args) {
//		System.out.println(canFinish(2, new int[][] { { 1, 0 }, { 0, 1 } }));
//		System.out.println(canFinish(2, new int[][] { { 1, 0 } }));
//		System.out.println(canFinish(5, new int[][] { { 1, 4 }, { 2, 4 }, { 3, 1 }, { 3, 2 } }));
		System.out.println(Arrays.toString(courseOrder2(5, new int[][] { { 1, 4 }, { 2, 4 }, { 3, 1 }, { 3, 2 } })));
		System.out.println(Arrays.toString(courseOrder2(4, new int[][] { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } })));
		System.out.println(Arrays.toString(courseOrder2(2, new int[][] { { 1, 0 }, { 0, 1 } })));
		System.out.println(Arrays.toString(courseOrder2(2, new int[][] {{ 0, 1 } })));

	}
}
