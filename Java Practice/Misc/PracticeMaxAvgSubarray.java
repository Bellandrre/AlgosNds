
public class PracticeMaxAvgSubarray {
	public static void main(String[] args) {
		int nums[] = {-1,12,-5,-6,50,3};
		System.out.println(bta(nums,3));
	}
	public static int bta(int nums[],int k) {
		int curr_max = nums[0];
		int max_so_far = nums[0];
		
		for(int i=0;i<nums.length;i++) {
			curr_max = Math.max(nums[i], curr_max+nums[i]);
			max_so_far = Math.max(curr_max,max_so_far);
		}
		return max_so_far/k;
	}
}
