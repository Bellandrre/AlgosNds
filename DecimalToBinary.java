import java.util.Scanner;


public class DecimalToBinary {
	private static Scanner in;

	public static void main(String[] args) {
        in = new Scanner(System.in);
        int n = in.nextInt();
        tobinary(n);
        
    }

	private static void tobinary(int n) {
		String converted=Integer.toBinaryString(n);
		int count=0,max=0;
		//System.out.println(converted);
		for(int i=0;i<converted.length();i++){
			
			if(converted.charAt(i)=='1'){
				count++;
				if(max<count){
                    max=count;
                }				
			}
			else
				count=0;
			
				
		}
		System.out.println(max);
		
		
	}
	

}
