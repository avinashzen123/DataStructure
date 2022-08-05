package com.avinash.trie;

public class LongestCommonSuffix extends Trie {
    private Node root;

    public LongestCommonSuffix() {
        this.root = new Node("");
    }

    int lcpIndex = 0;

    public void insert(String key) {
        Node tempNode = this.root;
        for (int i = 0; i < key.length(); i++) {
            int asciiValue = key.charAt(i) - 'a';
            if (tempNode.getChild(asciiValue) == null) {
                Node node = new Node(String.valueOf(key.charAt(i)));
                tempNode.setChild(asciiValue, node);
                tempNode = node;
            } else {
                tempNode = tempNode.getChild(asciiValue);
            }
        }
        tempNode.setLeaf(true);
    }
    public String longestCommonPrefix() {
        Node node = this.root;
        String lcp = "";

        while(numberOfChildren(node) ==1 && !node.isLeaf()) {
            node = node.getChild(lcpIndex);
            lcp = lcp + (char) (lcpIndex + 'a');
        }
        return lcp;
    }

    private int numberOfChildren(Node node) {
        int numberOfChildren = 0;
        for (int i = 0; i < node.getChildren().length; i++ ) {
            if (node.getChild(i) != null) {
                numberOfChildren ++;
                lcpIndex = i;
            }
        }
        return numberOfChildren;
    }

    public static void main(String[] args) {
        LongestCommonSuffix longestCommonSuffix = new LongestCommonSuffix();
        longestCommonSuffix.insert("apir");
        longestCommonSuffix.insert("appa");
        System.out.println(longestCommonSuffix.longestCommonPrefix());
    }

}
