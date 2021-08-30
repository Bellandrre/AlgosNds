/**
 * Leetcode problem number 12
 * @author Karthik Kolathumani
 */
public class IntegerToRoman {

    private static int[] values = {1000 ,900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRoman(int num){ // Left to right traversal
        StringBuilder strB = new StringBuilder();
        for(int i = 0; i < values.length && num > 0; i++){
            while(num >= values[i]){ // The '=' sign here takes care of repeating characters cases for eg 2 = II etc.
                num -= values[i];
                strB.append(values[i]);
            }
        }
        return strB.toString();
    }

    public static void main(String[] args) {
        System.out.println(new IntegerToRoman().intToRoman(1992));
    }
}