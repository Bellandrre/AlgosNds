package LeetcodeProblems;
import java.util.*;

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] str){

        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> resultList = new ArrayList<>();
        for(int i = 0; i < str.length; i++){
            char currWord[] = str[i].toCharArray();
            Arrays.sort(currWord);
            String sortedWord = new String(currWord);
            if(map.containsKey(sortedWord)){
                map.get(sortedWord).add(str[i]);
            }else{
                map.put(sortedWord, new ArrayList<>());
                map.get(sortedWord).add(str[i]);
            }
        }

        for(Map.Entry<String, List<String>> entry : map.entrySet()){
            resultList.add(entry.getValue());
        }

        return resultList;
    }

    public static void main(String[] args) {
        String str[] = {"a"};
        groupAnagrams(str);
    }
}
