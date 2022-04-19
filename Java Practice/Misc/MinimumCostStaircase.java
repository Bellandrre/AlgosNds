import java.util.*;
public class MinimumCostStaircase {
public static void main(String[] args) {
	int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
	minCostClimbingStairs(cost);
	minCostClimbingStairsBottomUp(cost);
}

private static void minCostClimbingStairsBottomUp(int[] cost) {
	int a,b,opt=0;
	a= cost[0];
	b= cost[1];
	
	for(int i=2;i<cost.length;i++) {
		opt = cost[i] + Math.min(a, b);
		a=b;
		b=opt;
	}
	System.out.println(opt);
	
	
}

public static int minCostClimbingStairs(int[] cost) {
	int opt[] = new int[cost.length];
	
	opt[0] = cost[0];
	opt[1] = cost[1];
	
	for(int i=2 ; i<cost.length;i++) {
		opt[i] = cost[i] + Math.min(opt[i-1], opt[i-2]); 
	}

	return Math.min(opt[opt.length-1], opt[opt.length-2]);
	
}


}
