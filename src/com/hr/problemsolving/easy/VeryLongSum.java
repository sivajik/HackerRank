package com.hr.problemsolving.easy;

import java.math.BigInteger;

public class VeryLongSum {

	public static void main(String[] args) {

	}

	static long aVeryBigSum(long[] ar) {
		BigInteger b = BigInteger.ZERO;
		for (long eachVal : ar) {
			b = b.add(BigInteger.valueOf(eachVal));
		}
		return b.longValue();
	}
}
