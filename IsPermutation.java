import java.util.Arrays;

/**
 * Considers whitespaces and case sensitive
 * @author karthik
 *
 */

public class IsPermutation {
	public static void main(String[] args) {
		String a = "dog";
		String b = "god";
		System.out.println(permutation(a,b));
		/*a = sort(a);
		b = sort(b);
		
		System.out.println(isPermutation(a,b));*/
	}
	
	private static String sort(String a) {
		char chararray[] = a.toCharArray();
		Arrays.sort(chararray);
		
		a = new String(chararray);
		return a;
	}
	
	
	private static boolean isPermutation(String a, String b) {
		if(a.length() != b.length()) {
			return false;
		}
		
		if(a.equals(b)) {
			return true;
		}
				
		return false;
		
	}
	
	private static boolean permutation(String a, String b) {
		if(a.length() != b.length()) {
			return false;
		}
		
		int[] letters = new int[128];
		letters['b']++;
		for(int i = 0; i<a.length(); i++) {
			letters[a.charAt(i)]++;
			System.out.println("charat"+a.charAt(i));
		}
		
		for(int i =0; i<letters.length;i++) {
			System.out.print(" "+letters[i]);
		}
		
		
		for(int i =0 ;i<b.length();i++) {
			letters[b.charAt(i)]--;
			if(letters[b.charAt(i)]<0) {
				return false;
			}
			
		}
		return true;
	}

}
