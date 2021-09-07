package sort;

import java.util.Arrays;

public class SortTest {
    public static void main(String[] args) {

        int[] arr = {43, 31, 71, 2, 68, 2, 9, 8};
        int[] arr1 = {4, 6, 8, 5, 9};
        int[] arr2 = {12, 113, 234, 923, 0, 132, 0, 198, 90};


        new RadixSort().sort(arr2);


        System.out.println(Arrays.toString(arr2));

    }
}
