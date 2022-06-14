package Graphs;
import java.util.*;

public class DependencyGraph {

    class Gnode{
        public Integer inDegrees = 0;
        public List<Integer> outNodes = new LinkedList<>();
    }

    public boolean canFinish(int numCourses, int[][] prerequisites){
        if(prerequisites.length == 0){
            return true;
        }

        HashMap<Integer, Gnode> graph = new HashMap<>();

        for(int[] relation : prerequisites){
            //Gnode prevCourse = this.get
        }
        return true;
    }
}
