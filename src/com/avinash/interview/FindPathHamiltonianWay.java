package com.avinash.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Stack;


public class FindPathHamiltonianWay {
	private static Stack<Vertex> stack = new Stack<>();
	private static List<Vertex> graph = new ArrayList<>();
	private static Vertex targetVertex = null;
	private static List<Vertex> path = new ArrayList<>();

	public static void main(String[] args) {
		int array[][] = { 
					{ 3, 3, 3, 1 }, 
					{ 3, 0, 3, 3 }, 
					{ 0, 3, 3, 3 }, 
					{ 0, 3, 2, 3 } };
//		int array[][] = { { 0, 3, 0, 1 }, {   0, 3, 3, 2 } };
		Vertex v1 = new Vertex(0, 0);
		stack.push(v1);
		buildGraph(array);
		System.out.println(" Printing path ");
//		graph.stream().forEach(System.out::println);
		System.out.println(hamiltonianUtil(array, v1));
		System.out.println("Target vertex " + targetVertex  + " Parent " + targetVertex.parent);
	} 
	
	private static boolean hamiltonianUtil(int[][] array, Vertex vertex) {
		if (vertex.i == targetVertex.i && vertex.j == targetVertex.j) {
			System.out.println(targetVertex +  " Hamiltonian " + path);
			return true;
		}
		for (Vertex v : vertex.vertexs) {
			if (!path.contains(v)) {
				path.add(v);
				boolean foundPath = false;
				for (Vertex v1: vertex.vertexs) {
					path.add(v1);
					if (hamiltonianUtil(array, v1.vertexs.get(0))) {
						foundPath = true;
						return true;
					} else {
						path.remove(v1);
					}
				}
				if (!foundPath) {
					path.remove(v);
				}
				
			}
		}
		System.out.println(targetVertex +  " Hamiltonian " + path);
		return true;
	}
	
	public static Vertex buildGraph(int[][] array) {
		while (!stack.isEmpty()) {
			Vertex pop = stack.pop();
			List<Vertex> adjacent = new ArrayList<>();
			if (hasValidValue(array, pop.i + 1, pop.j)) {
				stack.add(new Vertex(pop.i + 1, pop.j));
				adjacent.add(stack.peek());
			}
			if (hasValidValue(array, pop.i, pop.j + 1)) {
				stack.add(new Vertex(pop.i, pop.j + 1));
				adjacent.add(stack.peek());
			}
			if (hasValidValue(array, pop.i + 1, pop.j + 1)) {
				stack.add(new Vertex(pop.i, pop.j + 1));
				adjacent.add(stack.peek());
			}
			if (adjacent.size() > 0) {
				graph.add(pop);
				adjacent.stream().forEach(v -> v.parent = pop);
				Optional<Vertex> findAny = adjacent.stream().filter(v -> v.getValue(array) == 2).findAny();
				if (findAny.isPresent()) {
					targetVertex = findAny.get();
				}
				//.ifPresent(v -> targetVertex = v);
				pop.vertexs.addAll(adjacent);
			}
		}
		return null;
	}

	private static boolean hasValidValue(int[][] array, int i, int j) {
		try {
			return array[i][j] != 0;
		} catch (ArrayIndexOutOfBoundsException e) {
			return false;
		}
	}
}

class Vertex {
	public int i;
	public int j;
	public List<Vertex> vertexs = new ArrayList<>();
	public Vertex parent;

	public Vertex(int i, int j) {
		super();
		this.i = i;
		this.j = j;
	}

	public int getValue(int[][] array) {
		return array[i][j];
	}

	@Override
	public String toString() {
		return ""+ i + "," + j;

	}

}