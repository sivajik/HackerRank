package com.hr.problemsolving.easy;

import java.util.Random;

public class ArrayCircularRotation {

	public static void main(String[] args) {
		int[] a = new int[99725];// { 7, 2, 6, 0, 3, 1, 4, 8, 9 };
		Random r = new Random(0);
		for (int i = 0; i < a.length; i++) {
			a[i] = r.nextInt();
		}
		
		//print(a);
		
		int[] op = circularArrayRotation(a, 66957, new int[] { 3, 4 });
		print(op);
		
		
		// leftRotate(a, 3, a.length);
		//print(a);
	}

	static void print(int[] a) {
		for (int elem : a) {
			System.out.print(elem + " ");
		}
		System.out.println();
	}

	static void rightRotate(int arr[], int n, int k) {
		int[] result = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			result[(i + (arr.length + k)) % arr.length] = arr[i];
		}
		StringBuilder sbr = new StringBuilder();
		for (int i : result) {
			sbr.append(i);
			sbr.append(" ");
		}
		System.out.println(sbr.toString().trim());
	}
	
	
	static int[] circularArrayRotation(int[] a, int k, int[] queries) {
		int[] result = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			result[(i + (a.length + k)) % a.length] = a[i];
		}
		
		// print(a);
		int[] output = new int[queries.length];
		for (int i = 0; i < queries.length; i++) {
			output[i] = result[queries[i]];
		}
		return output;
	}
}
