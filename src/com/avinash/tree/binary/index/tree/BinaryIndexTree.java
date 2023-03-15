package com.avinash.tree.binary.index.tree;

import java.util.Arrays;
import java.util.stream.IntStream;

public class BinaryIndexTree {
	private int[] bIndTree;
	private int[] nums;

	public BinaryIndexTree(int[] nums) {
		this.nums = nums;
		this.bIndTree = new int[this.nums.length + 1];
		IntStream.range(0, this.nums.length).forEach(this::updateBIndxTree);
	}

	private int getSum(int index) {
		int sum = 0;
		index = index + 1;
		while (index > 0) {
			sum += this.bIndTree[index];
			index -= (index & -index);
		}
		return sum;
	}

	public int getRangeSum(int from, int to) {
		return getSum(to) - getSum(from);
	}

	private void updateBIndxTree(int index) {
		int val = this.nums[index++];
		while (index <= nums.length) {
			this.bIndTree[index] += val;
			index += (index & -index);
		}
	}

	public static void main(String[] args) {
		int array[] = { 2, 4, 7, 10, 12, 13 };
		BinaryIndexTree tree1 = new BinaryIndexTree(array);
		System.out.println(tree1.getRangeSum(0, 4));
		System.out.println(tree1.getRangeSum(1, 3));
		System.out.println(Arrays.toString(tree1.bIndTree));
	}
}
