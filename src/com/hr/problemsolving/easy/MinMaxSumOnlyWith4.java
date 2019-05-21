package com.hr.problemsolving.easy;

public class MinMaxSumOnlyWith4 {
	public static void main(String[] args) {
		int[] a = {1, 2, 3, 4, 5};
		miniMaxSum(a);

	}
    static void miniMaxSum(int[] arr) {
    	long sum = 0;
    	for (int ele : arr) {
    		sum += ele;
    	}
    	long min = Long.MAX_VALUE;
    	long max = Long.MIN_VALUE;
    	
    	long currSum = 0;
    	for (int ele : arr) {
    		currSum = sum - ele;
    		if (currSum < min) {
    			min = currSum;
    		}
    		if (currSum > max) {
    			max = currSum;
    		}
    	}
    	System.out.println(min + " " + max);
    }
}
