import java.awt.List;
import java.util.ArrayList;
import java.util.stream.*;

public class CheckEdits {
	static ArrayList<Integer> sumArray = new ArrayList<Integer>();
			
	public static void main(String[] args) {
		String a = "apple";
		String ab = "cdf";
		
		System.out.println("The number of edits away: " +checkedits(a,ab));
	}

	private static int checkedits(String a, String ab) {
		int result;
		int letters[] = new int[128];
		int sum = 0;
		int sum1 = 0;
		for(int i = 0; i< a.length() ; i++) {
			if(letters[a.charAt(i)] == 1) {
				letters[a.charAt(i)]++	;
			}
			else {
			letters[a.charAt(i)]++	;
			}
		}
		
		
		for(int i : letters) {
			System.out.print(i+" ");
		}
		
		for(int i: letters) {
			sum += i;
		}
		
		calculateSum(sum);
		
		for(int i = 0; i< ab.length() ; i++) {
			/*if(letters[ab.charAt(i)] < 1) {*/
			letters[ab.charAt(i)]++	;
			
		}
		
		System.out.println("\n");
		for(int i : letters) {
			System.out.print(i+" ");
		}
			
		
		for(int i: letters) {
			sum1 += i;
		}
		
	
		
		
		calculateSum(sum1);
		
		
		
			result = sumArray.get(1) - sumArray.get(0);
			return result;
	
		
	}
	
	public static ArrayList<Integer> calculateSum(int sum){
		sumArray.add(sum);
		
		for(Integer i : sumArray) {
			System.out.println(i);
		}
		return sumArray;
	}
}
