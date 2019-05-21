package com.hr.problemsolving.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public class MissingNumbers {
	public static void main(String[] args) throws Exception {
		System.out
				.println(Arrays.toString(missingNumbers(new int[] { 203, 204, 205, 206, 207, 208, 203, 204, 205, 206 },
						new int[] { 203, 204, 204, 205, 206, 207, 205, 208, 203, 206, 205, 206, 204 })));
	}

	static int[] missingNumbers(int[] arr, int[] brr) {
		TreeMap<Integer, Integer> bMap = new TreeMap<Integer, Integer>();
		for (int elem : brr) {
			if (bMap.containsKey(elem)) {
				bMap.put(elem, 1 + bMap.get(elem));
			} else {
				bMap.put(elem, 1);
			}
		}
		System.out.println(bMap);

		TreeMap<Integer, Integer> aMap = new TreeMap<Integer, Integer>();
		for (int elem : arr) {
			if (aMap.containsKey(elem)) {
				aMap.put(elem, 1 + aMap.get(elem));
			} else {
				aMap.put(elem, 1);
			}
		}
		System.out.println(aMap);

		Set<Integer> bMapKeySet = bMap.keySet();
		Iterator<Integer> itr = bMapKeySet.iterator();
		List<Integer> results = new ArrayList<Integer>();
		while (itr.hasNext()) {
			int key = itr.next();
			int bMapCount = bMap.get(key);
			int aMapCount = aMap.containsKey(key) ? aMap.get(key) : 0;
			if (bMapCount - aMapCount >= 1) {
				results.add(key);
			}
		}

		int[] resultsArray = new int[results.size()];
		int i = 0;
		for (int elem : results) {
			resultsArray[i++] = elem;
		}
		return resultsArray;
	}

}
