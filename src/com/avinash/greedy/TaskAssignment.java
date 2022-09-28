package com.avinash.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaskAssignment {

	private class TaskNode {
		public int index;
		public int duration;

		public TaskNode(int index, int duration) {
			this.index = index;
			this.duration = duration;
		}
	}

	public ArrayList<ArrayList<Integer>> taskAssignment(int k, List<Integer> tasks) {
		TaskNode[] taskNode = new TaskNode[tasks.size()];
		for (int index = 0; index < tasks.size(); index++) {
			taskNode[index] = new TaskNode(index, tasks.get(index));
		}
		Arrays.sort(taskNode, (i, j) -> i.duration - j.duration);
		int left = 0;
		int right = tasks.size() - 1;
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		while (left < right) {
			result.add(new ArrayList<>(List.of(taskNode[left++].index, taskNode[right--].index)));
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(new TaskAssignment().taskAssignment(3,  List.of(1, 3, 5, 3, 1, 4)));
	}
}
