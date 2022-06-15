package com.yue.learning.algorithm.lru;

import java.util.*;

public class MyLruCache<K, V> {
    static class Node<K, V> {
        public K k;
        public V v;
        public Node<K, V> pre;
        public Node<K, V> next;

        public Node() {
        }

        public Node(K k, V v) {
            this.k = k;
            this.v = v;
        }
    }

    private final Integer capacity;
    private final Integer size = 0;
    private Map<K, Node<K, V>> map;
    private Node<K, V> head;
    private Node<K, V> tail;

    public MyLruCache(Integer capacity) {
        this.capacity = capacity;
        this.head = new Node<>();
        this.tail = new Node<>();
        this.head.next = tail;
        this.tail.pre = head;
    }

    public void put(K k, V v) {
        if (map == null) {
            map = new HashMap<>();
        }
        //已存在
        if (map.containsKey(k)) {
            //移动到队首
            moveToHead(map.get(k));
            map.get(k).v = v;
        } else {
            Node<K, V> node = new Node<>(k, v);
            node.pre = head;
            node.next = head.next;
            head.next.pre = node;
            head.next = node;
            map.put(k, node);
            if (map.size() > capacity) removeTail();
        }
    }

    public V get(K k) {
        if (map.containsKey(k)) {
            moveToHead(map.get(k));
            return map.get(k).v;
        }
        return null;
    }

    private void removeTail() {
        Node<K, V> re = this.tail.pre;
        re.pre.next = this.tail;
        this.tail.pre = re.pre;
        map.remove(re.k);
    }

    private void moveToHead(Node<K, V> node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        node.pre = head;
        node.next = this.head.next;
        this.head.next.pre = node;
        this.head.next = node;
    }

    public List<K> getKeys() {
        List<K> keys = new ArrayList<>();
        Node<K, V> next = this.head.next;
        while (next != null && next != this.tail) {
            keys.add(next.k);
            next = next.next;
        }
        return keys;
    }

    public static void main(String[] args) {
        MyLruCache<Integer, String> cache = new MyLruCache<>(3);
        cache.put(1, "a");
        cache.put(2, "a");
        cache.put(3, "a");
        System.out.println(cache.getKeys());
        cache.put(4, "a");
        System.out.println(cache.getKeys());
        cache.get(3);
        System.out.println(cache.getKeys());
    }


}

