package com.avinash.search;

public class SearchInRotatedArray {
	public static int search(int[] array, int target) {
		int left = 0;
		int right = array.length - 1;
		while (left <= right) {
			int mid = (left + right)/2;
			if (target == array[mid]) {
				return mid;
			}
			if (array[left] < array[mid]) {
				if (target > array[mid] || target < array[left]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			} else {
				if (target < array[mid] || target > array[right]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		System.out.println(search(new int[] {4, 5, 6, 7, 0, 1, 2}, 0));
	}
}
