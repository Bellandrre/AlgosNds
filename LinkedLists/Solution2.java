package LinkedLists;


//Singly Linked - List
public class Solution2 {
	Node head;
	Node first;
	public class Node{
		Node next;
		int data;
	}
	
	public Solution2(int value) {
		head = new Node();
		head.data = value;
		head.next = null;
		first = new Node();
		first = head; // 
	}
	
	public boolean insert(int value) {
		Node n =new Node();
		n.data = value;
		n.next = head;
		head = n;
		return true;
	}
	
	public void traverse() {
		Node n = head;
		while(n!=null) {
			System.out.println(n.data);
			n = n.next;
		}
	}
	
	public void findKthElement(int k) {
		Node last = new Node();
		Node kp = new Node();
		last = head;
		kp = head;
		
		for(int i=0;i<k;i++) {
			if(last==null) { System.out.println("K exceeds length of LinkedList"); break;}
			last = last.next;
		}
		
		while(last!=null) {
			last = last.next;
			kp = kp.next;
		}
		
		System.out.println(kp.data);
	}
	
	
	public static void main(String[] args) {
		// Insertion here is in from backwards, i.e. the first element you insert is actually the last element.
		Solution2 newNode = new  Solution2(10);
		newNode.insert(90);
		newNode.insert(20);
		newNode.insert(80);
		newNode.insert(20);
		newNode.findKthElement(2);
		
	}
	
	
	
	
}
