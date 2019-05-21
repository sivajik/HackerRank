package com.hr.problemsolving.easy;

public class DesignPDFViewer {

	public static void main(String[] args) {
		System.out.println(designerPdfViewer(
				new int[] { 1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 }, "abc"));

		System.out.println(designerPdfViewer(
				new int[] { 1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 7}, "zaba"));

	}

	static int designerPdfViewer(int[] h, String word) {
		int maxHeight = Integer.MIN_VALUE;
		for (char ch : word.toCharArray()) {
			int charHeight = h[(int) ch - 97];
			if (charHeight > maxHeight) {
				maxHeight = charHeight;
			}
		}
		return maxHeight * word.length();
	}
}
