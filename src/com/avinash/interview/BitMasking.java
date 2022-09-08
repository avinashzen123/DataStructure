package com.avinash.interview;
import java.util.ArrayList;
import java.util.List;

public class BitMasking {
    public static List<String> allSubsets(String s) {
        List<String> result = new ArrayList<>();
        for (int counter = 0; counter < (1 << s.length()); counter++) {
            StringBuffer buffer = new StringBuffer();
            for (int j = 0; j < s.length(); j++) {
                if ((counter & (1 << j )) > 0) {
                    buffer.append(s.charAt(j));
                }
            }
            result.add(buffer.toString());
        }
        return result;
    }

    public static void printPowerSet(int[] set) {
        int set_size = set.length;
        ArrayList<String> subset = new ArrayList<String>();
        for (int counter = 0; counter < (long) Math.pow(2, set_size); counter++) {
            String temp = "";
            for (int j = 0; j < set_size; j++) {
                /*
                 * Check if jth bit in the
                 * counter is set If set then
                 * print jth element from set
                 */
                int setCounterBit = counter & (1 << j);
                if (setCounterBit > 0)
                    temp += (Integer.toString(set[j]) + '$');
            }

            if (!subset.contains(temp) && temp.length() > 0) {
                subset.add(temp);
            }
        }

        for (String s : subset) {
            s = s.replace('$', ' ');
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        printPowerSet(new int[] {1,2,3});
        System.out.println(allSubsets("abc"));
        // System.out.println(Integer.toString(2, 2));
    }
}
