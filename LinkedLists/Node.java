package LinkedLists;

public class Node {
		
		Node next = null;
		int data;
		
		public Node(int data) {
			data = this.data;
			
		}
	
	
	public boolean insertRec(int data) {
		Node newNode = new Node(data);
		System.out.println("This is new Node "+ newNode );
		Node n =this;
		//System.out.println(n.data);
		while(n.next!=null) {
			n = n.next;
		}
		
		n.next = newNode;
		
		return true;
	}
	
		
	public void traverse() {
		Node n = this;
		System.out.println(n);
		while(n.next!=null) {
			System.out.println(n.data);
			n = n.next;
		}
	}
	
	public static void main(String[] args) {
		Node newN = new Node(10);
		System.out.println(newN.insertRec(20));
		
		newN.traverse();
		
		
	}
	
}
