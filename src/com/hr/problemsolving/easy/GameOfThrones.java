package com.hr.problemsolving.easy;

public class GameOfThrones {

	public static void main(String[] args) {

	}

	static String gameOfThrones(String s) {

		return "";
    }
	
	
	static boolean isPalindrome(String s) {
		char[] c = s.toCharArray();
		for (int i = 0; i < c.length/2; i++) {
			if (c[i] != c[c.length - i - 1]) {
				return false;
			}
		}
		return true;
	}
}
