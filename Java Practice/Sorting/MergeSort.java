package Sorting;
public class MergeSort {

    static int inversionCount = 0;
    public void merge(int arr[], int leftIndex, int middleIndex, int rightIndex){

        int leftTempArraySize  = middleIndex - leftIndex + 1;
        int rightTempArraySize = rightIndex - middleIndex;

        int[] leftTempArray  = new int[leftTempArraySize];
        int[] rightTempArray = new int[rightTempArraySize];


        for(int i = 0; i < leftTempArraySize; i++){
            leftTempArray[i] = arr[leftIndex + i];
        }

        for(int j = 0 ; j < rightTempArraySize; j++){
            rightTempArray[j] = arr[middleIndex + 1 + j];
        }

        int left = 0, right = 0;
        int k = leftIndex;

        while(left < leftTempArraySize && right < rightTempArraySize){
            if(leftTempArray[left] <= rightTempArray[right]){
                arr[k++] = leftTempArray[left++];
            }else{
                arr[k++] = rightTempArray[right++];
            }
        }

        while(left < leftTempArraySize){
            arr[k++] = leftTempArray[left++];
        }

        while(right < rightTempArraySize){
            arr[k++] = rightTempArray[right++];
        }
    }

    public void sort(int arr[], int left, int right){
        if(left < right){
            int mid = (left + right)/2;

            sort(arr, left, mid);
            sort(arr,mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void main(String[] args) {
        int arr[] = {2, 3, 3, 1, 9, 5, 6};
        new MergeSort().sort(arr, 0, arr.length - 1);
        System.out.println(inversionCount);
        for(Integer i : arr){
            System.out.print(i+" ");
        }
    }
}
