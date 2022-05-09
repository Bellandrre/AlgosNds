package Graphs;
import java.util.LinkedList;
import java.util.List;
import java.util.Deque;
public class BreadthFirstSearch {

    /**
     *   10 ---> 20
     *  |  \
     *  |   \
     * 30--> 40
     */

    enum State{
        VISITED,
        UNVISITED,
        VISITING;
    }
    static List<Node> listNode = new LinkedList<>();
    static class Node{


        int value;
        LinkedList<Node> adjList;
        State state;

        public Node(int value){
            this.value = value;
            this.adjList = new LinkedList<>();
            this.state = State.UNVISITED;
        }
    }

    public static void breadthFirstSearch(Node start){

        Deque<Node> queue = new LinkedList<>();
        queue.addFirst(start);

        while(!queue.isEmpty()){
            Node poll = queue.poll();

            if(poll != null && poll.state == State.UNVISITED){

                LinkedList<Node> children = poll.adjList;

                for(Node node : children){
                    node.state = State.VISITING;
                    queue.addLast(node);
                }
            }
            poll.state = State.VISITED;
            System.out.println(poll.value);
        }
    }

    public static void depthFirstSearch(Node start){

    }

    public static void main(String[] args) throws Exception{
        Node newNode = new Node(10);
        Node newNode_2 = new Node(20);
        Node newNode_3 = new Node(30);
        Node newNode_4 = new Node(40);

        newNode.adjList.add(newNode_2);
        newNode.adjList.add(newNode_3);
        newNode.adjList.add(newNode_4);


        newNode_3.adjList.add(newNode_4);

        listNode.add(newNode);
        listNode.add(newNode_2);
        listNode.add(newNode_3);
        listNode.add(newNode_4);
        breadthFirstSearch(newNode);

    }

}
