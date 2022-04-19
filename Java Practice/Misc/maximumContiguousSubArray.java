
public class maximumContiguousSubArray {
	public static void main(String[] args) {
		int a[] = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray(a));
		System.out.println(maxSubArrayDp(a));
	}
	public static int maxSubArray(int a[]) {
		int currSum = 0;
		int maxSofar=0;
		for(int i=0;i<a.length;i++) {
			currSum += a[i];
			if(maxSofar < currSum) {
				maxSofar = currSum;
			}
			if (currSum<0) {
				currSum =0;
			}
		}
		return maxSofar;
	}
	
	public static int maxSubArrayDp(int a[]) {
		int dp[] = new int[a.length+1];
		dp[0] = a[0];
		int curr_max = a[0];
	    for (int i = 1; i < a.length; i++)
	    { 
	       curr_max = Math.max(a[i]+curr_max, a[i]); 
	       dp[i] = Math.max(curr_max, dp[i-1]);

	    }
	   
	   
		return dp[dp.length-2] ;
	}

}
