package com.avinash.interview;

//https://youtu.be/Rsq1ObYg6ak
public class IntegerToRoman {

	public static String intToRoman(int num) {
        int[] values =   {1,    4,    5,   9,   10,   40,  50,   90, 100,  400, 500,  900, 1000};
        String[] symbols = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        StringBuffer buff = new StringBuffer();
        int i = values.length - 1;
        while(num > 0) {
            if (values[i] > num) {
                i--;
            } else {
                buff.append(symbols[i]);
                num -= values[i];
            }
        }     
        return buff.toString();
    }
	
	public static void main(String[] args) {
		System.out.println(intToRoman(1994));
	}
}
