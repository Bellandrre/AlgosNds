package ArraysAndString;

import java.util.Arrays;

public class Solution2 {
	public static void main(String[] args) {
		String a = "Acb";
		String b = "acb";
		System.out.println(checkPerm(a,b));
		System.out.println(checkPerm2(a,b));
	}
	
	
	//Nothing special here, sort and compare
	public static boolean checkPerm(String a, String b) {
		if(a.length()!=b.length()) return false;
		
		char aChar[] = a.toCharArray();	
		char bChar[] = b.toCharArray();
		Arrays.sort(aChar);
		Arrays.sort(bChar);
		//System.out.println(new String(aChar));
		if((new String(aChar)).equals(new String(bChar))) return true;
		return false;
		
	}
	
	
	//Solution 2 here using an array to keep track of the frequency of the letters
	public static boolean checkPerm2(String a, String b) {
		if(a.length()!=b.length()) return false;
		int[] charArray = new int[128];
		for(int i=0;i<a.length();i++) charArray[a.charAt(i)]++;
		for(int j=0;j<b.length();j++) {
			charArray[b.charAt(j)]--;
			if(charArray[b.charAt(j)]<0) return false;
		}
		return true;
	}

}
