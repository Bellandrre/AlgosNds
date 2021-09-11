package ArraysAndString;
import java.util.*;
public class Solution6 {
	public static void main(String[] args) {
		String input = "aakkabbbcdde";
		System.out.println(compressString(input.toLowerCase()));
	}
	
	public static String compressString(String input) {
		
		StringBuilder result = new StringBuilder();
		LinkedHashMap<Character,Integer> mapString = new LinkedHashMap<>();
		
		for(int i=0;i<input.length();i++) {
			if(!mapString.containsKey(input.charAt(i))) mapString.put(input.charAt(i),1);
			else mapString.put(input.charAt(i),mapString.get(input.charAt(i))+1);
						
		}
		
		for(Map.Entry<Character,Integer> entry: mapString.entrySet()) {
			String temp ="" + entry.getKey() + entry.getValue();
			result.append(temp);
		}
		
		if(result.length()>input.length()) return input;
		return result.toString();
	}
}
