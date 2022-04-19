import java.util.*;
public class FindDegree {
	public static void main(String[] args) {
		int input[] = {1, 2, 2, 3, 1};
		System.out.println(findshortestLength(input));
	}
	
	
	public static int findshortestLength(int input[]) {
		HashMap<Integer,Integer> map = new HashMap<>();
		HashMap<Integer,Integer[]> map2 =new HashMap<>();
		int max = 0;
		int minsize = Integer.MAX_VALUE;
		for(int i=0;i<input.length;i++) {
			map.put(input[i], map.getOrDefault(input[i],0)+1);
			max = Math.max(max, map.get(input[i]));
			if(map2.get(input[i])==null) map2.put(input[i], new Integer[2]);
			Integer[] tempRange = map2.get(input[i]);
			if(tempRange[0]==null) tempRange[0] = i;
			tempRange[1] = i;
			//map2.put(input[i],tempRange);
		}
		
		for(Map.Entry<Integer, Integer> traverse : map.entrySet()) {
			if(traverse.getValue()!= max) continue;
			Integer[] range = map2.get(traverse.getKey());
			minsize = Math.min(minsize, range[1]-range[0]+1);
		}

		return minsize;
	}

}
