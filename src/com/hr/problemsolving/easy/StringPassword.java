package com.hr.problemsolving.easy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringPassword {

	public static void main(String[] args) {
		System.out.println(minimumNumber(3, "Ab1"));
		System.out.println(minimumNumber(11, "#HackerRank"));
	}

	static int minimumNumber(int n, String password) {
		// Return the minimum number of characters to make the password strong
		String lcRegex = "^.*[a-z]+.*$";
		String ucRegex = "^.*[A-Z]+.*$";
		String nuRegex = "^.*[0-9]+.*$";
		String splChars = "^.*[!@#$%^&*()+-]+.*$";

		int neededPaddedCharCount = 0;

		if (!password.matches(lcRegex)) {
			neededPaddedCharCount++;
		}

		if (!password.matches(ucRegex)) {
			neededPaddedCharCount++;
		}

		if (!password.matches(nuRegex)) {
			neededPaddedCharCount++;
		}

		Pattern p = Pattern.compile(splChars);
		Matcher m = p.matcher(password);
		if (!m.matches()) {
			neededPaddedCharCount++;
		}

		if (neededPaddedCharCount == 0) {
			System.out.println("Seems valid string but needs soem characters");
			return n > 6 ? 0 : 6 - n;
		} else {
			System.out.println("Not a valid password hence some padding needed");
			return n > 6 ? neededPaddedCharCount : Math.max(6-n, neededPaddedCharCount);
		}
	}
}
