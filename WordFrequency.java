import java.util.*;
import java.util.Map.Entry;
public class WordFrequency {
static String main = "I am the King am";

public static void main(String[] args) {
	checkFreq(main);
}

private static <K, V> Map<K, V> checkFreq(String main2) {
	TreeMap<String,Integer> map = new TreeMap<>();
	String split[] = main2.split(" ");
	for(int i=0;i<split.length;i++) {
		map.put(split[i], 0);
	}
	
	for(int i=0;i<split.length;i++) {
		map.put(split[i], map.get(split[i])+1);
	}
	
	Map<K, V> result = new LinkedHashMap<K, V>();
	
	result = (Map<K, V>) sortByValue(map);
	return result;
	
	
}


public static Map<String,Integer> sortByValue(Map<String,Integer> map) {
List<Map.Entry<String,Integer>> list = new LinkedList<Map.Entry<String,Integer>>(map.entrySet());
Collections.sort( list, new Comparator<Map.Entry<String,Integer>>() {
    public int compare(Map.Entry<String,Integer> o1, Map.Entry<String,Integer> o2) {
        return (o2.getValue()).compareTo( o1.getValue() );
    }
});

Map<String,Integer> result = new TreeMap<String,Integer>();
for (Map.Entry<String,Integer> entry : list) {
    result.put(entry.getKey(), entry.getValue());
}
return result;
}


}
