//import java.io.*;
import java.util.Scanner;
public class maxSubArrayKadane {
	
	private int maxSubArray(int arr[]){
		
	int max=0,a1 = 0,a2=0,sum1=0;
	
	
	for(int i=0;i<arr.length;i++){
		sum1=arr[i]; //1
		if(max<sum1){
			max=sum1; //1
		
		}
		for(int j=i+1;j<arr.length;j++){
			sum1+=arr[j];				
			if(max<sum1){
				max=sum1; //1
				a1=i;a2=j;
				
			}
			
			
	}
	}
	
	System.out.println("The Maximum element is: "+max+" found at index: "+a1 +" , "+a2);
	
	return 0;
	}

	public static void main(String args[]) {
		// TODO Auto-generated method stub
		
		int size;
		System.out.println("Enter the size of the array");
		Scanner sc=new Scanner(System.in);
		size=sc.nextInt();
		System.out.println("Enter the elements of the array");
		int[] arr = new int[size];
		for(int i=0;i<size;i++){
			arr[i]=sc.nextInt();
		}
				
		maxSubArrayKadane ob=new maxSubArrayKadane();
		ob.maxSubArray(arr);
		
		sc.close();
		
	}
	
	
}
