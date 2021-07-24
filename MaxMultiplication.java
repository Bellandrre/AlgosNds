import java.util.Arrays;

public class MaxMultiplication {
	public static void main(String[] args) {
		int nums[] = {1,3,4,0,6,1,9};
	
		System.out.println(maxMul(nums));
	}

	private static int maxMul(int[] nums) {
		// TODO Auto-generated method stub
		Arrays.sort(nums);
		int n = nums.length;
		return Math.max(nums[n-1]*nums[n-2]*nums[n-3],nums[0]*nums[1]*nums[n-1]);
	}
}