package ArraysAndString;
import java.util.*;
public class MinimumDominoRotations {

    public static int minDominoRotations(int[] tops, int[] bottoms){
        if(tops.length != bottoms.length){
            return -1;
        }

        // 2, 1, 2, 4, 2, 2
        // ^
        // 5, 2, 6, 2, 3, 2
        // ^
        //tm = 2
        //bm = 5
        //tmc = 1
        //bmc = 1
        HashMap<Integer, Integer> countMap = new HashMap<>();
        int topMajority = tops[0];
        int bottomMajority = bottoms[0];

        int topMajorityCount = 1;
        int bottomMajorityCount = 1;

        for(Integer i : tops){
            if(countMap.containsKey(i)){
                countMap.put(i, countMap.get(i) + 1);

                if(topMajorityCount < countMap.get(i)){
                    topMajorityCount = countMap.get(i);
                    topMajority = i;
                }
            }else{
                countMap.put(i, 1);
            }
        }

        countMap = new HashMap<>();

        for(Integer i : bottoms){
            if(countMap.containsKey(i)){
                countMap.put(i, countMap.get(i) + 1);

                if(bottomMajorityCount < countMap.get(i)){
                    bottomMajorityCount = countMap.get(i);
                    bottomMajority = i;
                }
            }else{
                countMap.put(i, 1);
            }
        }

        if(topMajorityCount == 1 && bottomMajorityCount == 1){
            return -1;
        }else{
            int topInversions = 0;
            int bottomInversions = 0;

            for(int i = 0; i < tops.length; i++){
                int currTop = tops[i];
                if(currTop != topMajority && bottoms[i] == topMajority){
                    topInversions++;
                }
            }

            for(int i = 0; i < bottoms.length; i++){
                int currBottom = bottoms[i];
                if(currBottom != bottomMajority && tops[i] == bottomMajority){
                    bottomInversions++;
                }
            }

            if(tops.length != (topMajorityCount + topInversions)){
                return -1;
            }

            if(bottoms.length != (bottomMajorityCount + bottomInversions)){
                return -1;
            }

            return Math.min(topInversions, bottomInversions);
        }
    }

    public static void main(String[] args) {
        int tops[] =    {2,1,2,4,2,2};
        int bottoms[] = {5,2,6,2,3,2};

        System.out.println(minDominoRotations(tops, bottoms));
    }
}
