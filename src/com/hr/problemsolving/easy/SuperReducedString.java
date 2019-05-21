package com.hr.problemsolving.easy;

public class SuperReducedString {

	public static void main(String[] args) {
		System.out.println(superReducedString("aaabccddd"));
		System.out.println(superReducedString("baab"));
	}

	static String superReducedString(String s) {
	/*	
		Stack<Character> stack = new Stack<Character>();
		for (int i = s.toCharArray().length - 1; i >= 0; i--) {
			stack.push(s.charAt(i));
		}

		StringBuffer str = new StringBuffer();

		if (stack.size() == 1) {
			return s;
		}

		while (!stack.isEmpty() && stack.size() > 1) {
			char first = stack.pop();
			char secon = stack.pop();

			if (first == secon) {
				stack.push('*');
			} else {
				if (first == '*') {
					stack.push(secon);
				} else {
					str.append(first);
					// stack.pop();
					stack.push(secon);
				}
			}
			// System.out.println(str.toString());
		}

		if (stack.size() == 1) {
			return str.toString() + stack.pop();
		} else {
			return str.toString();
		}
	*/
		while (true) {
			int len = s.length();
			s = s.replaceAll("(.)\\1", "");
			if (len == s.length()) {
				if (len == 0) {
					return "Empty String";	
				} else {
					return s;
				}
			} 
		}
		
	}
}
