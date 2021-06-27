package com.avinash.interview;

class QueueNode {
	public Integer data;
	public QueueNode next;
	
	public QueueNode(Integer data) {
		this.data = data;
	}
	
}
public class Queue {
	private QueueNode start, tail;
	
	public void push(Integer data) {
		QueueNode node = new QueueNode(data);
		if (start == null) {
			start  = node;
			tail = node;
			return;
		} else {
			tail.next = node;
			tail = node;
		}
	}
	
	public Integer poll() {
		Integer polledData = start.data;
		start = start.next;
		return polledData;
	}
	
	public static void main(String[] args) {
		Queue queue = new Queue();
		queue.push(10);
		queue.push(20);
		queue.push(30);
		queue.push(40);
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
	}

	
}
