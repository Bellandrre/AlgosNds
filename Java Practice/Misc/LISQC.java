
public class LISQC {
	public static void main(String[] args) {
		int input[] = {1};
		System.out.println(findIncSeq(input));
	}
	
	public static int findIncSeq(int input[]) {
		if(input.length==1) {
			return 1;
		}
		int max = 0;
		int count = 1;
		
		for(int i=1;i<input.length;i++) {
			if(input[i-1]<input[i]) {
				 count++;
				}
			else count=0;
			if(max<count) max = count;
		}
		return max;
	}
}
