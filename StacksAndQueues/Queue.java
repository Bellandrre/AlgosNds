package StacksAndQueues;
import java.util.NoSuchElementException;

public class Queue<T> {
	class QueueNode<T>{
		QueueNode<T> next;
		T data;
		
		public QueueNode(T data) {
			this.data = data;
		}
	}
	
	QueueNode<T> front;
	QueueNode<T> back;
	
	public T remove() {
		if(front==null) throw new NoSuchElementException();
		T data = front.data;
		front = front.next;
		if(front==null) {
			back = null;
		}
		return data;
	}
	
	public void add(T data) {
		QueueNode<T> t = new QueueNode<T>(data);
		if(back!=null) {
			back.next =t;
		}
		
		back = t;
		
		if(front==null) {
			front = back;
		}

	}
	
	public T peek() {
		if(front==null) throw new NoSuchElementException();
		T data = front.data;
		return data; 
	}
	
	public boolean isEmpty() {
		return front==null;
	}
	
}
