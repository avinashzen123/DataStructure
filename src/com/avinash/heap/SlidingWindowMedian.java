package com.avinash.heap;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

// https://leetcode.com/problems/sliding-window-median/
public class SlidingWindowMedian {

	public static double[] medianSlidingWindow(int[] nums, int k) {
        PriorityQueue<Double> minHeap = new PriorityQueue<>((a, b) -> Double.compare(a, b));
        PriorityQueue<Double> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b, a));
        Queue<Double> queue = new LinkedList<>();
        double[] medians = new double[nums.length - k + 1];
        int medianIdx = 0;
        for (int num : nums) {
            if (maxHeap.isEmpty() || maxHeap.peek() >= num) {
                maxHeap.add((double)num);
            } else {
                minHeap.add((double)num);
            }
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.add(maxHeap.poll());
            } else if (maxHeap.size() < minHeap.size()) {
                maxHeap.add(minHeap.poll());
            }
            queue.add((double)num);
            if (queue.size() == k) {
                if (maxHeap.size() == minHeap.size()) {
                    medians[medianIdx++] = (maxHeap.peek() + minHeap.peek())/2.0;   
                } else {
                    medians[medianIdx++] = maxHeap.peek();
                }
                double removeObj = queue.poll();
                if (maxHeap.contains(removeObj)) {
                    maxHeap.remove(removeObj);
                } else {
                    minHeap.remove(removeObj);
                }
            }
        }
        return medians;
    }

	public static void main(String[] args) {
		System.out.println(Arrays.toString(medianSlidingWindow(new int[] { 1, 3, -1, -3, 5, 3, 6, 7 }, 3)));
	}
}
