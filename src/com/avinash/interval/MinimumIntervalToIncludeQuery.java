package com.avinash.interval;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// https://www.youtube.com/watch?v=6FPsqiCS2g8 longest 1
// https://leetcode.com/problems/minimum-interval-to-include-each-query/
public class MinimumIntervalToIncludeQuery {

    private static class Interval {
        private int left;
        private int right;
        private int len;
        private Interval (int left, int right) {
            this.left = left;
            this.right = right;
            this.len = right - left + 1;
        }
        private Interval (int[] interval) {
            this.left = interval[0];
            this.right = interval[1];
            this.len = right - left + 1;
        }
    }

    private static int[] mapToArray(int[] queries, Map<Integer, Integer> queryInterval) {
        int[] result = new int[queries.length];
        int idx = 0;
        for (int query : queries) {
            result[idx++] = queryInterval.getOrDefault(query, -1);
        }
        return result;
    }

    public static int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (i, j) -> i[0] - j[0]);
        int[] queriesClone = queries.clone();
        Arrays.sort(queriesClone);
        Map<Integer, Integer> queryInterval = new HashMap<>();
        int idx = 0;
        PriorityQueue<Interval> candidate = new PriorityQueue<>((i, j) -> i.len - j.len);
        for (int query : queriesClone) {
            while (idx < intervals.length && intervals[idx][0] <= query) {
                candidate.add(new Interval(intervals[idx]));
                idx++;
            }
            while(!candidate.isEmpty() && candidate.peek().right < query) {
                candidate.poll();
            }
            if(!candidate.isEmpty()) {
                queryInterval.put(query, candidate.peek().len);
            } else {
                queryInterval.put(query, -1);
            }
        }
        return mapToArray(queries, queryInterval);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,4},{2,4},{3,6},{4,4}};
        int[]  queries = {2,3,4,5};
        System.out.println(Arrays.toString(minInterval(intervals, queries)));

        
        int[][] interval1 = {{6,6},{5,5},{10,10},{3,6},{9,9},{7,7},{2,10},{5,5},{3,7},{10,10}};
        int[] queries1 = {1,8,9,1,8,3,9,3,10,1};
        System.out.println(Arrays.toString(minInterval(interval1, queries1)));

        System.out.println(Arrays.toString(minInterval(new int[][] {{2, 3}, {2, 5}, {1, 8}, {20, 25}}, new int[]{2, 19, 5, 22})));

    }
}
