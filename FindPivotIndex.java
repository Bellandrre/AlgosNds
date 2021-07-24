import java.util.*;
public class FindPivotIndex {
	
	 public int pivotIndex(int[] nums) {
		 int sum = 0;
		 int sumL = 0;
		
		 for(int i = 0; i<nums.length; i++) {
			
			 sum += nums[i];
 
		 }
		 
		 for(int i=0;i<nums.length;++i) {
		 // 
			
//			 sumR = sum - sumL - nums[i];
//			 System.out.println("Right Sum" + sumR);
			 if(sumL == sum - sumL - nums[i]) {
				 return i;
			 }
			 sumL += nums[i];
			// System.out.println("Left Sum" + sumL);
			 
		 }
		 
		 
		return -1;
		 
	        
	    }
	 
	 public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num [] = new int[3];
		for(int i =0 ;i<num.length ; i++) {
			num[i] = sc.nextInt();
		}
		
		FindPivotIndex p = new FindPivotIndex();
		int result = p.pivotIndex(num);
		
		System.out.println(result);
	}

}
