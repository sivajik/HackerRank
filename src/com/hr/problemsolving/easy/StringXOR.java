package com.hr.problemsolving.easy;

public class StringXOR {

	public static void main(String[] args) {
		System.out.println(stringsXOR("10101", "00101"));
	}

	public static String stringsXOR(String s, String t) {
		StringBuilder res = new StringBuilder("");
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == t.charAt(i))
				res.append("0");
			else
				res.append("1");
		}
		return res.toString();
	}

}