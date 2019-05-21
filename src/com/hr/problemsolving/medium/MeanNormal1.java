package com.hr.problemsolving.medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MeanNormal1 {
	static int counter = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bufferedReader.readLine().trim());

		List<List<Long>> profits = new ArrayList<>();

		double means[] = new double[t];
		//int counter = 0;
		
 		IntStream.range(0, t).forEach(tItr -> {
			try {
				int n = Integer.parseInt(bufferedReader.readLine().trim());
				
				try {
					String[] tokens = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
					List<Long> tempList = Stream.of(tokens).map(Long::parseLong).collect(Collectors.toList());
 					profits.add(tempList);
 					means[counter++] = tempList.stream().mapToDouble(val -> val).average().orElse(0.0);
				} catch (IOException ex) {
					throw new RuntimeException(ex);
				}

			} catch (Exception ex) {
				throw new RuntimeException(ex);
			}
		});

		solve(means, profits);

		bufferedReader.close();
	}

	static void solve(double[] means, List<List<Long>> l) throws Exception {
		/*double[] means = new double[l.size()];

		int c = 0;
		for (List<Long> smallList : l) {
			means[c++] = smallList.stream().mapToDouble(val -> val).average().orElse(0.0);
		}*/

		List<Long> flat = l.stream().flatMap(List::stream).collect(Collectors.toList());

		double sum = 0.0d;
		boolean minFound = false;
		double min = Double.MAX_VALUE;
		for (double meanThisTime : means) {
			for (Long elem : flat) {
				sum += Math.abs(meanThisTime - elem.longValue());
				if (minFound) {
					if (sum > min) {
						break;
					}
				}
			}
			if (sum < min) {
				min = sum;
				minFound = true;
			}
			sum = 0.0d;
		}
		System.out.printf("%.12f", min);
	}
}