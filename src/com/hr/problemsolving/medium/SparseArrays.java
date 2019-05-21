package com.hr.problemsolving.medium;

import java.util.Arrays;
import java.util.HashMap;

public class SparseArrays {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(matchingStrings(new String[] {
				"abcde",
				"sdaklfj",
				"asdjf",
				"na",
				"basdn",
				"sdaklfj",
				"asdjf",
				"na",
				"asdjf",
				"na",
				"basdn",
				"sdaklfj",
				"asdjf"}, 
				new String[] {
"abcde", 
"sdaklfj", 
"asdjf", 
"na", 
"basdn"})));
	}

	static int[] matchingStrings(String[] strings, String[] queries) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (String str : strings) {
			if (map.containsKey(str)) {
				map.put(str, map.get(str) + 1);
			} else {
				map.put(str, 1);
			}
		}
		int[] results = new int[queries.length];
		for (int i = 0; i < queries.length; i++) {
			Integer r = map.get(queries[i]);
			results[i] = r == null ? 0 : r.intValue();
		}
		return results;
	}
}
