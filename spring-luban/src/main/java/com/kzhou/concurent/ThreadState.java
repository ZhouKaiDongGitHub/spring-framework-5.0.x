package com.kzhou.concurent;

import java.util.concurrent.TimeUnit;

/**
 * 线程状态：
 * 		OS  1.new 初始化创建的线程 2.runnable可运行状态，等待时间片分配  3.running运行状态 4.blocked 发生I/O中断等 5.dead 死亡状态
 * 		Java 1.new 初始化创建的   2.runnable就绪运行状态  3.blocked阻塞状态 4.waiting等待状态，等待处理其他线程任务  5time_wating超时等待  6 terminated终止状态
 *
 */
public class ThreadState {
	public static void main(String[] args) {
		new Thread(new TimeWaiting(),"TimeWaitingThread").start();
		new Thread(new Waiting(),"WaitingThread").start();
		new Thread(new Blocked(),"Blocked-1").start();
		new Thread(new Blocked(),"Blocked-2").start();
	}
	static class TimeWaiting implements Runnable{
		public void run(){
			while (true){
				try {
					TimeUnit.SECONDS.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	static class Waiting implements Runnable{
		public void run(){
			while (true){
				synchronized (Waiting.class){
					try {
						Waiting.class.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	static class Blocked implements Runnable{
		@Override
		public void run() {
			while (true){
				synchronized (Blocked.class){
					try {
						TimeUnit.SECONDS.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
