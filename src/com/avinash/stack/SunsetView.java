package com.avinash.stack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;


public class SunsetView {
	public static ArrayList<Integer> sunsetViews(int[] buildings, String direction) {
		PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
		LinkedList<Integer> result = new LinkedList<>();
		if (direction == "EAST") {
			for (int i = buildings.length - 1; i >= 0; i--) {
				if (queue.isEmpty() || queue.peek() < buildings[i]) {
					result.addFirst(i);
				}
				queue.add(buildings[i]);
			}
		} else {
			for (int i = 0; i < buildings.length; i++) {
				if (queue.isEmpty() || queue.peek() < buildings[i]) {
					result.add(i);
				}
				queue.add(buildings[i]);
			}
		}
		return new ArrayList<>(result);
	}

	public static void main(String[] args) {
		System.out.println(sunsetViews(new int[] {3, 5, 4, 4, 3, 1, 3, 2}, "EAST"));
	}
}
