import java.util.*;
public class LongestSubstring {
	public static void main(String[] args) {
		String given = "tmmzuxt";
		subSq(given);
	}
	
	public static int subSq(String given) {
	Map<Character,Integer> map = new HashMap<>();
//	int count =0;
	int max =0;
	char gvn[] = given.toCharArray();
	for(int i=0, j=0;i<given.length();++i) {
		
		if(map.containsKey(gvn[i])) {
			j = Math.max(map.get(gvn[i])+1, j);
			
		}
		
		
		
			
			map.put(gvn[i], i);
			max = Math.max(max, i-j+1);
			//map.clear();
	
		
		
	}
	
	
	
	
	System.out.println(max);
	return max;
		
	}

}
