package com.avinash.tree;

public class AVLTree<T extends Comparable<T>> implements Tree<T> {
    private Node<T> root;

    @Override
    public Node<T> insert(T data) {
        return this.root = insert(data, this.root);
    }

    @Override
    public void delete(T data) {
        this.root = delete(data, this.root);
    }

    @Override
    public void traverse() {
        this.dfsTraversal(this.root);
        this.bfsTraversal(this.root);
    }

    @Override
    public Node<T> getRoot() {
        return this.root;
    }

    private Node<T> insert(T data, Node<T> node) {
        if (node == null) {
            return new Node<>(data);
        }
        if (node.compareTo(data) > 0) {
            node.setLeftNode(insert(data, node.getLeftNode()));
        } else if (node.compareTo(data) < 0) {
            node.setRightNode(insert(data, node.getRightNode()));
        }
        setHeight(node);
        return settleInsertViolation(data, node);
    }

    private Node<T> settleInsertViolation(T data, Node<T> node) {
        final int balance = balance(node);
        if (balance > 1) {//Left heavy situation
            if (node.getLeftNode().compareTo(data) < 0) {//Left right situation
                node.setLeftNode(lefRotate(node.getLeftNode()));
            }
            return rightRotate(node);
        } else if (balance < -1) { //Right Heavy situation
            if (node.getRightNode().compareTo(data) > 0) {//Right left heavy situation
                node.setRightNode(rightRotate(node.getRightNode()));
            }
            return lefRotate(node);
        }
        return node;
    }

    private Node<T> delete(T data, Node<T> node) {
        if (node == null) {
            return null;
        }
        if (node.compareTo(data) > 0) {
            node.setLeftNode(delete(data, node.getLeftNode()));
        } else if (node.compareTo(data) < 0) {
            node.setRightNode(delete(data, node.getRightNode()));
        } else {
            if (node.getLeftNode() == null && node.getRightNode() == null) {
                return null;
            } else if (node.getLeftNode() == null) {
                return node.getRightNode();
            } else if (node.getRightNode() == null) {
                return node.getLeftNode();
            } else {
                final Node<T> predecessor = predecessor(node.getLeftNode());
                node.setData(predecessor.getData());
                node.setLeftNode(delete(predecessor.getData(), node.getLeftNode()));
            }
        }
        setHeight(node);
        return settleDeleteViolation(node);
    }

    private Node<T> settleDeleteViolation(Node<T> node) {
        final int balance = balance(node);
        if (balance > 1) {
            if (balance(node.getLeftNode()) < 0) {
                node.setLeftNode(lefRotate(node.getLeftNode()));
            }
            return rightRotate(node);
        } else if (balance < -1) {
            if (balance(node.getRightNode()) > 0) {
                node.setRightNode(node.getRightNode());
            }
            return lefRotate(node);
        }
        return node;
    }

    private Node lefRotate(Node node) {
        final Node rightNode = node.getRightNode();
        node.setRightNode(rightNode.getLeftNode());
        rightNode.setLeftNode(node);
        setHeight(node);
        setHeight(rightNode);
        return rightNode;
    }

    private Node rightRotate(Node node) {
        final Node leftNode = node.getLeftNode();
        node.setLeftNode(leftNode.getRightNode());
        leftNode.setRightNode(node);
        setHeight(node);
        setHeight(leftNode);
        return leftNode;
    }

    private void setHeight(Node node) {
        node.setHeight(Math.max(height(node.getLeftNode()), height(node.getRightNode())) + 1);
    }

    private int balance(Node node) {
        return node == null ? 0 : height(node.getLeftNode()) - height(node.getRightNode());
    }

    private int height(Node node) {
        return node == null ? -1 : node.getHeight();
    }

    /**
               14               
              / \       
             /   \      
            /     \     
           /       \    
           11       23       
          / \     / \   
         /   \   /   \  
         10   13   22   25   
            /   /       
            12   16  
    **/

    public static void main(String[] args) {
        AVLTree<Integer> tree = new AVLTree<>();
        System.out.println(tree.insert(22));
        System.out.println(tree.insert(11));
        System.out.println(tree.insert(15));
        System.out.println(tree.insert(13));
        System.out.println(tree.insert(14));
        System.out.println(tree.insert(25));
        System.out.println(tree.insert(23));
        System.out.println(tree.insert(10));
        System.out.println(tree.insert(12));
        tree.insert(16);
        tree.delete(15);
        System.out.println("-----------------------");
        BTreePrinter.printNode(tree.getRoot());
    }
}
