import java.util.Scanner;


public class ChromaticNumber {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
	int n=sc.nextInt();
	int c=sc.nextInt();
	
	chrom(n,c);
	}
	private static void chrom(int n, int c) {
		int constant = 1000000007;
		int num= fact(c);
		int denom= fact(c-n);
		int result=(num/denom)%constant;
		System.out.println(result);
		
	}
	private static int fact(int num) {
		int cal;
		if(num<=1)
			return 1;
		else 
			cal= fact(num-1)*num;
		return cal;
	}

}
