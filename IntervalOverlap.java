import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class IntervalOverlap extends MergeSortLines {
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		int n;
		int t;
		t=sc.nextInt();
		
		for(int z=0;z<t;z++){
			n=sc.nextInt();
		Map<Integer,Integer> logbook=new HashMap<Integer, Integer>();
		
		int a[] = null,b[] = null;
		for(int i=0;i<n;i++){
			a[i]=sc.nextInt();
		}
		for(int i=0;i<n;i++){
			b[i]=sc.nextInt();
		}
		
		for(int i=0;i<n;i++){
			logbook.put(b[i],a[i]);
			
		}
		
		Map<Integer,Integer> treeMap=new TreeMap<Integer, Integer>(logbook);
		
		maxInterval(treeMap);
		
		}
	}
	private static void maxInterval(Map<Integer, Integer> treeMap) {
		
		for(Integer i:treeMap.keySet()){
			for(Integer j:treeMap.keySet()){
				
			}
		}
		
	}
	
		
	}


