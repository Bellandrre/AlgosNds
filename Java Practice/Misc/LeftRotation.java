import java.util.Scanner;


public class LeftRotation {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
      
      lRotate(a,k);
	}

	private static void lRotate(int[] a, int k) {
		int temp;
		for(int i=0;i<k;i++){
			temp=a[0];
			for(int j=0;j<a.length-1;j++){
				a[j]=a[j+1];
				
			}
			a[a.length-1]=temp;
		}
		
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
		
	}
	

}
