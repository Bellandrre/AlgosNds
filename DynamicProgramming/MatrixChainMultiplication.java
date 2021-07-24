package DynamicProgramming;



public class MatrixChainMultiplication {
	// 1x2 2x1 1x4 4x1
	public static void main(String args[]) {
	int p[] = {1,2,1,4,1};
	System.out.println(calculateMinMultiplication(p));
	}
	public static int calculateMinMultiplication(int p[]) {
		int n = p.length ; // this is the total number of arrays;
		int m[][] = new int[p.length][p.length]; // this is the optimal solution
		int s[][] = new int[p.length][p.length]; // this is used for backtracking
		int q = 0;
		for(int i=1;i<m.length;i++) {
			m[1][i] =0;
		}
	
		
		for(int l = 2;l<n;l++) {
			for(int i =1; i<n-l+1;i++) {
				int j = i+l-1;
				if(j==n) {continue;}
				m[i][j] = Integer.MAX_VALUE;
				for(int k = i; k<=j-1;k++) {
				/*	if(i==0) {q = 0;}
					else*/
					q = m[i][k] + m[k+1][j] + p[i-1]*p[k]*p[j];
					//System.out.println(q +" "+m[i][j]);
					if(q<m[i][j]) {
						m[i][j] = q;
						
						s[i][j] = k;
					}
				}
			}
		}
		
			
		
		return m[1][n-1];
	}
}

