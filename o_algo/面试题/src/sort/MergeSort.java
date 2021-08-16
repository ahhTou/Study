package sort;

/**
 * 归并排序 - 递归 & 非递归
 */
public class MergeSort {

    public void sort(int[] arr, boolean useRecur) {
        if (useRecur) recurSort(arr, 0, arr.length - 1, new int[arr.length]);
        else normalSort(arr, new int[arr.length]);
    }


    public void recurSort(int[] arr, int start, int end, int[] temp) {
        if (start < end) {
            int mid = (start + end) / 2;
            recurSort(arr, start, mid, temp);
            recurSort(arr, mid + 1, end, temp);
            recurMerge(arr, start, mid, end, temp);
        }
    }


    private void recurMerge(int[] arr, int start, int mid, int end, int[] temp) {
        int i = 0, j = start, k = mid + 1;
        while (j <= mid && k <= end)
            temp[i++] = arr[j] < arr[k] ? arr[j++] : arr[k++];

        while (j <= mid) temp[i++] = arr[j++];

        while (k <= end) temp[i++] = arr[k++];

        if (i >= 0) System.arraycopy(temp, 0, arr, start, i);
    }

    public void normalSort(int[] arr, int[] buf) {
        for (int i = 1; i < arr.length; i *= 2)
            normalMerge(arr, i, buf);
    }

    private void normalMerge(int[] arr, int gap, int[] buf) {
        int len = arr.length, k = 0;
        int s1 = 0;
        int e1 = s1 + gap - 1;
        int s2 = e1 + 1;
        int e2 = s2 + gap - 1 < len ? s2 + gap - 1 : len - 1;

        while (s2 < len) {
            while (s1 <= e1 && s2 <= e2)
                buf[k++] = arr[s1] > arr[s2] ? arr[s2++] : arr[s1++];

            while (s1 <= e1) buf[k++] = arr[s1++];

            while (s2 <= e2) buf[k++] = arr[s2++];

            s1 = e2 + 1;
            e1 = s1 + gap - 1;
            s2 = e1 + 1;
            e2 = s2 + gap - 1 < len ? s2 + gap - 1 : len - 1;
        }

        if (s1 >= 0) System.arraycopy(buf, 0, arr, 0, s1);

    }


}
