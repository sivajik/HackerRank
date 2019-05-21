package com.hr.interviewprep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class CountTriplets {

	public static void main(String[] args) {
		List<Long> arr = new ArrayList<Long>();
		arr.add(1L);
		arr.add(5L);
		arr.add(5L);
		arr.add(25L);
		arr.add(125L);
		
		System.out.println(countTriplets(arr, 5));

	}

	static long countTriplets(List<Long> arr, long r) {
		HashMap<Long, ArrayList<PairObj>> h = new LinkedHashMap<Long, ArrayList<PairObj>>();

		for (int i = 0; i < arr.size(); i++) {
			Long key = arr.get(i);
			PairObj p = new PairObj(i, key);

			if (h.containsKey(key)) {
				ArrayList<PairObj> aList = h.get(key);
				aList.add(p);
				h.put(key, aList);
			} else {
				ArrayList<PairObj> aList = new ArrayList<PairObj>();
				aList.add(p);
				h.put(key, aList);
			}
		}
		System.out.println(h.size());
		System.out.println(h);
		int matchingCount = 0;

		Set<Long> keys = h.keySet();
		Iterator<Long> itr = keys.iterator();
		while (itr.hasNext()) {
			Long key = itr.next();
			ArrayList<PairObj> list = h.get(key);

			for (PairObj pairObj : list) {
				int nextOneExists = doesExists(pairObj, key, key * r, h);
				int nextNextOneExists = doesExists(pairObj, key * r, key * r * r, h);
				if (nextOneExists > 0 && nextNextOneExists > 0) {
					matchingCount += (nextOneExists * nextNextOneExists);
					System.out.println("------");
				}
			}
		}

		return matchingCount;
	}

	static int doesExists(PairObj pOri, Long originalValue, Long key, HashMap<Long, ArrayList<PairObj>> h) {
		ArrayList<PairObj> list = h.get(key);
		if (list != null) {
			System.out.println(originalValue + " -> " + key + " -> " + list);
			return list.size();
		} else {
			return 0;
		}
	}

	static class PairObj {
		Long value;
		int index;

		PairObj(int index, Long value) {
			this.index = index;
			this.value = value;
		}

		@Override
		public String toString() {
			return "PairObj [value=" + value + ", index=" + index + "]";
		}
	}
}
