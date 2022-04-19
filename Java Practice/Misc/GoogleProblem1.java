import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class GoogleProblem1 {
	public static void main(String[] args) {
		String a = "abcd";
		String b = "cdabcdab";
		GoogleProblem1 g =new GoogleProblem1();
		System.out.println(g.solution(a,b));
	}

	public  int solution(String a, String b) {
		char a1[] = a.toCharArray();
		char b1[] = b.toCharArray();
		
		HashMap<Character, Integer> mapA = new HashMap<>(); 
		HashMap<Character, Integer> mapB = new HashMap<>(); 
		ArrayList<Character> aA1 = new ArrayList<>();
		ArrayList<Character> bB1 = new ArrayList<>();
		
		
		for(int i = 0; i< a1.length; i++) {
			Integer count = mapA.containsKey(a1[i]) ? mapA.get(a1[i]): 0;
			mapA.put(a1[i], count+1);
			
		}
	
		/*
		for(Entry<Character,Integer> entry : mapA.entrySet()) {
			System.out.println(entry);
		}*/
		
		for(int i = 0; i< b1.length; i++) {
			Integer count = mapB.containsKey(b1[i]) ? mapB.get(b1[i]): 0;
			mapB.put(b1[i], count+1);
		}
	
		/*for(Entry<Character,Integer> entry : mapB.entrySet()) {
			System.out.println(entry);
		}*/
	
		
		
		
		if(aA1.size() == bB1.size()) {
					
				aA1.addAll(mapA.keySet());
				bB1.addAll(mapB.keySet());
				
				for(int i=0;i<mapA.size();i++) {
					if(aA1.get(i) == bB1.get(i)) {
						if(a.length()>b.length()) return (int) Math.ceil(a.length()/b.length()+1);
						else return (int) Math.ceil(b.length()/a.length()+1);
								
					}
				}
			
		
		}
		
		
		
		return -1;
		
		
		
		
		
		
		
	}

}
