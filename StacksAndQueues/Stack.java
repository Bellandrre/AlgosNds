package StacksAndQueues;

import java.util.EmptyStackException;

public class Stack<T> {
	
	class StackNode<T>{
		T data;
		StackNode<T> next;
		
		public StackNode(T data) {
			this.data = data;
		}
	}
	
	StackNode<T> top;
	
	public T pop() {
		if(top==null) throw new EmptyStackException();
		T item = top.data;
		top = top.next;
		return item;
	}
	
	public void push(T item) {
		StackNode<T> t = new StackNode<T>(item);
		t.next = top;
		top = t;
	}
	
	public T peek() {
		if(top==null) throw new EmptyStackException();
		return top.data;
	}
	
	public boolean isEmpty() {
		return top == null;
	}
	


}
