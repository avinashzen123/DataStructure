package com.avinash.search;

public class BinarySearch {

	public static int find(int[] container, int item, int left, int right) {
		if (right < left)
			return -1;
		int middle_index = (left + right) / 2;
		if (container[middle_index] == item)
			return middle_index;
		else if (container[middle_index] < item)
			return find(container, item, middle_index + 1, right);
		else if (container[middle_index] > item)
			return find(container, item, left, middle_index - 1);
		return left;
	}
	
	public static void main(String[] args) {
		int[] array = {-40, -2, 0, 1, 2 , 5, 6, 11, 32};
		System.out.println(find(array, 2, 0, array.length - 1));
	}
}
