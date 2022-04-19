import java.util.*;
public class NumArray {
	ArrayList<Integer> sum = new ArrayList<>();
	public static void main(String[] args) {
		int []  nums = {-2,0,3,-5,2,-1};
		 NumArray obj = new NumArray(nums);
		 int param_1 = obj.sumRange(0,3);
		System.out.println(param_1);
	}
	
	public  int sumRange(int start,int end) {
		if(start==0) {
			int result =sum.get(end);
			return result;
		}
		int result = sum.get(end) - sum.get(start-1);
		
		return result;
	}
	
	public NumArray(int nums[]) {
		int temp = 0;
		
		for(int i=0;i<nums.length;i++) {
			temp += nums[i];
			sum.add(temp);
		}
		
		
		
	}

}
