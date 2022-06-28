package Graphs;
import java.util.*;
public class CourseSchedule {

    HashMap<Integer, List<Integer>> graph;
    HashSet<Integer> seen = new HashSet<>();

    public void buildGraph(int[][] prerequisites, int numberOfCourses){
        for(int i = 0; i < prerequisites.length; i++){
            graph.put(prerequisites[i][0], new ArrayList<Integer>());
            for(int j = 1 ; j < prerequisites[i].length; j++){
                graph.get(prerequisites[i][0]).add(prerequisites[i][j]);
            }
        }
    }

    public boolean dfs(int currentCourse){
        if(seen.contains(currentCourse))
            return false;

        if(graph.get(currentCourse).size() == 0){
            return true;
        }

        seen.add(currentCourse);

        List<Integer> preReq = graph.get(currentCourse);

        for(Integer i : preReq){
            if(!dfs(i))
                return false;
            else{

            }
        }
        return true;
    }

}
