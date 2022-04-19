import java.util.Arrays;

public class ClimbingStairs {
	public static void main(String[] args) {
		int n =8;
		int opt[] = new int[n+1];
		Arrays.fill(opt, -1);
		System.out.println(ways(n,opt));
		
	}
public static int ways(int n,int opt[]) {
	if(n<0) {
		return 0;
	}
	
	if(n==0) {
		return 1;
	}
	
	if(opt[n]>-1) {
		return opt[n];
	}
	
	else {
	opt[n] =  ways(n-1,opt) + ways(n-2,opt) + ways(n-3,opt)+ ways(n-4,opt);
	return opt[n];
	}
}
}
