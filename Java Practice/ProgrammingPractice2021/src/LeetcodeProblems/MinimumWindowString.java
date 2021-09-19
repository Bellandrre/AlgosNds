package LeetcodeProblems;

public class MinimumWindowString {

    public static  String minWindow(String searchString, String t){

        int len1 = searchString.length();
        int len2 = t.length();

        if(len2 > len1){
            return "";
        }

        int givenString[] = new int[256];
        int toMatch[] = new int[256];

        int count = 0;
        //Storing the occurrences of pattern
        for(int i = 0 ; i < len2 ; i++)
            toMatch[t.charAt(i)]++;

        int start = 0, min_len = Integer.MAX_VALUE, start_index = -1;

        for(int j = 0 ; j < len1; j++) {
            givenString[searchString.charAt(j)]++;


            if(givenString[searchString.charAt(j)]
                    <= toMatch[searchString.charAt(j)])
                count++;

            // Try to minimize window
            if(count == len2){

                while(givenString[searchString.charAt(start)]
                        > toMatch[searchString.charAt(start)]
                     || toMatch[searchString.charAt(start)] == 0){

                    if(givenString[searchString.charAt(start)]
                            > toMatch[searchString.charAt(start)])
                        givenString[searchString.charAt(start)]--;
                    start++;
                }

                int len_window = j - start + 1;
                if(min_len > len_window){
                    min_len = len_window;
                    start_index = start;
                }
            }
        }

        if(start_index == -1){
            return "";
        }

        return searchString.substring(start_index, start_index + min_len);
    }

    public static void main(String[] args) {
        String givenString = "A";
        String t = "B";
        System.out.println(minWindow(givenString,t));
    }
}
