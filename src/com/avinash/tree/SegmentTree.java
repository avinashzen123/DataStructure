package com.avinash.tree;

import java.util.Arrays;

// https://www.javatpoint.com/segment-tree-in-java
public class SegmentTree {

	int stArr[];

	public SegmentTree(int[] a, int s) {
		s = a.length;
		int h = (int) Math.ceil(Math.log(s) / Math.log(2));
		int maxSize = 2 * (int) Math.pow(2, h) - 1;
		System.out.println("Max size " + maxSize + " s " + s);
		stArr = new int[maxSize];
		constructST(a, 0, s - 1, 0);
//		[48, 13, 35, 6, 7, 22, 13, 2, 4, 0, 0, 10, 12, 0, 0]
//		[48, 13, 35, 6, 7, 22, 13, 2, 4, 0, 0, 10, 12, 0, 0, 0, 0, 0]
		System.out.println(Arrays.toString(stArr));
	}

	/*
	 * A recursive method that does construct Segment tree for array
	 * 
	 * si is index of current node of the segment tree
	 */
	public int constructST(int[] array, int start, int end, int treeIndex) {
		if (start == end) {
			stArr[treeIndex] = array[start];
			return stArr[treeIndex];
		}
		int aMid = (start + end) / 2;
		stArr[treeIndex] = constructST(array, start, aMid, treeIndex * 2 + 1)
				+ constructST(array, aMid + 1, end, treeIndex * 2 + 2);
		return stArr[treeIndex];
	}

	/*
	 * Returning the sum of the elements in the range from the index x (query start)
	 * to y (query end)
	 * 
	 * it uses the method getSumUtil()
	 */
	public int getSum(int arrayLength, int queryStart, int queryEnd) {
		if (queryStart < 0 || queryEnd > arrayLength - 1 || queryStart > queryEnd) {
			System.out.println("Input is invalid");
			return -1;
		}
		System.out.println(Arrays.toString(stArr));
		return getSumUtil(0, arrayLength - 1, queryStart, queryEnd, 0);
	}


	private int getMiddleIndex(int x, int y) {
		return x + (y - x) / 2;
	}

	/*
	 * startIndex -> index of current node in segement tree initially 0 is passed as root is
	 * always at index 0 .
	 * 
	 * startIndex & endIndex -> start and end indices at segment represented by
	 * currentNode ie stArr[si]
	 * 
	 * queryStart & queryEnd -> start and end indices of the query range
	 */
	private int getSumUtil(int startIndex, int endIndex, int queryStart, int queryEnd, int treeIndex) {
		// If segment of this node is part of given range the return the sum of segment
		if (queryStart <= startIndex && queryEnd >= endIndex) {
			return this.stArr[treeIndex];
		}
		//if segment of this node is outside the given range
		if (endIndex < queryStart || startIndex > queryEnd) {
			return 0;
		}
		// If part of the segment overlaps with given range.
		int midVal = getMiddleIndex(startIndex, endIndex);
		return getSumUtil(startIndex, midVal, queryStart, queryEnd, 2 * treeIndex + 1)
				+ getSumUtil(midVal + 1, endIndex, queryStart, queryEnd, 2 * treeIndex + 2);
	}
	

	/*
	 * The method is to update the value in the input array and the segment tree. It
	 * uses the updateValUtil() to update the value in the segment tree
	 * 
	 */
	public void updateVal(int a[], int size, int index, int newVal) {
		// Check for erroneous input index
		if (index < 0 || index > size - index) {
			System.out.println("Input is invalid");
			return;
		}
		// Get the difference between the old value and new value
		int diffVal = newVal - a[index];
		this.stArr[index] = newVal;
		updateValUtil(0, size - 1, index, diffVal, 0);
	}

	private void updateValUtil(int startIndnex, int endIndex, int updatedIndex, int val, int treeIndex) {
		// Base case if the input index lies outside the range of this segment.
		if (updatedIndex < startIndnex || updatedIndex > endIndex)
			return;
		// If the input index is in range of this node, the update the value of the node and it childer.
		this.stArr[treeIndex] = this.stArr[treeIndex] + val;
		if (endIndex != startIndnex) {
			int midVal = getMiddleIndex(startIndnex, endIndex);
			updateValUtil(startIndnex, midVal, updatedIndex, val, 2 * treeIndex + 1);
			updateValUtil(midVal + 1, endIndex, updatedIndex, val, 2 * treeIndex + 2);
		}
	}

	public static void main(String[] args) {
		int a[] = { 2, 4, 7, 10, 12, 13 };
		int size = a.length;
		SegmentTree segmentTree = new SegmentTree(a, size);
		System.out.println(Arrays.toString(segmentTree.stArr));
		System.out.println("Sum of values in the given range 1 to 4 =" + segmentTree.getSum(size, 1, 4));
		segmentTree.updateVal(a, size, 3, 11);
		System.out.println("Sum of values in given rage 1 to 4 = " + segmentTree.getSum(size, 1, 4));
	}
}
