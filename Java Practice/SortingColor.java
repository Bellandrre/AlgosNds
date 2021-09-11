import java.util.*;
public class SortingColor {
	public static void main(String[] args) {
		int a[] = {1,0};
		sortColor(a);
	}

	
	public static int[] sortColor(int[] a) {
		ArrayList<Integer> count = new ArrayList<>();
		
				
		for(int i=0;i<a.length;i++) {
			count.add(a[i],1);
		}
		
		/*for(int i=0;i<a.length;i++) {
			count.add(a[i],count.get(a[i])+1);
		}*/
		
		for(int i: count) {
			System.out.println(i);
		}
		
		
		
		return a;
	}
}
