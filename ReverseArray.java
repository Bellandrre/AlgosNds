import java.util.Arrays;
import java.util.Scanner;


public class ReverseArray {
	public static void main(String[] args) {
	    Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i < n; i++){
            arr[i] = in.nextInt();
        }
        in.close();
        
        reverse(arr);
        for(int i=0;i<arr.length;i++){
        	System.out.print(arr[i]+ " ");
        }
    }

	private static void reverse(int[] arr) {
		
	int revarr[] = Arrays.copyOfRange(arr, 0 ,arr.length );
	
	for(int j=revarr.length-1,i=0;j>=0;j-- ){
		arr[i]=revarr[j];
		i++;
	}

}
}
