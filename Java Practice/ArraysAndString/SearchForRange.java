package ArraysAndString;

public class SearchForRange {

    static int minIndex = Integer.MAX_VALUE;
    static int maxIndex = Integer.MIN_VALUE;

    public static int binarySearch(int[] arr, int low, int high, int key){
        if(low <= high){
            int mid = low + (high - low) /2;
            if(arr[mid] == key){
                return mid;
            }
            if(arr[mid] > key){
               return binarySearch(arr, low, mid - 1, key);
            }else{
                return binarySearch(arr, mid + 1, high, key);
            }
        }
        return -1;
    }

    /**
     *  [0, 1, 21, 33, 45, 45, 45, 45, 45, 45, 61, 71, 73]
     *   0  1  2   3   4    5   6   7   8   9  10  11  12
     *                          ^
     *  mid = 6
     *
     */

    public static int[] searchForRange(int arr[], int target){
        if(arr.length <= 1) return new int[]{-1, -1};
        int targetKey = binarySearch(arr, 0, arr.length - 1, target);
        if(targetKey != -1){
            searchForRangerHelper(arr, 0, arr.length - 1, target);
        }else{
            return new int[]{-1, -1};
        }
        return new int[]{minIndex, maxIndex};
    }

    private static void searchForRangerHelper(int arr[], int low, int high, int target){
        if(arr.length == 0){
            return;
        }else{
            int targetKey = binarySearch(arr, low, high, target);
            if(targetKey != -1){
                minIndex = Math.min(minIndex, targetKey);
                maxIndex = Math.max(maxIndex, targetKey);
                searchForRangerHelper(arr, low, targetKey - 1, target);
                searchForRangerHelper(arr,targetKey + 1, high, target);
            }
        }
    }


    public static void main(String[] args) {
        int arr[] = {5, 7, 7, 8, 8, 10};
        int index[] = searchForRange(arr, 7);
        System.out.println(index[0] + " " + index[1]);
    }
}
