package sortingAndSearching;

public class SortedMerge {
	public static void main(String[] args) {
		int a[] = new int[11];
		int b[] = new int[6];
		
		for(int i=0; i<5;i++) {a[i]=i;}
		for(int i=0,j=45;i<b.length;i++,j++) {b[i] = j;}
		sortedMerge(a,b,a.length,b.length);
	}

	public static void sortedMerge(int a[], int b[], int aLength, int bLength) {
		int mergedLength = 5 + bLength -1;
		int alength = 5 -1;
		int blength = bLength -1;
		
		while(blength>=0) {
			if(alength>=0 && a[alength]>b[blength]) {
				a[mergedLength] = a[alength];
				alength--;
			}
			else {
				a[mergedLength] = b[blength];
				blength--;
			}
			mergedLength--;
		}
		for(int x: a) {
			System.out.println(x);
		}
	}
}
