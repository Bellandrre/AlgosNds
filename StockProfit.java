public class StockProfit {
	public static void main(String[] args) {
		int a[] = { 7,4,7,7,3,92,3,1};
		System.out.println(findProfit(a));
	}
	public static int findProfit(int a[]) {
		if(a.length==0) {
			return 0;
		}
		if(a.length==1) {
			return 0;
		}
	int dp[] = new int[a.length+1];
	dp[0] = 0;
	int maxValue = a[0];
	for(int i=1;i<a.length;i++) {
		maxValue = Math.min(maxValue, a[i]);
		dp[i] = Math.max(dp[i-1], a[i]-maxValue);
	}
	
	
	return dp[a.length-1];
	}

}
