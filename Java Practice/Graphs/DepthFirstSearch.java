package Graphs;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Deque;
public class DepthFirstSearch {

    private int numberOfvertices;
    private LinkedList<Integer> adj[];

    private HashSet<Integer> seen = new HashSet<>();

    public DepthFirstSearch(int numberOfvertices){

        this.numberOfvertices = numberOfvertices;
        this.adj = new LinkedList[numberOfvertices];

        for(int i = 0 ; i < this.numberOfvertices; i++){
            this.adj[i] = new LinkedList<>();
        }

    }

    public void addEdge(int from, int to){
        this.adj[from].add(to);
    }

    public void doDFS(int start){
        // 1
        // S {1, 2, 0, 3}
        // 1, 2, 0, 3
        //
        seen.add(start);
        doDFSHelper(start);
    }

    private void doDFSHelper(int start){
        System.out.println(start);

        Iterator iter = adj[start].iterator();
        while(iter.hasNext()){
            int current = (int)iter.next();
            if(!seen.contains(current)){
                seen.add(current);
                doDFSHelper(current);
            }
        }
    }

    public static void main(String[] args) {
        DepthFirstSearch g = new DepthFirstSearch(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println(
                "Following is Depth First Traversal "
                        + "(starting from vertex 2)");

        g.doDFS(1);
    }
}
