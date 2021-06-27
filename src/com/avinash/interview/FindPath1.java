package com.avinash.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class FindPath1 {
	private static int[][] array;

	public static void main(String[] args) {
		int[][] arr = { { 3, 3, 3, 1 }, { 3, 0, 3, 3 }, { 0, 3, 3, 3 }, { 0, 3, 2, 3 } };
		FindPath1.array = arr;
		hasPath(FindPath1.array);

	}

	public static boolean hasPath(int[][] array) {
		FindPath1.array = array;
		List<int[]> path = new ArrayList<>();
		Stack<int[]> stack = new Stack<>();
		stack.push(new int[] { 0, 0 });
		while (!stack.isEmpty()) {
			int[] pop = stack.pop();
			if (array[pop[0]][pop[1]] == 2) {
				path.add(pop);
				break;
			}
			if (addAdjancy(stack, pop)) {
				path.add(pop);
			}
		}
		path.stream().forEach(v -> System.out.println(Arrays.toString(v)));
		return false;
	}
	

	public static boolean addAdjancy(Stack<int[]> stack, int[] position) {
		int[] diagonal = new int[] { position[0] + 1, position[1] + 1 };
		int[] left = new int[] { position[0] + 1, position[1] };
		int[] right = new int[] { position[0], position[1] + 1 };
		boolean hasChildren = false;
		if (isValidPosition(diagonal)) {
			stack.push(diagonal);
			hasChildren = true;
		}
		if (isValidPosition(left)) {
			hasChildren = true;
			stack.add(left);
		}
		if (isValidPosition(right)) {
			stack.add(right);
			hasChildren = true;
		}
		return hasChildren;
	}

	public static boolean isValidPosition(int[] position) {
		try {
			return array[position[0]][position[1]] != 0;
		} catch (ArrayIndexOutOfBoundsException e) {
			return false;
		}
	}
}

//class Vertex {
//	public int[] index;
//	public Vertex parent;
//	public List<Vertex> childers;
//	public Vertex(int[] index) {
//		super();
//		this.index = index;
//	}
//
//}
