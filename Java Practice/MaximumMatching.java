import java.util.Arrays;

public class MaximumMatching {
	public static int m =6;
	public static int n =6;
	
	boolean matching (boolean bpr[][], int u, boolean seen [], int matchR[]) {
		for(int v = 0; v<n; v++) {
			
			if(bpr[u][v] && !seen [v]) {
				seen[v] = true;
				
				if(matchR[v] < 0 || matching(bpr,matchR[v], seen, matchR)) {
					matchR[v] = u;
					return true;
				}
			}
			
		}
		return false;
	}
	
	
	int maxMatching (boolean bpr[][]) {
		
		int matchR[] = new int[n];
		int result =0;
		Arrays.fill(matchR, -1);
		
		for(int u =0 ; u<m ; u++) {
			boolean seen[] = new boolean[n];
			Arrays.fill(seen, false);
			
			if(matching(bpr,u,seen,matchR)) {
				result++;
			}
				}
		for(int i =0 ;i< matchR.length;i++) {
			System.out.println(matchR[i]);
	}
		return result;
		
			
	

}
	
	public static void main(String[] args) {
		boolean bpGraph[][] = new boolean[][]{
            {false, true, true, false, false, false},
            {true, false, false, true, false, false},
            {false, false, true, false, false, false},
            {false, false, true, true, false, false},
            {false, false, false, false, false, false},
            {false, false, false, false, false, true}
        };
        MaximumMatching m = new MaximumMatching();
        System.out.println( "Maximum number of applicants that can"+
                            " get job is "+m.maxMatching(bpGraph));
	}
}