package LinkedLists;

import java.util.Random;

// Deleting the middle element singly linked list
public class Solution3 {
	Node head;
	class Node{
		Node next;
		int data;
	}
	
	public Solution3(int value) {
		head = new Node();
		head.data = value;
		head.next = null;
	}
	
	public boolean insert(int value) {
		Node n = new Node();
		Node travNode = new Node();
		travNode = head;
		while(travNode.next!=null) {
			travNode = travNode.next;
		}
		n.data = value;
		travNode.next = n;
		n.next = null;	
		return true;
		
	}
	
	public void traverse() {
		Node n = head;
		while(n!=null) {
			System.out.println(n.data);
			n = n.next;
		}
	}
	
	// A bubble sort
	public void sortList() {
		Node a = new Node();
		Node b = new Node();
		int temp;
		a = head;
		while(a.next!=null) {
			b = head; //necessary
			while(b.next!=null) {
				if(b.data > b.next.data){
					temp = b.data;
					b.data = b.next.data;
					b.next.data = temp;
				}
				b = b.next;
			}
			a = a.next;
		}
	}
	
	public void partition(int value) {
		Node a = new Node();
		Node b = new Node();
		Node c = new Node();
		Node d = new Node();
		Node head2 = new Node();
		Node travel = new Node();
		travel = head2;
		a = head.next;
		b = head;
		while(true) {
			if(a.next==null) {System.out.println("Element not found"); break;}
			if(a.data==value) {c = a; break;}
			b = a;
			a = a.next;
		}
		
		d = c;
		c = c.next;
		System.out.println(c.data);
		head2.next = null;
		while(true) {
			if(c.next==null) break;
			if(c.data<a.data) {
				System.out.println("Executed");
				if(head2.data == 0) { head2.data = c.data; d = c; c = c.next; continue;}
				Node n = new Node();
				while(travel.next!=null) {
					travel = travel.next;
				}
				
				travel.next =n;
				n.next = null;
				n.data = c.data;
				
			}
			d = c;
			c = c.next;			
			
		}
		
		Node n = head2;
		while(n!=null) {
			System.out.println(n.data);
			n = n.next;
		}
		
		
		
	}

	public static void main(String[] args) {
		Solution3 newNode = new Solution3(20);
		newNode.insert(21);
		newNode.insert(9);
		newNode.insert(29);newNode.insert(245);newNode.insert(246);newNode.insert(65);newNode.insert(2);
		
		newNode.partition(245);
		//newNode.traverse();
		
		
	}
	
}
