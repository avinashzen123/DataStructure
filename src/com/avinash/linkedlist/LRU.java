package com.avinash.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class LRU {
	private static class Node {
		private int key;
		private int val;
		private Node next;
		private Node prev;
		
		public Node(int key, int val) {
			this.key = key;
			this.val = val;
		}
	}
	
	private Map<Integer, Node> cache;
	private int capacity;
	private Node left;
	private Node right;
	
	public LRU(int capacity) {
		this.capacity = capacity;
		cache = new HashMap<>();
		this.left = new Node(0,0);
		this.right = new Node(0,0);
		this.left.next = this.right;
		this.right.prev = this.left;
	}
	
	public int get(int key) {
		if (cache.containsKey(key)) {
			remove(cache.get(key));
			insert(cache.get(key));
			return cache.get(key).val;
		}
		return -1;
	}
	
	public void put(int key, int value) {
		if (cache.containsKey(key)) {
			remove(cache.get(key));
		}
		cache.put(key, new Node(key, value));
		insert(cache.get(key));
		if (cache.size() > capacity) {
			//Remove from the list and delete the LRU from the hashmap
			Node lru = this.left.next;
			remove(lru);
			cache.remove(lru.key);
		}
	}
	
	public void remove(Node node) {
		Node prev = node.prev;
		Node next = node.next;
		prev.next = next;
		prev.prev = prev;
	}
	
	public void insert(Node node) {
		Node prev = this.right.prev;
		Node next = this.right;
		
		prev.next = node;
		next.prev = node;
		
		node.next = next;
		node.prev = prev;
	}
	
	public static void main(String[] args) {	
		LRU lru = new LRU(2);
		lru.put(1, 1);
		System.err.println(lru.get(1));
	}
}
