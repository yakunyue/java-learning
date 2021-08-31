package com.yue.learning.algorithm.string;

public class String2Integer {
	public static void main(String[] args) {
		System.out.println(convert("   2147483648"));
		System.out.println(' '-'0');
	}

	private static int convert(String str) {
		if (str==null||str.length()==0){
			return 0;
		}
		str = str.trim();
		str = str.replace(" ","");
		boolean isPositive = true;
		if (str.startsWith("-")) {
			isPositive = false;
		}
		char[] chars = str.toCharArray();
		int sum = 0;
		for (int i = (str.startsWith("-") || str.startsWith("+")) ? 1 : 0; i < chars.length; i++) {
			int digit = chars[i] - '0';
			if (Integer.MAX_VALUE / 10 < sum) {
				return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}
			if (Integer.MAX_VALUE / 10 == sum && Integer.MIN_VALUE % 10 < digit) {
				return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}
			sum = sum * 10 + digit;
		}

		return isPositive ? sum : -sum;
	}
	// 2147483647
	// 2147483648
}
