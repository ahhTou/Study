package sort;

/**
 * 插入排序
 */
public class InsertionSort {

    public void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {

            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                }
            }

        }
    }

}
