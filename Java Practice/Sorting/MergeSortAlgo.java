package Sorting;

public class MergeSortAlgo {

    public  void merge(int arr[], int low, int mid, int high){
        int leftTempArraySize  = mid - low + 1;
        int rightTempArraySize = high - mid;

        int arr_temp_left[]  = new int[mid - low + 1];
        int arr_temp_right[] = new int[high - mid];

        for(int i = 0 ; i < leftTempArraySize; i++){
            arr_temp_left[i] = arr[low + i];
        }

        for(int j = 0; j < rightTempArraySize; j++){
            arr_temp_right[j] = arr[mid + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = low;
        while(i < leftTempArraySize && j < rightTempArraySize){
            if(arr_temp_left[i] <= arr_temp_right[j]){
                arr[k++] = arr_temp_left[i++];
            }else{
                arr[k++] = arr_temp_right[j++];
            }
        }

        if(i < leftTempArraySize){
            arr[k++] = arr_temp_left[i++];
        }
        if(j < rightTempArraySize){
            arr[k++] = arr_temp_right[j++];
        }
    }

    public  void sort(int arr[], int low, int high){
        if(low < high){
            int mid = (low + high) / 2;
            sort(arr, low, mid);
            sort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    public static void main(String[] args) {
        int arr[] = {8, 5, 2, 9, 5, 6, 3};

        new MergeSort().sort(arr, 0, arr.length - 1);

        for(Integer i : arr){
            System.out.print(i + " ");
        }
    }

}
