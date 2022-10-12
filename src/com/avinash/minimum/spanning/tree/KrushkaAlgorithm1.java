package com.avinash.minimum.spanning.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lombok.Data;
import lombok.RequiredArgsConstructor;

public class KrushkaAlgorithm1 {
    @Data
    @RequiredArgsConstructor
    private static class Vertex {
        private final String name;
        private Node node;
    }

    @Data
    @RequiredArgsConstructor
    private static class Node {
        private final int id;
        private Node parentNode;
        private int rank;
    }

    @Data
    @RequiredArgsConstructor
    private static class Edge implements Comparable<Edge> {
        private final Vertex startVertex, endVertex;
        private final double weight;

        public int compareTo(Edge o) {
            return Double.compare(this.weight, o.weight);
        }

        @Override
        public String toString() {
            return this.startVertex.getName() +  "-" + this.endVertex.getName();
        }
    }

    private static class DisjointSet {
        private List<Node> rootNodes = new ArrayList<>();

        private DisjointSet(List<Vertex> vertices) {
            vertices.forEach(this::makeSet);
        }

        private void makeSet(Vertex vertex) {
            final Node node = new Node(this.rootNodes.size());
            vertex.setNode(node);
            this.rootNodes.add(node);
        }

        private int find(Vertex vertex) {
            Node currNode = vertex.getNode();
            while(currNode.getParentNode() != null) {
                currNode = currNode.getParentNode();
            }
            final Node rootNode = currNode;
            currNode = vertex.getNode();
            while(rootNode != currNode) {
                Node parentNode = currNode.getParentNode();
                currNode.setParentNode(rootNode);
                currNode = parentNode;
            }
            return rootNode.getId();
        }

        private void union(Vertex vertex1, Vertex vertex2) {
            final int index1 = find(vertex1);
            final int index2 = find(vertex2);
            if (index1 == index2) {
                return;
            }
            if (vertex1.getNode().getRank() < vertex2.getNode().getRank()) {
                vertex1.getNode().setParentNode(vertex2.getNode());
            } else if (vertex1.getNode().getRank() > vertex2.getNode().getRank()) {
                vertex2.getNode().setParentNode(vertex1.getNode());
            } else {
                vertex1.getNode().setParentNode(vertex2.getNode());
                vertex2.getNode().setRank(vertex2.getNode().getRank() + 1);

            }
        }
    }

    public KrushkaAlgorithm1(List<Vertex> vertices, List<Edge> edges) {
        DisjointSet disjointSet = new DisjointSet(vertices);
        List<Edge> mst = new ArrayList<>();
        Collections.sort(edges); 
        for (Edge edge: edges) {
            if (disjointSet.find(edge.getStartVertex()) != disjointSet.find(edge.getEndVertex()) ) {
                mst.add(edge);
                disjointSet.union(edge.getStartVertex(), edge.getEndVertex());
            }
        }
        mst.forEach(System.out::println);
    }

    public static void main(String[] args) {
        List<Vertex> vertexList = new ArrayList<>();
        vertexList.add(new Vertex("A"));
        vertexList.add(new Vertex("B"));
        vertexList.add(new Vertex("C"));
        vertexList.add(new Vertex("D"));
        vertexList.add(new Vertex("E"));
        vertexList.add(new Vertex("F"));
        vertexList.add(new Vertex("G"));
        vertexList.add(new Vertex("H"));

        List<Edge> edgeList = new ArrayList<>();
        edgeList.add(new Edge(vertexList.get(0), vertexList.get(1), (double) 3));
        edgeList.add(new Edge(vertexList.get(0), vertexList.get(2), (double) 2));
        edgeList.add(new Edge(vertexList.get(0), vertexList.get(3), (double) 5));
        edgeList.add(new Edge(vertexList.get(1), vertexList.get(5), (double) 13));
        edgeList.add(new Edge(vertexList.get(1), vertexList.get(3), (double) 2));
        edgeList.add(new Edge(vertexList.get(2), vertexList.get(4), (double) 5));
        edgeList.add(new Edge(vertexList.get(2), vertexList.get(3), (double) 2));
        edgeList.add(new Edge(vertexList.get(3), vertexList.get(4), (double) 4));
        edgeList.add(new Edge(vertexList.get(3), vertexList.get(5), (double) 6));
        edgeList.add(new Edge(vertexList.get(3), vertexList.get(6), (double) 3));
        edgeList.add(new Edge(vertexList.get(4), vertexList.get(6), (double) 6));
        edgeList.add(new Edge(vertexList.get(5), vertexList.get(6), (double) 2));
        edgeList.add(new Edge(vertexList.get(5), vertexList.get(7), (double) 3));
        edgeList.add(new Edge(vertexList.get(6), vertexList.get(7), (double) 6));

        new KrushkaAlgorithm1(vertexList, edgeList);
        //Output - A C - B D - C D - F G - D G - F H - D E - D F - G H - 
    }

}
