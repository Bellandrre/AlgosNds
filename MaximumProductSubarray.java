
public class MaximumProductSubarray {
	public static void main(String[] args) {
		int nums[] = {3,-1,0,1,4};
		System.out.println(maxMul(nums));
	}
	
	public static int maxMul(int nums[]) {
		if(nums.length==1) return nums[0];
			int max = Integer.MIN_VALUE;
			int product =1;
			
			for(int i=0;i<nums.length;i++) {
				max = Math.max(product *=nums[i], max);
				if(nums[i]==0) product =1;
			}
			product = 1;
			for(int i=nums.length-1;i>0;i--) {
				max = Math.max(product *=nums[i], max);
				if(nums[i]==0) product =1;
			}
	
			return max;
}
}