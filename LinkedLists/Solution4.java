package LinkedLists;

public class Solution4 {
  Node head;
  Node temp;
  public class Node {
    Node next;
    int data;

  }

  public Solution4(int value) {
    head = new Node();
    head.next = null;
    head.data = value;

  }

  public boolean insertRec(int value) {
    Node travelNode;
    travelNode = head;
    while (travelNode.next != null) {
      travelNode = travelNode.next;
    }
    Node newNode = new Node();
    travelNode.next = newNode;
    newNode.next = null;
    newNode.data = value;
    return true;


  }


  public boolean insertTemp(int value) {
    if (temp == null) {
      temp = new Node();
      temp.next = null;
      temp.data = value;
      return true;
    }

    Node n = new Node();
    n = temp;
    while (n.next != null) {
      n = n.next;
    }

    Node newTemp = new Node();
    n.next = newTemp;
    newTemp.data = value;
    newTemp.next = null;
    return true;
  }


  public void travel() {
    Node n = new Node();
    n = head;
    while (n != null) {
      System.out.println(n.data);
      n = n.next;
    }
  }

  public boolean partition(int value) {
    int count = 0;
    Node fwd = new Node();
    Node bck = new Node();
    fwd = head.next;
    bck = head;
    while (bck != null) {
      if (fwd.data == value) break;
      bck = fwd;
      fwd = fwd.next;
    }

    Node runn = new Node();
    runn = fwd;

    while (runn != null) {
      if (runn.data < fwd.data) {
        insertTemp(runn.data);
        count++;
      }

      runn = runn.next;
    }

    if (count == 0) {
      System.out.println("No such partition");
      return false;
    }

    Node m = temp;
    while (m.next != null) {
      m = m.next;
    }

    bck.next = temp;
    m.next = fwd;
    fwd.next = null;

    return true;

  }


  public static void main(String[] args) {
    Solution4 newNode = new Solution4(10);
    newNode.insertRec(20);
    newNode.insertRec(0);
    newNode.insertRec(1);
    newNode.insertRec(2);
    newNode.insertRec(3);
    newNode.insertRec(4);
    newNode.insertRec(5);
    newNode.insertRec(6);
    newNode.insertRec(7);
    long startTime = System.currentTimeMillis();
    
    newNode.partition(20);
    long endTime = System.currentTimeMillis();
    long total = endTime - startTime;
    System.out.println(total);
    //newNode.travel();
  }


}
