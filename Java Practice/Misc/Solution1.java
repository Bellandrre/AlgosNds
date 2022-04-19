
public class Solution1 {
	
	static long maxPoints(int[] elements) {
		long result = 0;
		int sum[] = new int[100001];
		for(int i: elements) {
			//System.out.println(i+" " +"First");
			sum[i] += i; 
			System.out.println(sum[i]);
		}
		
		/*for(int i:sum) {
			if(i!=0)
			System.out.println(i);
		}*/
		
		int temp[] = new int[100003];
		
		for(int i=elements.length;i>=0;i--) {
			System.out.println("This is sum: "+sum[i]+" Temp: "+temp[i+2]+" temp" +temp[i+1]);
			temp[i] = Math.max(sum[i]+temp[i+2],temp[i+1]);
		}
		result = temp[0];
		//System.out.println(result);
		return result;
    }
	
	public static void main(String[] args) {
		int a[] = {3,3,4,2};
		maxPoints(a);
	}

}
