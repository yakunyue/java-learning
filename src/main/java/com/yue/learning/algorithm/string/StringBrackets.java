package com.yue.learning.algorithm.string;

import java.util.Stack;

/**
 * 判断由{}[]()这6个字符组成的字符串是否合法
 * 合法的定义是不能越级嵌套，且必须成对出现
 */
public class StringBrackets {

	public static void main(String[] args) {
		System.out.println(judge("{}{[]()()}()[{}()]"));
		System.out.println(judge2("{}{[]()()}()[{}()]"));
		System.out.println(judge3("{}{[]()()}()[{}()]"));
	}

	private static boolean judge(String str) {
		char[] arr = str.toCharArray();
		char pre = ' ';
		int a = 0;
		int b = 0;
		int c = 0;
		for (char cur : arr) {
			if (pre == '{' && cur != '}' && cur != '[' && cur != '(') {
				return false;
			}
			if (pre == '[' && cur != ']' && cur != '(') {
				return false;
			}
			if (pre == '(' && cur != ')') {
				return false;
			}
			switch (cur) {
				case '{':
					a++;
					break;
				case '[':
					b++;
					break;
				case '(':
					c++;
					break;
				case '}':
					a--;
					break;
				case ']':
					b--;
					break;
				case ')':
					c--;
					break;
			}
			pre = cur;
		}
		return (a + b + c) == 0;
	}

	private static boolean judge2(String str) {
		char[] arr = str.toCharArray();
		Stack<Character> stack = new Stack<>();
		int level = 0;
		for (char c : arr) {
			switch (c) {
				case '{':
					if (level>0){
						return false;
					}
					level = 1;
					stack.push(c);
					break;
				case '[':
					if (level>1){
						return false;
					}
					level = 2;
					stack.push(c);
					break;
				case '(':
					if (level>2){
						return false;
					}
					level = 3;
					stack.push(c);
					break;
				case '}':
					if (stack.pop() != '{') {
						return false;
					}
					level = 0;
					break;
				case ']':
					if (stack.pop() != '[') {
						return false;
					}
					level = 1;
					break;
				case ')':
					if (stack.pop() != '(') {
						return false;
					}
					level = 2;
					break;
			}
		}
		return stack.size() == 0;
	}

	private static boolean judge3(String str) {
		str.replaceAll("()", "");
		str.replaceAll("[\\[\\]]", "");
		str.replaceAll("\\{\\}", "");
		return str.length() == 0;
	}
}
