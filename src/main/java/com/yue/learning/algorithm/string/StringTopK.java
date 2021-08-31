package com.yue.learning.algorithm.string;

import java.util.*;

/**
 * 给定一个字符串数组，输出出现次数最多的k个字符串
 */
public class StringTopK {

	public String[][] topKStrings(String[] strings, int k) {

		HashMap<String, Integer> map = new HashMap<>();
		for (String s : strings) {
			map.put(s, map.getOrDefault(s, 0) + 1);
		}
		List<String> list = new ArrayList<>(map.keySet());
		list.sort((s1, s2) -> {
			if (map.get(s1) == map.get(s2)) {
				return s1.compareTo(s2);
			} else {
				return map.get(s2) - map.get(s1);
			}
		});
		String[][] result = new String[k][];

		for (int i = 0;i<k;i++) {
			result[i] = new String[]{list.get(i),map.get(list.get(i)).toString()};
		}

		return result;
	}
}
