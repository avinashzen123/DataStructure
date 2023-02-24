package com.avinash.iterator;

import java.util.NoSuchElementException;

public class TwoDVectorIterator {
	private int[][] vector;
	private int inner = 0;
	private int outer = 0;

	public TwoDVectorIterator(int[][] vector) {
		this.vector = vector;
	}

	/*
	 * Time complexity : O(V/N)if the iterator is completely exhausted, then all call to advanceToNext()
	 * will have performed O(N + V) total operations. 
	 * However because we performed N advancedNext() operation in order to exhaust the iterator the 
	 * amortized cost of this operation is just O( (N + V)/ N) = O(N/N + V/N)  = O(V/N)
	 * 
	 */
	private void advanceToNext() {
		while (outer < vector.length && inner == vector[outer].length) {
			inner = 0;
			outer++;
		}
	}

	/*
	 * next() and hasNext() time complexity : O(V/N) or O(1)
	 * The cost of both these method depends on how they are called. If we just got a value from next() the next 
	 * call to either method will involve calling advanceNext(). In this case the time complexity is O(V/N)
	 * 
	 * However if we call hasNext() the all successive calls to hasNext() or next call to next() will be O(1).
	 * This is because advanceToNext() will only perform O(1) check and immediately return.
	 */
	public int next() {
		if (!hasNext())
			throw new NoSuchElementException();
		return this.vector[outer][inner++];
	}

	public boolean hasNext() {
		advanceToNext();
		return outer < vector.length;
	}
	
	public static void main(String[] args) {
		TwoDVectorIterator dVectorIterator = new TwoDVectorIterator(new int[][] {{2, 3}, {4, 5},{6}, {}});
		while(dVectorIterator.hasNext()) {
			System.out.println(dVectorIterator.next());
		}
	}
}
