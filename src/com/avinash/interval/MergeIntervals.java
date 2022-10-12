package com.avinash.interval;

import java.util.ArrayList;
import java.util.Arrays;
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

	public static int[][]  mergeOverlappingIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);
        int resultIndex = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (result.get(resultIndex)[1] >= intervals[i][0]) {
                result.set(resultIndex, new int[]{result.get(resultIndex)[0], Math.max(result.get(resultIndex)[1], intervals[i][1])});
            } else {
                result.add(new int[] {intervals[i][0], intervals[i][1]});
                resultIndex++;
            }
        }
        int[][] res = new int[result.size()][2];
        result.toArray(res);
        return res;
    }
	
	public static void main(String[] args) {
		
		int[][] arr = {{1, 2},{4, 7}, {3, 5},  {6, 8}, {9, 10}};
        int[][] resultList = mergeOverlappingIntervals(arr);
        Arrays.stream(resultList).map(Arrays::toString).forEach(System.out::println);
		
//		List<Interval> intervals = new ArrayList<>();
//		intervals.add(new Interval(1, 3));
//		intervals.add(new Interval(8, 10));
//		intervals.add(new Interval(2, 6));
//		intervals.add(new Interval(15, 18));
//		Collections.sort(intervals, (o1, o2) -> o1.getStart().compareTo(o2.getStart()));
//		Iterator<Interval> iterator = intervals.iterator();
//		Interval prevValue = iterator.next();
//		while(iterator.hasNext()) {
//			Interval currValue = iterator.next();
//			if (prevValue.getEnd() > currValue.getStart()) {
//				prevValue.setEnd(currValue.getEnd());
//				iterator.remove();
//			}
//		}
//		System.out.println(intervals);
	}
}
