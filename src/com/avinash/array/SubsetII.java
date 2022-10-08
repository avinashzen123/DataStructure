package com.avinash.array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/subsets-ii/submissions/
public class SubsetII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        subsets(0, nums, result, new ArrayList<>());
        return result;
    }
    private void subsets(int currIndex, int[] nums, List<List<Integer>> result, ArrayList<Integer> arrayList) {
        if (currIndex >= nums.length) {
            result.add(new ArrayList<>(arrayList));
            return;
        }
        arrayList.add(nums[currIndex]);
        subsets(currIndex+1, nums, result, arrayList);
        arrayList.remove(arrayList.size() - 1);
        while(currIndex + 1 < nums.length && nums[currIndex] == nums[currIndex + 1]) {
            currIndex++;
        }
        subsets(currIndex + 1, nums, result, arrayList);
        
    }

    public static void main(String[] args) {
        System.out.println(new SubsetII().subsetsWithDup(new int[] {1,2,2}));
    }
}
