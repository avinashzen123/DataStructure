package com.avinash.interview;

import java.util.Arrays;

public class ProductOfArrayExceptItself {

	public static int[] productOfArrayExceptItself(int[] array) {
		int[] res = new int[array.length];
		int[] prefix = new int[array.length];
		int[] postfix = new int[array.length];
		for(int i = 0; i < array.length; i++) {
			prefix[i] = array[i] * (i <= 0 ? 1 : prefix[i-1]);
		}
		for (int i = array.length - 1; i >= 0; i--) {
			postfix[i] = array[i] * (i >= array.length-1 ? 1 : postfix[i + 1]);
		}
		for (int i = 0; i < array.length; i++) {
			res[i] = (i <= 0 ? 1 : prefix[i-1]) * (i >= array.length-1 ? 1 : postfix[i+1]);
		}
		return res;
	}
	
	public static int[] productOfArrayExceptItselfOpt(int[] nums) {
		int[] res = new int[nums.length];
		int prefix = 1;
		int postfix = 1;
		for(int i = 0; i < nums.length; i++) {
			res[i] = prefix;
			prefix  *= nums[i];
		}
		for (int i = nums.length - 1; i >= 0; i--) {
			res[i] *= postfix;
			postfix *= nums[i];
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] array = {1,2,3,4};
		int[] productOfArrayExceptItself = productOfArrayExceptItself(array);
		System.out.println(Arrays.toString(productOfArrayExceptItself));
		productOfArrayExceptItself = productOfArrayExceptItselfOpt(array);
		System.out.println(Arrays.toString(productOfArrayExceptItself));
	}
}
