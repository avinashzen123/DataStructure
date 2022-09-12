package com.avinash.sliding.window;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

// https://leetcode.com/problems/sliding-window-maximum/
// https://www.youtube.com/watch?v=DfljaUwZsOk
public class SlidingWindoMax {
    
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        int low = 0;
        int high = 0;
        Deque<Integer> deque = new LinkedList<>();
        while(high < nums.length) {
            while (!deque.isEmpty() && deque.getLast() < nums[high]) 
                deque.removeLast();
            deque.add(nums[high]);
            if (high - low + 1 == k) {
                result[low] = deque.getFirst();
                if (nums[low] == deque.getFirst()) {
                    deque.removeFirst();
                }
                low++;
            }
            high++;
        }
        return result;
    }

    public static void main(String[] args) {

        // Arrays.stream(new int[] {1,3,-1,-3,5,3,6,7}).
        int[] result = maxSlidingWindow(new int[] {1,3,-1,-3,5,3,6,7}, 3);
        System.out.println(Arrays.toString(result));
    }
}
