
public class HouseRobbing {
	public static void main(String[] args) {
		int a[] = {1,2,5,3};
		System.out.println(maxRobbed(a));
	}
	
	public static int maxRobbed(int a[]) {
		//int maxRobbed;
		int dp[] = new int[a.length +1];
		dp[0] = a[0];
		dp[1] = Math.max(a[0], a[1]);
		
		for(int i=2; i<a.length;i++) {
			dp[i] = dp[i-1];
			dp[i] = Math.max(dp[i-1], a[i]+dp[i-2]);
		}
		//maxRobbed = 
		return dp[a.length-1];
	}
}
