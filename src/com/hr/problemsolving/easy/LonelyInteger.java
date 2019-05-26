package com.hr.problemsolving.easy;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class LonelyInteger {

	public static void main(String[] args) {
		System.out.println(lonelyinteger(new int[] { 1, 2, 3, 4, 3, 2, 1 }));
		System.out.println(lonelyinteger(new int[] { 1 }));
		System.out.println(lonelyinteger(new int[] { 1, 1, 2 }));
	}

	// Complete the lonelyinteger function below.
	static int lonelyinteger(int[] a) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int elem : a) {
			if (!map.containsKey(elem)) {
				map.put(elem, 1);
			} else {
				map.put(elem, 1 + map.get(elem));
			}
		}

		Set<Integer> set = map.keySet();
		Iterator<Integer> itr = set.iterator();
		while (itr.hasNext()) {
			Integer key = itr.next();
			if (map.get(key) == 1) {
				return key;
			}
		}
		return -1;
	}
}
