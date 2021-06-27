package com.avinash.interview;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

// https://www.geeksforgeeks.org/find-pythagorean-triplet-in-an-unsorted-array/
public class FindTriplets {
	public static void main(String[] args) {
		Integer arr[] = {3, 1, 4, 6, 5}; 
		System.out.println(findTriplet(arr));
	}
	
	public static boolean findTriplet(Integer[] arr) {
		Map<Integer, Integer> collect = Arrays.stream(arr).collect(Collectors.toMap(i -> i, i -> i*i));
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j< arr.length; j++) {
				if (collect.containsValue(collect.get(arr[i]) + collect.get(arr[j]))) {
					return true;
				}
			}
		}
		return false;
	}
}
