package com.avinash.trie.associative_array;

public class TrieAssociativeArray {
    private Node root;

    public TrieAssociativeArray() {
        this.root = new Node("");
    }

    public void insert(String key, int value) {
        Node tempNode = this.root;

        for (int i = 0; i < key.length(); i ++) {
            int asciiIndex = key.charAt(i) - 'a';
            if (tempNode.getChild(asciiIndex) == null) {
                Node node = new Node(String.valueOf(key.charAt(i)));
                tempNode.setChild(asciiIndex, node);
                tempNode = node;
            } else {
                tempNode = tempNode.getChild(asciiIndex);
            }
        }
        tempNode.setLeaf(true);
        tempNode.setValue(value);
    }

    public Integer search(String key) {
        Node tempNode = this.root;
        for (int i = 0; i < key.length(); i++) {
            int asciiIndex = key.charAt(i) - 'a';
            if (tempNode.getChild(asciiIndex) == null){
                return null;
            } else {
                tempNode = tempNode.getChild(asciiIndex);
            }
        }
        if (!tempNode.isLeaf()) {
            return null;
        }
        return tempNode.getValue();
    }

    public static void main(String[] args) {
        TrieAssociativeArray trie = new TrieAssociativeArray();
        trie.insert("air", 5);
        trie.insert("apple", 10);
        trie.insert("approve", 6);
        trie.insert("bee", 11);
        System.out.println(trie.search("bee"));
        System.out.println(trie.search("al"));
    }
}
