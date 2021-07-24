
public class NonDecreasingarray {
	public static void main(String[] args) {
		int arr [] = {4,2,3};
		System.out.println(check(arr));
	}
	
	
	public static boolean check(int arr[]) {
		int max_so_far = arr[0];
		boolean flag = false;
		int count = 0;
		for(int i =1 ;i<arr.length;i++) {
			if(flag) {
				if(max_so_far > arr[i])
					return false;
			}
			if(max_so_far < arr[i]) {
				max_so_far = arr[i];
			}
			
			if (arr[i-1] > arr[i]) {
				count++;
				flag = true;
			}
			
			
		}
		
		return count==1;
	}
}
