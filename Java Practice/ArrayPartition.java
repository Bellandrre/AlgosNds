import java.util.Arrays;
import java.util.Scanner;


public class ArrayPartition {
	
	  
    public static void mergeSort(int[] a) {
     if (a.length >= 2) {
         int[] left = new int[a.length / 2];
         int[] right = new int[a.length-a.length / 2];

         for (int i = 0; i < left.length; i++)
         {
             left[i] = a[i];
         }
         for (int i = 0; i < right.length; i++)
         {
             right[i] = a[i + a.length / 2];
         }

         mergeSort(left);
         mergeSort(right);

         merge(a, left, right);
        
        
     }
   
 }
   
     public static void merge(int[] result, int[] left, int[] right) {
	  int i1 = 0;
     int i2 = 0;
     for (int i = 0; i < result.length; i++) {
         if (i2 >= right.length || i1 < left.length && left[i1]<right[i2]) {
                   result[i] = left[i1];
                   i1++;
              } else {
                   result[i] = right[i2];
                   i2++;
              }
         
         }
    
 }
   
   
   
   
   
   
   
   public int arrayPairSum(int[] nums) {
       mergeSort(nums);
       int sum=0;
       int j=0;       
       int result[] = new int[nums.length/2];
       for(int i=0;i<nums.length-1;i=i+2){
    	   result[j] = Math.min(nums[i], nums[i+1]);
    	   j++;
       }
       
       for(int i=0;i<result.length;i++){
    	   sum +=result[i];
       }
       
       
       return sum;
			
   }
   
   
   public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);   
	int n = sc.nextInt();
	int input[] = new int[n];
	
	for(int i=0;i<input.length;i++){
		input[i]= sc.nextInt();
	}
	sc.close();
	
	ArrayPartition sol = new ArrayPartition();
	int result = sol.arrayPairSum(input);
	System.out.println(result);
	
}

}
