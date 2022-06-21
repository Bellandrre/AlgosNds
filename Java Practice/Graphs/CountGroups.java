package Graphs;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.*;
public class CountGroups {
    // [[1,1,0],[1,1,0],[0,0,1]]


    static int[][] nodesMap;

    public static void buildGraph(String input[][]){
        nodesMap = new int[input.length][input.length];

        for(int i = 0 ; i < input.length; i++){
            for(int j = 0 ; j < input[i].length; j++){
                nodesMap[i][j] = Integer.parseInt(input[i][j]);
            }
        }
    }


    public static int dfs(){
        boolean visited[] = new boolean[nodesMap.length];
        int count = 0;
        for(int i = 0 ; i < nodesMap.length; i++){
            if(!visited[i]){
                visited[i] = true;
                dfsUtil(visited,i);
                count++;
            }
        }
        return count;
    }

    public static void dfsUtil(boolean[] visited, int i){
        for(int j = 0 ; j < nodesMap[i].length; j++){
            if(nodesMap[i][j] == 1 && !visited[j]){
                visited[j] = true;
                dfsUtil(visited, j);
            }
        }
    }
    public static void main(String[] args) {
        String input[][] = {{"1", "1", "0"},
                            {"1", "1", "0"},
                            {"0", "0", "1"}};

        buildGraph(input);
        System.out.println(dfs());
    }
}
