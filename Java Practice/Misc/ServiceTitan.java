import java.util.*;
public class ServiceTitan {
	
	public static void main(String[] args) {
		System.out.println(canReach(1,4,5,9));
	}
	
	
	static String canReach(int x1, int y1, int x2, int y2) {
		
		boolean flag = true;
		
		for(int i=x1,j=y1;i<=x2 && j<=y2;) {
			
			
			if(flag) {
				x1= x1+y1;
				if(x1==x2 && y1==y2) return "Yes";
				flag = false;
				i++;
			}
			
			else {
			y1= y1+x1;
			if(x1==x2 && y1==y2) return "Yes";
			flag = true;
			j++;
			}
			
		}
		
		return "No";
	}
}
