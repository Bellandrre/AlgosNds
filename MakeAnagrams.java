import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class MakeAnagrams {
	
	
	  
    
    
  
	 static int remAnagram(String str1, String str2)
	    {
	        // make hash array for both string 
	        // and calculate frequency of each
	        // character
	        int count1[] = new int[26]; 
	        int count2[] = new int[26];
	 
	        // count frequency of each charcter 
	        // in first string
	        for (int i = 0; i < str1.length() ; i++)
	            count1[str1.charAt(i) -'a']++;
	     
	        // count frequency of each charcter 
	        // in second string
	        for (int i = 0; i < str2.length() ; i++)
	            count2[str2.charAt(i) -'a']++;
	 
	        // traverse count arrays to find 
	        // number of charcters to be removed
	        int result = 0;
	        for (int i = 0; i < 26; i++)
	            result += Math.abs(count1[i] -
	                               count2[i]);
	        return result;
	    }
    
    
 
    
    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
       
       
        int res=remAnagram(a,b);
        
       System.out.println(res);
        
       
        //System.out.println(join.length()-res);
       
    
    }

	
}
