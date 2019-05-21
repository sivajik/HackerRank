package com.hr.problemsolving.hard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int n = Integer.parseInt(line);
		for (int i = 1; i <= n; i++) {
			String op = "" + i;

			if (i % 3 == 0) {
				op = "Fizz";
			}

			if (i % 5 == 0) {
				op = "Buzz";
			}
			if (i % 3 == 0 && i % 5 == 0) {
				op = "FizzBuzz";
			}
			System.out.println(op);
		}

	}
}