

public class MinimumSum{
public static void main(String[] args) {
	int a[] = {2,2,2,3,3};
	int result =minSum(a);
	System.out.println(result);
}	
	public static int minSum(int a[]) {
		int sum = 0;
		for(int i :a) {
			sum+=i;
		}
		int partition [][] = new int[sum/2+1][a.length];
		for(int i=0;i<sum/2+1;i++) {
			partition[i][0]=0;
		}
		for(int j=1;j<a.length;j++) {
			partition[0][j]=1;
		}
		
		
		for(int i = 0;i<sum/2+1;i++) {
			for(int j=0;j<a.length;j++) {
				partition[i][j] = partition[i][j-1];
				if(i>=a[j-1]) {
					partition[i][j] = partition[i-a[j-1]][j-1];
				}
			}
			
		}
		
		return partition[sum/2][a.length];
	}
}