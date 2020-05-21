package com.hr.problemsolving.medium;

public class ReecuriveDigitSum {

	public static void main(String[] args) {
		System.out.println(superDigit("9875", 4));
		System.out.println(superDigit("148", 3));
		System.out.println(superDigit("123", 3));
		System.out.println(superDigit("123", 1));
	}

	static int superDigit(String n, int k) {
		return getSuperDigitOf(n, k);
	}

	static int getSuperDigitOf(String n, int k) {
		if (n.length() == 1) {
			System.out.println("------");
			return Integer.parseInt(n);
		} else {
			long sum = 0;
			for (char c : n.toCharArray()) {
				sum += (int) c - (int) '0';
			}
			//System.out.println("Temp sum: " + sum * k);
			return getSuperDigitOf(String.valueOf(sum), 1);
		}
	}
}