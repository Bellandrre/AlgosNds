package DataStructures;

/**
 * @author Karthik Kolathumani
 * This class can be used to build a simple primitive integer type linked list assuming the data is unique.
 * TODO:
 * 1) Make the list generic and allow duplicates
 * 2) Search in generic List and output next and prev pointers.
 * 3) Delete based on references.
 * */
public class LinkedList {

    private Node node;

    public LinkedList(int data){
        this.node = new Node(data);
    }

    private class Node{
        int val;
        Node next;
        Node prev;
        Node (int val, Node next, Node prev){
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
        Node (int val){
            this.val = val;
            this.next = null;
            this.prev = null;
        }

        private void addNode(int data){
            Node end = new Node(data);
            Node existing = this;

            while(existing.next != null){
                existing = existing.next;
            }

            existing.next = end;
            end.prev = existing;
        }

        private Node deleteNode(Node head, int d) {
            Node n = head;

            if(n.val == d){
                return n.next;
            }

            while(n.next != null){
                if(n.next.val == d){
                    n.next.next.prev = n;
                    n.next = n.next.next;
                    return head;
                }
                n = n.next;
            }
            return head;
        }

        private void printList(){
            Node head = this;
            while(head != null){
                System.out.print(head.val +" "+ "->");
                head = head.next;
            }
        }

        private void getPrevNode(int data){
            Node head = this;

            int prevVal = -1;

            if(head.val == data){
                System.out.println("This is the head node so there is no prev node!");
                return;
            }

            while(head  != null){
                if(head.val == data){
                    prevVal =  head.prev.val;
                    break;
                }
                head = head.next;
            }
            if(prevVal != -1) {
                System.out.println("Previous node for " + data + " is " + prevVal);
            }else{
                System.out.println("There is no node with value "+data);
            }
        }
    }

    public void add(int data){
        this.node.addNode(data);
    }

    public Node delete(LinkedList node, int data){
        if(this.node.val == data){
            return this.node.next;
        }
        return this.node.deleteNode(node.node, data);
    }

    public void printList(){
         this.node.printList();
         System.out.println();
    }

    public void getPrevNode(int data){
        this.node.getPrevNode(data);
    }

}
