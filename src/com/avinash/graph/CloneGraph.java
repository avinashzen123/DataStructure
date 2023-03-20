package com.avinash.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


// https://leetcode.com/problems/clone-graph/editorial/
public class CloneGraph {
	static class Node {
		public int val;
		public List<Node> neighbors;

		public Node(int _val) {
			val = _val;
			neighbors = new ArrayList<Node>();
		}
	}
	
	static class DFS {
		HashMap<Node, Node> visited = new HashMap<>();
		
		public Node cloneGraph(Node node) {
			if (node == null) return null;
			if (visited.containsKey(node)) {
				// If node was already visited before. Return the clone from the visited dictionary
				return visited.get(node);
			}
			//Create a clone for the given node. Note that we don't have cloned neighbours as of now
			Node cloneNode = new Node(node.val);
			// The key is original node and value is cloned node
			visited.put(node, cloneNode);
			// Iterate through the neighbours to generate their cloned 
			// and prepare a list of clone neighbours to add to the cloned nodes
			for (Node neighbour : node.neighbors) {
				cloneNode.neighbors.add(cloneGraph(neighbour));
			}
			return cloneNode;
		}
	}
	
	static class BFS {
		public Node cloneGraph(Node node) {
			if (node == null) return null;
			HashMap<Node, Node> visited = new HashMap<>();
			Queue<Node> queue = new LinkedList<>();
			queue.add(node);
			visited.put(node, new Node(node.val));
			while(!queue.isEmpty()) {
				node = queue.poll();
				for (Node neighbour : node.neighbors) {
					if (!visited.containsKey(neighbour)) {
						visited.put(neighbour, new Node(neighbour.val));
						queue.add(neighbour);
					}
					visited.get(node).neighbors.add(visited.get(neighbour));
				}
			}
			return visited.get(node);
		}
	}
	

}
