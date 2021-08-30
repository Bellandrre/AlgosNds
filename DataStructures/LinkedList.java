package DataStructures;

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
                    n.next = n.next.next;
                    n.next.next.prev = n; // re pointing pointer back to deleted node's prev
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

}
