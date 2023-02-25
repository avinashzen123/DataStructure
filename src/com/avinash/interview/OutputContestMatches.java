package com.avinash.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

// https://leetcode.com/problems/output-contest-matches/submissions/904451171/
public class OutputContestMatches {
	public String findContestMatch(int n) {
        List<String> matches = IntStream.rangeClosed(1, n)
        		.mapToObj(String::valueOf).toList();
        System.out.println(matches);
        while(matches.size() > 1) {
        	List<String> curMatches = new ArrayList<>();
        	for (int i = 0; i < matches.size() / 2; i++) {
        		curMatches.add("(" + matches.get(i) + "," + matches.get(matches.size() - i - 1)+ ")");
        	}
        	
        	System.out.println(curMatches);
        	matches = curMatches;
        }
        return matches.get(0);
    }
	
	public static void main(String[] args) {
		System.out.println(new OutputContestMatches().findContestMatch(8));
	}
}
