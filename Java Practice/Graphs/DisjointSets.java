package Graphs;
import java.sql.Array;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.*;

public class DisjointSets {

    static class Node{
        int value;
        boolean visited;

        public Node(int value){
            this.value = value;
            this.visited = false;
        }
    }

    static HashMap<Node, LinkedList<Node>> graph =  new HashMap<>();
    static List<HashSet<Node>> listOfSets   = new ArrayList<>();


    public static void constructSets(){


        HashSet<Node> seen = new HashSet<>();

        for(Map.Entry<Node, LinkedList<Node>> entry : graph.entrySet()){
            HashSet<Node> set = new HashSet<>();
            seen.add(entry.getKey());
            dfsUtil( entry.getKey(), set, seen);
            if(set.size() != 0)
                listOfSets.add(set);
        }
    }

    public static void dfsUtil(Node start, HashSet<Node> set, HashSet<Node> seen){
        LinkedList<Node> adj = graph.get(start);

        Iterator iterList = adj.iterator();

        while(iterList.hasNext()){
            Node currNode = (Node)iterList.next();
            if(!seen.contains(currNode)){
                seen.add(currNode);
                dfsUtil(currNode, set, seen);
            }else{

               for(HashSet currSet : listOfSets){
                   if(currSet.contains(currNode)){
                       currSet.add(start);
                       return;
                   }
               }
            }
        }
        set.add(start);
    }


    /*
    * seen 0, 1, 2, 4, 5, 6, 7
    * ListOfSets [{0, 1, 2, 3}, {4,8}, {5, 6, 7}]
    * */
    public static boolean checkIfNodesConnected(Node a, Node b){
        for(HashSet set : listOfSets){
            if(set.contains(a) && set.contains(b)){
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {

        Node zero = new Node(0);
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);
        Node eight = new Node(8);
        Node nine = new Node(9);

        LinkedList<Node> oneAdj = new LinkedList<>();
        oneAdj.add(zero);

        LinkedList<Node> twoAdj = new LinkedList<>();
        twoAdj.add(zero);

        LinkedList<Node> threeAdj = new LinkedList<>();
        threeAdj.add(one);

        LinkedList<Node> sixAdj = new LinkedList<>();
        sixAdj.add(five);

        LinkedList<Node> sevenAdj = new LinkedList<>();
        sevenAdj.add(five);

        LinkedList<Node> eightAdj = new LinkedList<>();
        eightAdj.add(four);

        graph.put(zero, new LinkedList<>());
        graph.put(one, oneAdj);
        graph.put(two, twoAdj);
        graph.put(three, threeAdj);
        graph.put(four, new LinkedList<>());
        graph.put(five, new LinkedList<>());
        graph.put(six, sixAdj);
        graph.put(seven, sevenAdj);
        graph.put(eight, eightAdj);
        graph.put(nine, new LinkedList<>());

        constructSets();

        System.out.println(checkIfNodesConnected(six, nine));


    }
}
