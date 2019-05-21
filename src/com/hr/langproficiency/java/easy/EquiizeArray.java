package com.hr.langproficiency.java.easy;

import java.util.HashMap;
import java.util.Map;

public class EquiizeArray {

	public static void main(String[] args) {
		System.out.println(equalizeArray(new int[] { 1, 2, 2, 3 }));
		System.out.println(equalizeArray(new int[] { 3, 3, 2, 1, 3 }));
		System.out.println(equalizeArray(new int[] { 37, 32, 97, 35, 76, 62 }));

	}

	// Complete the equalizeArray function below.
	static int equalizeArray(int[] arr) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int max = Integer.MIN_VALUE;

		for (int elem : arr) {
			if (map.containsKey(elem)) {
				int newFreq = 1 + map.get(elem);
				map.put(elem, newFreq);
				if (newFreq > max) {
					max = newFreq;
				}
			} else {
				map.put(elem, 1);
			}
		}
		if (max == Integer.MIN_VALUE) {
			return arr.length - 1;
		} else {
			return arr.length - max;

		}
	}
}
