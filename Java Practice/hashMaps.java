//Complete this code or write your own from scratch
import java.util.*;
import java.util.Map.Entry;
//import java.io.*;

class hasMaps{
    public static void main(String []argh){
    	Map<String,Integer> phonebook=new HashMap<String, Integer>();
    	Set<String> keys= phonebook.keySet();
    	Set<Entry<String, Integer>> values=phonebook.entrySet();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0; i < n; i++){
            String name = in.next();
            int phone = in.nextInt();
            phonebook.put(name,phone);
        }
        while(in.hasNext()){
            String s = in.next();
            if(keys.contains(s)){
            	Integer result=phonebook.get(s);
            	System.out.println(s+"="+result);
            	
            }
            else
            	System.out.println("Not found");
        }
        in.close();
        
        
    }
}
