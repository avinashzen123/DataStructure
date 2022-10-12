package com.avinash.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

// https://www.geeksforgeeks.org/next-greater-element/
public class NextGreaterElement {

	static void printNGE(int[] arr, int n) {
		int i = 0;
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(arr[0]);

		int element, next;
		for (i = 1; i < n; i++) {
			next = arr[i];
			if (!stack.empty()) {
				element = stack.pop();

				while (element < next) {
					System.out.println(element + " ---> " + next);
					if (stack.empty()) {
						break;
					}
					element = stack.pop();
				}
				if (element > next) {
					stack.push(element);
				}
			}
			stack.push(next);
		}

		while (!stack.empty()) {
			element = stack.pop();
			next = -1;
			System.out.println(element + " -- " + next);
		}
	}

	static void printNGE1(int[] arr) {
		Stack<Integer> stack = new Stack<>();
		int nge[] = new int[arr.length];

		for (int i = arr.length - 1; i >= 0; i--) {
			if (!stack.empty()) {
				while (!stack.empty() && stack.peek() <= arr[i]) {
					stack.pop();
				}
			}
			nge[i] = stack.empty() ? -1 : stack.peek();
			stack.push(arr[i]);
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i] + " --> " + nge[i]);
		}
	}

	/*
	 * https://leetcode.com/problems/next-greater-element-ii/
	 * 
	 * Given a circular integer array nums (i.e., the next element of
	 * nums[nums.length - 1] is nums[0]), return the next greater number for every
	 * element in nums.
	 * 
	 * The next greater number of a number x is the first greater number to its
	 * traversing-order next in the array, which means you could search circularly
	 * to find its next greater number. If it doesn't exist, return -1 for this
	 * number.
	 * 
	 * Input: nums = [1,2,1] Output: [2,-1,2] Explanation: The first 1's next
	 * greater number is 2; The number 2 can't find next greater number. The second
	 * 1's next greater number needs to search circularly, which is also 2.
	 * 
	 * 
	 * Input: nums = [1,2,3,4,3] Output: [2,3,4,-1,4]
	 * 
	 * 
	 */
	public static int[] nextGreatElementDoubleLinkedList(int[] array) {
		Stack<Integer> stack = new Stack<>();
		int[] result = new int[array.length];
		for (int i = 2 * array.length - 1; i >= 0; i--) {
			int index = i % array.length;
			while (!stack.empty() && stack.peek() <= array[index]) {
				stack.pop();
			}
			result[index] = stack.isEmpty() ? -1 : stack.peek();
			stack.push(array[index]);
		}

		return result;
	}

//	https://leetcode.com/problems/next-greater-element-iii/
	/*
	 * Given a positive integer n, find the smallest integer which has exactly the
	 * same digits existing in the integer n and is greater in value than n. If no
	 * such positive integer exists, return -1.
	 * 
	 * Note that the returned integer should fit in 32-bit integer, if there is a
	 * valid answer but it does not fit in 32-bit integer, return -1.
	 * 
	 * 
	 */
	public static int nextGreaterElement(int n) {
		char[] chars = String.valueOf(n).toCharArray();
		int[] digit = new int[chars.length];
		for (int i = 0 ; i < chars.length; i++) {
			digit[i] = (int)chars[i] - (int)'1' + 1;
		}
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = digit.length - 1; i >= 0; i--) {
			int val = digit[i];
			while (!stack.isEmpty() && digit[stack.peek()] <= val) {
				stack.pop();
			}
			if (!stack.isEmpty() && digit[stack.peek()] > val) {
				int temp = digit[stack.peek()];
				digit[stack.peek()] = digit[i];
				digit[i] = temp;
				break;
			}
			stack.push(i);
		}
		int result = 0;
		for (int i = 0; i < digit.length ; i++) {
			result = result * 10 + digit[i];
		}
		return result > n ? result : -1;
	}

	public static void main(String[] args) {
//		int arr[] = { 11, 2, 13, 21, 3, 2, 1, 2, 3 };
//		printNGE(arr, arr.length);
//		printNGE1(arr);
//		System.out.println(Arrays.toString(nextGreatElementDoubleLinkedList(new int[] { 2, 5, -3, -4, 6, 7, 2 })));
		// not working output should be 2, 3, -1, 3, 2 but got 2, 3, -1, 3, 3
//		System.out.println(Arrays.toString(nextGreatElementDoubleLinkedList(new int[] { 1, 2, 3, 2, 1 })));
		
		System.out.println(nextGreaterElement(230241));
		System.out.println(nextGreaterElement(1234));
//		System.out.println(nextGreaterElement(101));

	}

}
