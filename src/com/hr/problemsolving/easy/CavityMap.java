package com.hr.problemsolving.easy;

import java.util.Arrays;

public class CavityMap {

	public static void main(String[] args) {
		/*for (String str : cavityMap(new String[] { "989", "191", "111" })) {
			System.out.println(str);
		}
		System.out.println();
		for (String str : cavityMap(new String[] { "1112", "1912", "1892", "1234" })) {
			System.out.println(str);
		}
		System.out.println();
		for (String str : cavityMap(new String[] { "12", "12"})) {
			System.out.println(str);
		}*/
		System.out.println();
		for (String str : cavityMap(new String[] { "179443854", "961621369", "164139922", 
				"968633951", "812882578", "257829163", 
				"812438597", "176656233", "485773814"})) {
			System.out.println(str);
		}		
	}

	static String[] cavityMap(String[] grid) {
		int n = grid.length;
		
		if (n <= 2) {
			return grid;
		}
		
		int[][] g = new int[n][n];
		int[][] gDash = new int[n][n];
		for (int i = 0; i < n; i++) {
			g[i] = new int[n];
			for (int j = 0; j < g[i].length; j++) {
				g[i][j] = (int) (grid[i].charAt(j) - 48);
				gDash[i][j] = (int) (grid[i].charAt(j) - 48);
			}
		}

		for (int i = 1; i < n - 1; i++) {
			for (int j = 1; j < n - 1; j++) {
				int elem = g[i][j];
				if (elem > g[i - 1][j] && elem > g[i + 1][j] && elem > g[i][j - 1] && elem > g[i][j + 1]) {
					gDash[i][j] = -1;
				}
			}
		}

		String[] results = new String[grid.length];
		for (int i = 0; i < n; i++) {
			String row = Arrays.toString(gDash[i]);
			row = row.replaceAll("-1", "X");
			row = row.replaceAll("[\\]\\[ ,]", "");
			results[i] = row;
		}
		return results;
	}
}
