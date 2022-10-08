package com.avinash.tree;

import java.util.Arrays;

public class SegmentTree1 {

	private int[] tree;
	
	public SegmentTree1(int[] array) {
		int height = (int)Math.ceil(Math.log(array.length)/Math.log(2));
		int maxSize = 2 * (int) Math.pow(2, height) + 1;
		tree = new int[maxSize];
		constructST(array, 0, array.length - 1, 0);
	}
	
	private int constructST(int[] array, int startIndex, int endIndex, int treeIndex) {
		if (startIndex == endIndex) {
			tree[treeIndex] = array[startIndex];
			return array[startIndex];
		}
		int middle = startIndex + (endIndex - startIndex)/2;
		tree[treeIndex] = constructST(array, startIndex, middle, treeIndex * 2 + 1) 
				+ constructST(array, middle + 1, endIndex, treeIndex * 2 + 2);
		return tree[treeIndex];
	}
	
	public int getRangeSum(int startIndex, int endIndex, 
			int queryStart, int queryEnd, int treeIndex) {
		if (queryStart <= startIndex && queryEnd >= endIndex) {
			return tree[treeIndex];
		}
		if (endIndex < queryStart || startIndex > queryEnd) {
			return 0;
		}
		int midValue = startIndex + (endIndex - startIndex)/2;
		return getRangeSum(startIndex, midValue, queryStart, queryEnd, 2 * treeIndex + 1) 
				+ getRangeSum(midValue + 1, endIndex, queryStart, queryEnd, 2 * treeIndex + 2);
	}
	
	public static void main(String[] args) {
		int array[] = {2, 4, 7, 10, 12, 13};
		SegmentTree1 segmentTree1 = new SegmentTree1(array);
		System.out.println(Arrays.toString(segmentTree1.tree));
		System.out.println("Sum of values in given range = " + segmentTree1.getRangeSum(0, array.length, 1, 4, 0));
	}
}
