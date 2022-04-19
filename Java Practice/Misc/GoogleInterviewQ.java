import java.util.*;

public class GoogleInterviewQ {
	public static void main(String[] args) {
		
		String a = "a";
		String b = "ab";
		System.out.println(findSubsetLength(a,b));
		
	}
	
	public static int findSubsetLength(String a, String b) {
		if(a.length()==0||b.length()==0) {
			return 0;
		}
		
		TreeMap<Character,Integer> mapA = new TreeMap<>();
		TreeMap<Character,Integer> mapB = new TreeMap<>();
		int max=0;
		for(int i=0;i<a.length();i++) {
			mapA.put(a.charAt(i), 0);
		}
		
		for(int i=0;i<a.length();i++) {
			mapA.put(a.charAt(i), mapA.get(a.charAt(i))+1);
		}
		
				
		for(int i =0;i<b.length();i++) {
			if(!mapA.containsKey(b.charAt(i))) {
				return 0;
			}
			
			mapB.put(b.charAt(i), 0);
			
		}
		
		for(int i=0;i<b.length();i++) {
			mapB.put(b.charAt(i), mapB.get(b.charAt(i))+1);
		}
		
		Set<Integer> sA = new HashSet<>(mapA.values());
		
		for(int x: sA) {
			if(max<x) {
				max =x;
			}
			
		}

		return max+1;

	}

}
