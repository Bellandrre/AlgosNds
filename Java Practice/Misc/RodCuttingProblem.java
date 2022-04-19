import java.util.*;
public class RodCuttingProblem {
public static void main(String[] args) {
	ArrayList<Integer> prices = new ArrayList<Integer>();
	prices.add(0);
	prices.add(1);
	prices.add(5);
	prices.add(8);
	prices.add(9);
	prices.add(10);
	prices.add(17);
	prices.add(17);
	prices.add(20);
	prices.add(24);
	prices.add(30);
	int length = 9;
	//System.out.println(prices.get(1));
	System.out.println(calculateCost(prices,length));
	
	
}

	public static int calculateCost(ArrayList<Integer> prices, int length) {
		int r[] = new int[length+1];
		r[0] = 0;
		
		int temp ;
		int maxValue;
		for(int i=1;i<=length;++i) {
			maxValue =-1;
			for(int j=1;j<=i;++j) {
				temp = prices.get(j-1) + r[i-j];
				System.out.println(temp);
				if(maxValue<temp) {
					maxValue = temp;
				}
				
			}
			r[i] = maxValue;
		}
		
		
		return r[length];
	}
}
