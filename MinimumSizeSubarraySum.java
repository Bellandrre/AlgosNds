import java.util.Arrays;

public class MinimumSizeSubarraySum {
	//Sum should be greater than equal to s
	
	public static void main(String[] args) {
		int nums[] = {1,1,1,1,1,1,1,1,6};
		//System.out.println(nums.length);
		int sum = 11;
		
		System.out.println(minSize(nums,sum));
		System.out.println(minSizeEfficient(nums,sum));
	}
	
	public static int minSize(int nums[],int sum) {
		if(nums.length==1 && nums[0]>=sum) return 1;
		for(int i=0;i<nums.length;i++) {
			if(nums[i]>=sum) return 1;
		}
		int max_sum = Integer.MIN_VALUE;
		int min_size = Integer.MAX_VALUE;
		int size ;
		int sums = 0;
		for(int i=0;i<nums.length-1;i++) {
			sums = nums[i];
			for(int j=i+1;j<nums.length;j++) {
				
				sums +=nums[j];
			
				size = j-i+1;
				//System.out.println(j);
				if(sums>=sum && size<min_size) {
					max_sum = sums;
					min_size = size;
				}
			}
		}
	
		
		if(min_size==Integer.MAX_VALUE) return 0;
		return  min_size;
	}
	
	public static int minSizeEfficient(int nums[],int sums) {
		int sum = 0;
        int n = nums.length;
        int res = Integer.MAX_VALUE;
        int l = 0;
        boolean flag =false;
        for(int r = 0; r < n; r++){
            sum += nums[r];
            while (sum >= sums){
            	//System.out.println(sum);
            	//System.out.println(r);
                res = Math.min(res, r-l+1);
              // System.out.println(res);
                sum -= nums[l++];
                
                flag =true;
            }
            if(flag) break;
        }
        return res == Integer.MAX_VALUE ? 0 : res;

		
		
	}
	
}
