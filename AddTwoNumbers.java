import java.util.HashSet;
import java.util.Map.Entry;
import java.util.*;

public class AddTwoNumbers {

	
	public static void main(String[] args) {
		int a[] = {-3,4,3,90,3};
		int target = 7;
		addTwo(a,target);
	}
	
	
	public static void addTwo(int a[],int target) {
		int result[] = new int[2];
		HashMap<Integer,Integer> map = new HashMap<>();
		
		for(int i=0;i<a.length;i++) {
			map.put(a[i], i);
			int required = (a[i] - target)*-1;
			if(map.containsKey(required)) {
				
				result[0] = map.get(required);
				result[1] = i;
				
				
			}
		
			
		}
		
		
	
		
		
		System.out.println(result[0]);
		System.out.println(result[1]);
		//return result;
		
		
		
		
	}
	
}
