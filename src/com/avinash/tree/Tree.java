package com.avinash.tree;

import java.util.Stack;

public interface Tree<T extends Comparable<T>> {
    Node<T> insert(T data);

    void delete(T data);

    void traverse();

    Node<T> getRoot();

    default void dfsTraversal(Node<T> node) {
        if (node != null) {
            dfsTraversal(node.getLeftNode());
            System.out.println(node);
            dfsTraversal(node.getRightNode());
        }
    }

    default void bfsTraversal(Node<T> node) {
        Stack<Node> stack = new Stack<>();
        stack.add(node);
        while (!stack.isEmpty()) {
            System.out.print(node);
            if (node.getLeftNode() != null) {
                stack.add(node.getLeftNode());
            }
            if (node.getRightNode() != null) {
                stack.add(node.getRightNode());
            }
        }
        System.out.println(" ");
    }
    
    default Node<T> predecessor(Node<T> node) {
        return node.getRightNode() == null ? node : predecessor(node.getRightNode());
    }
}
