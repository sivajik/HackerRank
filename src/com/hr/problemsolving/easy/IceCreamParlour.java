package com.hr.problemsolving.easy;

import java.util.Arrays;

public class IceCreamParlour {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(icecreamParlor(4, new int[] {1 ,4, 5, 3 ,2})));
		System.out.println(Arrays.toString(icecreamParlor(4, new int[] {2, 2, 4, 3})));
	}
    // Complete the icecreamParlor function below.
    static int[] icecreamParlor(int m, int[] arr) {
    	for (int i = 0; i < arr.length; i++) {
    		for (int j = i + 1; j < arr.length; j++) {
    			if (arr[i] + arr[j] == m) {
    				return new int[] {i + 1, j + 1};
    			}
    		}
    	}
    	return null;
    }
}
