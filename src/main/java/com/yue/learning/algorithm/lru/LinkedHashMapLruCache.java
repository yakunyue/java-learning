package com.yue.learning.algorithm.lru;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapLruCache<K, V> extends LinkedHashMap<K,V> {

    private final int capacity;

    public LinkedHashMapLruCache(int initialCapacity) {
        super(initialCapacity, 0.75f, true);
        this.capacity = initialCapacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return this.size() > capacity;
    }

    public static void main(String[] args) {
        LinkedHashMapLruCache<Integer, String> cache = new LinkedHashMapLruCache(3);
        cache.put(1,"a");
        cache.put(2,"a");
        cache.put(3,"a");
        System.out.println(cache.keySet());
        cache.put(4,"a");
        cache.get(3);
        System.out.println(cache.keySet());
    }
}
