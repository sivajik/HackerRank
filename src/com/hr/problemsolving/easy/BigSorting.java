package com.hr.problemsolving.easy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class BigSorting {

	public static void main(String[] args) throws IOException {
		// String[] x = new String[] { "31415926535897932384626433832795", "1", "3",
		// "10", "3", "5" };
		String[] x = new String[9447];
		BufferedReader br = new BufferedReader(new FileReader("/Users/ski/Scripts/ip.txt"));
		String str = null;
		int c = 0;
		int max = Integer.MIN_VALUE;
		while ((str = br.readLine()) != null) {
			x[c++] = str;
			if (str.length() > max) {
				max = str.length();
			}
		}
		
		System.out.println("Max len: " + max);

		for (String y : bigSorting(x)) {
			System.out.println(y);
		}
	}

	// Complete the bigSorting function below.
	static String[] bigSorting(String[] unsorted) {
		Arrays.sort(unsorted, new Comparator<String>() {
			public int compare(String o1, String o2) {
				int o1Len = o1.length();
				int o2Len = o2.length();
				if (o1Len == o2Len) {
					boolean sent = false;
					for (int i = 0; i < o1Len; i++) {
						char o1Char = o1.charAt(i);
						char o2Char = o2.charAt(i);
						if (o1Char != o2Char) {
							return o1Char - o2Char;
						}
					}
					if (sent == false) {
						return 0;
					}
				} else  if (o1Len < o2Len) {
					return -1;
				} else {
					return 1;
				}
				return -1;
			}
		});

		return unsorted;
	}
}
