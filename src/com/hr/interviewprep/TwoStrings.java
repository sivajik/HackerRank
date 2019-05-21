package com.hr.interviewprep;

import java.util.HashMap;

public class TwoStrings {

	public static void main(String[] args) {
		System.out.println(twoStrings("hello", "world"));
		System.out.println(twoStrings("hi", "world"));

	}
    static String twoStrings(String s1, String s2) {
    	HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    	for (char c : s1.toCharArray()) {
    		if (!map.containsKey(c)) {
    			map.put(c, 1);
    		}
    	}
    	
    	int matchingChars = 0;
    	for (char c : s2.toCharArray()) {
    		if (map.containsKey(c)) {
    			matchingChars++;
    		}
    	}
    	return matchingChars > 0 ? "YES" : "NO";
    }
}
