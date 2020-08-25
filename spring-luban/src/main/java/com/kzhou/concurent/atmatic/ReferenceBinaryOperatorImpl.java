package com.kzhou.concurent.atmatic;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;

public class ReferenceBinaryOperatorImpl implements BinaryOperator<AtomicDao> {

	@Override
	public AtomicDao apply(AtomicDao atomicDao, AtomicDao atomicDao2) {
		if("xiaoming".equals(atomicDao.getName()) && "kzhou".equals(atomicDao.getName()))

		return new AtomicDao("xiaoxiaozhou",5);

		return atomicDao;
	}

}
