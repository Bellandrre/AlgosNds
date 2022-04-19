
public class RotateArray {
	public static void main(String[] args) {
		int k = 2;
		int nums[] = {-1};
		//rotate(nums,k);
		rotateSpace(nums,k);
		/*for(int n:nums) {
			System.out.println(n);
		}*/
	}
	
	public static int[] rotate(int nums[],int k) {
		for(int i=0;i<k;i++) {
			int temp = nums[nums.length-1];
			for(int j=nums.length-1;j>0;j--) {
				nums[j] = nums[j-1];
			}
			
			nums[0] = temp;
			
		}
		
		return nums;
	}
	
	public static int[] rotateSpace(int nums[],int k) {
		int temp;
		
	
		while(k>0) {
			temp = nums[nums.length-1]; 
			for(int i=nums.length-1;i>0;i--) {
			
				nums[i] = nums[i-1];
				
			}
			nums[0] = temp;
			k--;
		}
		
		
		
		
		for(int n:nums) {
			System.out.println(n);
		}
		return nums;
	}
}
