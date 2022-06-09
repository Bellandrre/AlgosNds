package Graphs;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
public class Dijkstra {

    static PriorityQueue<Vertex> nextVertex = new PriorityQueue<>((a, b) -> (int)(a.cost - b.cost));

    static class Vertex {
        String name;
        Set<Edge> edges;
        double cost;
        boolean visited;
        Vertex previous;

        public Vertex(){
            edges = new HashSet<>();
            cost = Double.MAX_VALUE;
            visited = false;
            previous = null;
        }

        public Vertex(String name){
            this.name = name;
            edges = new HashSet<>();
            cost = Double.MAX_VALUE;
            visited = false;
            previous = null;
        }
    }

    static class Edge{
        Vertex start;
        Vertex end;
        double weight;

        public Edge(double weight){
            this.start = null;
            this.end = null;
            this.weight = weight;
        }
    }

    public static Vertex shortestPath(Vertex A, Vertex B){
        nextVertex.add(A);
        A.cost = 0; // necessary step

        Vertex end = null;
        while(!nextVertex.isEmpty()){
            Vertex popped = nextVertex.poll(); // A -> B, D
            if(popped.equals(B)){
                end = popped;
                break;
            }
            for(Edge edge : popped.edges){
                Vertex toVertex = edge.end;
                if(!toVertex.visited) {
                    double newCostToVertex =  popped.cost + edge.weight;
                    if (newCostToVertex < toVertex.cost) {
                        toVertex.cost = newCostToVertex;
                        toVertex.previous = popped;
                        nextVertex.add(toVertex);
                    }
                }
            }
            popped.visited = true;
        }

        return end; // traverse path using previous pointers.
    }

    public static void main(String[] args) {
        Vertex A = new Vertex("A");
        Vertex B = new Vertex("B");
        Vertex C = new Vertex("C");
        Vertex D = new Vertex("D");
        Vertex E = new Vertex("E");
        Vertex F = new Vertex("F");
        Vertex G = new Vertex("G");


        A.edges = new HashSet<>();
            Edge a_to_b = new Edge(2);
            a_to_b.start = A;
            a_to_b.end = B;
            A.edges.add(a_to_b);

            Edge a_to_d = new Edge(1);
            a_to_d.start = A;
            a_to_d.end = D;

            A.edges.add(a_to_b);
            A.edges.add(a_to_d);


        B.edges = new HashSet<>();
            Edge b_to_d = new Edge(3);
            b_to_d.start = B;
            b_to_d.end = D;

            Edge b_to_e = new Edge(10);
            b_to_e.start = B;
            b_to_e.end = E;

            B.edges.add(b_to_d);
            B.edges.add(b_to_e);

        C.edges = new HashSet<>();
            Edge c_to_a = new Edge(2);
            c_to_a.start = C;
            c_to_a.end = A;

            Edge c_to_f = new Edge(5);
            c_to_f.start = C;
            c_to_f.end = F;

            C.edges.add(c_to_a);
            C.edges.add(c_to_f);

        D.edges = new HashSet<>();
            Edge d_to_c = new Edge(2);
            d_to_c.start = D;
            d_to_c.end = C;

            Edge d_to_e = new Edge(2);
            d_to_e.start = D;
            d_to_e.end = E;

            Edge d_to_f = new Edge(8);
            d_to_f.start = D;
            d_to_f.end = F;

            Edge d_to_g = new Edge(4);
            d_to_g.start = D;
            d_to_g.end = G;

            D.edges.add(d_to_c);
            D.edges.add(d_to_f);
            D.edges.add(d_to_g);

        E.edges = new HashSet<>();
            Edge e_to_g = new Edge(6);
            e_to_g.start = E;
            e_to_g.end = G;

            E.edges.add(e_to_g);

        G.edges = new HashSet<>();
            Edge g_to_f = new Edge(1);
            g_to_f.start = G;
            g_to_f.end = F;

            G.edges.add(g_to_f);

        Vertex result = shortestPath(A, F);

        while(result != null){
            System.out.print(result.name + " <- ");
            result = result.previous;
        }

    }
}
