package LinkedLists;
import java.util.*;
public class Solution6 {
  Node head;
  class Node {
    Node next;
    int data;
  }

  public Solution6(int value) {
    head = new Node();
    head.next = null;
    head.data = value;
  }

  public boolean insertRec(int value) {
    Node n;
    n = head;
    while (n.next != null) {
      n = n.next;
    }
    Node newNode = new Node();
    newNode.next = null;
    newNode.data = value;
    n.next = newNode;
    return true;
  }

  public void travel() {
    Node n;
    n = head;
    while (n != null) {
      System.out.println(n.data);
      n = n.next;
    }
  }


  public boolean checkPalidrome() {
    int checkOdds = 0;
    Map < Integer,Integer > map = new TreeMap < > ();

    Node n = head;

    while (n != null) {
      if (!map.containsKey(n.data)) {
        map.put(n.data, 1);
      } else
        map.put(n.data, map.get(n.data) + 1);

      n = n.next;
    }


    for (Map.Entry < Integer, Integer > entry: map.entrySet()) {
      if (entry.getValue() % 2 != 0) {
        checkOdds++;		
      }
    }


    return checkOdds <= 1;
  }
  
  
  public boolean checkPal(Node head) {
	  
	  Node fast = head;
	  Node slow = head;
	  while(fast!=null) {
		  fast = fast.next.next;
		  slow = slow.next;
	  }
	  
	  return true;
  }


  public static void main(String[] args) {
    Solution6 newNode = new Solution6(9);
    newNode.insertRec(2);
    newNode.insertRec(2);
    newNode.insertRec(8);
    //newNode.travel();
    System.out.println(newNode.checkPalidrome());

  }


}
