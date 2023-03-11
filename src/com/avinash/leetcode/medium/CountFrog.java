package com.avinash.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Data;


//record Pair(Integer star, Integer end) {};

// https://gist.github.com/bhaveshmunot1/9b9456999c7b53a35c87b0dae81aedf0


public class CountFrog {
	
	@Data
	class ListNode {
		Character ch;
		ListNode next;
		ListNode prev;
		Integer croakIndex;
		Integer stingIndex;
		boolean used;
		public ListNode(Character ch) {
			this.ch = ch;
		}
	};

	public void solve(String source, String croak) {
		Map<Character, Integer> lookup = new HashMap<>();
		for (int i = 0; i < croak.length();  i++) {
			lookup.put(croak.charAt(i), i);
		}
		ListNode root = this.new ListNode(source.toCharArray()[0]);
		ListNode currNode = root;
		for (int i = 1; i < source.length(); i++) {
			currNode.setNext(new ListNode(source.toCharArray()[i]));
			currNode.getNext().setStingIndex(i);
			currNode.getNext().setCroakIndex(lookup.get(source.toCharArray()[i]));
			currNode.getNext().setPrev(currNode);
			currNode = currNode.getNext();
		}
		List<List<ListNode>> croaks = new ArrayList<>();
		currNode = root;
		while(currNode != null) {
			if (currNode.getCh().equals('c')) {
				croaks.add(new ArrayList<>());
				int currentIndex = croaks.size();
				croaks.get(currentIndex).add(currNode);
				currNode.setUsed(true);
				ListNode tempNode = currNode.getNext();
				while(tempNode!= null) {
					if (!tempNode.isUsed()) {
						
					}
					tempNode = tempNode.getNext();
				}
			}
		}
	}
	
//	public static int solve(String source, String croak) {
//		int m[] = new int[26];
//		int dp[] = new int[4];
//		int ans = 0;
//		int sum = 0;
//
//		IntStream.range(0, croak.length()).forEach(i -> m[croak.charAt(i) - 'a'] = i);
//		for (char c : source.toCharArray()) {
//			int i = m[c - 'a'];
//			System.out.println("Current char : " + c + " i: " + m[c - 'a']);
//			System.out.println(Arrays.toString(dp));
//			if (i > 0) {
//				if (--dp[i - 1] < 0)
//					return -1;
//				--sum;
//			}
//			if (i < 4) {
//				++dp[i];
//				++sum;
//			}
//			ans = Math.max(ans, sum);
//		}
//		return ans;
//	}

	public static void main(String[] args) {
		String source = "crcoakroak";
//		source = "croakcroa";
		source = source.toLowerCase();
//		System.out.println(solve(source, "croak"));
		
	
	}
}
