package com.avinash.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class LaptopRental {

	public static int laptopRentals(ArrayList<ArrayList<Integer>> times) {
		PriorityQueue<ArrayList<Integer>> queue = new PriorityQueue<>((a, b) -> a.get(1) - b.get(1));
		Collections.sort(times, (a, b) -> a.get(0) - b.get(0));
		queue.add(times.get(0));
		for (int i = 1; i < times.size(); i++) {
			if (queue.peek().get(1) <= times.get(i).get(0)) {
				queue.poll();
			}
			queue.add(times.get(i));
		}
		return queue.size();
	}
	
	public static int laptopRentals1(ArrayList<ArrayList<Integer>> times) {
		if (times.size() == 0) return 0;
		List<Integer> startTime = times.stream().map(i -> i.get(0)).sorted().collect(Collectors.toList());
		List<Integer> endTime = times.stream().map(i -> i.get(1)).sorted().collect(Collectors.toList());
		int usedLaptops = 0;
		int startIndex = 0;
		int endIndex = 0;
		while(startIndex < times.size()) {
			if(startTime.get(startIndex) >= endTime.get(endIndex)) {
				usedLaptops--;
				endIndex++;
			}
			usedLaptops++;
			startIndex++;
		}
		return usedLaptops;
	}

	public static void main(String[] args) {
		int[][] times = { { 0, 2 }, { 1, 4 }, { 4, 6 }, { 0, 4 }, { 7, 8 }, { 9, 11 }, { 3, 10 } };
		ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
		for (int[] time: times) {
			ArrayList<Integer> t = new ArrayList<>();
			for (int i: time) {
				t.add(i);
			}
			arrayList.add(t);
		}
		System.out.println(laptopRentals1(arrayList));
	}

}
