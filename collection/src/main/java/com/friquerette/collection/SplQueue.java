package com.friquerette.collection;

import java.util.ArrayDeque;
import java.util.Deque;

class SplQueue {
	private Deque<String> splQ = new ArrayDeque<>();

	void addInQueue(String customer) {
		splQ.addLast(customer);
	}

	void removeFront() {
		splQ.removeFirst();
	}

	void removeBack() {
		splQ.removeLast();
	}

	void printQueue() {
		System.out.println("Special queue contains: " + splQ);
	}
}
