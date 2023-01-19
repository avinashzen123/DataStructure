package com.avinash.dynamic;

import java.util.HashMap;

// https://leetcode.com/problems/delete-and-earn/solutions/1818112/official-solution/
class TopDownApproach {
    private HashMap<Integer, Integer> points = new HashMap<>();
    private HashMap<Integer, Integer> cache = new HashMap<>();

    private int maxPoints(int num) {
        if (num == 0)
            return 0;
        if (num == 1)
            return cache.getOrDefault(num, 0);
        if (cache.containsKey(num))
            return cache.get(num);
        cache.put(num, Math.max(maxPoints(num - 1), maxPoints(num - 2) + points.getOrDefault(num, 0)));
        return cache.get(num);
    }

    public int deleteAndEarn(int[] nums) {
        int maxNumber = 0;
        for (int num : nums) {
            points.put(num, points.getOrDefault(num, 0) + num);
            maxNumber = Math.max(maxNumber, num);
        }
        int result = maxPoints(maxNumber);
        return result;
    }
}

/*
 * In the top-down approach, we start at the "top" (maxNumber), and move towards
 * our base cases (maxPoints[0] = 0, maxPoints[1] = nums.count(1)). With
 * bottom-up, we will start at the base cases and iterate away from them towards
 * the result we want (maxNumber).
 * 
 * For this approach, instead of having maxPoints be a recursive function, we
 * will have it be an array where maxPoints[num] stores the maximum points we
 * can gain if we consider only numbers from 0 to num. As you can see, this is
 * just a different way to format maxPoints, but in terms of functionality, it
 * will be the same as the previous approach.
 * 
 * Algorithm
 * 
 * Declare a hash table points that will map elements to the amount of points
 * that we can gain from taking each element.
 * 
 * Loop through nums once to populate points and find the largest element in
 * nums, maxNumber.
 * 
 * Initialize an array maxPoints of size maxNumber + 1, where maxPoints[num]
 * will store the maximum amount of points we can gain if we only considered
 * numbers from 0 to num (inclusive). Set all the values to 0 initially, except
 * for maxPoints[1] - it should be set to points[1] (our base case).
 * 
 * Iterate from 2 to maxNumber. At each iteration, apply the recurrence relation
 * maxPoints[num] = max(maxPoints[num - 1], maxPoints[num - 2] + points[num]) to
 * populate maxPoints.
 * 
 * At the end, return maxPoints[maxNumber].
 * 
 */
class BottomUpApporach {
    public int deleteAndEarn(int[] nums) {
        HashMap<Integer, Integer> points = new HashMap<>();
        int maxNumber = 0;
        for (int num : nums) {
            points.put(num, points.getOrDefault(num, 0) + num);
            maxNumber = Math.max(maxNumber, num);
        }
        int[] maxPoints = new int[maxNumber + 1];
        maxPoints[1] = points.getOrDefault(1, 0);
        for (int point = 2; point < maxPoints.length; point++) {
            maxPoints[point] = Math.max(maxPoints[point - 1], maxPoints[point - 2] + points.getOrDefault(point, 0));
        }
        return maxPoints[maxNumber];
    }
}

class SpaceOptimizedBottomUp {
    public int deleteAndEarn(int[] nums) {
        int maxNumber = 0;
        HashMap<Integer, Integer> points = new HashMap<>();
        for (int num : nums) {
            points.put(num, points.getOrDefault(num, 0) + num);
            maxNumber = Math.max(maxNumber, num);
        }
        int towBack = 0;
        int oneBack = points.getOrDefault(1, 0);
        for (int i = 2; i <= maxNumber ; i ++) {
            int temp = oneBack;
            oneBack = Math.max(oneBack, towBack + points.getOrDefault(i, 0));
            towBack = temp;
        }
        return oneBack;
    }
}

public class DeleteAndEarn {

    public static void main(String[] args) {
        System.out.println(new TopDownApproach().deleteAndEarn(new int[] { 2, 2, 3, 3, 3, 4 }));
        System.out.println(new BottomUpApporach().deleteAndEarn(new int[] { 2, 2, 3, 3, 3, 4 }));
        System.out.println(new SpaceOptimizedBottomUp().deleteAndEarn(new int[] { 2, 2, 3, 3, 3, 4 }));
    }
}