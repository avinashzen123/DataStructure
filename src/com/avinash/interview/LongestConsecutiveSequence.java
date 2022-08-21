package com.avinash.interview;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

	public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0;
        for (int num: nums) set.add(num);
        for (int num : nums) {
            int left = num - 1;
            int right = num + 1;
            int count = 1;
            while(set.contains(left)) {
                count++;
                set.remove(left);
                left --;
            } 
            while(set.contains(right)) {
                count ++;
                set.remove(right);
                right++;
            }
            max = Math.max(max, count);
        }
        return max;
    }
	
	public static void main(String[] args) {
		System.out.println(longestConsecutive(new int[] {100,4,200,1,3,2}));
	}
}
