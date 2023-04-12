package com.avinash.stack;

public class TwoStackInArray {

	private int size;
	private int top1, top2;
	int arr[];

	public TwoStackInArray(int n) {
		arr = new int[n];
		size = n;
		top1 = -1;
		top2 = size;
	}

	public void push1(int x) {
		if (top1 < top2 - 1) {
			arr[++top1] = x;
		} else {
			System.out.println("Stack overflow");
		}
	}

	public void push2(int x) {
		if (top1 < top2 - 1) {
			arr[--top2] = x;
		} else {
			System.out.println("Stack overflow");
		}
	}

	public int pop1() {
		if (top1 >= 0) {
			return arr[top1--];
		} else {
			System.out.println("Stack underflow");
			return 0;
		}
	}

	public int pop2() {
		if (top2 < size) {
			return arr[top2++];
		} else {
			System.out.println("Stack underflow");
			return 0;
		}
	}

	public static void main(String args[]) {
		TwoStackInArray ts = new TwoStackInArray(5);
		ts.push1(5);
		ts.push2(10);
		ts.push2(15);
		ts.push1(11);
		ts.push2(7);
		System.out.println("Popped element from" + " stack1 is " + ts.pop1());
		ts.push2(40);
		System.out.println("Popped element from" + " stack2 is " + ts.pop2());
	}

}
