/**
 * Two ways to do this. Use the Pattern class from regesx lib
 * or use DP (bottom up) to compute match(text[i:], pattern[j:])
 * @author Karthik Kolathumani
 */
import java.util.regex.*;
class Solution {

    // Simple approach I prefer
    // downsides - slow (not sure about the time complexity of this one. Need to know the matcher method computes regex)

    // public boolean isMatch(String s, String p) {
    //     Pattern patt = Pattern.compile(p);
    //     Matcher matt = patt.matcher(s);
    //     int start = -1;
    //     int end = -1;
    //     String group = "";
    //     while(matt.find()){
    //         start = matt.start();
    //         end = matt.end();
    //         group = matt.group();
    //         if(!group.equals("")) break;
    //     }
    //     return (start!=-1 && end!=-1 && group.equals(s));
    // }

    // DP Approach O(TP) where T is length of text and P is pattern 
    public boolean isMatch(String text, String pattern) {
        boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
        dp[text.length()][pattern.length()] = true;

        for (int i = text.length(); i >= 0; i--){
            for (int j = pattern.length() - 1; j >= 0; j--){
                boolean first_match = (i < text.length() &&
                                       (pattern.charAt(j) == text.charAt(i) ||
                                        pattern.charAt(j) == '.'));
                if (j + 1 < pattern.length() && pattern.charAt(j+1) == '*'){
                    dp[i][j] = dp[i][j+2] || first_match && dp[i+1][j];
                } else {
                    dp[i][j] = first_match && dp[i+1][j+1];
                }
            }
        }
        return dp[0][0];
    }
}