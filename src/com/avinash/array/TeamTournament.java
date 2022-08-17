package com.avinash.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TeamTournament {

	public static String tournamentWinner(List<List<String>> competitions, List<Integer> results) {
		// Write your code here.
		Map<String, Integer> teamScore = new HashMap<>();

		for (int i = 0; i < competitions.size(); i++) {
			List<String> pair = competitions.get(i);
			Integer winner = results.get(i) == 0 ? 1: 0;
			if (teamScore.containsKey(pair.get(winner))) {
				teamScore.put(pair.get(winner), teamScore.get(pair.get(winner)) + 3);
			} else {
				teamScore.put(pair.get(winner), 3);
			}
		}

		int topScore = Integer.MIN_VALUE;
		String topTeam = "";
		for (Map.Entry<String, Integer> entry : teamScore.entrySet()) {
			Integer currentScore = entry.getValue();
			if (currentScore > topScore) {
				topScore = currentScore;
				topTeam = entry.getKey();
			}
		}
		System.out.println(teamScore);
		return topTeam;
	}
	
	public static void main(String[] args) {
		List<List<String>> competitions = new ArrayList<>();
//		competitions.add(List.of("Bulls", "Eagles"));
//		competitions.add(List.of("Bulls", "Bears"));
//		competitions.add(List.of("Bulls", "Monkeys"));
//		competitions.add(List.of("Eagles", "Bears"));
//		competitions.add(List.of("Eagles", "Monkeys"));
//		competitions.add(List.of("Bears", "Monkeys"));
//		List<Integer>	results = List.of(1, 1, 1, 1, 1, 1);
		competitions.add(List.of("Bulls", "Eagles"));
		List<Integer>	results = List.of(1);
		System.out.println(tournamentWinner(competitions, results));
	}
}
