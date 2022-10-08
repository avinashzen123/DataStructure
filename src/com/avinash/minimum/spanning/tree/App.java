package com.avinash.minimum.spanning.tree;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        System.out.println("Main method");
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

        new KrushkalAlgorithm(vertexList, edgeList);
        //Output - A C - B D - C D - F G - D G - F H - D E - D F - G H - 
    }
}
