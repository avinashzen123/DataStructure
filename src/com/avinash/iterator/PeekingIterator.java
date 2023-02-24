package com.avinash.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class PeekingIterator implements Iterator<Integer> {
	private Iterator<Integer> iter;
	private Integer peekedValue = null;
	
	public PeekingIterator(Iterator<Integer> iterator) {
		this.iter = iterator;
	}
	
	@Override
	public boolean hasNext() {
		return peekedValue != null || iter.hasNext();
	}

	@Override
	public Integer next() {
		if (peekedValue != null) {
			Integer toReturn = peekedValue;
			peekedValue = null;
			return toReturn;
		}
		if (!iter.hasNext()) {
			throw new NoSuchElementException();
		}
		return iter.next();
	}
	
	public Integer peek() {
		if (peekedValue == null) {
			if (!iter.hasNext()) {
				throw new NoSuchElementException();
			}
			peekedValue = iter.next();
		}
		return peekedValue;
	}
	
	public static void main(String[] args) {
	}
}
