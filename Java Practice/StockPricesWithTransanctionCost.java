
public class StockPricesWithTransanctionCost {
	public static void main(String[] args) {
		int a[] = {1, 3, 2, 8, 4, 9};
		int cost = 2;
		System.out.println(calculate(a,cost));
	}
	public static int calculate(int a[],int cost) {
		
		if(a.length==0 && a.length==1) return 0;
		
		int result = 0;
		int max = 0;
		for(int i=0;i<a.length-1;i++) {
			if(a[i+1]>=a[i]) 
				result =Math.max((a[i+1] - a[i])-cost,result);
				max += result;
			
		
		return max;
	}
		return 0;
}}