package com.hr.problemsolving.easy;

public class FlippingBits {

	public static void main(String[] args) {
		System.out.println(flippingBits(1));
		System.out.println(flippingBits(0));
		System.out.println(flippingBits(9));
		System.out.println(flippingBits(2147483647));
	}

	static long flippingBits(long n) {
		String bin = Long.toBinaryString(n);
		int l = bin.length();

		for (int i = 0; i < 32 - l; i++) {
			bin = "0" + bin;
		}
		bin = bin.replaceAll("1", "x");
		bin = bin.replaceAll("0", "1");
		bin = bin.replaceAll("x", "0");

		return Long.parseLong(bin, 2);
	}
}
