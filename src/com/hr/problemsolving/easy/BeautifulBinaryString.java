package com.hr.problemsolving.easy;

public class BeautifulBinaryString {

	public static void main(String[] args) {
		System.out.println(beautifulBinaryString("01100"));
	}

	static int beautifulBinaryString(String s) {
		int changes = 0;
		for (int i = 0; i < s.length() - 2; i++) {
			if (s.charAt(i) == '0' && s.charAt(i + 1) == '1' && s.charAt(i + 2) == '0') {
				changes++;
				i += 2;
			}
		}
		return changes;
	}

}
