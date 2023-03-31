package com.avinash.graph.disjointset;

import java.util.Arrays;
import java.util.Comparator;

// https://leetcode.com/problems/the-earliest-moment-when-everyone-become-friends/description/
/**
 * There are n people in a social group labeled from 0 to n - 1. You are given
 * an array logs where logs[i] = [timestampi, xi, yi] indicates that xi and yi
 * will be friends at the time timestampi.
 * 
 * Friendship is symmetric. That means if a is friends with b, then b is friends
 * with a. Also, person a is acquainted with a person b if a is friends with b,
 * or a is a friend of someone acquainted with b.
 * 
 * Return the earliest time for which every person became acquainted with every
 * other person. If there is no such earliest time, return -1.
 * 
 * Input: logs = [[0,2,0},{1,0,1},{3,0,3},{4,1,2},{7,3,1]], n = 4
 * 
 * Output: 3
 * 
 * Explanation: At timestamp = 3, all the persons (i.e., 0, 1, 2, and 3) become
 * friends.
 *
 * 
 */
public class EarliestMomentToBeFriends {

	static class UnionFind {
		private int[] groups;
		private int[] rank;

		public UnionFind(int size) {
			this.groups = new int[size];
			this.rank = new int[size];
			for (int person = 0; person < size; person++) {
				this.groups[person] = person;
				this.rank[person] = 0;
			}
		}

		public int find(int person) {
			if (this.groups[person] != person) {
				this.groups[person] = this.find(this.groups[person]);
			}
			return this.groups[person];
		}

		private boolean union(int a, int b) {
			int groupA = this.find(a);
			int groupB = this.find(b);
			boolean isMerged = false;

			if (groupA == groupB) {
				return isMerged;
			}
			isMerged = true;
			if (rank[groupA] > this.rank[groupB]) {
				this.groups[groupB] = groupB;
			} else if (rank[groupA] < this.rank[groupB]) {
				this.groups[groupA] = groupB;
			} else {
				this.groups[groupA] = groupB;
				this.rank[groupB] += 1;
			}
			return isMerged;
		}
	}

	public int earliestAcq(int[][] logs, int n) {
		Arrays.sort(logs, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[0], o2[0]);
			}
		});
		int groupCount = n;
		UnionFind uf = new UnionFind(n);
		for (int[] log : logs) {
			int timeStamp = log[0];
			int friendA = log[1];
			int friendB = log[2];
			if (uf.union(friendA, friendB)) {
				groupCount -= 1;
			}
			if (groupCount == 1) {
				return timeStamp;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[][] logs = { { 20190101, 0, 1 }, { 20190104, 3, 4 }, { 20190107, 2, 3 }, { 20190211, 1, 5 },
				{ 20190224, 2, 4 }, { 20190301, 0, 3 }, { 20190312, 1, 2 }, { 20190322, 4, 5 } };
		int n = 6;
		EarliestMomentToBeFriends beFriends = new EarliestMomentToBeFriends();
		System.out.println(beFriends.earliestAcq(logs, n));
	}

}
