package com.yue.learning.algorithm.string;

/**
 * 数字转字符串，有多少种可能的组合
 * 一个字符对应一个数字，如a->1，，，z->26
 * 把一串数字转化成字符串，返回有多少种可能性
 */
public class Number2String {


	public static void main(String[] args) {
		String num = "317171262415417170";
		System.out.println(convert(num.toCharArray(), 0));
	}

	private static int convert(char[] num,int start){
		if (start==num.length){
			return 1;
		}
		int res1 = convert(num, start+1);
		int res2 = 0;
		if (start<num.length-1&&(num[start]=='1'||(num[start]=='2'&&num[start+1]<='6'))){
			res2 = convert(num, start+2);
		}
		return res1+res2;
	}
}
