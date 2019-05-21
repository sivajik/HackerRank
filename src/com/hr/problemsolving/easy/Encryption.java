package com.hr.problemsolving.easy;

public class Encryption {

	public static void main(String[] args) {
		System.out.println(encryption("if man was meant to stay on the ground god would have given us roots"));
		System.out.println(encryption("haveaniceday"));
		System.out.println(encryption("feedthedog"));
		System.out.println(encryption("chillout"));
	}

	static String encryption(String s) {
		s = s.replaceAll(" ", "");
		int rows = (int) Math.floor(Math.sqrt(s.length()));
		int cols = (int) Math.ceil(Math.sqrt(s.length()));

		if (rows * cols < s.length()) {
			rows = rows + 1;
		}
		
		System.out.println(rows + " " + cols);
		for (int i = 0; i < (rows * cols) - 2; i++) {
			s += '=';
		}

		StringBuffer sbrFinal = new StringBuffer();
		for (int i = 0; i < cols; i++) {
			StringBuffer tempStr = new StringBuffer();
			for (int j = i; j < rows * cols; j = j + cols) {
				tempStr.append(s.charAt(j));
			}
			sbrFinal.append(tempStr.toString().replaceAll("=", "")).append(" ");
		}
		return sbrFinal.toString().trim();
	}
}
