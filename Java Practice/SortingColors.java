import java.util.*;
public class SortingColors {
	
	public static void main(String[] args) {
		int a[] = {1,0};
		
		int result [] = sortColor(a);
		for(int b: result) {
			System.out.println(b);
		}
	}

	private static int[] sortColor(int[] nums) {
		if(nums==null||nums.length<2){
	        return nums;
	    }
	 
	    int[] countArray = new int[3];
	    for(int i=0; i<nums.length; i++){
	        countArray[nums[i]]++;
	    }
	 
	    for(int i=1; i<=2; i++){
	        countArray[i]=countArray[i-1]+countArray[i];
	    }
	 
	    int[] sorted = new int[nums.length];
	    for(int i=0;i<nums.length; i++){
	        int index = countArray[nums[i]]-1;
	        countArray[nums[i]] = countArray[nums[i]]-1;
	        sorted[index]=nums[i];
	    }
	 
	    System.arraycopy(sorted, 0, nums, 0, nums.length);
		return nums;
	}

}
