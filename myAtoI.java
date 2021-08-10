public class StringToInteger {


    public static int myAtoi(String str){
        int index = 0, sign = 1, total = 0;
        // Empty String 
        if(str.length() == 0) return 0;
        
        // remove whitespaces
        while(str.length() > index && str.charAt(index) == ' '){
            index++;
        }
        
        if (index == str.length()) return 0;
        
        // -ve or +ve
        if((index < str.length()) && (str.charAt(index) == '+') || (str.charAt(index) == '-')){
            sign = str.charAt(index) == '+' ? 1 : -1;
            index++; // this is done when sign is present
        }
        
        // Convert to number and check overflow before doing result*10 + number
        while(index < str.length()){
            int digit = str.charAt(index) - '0';
            
            if(digit < 0 || digit > 9) break; // the digit is not a number
            
            if(Integer.MAX_VALUE/10 < total || Integer.MAX_VALUE/10 == total && Integer.MAX_VALUE % 10 < digit){
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            
            total = total * 10 + digit;
            index++;
        }
        
        return total * sign;
    }

    public static void main(String[] args) {

    }
}