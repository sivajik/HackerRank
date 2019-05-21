package com.hr.problemsolving.easy;

public class AlternateCharacters {

	public static void main(String[] args) {
		System.out.println(alternatingCharacters("AAAA"));
		System.out.println(alternatingCharacters("BBBBB"));
		System.out.println(alternatingCharacters("ABABABAB"));
		System.out.println(alternatingCharacters("BABABA"));
		System.out.println(alternatingCharacters("AAABBB"));
	}

	static int alternatingCharacters(String s) {
		StringBuffer sbr = new StringBuffer();

		char prevChar = '@';
		for (char c : s.toCharArray()) {
			if (c == prevChar) {
				;// do nothing.
			} else {
				sbr.append(c);
				prevChar = c;
			}
		}
		System.out.println(s + " -> " + sbr.toString());
		return s.length() - sbr.toString().length();
	}
}
