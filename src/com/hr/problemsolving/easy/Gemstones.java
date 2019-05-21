package com.hr.problemsolving.easy;

import java.util.HashMap;
import java.util.Map;

public class Gemstones {

	public static void main(String[] args) {
		System.out.println(gemstones(new String[] {"abc", "abc", "bc"}));
		System.out.println(gemstones(new String[] {"abcdde", "baccd", "eeabg"}));		
	}

	static int gemstones(String[] arr) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int charsFound = 0;
		for (int i = 'a'; i <= 'z'; i++) {
			boolean givenCharFoundInAllStr = true;
			for (String s : arr) {
				if (s.indexOf((char) i) == -1) {
					givenCharFoundInAllStr = false;
					break;
				}
			}
			if (givenCharFoundInAllStr) {
				charsFound++;
			}
		}
		return charsFound;
	}
}
