import java.util.*;
/*Breath first Traversal for a directed graph
Code works from source to Sink.*/


public class BFS {
	
	LinkedList<Integer> adj[];
	 int size;
	
	@SuppressWarnings("unchecked")
	public BFS(int size) {
		this.size = size;
		adj = new LinkedList[size];
		for(int i = 0; i<size; i++) {
			adj[i] = new LinkedList<>();
		}
	}
		
	void addEdge(int v , int w) {
		adj[v].add(w); 
		adj[w].add(v);
	}
	
	
	void traverse(int s) {
		boolean visited[] = new boolean[size];
		Queue<Integer> queue = new LinkedList();
		
		visited[s] = true;
		queue.add(s);
		
		while(!queue.isEmpty()) {
			s = queue.poll();
			System.out.print(s+ " ");
			
			Iterator<Integer> i = adj[s].listIterator();
			while(i.hasNext()) {
				int n = i.next();
				
				if(!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
			
		}
		
		
	}
	
	public static void main(String[] args) {
		BFS g = new BFS(4);
		g.addEdge(0, 1 );
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 3);
		
		g.addEdge(0, 1);
	    g.addEdge(0, 2);
	    g.addEdge(1, 2);
	    g.addEdge(2, 0);
	    g.addEdge(2, 3);
	    g.addEdge(3, 3);
		
		g.traverse(3);
		
	}
		
}


