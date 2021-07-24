package ArraysAndString;



// This is O(n) & O(n) solution given that the character set used is ASCII i.e. 128 
public class Solution1 {
	
	public static void main(String[] args) {
		String input = "abccde";
		System.out.println(isUniqueChars(input));
	}
	
	public static boolean isUniqueChars(String input) {
		if(input.length()>128) return false;
		
		boolean[] char_set = new boolean[128];
		for(int i=0;i<input.length();i++) {
			int val = input.charAt(i);
			if(char_set[val]) return false;
			char_set[val] = true;
		}
			return true;
		
	}
	
	
}
