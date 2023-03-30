package com.avinash.random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

// https://leetcode.com/problems/random-pick-with-blacklist/description/
/**
 * You are given an integer n and an array of unique integers blacklist. Design
 * an algorithm to pick a random integer in the range [0, n - 1] that is not in
 * blacklist. Any integer that is in the mentioned range and not in blacklist
 * should be equally likely to be returned.
 * 
 * Optimize your algorithm such that it minimizes the number of calls to the
 * built-in random function of your language.
 * 
 * Implement the Solution class:
 * 
 * Solution(int n, int[] blacklist) Initializes the object with the integer n
 * and the blacklisted integers blacklist. int pick() Returns a random integer
 * in the range [0, n - 1] and not in blacklist.
 * 
 *
 */
public class RandomPickWithBlackList {
	static class WhiteList {
		List<Integer> w;
		Random random;

		public WhiteList(int n, int[] b) {
			random = new Random();
			Set<Integer> set = new HashSet<>();
			for (int i = 0; i < n; i++)
				set.add(i);
			for (int x : b)
				set.remove(x);
			this.w = new ArrayList<>(set);
		}

		// Processing Time complexity : O(n)
		// Picking time complexity : O(1)
		public int pick() {
			return w.get(random.nextInt(this.w.size()));
		}
	}

	static class BinarySearchOverBlacklist {
		int n;
		int[] b;
		Random random;

		public BinarySearchOverBlacklist(int n, int[] blackList) {
			this.n = n;
			Arrays.sort(blackList);
			this.b = blackList;
			this.random = new Random();
		}

		// Time complexity : O(BlogB)
		public int pick() {
			int k = this.random.nextInt(n - b.length);
			int lo = 0;
			int hi = b.length - 1;
			while (lo < hi) {
				int mid = (lo + hi + 1) / 2;
				if (b[mid] - mid > k)
					hi = mid - 1;
				else
					lo = mid;
			}
			return lo == hi && b[lo] - lo <= k ? k + lo + 1 : k;
		}
	}

	static class VirtualWhitelist {
		Map<Integer, Integer> map;
		Random random;
		int wLen;

		public VirtualWhitelist(int n, int[] b) {
			map = new HashMap<>();
			random = new Random();
			wLen = n - b.length;
			Set<Integer> w = new HashSet<>();
			for (int i = 0; i < n; i++)
				w.add(i);
			for (int x : b)
				w.remove(x);
			Iterator<Integer> wi = w.iterator();
			for (int x : b) {
				if (x < wLen) {
					map.put(x, wi.next());
				}
			}
		}

		public int pick() {
			int k = random.nextInt(wLen);
			return map.getOrDefault(k, k);
		}
	}
}
