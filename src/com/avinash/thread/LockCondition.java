package com.avinash.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockCondition {
	private Lock lock ;
	private Condition oddCondition ;
	private Condition evenCondition;
	private AtomicInteger atomicInteger;
	public LockCondition() {
		lock = new ReentrantLock();
		oddCondition = lock.newCondition();
		evenCondition = lock.newCondition();
		atomicInteger = new AtomicInteger();
	}
	
	Thread oddThread = new Thread() {
		public synchronized void run() {
			while(true) {
				while(atomicInteger.get() % 2 != 0) {
					try {
						lock.tryLock(10, TimeUnit.MILLISECONDS);
						evenCondition.await(10, TimeUnit.MILLISECONDS);
					} catch (InterruptedException e) {
						e.printStackTrace();	
					}
					System.out.println("Odd Thred " + atomicInteger.getAndAdd(1));
					oddCondition.signal();
					lock.unlock();
				}
			}
			
		};
	};
	
	Thread eventThread = new Thread() {
		public synchronized void run() {
			while(true) {
				while(atomicInteger.get() % 2 == 0) {
					try {
						lock.tryLock(10, TimeUnit.MILLISECONDS);
						oddCondition.await(1, TimeUnit.SECONDS);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("Even Thread " + atomicInteger.getAndAdd(1));
					evenCondition.signal();
					lock.unlock();

				}
			}
		};
	};
	
	public static void main(String[] args) throws InterruptedException {
		LockCondition  condition = new LockCondition();
		condition.oddThread.start();
		condition.eventThread.start();
		condition.oddThread.join();
		condition.eventThread.join();
	}
}
