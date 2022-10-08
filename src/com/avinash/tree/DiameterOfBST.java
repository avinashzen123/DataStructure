package com.avinash.tree;

import lombok.ToString;

public class DiameterOfBST {
    @ToString
    private static class Node {
        private Integer value;
        private Node left, right;

        public Node(Integer value) {
            this.value = value;
        }
    }

    public Node root;

    public int calculateDiamter(Node node) {
        int[] array = { 0 };
        calculateHeight(node, array);
        System.out.println(array[0]);
        return 0;
    }

    private int calculateHeight(Node node, int[] diameter) {
        if (node == null) {
            return 0;
        }
        int leftHeight =  calculateHeight(node.left, diameter);
        int rightHeight = calculateHeight(node.right, diameter);
        diameter[0] = Math.max(diameter[0], leftHeight + rightHeight);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(3);
        root.left.left = new Node(7);
        root.left.left.left = new Node(8);
        root.left.left.left.left = new Node(9);
        root.right = new Node(2);
        root.left.right = new Node(4);
        root.left.right.right = new Node(5);
        root.left.right.right.right = new Node(6);
//        System.out.println(root);
        new DiameterOfBST().calculateDiamter(root);
    }
}
