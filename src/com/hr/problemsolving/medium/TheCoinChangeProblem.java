package com.hr.problemsolving.medium;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class TheCoinChangeProblem {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int n = Integer.parseInt(firstMultipleInput[0]);

		int m = Integer.parseInt(firstMultipleInput[1]);

		List<Long> c = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Long::parseLong)
				.collect(toList());

		// Print the number of ways of making change for 'n' units using coins having
		// the values given by 'c'

		long ways = Result.getWays(n, c);

		bufferedWriter.write(String.valueOf(ways));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();

		/*
		 * List<Long> l = new ArrayList<Long>();
		 * l.add(2l);l.add(5l);l.add(3l);l.add(6l);
		 * System.out.println(Result.getWays(10, l));
		 */
	}
}

class Result {

	public static long getWays(int totalSum, List<Long> c) {
		Collections.sort(c);
		long[][] dp = new long[c.size() + 1][totalSum + 1];

		for (int i = 0; i <= c.size(); i++) {
			dp[i][0] = 1;
		}

		for (int i = 1; i <= c.size(); i++) {
			for (int j = 1; j <= totalSum; j++) {
				if (c.get(i - 1) > j) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j] + dp[i][(int) (j - c.get(i - 1))];
				}
			}
		}
		return dp[c.size()][totalSum];

	}

}