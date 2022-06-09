package ArraysAndString;

public class CountInversions {

    static int inversions;
    public int countInversions(int arr[]){
        return 0;
    }
    // 3
    // [1, 2, 3, 3, 5, 6, 9]
    //

    private void merge(int arr[], int left , int middle, int right){
        int leftSize  = middle - left + 1;
        int rightSize = right - middle;

        int leftArray[]  = new int[leftSize];
        int rightArray[] = new int[rightSize];

        for(int i = 0 ; i < leftSize; i++){
            leftArray[i] = arr[left + i];
        }

        for(int i = 0; i < rightSize; i++){
            rightArray[i] = arr[middle + 1 + i];
        }

        int leftPtr, rightPtr, k;

        leftPtr = rightPtr = 0;

        k = left;

        while(leftPtr < leftSize && rightPtr < rightSize){
            if(leftArray[leftPtr] <= rightArray[rightPtr]){
                arr[k++] = leftArray[leftPtr++];
            }else{
                inversions += leftArray.length - leftPtr;
                arr[k++] = rightArray[rightPtr++];
            }
        }

        while(leftPtr < leftSize){
            arr[k++] = leftArray[leftPtr++];
        }

        while(rightPtr < rightSize){
            arr[k++] = rightArray[rightPtr++];
        }

    }

    /**
     * 1 + 2 + 1 + 1 = 5
     * {1, 2, 3, 3, 5, 6, 9}
     *  ^
     *  [1, 2, 3, 3]  [5, 6, 9]
     *
     *  [2, 3] [1, 3]       [5, 9]   [6]
     *  [2] [3] [3] [1]     [9] [5]
     *
     *  left = 0
     *  right = 6
     *  mid = 3
     *  *****
     *  left = 0
     *  right = 3
     *  mid = 1
     *
     *  left = 2
     *  right = 3
     *  mid = 2
     *
     *
     *  *******
     *
     */
    public void sort(int arr[] , int left, int right){

        if(left < right){
            int mid = (left + right) / 2;
            sort(arr, left, mid);
            sort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }


    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, -1};
        inversions = 0;
        new CountInversions().sort(arr, 0, arr.length - 1);
        for(Integer i : arr) System.out.print(i + " ");
        System.out.print("\n");
        System.out.println(inversions);
    }
}
