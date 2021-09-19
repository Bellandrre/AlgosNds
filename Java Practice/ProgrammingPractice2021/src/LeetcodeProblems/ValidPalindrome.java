package LeetcodeProblems;

public class ValidPalindrome {

    public static boolean isPalindrome(String s){
        String inputString = fixString(s);
        boolean isPalindrome = checkPalindrome(inputString);
        return isPalindrome;
    }

    public static boolean checkPalindrome(String inputString){
        int start = 0;
        int end = inputString.length()-1;
        while(start < end){
            if(inputString.charAt(start) != inputString.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }


    public static String fixString(String s){
        StringBuilder strB = new StringBuilder();
        for(int i = 0 ; i < s.length(); i++){
            boolean isValid = Character.isLetterOrDigit(s.charAt(i));
            if(isValid) strB.append(s.charAt(i));
        }
        return strB.toString().toLowerCase();
    }

    public static void main(String[] args) {
        String inputString = "";
        System.out.println(isPalindrome(inputString));
    }
}
