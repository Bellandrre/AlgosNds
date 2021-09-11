
public class NonDecreasingArr {
	public static void main(String[] args) {
		int arr[] = {1,2,3,0,2,3,4};
		NonDecreasingArr p = new NonDecreasingArr();
		System.out.println(check(arr));
		
	}
	
	
	public  int [] mergeSort(int arr[]) {
		sort(arr,0,arr.length-1);
		return arr;
	}
	
	public void sort(int arr[],int p,int r) {
		if(p<r) {
			int q = (p+r)/2;
			sort(arr,p,q);
			sort(arr,q+1,r);
			mergesort(arr,p,q,r);
		}
	}
	
	public void mergesort(int arr[],int p,int q,int r) {
		int n1 = q - p + 1;
		int n2 = r - q;
		int left [] = new int[n1+1];
		int right [] = new int[n2+1];
		
		for(int i = 0 ;i<n1; i++) {
			left[i] = arr[p+i];
		}
		
		for(int j = 0;j<n2 ;j++) {
			right[j] = arr[q+1+j];
		}
		
		left[n1] = Integer.MAX_VALUE;
		right[n2] = Integer.MAX_VALUE;
		
		int i = 0;
		int j = 0;
		
		for(int k=p;k<=r;k++) {
			if(left[i]<=right[j]) {
				arr[k] = left[i];
				i += 1;
			}
			else {
				arr[k] = right[j];
				j += 1;
			}
			
		}
	}
	
	
	
	public static boolean check(int nums[]) {

		for(int i=1;i<nums.length;i++) {
			
			if(nums[i-1]>nums[i]) {
				
				nums[i-1] = nums[i];
				for(int j = 0;j<nums.length-1;j++) {
					if(nums[j]>nums[j+1]) return false;
				}
				
			}
			
		}
			return true;
		
	}
	
	

}
