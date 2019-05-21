package com.hr.problemsolving.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GridSearch {

	public static void main(String[] args) {
		/*
		 * System.out.println( gridSearch(new String[] { "1234567890", "0987654321",
		 * "1111111111", "1111111111", "2222222222", }, new String[] { "876543",
		 * "111111", "111111" })); System.out.println("-------------");
		 * System.out.println( gridSearch(new String[] { "7283455864", "6731158619",
		 * "8988242643", "3830589324", "2229505813", "5633845374", "6473530293",
		 * "7053106601", "0834282956", "4607924137" }, new String[] { "9505", "3845",
		 * "3530"})); System.out.println("-------------"); System.out.println(
		 * gridSearch(new String[] { "400453592126560", "114213133098692",
		 * "474386082879648", "522356951189169", "887109450487496", "252802633388782",
		 * "502771484966748", "075975207693780", "511799789562806", "404007454272504",
		 * "549043809916080", "962410809534811", "445893523733475", "768705303214174",
		 * "650629270887160" }, new String[] { "99", "99"}));
		 */

		//System.out.println(
		//		gridSearch(new String[] { "123412", "561212", "123634", "781288" }, new String[] { "12", "34" }));

//		System.out.println(
//				gridSearch(new String[] {
//		"111111111111111",
//		"111111111111111",
//		"111111111111111",
//		"111111011111111",
//		"111111111111111",
//		"111111111111111",
//		"101010101010101"},
//						new String[] {
//		"11111",
//		"11111",
//		"11111",
//		"11110"}));
		
		System.out.println(gridSearch(new String[] {
				"456712",
				"561245",
				"123667",
				"781288"
		}, new String[] {"45",
						"67"}));
		
		
		// System.out.println(allPossIndexesFound("123412561278123412", "3412"));
	}

	static HashSet<Integer> allPossIndexesFound(String big, String small) {
		HashSet<Integer> list = new HashSet<Integer>();

		if (big.indexOf(small) == -1) {
			return list;
		} else {
			int smallLen = small.length();
			String dummy = "";
			for (int i = 0; i < smallLen; i++) {
				dummy += 'X';
			}
			int startIndex = 0;
			while (big.indexOf(small, startIndex) != -1) {
				int index = big.indexOf(small, startIndex);
				list.add(index);
				startIndex = startIndex  + 1;
				// big = big.replaceFirst(small, dummy);
			}
		}
		return list;
	}

	// Complete the gridSearch function below.
	static String gridSearch(String[] G, String[] P) {
		int matchingCount = 0;

		ArrayList<HashSet<Integer>> matchingIndicesList = new ArrayList<HashSet<Integer>>();

		int prevOccuranceRowNumber = -1;
		for (int j = 0; j < P.length; j++) {
			String firstLineInPattern = P[j];

			for (int i = prevOccuranceRowNumber + 1; i < G.length; i++) {
				String currRow = G[i];
				HashSet<Integer> matchingIndices = allPossIndexesFound(currRow, firstLineInPattern);
				if (matchingIndices.size() > 0) {
					prevOccuranceRowNumber = i;

					System.out
							.println("String: " + firstLineInPattern + " found at diff locations:: " + matchingIndices);
					matchingIndicesList.add(matchingIndices);
					break;
				} else {
					// do nothing.. go to next line in the main grid
				}
			}
		}

		System.out.println(matchingIndicesList);

		return matchingIndicesList.size() == P.length && doesCommonElemExists(matchingIndicesList) ? "YES" : "NO";
	}

	static boolean doesCommonElemExists(ArrayList<HashSet<Integer>> list) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (HashSet<Integer> eachList : list) {
			for (Integer i : eachList) {
				if (map.containsKey(i)) {
					map.put(i, 1 + map.get(i));
				} else {
					map.put(i, 1);
				}
			}
		}

		boolean found = false;
		for (Integer i : map.values()) {
			if (i == list.size()) {
				System.out.println("common element found at index: " + i);
				found = true;
			}
		}

		return found;
	}

	// Complete the gridSearch function below.
	static String gridSearchOld(String[] G, String[] P) {
		int prevOccuranceIndex = -1;
		int matchingCount = 0;

		int prevOccurance = -1;
		for (int j = 0; j < P.length; j++) {
			String firstLineInPattern = P[j];
			for (int i = prevOccurance + 1; i < G.length; i++) {
				String currRow = G[i];
				int patternIndexInCurrRow = prevOccuranceIndex == -1 ? currRow.indexOf(firstLineInPattern)
						: currRow.indexOf(firstLineInPattern, prevOccuranceIndex);
				if (patternIndexInCurrRow != -1) {
					prevOccurance = i;
					System.out.println("String: " + firstLineInPattern + " found at: " + patternIndexInCurrRow);
					if (prevOccuranceIndex == -1) {
						// never found so far
						prevOccuranceIndex = patternIndexInCurrRow;
						matchingCount++;
					} else {
						if (prevOccuranceIndex == patternIndexInCurrRow) {
							prevOccuranceIndex = patternIndexInCurrRow;
							matchingCount++;
						}
					}
					break;
				}
			}
		}

		if (matchingCount == P.length) {
			return "YES";
		} else {
			return "NO";
		}
	}
}
