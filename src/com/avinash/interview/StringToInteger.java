package com.avinash.interview;

import java.util.HashMap;
import java.util.Map;

public class StringToInteger {
	public static int myAtoi(String s) {
        s = s.trim();
        int result = 0;
        char[] charArray = s.toCharArray();
        boolean isNegative = charArray.length >= 1 && charArray[0] == '-';
        int i = charArray.length >= 1 && (charArray[0] == '-' || charArray[0] == '+') ? 1: 0;
        while (i < charArray.length && charArray[i] == '0') i++;
        for (; i < charArray.length; i++) {
            if (Character.isDigit(charArray[i])) {
                int temp = result * 10 + Integer.parseInt(charArray[i] + "");
                if (temp > result && (result * 10)/ 10 == result) {
                    result = temp;
                } else{
                    return result == 0? 0: isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
            } else {
                break;
            }
        }
        return isNegative ? -result : result;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("-42"));
        System.out.println(myAtoi("4193 with words"));
        System.out.println(myAtoi("words and 987"));
        System.out.println(myAtoi("-91283472332"));
        System.out.println(myAtoi("21474836460"));
        System.out.println(myAtoi("00000-42a1234"));
        System.out.println(myAtoi("  0000000000012345678"));
        System.out.println(myAtoi("-6147483648"));
    }

}
