package com.avinash.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
class Interval {
	Integer start;
	Integer end;
};

public class MergeIntervals {

	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(1, 3));
		intervals.add(new Interval(8, 10));
		intervals.add(new Interval(2, 6));
		intervals.add(new Interval(15, 18));
		Collections.sort(intervals, (o1, o2) -> o1.getStart().compareTo(o2.getStart()));
		Iterator<Interval> iterator = intervals.iterator();
		Interval prevValue = iterator.next();
		while(iterator.hasNext()) {
			Interval currValue = iterator.next();
			if (prevValue.getEnd() > currValue.getStart()) {
				prevValue.setEnd(currValue.getEnd());
				iterator.remove();
			}
		}
		System.out.println(intervals);
	}
}
