package com.hr.problemsolving.easy;

public class ArrayLeftRotation {

	public static void main(String[] args) {
		int[] a = { 7, 2, 6, 0, 3, 1, 4, 8, 9 };
		for (int i = 0; i <= a.length; i++)
			// leftRotate(a, a.length, i);
			rightRotate(a, a.length, i);
	}

	static void leftRotate(int arr[], int n, int k) {
		int[] result = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			result[(i + (arr.length - k)) % arr.length] = arr[i];
		}
		StringBuilder sbr = new StringBuilder();
		for (int i : result) {
			sbr.append(i);
			sbr.append(" ");
		}
		System.out.println(sbr.toString().trim());
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
}
