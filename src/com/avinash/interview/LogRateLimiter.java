package com.avinash.interview;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

// https://leetcode.com/problems/logger-rate-limiter/description/
public class LogRateLimiter {
	static class Pair<U, V> {
		public U first;
		public V second;
		
		public Pair(U first, V second) {
			this.first = first;
			this.second = second;
		}
	}
	
	static class LoggerUsingSet_Queue {
		private LinkedList<Pair<String, Integer>> msgQueue;
		private HashSet<String> msgSet;
		
		LoggerUsingSet_Queue() {
			msgQueue = new LinkedList<>();
			msgSet = new HashSet<>();
		}
		
		public boolean shouldPrintMessage(int timeStamp, String message) {
			while(msgQueue.size() > 0) {
				Pair<String, Integer> head = msgQueue.getFirst();
				if (timeStamp - head.second >= 0) {
					msgQueue.remove();
					msgSet.remove(head.first);
				} else {
					break;
				}
			}
			if (!msgSet.contains(message)) {
				Pair<String, Integer> newEntry = new Pair<>(message, timeStamp);
				msgQueue.addLast(newEntry);
				msgSet.add(message);
				return true;
			} else {
				return false;
			}
		}
	}
	
	static class LoggerUsingHashMap {
		private HashMap<String, Integer> msgDict;
		public LoggerUsingHashMap() {
			this.msgDict = new HashMap<>();
		}
		public boolean shouldPrintMessage(int timeStamp, String message) {
			if (!this.msgDict.containsKey(message)) {
				this.msgDict.put(message, timeStamp);
				return true;
			} 
			Integer oldTimeStamp = this.msgDict.get(message);
			if (timeStamp - oldTimeStamp >= 10) {
				this.msgDict.put(message, timeStamp);
				return true;
			} else {
				return false;
			}
		}
	}
}
