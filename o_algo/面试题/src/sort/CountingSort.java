package sort;

/**
 * 计数排序
 * 找出待排序的数组中最大和最小的元素；
 * 统计数组中每个值为i的元素出现的次数，存入数组C的第i项；
 * 对所有的计数累加（从C中的第一个元素开始，每一项和前一项相加）；
 * 反向填充目标数组：将每个元素i放在新数组的第C(i)项，每放一个元素就将C(i)减去1。
 */
public class CountingSort {

    public void sort(int[] arr) {

        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

        for (int i : arr) {
            if (i > max) max = i;
            if (i < min) min = i;
        }

        int[] count = new int[max - min + 1];

        for (int i : arr) count[i - min]++;

        for (int i = 0, j = 0; i < count.length; i++)
            for (int k = 0; k < count[i]; k++) arr[j++] = i + min;
    }

}
