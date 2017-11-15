package com.slinetech.node;

public class Node<T> {
	
	private Node<T> back;
	private Node<T> next;
	private T value;
	private long index;
	
	public Node() {
	}
	
	public Node(T value) {
		this.value=value;
	}
	
	public Node<T> getBack() {
		return back;
	}
	public void setBack(Node<T> back) {
		this.back = back;
	}
	public Node<T> getNext() {
		return next;
	}
	public void setNext(Node<T> next) {
		this.next = next;
	}
	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
	public long getIndex() {
		return index;
	}
	public void setIndex(long index) {
		this.index = index;
	}
	
	
}
