package Graphs;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class DetectCyclesInGraph {

    static LinkedList<Integer> adj[];
    static HashSet<Integer> seen = new HashSet<>();
    static HashSet<Integer> recStack = new HashSet<>();

    /*
     recStack - 1, 2, 0
     seen - 1, 2, 0
     stack true
     current -
     */
    public static boolean hasCycles(int start){
        seen.add(start);
        return doDFSHelper(start);
    }

    public static boolean doDFSHelper(int start){
        recStack.add(start);
        Iterator iter = adj[start].iterator();
        while(iter.hasNext()){
            int currentNeighbor = (int)iter.next();
            if(seen.contains(currentNeighbor) && recStack.contains(currentNeighbor)){
                return true;
            }
            if(!seen.contains(currentNeighbor)){
                seen.add(currentNeighbor);
                return doDFSHelper(currentNeighbor);
            }
        }
        return false;
    }


    public static void main(String[] args) {
        SimpleGraph g = new SimpleGraph(7);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        g.addEdge(5, 6);

        adj = g.getGraph();

        System.out.println(hasCycles(1));

    }
}
