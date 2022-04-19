/*
    Simple generic Graph class
 */

package Graphs;
import java.util.ArrayList;
public class Graph<T> {

    static class NodeNotFoundException extends Exception{
        public NodeNotFoundException(){
        }
        public NodeNotFoundException(String message){
            super(message);
        }
    }

    static ArrayList<Node> listOfNodes;

    static class Node<T>{
        T data;
        ArrayList<Edge> edges;

        public Node(){
            this.data = null;
            this.edges = null;
        }

        public Node(T data, ArrayList<Edge> edges){
            this.data = data;
            this.edges = edges;
        }

        public Node(T data){
            this.data = data;
            this.edges = null;
        }
    }

    static class Edge<T>{
        Node from;
        Node to;
        T type;

        public Edge(){
            this.from = null;
            this.to = null;
        }
        public Edge (Node from, Node to){
            this.from = from;
            this.to = to;
        }

        public Edge(Node from, Node to, T type){
            this.from = from;
            this.to = to;
            this.type = type;
        }
    }

    public Graph(){
        listOfNodes = new ArrayList<>();
    }

    public void addNode(T newNode){
        Node<T> newNodeToBeAdded = new Node<>();
        newNodeToBeAdded.edges = null;
        listOfNodes.add(newNodeToBeAdded);
    }

    public boolean addNode(T newNode, T to) throws NodeNotFoundException{
        Node<T> newNodeToBeAdded = new Node<>(newNode);
        Edge<T> edge = new Edge<>();
        // find the toNode from the list of nodes in graph
        Node toNode = null;

        for(Node node : listOfNodes){
            if(node.data.equals(to)){
                toNode = node;
            }
        }
        if(toNode == null){
            if(toNode == null)
                throw new NodeNotFoundException("ToNode not found");
        }else {
            edge.from = newNodeToBeAdded;
            edge.to = toNode;
            newNodeToBeAdded.edges.add(edge);
        }
        return true;
    }

    public boolean deleteNode(T deleteNode) throws NodeNotFoundException{
        Node nodeToRemoved = null;

        for(Node node : listOfNodes){
            if(node.data.equals(deleteNode)){
                nodeToRemoved = node;
                break;
            }
        }
        if(nodeToRemoved == null)
            throw new NodeNotFoundException();
        else{
            listOfNodes.remove(nodeToRemoved);
            return true;
        }
    }

    public void traverseGraph(){

    }
}
