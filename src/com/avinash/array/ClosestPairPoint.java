package com.avinash.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import static java.lang.Math.*;

@Data
@AllArgsConstructor
@ToString(includeFieldNames = true)
class Point {
	private double x, y;
}

@AllArgsConstructor
public class ClosestPairPoint {
	List<Point> points;

	public double solveProblem() {
		List<Point> sortedXPoints = points.stream().sorted((o1, o2) -> Double.compare(o1.getX(), o2.getX()))
				.collect(Collectors.toList());
		List<Point> sortedYPoints = points.stream().sorted((o1, o2) -> Double.compare(o1.getY(), o2.getY()))
				.collect(Collectors.toList());
		return findClosestPoint(sortedXPoints, sortedYPoints, sortedXPoints.size());
	}

	private double findClosestPoint(List<Point> sortedXPoints, List<Point> sortedYPoints, int numberOfPoints) {
		if (numberOfPoints <= 3) {
			return bruteForceSearch(sortedXPoints);
		}
		int middleIndex = numberOfPoints / 2;
		Point middlePoint = sortedXPoints.get(middleIndex);
		// Divide the data set into left and right subarrays.
		List<Point> leftSubPointsSorted = sortedXPoints.subList(0, middleIndex);
		List<Point> rightSubPointsSorted = sortedXPoints.subList(middleIndex, numberOfPoints);

		// We need to find the Closest point in the left and right sub-array
		double deltaLeft = findClosestPoint(leftSubPointsSorted, sortedYPoints, middleIndex);
		double deltaRight = findClosestPoint(rightSubPointsSorted, sortedYPoints, numberOfPoints - middleIndex);

		double delta = Math.min(deltaLeft, deltaRight);

		List<Point> pointsInStrip = new ArrayList<>();
		// Linear search for items that will fall within the strip [middleItem.x -
		// delta, middleItem.x + delta]
		for (int index = 0; index < numberOfPoints; index++) {
			if (Math.abs(sortedYPoints.get(index).getX() - middlePoint.getX()) < delta) {
				pointsInStrip.add(sortedYPoints.get(index));
			}
		}

		double minDistanceStrip = findMinimumDistanceInStrip(pointsInStrip, delta);

		return Math.max(delta, minDistanceStrip);
	}

	private double findMinimumDistanceInStrip(List<Point> points, double delta) {
		double minDistance = delta;
		for (int i = 0 ; i < points.size(); i++) {
			for (int j = i + 1; j < points.size() && (points.get(j).getY() - points.get(i).getY()) < minDistance; j++) {
				minDistance = distance(points.get(i), points.get(j));
			}
		}
 		return minDistance;
	}

	private double bruteForceSearch(List<Point> points) {
		double minDistance = Double.MAX_VALUE;
		for (int i = 0; i < points.size(); i++) {
			for (int j = i + 1; j < points.size(); j++) {
				double actualDistance = distance(points.get(i), points.get(j));
				if (actualDistance < minDistance) {
					minDistance = actualDistance;
				}
			}
		}
		return minDistance;
	}

	private double distance(Point point, Point point2) {
		return sqrt(pow(abs(point.getX() - point2.getX()), 2)
				+ pow(abs(point.getY() - point2.getY()), 2));
	}
	
	public static void main(String[] args) {
		List<Point> points = Arrays.asList(
				new Point(2, 3),
				new Point(3,3),
				new Point(1,1),
				new Point(1,2),
				new Point(2,1),
				new Point(2,2));
		ClosestPairPoint closestPairPoint = new ClosestPairPoint(points);
		System.out.println(closestPairPoint.solveProblem());
	}
}
