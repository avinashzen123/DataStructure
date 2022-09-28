package com.avinash.heap;

import java.util.ArrayList;
import java.util.List;

public class MinHeap {
	private List<Integer> heap;
	
	public MinHeap() {
		this.heap = new ArrayList<>();
	}
	
	public void insert(int value) {
		heap.add(value);
		siftUp(heap.size() - 1);
	}

	private void siftUp(int curIdx) {
		int parentIdx = curIdx/2;
		if (heap.get(curIdx) < heap.get(parentIdx)) {
			swap(curIdx, parentIdx);
			siftUp(parentIdx);
		}
	}
	
	public int remove() {
		int value = heap.get(0);
		heap.set(0, heap.get(heap.size() - 1));
		heap.remove(heap.size() - 1);
		siftDown(0);
		return value;
	}
	
	private void siftDown(int parentIdx) {
		int minIdx = 2 * parentIdx + 1;
		if (minIdx < heap.size()) {
			int rightIdx = 2 * parentIdx + 2;
			if (rightIdx < heap.size() && heap.get(minIdx) > heap.get(rightIdx)) {
				minIdx = rightIdx;
			}
			if (heap.get(parentIdx) > heap.get(minIdx)) {
				swap(parentIdx, minIdx);
				siftDown(minIdx);
			}
		}
	}

	public int peek() {
		if (heap.isEmpty()) {
			return -1;
		}
		else return heap.get(0);
	}
	
	private void swap(int i, int j) {
		int temp = heap.get(i);
		heap.set(i, heap.get(j));
		heap.set(j, temp);
	}
	
	public static void main(String[] args) {
		MinHeap heap = new MinHeap();
		heap.insert(10);
		heap.insert(8);
		heap.insert(14);
		heap.insert(6);
		System.out.println(heap.heap);
		System.out.println(heap.peek());
		heap.remove();
		System.out.println(heap.peek());
	}
	
}
