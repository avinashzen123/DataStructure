package com.avinash.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {
	private static class Node {
		public int val;
		public List<Node> neighbors;

		public Node(int _val) {
			val = _val;
			neighbors = new ArrayList<Node>();
		}
	}
	
	private static Map<Integer, Node> map = new HashMap<>();
	
	public Node cloneGraph(Node node) {
		if (node == null) return null;
		if (map.containsKey(node.val)) return map.get(node.val);
		Node newNode = new Node(node.val);
		map.put(node.val, newNode);
		for (Node neighbor : node.neighbors) {
			newNode.neighbors.add(cloneGraph(neighbor));
		}
		return newNode;
	}

}
