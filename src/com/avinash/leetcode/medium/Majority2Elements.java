package com.avinash.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Majority2Elements {

	public static List<Integer> majorityElement(int[] nums) {
		Integer candidate1 = null;
        Integer candidate2 = null;
        int count1 = 0;
        int count2 = 0;
        for (int num : nums) {
            if (candidate1 != null && num == candidate1) {
                count1++;
            } else if (candidate2 != null && num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1++;
            } else if (count2 == 0) {
                candidate2 = num;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (candidate1 != null && num == candidate1) count1++;
            if (candidate2 != null && num == candidate2) count2++;
        }
        List<Integer> result = new ArrayList<>();
        if (count1 > nums.length / 3) result.add(candidate1);
        if (count2 > nums.length / 3) result.add(candidate2);
        return result;
       
	}

	public static void main(String[] args) {
		List<Integer> majorityElement = majorityElement(new int[] { 3, 2, 3 });
		System.out.println("Majority Element " + majorityElement);
		System.out.println(majorityElement(new int[] { 0,0,0 }));
		System.out.println(majorityElement(new int[] { 2,1,1,3,1,4,5,6 }));
	}
}
