package com.avinash.tst;

public class TernarySearchTree {
    private Node root;

    public void insert(String key, int value) {
        root = insert(this.root, key, value, 0);
    }

    private Node insert(Node node, String key, int value, int index) {
        char c = key.charAt(index);
        if (node == null) {
            node = new Node(c);
        }
        if (c < node.getCharacter()) {
            node.setLeftChild(insert(node.getLeftChild(), key, value, index));
        } else if (c > node.getCharacter()) {
            node.setRightChild(insert(node.getRightChild(), key, value, index));
        } else if (index < key.length() - 1) {
            // This node is not last letter and this is a middle child
            node.setMiddleChild(insert(node.getMiddleChild(), key, value, index + 1));
        } else {
            //This node is leaf node
            node.setLeaf(true);
            node.setValue(value);
        }
        return node;
    }

    public Integer get(String key) {
        Node  node = get(this.root, key, 0);
        if (node == null) return null;
        return node.getValue();
    }

    private Node get(Node node, String key, int index) {
        if (node == null) return  null;
        char character = key.charAt(index);
        if (character < node.getCharacter()) {
            return get(node.getLeftChild(), key, index);
        } else if (character > node.getCharacter()) {
            return get(node.getRightChild(), key, index);
        } else  if (index < key.length() - 1) {
            return get(node.getMiddleChild(), key, index + 1);
        } else {
            if (!node.isLeaf()) return  null;
            return node;
        }
    }

    public void traverse() {
        if (root != null) {
            traverse(root, "");
        }
    }

    private void traverse(Node node, String str) {
        if (node.getMiddleChild() == null || node.getValue() != 0) {
            System.out.println(str + node.getCharacter() + " : " + node.getValue());
        }
        if (node.getLeftChild() != null) {
            traverse(node.getLeftChild(), str);
        }
        if (node.getMiddleChild() != null) {
            traverse(node.getMiddleChild(), str + node.getCharacter());
        }
        if (node.getRightChild() != null) {
            traverse(node.getRightChild(), str);
        }
    }

    public static void main(String[] args) {
        TernarySearchTree tree = new TernarySearchTree();
        tree.insert("car", 10);
        tree.insert("bus", 5);
        tree.insert("banana", 7);
        tree.insert("city", 20);
        tree.insert("person", 2);
        System.out.println(tree.get("adam"));
        System.out.println(tree.get("banana"));
        System.out.println();
        tree.traverse();
    }
}
