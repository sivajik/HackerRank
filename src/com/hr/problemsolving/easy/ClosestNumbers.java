package com.hr.problemsolving.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClosestNumbers {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(closestNumbers(new int[] { -5, 15, 25, 71, 63 })));
/*		System.out.println(Arrays.toString(closestNumbers(new int[] { 5, 4, 3, 2 })));
		System.out.println(Arrays.toString(closestNumbers(new int[] { -20, -3916237, -357920, -3620601, 7374819,
				-7330761, 30, 6246457, -6461594, 266854, -520, -470 })));
*/				
	}
	
    /*
    int i = 0; 
    try{
        for (; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
    } catch(NoSuchElementException ex){
        arr = Arrays.copyOf(arr, i);
    }
    */
    

	// Complete the closestNumbers function below.
	static int[] closestNumbers(int[] arr) {
		// Sort the array.
		Arrays.sort(arr);

		// Find min of absolute diff; O(n)
		int minDiff = Integer.MAX_VALUE;// 2 3 4 5
		for (int i = 1; i < arr.length; i++) {
			int diff = Math.abs(arr[i] - arr[i - 1]);
			if (diff < minDiff) {
				minDiff = diff;
			}
		}

		// find all pairs whose diff is currMin
		List<Pair> pairs = new ArrayList<Pair>();
		for (int i = 1; i < arr.length; i++) {
			int diff = Math.abs(arr[i] - arr[i - 1]);
			if (diff == minDiff) {
				pairs.add(new Pair(i - 1, i));
			}
		}
		int[] result = new int[pairs.size() * 2];
		int count = 0;
		for (Pair p : pairs) {
			result[count++] = arr[p.i];
			result[count++] = arr[p.j];
		}
		return result;
	}

	static class Pair {
		int i;
		int j;

		Pair(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}
