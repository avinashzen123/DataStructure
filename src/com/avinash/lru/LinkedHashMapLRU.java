package com.avinash.lru;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.IntStream;

/*
 * We're asked to implement the structure which provides the following operations in O(1)\mathcal{O}(1)O(1) time :

    Get the key / Check if the key exists

    Put the key

    Delete the first added key

The first two operations in O(1)\mathcal{O}(1)O(1) time are provided by the standard hashmap, and the last one - by linked list.

 */
public class LinkedHashMapLRU extends LinkedHashMap<Integer, Integer> {
	private static final long serialVersionUID = 1L;
	private int capacity;

	public LinkedHashMapLRU(int capacity) {
		super(capacity, 0.75f, true);
		this.capacity = capacity;
	}

	public int get(int key) {
		return super.getOrDefault(key, -1);
	}

	public void put(int key, int value) {
		super.put(key, value);
	}

	@Override
	protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
		return size() > capacity;
	}

	/**
	 * 
	 * 
	 * Time complexity : O(1) both for put and get since all
	 * operations with ordered dictionary : get/in/set/move_to_end/popitem
	 * (get/containsKey/put/remove) are done in a constant time.
	 * 
	 * Space complexity : O(capacity)\mathcal{O}(capacity)O(capacity) since the
	 * space is used only for an ordered dictionary with at most capacity + 1
	 * elements.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedHashMapLRU hashMapLRU = new LinkedHashMapLRU(5);
		IntStream.range(0, 10).forEach(i -> hashMapLRU.put(i, i));
		System.out.println(hashMapLRU);
		System.out.println(hashMapLRU.get(7));
		System.out.println(hashMapLRU);
	}
}
