package com.hr.problemsolving.easy;

public class LoveLetterMystery {

	public static void main(String[] args) {
		System.out.println(theLoveLetterMystery("abc"));
		System.out.println(theLoveLetterMystery("abcba"));
		System.out.println(theLoveLetterMystery("abcd"));
		System.out.println(theLoveLetterMystery("cba"));
	}

	// Complete the theLoveLetterMystery function below.
	static int theLoveLetterMystery(String s) {
		char[] chars = s.toCharArray();

		int totalMoves = 0;
		for (int i = 0; i < chars.length / 2; i++) {
			int leftIndex = i;
			int rightIndex = chars.length - i - 1;
			
			if (chars[leftIndex] == chars[rightIndex]) {
				continue;
			} else {
				//while (chars[leftIndex] != chars[rightIndex]) {
				totalMoves += Math.abs( (int) chars[rightIndex] - chars[leftIndex]);
				//}
			}
		}
		return totalMoves;
	}
}
