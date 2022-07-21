package com.avinash.trie.associative_array;

public class Node extends com.avinash.trie.Node {
    private int value;

    public Node(String character) {
        super(character);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getChild(int index) {
        return (Node) getChildren()[index];
    }
}
