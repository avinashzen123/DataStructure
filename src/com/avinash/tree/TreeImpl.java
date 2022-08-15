package com.avinash.tree;

class TreeNode {
    Integer data;
    TreeNode left, right;

    public TreeNode(Integer data) {
        this.data = data;
    }
}
public class TreeImpl {
    private TreeNode head;

    public void preOrder() {
        preOrder(this.head);
    }

    private void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + "-");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder() {
        inOrder(this.head);
    }

    public void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.data + "-");
        inOrder(node.right);
    }

    public void postOrder() {
        postOrder(this.head);
    }

    private void postOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + "-");
    }
    
    public static void main(String[] args) {
        TreeImpl tree = new TreeImpl();
        tree.head = new TreeNode(1);
        tree.head.left = new TreeNode(2);
        tree.head.right = new TreeNode(3);
        tree.head.left.left = new TreeNode(4);
        tree.head.left.right = new TreeNode(5);
        tree.head.right.left = new TreeNode(6);
        tree.head.right.right = new TreeNode(7);
        tree.preOrder();
        System.out.println();
        tree.inOrder();
        System.out.println();
        tree.postOrder();
    }
}
