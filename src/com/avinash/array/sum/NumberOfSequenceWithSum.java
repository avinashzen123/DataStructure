package com.avinash.array.sum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
// https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/
public class NumberOfSequenceWithSum {

	// Not optimised
	static int numSubseq(int[] nums, int target) {
		List<List<Integer>> subSequences = new ArrayList<>();
        genereateSeq(nums, subSequences, new ArrayList<>(), target, 0);
        System.out.println(subSequences);
        List<List<Integer>> collect = subSequences.stream().filter(seq -> !seq.isEmpty()).filter(seq -> Collections.max(seq) + Collections.min(seq) <= target).collect(Collectors.toList());
        System.out.println(collect);
        return collect.size();
	}
	
	static void genereateSeq (int[] nums, List<List<Integer>> subSequences, List<Integer> curSeq, int target, int index) {
        if (index == nums.length) {
            subSequences.add(new ArrayList<>(curSeq));
        } else {
            curSeq.add(nums[index]);
            genereateSeq(nums, subSequences, curSeq, target, index + 1);
            curSeq.remove(curSeq.size() - 1);
            genereateSeq(nums, subSequences, curSeq, target, index + 1);
        }
    }

	public static void main(String[] args) {
		int[] nums = { 3,  5, 6, 7 };
		int target = 9;
		System.out.println(numSubseq(nums, target));
		
		int[] nums1 = {14,4,6,6,20,8,5,6,8,12,6,10,14,9,17,16,9,7,14,11,14,15,13,11,10,18,13,17,17,14,17,7,9,5,10,13,8,5,18,20,7,5,5,15,19,14};
		System.out.println(numSubseq(nums1, 21));
	}
}
