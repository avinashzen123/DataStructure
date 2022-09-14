package com.avinash.stack;
import java.util.Arrays;
import java.util.Stack;

public class DailyTemperature {
    /*
     * Given an array of integers temperatures represents the daily temperatures,
     * return an array answer such that answer[i] is the number of days you have to
     * wait after the ith day to get a warmer temperature. If there is no future day
     * for which this is possible, keep answer[i] == 0 instead.
     * 
     * Input: temperatures = [73,74,75,71,69,72,76,73]
     * Output: [1,1,4,2,1,1,0,0]
     */
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int curDay = 0; curDay < temperatures.length; curDay++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[curDay]) {
                int prevDay = stack.pop();
                result[prevDay] = curDay - prevDay;
            }
            stack.push(curDay);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] dailyTemperatures = dailyTemperatures(new int[] {73,74,75,71,69,72,76,73});
        System.out.println(Arrays.toString(dailyTemperatures));
    }
}