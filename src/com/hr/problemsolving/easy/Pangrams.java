package com.hr.problemsolving.easy;

import java.util.HashMap;
import java.util.Map;

public class Pangrams {

	public static void main(String[] args) {
		System.out.println(pangrams("The quick brown fox jumps over the lazy dog"));
		System.out.println(pangrams("We promptly judged antique ivory buckles for the prize"));
		System.out.println(pangrams("We promptly judged antique ivory buckles for the next prize"));
	}

	// Complete the pangrams function below.
	static String pangrams(String s) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (char c : s.toLowerCase().toCharArray()) {
			if (!map.containsKey(c)) {
				map.put(c, 1);
			}
		}
		if (s.indexOf(' ') != -1) {
			if (map.size() == 27) {
				return "pangram";
			}
		} else {
			if (map.size() == 26) {
				return "pangram";
			}
		}
		return "not pangram";
	}
}
