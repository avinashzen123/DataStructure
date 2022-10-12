package com.avinash.interview;

import java.util.Arrays;
import java.util.Random;

public class RandomIteger {
	
	static Random random = new Random();
	public static int next(int[] weight) {
		int sum = Arrays.stream(weight).sum();
		int range = sum * weight.length;
		int next = random.nextInt(range);
//		System.out.println(next);
		int start = 0;
		int index = 0;
		for (int wt: weight) {
			start = start + wt * weight.length;
			if (next <= start) {
				return index;
			}
			index ++;
		}
		return index;
	}
	
	public static void main(String[] args) {
		int[] weight = {3, 5, 2};
		System.out.println(next(weight));
		System.out.println(next(weight));
		System.out.println(next(weight));
		System.out.println(next(weight));
		System.out.println(next(weight));
		System.out.println(next(weight));
		System.out.println(next(weight));
		System.out.println(next(weight));
		System.out.println(next(weight));
		System.out.println(next(weight));
		
	}
}
