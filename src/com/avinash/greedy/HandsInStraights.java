package com.avinash.greedy;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HandsInStraights {
	public static boolean isNStraighHand(int[] hand, int groupSize) {
		if ( hand.length % groupSize != 0) {
			return false;
		}
		Map<Integer, Integer> count = new HashMap<>();
		for (int i : hand) {
			if (!count.containsKey(i)) {
				count.put(i, 0);
			}
			count.put(i, count.get(i) + 1);
		}
		PriorityQueue<Integer> minHeap = new PriorityQueue<>(count.keySet());
		while (!minHeap.isEmpty()) {
			int first = minHeap.peek();
			for (int i = first; i < first + groupSize; i++) {
				if (count.containsKey(i)) {
					count.put(i, count.get(i) - 1);
					if (count.get(i) == 0) {
						if (i != minHeap.peek()) {
							return false;
						}
						minHeap.poll();
					}
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
//		int[] hands = { 1, 2, 3, 6, 2, 3, 4, 7, 8 };
//		int groupSize = 3;
//		System.out.println(isNStraighHand(hands, groupSize));
		
		System.out.println(isNStraighHand(new int[] {8, 10, 12}, 3));
	}
}
