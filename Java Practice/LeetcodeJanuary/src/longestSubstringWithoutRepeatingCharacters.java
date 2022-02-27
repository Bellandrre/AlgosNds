import java.util.*;

/*
Input - aabbccdeffghj   - 4
      - a  - 1
      - "" 0

      Set (a,b,c,d,f,g, )     Max size = 7
      - a  b  c  d  f  g  c  d  e  f  g  h  i
                          ^
                 ^

      - aaaaaaaa - 1

 */

public class longestSubstringWithoutRepeatingCharacters {

    public static int getLongestSubstringWithoutRepeatingCharacters(String input){
        int stringLength = input.length();
        if(stringLength == 0) return 0;
        if(stringLength == 1) return 1;
        Set<Character> seen = new HashSet<>();
        int fwdPtr = 0;
        int bckPtr = 0;
        int maxSubstringLen = Integer.MIN_VALUE;
        while(fwdPtr < stringLength){
            char currChar = input.charAt(fwdPtr);

            if(!seen.contains(currChar)){
                seen.add(currChar);
                maxSubstringLen = Math.max(seen.size(), maxSubstringLen);
            }else{
                // move backPtr to the first occurrence of the current seen character
                while(bckPtr < stringLength && input.charAt(bckPtr) != currChar){
                    seen.remove(input.charAt(bckPtr));
                    bckPtr++;
                }
                seen.remove(input.charAt(bckPtr));
                bckPtr++;
                seen.add(currChar);
                maxSubstringLen = Math.max(seen.size(), maxSubstringLen);
            }
            fwdPtr++;
        }
        return maxSubstringLen;
    }

    public static void main(String[] args) {
        String inputString = "aaaaaaa";
        System.out.println(getLongestSubstringWithoutRepeatingCharacters(inputString));
    }

}

