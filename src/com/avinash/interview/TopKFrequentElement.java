package com.avinash.interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;

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
	
	// https://leetcode.com/problems/top-k-frequent-elements/description/
	static class UsingPriorityQueue {
		/*
		 * Time complexity : O(n long n)
		 */
		static int[] topKElement(int[] nums, int k) {
			Map<Integer, Integer> map = new HashMap<>();
			for (int num : nums) {
				map.put(num, map.getOrDefault(num, 0) + 1);
			}
			PriorityQueue<Map.Entry<Integer, Integer>> pQueue = new PriorityQueue<>((o1, o2) -> o1.getValue().compareTo(o2.getValue()));
			for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
				pQueue.add(entry);
				if (pQueue.size() > k) {
					pQueue.poll();
				}
			}
			int[] result = new int[k];
			int index = 0;
			while(!pQueue.isEmpty()) {
				result[index++] = pQueue.poll().getKey();
			}
			return result;
		}
	}
	
	static class QuickSelect {
		/*
		 * Avg Time comlexity : O(N) Worst case time complexity : O(N ^ 2)
		 */
		Integer[] unique;
		Map<Integer, Integer> count;
		Integer[] topKElement(int[] nums, int k) {
			count = new HashMap<>();
			for (int num: nums) {
				count.put(num, count.getOrDefault(num, 0) + 1);
			}
			unique = count.keySet().stream().toArray(Integer[]::new);
			quickSelect(0, count.size() - 1, count.size() - k);
			System.out.println("Array is " + Arrays.toString(unique));
			return Arrays.copyOfRange(unique, unique.length - k, unique.length);
 		}
		
		public void quickSelect(int left, int right, int kSmallest) {
			if (left == right) return;
			Random random = new Random();
			int pivotIndex = left + random.nextInt(right - left);
			pivotIndex = partition(left, right, pivotIndex);
			if (kSmallest == pivotIndex) {
				return;
			} else if (kSmallest < pivotIndex) {
				quickSelect(left, pivotIndex - 1, kSmallest);
			} else {
				quickSelect(pivotIndex + 1, right, kSmallest);
			}
		}

		private int partition(int left, int right, int pivotIndex) {
			int pivotFreq = count.get(unique[pivotIndex]);
			swap(pivotIndex, right);
			int storeIndex = left;
			for (int i = left; i <= right; i++) {
				if (count.get(unique[i]) < pivotFreq) {
					swap(storeIndex++, i);
				}
			}
			swap(storeIndex, right);
			return storeIndex;
		}
		
		private void swap(int a, int b) {
			int tmp = unique[a];
			unique[a] = unique[b];
			unique[b] = tmp;
		}

		
	}
	
	public static void main(String[] args) {
		int nums1[] = {1,1,1,2,2,3};
//		int k = 2;
		int nums[] = {-1,-1};
		int k = 1;
		System.out.println(Arrays.toString(topKFrequent(nums, k)));
		
		System.out.println(Arrays.toString(UsingPriorityQueue.topKElement(nums1, 2)));
		
		System.out.println(Arrays.toString(new QuickSelect().topKElement(nums1, 2)));
		
		
	}
}
