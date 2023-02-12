package com.avinash.lru;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class LRUCache {

	class DLinkedNode {
		int key;
		int value;
		DLinkedNode prev;
		DLinkedNode next;
		
		public DLinkedNode() {}
		public DLinkedNode(int key, int value) {
			this.key = key;
			this.value = value;
		}
		@Override
		public String toString() {
			return this.value + "  "+ (next == null ? " " : next.toString());
		}
	}

	private Map<Integer, DLinkedNode> cache = new HashMap<>();
	private int size;
	private int capacity;
	private DLinkedNode head, tail;
	
	public LRUCache(int capacity) {
		this.size = 0;
		this.capacity = capacity;
		head = new DLinkedNode();
		tail = new DLinkedNode();
		head.next = tail;
		tail.prev = head;
	}

	private void addNode(DLinkedNode node) {
		// Always add new node right after head;
		node.prev = head;
		node.next = head.next;
		head.next.prev = node;
		head.next = node;
	}
	
	private void removeNode(DLinkedNode node) {
		DLinkedNode prev = node.prev;
		DLinkedNode next = node.next;
		prev.next = next;
		next.prev = prev;
	}
	
	private void moveToHead(DLinkedNode node) {
		removeNode(node);
		addNode(node);
	}
	
	private DLinkedNode popTail() {
		DLinkedNode res = tail.prev;
		removeNode(res);
		return res;
	}
	
	public int get(int key) {
		DLinkedNode node = cache.get(key);
		moveToHead(node);
		return node.value;
	}
	
	public void put(int key, int value) {
		DLinkedNode node = cache.get(key);
		if (node == null) {
			DLinkedNode newNode = new DLinkedNode(key, value);
			cache.put(key,  newNode);
			addNode(newNode);
			++size;
			if (size > capacity) {
				DLinkedNode tail = popTail();
				cache.remove(tail.key);
				--size;
			}
		} else {
			node.value = value;
			moveToHead(node);
		}
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.head.toString();
	}
	
	public static void main(String[] args) {
		LRUCache cache = new LRUCache(5);
		IntStream.range(0, 10).forEach(i -> cache.put(i, i));
		cache.get(6);
		System.out.println(cache);
	}
}
