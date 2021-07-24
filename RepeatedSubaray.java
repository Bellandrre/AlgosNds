
public class RepeatedSubaray {
	public static void main(String[] args) {
		int a[] = {1,2,3,2,1};
		int b[] = {3,2,1,4,7};
		System.out.println(maxLength(a,b));
	}
	
	public static int maxLength(int a[],int b[]) {
		if (a.length == 0 || b.length == 0) return 0;
		int al= a.length;
		int bl = b.length;
		int dp[][] = new int[al+1][bl+1];
		int max =0;
			
		for(int i=1;i<=al;i++) {
			for(int j=1;j<=bl;j++) {
				if(a[i-1]==b[j-1]) {
					dp[i][j] = dp[i-1][j-1]+1;
					max = Math.max(max, dp[i][j]);
				}
				
				
			}
		}
		
		
		
		return max;
	}
}
