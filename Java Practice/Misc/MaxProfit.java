
public class MaxProfit {
	public static void main(String[] args) {
		int nums[] = {99,1,5,3,9,4};
		System.out.println(calculateMaxProfit(nums));
		System.out.println(calculateMaxProfitEfficient(nums));
	}
	
	public static int calculateMaxProfit(int nums[]) {
		int sum;
		int max = Integer.MIN_VALUE;
		for(int i=0;i<nums.length-1;i++) {
			for(int j=i+1;j<nums.length;j++) {
				sum = nums[j] - nums[i];
				//System.out.println(sum);
				if(max<sum) max = sum;
			}
		}
		
		if(max<0) return 0;
		return max;
	}
	
	
	public static int calculateMaxProfitEfficient(int nums[]) {
		int min_value = nums[0];
		int dp[] = new int[nums.length];
		dp[0] = 0;
		
		for(int i=1;i<nums.length;i++) {
			min_value = Math.min(min_value, nums[i]);
			dp[i] = Math.max(dp[i-1], nums[i]-min_value);
		}
		
		
		return dp[nums.length-1];
	}
}
