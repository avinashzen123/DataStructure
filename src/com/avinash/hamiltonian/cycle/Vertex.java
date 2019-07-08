package com.avinash.hamiltonian.cycle;

public class Vertex {
	private final Integer id;
	
	public Vertex(Integer id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return this.id.toString();
	}
}
