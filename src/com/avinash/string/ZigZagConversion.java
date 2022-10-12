package com.avinash.string;

import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion {
	public static String convert(String s, int numRows) {
		if (numRows <= 1) return s;
		boolean goingDown = true;
		List<List<String>> zigZag = new ArrayList<>();
		for (int i = 0; i < numRows; i++) {
			zigZag.add(new ArrayList<>());
		}
		int curRow = 0;
		for (int i = 0; i < s.length(); i++) {
			if (goingDown) {
				zigZag.get(curRow++).add(s.charAt(i) + "");
			} else {
				zigZag.get(--curRow).add(s.charAt(i) + "");
			}
			if (curRow == numRows) {
				goingDown = false;
				curRow--;
			} else if (curRow == 0) {
				goingDown = true;
				curRow++;
			}
		}
		StringBuffer buff = new StringBuffer();
		for (List<String> list : zigZag) {
			for (String str : list) {
				buff.append(str);
			}
		}
		return buff.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(convert("PAYPALISHIRING", 3));
	}

}
