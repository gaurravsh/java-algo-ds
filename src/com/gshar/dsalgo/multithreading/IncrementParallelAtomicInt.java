package com.gshar.dsalgo.multithreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/** This code does the increment in parallel using multiple threads.
 *  Note worthy points are :
 *  1: Use of Atomic Integer
 *  2: Use of CountDownLatch. CyclicBarrier can also be used for this.
 *  */

public class IncrementParallelAtomicInt {
	private static AtomicInteger counter = new AtomicInteger(0);
	private static final int ITER_COUNTER=1_00_000;
	private static final int thread_count=3;
	private static CountDownLatch latch = new CountDownLatch(thread_count);
	
	public static void inc() {
		counter.incrementAndGet();
	}
	
	static class MyThread implements Runnable{
		public void run() {
			for(int i=0;i<ITER_COUNTER;i++) {
				inc();
			}
			latch.countDown();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		Thread[] threads = new Thread[thread_count];
		for(int i=0;i<thread_count;i++) {
			threads[i] = new Thread(new MyThread());
		}
		for(int i=0;i<thread_count;i++) {
			threads[i].start();
		}
		
		latch.await();
		System.out.println(counter.intValue());
		
	}
}
