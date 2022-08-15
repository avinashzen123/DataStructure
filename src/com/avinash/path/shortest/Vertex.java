package com.avinash.path.shortest;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Vertex implements Comparable<Vertex> {
    private final String name;
    private Vertex prevVertex;
    private Double distance = Double.MAX_VALUE;
    
    @Override
    public String toString() {
        return name + "-" + distance;
    }

    @Override
    public int compareTo(Vertex o) {
        return Double.compare(distance, o.getDistance());
    }
}
