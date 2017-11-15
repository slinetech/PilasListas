package com.slinetech.interfaces;

import com.slinetech.exceptions.StackException;

public interface IStack<T> {
	
	public boolean isEmpty();
	public boolean isFull();
	public void push(T value) throws StackException;
	public void pop() throws StackException;
	public T peek() throws StackException;
	public T search(T value) throws StackException;
	public void clean();
}
