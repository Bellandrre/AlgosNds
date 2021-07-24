import java.util.Scanner;


public class FactorialRecu {
	 private static Scanner in;

	static int factorial(int n) {
		int result;
		if(n<=1)
		return 1;
		else
			result = factorial(n-1)*n;
		return result;
	       
	    }

	    public static void main(String[] args) {
	        in = new Scanner(System.in);
	        int n = in.nextInt();
	        int result = factorial(n);
	        System.out.println(result);
	    }
	   

}
