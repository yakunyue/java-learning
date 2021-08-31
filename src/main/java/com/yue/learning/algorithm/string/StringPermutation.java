package com.yue.learning.algorithm.string;

import java.util.*;

/**
 * 回溯算法-全排列问题
 *
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则按字典序打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入描述：
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 * 示例
 * 输入："ab"
 * 输出：["ab","ba"]
 */
public class StringPermutation {

//	List<String> res = new LinkedList<>();
//	char[] c;
//
//	public String[] permutation(String s) {
//		c = s.toCharArray();
//		dfs(0);
//		return res.toArray(new String[res.size()]);
//	}
//
//	void dfs(int x) {
//		if (x == c.length - 1) {
//			res.add(String.valueOf(c));      // 添加排列方案
//			return;
//		}
//		HashSet<Character> set = new HashSet<>();
//		for (int i = x; i < c.length; i++) {
//			if (set.contains(c[i]))
//				continue;        // 重复，因此剪枝
//			set.add(c[i]);
//			swap(i, x);         // 交换，将 c[i] 固定在第 x 位
//			dfs(x + 1);      // 开启固定第 x + 1 位字符
//			swap(i, x);         // 恢复交换
//		}
//	}
//
//	void swap(int a, int b) {
//		char tmp = c[a];
//		c[a] = c[b];
//		c[b] = tmp;
//	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(range("abcd")));

		LinkedList<String> res = new LinkedList<>();
		doBacktrack("abcd".toCharArray(),new LinkedHashSet(),res);
		System.out.println(res);
	}

	private static String[] range(String str) {
		List<String> list = new ArrayList<>();
		char[] c = str.toCharArray();
		doRange(0,c,list);
		return list.toArray(new String[list.size()]);
	}

	private static void doRange(int x, char[] c,List<String> list) {
		if (x==c.length){
			list.add(String.valueOf(c));
		}
		Set<Character> set = new HashSet<>();
		for (int i = x;i<c.length;i++){
//			if (set.contains(c[i])){
//				continue;
//			}
			set.add(c[i]);
			swap(c,i,x);
			doRange(x+1,c,list);
			swap(c,i,x);
		}
	}

	static void swap(char[] c,int a, int b) {
		char tmp = c[a];
		c[a] = c[b];
		c[b] = tmp;
	}

	/**
	 *
	 * 另一个实现方式,性能不及上一个,但是更好理解一些
	 */

	private static void doBacktrack(char[] c, Set<Character> characterSet, List<String> res) {
		if (characterSet.size() == c.length) {
			StringBuilder stringBuilder = new StringBuilder();
			characterSet.forEach(ch->stringBuilder.append(ch));
			res.add(stringBuilder.toString());
			return;
		}
		for (char value : c) {
			if (characterSet.contains(value)) {
				continue;
			}
			characterSet.add(value);
			doBacktrack(c, characterSet, res);
			characterSet.remove(value);
		}
	}


}
