package sort;

/**
 * 选择排序
 */
public class SelectionSort {

    public void sort(int[] arr) {
        int index, temp;

        for (int i = 0; i < arr.length; i++) {
            index = i;

            for (int j = i; j < arr.length; j++)
                if (arr[j] < arr[index]) index = j;

            temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;

        }
    }

}
