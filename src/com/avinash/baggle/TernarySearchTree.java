package com.avinash.baggle;

public class TernarySearchTree {
    private Node root;


    public static void main(String[] args) {
        TernarySearchTree tree = new TernarySearchTree();
        tree.insert("car");
        tree.insert("bus");
        tree.insert("banana");
        tree.insert("city");
        tree.insert("person");
        System.out.println(tree.get("adam"));
        System.out.println(tree.get("banana"));
        System.out.println();
        tree.traverse();
    }

    public void traverse() {
        traverse(this.root, "");
    }

    private void traverse(Node node, String str) {
        if (node == null) return;
        if (node.getMiddleChild() == null){
            System.out.println("Key is : " + str + node.getCharacter());
        }
        if (node.getLeftChild() != null){
            traverse(node.getLeftChild(), str);
        }
        if (node.getMiddleChild() != null  ) {
            traverse(node.getMiddleChild(), str + node.getCharacter());
        }
        if (node.getRightChild() != null){
            traverse(node.getRightChild(), str);
        }
    }

    public void insert(String key) {
        this.root = insert(key, this.root, 0);
    }

    private Node insert(String key, Node node, int index) {
        char character = key.charAt(index);
        if (node == null) {
            node = new Node(character);
        }
        if (character < node.getCharacter()) {
            node.setLeftNode(insert(key, node.getLeftChild(), index));
        } else if (character > node.getCharacter()) {
            node.setRightNode(insert(key, node.getRightChild(), index));
        } else if (index < key.length() - 1) {
            node.setMiddleNode(insert(key,node.getMiddleChild(), index + 1));
        } else {
            node.setLeaf(true);
        }
        return node;
    }
    
    public boolean get(String key) {
        Node node = get(key, this.root, 0);
        if (node == null) return false;
        return true;
    }

    private Node get(String key, Node node, int index) {
        if (node == null) return null;
        char character = key.charAt(index);
        if (character < node.getCharacter()) {
            return get(key, node.getLeftChild(), index);
        } else if (character > node.getCharacter()) {
            return get(key, node.getRightChild(), index);
        } else if (index < key.length() - 1) {
            return get(key, node.getMiddleChild(), index + 1);
        } else if (!node.isLeaf()) {
            return null;
        } else {
            return node;
        }
    }

}
