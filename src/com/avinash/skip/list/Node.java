package com.avinash.skip.list;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@ToString(exclude = {"nextLevel", "next"})
public class Node<T extends Comparable<T>> implements Comparable<T> {

	private final T data;
	private Node<T> nextLevel;
	private Node<T> next;

	@Override
	public int compareTo(T o) {
		return data.compareTo(o);
	}
}
