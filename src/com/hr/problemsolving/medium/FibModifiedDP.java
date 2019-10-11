package com.hr.problemsolving.medium;

import java.math.BigInteger;

public class FibModifiedDP {

	public static void main(String[] args) {
		BigInteger y = fibonacciModified(1, 1, 20);
		System.out.println(y.toString());
	}

	static BigInteger add(BigInteger a, BigInteger b) {
		return a.add(b.multiply(b));
	}

	static BigInteger fibonacciModified(int t1, int t2, int n) {
		if (n == 1) {
			return BigInteger.valueOf(t1);
		}

		if (n == 2) {
			return BigInteger.valueOf(t2);
		}

		BigInteger[] dp = new BigInteger[n];
		dp[0] = BigInteger.valueOf(t1);
		dp[1] = BigInteger.valueOf(t2);
		for (int i = 2; i < n; i++) {
			dp[i] = add(dp[i - 2], dp[i - 1]);
		}
		return dp[n - 1];
	}
}
