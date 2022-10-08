package com.avinash.heap;

import java.util.PriorityQueue;
import java.util.Queue;

// https://leetcode.com/problems/find-median-from-data-stream/
public class MedianFinder {
	private Queue<Integer> smallHeap;
	private Queue<Integer> largeHeap;

	public MedianFinder() {
		this.smallHeap = new PriorityQueue<>((a, b) -> b - a);
		this.largeHeap = new PriorityQueue<>((a, b) -> a - b);
	}
	
	public void addNum(int num) {
		smallHeap.add(num);
		if (smallHeap.size() - largeHeap.size() > 1 || !largeHeap.isEmpty() && smallHeap.peek() > largeHeap.peek()) {
			largeHeap.add(smallHeap.poll());
		}
		if (largeHeap.size() - smallHeap.size() > 1	) {
			smallHeap.add(largeHeap.poll());
		}
	}
	
	public double findMean() {
		System.out.println(smallHeap.toString());
		System.out.println(largeHeap.toString());
		if (smallHeap.size() == largeHeap.size()) {
			return (double) (largeHeap.peek() + smallHeap.peek())/2;
		} else if (smallHeap.size() > largeHeap.size()) {
			return (double) smallHeap.peek();
		} else {
			return (double) largeHeap.peek();
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
