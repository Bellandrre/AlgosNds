import java.util.*;
public class SortedMerge {
	static int a[] = new int[10];
	static int b[] = new int[5];
	
	public static void main(String[] args) {
		for(int i=0;i<5;i++) {
			a[i] = i;
		}
		for(int i=0,j=5;i<5;i++,j++) {
			b[i] = j;
			
		}
		
		sortMerge(a,b);
	}
	// Sorted combined array. It uses 2n more space and time is O(n).
	public static Integer[] sortMerge(int a[], int b[]) {
		TreeSet<Integer> map =new TreeSet<>();
		for(int i=0;i<a.length;i++) {
			map.add(a[i]);
		}
		
		for(int i=0;i<b.length;i++) {
			map.add(b[i]);
		}
		
		Integer[] c = map.toArray(new Integer[map.size()]);
		return c;
	}
	
	
	
}
