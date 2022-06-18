package Graphs;
import java.util.List;
public class CountGroups {
    // [[1,1,0],[1,1,0],[0,0,1]]

    static int graph[][];

    static boolean visited[][];

    private static void constructGraph(String input[][]){
        for(int i = 0 ; i < input.length; i++){
            for(int j = 0 ; j < input[i].length; j++){
                graph[i][j] = Integer.parseInt(input[i][j]);
                visited[i][j] = false;
            }
        }
    }

    public static void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }
    public static int findCircleNum() {
        int[] visited = new int[graph.length];
        int count = 0;
        for (int i = 0; i < graph.length; i++) {
            if (visited[i] == 0) {
                dfs(graph, visited, i);
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String input[][] = {{"1", "1", "0"},
                            {"1", "1", "0"},
                            {"0", "0", "1"}};

        int rows = input.length;
        int columns = input.length;

        graph= new int[rows][columns];
        visited = new boolean[rows][columns];

        constructGraph(input);
        System.out.println(findCircleNum());
    }
}
