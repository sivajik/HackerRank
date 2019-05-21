package com.hr.problemsolving.easy;

import java.util.HashMap;
import java.util.Map;

public class Anagrams {

	public static void main(String[] args) {
		//System.out.println(makingAnagrams("abc", "amnop"));
		//System.out.println(makingAnagrams("cde", "abc"));
		//System.out.println(makingAnagrams("absdjkvuahdakejfnfauhdsaavasdlkj", 
		//		"djfladfhiawasdkjvalskufhafablsdkashlahdfa"));
		System.out.println(makingAnagrams("tttttttttttttttttttttttttttttttttttttsssssssssssssssss", 
				"sssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss"));
	}

	// Complete the makingAnagrams function below.
	static int makingAnagrams(String s1, String s2) {
		String big = s1.length() >= s2.length() ? s1 : s2;
		String small = s1.length() < s2.length() ? s1 : s2;

		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (char c : big.toCharArray()) {
			if (!map.containsKey(c)) {
				map.put(c, 1);
			} else {
				map.put(c, 1 + map.get(c));
			}
		}
		System.out.println(map);
		for (char c : small.toCharArray()) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) - 1);
				if (map.get(c) == 0) {
					map.remove(c);
				}
			} else {
				map.put(c, 1);
			}
		}
		System.out.println(map);
		Integer[] valuesArra = map.values().toArray(new Integer[0]);		
		int sum = 0;
		for (int x : valuesArra) {
			sum += x < 0 ? -x : x;
		}
		return sum;
	}
}
