
class NonDecreasingArray {
	public static void main(String[] args) {
		int input[] = {3,4,2,3}; //4,2,3
		System.out.println(findCanbeMadeDecreasing(input));
	}
	
	public static boolean findCanbeMadeDecreasing(int input[]) {
		int countTrue = 0;
		
		for(int i=1;i<input.length && countTrue<=1;i++) {
			if(input[i-1]>=input[i]) {
				countTrue++;
				
			}
		}
		return true;
	}
	
}
