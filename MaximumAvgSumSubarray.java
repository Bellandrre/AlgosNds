import java.util.*;
public class MaximumAvgSumSubarray {
	Queue<Integer> tempStack = new LinkedList<>();
	double max_avg;
	double sum;
	double avg;
	public static void main(String[] args) {
		int arr[] = {1,1000,3,1,4,2,2,99,17};
			
		new MaximumAvgSumSubarray().checkAvg(arr,3);
		
	}
	
	public void checkAvg(int arr[],int k) {
		
		
		for(int i =0;i<arr.length;i++) {
			if(tempStack.size()<=k) tempStack.add(arr[i]);
			if(tempStack.size()==k) calSum(k); 
		
		}
		
		System.out.println(max_avg);
	}
	
	
	public void calSum(int k) {
		Iterator<Integer> iter = tempStack.iterator();
		
		while(iter.hasNext()) {
			sum += iter.next();
		}
		
		avg = sum/3;
		
		if(max_avg<avg) {
			max_avg = avg;
		}
		
		sum = 0;
		tempStack.remove();
		
	}
}
