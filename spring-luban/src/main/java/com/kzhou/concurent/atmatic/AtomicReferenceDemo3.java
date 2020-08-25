package com.kzhou.concurent.atmatic;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * 第三种类型就是引用类型，也即是类
 */
public class AtomicReferenceDemo3 {

	private static AtomicReference<AtomicDao> atomicReference = new AtomicReference<>();
	private static AtomicDao atomicDao = new AtomicDao("kzhou",25);
	private static AtomicStampedReference<AtomicDao> atomicStampedReference = new AtomicStampedReference<>(atomicDao,1);

	public static void main(String[] args) {
		AtomicDao atomicDao = new AtomicDao("xiaoming",24);
		atomicReference.set(atomicDao);
		System.out.println(atomicReference.accumulateAndGet(atomicDao, new ReferenceBinaryOperatorImpl()).getName());

	}
}
