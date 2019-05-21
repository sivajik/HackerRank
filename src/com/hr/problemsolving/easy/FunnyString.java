package com.hr.problemsolving.easy;

import java.util.Arrays;

public class FunnyString {

	public static void main(String[] args) {
		//System.out.println(funnyString("acxz"));
		//System.out.println(funnyString("bcxz"));
		//System.out.println(funnyString("lmnop"));
		System.out.println(funnyString("a"));
	}

	// Complete the funnyString function below.
	static String funnyString(String s) {
		char[] chars = s.toCharArray();
		int[] a = new int[chars.length - 1];
		for (int i = 1, j=0; i < chars.length; i++) {
			a[j++] = Math.abs((int) chars[i] - (int) chars[i - 1]);
		}
		
		//System.out.println(Arrays.toString(a));
		int[] b = new int[chars.length - 1];
		for (int i = chars.length - 1, j=0; i >= 1; i--) {
			b[j++] = Math.abs((int) chars[i] - (int) chars[i - 1]);
		}
		//System.out.println(Arrays.toString(b));
		return Arrays.equals(a, b) ? "Funny" : "Not Funny";
	}
}
