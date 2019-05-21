package com.hr.problemsolving.easy;

public class RepeatedStrings {

	public static void main(String[] args) {
		System.out.println(repeatedString("aba", 10));
		System.out.println(repeatedString("a", 1000000000000l));
		System.out.println(repeatedString("x", 1000000000000l));
		System.out.println(repeatedString("kmretasscityylpdhuwjirnqimlkcgxubxmsxpypgzxtenweirknjtasxtvxemtwxuarabssvqdnktqadhyktagjxoanknhgilnm", 
				736778906400l)); //51574523448
		
	}

	// Complete the repeatedString function below.
	static long repeatedString(String s, long n) {
		if (s.length() == 1) {
			if (s.equalsIgnoreCase("a")) {
				return n;
			} else {
				return 0;
			}
		} 
		
		// first calculate count of "a" in given string 
		String tempStr = s;
		tempStr = tempStr.replaceAll("[^a]", "");
		int countOfAs = tempStr.length();
		
		long repetitions = n / s.length();
		long currentCount = countOfAs * repetitions;
				
		long remainingStrLen = n % s.length();
		
		for (int i = 0; i < remainingStrLen; i++) {
			if (s.charAt(i) == 'a') {
				currentCount++;
			}
		}
		return currentCount++;
	}
}