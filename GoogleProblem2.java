import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class GoogleProblem2 {

	public static void main(String[] args) {
		int a[] = {1,1,1,2,2};
		int b[] = {1,2,1,3,2,4,2,5};
		
		GoogleProblem2 g =new GoogleProblem2();
		g.solution(a,b);
		
		
	}

	public void solution(int[] a, int[] b) {
		Arrays.sort(a);
		
		HashMap<Integer,Integer> mapA = new HashMap<Integer,Integer>();
		
		for(int i = 0;i<a.length;i++) {
			Integer count = mapA.containsKey(a[i]) ? mapA.get(a[i]): 0;
			mapA.put(a[i],count+1 );
		}
		
		
		for(Entry<Integer,Integer> entry : mapA.entrySet()) {
			System.out.println(entry);
		}
	
		
		Integer max = 0;
		
		Map.Entry<Integer, Integer> maxEntry = null;

		for (Map.Entry<Integer, Integer> entry : mapA.entrySet())
		{
		    if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
		    {
		        maxEntry = entry;
		    }
		}
			
			max = maxEntry.getKey();
			
			
			
	
		
		
		
	}
}
