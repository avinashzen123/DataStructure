package com.avinash.search.ternary.tree;

public class TernarySearchTree<T extends Comparable<T>> {
    private Node<T> root;

    public void put(String key, T value) {
        this.root = put(this.root, key, value, 0);
    }

    private Node<T> put(Node<T> node, String key, T value, int index) {
        final Character character = key.charAt(index);
        if (node == null) {
            node = new Node<>(character);
        }
        if (node.compareTo(character) > 0) {
            node.setLeftNode(put(node.getLeftNode(), key, value, index));
        } else if (node.compareTo(character) < 0) {
            node.setRightNode(put(node.getRightNode(), key, value, index));
        } else if (index < key.length() - 1) {
            node.setMiddleNode(put(node.getMiddleNode(), key, value, index + 1));
        } else {
            node.setData(value);
        }
        return node;
    }

    public T get(String key) {
        final Node<T> node = get(this.root, key, 0);
        return node == null ? null: node.getData();
    }

    private Node<T> get(Node<T> node, String key, int index) {
        if (node == null) {
            return null;
        }
        final char character = key.charAt(index);
        if (node.compareTo(character) > 0) {
            return get(node.getLeftNode(), key, index);
        } else if (node.compareTo(character) < 0) {
            return get(node.getRightNode(), key, index);
        } else if (index < key.length() - 1) {
            return get(node.getMiddleNode(), key, index + 1);
        } else {
            return node;
        }
    }

    public Node<T> getRootNode() {
        return this.root;
    }

    public static void main(String[] args) {
        TernarySearchTree<Integer> tst = new TernarySearchTree<>();
        tst.put("apple", 1);
        tst.put("apple1", 12);
        tst.put("appl", 3);
        System.out.println(tst.getRootNode().getCharacter());
        tst.put("orange", 2);
        System.out.println(tst.getRootNode().getCharacter());
        System.out.println(tst.get("apple1"));
    }
}
