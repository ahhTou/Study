package sort;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * 桶排序
 * 设置一个定量的数组当作空桶；
 * 遍历输入数据，并且把数据一个一个放到对应的桶里去；
 * 对每个不是空的桶进行排序；
 * 从不是空的桶里把排好序的数据拼接起来。
 */
public class BucketSort {

    public void sort(int[] arr) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        int size = 5; // 每个桶的大小
        List<List<Integer>> buckets = new LinkedList<>();

        for (int i : arr) {
            if (i > max) max = i;
            if (i < min) min = i;
        }

        for (int i = 0; i <= Math.floorDiv(max - min, size); i++)
            buckets.add(new LinkedList<>());

        // 利用映射函数将数据分配到各个桶中
        for (int j : arr) {
            System.out.println(Math.floorDiv(j - min, size));
            buckets.get(Math.floorDiv(j - min, size)).add(j);
        }

        int i = 0;
        for (List<Integer> bucket : buckets) {
            bucket.sort(Comparator.naturalOrder());
            for (Integer num : bucket) arr[i++] = num;
        }


    }

}
