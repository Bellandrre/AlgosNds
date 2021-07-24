package sortingAndSearching;

import java.util.Arrays;

/*
 * Array is sorted
 * Duplicates considered
 */
public class SearchRotatedArray {
	static int[] a = {2,3,4,5,6,7,8,9,1};
	
	public static void main(String[] args) {
		int s = 5;
	search(a,s);
	}
	
	public static int search(int[] a,int s) {
		int middle = (a.length-1)/2;
		if(a[middle]==s) {
			return middle;
		}
		if(a[0]>a[middle]) {
			int result =searchRight(middle+1,a.length-1,s);
			System.out.println(result);
		}
		
		if(a[a.length-1]<middle) {
			int result = searchLeft(0,middle-1,s);
			System.out.println(result);
		}
		
		if(a[0]==middle) {
			if(a[a.length-1]==middle) {
				for(int i:a) {
					if(i==s) {
						return i;
					}
				}
			}
			
			
		}
		
		
		
		return 0;
	}
	
	public static int searchRight(int start,int end, int s) {
		if(end>=start) {
		int middle = start + (end-start)/2;
		
		if(a[middle]==s) 
			return middle;
		
		if(s<a[middle]) 
			return searchRight(start,middle-1,s);
		
		
		if(s>a[middle]) 
			return searchRight(middle+1,end,s);
		
		}
		return -1;
	}
		public static int searchLeft(int start,int end, int s) {
			if(end>=start) {
			int middle = start + (end-start)/2;
			
			if(a[middle]==s) 
				return middle;
			
			if(s<a[middle]) 
				return searchRight(start,middle-1,s);
			
			
			if(s>a[middle]) 
				return searchRight(middle+1,end,s);
			
			}
			return -1;
		
		
	}
}


