
public class LinkedlistPractice {
	
	Node head;
	
	class Node {
		int value;
		Node next;
	}
	
	public LinkedlistPractice(int init) {
		head = new Node();
		head.value = init;
		head.next = null;
		
	}
	
	public boolean insertRec(int val) {
		Node n = new Node();
		n.value = val;
		n.next = head;
		head = n;
				
		return true;
	}
	
	
	public int endDeleteRec() {
		int value;
		value = head.value;
		head = head.next;
		return value;
		
	}
	
	public void print() {
		Node z = head;
		while(z!=null) {
			System.out.println(z.value);
			z = z.next;
		}
	}
	
	public boolean insertMiddle(int val, int whr) {
		Node z = head;
		while(z!= null) {
			if(z.value == whr) {
				Node n = new Node();
				n.value = val;
				n.next = z.next;
				z.next = n;
				return true;
			}
			z = z.next;
		}
		
		
		System.out.println("Not found");
		return false;
	}
	
	
	
	public boolean deleteMiddle(int val) {
		if(head.value == val) {
			head.next = head;
			return true;
		}
		
		else {
			Node x;
			Node y;
			
			x = head;
			y = head.next;
			while(true) {
			if(y == null || y.value == val) {
				break;
			}
			
			else {
				
				x = y;
				y = y.next;
			}
			
			}
			
			if(y!=null) {
				x.next = y.next;
				return true;
			}
			else {
				return false;
			}
			
		}
		
		
		
		
		
		
		
	}
	
	
	
	public static void main(String[] args) {
		LinkedlistPractice l1 = new LinkedlistPractice(0);
		l1.insertRec(20);
		l1.insertRec(40);
		l1.insertRec(60);
		l1.insertMiddle(50, 60);
		l1.deleteMiddle(40);
		l1.print();
		
		
		
		
		
				
		
	}
	

}
