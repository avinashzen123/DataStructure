package com.avinash.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;

import static java.lang.Math.abs;

// https://www.youtube.com/watch?v=f7JOBJIC-NA
// https://leetcode.com/problems/min-cost-to-connect-all-points/
// Prims implementation can be implemented using Kruskal algorighm
public class MinCosToConnectAllNode {
	
	@Data
	@AllArgsConstructor
	private static class Point implements Comparable<Point> {
		private int node;
		private int distance;
		
		public int compareTo(Point p) {
			return this.distance - p.distance;
		}
		@Override
		public int hashCode() {
			return node;
		}
		@Override
		public boolean equals(Object o) {
			Point other = (Point)o;
			return this.node == other.node;
		}
	}
	
	public static int minCostConnectPoints(int[][] points) {
		int n = points.length;
		Map<Integer, List<Point>> adj = new HashMap<>();
		for (int i = 0; i < n ; i++) {
			int x1 = points[i][0];
			int y1 = points[i][1];
			for (int j = i + 1; j < n ; j++) {
				int x2 = points[j][0];
				int y2 = points[j][1];
				int dist = abs(x1 - x2) + abs(y1 - y2);
				adj.computeIfAbsent(i, x -> new ArrayList<>()).add(new Point(j, dist));
				adj.computeIfAbsent(j, x -> new ArrayList<>()).add(new Point(i, dist));
			}
		}
		int result = 0;
		Set<Integer> visited = new HashSet<>();
		PriorityQueue<Point> minHeap = new PriorityQueue<>();
		minHeap.add(new Point(0,0));
		while (visited.size() < n && !minHeap.isEmpty()) {
			Point curPoint = minHeap.poll();
			if (!visited.contains(curPoint.getNode())) {
				result += curPoint.getDistance();
				System.out.println("Visiting node " + curPoint.getNode());
				visited.add(curPoint.getNode());
				for (Point point : adj.get(curPoint.getNode())) {
					if (!visited.contains(point.getNode())) {
						minHeap.remove(point);
						minHeap.add(point);
					}
				}
			}
		}
		return result;
	}
	
	// https://youtu.be/Yj_M41fT-X8
	public static int minCostToConnectAllPoints1(int[][] points) {
		int n = points.length;
		int minCost = 0;
		int edgeUsed = 0;
		boolean[] visited = new boolean[points.length];
		int[] minDist = new int[n];
		Arrays.fill(minDist, Integer.MAX_VALUE);
		minDist[0] = 0;
		while(edgeUsed++ < n) {
			int curNode = -1;
			int curMinDist = Integer.MAX_VALUE;
			for (int node = 0; node < n; node ++) {
				if (!visited[node] && minDist[node] < curMinDist) {
					curNode = node;
					curMinDist = minDist[node];
				}
			}
			minCost += curMinDist;
			visited[curMinDist] = true;
			for (int nextNode = 0; nextNode < n; nextNode++) {
				int weight = Math.abs(points[curNode][0] - points[nextNode][0])
							+ Math.abs(points[curNode][1] - points[curNode][1]);
				if (!visited[nextNode] && minDist[nextNode] > weight) {
					minDist[nextNode] = weight;
				}
			}
		}
		return minCost;
	}
	
	public static void main(String[] args) {
		System.out.println(minCostConnectPoints(new int[][] {{0,0},{2,2},{3,10},{5,2},{7,0}}));
	}
}
