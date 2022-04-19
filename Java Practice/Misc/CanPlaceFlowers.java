
public class CanPlaceFlowers {
	public static void main(String[] args) {
		int nums[] = {1,0,0,0,1};
		System.out.println(canPlace(nums,1));
	}
	
	public static boolean canPlace(int nums[], int n) {
		int i =0;
		int count = 0;
		if(nums.length==1 && nums[0]==0) {count++;return count>=n;} 
		while(i<nums.length) {
			if(nums[i]==0) {
				int next,prev;
				next = (i==nums.length-1)? 0: nums[i+1];
				prev = (i==0)? 0 : nums[i-1];
				
				if(next==0 && prev==0) {
					nums[i] = 1;
					count++;
				}
				i++;
			}
			else i++;
		}
		System.out.println(i);
		return count>=n;
	}
	
	

}
