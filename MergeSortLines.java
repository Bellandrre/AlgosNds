import java.util.*;

public class MergeSortLines {
   

    public static void mergeSort(String[] a) {
        if (a.length >= 2) {
            String[] left = new String[a.length / 2];
            String[] right = new String[a.length-a.length / 2];

            for (int i = 0; i < left.length; i++)
            {
                left[i] = a[i];
            }
            for (int i = 0; i < right.length; i++)
            {
                right[i] = a[i + a.length / 2];
            }

            mergeSort(left);
            mergeSort(right);

            merge(a, left, right);
        }
    }

    public static void merge(String[] result, String[] left, String[] right) {
        int i1 = 0;
        int i2 = 0;
        for (int i = 0; i < result.length; i++) {
            if (i2 >= right.length || (i1 < left.length &&
                    left[i1].compareToIgnoreCase(right[i2])<0)) {
                      result[i] = left[i1];
                      i1++;
                 } else {
                      result[i] = right[i2];
                      i2++;
                 }
            }
    }
}