package com.avinash.stack;

public class StackImpl {

	private final Integer maxElements = 1000;
	private Integer top;
	private final Integer[] stack;

	public StackImpl() {
		top = 0;
		stack = new Integer[maxElements];
	}

	public boolean isEmpty() {
		return top == 0;
	}

	public boolean push(Integer value) {
		if (this.top == this.maxElements) {
			return false;
		}

		this.stack[this.top++] = value;
		return true;
	}

	public Integer peek() {
		if (this.top == 0) {
			throw new IllegalStateException();
		}
		return this.stack[this.top - 1];
	}

	public Integer pop() {
		if (this.top == 0) {
			throw new IllegalStateException();
		}
		return this.stack[--this.top];
	}

	void print() {
		for (int i = top; i > -1; i--) {
			System.out.print(" " + this.stack[i]);
		}
	}

	public static void main(String args[]) {
		StackImpl s = new StackImpl();
		s.push(10);
		s.push(20);
		s.push(30);
		System.out.println(s.pop() + " Popped from stack");
		s.print();
		s.push(100);
		System.out.println("Top element is :" + s.peek());
		System.out.print("Elements present in stack :");
		s.print();
	}
}
