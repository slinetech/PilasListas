package com.slinetech.stacklist;

import java.util.Iterator;

import com.slinetech.exceptions.StackException;
import com.slinetech.interfaces.IStack;
import com.slinetech.node.Node;

public class StackList<T extends Comparable<T>> implements IStack<T>,Iterable<T>,Iterator<T> {
	private Node<T> start;
	private Node<T> end;
	Node<T> _tmp=end;
	private int top=-1;
	private int count=0;
	private int size;
	
	public StackList(int size) {
		start = new Node<T>();
		start.setIndex(-1);
		end = new Node<T>();
		end.setIndex(-1);
		this.size=size;
	}
	public StackList(T value,int size){
		this(size);
		Node<T> tmp =new Node<T>(value);
		tmp.setIndex(0);
		start.setNext(tmp);
		end.setBack(tmp);
		top++;
	}
	
	
	
	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			 Node<T> _tmp=end;
			@Override
			public boolean hasNext() {
				return (isEmpty())?false:(_tmp.getBack() != null);
			}

			@Override
			public T next() {
				T value=_tmp.getBack().getValue();
				_tmp=_tmp.getBack();
				return value;
			}
		};
	}
	@Override
	public boolean isEmpty() {
		return (top < 0);
	}
	@Override
	public boolean isFull() {
		return (count==size);
	}
	@Override
	public void push(T value) throws StackException {
		if (isFull()) throw new StackException("StackIsFull");
		Node<T> _new=new Node<T>(value);
		if (isEmpty()) {
			start.setNext(_new);
			_new.setIndex(++top);
			end.setBack(_new);
			count++;
		}else {
			_new.setBack(end.getBack());
			_new.setIndex(++top);
			count++;
			end.getBack().setNext(_new);
			end.setBack(_new);
		}
	}
	@Override
	public void pop() throws StackException {
		if(isEmpty()) throw new StackException("StackIsEmpty");
		end.getBack().getBack().setNext(null);
		end.setBack(end.getBack().getBack());
		System.gc();
		top--;
		count--;
	}
	@Override
	public T peek() throws StackException {
		if (isEmpty()) throw new StackException("StackIsEmpty");
		return end.getBack().getValue();
	}
	@Override
	public T search(T value) throws StackException {
		if(isEmpty()) throw new StackException("StackIsEmpty");
		Node<T> tmp=start;
		while(tmp.getNext() != null) {
			if (tmp.getNext().getValue().equals(value)) {
				return tmp.getNext().getValue();
			}
			tmp=tmp.getNext();
		}
		return null;
	}
	@Override
	public void clean() {
		if(isEmpty()) {
			System.out.println("La Pila esta vacia no se puede limpiar");
		}else {
			/*Node<T> tmp=start;
			Node<T> temp=null;
			while(tmp.getNext() != null) {
				if(tmp.getNext().getNext() != null)
					temp=tmp.getNext().getNext();
				else 
					temp=tmp.getNext();
				
				tmp.getNext().setNext(null);
				tmp.getNext().setBack(null);
				tmp=temp;
			}*/
			Node<T> tmp=start;
			Node<T> temp=null;
			while(start.getNext() != null) {
				if(start.getNext().getNext() != null)
					temp=start.getNext().getNext();
				else 
					temp=start.getNext();
				start.getNext().setNext(null);
				start.getNext().setBack(null);
				start=temp;
			}
			start=tmp;
			start.setNext(null);
			//System.out.println(start.getIndex()+ "index del ultimo elemento " + start.getNext());
			end.setBack(null);
			//System.out.println(end.getIndex()+ "index del ultimo elemento " + end.getBack());
			System.gc();
			top=-1;
			count=0;
			
		}
	}

	public void printer() {
		//System.out.println(top);
		if(isEmpty()) {
			System.out.println("Pila vacia");
		}else {
			Node<T> tmp=end;
			while(tmp.getBack()!= null) {
				System.out.println(tmp.getBack().getIndex()+ " " + tmp.getBack().getValue());
				tmp=tmp.getBack();
			}
		}
	}
	
	public void list() {
		if (isEmpty()) {
			System.out.println("\nImprimiendo Pila");
			_tmp=end;
			while(hasNext()) {
				System.out.println(next());
			}
		}else {
			System.out.println("La pila esta vacia por lo tanto no se puede imprimir");
		}
	}
	
	@Override
	public boolean hasNext() {
		return (isEmpty())?false:(_tmp.getBack() != null);
	}
	@Override
	public T next() {
		T value = _tmp.getBack().getValue();
		_tmp=_tmp.getBack();
		return value;
	}
}
