import java.util.HashMap;

public class ArrayThroughConcatenation {
        public boolean canFormArray(int[] arr, int[][] pieces) {
            // Put all the pieces into a map with element[0] of the piece to be key and rest of the arr[] as value.
            HashMap<Integer,int[]> pieceMap = makePiecesMap(pieces);

            //Check for the pieces in the map
            int i = 0;
            while(i < arr.length){
                if(pieceMap.get(arr[i]) == null) return false;
                else{
                    int searchArr[] = pieceMap.get(arr[i]);
                    int j = 0;
                    while(j < searchArr.length && i < arr.length){
                        if(searchArr[j] != arr[i]){
                            System.out.println("This was executed"+i+" "+j);
                            return false;
                        }
                        else{
                            i++;
                            j++;
                        }
                    }
                }
            }
            return true;
        }

        private static HashMap<Integer, int[]> makePiecesMap(int[][] pieces){
            HashMap<Integer, int[]> map = new HashMap<>();

            for(int i=0; i< pieces.length; i++){
                map.put(pieces[i][0], new int[pieces[i].length]);
                for(int j=0; j< pieces[i].length;j++){
                    map.get(pieces[i][0])[j] = pieces[i][j];
                }
            }
            return map;
        }

        public static void main(String[] args) {
            ArrayThroughConcatenation obj = new ArrayThroughConcatenation();
            System.out.println(obj.canFormArray(new int[]{15, 88}, new int[][]{{88},{15}}));

        }


}
