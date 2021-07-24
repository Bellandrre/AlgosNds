
public class _1bit2bit {
	   public boolean isOneBitCharacter(int[] bits) {
		   int count = 0;
		   
		   
		   
		   for(int i = 0 ; i<bits.length;i++) {
			   if(bits[i] == 1) {
				   count++;
			   }
		   }
		   
		   if(bits.length==1) {
			   return true;
		   }
		   		   		   
		   else if(bits[bits.length-2] == 0) {
			   return true;
		   }
		   
		 
		   
		   else if (bits[bits.length-2] == 1 && count%2==0) {
			   return false;
		   }
		   
		   else
			   return false;
	       
	    }
	   
	   public static void main(String[] args) {
		int bits[] = {1,1,1,0};
		
		_1bit2bit p = new _1bit2bit();
	boolean result =	p.isOneBitCharacter(bits);
		System.out.println(result);
	}

}
