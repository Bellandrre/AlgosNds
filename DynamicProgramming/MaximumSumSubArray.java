package DynamicProgramming;

public class MaximumSumSubArray {
	public static void main(String[] args) {
		int array[] = {-2};
		findMaxSum(array);
		findMaxSumCummulativeFrequency(array);
		findMaxSumDp(array);
		kadanes(array);
	}
	
	public static int findMaxSum(int array[]) {
		if(array.length==0) {
			return 0;
		}
		
		if(array.length==1) {
			return array[0];
		}
		int max = 0;
		int sum = 0;
		for(int i=0;i<array.length;i++) {
			for(int j=i;j<array.length;j++) {
				sum =0;
				for(int k=i; k<=j;k++) {
					sum += array[k];
					max =Math.max(sum, max);
				}
			}
		}
		System.out.println(max);
		return sum;
	}
	
	public static int findMaxSumCummulativeFrequency(int array[]) {
		if(array.length==0) {
			return 0;
		}
		
		if(array.length==1) {
			return array[0];
		}
		int sum =0;
		int cuSum[] = new int[array.length];
		for(int i=0;i<array.length;i++) {
			sum += array[i];
			cuSum[i] = sum;
		}
		
		int max = cuSum[0];
		for(int i=0;i<array.length;i++) {
			for(int j=i;j<array.length;j++) {
				if(i==0) {
					max = Math.max(cuSum[j], max);
				}
				else
				max = Math.max(cuSum[j]-cuSum[i-1], max);
				//System.out.println(cuSum[j]-cuSum[i-1]+" "+max);
			}
		}
		System.out.println(max);
		return max;
	}
	
	public static int findMaxSumDp(int array[]) {
		if(array.length==0) {
			return 0;
		}
		if(array.length==1) {
			return array[0];
		}
		int dp[] = new int[array.length];
		dp[0] = array[0];
		int max = Integer.MIN_VALUE;
		int sum = array[0];
		for(int i=1;i<array.length;i++) {
			sum = Math.max(array[i], array[i]+sum);  // {-2,12,3,12,123,324,123,54}; dp[0] = -2 sum = -2, (12,10) 12,
			max = Math.max(sum,max);
		}
		System.out.println(max);
		return dp[array.length-1];
	}
	
	public static int kadanes(int array[]) {
		int max_so_far=0;
		int curr_sum = 0;
		for(int i=0;i<array.length;i++) {
			if(curr_sum<0) {
				curr_sum = 0;
			}
			curr_sum += array[i];
			if(max_so_far < curr_sum) {
				max_so_far = curr_sum;
			}
		}
		System.out.println(max_so_far);
		return max_so_far;
	}

}
