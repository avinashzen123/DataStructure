package com.avinash.trie;

import java.util.ArrayList;
import java.util.List;

public class Trie {
    private Node root;

    public Trie() {
        this.root = new Node("");
    }

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

    public boolean search(String key) {
        Node tempNode = this.root;
        for (int i = 0 ; i < key.length() ; i ++) {
            int asciiIndex = key.charAt(i) - 'a';
            if (tempNode.getChild(asciiIndex) == null) {
                return false;
            } else {
                tempNode = tempNode.getChild(asciiIndex);
            }
        }
        if (!tempNode.isLeaf()) {
            return false;
        }
        return true;
    }

    public List<String> autocomplete(String prefix) {
        Node tempNode = this.root;
        List<String> autocompleteList = new ArrayList<>();
        for (int i = 0 ; i < prefix.length(); i ++) {
            int asciiIndex = prefix.charAt(i) - 'a';
            if (tempNode.getChild(asciiIndex) == null) {
                return new ArrayList<>();
            }
            tempNode = tempNode.getChild(asciiIndex);
        }
        collect(tempNode, prefix, autocompleteList);
        return autocompleteList;
    }

    private void collect(Node node, String prefix, List<String> list ) {
        if (node == null) return;
        if (node.isLeaf()) {
            list.add(prefix);
        }
        for (Node childNode : node.getChildren()) {
            if (childNode == null) continue;
            collect(childNode, prefix + childNode.getCharacter(), list);
        }
    }

    public List<String> sort() {
        return autocomplete("");
    }


    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("air");
        trie.insert("apple");
        trie.insert("approve");
        trie.insert("bee");
        System.out.println(trie.search("airstrike"));
        System.out.println(trie.search("bee"));
        System.out.println(trie.search("app"));
        System.out.println(trie.autocomplete("app"));
        System.out.println(trie.sort());
    }
}
