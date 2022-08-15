package com.avinash.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import lombok.Data;

@Data
class Node {
	private Integer start;
	private Integer end;
}

public class InsertInterval {
	
	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(1, 2));
		intervals.add(new Interval(3, 5));
		intervals.add(new Interval(6, 7));
		intervals.add(new Interval(8, 10));
		intervals.add(new Interval(12, 16));
		Collections.sort(intervals, (o1, o2) -> o1.getStart().compareTo(o2.getEnd()));
		Interval newInterval = new Interval(4, 9);
		
		Iterator<Interval> iterator = intervals.iterator();
		List<Interval> result = new ArrayList<>();
		
		while (iterator.hasNext()) {
			Interval currentInterval = iterator.next();
			if (currentInterval.getEnd() < newInterval.getStart()) {
				result.add(currentInterval);
			}
		}
	}
}
