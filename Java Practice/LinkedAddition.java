
public class LinkedAddition {
	
	public class ListNode{
		int val;
		ListNode next;
		ListNode(int x){
			val = x; 
			}
	}
	
	public static void main(String[] args) {
		LinkedAddition l = new LinkedAddition();
		LinkedAddition.ListNode l1 = l.new ListNode(1);
		LinkedAddition.ListNode l2 = l.new ListNode(2);
		l1.next = l2;
		l2.next = null;
		LinkedAddition.ListNode l3 = l.new ListNode(3);
		l2.next = l3;
		l3.next = null;
		
		
		
	}
	
	


}
