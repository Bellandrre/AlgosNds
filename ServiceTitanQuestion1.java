import javafx.util.*;
import java.util.*;
public class ServiceTitanQuestion1 {
	public static void main(String[] args) {
		int x1 = 1;
		int y1 = 4;
		int x2 = 5;
		int y2 = 1;
		
		System.out.println(calculatePath(x1,y1,x2,y2));
	}
	
	public static boolean calculatePath(int x1,int y1,int x2,int y2) {
		LinkedList<Pair<Integer,Integer>> list = new LinkedList<>();
		list.addLast(new Pair<Integer, Integer>(x1,y1));
		while(!list.isEmpty()) {
			Pair <Integer,Integer> pairs = list.poll();
			Integer key = pairs.getKey();
			Integer value = pairs.getValue();
			if(key.equals(x2)&& value.equals(y2)) return true;
			int sum = key+value;
			if(sum<=x2)	list.add(new Pair<Integer, Integer>(sum,value));
			if(sum<=y2) list.add(new Pair<Integer, Integer>(key,sum));
		}
		return false;
			
		
			
		}
		
		
	}

