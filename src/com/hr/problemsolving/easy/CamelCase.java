package com.hr.problemsolving.easy;

public class CamelCase {

	public static void main(String[] args) {
		System.out.println(camelcase("saveChangesInTheEditor"));

	}

	// Complete the camelcase function below.
	static int camelcase(String s) {
		s = "A" + s;
		String newString = s.replaceAll("([a-z])", "");
		System.out.println(newString);
		return newString.length();
	}
}
