package com.hr.problemsolving.easy;

public class AlmostSorted {

	public static void main(String[] args) {
		int[] a = { 1, 5, 4, 3, 2, 6 };
		sort(a);
	}

	static void print(int[] a) {
		for (int elem : a) {
			System.out.print(elem + " ");
		}
		System.out.println();
	}

	static void sort(int[] a) {
		int swapCount = 0;
		int revSegCount = 0;
		String swapStr = "";
		String revStr = "";
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] > a[j]) {
					if (swapCount > 0 || revSegCount > 0) {
						System.out.println("no");
						return;
					} else {
						if (Math.abs(i - j) == 1) {
							swapCount++;
							swapStr = "swap " + (i + 1) + " " + (j + 1);
						} else if (Math.abs(i - j) >= 1) {
							revSegCount++;
							revStr = "reverse " + (i + 1) + " " + (j + 1);
						}
						int temp = a[i];
						a[i] = a[j];
						a[j] = temp;
					}
				}
			}
		}
		print(a);

		if (swapCount == 0 && revSegCount == 0) {
			System.out.println("yes");
			return;
		}

		if (swapCount == 1 && revSegCount == 0) {
			System.out.println("yes");
			System.out.println(swapStr);
			return;
		}

		if (swapCount == 0 && revSegCount == 1) {
			System.out.println("yes");
			System.out.println(revStr);
			return;
		}
	}
}
