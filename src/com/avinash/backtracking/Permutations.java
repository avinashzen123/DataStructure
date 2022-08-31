package com.avinash.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Permutations {

	public static List<List<Integer>> permute(int[] array) {
		List<List<Integer>> ans = new ArrayList<>();
		function(ans, array, 0);
		return ans;
	}

	private static void function(List<List<Integer>> ans, int[] array, int start) {
		if (start == array.length) {
			List<Integer> list = new ArrayList<>();
			IntStream.range(0, array.length).forEach( i -> list.add(array[i]));
			ans.add(list);
			return;
		}
		for (int i = start ; i < array.length; i++) {
     		swap(array, start, i);
			function(ans, array, start + 1);
			swap(array, start, i);
		}
	}
	 
    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }





	public static void main(String[] args) {
		int[] array = {1,2,3};
		System.out.println(permute(array));
	}
}
