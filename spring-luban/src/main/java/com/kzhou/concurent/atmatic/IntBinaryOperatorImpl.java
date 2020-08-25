package com.kzhou.concurent.atmatic;

import java.util.function.IntBinaryOperator;

public class IntBinaryOperatorImpl implements IntBinaryOperator {

	@Override
	public int applyAsInt(int left, int right) {
		return left * right;
	}
}
