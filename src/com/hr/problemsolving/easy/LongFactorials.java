package com.hr.problemsolving.easy;

import java.math.BigInteger;

public class LongFactorials {

	public static void main(String[] args) {
		extraLongFactorials(6);
	}
	
    static void extraLongFactorials(int n) {
    	BigInteger b = BigInteger.ONE;

    	for (int i = 1; i <= n; i++) {
    		b = b.multiply(BigInteger.valueOf(i));
    	}
    	System.out.println(b.toString());
    }
}
