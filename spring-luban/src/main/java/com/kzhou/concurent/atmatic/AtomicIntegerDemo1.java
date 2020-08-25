package com.kzhou.concurent.atmatic;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.IntBinaryOperator;

/**
 * 原子操作有两个方法1.循环CAS 2.synchronized 区别在于一个是阻塞的，一个是非阻塞的
 * jdk提供的JUC包中的atomic工具类通过CAS乐观锁实现非阻塞改变数据
 * 数据的类型（JUC Atomic这边的划分）有一下4种
 * 1.基本数据类型
 * 2.数组
 * 3.对象（类）
 * 4.对象中的属性
 */
public class AtomicIntegerDemo1 {

	//对于基本数据类型，Atomic只提供了三种，其他的可以自己扩展
	private static AtomicInteger atomicInteger = new AtomicInteger(1);
	private static AtomicLong atomicLong = new AtomicLong();
	private static AtomicBoolean atomicBoolean = new AtomicBoolean();

	public static void main(String[] args) {
		System.out.println(atomicInteger.getAndIncrement());// 1
		System.out.println(atomicInteger.incrementAndGet());// 3
		atomicInteger.compareAndSet(3,5);// true/false
		System.out.println(atomicInteger.getAndSet(10)); //5
		atomicInteger.lazySet(20); //cas竞争非常激烈的时候使用
		System.out.println(atomicInteger.get());// 20

		atomicBoolean.get();
		atomicBoolean.set(true);
		atomicBoolean.compareAndSet(true,false);
	}
}
