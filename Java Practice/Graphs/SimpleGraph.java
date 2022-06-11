package Graphs;

import java.util.LinkedList;

public class SimpleGraph {

    private int noOfvertices;
    private LinkedList<Integer> adj[];

    public SimpleGraph(int noOfvertices){
        this.noOfvertices = noOfvertices;
        adj = new LinkedList[noOfvertices];
        for(int i = 0 ; i < this.noOfvertices; i++){
            this.adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(Integer fromVertex, Integer toVertex){
        adj[fromVertex].add(toVertex);
    }

    public LinkedList<Integer>[] getGraph() throws NullPointerException{
        if(adj == null)
            throw new NullPointerException();
        return adj;
    }
}
