package com.gshar.dsalgo.multithreading;

import java.util.concurrent.atomic.AtomicInteger;

public class MultipleThreadSequentialIncrement {
	private static AtomicInteger atomicInt=new AtomicInteger(0);
	private static final int limit =100;
	private static final int threadCount=3;
	
	static Object monitor = new Object();
	public static class MyThread extends Thread{
		@Override
		public void run() {
			synchronized(monitor) {
			while(atomicInt.get()<limit) {
				System.out.println(atomicInt.incrementAndGet());
			}
			}
		}
	}
	
	public static void main(String[] args) {
		Thread[] threads = new Thread[threadCount];
		for(int i=0; i<threadCount;i++) {
			threads[i]=new MyThread();
			threads[i].start();
		}
		
	}

}
