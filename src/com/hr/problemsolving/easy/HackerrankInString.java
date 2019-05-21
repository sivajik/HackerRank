package com.hr.problemsolving.easy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HackerrankInString {

	public static void main(String[] args) {
		System.out.println(hackerrankInString("hereiamstackerrank"));
		System.out.println(hackerrankInString("hackerworld"));
	}

	static String hackerrankInString(String s) {
		Pattern p = Pattern.compile("^.*[h]+.*[a]+.*[c]+.*[k]+.*[e]+.*[r]+.*[r]+.*[a]+.*[n]+.*[k]+.*$");
		Matcher m = p.matcher(s);
		return m.matches() ? "YES" : "NO";
	}
}
