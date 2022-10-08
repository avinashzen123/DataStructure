package com.avinash.stack;

import java.util.ArrayList;
import java.util.Arrays;

public class SortStack {

	public ArrayList<Integer> sortStack(ArrayList<Integer> stack) {
		if (stack.isEmpty()) return stack;
		Integer poppedEle = stack.remove(stack.size() - 1);
		sortStack(stack);
		insertInSortedOrder(stack, poppedEle);
		return stack;
	}

	private void insertInSortedOrder(ArrayList<Integer> stack, Integer poppedEle) {
		if (stack.isEmpty() || stack.get(stack.size() - 1) <= poppedEle) {
			stack.add(poppedEle);
			return;
		}
		int top = stack.remove(stack.size() - 1);
		insertInSortedOrder(stack, top);
		stack.add(top);
	}
	
	public static void main(String[] args) {
		int[] array = {-5, 2, -2, 4, 3, 1};
		ArrayList<Integer> list = new ArrayList<>();
		Arrays.stream(array).forEach(list::add);
		System.out.println(new SortStack().sortStack(list));
	}
}
