package sort;

/**
 * 冒泡排序
 */
public class BubbleSort {

    public void sort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = 0; j < arr.length - 1 - i; j++) {

                if (arr[j] > arr[j + 1]) swap(arr, j, j + 1);

            }

        }

    }

    public void swap(int[] arr, int a, int b) {
        int buf = arr[a];
        arr[a] = arr[b];
        arr[b] = buf;
    }
}
