package com.avinash.stack;

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
		
		for (int i = arr.length -1 ; i >=0; i--) {
			if(!stack.empty()) {
				while(!stack.empty() && stack.peek() <= arr[i]) {
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

	public static void main(String[] args) {
		int arr[] = { 11, 2, 13, 21, 3 };
//		printNGE(arr, arr.length);
		printNGE1(arr);
	}

}
