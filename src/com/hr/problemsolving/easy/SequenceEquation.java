package com.hr.problemsolving.easy;

import java.util.Arrays;

public class SequenceEquation {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(permutationEquation(new int[] { 5, 2, 1, 3, 4 })));
		System.out.println(Arrays.toString(permutationEquation(new int[] { 2, 3, 1 })));
	}

	static int[] permutationEquation(int[] p) {
		int[] a = new int[p.length + 1];
		for (int i = 0; i < p.length; i++) {
			a[i + 1] = p[i];
		}
		print(a);

		int[] b = new int[p.length + 1];
		for (int i = 1; i < b.length; i++) {
			b[a[i]] = i;
		}
		print(b);

		int[] c = new int[p.length + 1];
		for (int i = 1; i < b.length; i++) {
			c[i] = b[b[i]];
		}
		print(c);

		int[] d = new int[p.length];
		System.arraycopy(c, 1, d, 0, c.length-1);
		return d;
	}

	static void print(int[] a) {
		for (int i = 1; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
}
