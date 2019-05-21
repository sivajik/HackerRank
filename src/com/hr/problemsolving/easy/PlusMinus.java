package com.hr.problemsolving.easy;

public class PlusMinus {

	public static void main(String[] args) {
		int[] arr = {-4, 3, -9, 0, 4, 1};
		plusMinus(arr);
	}
	
    static void plusMinus(int[] arr) {
    	float plusCount = 0.0f;
    	float minuscount = 0.0f;
    	float zeroCount = 0.0f;
    	
    	for (int elem : arr) {
    		if (elem == 0) {
    			zeroCount++;
    		} else if (elem < 0) {
    			minuscount++;
    		} else if (elem > 0) {
    			plusCount++;
    		}
    	}

    	System.out.format("%.6f\n", (float) (plusCount/arr.length));
    	System.out.format("%.6f\n", (float) (minuscount/arr.length));
    	System.out.format("%.6f\n", (float) (zeroCount/arr.length));
    }
}
