package com.avinash.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SortKSortedArray {

	public static int[] sortKSortedArray(int[] array, int k) {
		PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> a - b);
		int index = 0;
		for (int num : array) {
			queue.add(num);
			if (queue.size() == k + 1) {
				array[index++] = queue.poll();
			}
		}
		while(index < array.length) {
			array[index++] = queue.poll();
		}
		return array;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(sortKSortedArray(new int[] { -1, -3, -4, 2, 1, 3 }, 2)));
	}
}
