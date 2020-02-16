package com.gshar.dsalgo.multithreading;


/** This code does the increment in parallel using multiple threads.
 *  Note worthy points are :
 *  1: using volatile does no help in the line "private static int counter=0;"
 *  	It means that cache flush is not problem.
 *  	The increment operation is not atomic in the function inc().
 *  2: The thread was created by implementing the interface Runnable.
 *  	It could also have been created by extending Thread class.
 *  3: Instead of calling threads[i].start() multiple times, we could have used ExecutorService.
 *  4: Instead of threads[i].join(), we could have used CyclicBarrier, CountdownLatch or something similar.
 *  5: Making the function inc() synchronized solves the problem, even if I don't make the `counter` volatile. */

public class IncrementParallelPrimitive {
	private static int counter=0;
	private static final int ITER_COUNTER=1_00_000;
	private static final int thread_count=3;
	
	public static void inc() {
		counter++;
	}
	
	static class MyThread implements Runnable{
		public void run() {
			for(int i=0;i<ITER_COUNTER;i++) {
				inc();
			}
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
		
		for(int i=0;i<thread_count;i++) {
			threads[i].join();
		}
		
		System.out.println(counter);
		
	}
	
	
}
