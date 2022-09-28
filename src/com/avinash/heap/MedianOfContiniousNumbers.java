package com.avinash.heap;

import java.util.PriorityQueue;

public class MedianOfContiniousNumbers {

	PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
	PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);

	public void insert(int num) {
		if (maxHeap.isEmpty() || maxHeap.peek() >= num) {
			maxHeap.add(num);
		} else {
			minHeap.add(num);
		}
		if (maxHeap.size() >= minHeap.size() + 1) {
			minHeap.add(maxHeap.poll());
		} else if (maxHeap.size() < minHeap.size() ) {
			maxHeap.add(minHeap.poll());
		}
	}

	public double getMedian() {
		if (maxHeap.size() == minHeap.size()) {
			return (maxHeap.peek() + minHeap.peek() )/ 2.0;
		}
		return maxHeap.peek();
	}
	
	public static void main(String[] args) {
		MedianOfContiniousNumbers  mcn = new MedianOfContiniousNumbers();
		mcn.insert(5);
		mcn.insert(10);
		System.out.println(mcn.getMedian());
		mcn.insert(100);
		System.out.println(mcn.getMedian());
	}
}
