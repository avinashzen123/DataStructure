package com.avinash.interview;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import lombok.AllArgsConstructor;

public class TopKFrequentElement {
	@AllArgsConstructor
	static class Node implements Comparable<Node>{
		Integer key;
		Integer value;
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.value.compareTo(o.value);
		}
		
		
	}
	public static int[] topKFrequent(int[] nums, int k) {
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		for (int i : nums) {
			if (hashMap.containsKey(i)) {
				hashMap.put(i, hashMap.get(i) + 1);
			} else {
				hashMap.put(i, 1);
			}
		}
		PriorityQueue<Node> priorityQueue = new PriorityQueue<>(); 
		for (Map.Entry<Integer, Integer> entry: hashMap.entrySet()) {
			priorityQueue.add(new Node(entry.getValue(), entry.getKey()));
		}
		int[] result = new int[k];
		for (int i = 0; i < k;i++) {
			result[i] = priorityQueue.poll().value;
		}
		return result;
	}
	
	public static void main(String[] args) {
//		int nums[] = {1,1,1,2,2,3};
//		int k = 2;
		int nums[] = {-1,-1};
		int k = 1;
		System.out.println(Arrays.toString(topKFrequent(nums, k)));
	}
}
