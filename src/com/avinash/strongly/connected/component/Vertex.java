package com.avinash.strongly.connected.component;

public class Vertex {
    private final String name;
    private boolean visited;
    private int componentId;

    public Vertex(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public int getComponentId() {
        return componentId;
    }

    public void setComponentId(int componentId) {
        this.componentId = componentId;
    }

    @Override
    public String toString() {
        return name;
    }
}
