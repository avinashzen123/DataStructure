package com.avinash.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HashMapImpl {
	private static class Pair<U, V> {
		public U first;
		public V second;

		public Pair(U first, V second) {
			this.first = first;
			this.second = second;
		}
	}
	
	private static class Bucket {
		private List<Pair<Integer, Integer>> bucket;
		
		public Bucket() {
			this.bucket = new LinkedList<>();
		}
		
		public Integer get(Integer key) {
			for (Pair<Integer, Integer> pair: this.bucket) {
				if (pair.first.equals(key)) {
					return pair.second;
				}
			}
			return -1;
		}
		
		public void update(Integer key, Integer value) {
			boolean found = false;
			for (Pair<Integer, Integer> pair : this.bucket) {
				if (pair.first.equals(key)) {
					pair.second = value;
					found = true;
				}
			}
			if (!found) {
				this.bucket.add(new Pair<> (key, value));
			}
		}
		
		public void remove(Integer key) {
			for (Pair<Integer, Integer> pair : this.bucket) {
				if (pair.first.equals(key)) {
					this.bucket.remove(pair);
					break;
				}
			}
		}
	}
	
	private int keySpace;
	private List<Bucket> hashTable;
	
	public HashMapImpl() {
		this.keySpace = 2069;
		this.hashTable = new ArrayList<>();
		for (int i = 0; i < keySpace; i++) {
			this.hashTable.add(new Bucket());
		}
	}
	
	public void put(int key, int value) {
		int hashKey = key % this.keySpace;
		this.hashTable.get(hashKey).update(key, value);
	}
	
	public int get(int key) {
		int hashKey = key % this.keySpace;
		return this.hashTable.get(hashKey).get(key);
	}
	
	public void remove(int key) {
		int hashKey = key % this.keySpace;
		this.hashTable.get(hashKey).remove(key);
	}
}
