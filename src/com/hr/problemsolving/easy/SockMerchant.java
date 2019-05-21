package com.hr.problemsolving.easy;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class SockMerchant {

	public static void main(String[] args) {
		System.out.println(sockMerchant(9, new int[] {10, 20 ,20, 10, 10 ,30, 50, 10, 20}));

	}

	static int sockMerchant(int n, int[] ar) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int elem : ar) {
			if (map.containsKey(elem)) {
				int currCount = map.get(elem);
				map.put(elem, currCount + 1);
			} else {
				map.put(elem, 1);
			}
		}

		int totalPairs = 0;
		Set<Integer> set = map.keySet();
		Iterator<Integer> itr = set.iterator();
		while (itr.hasNext()) {
			totalPairs += map.get(itr.next()) / 2;
		}
		return totalPairs;
	}
}
