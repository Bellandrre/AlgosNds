import java.util.HashMap;
import java.util.Map.Entry;

public class CheckPalindromeandPermutation {
	public static void main(String[] args) {
		String check = "abaaa";
		
		System.out.println(isResult(check));
		
	}

	private static boolean isResult(String check) {
		
		HashMap<Character,Integer> map = new HashMap<>();
		//Integer a = 1;
		//int countEven = 0;
		int countOdd = 0;
		check = check.toLowerCase();
		for(int i = 0; i<check.length() ; i++) {
			if(check.charAt(i) != ' ') {
			
			Integer count = map.containsKey(check.charAt(i)) ? map.get(check.charAt(i)): 0;
			map.put(check.charAt(i), count+1);
			}
		
			
		}
		for(Entry<Character,Integer> entry : map.entrySet()) {
			
			Integer count = entry.getValue();
			//System.out.println(count);
			if(count%2!=0) {
				countOdd ++;
			}
			
		}
		
		
		for(Entry<Character,Integer> entry : map.entrySet()) {
			System.out.println(entry);
		}
		return 	checkPal(countOdd);
		
		
		
	}

	private static boolean checkPal( int countOdd) {
		//System.out.println(countEven+" "+ countOdd);
		if(countOdd>1) {
			return false;
		}
		
		
		return true;
		
	}
	
	
}
