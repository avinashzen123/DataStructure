package com.avinash.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class MaxHeap {
	Function<Integer, Integer> leftChild = parent -> 2 * parent + 1;
	Function<Integer, Integer> rightChild = parent -> 2 * parent + 2;
	Function<Integer, Integer> parent =  child -> child/2;
	 
	private List<Integer> heap = new ArrayList<>();
	
	public void push(Integer value) {
		this.heap.add(value);
		this.shiftUp(this.heap.size() - 1);
	}
	
	public int pop() {
		int popedValue = this.heap.get(0);
		this.heap.set(0, this.heap.get(this.heap.size() - 1));
		this.heap.remove(this.heap.size() - 1);
		this.shiftDown(0);
		return popedValue;
	}
	
	private void shiftDown(Integer parentIndex) {
		int leftIndex = leftChild.apply(parentIndex);
		if (leftIndex < this.heap.size()) {
			int max = leftIndex;
			Integer rightIndex = rightChild.apply(parentIndex);
			if(rightIndex < this.heap.size() && this.heap.get(max).compareTo(this.heap.get(rightIndex)) < 0) {
				max = rightIndex;
			}
			if(this.heap.get(max).compareTo(this.heap.get(parentIndex)) > 0) {
				swap(max, parentIndex);
				shiftDown(max);
			}
		}
	}

	private void shiftUp(int childIndex) {
		Integer parentIndex = parent.apply(childIndex);
		System.out.println(childIndex + "  " + parentIndex);
		if(childIndex > 0 && parentIndex >= 0 && heap.get(parentIndex).compareTo(heap.get(childIndex)) < 0) {
			swap(parentIndex, childIndex);
			shiftUp(parentIndex);
		}
	}
	
	private void swap(int i, int j) {
		Integer temp = heap.get(i);
		heap.set(i, heap.get(j));
		heap.set(j, temp);
	}
	
	public static void main(String[] args) {
		
        
		int[] array = {10, 30, 20, 400};
		final MaxHeap heap = new MaxHeap();
		Arrays.stream(array).forEach(i -> heap.push(i));
		System.out.println(heap);
		System.out.println(heap.pop());
		System.out.println(heap);
		System.out.println(heap.pop());
		System.out.println(heap);
		System.out.println(heap.pop());
		System.out.println(heap);
	}

	@Override
	public String toString() {
		return Arrays.toString(this.heap.toArray());
	}
	
	
	
}
