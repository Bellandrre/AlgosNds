import java.util.Arrays;
import java.util.*;

public class sortAnagrams {
	static HashMap<String,Integer > map = new HashMap<>();
	static List<String> same[] = new LinkedList[2];
	static ArrayList<String> sorted = new ArrayList<>();
	static int z =0;
	public static void main(String[] args) {
		String a[] = {"ana","karthik","kihtrak","naa"};
		for(int i=0;i<2;i++) {
			same[i] = new LinkedList<>();
		}
		sort(a);
	}
	
	public static void sort(String a[]) {
		for(String b:a) {
			checkAnagram(b);
		}
		
		for(int i=0;i<same.length;i++) {
			for(int j=0;j<same[i].size();j++) {
				System.out.println(same[i].get(j));
			}
		}
		
	}
	
	public static void  checkAnagram(String b) {
		char temp[] = b.toCharArray();
		Arrays.sort(temp);
		String tempBack = new String(temp);
		if(map.containsKey(tempBack)) {
			int a =map.get(tempBack);
			same[a].add(b);
		}
		
		else {
		
			map.put(tempBack,z);
			same[z].add(b);
			z++;
		}

	}
	
}
