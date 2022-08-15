package com.avinash.string;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
class Node {
	private Node left, middle, right;
	private final Character character;
	private boolean isLeaf;
}

class TernarySearchTree {
	private Node root;
	
	public TernarySearchTree() {
		this.root = new Node('*');
	}
	
	public void insert(String word) {
		this.root = insert(word, this.root, 0);
	}

	private Node insert(String word, Node node, int index) {
		var character = word.charAt(index);
		if (node == null) {
			node = new Node(character);
		}
		if (node.getCharacter().compareTo(character) > 0) {
			node.setLeft(insert(word, node.getLeft(), index));
		} else if (node.getCharacter().compareTo(character) < 0) {
			node.setRight(insert(word, node.getRight(), index));
		} else if (index < word.length() - 1) {
			node.setMiddle(insert(word, node.getMiddle(), index + 1));
		} else {
			node.setLeaf(true);
		}
		return node;
	}
	
	public Node find(String word) {
		Node node = find(word, this.root, 0);
		if (node == null) return null;
		return node;
	}

	private Node find(String word, Node node, int index) {
		if (node == null) return null;
		var character = word.charAt(index);
		if(node.getCharacter().compareTo(character) > 0) {
			return find(word, node.getLeft(), index);
		} else if(node.getCharacter().compareTo(character) < 0) {
			return find(word, node.getRight(), index);
		} else if (index < word.length() - 1) {
			return find(word, node.getMiddle(), index + 1);
		} else if (!node.isLeaf()) {
			return null;
		} else {
			return node;
		}
	}
}

public class SplitSpaceLessSentence {
	private TernarySearchTree dictionary = new TernarySearchTree();
	
	public void splittingSpacelessSentence(String word, List<String> result, int start, int end, int stringIndex) {
		if (end >  word.length()) return; 
		String lookupString = word.substring(start, end);
		Node node = this.dictionary.find(lookupString);
		if (node == null) {
			splittingSpacelessSentence(word, result, start, end + 1, stringIndex);
		} else {
			if (result.size() == stringIndex ) {
				result.add(stringIndex, lookupString);
				splittingSpacelessSentence(word, result, end, end + 1, stringIndex);
			} else {
				result.set(stringIndex, result.get(stringIndex) + " " + lookupString);
				splittingSpacelessSentence(word, result, end , end + 1, stringIndex);
			}
			splittingSpacelessSentence(word, result, start, end +1, result.size());
		}
	}
	
	public static void main(String[] args) {
		SplitSpaceLessSentence spaceLessSentence = new SplitSpaceLessSentence();
		spaceLessSentence.dictionary.insert("cat");
		spaceLessSentence.dictionary.insert("cats");
		spaceLessSentence.dictionary.insert("and");
		spaceLessSentence.dictionary.insert("sand");
		spaceLessSentence.dictionary.insert("dog");
		List<String> result = new ArrayList<>();
		spaceLessSentence.splittingSpacelessSentence("catsanddog", result, 0, 1, 0);
		System.out.println(result);
	}
}
