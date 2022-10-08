package com.avinash.dynamic;

import java.util.Arrays;

//https://www.geeksforgeeks.org/box-stacking-problem-dp-22/#:~:text=You%20want%20to%20create%20a,side%20functions%20as%20its%20base.
public class BoxStacking {
	private static class Box implements Comparable<Box> {
		private int height;
		private int width;
		private int dimension;
		private int area;
		
		private Box(int height, int width, int dimension) {
			this.height = height;
			this.width = width;
			this.dimension = dimension;
			this.area = this.width * this.dimension;
		}
		
		public int compareTo(Box o) {
			return o.area - this.area;
		}
	}
	
	public static int maxStackHeight (Box[] arr, int n) {
		int count = 3 * n;
		Box[] rot = new Box[count];
		for (int i = 0; i < n; i++) {
			Box box = arr[i];
			rot[3*i] = new Box(box.height, Math.max(box.width, box.dimension), Math.min(box.width, box.height));
			rot[3*i + 1] = new Box(box.width, Math.max(box.height, box.dimension), Math.min(box.height, box.dimension));
			rot[3*i + 2] = new Box(box.dimension, Math.max(box.width, box.height), Math.min(box.width,  box.height));
		}
		Arrays.sort(rot);
		// Initialize msh value for all indexes
		// msh[i] -> maximum possible stack height with box i on top
		int[] msh = new int[count];
		
		//Computing optimized msh[] values in bottom up manner
		for (int i = 0; i < count; i ++) {
			msh[i] = 0;
			Box box = rot[i];
			int val = 0;
			for (int j = 0; j < i; j++) {
				Box prevBox = rot[j];
				if (box.width < prevBox.width && box.dimension < prevBox.dimension) {
					val = Math.max(val, msh[j]);
				}
			}
			msh[i] = val + box.height;
		}
		
		int max = -1;
		for (int i = 0; i < count; i++) {
			max = Math.max(max, msh[i]);
		}
		return max;
	}
	
	public static void main(String[] args) {
		Box[] arr = new Box[4];
		arr[0] = new Box(4, 6, 7);
		arr[1] = new Box(1, 2, 3);
		arr[2] = new Box(4, 5, 6);
		arr[3] = new Box(10, 12, 32);
		System.out.println("Maximum possible height of stack is "+ maxStackHeight(arr, 4));
	}
}
