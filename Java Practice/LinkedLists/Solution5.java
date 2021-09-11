package LinkedLists;

public class Solution5 {
	static Node head;
	static Node head2;
	class Node{
		Node next;
		int data;
				
	}
	
	public Solution5(int value, int value2) {
		head = new Node();
		head.next = null;
		head.data = value;
		
		head2 = new Node();
		head2.next = null;
		head2.data = value2;
			
	}
	
	public boolean insertrec(int value) {
		Node n;
		Node newNode = new Node();
		n = head;
		while(n.next!=null) {
			n=n.next;
		}
		n.next = newNode;
		newNode.next = null;
		newNode.data = value;
		return true;
		
	}
	

	public boolean insertrec2(int value) {
		Node n;
		Node newNode = new Node();
		n = head2;
		while(n.next!=null) {
			n=n.next;
		}
		n.next = newNode;
		newNode.next = null;
		newNode.data = value;
		return true;
		
	}
	
	
	
	public void traverse2() {
		Node n = head2;
		while(n!=null) {
			System.out.println(n.data);
			n = n.next;
		}
	}
	
	
	
	public void traverse() {
		Node n = head;
		while(n!=null) {
			System.out.println(n.data);
			n = n.next;
		}
	}
	
	
	public int addlists(Node head,Node head2) {
		int sum = 0;
		Node n = head;
		Node n2 = head2;
		StringBuilder s = new StringBuilder();
		StringBuilder s2 = new StringBuilder();
		while(n!=null) {
			s.append(n.data);
			n = n.next;
		}
		
		while(n2!=null) {
			s2.append(n2.data);
			 n2 = n2.next;
		}
		
		s.reverse(); s2.reverse();
		
		sum = Integer.parseInt(s.toString()) + Integer.parseInt(s2.toString());
		System.out.println(sum);
		return sum;
	}
	
	
	public static void main(String[] args) {
		Solution5 init = new Solution5(1,1);
		init.insertrec(2);
		init.insertrec(3);
		//init.traverse();
		
		
		init.insertrec2(2);
		init.insertrec2(3);
		//init.traverse2();
		
		init.addlists(head, head2);
	}

}
