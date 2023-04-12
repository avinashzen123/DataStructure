package com.avinash.heap;

import java.util.PriorityQueue;
import java.util.Queue;

// https://leetcode.com/problems/find-median-from-data-stream/
public class MedianFinder {
	private Queue<Integer> maxHeap;
	private Queue<Integer> minHeap;

	public MedianFinder() {
		this.maxHeap = new PriorityQueue<>((a, b) -> b - a);
		this.minHeap = new PriorityQueue<>((a, b) -> a - b);
	}

	public void addNum(int num) {
		maxHeap.add(num);
		if (maxHeap.size() - minHeap.size() > 1 || !minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
			minHeap.add(maxHeap.poll());
		}
		if (minHeap.size() - maxHeap.size() > 1) {
			maxHeap.add(minHeap.poll());
		}
		System.out.println(String.format("Min Peek %s %s max Peek %s %s", maxHeap.peek(), maxHeap.toString(),
				minHeap.peek(), minHeap.toString()));
	}

	public double findMean() {
		System.out.println(maxHeap.toString());
		System.out.println(minHeap.toString());
		if (maxHeap.size() == minHeap.size()) {
			return (double) (minHeap.peek() + maxHeap.peek()) / 2;
		} else if (maxHeap.size() > minHeap.size()) {
			return (double) maxHeap.peek();
		} else {
			return (double) minHeap.peek();
		}
	}

	public static void main(String[] args) {
		MedianFinder finder = new MedianFinder();
		finder.addNum(1);
		finder.addNum(2);
		finder.addNum(9);
		finder.addNum(7);
		finder.addNum(10);

		System.out.println(finder.findMean());
		finder.addNum(3);
		System.out.println(finder.findMean());
	}
}
