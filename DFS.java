	import java.util.*;
public class DFS {
	
	int size;
	LinkedList<Integer> adj[];
	
	@SuppressWarnings("unchecked")
	public DFS(int size) {
		this.size = size;
		adj = new LinkedList[size];
		for(int i = 0; i<size ; i++) {
			adj[i] = new LinkedList<>();
		}
	}
	
	
	void addEdge(int v, int w) {
		adj[v].add(w);
	}
	
	
	void dfs(int s) {
		boolean visited [] = new boolean[size];
		dfsmain(s,visited);
	}
	
	
	void dfsmain(int s, boolean visited[]) {
		//boolean visited[] = new boolean[size];
		
		visited[s] = true;
		System.out.print(s+" ");
		
		Iterator<Integer> i = adj[s].listIterator();
		while(i.hasNext()) {
			int n = i.next();
			if(!visited[n]) {
				dfsmain(n,visited);
			}
		}
		
	}
	
	public static void main(String[] args) {
		DFS g = new DFS(4);
		g.addEdge(0, 1);
	    g.addEdge(0, 2);
	    g.addEdge(1, 2);
	    g.addEdge(2, 0);
	    g.addEdge(2, 3);
	    g.addEdge(3, 3);
		
		g.dfs(2);
	}
	

}
