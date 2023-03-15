package com.avinash.leetcode.medium;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lombok.Data;


//record Pair(Integer star, Integer end) {};

// https://gist.github.com/bhaveshmunot1/9b9456999c7b53a35c87b0dae81aedf0

//https://leetcode.com/problems/minimum-number-of-frogs-croaking/solutions/?languageTags=java
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

//	public void solve(String source, String croak) {
//		Map<Character, Integer> lookup = new HashMap<>();
//		for (int i = 0; i < croak.length();  i++) {
//			lookup.put(croak.charAt(i), i);
//		}
//		ListNode root = this.new ListNode(source.toCharArray()[0]);
//		ListNode currNode = root;
//		for (int i = 1; i < source.length(); i++) {
//			currNode.setNext(new ListNode(source.toCharArray()[i]));
//			currNode.getNext().setStingIndex(i);
//			currNode.getNext().setCroakIndex(lookup.get(source.toCharArray()[i]));
//			currNode.getNext().setPrev(currNode);
//			currNode = currNode.getNext();
//		}
//		List<List<ListNode>> croaks = new ArrayList<>();
//		currNode = root;
//		while(currNode != null) {
//			if (currNode.getCh().equals('c')) {
//				croaks.add(new ArrayList<>());
//				int currentIndex = croaks.size();
//				croaks.get(currentIndex).add(currNode);
//				currNode.setUsed(true);
//				ListNode tempNode = currNode.getNext();
//				while(tempNode!= null) {
//					if (!tempNode.isUsed()) {
//						
//					}
//					tempNode = tempNode.getNext();
//				}
//			}
//		}
//	}
	
	public static int solve(String source, String croak) {
		int m[] = new int[26];
		int dp[] = new int[4];
		int ans = 0;
		int sum = 0;

		IntStream.range(0, croak.length()).forEach(i -> m[croak.charAt(i) - 'a'] = i);
		System.out.println(IntStream.range(65, 26 + 65).mapToObj(i -> (char)i).collect(Collectors.toList()));
		System.out.println(Arrays.toString(m));
		for (char c : source.toCharArray()) {
			int i = m[c - 'a'];
//			System.out.println("Current char : " + c + " i: " + m[c - 'a']);
//			System.out.println(Arrays.toString(dp));
			if (i > 0) {
				if (--dp[i - 1] < 0)
					return -1;
				--sum;
			}
			if (i < 4) {
				++dp[i];
				++sum;
			}
			ans = Math.max(ans, sum);
		}
		if (dp[0] + dp[1] + dp[2] + dp[3] > 0) return -1;
		return ans;
	}

	public static int minNumberOfFrogs(String croakOfFrogs) {
	    int cnt[] = new int[5];
	    int frogs = 0, max_frogs = 0;
	    for (var i = 0; i < croakOfFrogs.length(); ++i) {
	        var ch = croakOfFrogs.charAt(i);
	        var n = "croak".indexOf(ch);
	        ++cnt[n];
	        if (n == 0)
	            max_frogs = Math.max(max_frogs, ++frogs);
	        else if (--cnt[n - 1] < 0)
	            return -1;
	        else if (n == 4)
	            --frogs;
	    }
	    return frogs == 0 ? max_frogs : -1;    
	}
	
	public static int minNumberOfFrogsSwitch(String croakOfFrogs) {
        int c=0,r=0,o=0,a=0,k=0;
        int activeFrogs = 0;
        int ans = -1;
        for(char ch: croakOfFrogs.toCharArray()){
            switch(ch){
                case 'c':
                    c++;
                    activeFrogs++;
                    break;
                case 'r':
                    r++;
                    break;
                case 'o':
                    o++;
                    break;
                case 'a': 
                    a++;
                    break;
                case 'k': 
                    k++;
                    activeFrogs--;
                    break;
            }
            ans = Math.max(ans,activeFrogs);
            if(c<r || r<o || o < a || a < k)
                return -1;
            
        }
        return activeFrogs == 0 ? ans : -1;
    }

	
	public static void main(String[] args) {
		String source = "crcoakroak";
		source = "croakcroa";
		source = source.toLowerCase();
		System.out.println(solve(source, "croak"));
		System.out.println(minNumberOfFrogsSwitch(source));
	
	}
}
