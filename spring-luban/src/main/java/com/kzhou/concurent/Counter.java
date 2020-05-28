package com.kzhou.concurent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
	private AtomicInteger atomicInteger = new AtomicInteger(0);
	private int i = 0;

	public static void main(String[] args) {
		final Counter cas = new Counter();
		List<Thread> ts = new ArrayList<>(600);
		long start = System.currentTimeMillis();
		for (int j=0;j<100;j++){
			Thread t = new Thread(new Runnable() {
				@Override
				public void run() {
					for (int i=0;i<10000;i++){
						cas.count();
						cas.safeCount();
					}
				}
			});
			ts.add(t);
		}
		for (Thread thread:ts){
			thread.start();
		}
		for(Thread thread:ts){
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(cas.i);
		System.out.println(cas.atomicInteger);
		System.out.println(System.currentTimeMillis()-start);
	}
	private void safeCount(){
		while (true){
			int i = atomicInteger.get();
			if(atomicInteger.compareAndSet(i,++i)){
				break;
			};
		}
	}
	private void count(){
		i++;
	}
}
