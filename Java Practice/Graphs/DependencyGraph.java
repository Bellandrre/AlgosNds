package Graphs;
import java.util.*;

public class DependencyGraph {

    HashSet<Integer> seen = new HashSet<>();
    HashSet<Integer> recursionStack = new HashSet<>();

    public boolean isCyclic(int[][] prerequisites){
        if(prerequisites.length == 0)
            return false;
        seen.add(prerequisites[0][0]);
        recursionStack.add(prerequisites[0][0]);

        return true; // doDFSHelper();
    }

    public boolean doDFSHelper(int start, int[][] prerequisites){

        int currentNode = prerequisites[start][0];
        return true;
    }

}
