package Graphs;
import org.junit.Assert;

import java.util.*;

public class GraphTraversals {
     static class GraphNode{
        int value;
        ArrayList<GraphNode> adjList;

        public GraphNode(int value){
            this.value = value;
        }

        public GraphNode(int value, ArrayList<GraphNode> list){
            this.value = value;
            this.adjList = list;
        }

        public GraphNode(){}
    }
    public static void breadthFirstSearch(GraphNode start){
         HashMap<GraphNode, String> seenMap = new HashMap<>();
         Deque<GraphNode> queue = new LinkedList<>();

         queue.add(start);
         seenMap.put(start, "G");

         while(!queue.isEmpty()){
             GraphNode currNode = queue.poll();
             System.out.println(currNode.value);

             for(GraphNode node : currNode.adjList){
                 if(!seenMap.containsKey(node)){
                     seenMap.put(node, "G"); // This is Gray color
                     queue.addLast(node);
                 }
             }
             seenMap.put(currNode, "B"); // This node is fully discovered
         }

         Assert.assertTrue(seenMap.size() == 8);
         for(Map.Entry<GraphNode, String> entry : seenMap.entrySet() ){
             Assert.assertTrue("B".equals(entry.getValue())); // Here we assert that we have visited all vertices
         }
    }

    public static void depthFirstSearch(GraphNode start){
         Set<GraphNode> seen = new HashSet<>();
         depthFirstSearchUtil(start, new HashSet<>());
    }

    private static void depthFirstSearchUtil(GraphNode currNode, HashSet seen){
         // Mark this node as visited
        seen.add(currNode);
        System.out.println(currNode.value);

        for(GraphNode node : currNode.adjList){
            if(!seen.contains(node)){
                depthFirstSearchUtil(node, seen);
            }
        }
    }


    public static void main(String[] args) {
        GraphNode starting_1 = new GraphNode();
        starting_1.value = 1;

        GraphNode starting_2 = new GraphNode();
        starting_2.value = 2;

        GraphNode starting_3 = new GraphNode();
        starting_3.value = 3;

        GraphNode starting_4 = new GraphNode();
        starting_4.value = 4;

        GraphNode starting_5 = new GraphNode();
        starting_5.value = 5;

        GraphNode starting_6 = new GraphNode();
        starting_6.value = 6;

        GraphNode starting_7 = new GraphNode();
        starting_7.value = 7;

        GraphNode starting_8 = new GraphNode();
        starting_8.value = 8;

        starting_1.adjList = new ArrayList<>(Arrays.asList(starting_2));
        starting_2.adjList = new ArrayList<>(Arrays.asList(starting_1, starting_3));
        starting_3.adjList = new ArrayList<>(Arrays.asList(starting_2,starting_4));
        starting_4.adjList = new ArrayList<>(Arrays.asList(starting_3,starting_5, starting_6));
        starting_5.adjList = new ArrayList<>(Arrays.asList(starting_4, starting_6, starting_8));
        starting_6.adjList = new ArrayList<>(Arrays.asList(starting_4, starting_5, starting_8, starting_7));
        starting_7.adjList = new ArrayList<>(Arrays.asList(starting_6, starting_8));
        starting_8.adjList = new ArrayList<>(Arrays.asList(starting_5, starting_6, starting_7));


        GraphNode starting_01 = new GraphNode();
        starting_01.value = 1;

        GraphNode starting_02 = new GraphNode();
        starting_02.value = 2;

        GraphNode starting_03 = new GraphNode();
        starting_03.value = 3;

        GraphNode starting_04 = new GraphNode();
        starting_04.value = 4;

        GraphNode starting_05 = new GraphNode();
        starting_05.value = 5;

        GraphNode starting_06 = new GraphNode();
        starting_06.value = 6;

        GraphNode starting_07 = new GraphNode();
        starting_07.value = 7;

        GraphNode starting_08 = new GraphNode();
        starting_08.value = 8;

        GraphNode starting_09 = new GraphNode();
        starting_09.value = 9;

        GraphNode starting_10 = new GraphNode();
        starting_10.value = 10;

        starting_01.adjList = new ArrayList<>(Arrays.asList(starting_04, starting_02));
        starting_02.adjList = new ArrayList<>(Arrays.asList(starting_01, starting_03, starting_05, starting_08, starting_07));
        starting_03.adjList = new ArrayList<>(Arrays.asList(starting_04,starting_02,starting_10, starting_09));
        starting_04.adjList = new ArrayList<>(Arrays.asList(starting_01,starting_03));
        starting_05.adjList = new ArrayList<>(Arrays.asList(starting_02, starting_06, starting_08, starting_07));
        starting_06.adjList = new ArrayList<>(Arrays.asList(starting_05));
        starting_07.adjList = new ArrayList<>(Arrays.asList(starting_05, starting_02, starting_08));
        starting_08.adjList = new ArrayList<>(Arrays.asList(starting_02, starting_05, starting_07));
        starting_09.adjList = new ArrayList<>(Arrays.asList(starting_03));
        starting_10.adjList = new ArrayList<>(Arrays.asList(starting_03));



        //breadthFirstSearch(starting_8);
        depthFirstSearch(starting_01);
    }


}
