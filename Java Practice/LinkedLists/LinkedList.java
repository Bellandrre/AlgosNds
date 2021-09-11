package LinkedLists;
import java.util.*;
public class LinkedList {
	Node head;
	
	public class Node{
		Node next;
		int data;
		Node prev;
		
	}
	
	public LinkedList (int value) {
		head = new Node();
		head.data = value;
		head.next = null;
		head.prev = null;
	}
	
	public boolean insertRec(int value) {
		Node newNode = new Node();
		newNode.data = value;
		head.next = newNode;
		newNode.prev = head;
		newNode.next = null;
		head = newNode;
		return true;
		
	}
	
	
	public void traverse() {
		Node n = head;
		while(n!=null) {
			System.out.println(n.data);
			n = n.prev;
		}
	}
	
	public boolean search(int value) {
		Node n = head;
		while(n!=null) {
			if(n.data==value) return true;
			n = n.prev;
		}
		return false;
	}
	
	
	public boolean search_duplicates() {
		Set<Integer> seen = new HashSet<>();
		Node n = head;
		boolean flag = false;
		while(n!=null) {
			if(!seen.contains(n.data)) {
			seen.add(n.data);
			n = n.prev;
			}
			else {
			flag	= deleteNode(n);
				n = n.prev;
			}
		}
		return flag;
	}
	
	
	public boolean search_duplicated_without_buffer() {
		Node current = head;
		while(current!=null) {
			Node runner = current;
			while(runner.prev!=null) {
				if(runner.prev.data == current.data) {
					deleteNode(runner.prev);
				}
				else {
					runner = runner.prev;
				}
			}
			current = current.prev;
		}
		return true;
	}
	
	
	public boolean deleteNode(Node n) {
		System.out.println("Delete Node called for : "+n.data );
		n.prev.next = n.next;
		n.next.prev = n.prev;
		return true;
		
	}
	
	
	
	
	public static void main(String[] args) {
		LinkedList newN = new LinkedList(10);
		newN.insertRec(20);
		newN.insertRec(30);
		newN.insertRec(30);
		newN.insertRec(40);
		newN.insertRec(670);
		newN.insertRec(800);
		newN.insertRec(340);
		newN.insertRec(340);
		newN.insertRec(3400);
		//newN.traverse();
		newN.search_duplicated_without_buffer();
		newN.traverse();
		
	}
	
	
	
	
}
