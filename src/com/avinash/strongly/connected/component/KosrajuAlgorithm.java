package com.avinash.strongly.connected.component;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class KosrajuAlgorithm {

    private final List<Edge> edges;
    private int count = 0;

    public KosrajuAlgorithm(Graph graph) {
        this.edges = graph.getEdges();
        DepthFIrstOrder depthFIrstOrder = new DepthFIrstOrder(this.transposedGraph(graph));
        final Stack<Vertex> reversePost = depthFIrstOrder.getReversePost();
        while (!reversePost.isEmpty()) {
            final Vertex poppedObj = reversePost.pop();
            if (!poppedObj.isVisited()) {
                dfs(poppedObj);
                this.count++;
            }
        }
    }

    public int getCount() {
        return this.count;
    }

    private void dfs(Vertex vertex) {
        if (!vertex.isVisited()) {
            vertex.setVisited(true);
            vertex.setComponentId(this.count);
            this.edges.stream().filter(edge -> edge.getStartVertex() == vertex).map(Edge::getEndVertex).forEach(this::dfs);
        }
    }

    private Graph transposedGraph(Graph graph) {
        List<Edge> rEdgeList = new ArrayList<>();
        graph.getEdges().forEach(edge -> rEdgeList.add(new Edge(edge.getEndVertex(), edge.getStartVertex())));
        return new Graph(graph.getVertices(), rEdgeList);
    }

    public static void main(String[] args) {

        List<Vertex> vertexList = new ArrayList<>();

        vertexList.add(new Vertex("a"));
        vertexList.add(new Vertex("b"));
        vertexList.add(new Vertex("c"));
        vertexList.add(new Vertex("d"));
        vertexList.add(new Vertex("e"));
        vertexList.add(new Vertex("f"));
        vertexList.add(new Vertex("g"));
        vertexList.add(new Vertex("h"));

        List<Edge> edgeList = new ArrayList<Edge>();

        edgeList.add(new Edge(vertexList.get(0), vertexList.get(1)));
        edgeList.add(new Edge(vertexList.get(1), vertexList.get(2)));
        edgeList.add(new Edge(vertexList.get(1), vertexList.get(4)));
        edgeList.add(new Edge(vertexList.get(1), vertexList.get(5)));
        edgeList.add(new Edge(vertexList.get(2), vertexList.get(3)));
        edgeList.add(new Edge(vertexList.get(2), vertexList.get(6)));
        edgeList.add(new Edge(vertexList.get(3), vertexList.get(2)));
        edgeList.add(new Edge(vertexList.get(3), vertexList.get(7)));
        edgeList.add(new Edge(vertexList.get(4), vertexList.get(0)));
        edgeList.add(new Edge(vertexList.get(4), vertexList.get(5)));
        edgeList.add(new Edge(vertexList.get(5), vertexList.get(6)));
        edgeList.add(new Edge(vertexList.get(6), vertexList.get(5)));
        edgeList.add(new Edge(vertexList.get(7), vertexList.get(3)));
        edgeList.add(new Edge(vertexList.get(7), vertexList.get(6)));
        Graph graph = new Graph(vertexList, edgeList);
        KosrajuAlgorithm kosarajuAlgorithm = new KosrajuAlgorithm(graph);
        System.out.println(kosarajuAlgorithm.getCount());
        for (Vertex vertex : vertexList) {
            System.out.println(vertex + " - " + vertex.getComponentId());
        }

    }
    
    /**
        3
        a 2 - 2
        b 2 - 2
        c 1 - 1
        d 1 - 1
        e 2 - 2
        f 0 - 0
        g 0 - 0
        h 1 - 1
    **/
}
