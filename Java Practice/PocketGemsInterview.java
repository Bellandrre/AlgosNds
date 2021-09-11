import java.util.*;
import java.util.Map.Entry;
public class PocketGemsInterview {
public static void main(String[] args) {
	String names[] = {"Louis IX", "Louis VIII"};
	getSortedList(names);

}

static ArrayList<String> getSortedList(String[] names) {
	
	ArrayList<String> sorted = new ArrayList<>();
	Map<String, Integer> map = new TreeMap<>();
	
	for(int i=0;i<names.length;i++) {
		String[] FirstLastName = names[i].split(" ");
		//System.out.println(FirstLastName[0]+" "+FirstLastName[1]);
		map.put(FirstLastName[0]+" "+FirstLastName[1],getValue(FirstLastName[1]));
		}
		
	map=sortMap(map);
	for(Map.Entry<String, Integer> entry: map.entrySet()) {
		sorted.add(entry.getKey());
	}
	for(String a:sorted) {
		System.out.println(a);
	}
	return sorted;
}



	private static Map<String,Integer> sortMap(Map<String, Integer> map) {
		List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(map.entrySet());
        Collections.sort( list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o1.getValue()).compareTo( o2.getValue() );
            }
        });

        Map<String, Integer> result = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;

	
}

	static int getValue(String a) {
		int sum=0;
	if(a.contains("IX")) {
		sum = 9;
		char[] r = a.toCharArray();	
		int i =0;
		while(true) {
			if(r[i] == 'X') {sum += 10;}
			if(r[i]=='I')break;
			i++;
		}
		return sum;
	}	
	char[] r = a.toCharArray();	
	for(int i=0;i<r.length;i++) {
		if(r[i]=='I') {
			sum += 1;
		}
		if(r[i]=='V') {
			sum += 5;
		}
		
		if(r[i]=='X') {
			sum += 10;
		}
	}
	
	return sum; 
	
	}

}

	
