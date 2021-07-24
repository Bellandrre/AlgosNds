import java.util.*;
public class AverageSum {
	public static void main(String[] args) {
		int nums[] = {1,12,-5,-6,50,3};
		System.out.println(findMaxAverage(nums,4));
	}
	public static double findMaxAverage(int[] nums, int k) {
		if(k>nums.length) return 0;
		if(k==nums.length) {
			double sum=0;
			for(int i=0;i<nums.length;i++) {
				sum += (double) nums[i];
			}
			return sum/k;
					}
		else {
       double max =0;
       double max_until_now ;
     
       for(int i=0;i<k;i++) {
    	   max += (double)nums[i];
       }
       //4 4-4=0
       max_until_now = max;
       for(int i=k;i<nums.length;i++) {
    	   max_until_now += nums[i] - nums[i-k];
    	   max = Math.max(max, max_until_now);
    	  
    	  
       }
       
       return max/k;
}}
	
}
