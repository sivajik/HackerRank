package com.hr.problemsolving.medium;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LongestCommonSubsequence {
	// Complete the longestCommonSubsequence function below.
	static int[] longestCommonSubsequence(int[] a, int[] b) {
		int[][] dp = new int[a.length + 1][b.length + 1];

		for (int i = 0; i <= a.length; i++) {
			for (int j = 0; j <= b.length; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				} else if (a[i - 1] == b[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		int i = dp.length - 1, j = dp[0].length - 1;
		int maxMatches = dp[dp.length - 1][dp[0].length - 1];
		int[] result = new int[maxMatches];
		int count = maxMatches;
		while (i > 0 && j > 0) {
			if (dp[i][j - 1] == dp[i - 1][j] && dp[i][j] == 1 + dp[i - 1][j - 1]) {
				result[--count] = b[j - 1];
				i--;
				j--;
			} else if (dp[i][j] == dp[i - 1][j] && dp[i - 1][j] == Math.max(dp[i - 1][j], dp[i][j - 1])) {
				i--;
			} else if (dp[i][j] == dp[i][j - 1] && dp[i][j - 1] == Math.max(dp[i][j - 1], dp[i - 1][j])) {
				j--;
			}
		}
		return result;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String[] nm = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nm[0]);

		int m = Integer.parseInt(nm[1]);

		int[] a = new int[n];

		String[] aItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int aItem = Integer.parseInt(aItems[i]);
			a[i] = aItem;
		}

		int[] b = new int[m];

		String[] bItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < m; i++) {
			int bItem = Integer.parseInt(bItems[i]);
			b[i] = bItem;
		}

		int[] result = longestCommonSubsequence(a, b);

		for (int i = 0; i < result.length; i++) {
			bufferedWriter.write(String.valueOf(result[i]));

			if (i != result.length - 1) {
				bufferedWriter.write(" ");
			}
		}

		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}