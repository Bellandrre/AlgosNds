import java.util.*;
public class ReverseInteger {
	public static void main(String[] args) {
		int a = 1534236469;
		reverse(a);
	}
	public static int reverse(int a) {
		
    	ArrayList<Integer> rev = new ArrayList<>();
		StringBuilder reversed = new StringBuilder();
		int revsd;
		boolean flag = false;
		if(a<0) {
			flag = true;
			a = Math.abs(a);
		}
		
		if(a==0) {
			rev.add(0);
		}
		while(a>0) {
			
			
			rev.add(a%10);
			a /=10;
		}
		
		
		
		for(int i=0;i<rev.size();i++) {
			reversed.append(rev.get(i));
			}
		try {
			 revsd = Integer.parseInt(reversed.toString());
		}
		catch(Exception e) {
			return 0;
		}
		
		if(flag) {
			revsd *= -1;
		}
	
		return revsd;
		
	}

}
