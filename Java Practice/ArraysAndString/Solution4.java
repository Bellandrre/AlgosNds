package ArraysAndString;
import java.util.*;
public class Solution4 {
	public static void main(String[] args) {
		String input = "bnb";
		System.out.println(checkIfPalindrome(input));
	}
	
	
	//There should be only one character in the string with a odd count
	public static boolean checkIfPalindrome(String input) {
		input = input.toLowerCase();
		int countOdd = 0;
		HashMap<Character,Integer> frequency = new HashMap<>();
		
		for(int i =0;i<input.length();i++) {
			char val = input.charAt(i);
			if(val==' ')continue;
			if(frequency.containsKey(val))frequency.put(val, frequency.get(val)+1);
			else frequency.put(val, 1);
		}
		
		
		for(Map.Entry<Character, Integer> entry: frequency.entrySet()) {
			if(entry.getValue()%2!=0) countOdd++;
		}
		
		
		return countOdd<=1;
	}
}
