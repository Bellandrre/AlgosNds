import java.util.Scanner;


public class LongestConsecutiveSubsequence {
	
	public static void main(String[] args) {
		int size;
		System.out.println("Enter the size of the array");
		Scanner sc=new Scanner(System.in);
		size=sc.nextInt();
		System.out.println("Enter the elements of the array");
		int[] arr = new int[size];
		for(int i=0;i<size;i++){
			arr[i]=sc.nextInt();
		}
		sc.close();
		LongestConsecutiveSubsequence ob=new LongestConsecutiveSubsequence();
		ob.mergeSort(arr,0,arr.length-1);
		LongestConsecutiveSubsequence.longSub(arr);
		
	}

	private void mergeSort(int[] arr, int s, int e) {
		if(s<e)
		{	int m=(s+e)/2;
		
			mergeSort(arr,s,m);
			mergeSort(arr,m+1,e);
			merge(arr,s,m,e);
		}
		
		
	
		
	}
//kson point bloomberg
	private void merge(int[] arr, int s, int m, int e) {
		//System.out.println("Value of m :" +m);
		
		int n1=m-s+1;
		int n2=e-m;
		int L[]=new int[n1];
		int R[]=new int[n2];
		
		for(int i=0;i<L.length;++i){
			L[i]=arr[s+i];
		}
		for(int j=0;j<R.length;++j){
			R[j]=arr[m+1+j];
		}
		
		int i=0;int j=0;
		int k=s;
		
		while(i<n1 && j<n2){
			if(L[i]<= R[j]){
				arr[k]=L[i];
				i++;
			}
			else
			{
				arr[k]=R[j];
				j++;
			}
			k++;
		}
		
		while(i<n1){
			arr[k]=L[i];
			i++;
			k++;
		}
		
		while(j<n2){
			arr[k]=R[j];
			j++;
			k++;
		}
		//LongestConsecutiveSubsequence ob=new LongestConsecutiveSubsequence();
	
		
		
	}



	private static int longSub(int[] arr) {
	int count=0;
	int flag=2;
	//int[] result=new int[arr.length];
	for(int i=0;i<arr.length-1;i++){
		int j=i+1;
		if(arr[j]-arr[i]==1){
			count++;
			flag=0;
		}
		
	}
	if (flag==0)
	System.out.println(count+1);
	else
		System.out.println("0");

	return count;
	}

}
