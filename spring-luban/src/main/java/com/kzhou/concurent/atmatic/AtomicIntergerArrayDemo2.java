package com.kzhou.concurent.atmatic;

import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReferenceArray;

/**
 * 第二种类型：数组原子操作，数组的原子操作不改变原数组的结果，只返回复制的数组的操作结果
 */
public class AtomicIntergerArrayDemo2 {

	private static AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(new int[]{1,2,3,4,5,6,7,8,9,10});
	private static AtomicLongArray atomicLongArray = new AtomicLongArray(10);
	private static AtomicReferenceArray<AtomicDao> atomicReferenceArray = new AtomicReferenceArray<>(
			new AtomicDao[]{new AtomicDao("kzhou",25),new AtomicDao("xiaoming",24)}
	);

	public static void main(String[] args) {

		System.out.println(atomicIntegerArray.getAndSet(0, 100));//1
		System.out.println(atomicIntegerArray.get(0));//100
		System.out.println(atomicIntegerArray.getAndAccumulate(1, 100, new IntBinaryOperatorImpl())); //2*100=200
		atomicIntegerArray.compareAndSet(2,3,300);// true/false
		System.out.println(atomicIntegerArray.get(2));//300

		AtomicDao atomicDao = atomicReferenceArray.get(0);
		atomicDao.setAge(18);
		System.out.println(atomicDao.hashCode());
		AtomicDao atomicDaoTemp = new AtomicDao("changfei",30);
		System.out.println(atomicDaoTemp.hashCode());// example 195600860
		System.out.println(atomicReferenceArray.compareAndSet(0, atomicDao, atomicDaoTemp));//true
		System.out.println(atomicReferenceArray.get(0).hashCode());// == below 195600860
	}

}
