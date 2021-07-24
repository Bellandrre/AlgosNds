import java.util.Scanner;


public class MaxNegSubArray {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	int n =sc.nextInt();
	
	int a[]=new int[n];
	
	for(int i=0;i<a.length;i++){
		a[i]=sc.nextInt();
	}
	
	subArray(a);
	
}

private static void subArray(int[] a) {
	int calSum=0,maxSum=0;
	
	for(int i=0;i<a.length-1;i++){
		calSum+=a[i];
		if(maxSum<calSum){
			maxSum=calSum;
		}
		else
			calSum=0;
	}
	System.out.println(maxSum);
	
	
}
}
