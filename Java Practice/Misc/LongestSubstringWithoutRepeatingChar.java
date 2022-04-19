/**
 * @author Karthik Kolathumani
 *
 */

import java.util.HashSet;
public class LongestSubstringWithoutRepeatingChar {


    // I just use a a hashset to keep track of seen characters until now
    // Use two pointers to remove the previously seen character from set.
    // At any point - the size of the set is the lengthOfLongestNonRepeatingSubstring
    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> seen = new HashSet<>();
        int start = 0 ;
        int end = 0;
        int maxLen = 0;
        while(end < s.length()){

            if(!seen.contains(s.charAt(end))){
                seen.add(s.charAt(end));
                end++;
                maxLen = Math.max(seen.size(), maxLen);
            }else{
                seen.remove(s.charAt(start));
                start++;
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String input = " ";
        System.out.println(lengthOfLongestSubstring(input));
    }
}
