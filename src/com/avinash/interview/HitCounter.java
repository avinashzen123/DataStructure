package com.avinash.interview;

import java.util.LinkedList;
import java.util.Queue;

public class HitCounter {
	
	static class UsingQueue {
		private Queue<Integer> hits;
		
		public UsingQueue() {
			this.hits = new LinkedList<>();
		}
		
		// Time complexity : O(1)
		public void hit(int timeStamp) {
			this.hits.add(timeStamp);
		}
		// Time complexity : O(n)ß
		public int getHits(int timeStamp) {
			while(!this.hits.isEmpty()) {
				int diff = timeStamp - this.hits.peek();
				if (diff >= 300) this.hits.remove();
				else break;
			}
		
			return this.hits.size();
		}
	}

}
