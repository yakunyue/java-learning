package com.yue.learning.design;

import java.util.HashMap;
import java.util.Map;

public class MyLRU<K,V> {
	private Node<K,V> head;
	private Node<K,V> tail;
	private Map<K,Node<K,V>> map;
	private Integer size;

	public MyLRU(Integer size){
		if (size==null||size<=0){
			throw new RuntimeException("容量必须为整数");
		}
		this.size = size;
		map = new HashMap<>();
	}

	public void put(K key,V value){

		if (map.containsKey(key)){
			Node<K,V> node = map.get(key);
			node.value = value;
			moveToHead(node);
		}else {
			Node<K,V> node = new Node<>(key,value);
			if (map.size()==0){
				head = node;
				tail = head;
				head.next = tail;
				tail.prev = head;
			}
			node.next = head;
			head.prev = node;
			head = node;
			if (map.size()>=size){
				map.remove(tail.key);
				tail = tail.prev;
				tail.next = null;
			}
			map.put(key,node);
		}
	}

	public V get(K key){
		Node<K, V> node = map.get(key);
		if (node==null){
			return null;
		}
		moveToHead(node);
		return node.value;
	}

	private void moveToHead(Node<K,V> node){
		Node<K, V> prev = node.prev;
		Node<K, V> next = node.next;
		next.prev = prev;
		prev.next = next;
		node.prev = null;
		node.next = head;
		head.prev = node;
		head = node;
	}
}

class Node<K,V>{
	K key;
	V value;
	Node<K,V> next;
	Node<K,V> prev;
	public Node(K key,V value){
		this.key = key;
		this.value = value;
	}
}
