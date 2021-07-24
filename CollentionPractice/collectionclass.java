package CollentionPractice;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Predicate;
public class collectionclass {
	public static void main(String[] args) {
		Collection boxes = new ArrayList<>();
		Integer a[] = {1,2,3,4,5,6,78,89};
		ArrayList<Integer> age =  new ArrayList<>();
		
		age.add(12);
		age.add(22);
		 boxes.add(12);
		 boxes.add("Karthik");
		 boxes.addAll(age);
		 
		// boxes.retainAll(age);
	
	  Object e = boxes.iterator();
	  System.out.println(boxes.hashCode());
	
	 
	  System.out.println(boxes.iterator());
	  System.out.println(boxes.isEmpty());
	  
	 for(Object c:boxes) {
		 System.out.println(c);
	 }
	  
	  
	  System.out.println(boxes.size());
	  
	  Object b[] = boxes.toArray();
	
	  for(Object f: b) {
		  System.out.println(f);
	  }
	  
	  
	  
	}
	

}
