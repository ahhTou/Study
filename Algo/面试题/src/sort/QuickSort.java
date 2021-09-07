package sort;

import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSort {

    public void sort(int[] arr, int start, int end) {

        if (start >= end) return;

        int i = start, j = end;

        int val = arr[start];

        while (i < j) {

            while (i < j && arr[j] >= val) j--;

            // 第一次交换，arr[i] 被 arr[j] 覆盖，但是arr[j] 刚好 是 val值
            // arr[i] 被替代后 arr[j] 这个位置就多余了
            if (i < j) arr[i++] = arr[j];

            while (i < j && arr[j] > val) i++;

            // arr[j] 这个多余的位置 被 arr[i] 覆盖
            // 到下一次循环， arr[i] 就可以 被覆盖。
            if (i < j) arr[j--] = arr[i];

        }

        arr[i] = val; // arr[i] 到最后 就是 val 值 的位置

        int mid = (start + end) / 2;
        sort(arr, start, mid);
        sort(arr, mid + 1, end);

    }

}
