package ArraysAndString;
import java.util.*;
public class Solution5 {
	// O(n) Solution
	public static void main(String[] args) {
		String beforeEdit = "abc";
		String afterEdit = "abc";
		if(beforeEdit.length() == afterEdit.length()) System.out.println(replaceEdit(beforeEdit,afterEdit));
		else if (beforeEdit.length() +1 == afterEdit.length()) System.out.println(insertEdit(beforeEdit,afterEdit));
		else if (beforeEdit.length()  == afterEdit.length()+1) System.out.println(insertEdit(beforeEdit,afterEdit));
		else System.out.println("False");
	}

	private static boolean insertEdit(String be, String ae) {
		// TODO Auto-generated method stub
	
		for(int i =0,j=0; i<be.length() && j<ae.length(); ) {
			System.out.println(i+" "+j);
			if(be.charAt(i)!=ae.charAt(j)) {
				if(i!=j) return false;
				j++;
			}
			
			else
				i++;
				j++;
		}
		
		return true;
		
	}


	private static boolean replaceEdit(String be, String ae) {
		int countEdits =0;
		for(int i=0;i<be.length();i++) {
			if(ae.charAt(i)!=be.charAt(i)) countEdits++;
		}
		if(countEdits==0) {System.out.println("No edits"); return false;}
		else return countEdits==1;
	}
	
	
}
