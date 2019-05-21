package com.hr.problemsolving.medium;

import java.util.Stack;

public class BalancedBrackets {

	public static void main(String[] args) {
		System.out.println(isBalanced("}][}}(}][))]"));
		System.out.println(isBalanced("[](){()}"));
		System.out.println(isBalanced("()"));
		System.out.println(isBalanced("({}([][]))[]()"));
		System.out.println(isBalanced("{)[](}]}]}))}(())("));
		System.out.println(isBalanced("([[)"));
	}

	// Complete the isBalanced function below.
	static String isBalanced(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (char c : s.toCharArray()) {
			if (c == '{' || c == '[' || c == '(') {
				stack.push(c);
			} else {
				char topChar = ' ';
				if (stack.size() >= 1) {
					topChar = stack.peek();
					if (c == '}' && topChar == '{') {
						stack.pop();
					} else if (c == ')' && topChar == '(') {
						stack.pop();
					} else if (c == ']' && topChar == '[') {
						stack.pop();
					} else {
						return "NO";
					}
				} else {
					return "NO";
				}
			}
		}
		return stack.isEmpty() ? "YES" : "NO";
	}
}
