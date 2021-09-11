import java.util.Scanner;


public class Solution {
public static void main(String[] args) {
	int n;
	String k=null;
	Scanner sc=new Scanner(System.in);
	n=sc.nextInt();
	
	for(int i=0;i<n;i++){
		k=sc.next();
		compare(k);
	}
	
	sc.close();
			
}

private static void compare(String k) {
	int length=k.length();
	String d1 = "";
	String d2 = "";
	for(int i=0;i<length;i++){
		if(i%2==0){
		d1+=k.charAt(i);	
		}
		else
			d2+=k.charAt(i);
	
}
	System.out.println(d1+" "+d2);
}
}