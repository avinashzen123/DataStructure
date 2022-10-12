package com.avinash.heap;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import lombok.AllArgsConstructor;
import lombok.Data;

public class TaskScheduler {
	@Data
	@AllArgsConstructor
	static class Pair<T, K> {
		private T key;
		private K value;
	}
	public static int leastInterval(char[] tasks, int n) {
//		if (n == 0) return tasks.length;
//		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
//		Queue<int[]> q = new LinkedList<>();
//		int[] arr = new int[26];
//		for (char c : tasks) arr[c - 'A'] ++;
//		for (int val : arr) if (val > 0) pq.add(val);
//		int time = 0;
//		while((!pq.isEmpty() || !q.isEmpty())) {
//			time++;
//			if (!pq.isEmpty()) {
//				int val = pq.poll();
//				val --;
//				if (val > 0) q.add(new int[] {val, time + n});
//			}
//			if (!q.isEmpty() && q.peek()[1] == time) {
//				pq.add(q.poll()[0]);
//			}
//		}
//		return time;
		if (n == 0) return tasks.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        int[] arr = new int[26];
        for (char c : tasks) arr[c - 'A']++;
        for (int val : arr) if (val > 0) pq.add(val);
        int time = 0;

        while ((!pq.isEmpty() || !q.isEmpty())) {
            time++;
            if (!pq.isEmpty()) {
                int val = pq.poll();
                val--;
                if (val > 0) q.add(new Pair<Integer, Integer>(val, time + n));
            }

            if (!q.isEmpty() && q.peek().getValue() == time) 
            	pq.add(q.poll().getKey()
            );
        }
        return time;

	}
	
	public static void main(String[] args) {
		System.out.println(leastInterval(new char[] {'A', 'A', 'A', 'B', 'B', 'B'}, 2));
	}
}
