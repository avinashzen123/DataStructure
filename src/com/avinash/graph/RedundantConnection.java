package com.avinash.graph;

import java.util.Arrays;

public class RedundantConnection {

	public int[] redundantConnection(int[][] edges) {
		int[] parent = new int[edges.length + 1];
		int[] rank = new int[edges.length + 1] ;
		Arrays.fill(rank, 1);
		for (int i = 0;i < parent.length; i++) parent[i] = i;
		for (int[] edge : edges) {
			if (!union(edge[0], edge[1], parent, rank)) {
				System.out.println(Arrays.toString(parent));
				System.out.println(Arrays.toString(rank));
				return edge;
			}
		}
		return new int[] {};
	}
	
	private  int find(Integer node, int[] parent) {
		Integer pNode = parent[node];
		while (pNode != parent[pNode]) {
			parent[pNode] = parent[parent[pNode]];
			pNode = parent[pNode];
		}
		return pNode;
	}
	
	private boolean union(Integer node1, Integer node2, int[] parent, int[] rank) {
		Integer pNode1 = find(node1, parent);
		Integer pNode2 = find(node2, parent);
		if (pNode1 == pNode2) return false;
		if (rank[pNode1] > rank[pNode2]) {
			parent[pNode2] = pNode1;
			rank[pNode1] += rank[pNode2];
		} else {
			parent[pNode1] = pNode2;
			rank[pNode2] += rank[pNode1];
		}
		return true;
	}
	
	public static void main(String[] args) {
		int[] redundantConnection  = new RedundantConnection().redundantConnection(new int[][] {{1,2}, {1,3},{2,3}});
		System.out.println(Arrays.toString(redundantConnection) );
	}
}
