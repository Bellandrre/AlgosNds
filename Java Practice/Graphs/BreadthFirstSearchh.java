package Graphs;
import java.util.*;
import java.util.Deque;

public class BreadthFirstSearchh {

    private int noOfvertices;
    private LinkedList<Integer> adj[];

    public BreadthFirstSearchh(int noOfvertices){
        this.noOfvertices = noOfvertices;
        adj = new LinkedList[noOfvertices];
        for(int i = 0 ; i < this.noOfvertices; i++){
            this.adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(Integer fromVertex, Integer toVertex){
        adj[fromVertex].add(toVertex);
    }

    public void doBFS(Integer startNode){
        Deque<Integer> queue = new LinkedList<>();
        Set<Integer> seen = new HashSet<>();
        queue.add(startNode);
        seen.add(startNode);
        while(!queue.isEmpty()){
            Integer popped = queue.poll();
            System.out.println(popped + " ");
            LinkedList<Integer> neighbors = adj[popped];

            for(Integer neighbor : neighbors){
                if(!seen.contains(neighbor)) {
                    seen.add(neighbor);
                    queue.addLast(neighbor);
                }
            }


        }
    }

    public static void main(String[] args) {
        BreadthFirstSearchh g = new BreadthFirstSearchh(6);
        g.addEdge(5, 4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(2, 4);

        g.doBFS(0);
    }

}
