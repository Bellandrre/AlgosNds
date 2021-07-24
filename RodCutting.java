import java.util.Arrays;

public class RodCutting {
	static int length = 10;
	static int prices[] = {1,5,8,9,10,17,17,20,24,30};
	
	
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) {
	int dp[] = new int[length+1];
		for(int i=0;i<dp.length;i++) {
			dp[i] = Integer.MIN_VALUE;
		}
		System.out.println(calculateMaxRevenueDPBottomUp(prices,length,dp));
	}
	
	public static int calculateMaxRevenueRecursive(int prices[],int length) {
		if(length==0) {
			return 0;
		}
		int max = Integer.MIN_VALUE;
		
		for(int i = 1; i<length;i++) {
			max = Math.max(prices[i], calculateMaxRevenueRecursive(prices,length-1));
		}
		return max;
	}
	
	public static int calculateMaxRevenueDP(int prices[],int length,int dp[]) {
		if(dp[length]>=0) {
			return dp[length];
		}
		
		if (length==0) {
			max =0;
		}
		else 
			//max = Integer.MIN_VALUE;
		for(int i=1;i<=length;i++) {
			max = Math.max(max, prices[i-1]+calculateMaxRevenueDP(prices,length-i,dp));
			
		}
		
		
		dp[length] = max;
		return max;
	}
	
	public static int calculateMaxRevenueDPBottomUp(int prices[],int length,int dp[]) {
		int max = Integer.MIN_VALUE;
		dp[0] = 0;
		
		for(int i=1;i<=length;i++) {
			max = Integer.MIN_VALUE;
			for(int j=1;j<=i;j++) {
				max = Math.max(max, prices[j-1]+dp[i-j]);
				
			}
			dp[i] = max;
		}
		
		return dp[dp.length-1];
	}
	
	
}
