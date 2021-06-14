package com.avinash.traversal.maze;
public class App {

	public static void main(String[] args) {
		
		FileReader fileReader = new FileReader("map.txt", 5, 5);
		fileReader.parseFile();
		MazeSolver mazeSolver = new MazeSolver(fileReader.getMap(),fileReader.getStartPositionRow(),fileReader.getStartPositionCol());
		mazeSolver.findWayOut();
		
	}
}