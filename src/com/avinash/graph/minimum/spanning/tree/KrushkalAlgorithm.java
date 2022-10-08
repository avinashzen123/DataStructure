package com.avinash.graph.minimum.spanning.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KrushkalAlgorithm {

    public KrushkalAlgorithm(List<Vertex> vertices, List<Edge> edges) {
        DisjointSet disjointSet = new DisjointSet(vertices);
        List<Edge> mst = new ArrayList<>();
        Collections.sort(edges);
        for (Edge edge : edges) {
            if (disjointSet.find(edge.getStartVertex()) != disjointSet.find(edge.getEndVertex())) {
                mst.add(edge);
                disjointSet.union(edge.getStartVertex(), edge.getEndVertex());
            }
        }
        mst.forEach(System.out::print);
    }
}
