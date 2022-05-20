package Graphs;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Deque;

public class CloneGraph {

    class Node{
        public int val;
        public List<Node> neighbors;

        public Node(){
            this.val = 0;
            this.neighbors = new ArrayList<>();
        }

        public Node(int val){
            this.val = val;
            this.neighbors = new ArrayList<>();
        }

        public Node(int val, ArrayList<Node> _neighbors){
            this.val = val;
            this.neighbors = _neighbors;
        }

    }


    public Node breadthFirstSearch(Node start){
        Deque<Node> queue = new LinkedList<>();

        queue.addFirst(start);
        Node newStartNode = new Node();
        Node newGraph = newStartNode;

        while(!queue.isEmpty()){
            Node popped = queue.poll();

            for(Node node : popped.neighbors){
                queue.addLast(node);
            }
            newStartNode = popped;
        }
        return newGraph;
    }

    public static void main(String[] args) {

    }
}
