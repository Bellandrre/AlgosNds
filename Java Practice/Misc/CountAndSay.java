import java.util.*;

public class CountAndSay {
	public static void main(String[] args) {
		int arr =22;
		countSay(arr);
	}
	
 
	
	public static String countSay(int nums) {
		StringBuilder str = new StringBuilder();
		Stack<Integer> count = new Stack<>();
		boolean flag = false;
		String arr = ""+nums;
		for(int i=0;i<arr.length();i++) {
			
			int value = Character.getNumericValue(arr.charAt(i));
			
			if(count.empty()) { count.push(value);continue;}
			if(count.peek()==value) { count.push(value); continue;}
			if(count.peek()!=value) {
				flag =true;
				str.append(count.size());
				str.append(count.peek());
				count.clear();
				count.push(value);
				if(i==arr.length()-1) {
					str.append(count.size());
					str.append(count.peek());
				}
			}
			
			
		
		}

		if(!flag) {
			str.append(count.size());
			str.append(count.peek());
		}
		
		System.out.println(str);
		
		return str.toString();
	}
	
}
