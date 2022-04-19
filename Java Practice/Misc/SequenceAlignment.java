
public class SequenceAlignment {
	
	public static void main(String[] args) {
		
		String a = "TTCATA";
		String b = "TGCTCGTA";
		int aL = a.length();
		int bL = b.length();
		sequence(a,b);
	}

	private static void sequence( String a, String b) {
		int gap =6, mis = 2, match = -5;
		int opt[][] = new int[a.length()+1][b.length()+1];
		
		for(int i =1 ; i <a.length();i++ )
			opt[i][0] = gap + opt[i-1][0];
		
		for(int j=1; j<b.length();j++)
			opt[0][j] = gap + opt[0][j-1];
		
		for(int i = 1; i<=a.length();i++ ) {
			for(int j=1;j<=b.length();j++) {
				int diag = opt[i-1][j-1] + (a.charAt(i-1) == b.charAt(j-1)? match:mis);
				int left = opt[i][j-1] +gap;
				int top = opt[i-1][j] +gap;
				opt[i][j] =  Math.min(Math.min(diag,left),top);
			}
		}
		
		
	
		for (int i = 0; i <= a.length(); i++) {
		    for (int j = 0; j <= b.length(); j++) 
		        System.out.print(opt[i][j] + "\t");
		    
		    System.out.println();
		}
		
		
	}
	

}
