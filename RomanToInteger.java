import java.util.HashMap;
public class RomanToInteger {
    private static HashMap<String, Integer> map;

    public RomanToInteger(){
        map = new HashMap<>();
        map.put("I",1);
        map.put("V",5);
        map.put("X",10);
        map.put("L",50);
        map.put("C",100);
        map.put("D",500);
        map.put("M",1000);
    }

    public int convertRomanToInt(String s){
        int sum = 0;
        int i = 0;
        while(i < s.length()){
            String currentSymbol = s.substring(i, i+1);
            int currentValue = map.get(currentSymbol);
            int nextValue = 0;
            if(i+1 < s.length()){
                String nextSymbol = s.substring(i+1, i+2);
                nextValue = map.get(nextSymbol);
            }
            if(nextValue > currentValue){
                sum += nextValue - currentValue;
                i +=2;
            }else{
                sum += currentValue;
                i +=1;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        RomanToInteger rToI = new RomanToInteger();
        System.out.println(rToI.convertRomanToInt("IV"));
    }
}