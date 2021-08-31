package com.yue.learning.algorithm.string;

/**
 * 翻转字符串
 */
public class StringReverse {
	public static void main(String[] args) {
		System.out.println(reverse("abcd"));
	}
	private static String reverse(String str){
		if(str==null||str.length()<2){
			return str;
		}
		int i = 0;
		int j = str.length()-1;
		char[] arr = str.toCharArray();
		while(i<j){
			swap(arr,i,j);
			i++;
			j--;
		}
		StringBuffer buffer = new StringBuffer();
		for (char c : arr){
			buffer.append(c);
		}

		return buffer.toString();
	}
	private static void swap(char[] arr ,int i,int j){
		char tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
