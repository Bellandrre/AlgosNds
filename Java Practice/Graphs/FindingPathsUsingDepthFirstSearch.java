package Graphs;
import java.util.*;

public class FindingPathsUsingDepthFirstSearch {

    static private LinkedList<Integer> adj[];

    public static LinkedList<Integer> findPathUsingBFS(int start, int end){
        Deque<Integer> queue = new LinkedList<>();
        HashSet<Integer> seen = new HashSet<>();
        queue.add(start);
        seen.add(start);
        LinkedList<Integer> resultQueue = new LinkedList<>();

        while(!queue.isEmpty()){

            int popped = queue.poll();

            if(popped == end){
                resultQueue.addLast(end);
                return resultQueue;
            }

            Iterator iter = adj[popped].iterator();

            while(iter.hasNext()){
                int current = (int)iter.next();
                if(!seen.contains(current)){
                    seen.add(current);
                    queue.addLast(current);
                }
            }
            resultQueue.addLast(popped);
        }
        return new LinkedList<>();
    }


    public static void main(String[] args) {

        SimpleGraph g = new SimpleGraph(7);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        adj = g.getGraph();

        for(int i = 0 ; i < adj.length; i++){
            System.out.print(i + "|");
            for(Integer value : adj[i]){
                System.out.println( value + " ");
            }
            System.out.println();
        }

        System.out.println(findPathUsingBFS(1, 3).toString());
    }

}
