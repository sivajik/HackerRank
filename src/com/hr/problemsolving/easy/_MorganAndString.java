package com.hr.problemsolving.easy;

import java.util.Stack;

public class _MorganAndString {

	public static void main(String[] args) {
		System.out.println(morganAndString("ACA", "BCF"));
		System.out.println(morganAndString("JACK", "DANIEL"));
		System.out.println(morganAndString("ABACABA", "ABACABA"));
	}

	static String morganAndString(String a, String b) {
		Stack<Character> s1 = new Stack<Character>();
		Stack<Character> s2 = new Stack<Character>();

		a = a + 'a';
		b = b + 'b';
		
		for (int i = a.length() - 1; i >= 0; i--) {
			s1.push(a.charAt(i));
		}

		for (int i = b.length() - 1; i >= 0; i--) {
			s2.push(b.charAt(i));
		}

		StringBuffer sbr = new StringBuffer();

		while (!s1.isEmpty() && !s2.isEmpty()) {
			char s1Char = s1.peek();
			char s2Char = s2.peek();

			if (s1Char < s2Char) {
				sbr.append(s1Char);
				s1.pop();
			} else if (s2Char < s1Char) {
				sbr.append(s2Char);
				s2.pop();
			} else if (s1Char == s2Char) {
				char topChar = s1Char; // p

				// remove the top character for now, we add it later..
				s1.pop();
				s2.pop();
				
				Stack<Character> interimStack = new Stack<Character>();
				while (s1.peek() == s2.peek() && (s1.peek() != 'a' || s2.peek() != 'b') ) {
					char sameChar = s1.peek();
					interimStack.push(sameChar);
					s1.pop();
					s2.pop();
				}

				char secondQ1Peak = s1.peek();
				char secondQ2Peak = s2.peek();

				while (!interimStack.isEmpty()) {
					char c = interimStack.pop();
					s1.push(c);
					s2.push(c);
				}
				
				s1.push(topChar);
				s2.push(topChar);
				
				if (secondQ1Peak < secondQ2Peak) {
					sbr.append(s1Char);
					s1.pop();
				} else if (secondQ1Peak > secondQ2Peak) {
					sbr.append(s2Char);
					s2.pop();
				} else {
					System.out.println("Devuda... cant fix this now...");
				}
			}
		}

		if (s1.isEmpty() && !s2.isEmpty()) {
			while (!s2.isEmpty()) {
				sbr.append(s2.pop());
			}
		}

		if (!s1.isEmpty() && s2.isEmpty()) {
			while (!s1.isEmpty()) {
				sbr.append(s1.pop());
			}
		}

		return sbr.toString().replaceAll("ab", "").replaceAll("ba", "");
	}
}
