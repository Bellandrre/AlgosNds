import java.util.Arrays;

public class StringIsunique {

	
	public static boolean isUnique(String check) {
		
		if(check.length() > 128) {
			return false;
		}
		
		else {
			
			boolean visited[] = new boolean[128];
			for(int i = 0 ; i< check.length(); i++) {
				int c = check.charAt(i);
				
				if(visited[c]) {
					return false;
				}
				
				visited[c] = true;
			}
			
			
		}
		
		
		return true;
	}
	
	public static void main(String[] args) {
		String check = "abcd";
		
		System.out.println(isUnique(check));
		
		
	}
}
