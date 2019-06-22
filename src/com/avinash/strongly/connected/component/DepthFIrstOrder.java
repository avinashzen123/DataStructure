package com.avinash.strongly.connected.component;

import java.util.List;
import java.util.Stack;

public class DepthFIrstOrder {

    private final Stack<Vertex> reversePost = new Stack<>();
    private List<Edge> edges;

    public DepthFIrstOrder(Graph graph) {
        this.edges = graph.getEdges();
        graph.getVertices().forEach(this::dfs);
        graph.getVertices().forEach(vertex -> vertex.setVisited(false));
    }

    public void dfs(Vertex vertex) {
        if (!vertex.isVisited()) {
            vertex.setVisited(true);
            this.reversePost.push(vertex);
            edges.stream().filter(edge -> edge.getStartVertex() == vertex).map(Edge::getEndVertex).forEach(this::dfs);
        }
    }

    public Stack<Vertex> getReversePost() {
        return reversePost;
    }
}
