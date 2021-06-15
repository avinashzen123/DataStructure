package com.avinash.traversal.topologicalorder.shortestpath;
import java.util.List;
import java.util.Stack;

public class TopologicalOrdering {

	private Stack<Vertex> stack;
	
	public TopologicalOrdering(List<Vertex> graph){
		this.stack = new Stack<>();
		for (int i = 0; i < graph.size(); i++) {
			if (!graph.get(i).isVisited()) {
				dfs(graph.get(i));
			}
		}
	}
	
	public void dfs(Vertex vertex){
		vertex.setVisited(true);
		for (Edge edge: vertex.getNeighbor()) {
			if (!edge.getTarget().isVisited()) {
				dfs(edge.getTarget());
			}
		}
		this.stack.add(vertex);
	}
	
	public Stack<Vertex> getStack(){
		return this.stack;
	}
}
