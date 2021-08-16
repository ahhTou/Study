package sort;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class RadixSort {

    public void sort(int[] arr) {

        List<List<Integer>> counters = new LinkedList<>();
        for (int i = 0; i < 10; i++) counters.add(new LinkedList<>());

        int maxDigit = 0, mod = 10, dev = 1, pos;
        // 得到最大位数
        for (int num : arr) {
            int len = Integer.toString(num).length();
            int digit = len > 0 ? len : len - 1;
            if (digit > maxDigit) maxDigit = digit;
        }

        for (int i = 0; i < maxDigit; i++, dev *= 10, mod *= 10) {
            pos = 0;

            for (int num : arr) counters.get(num % mod / dev).add(num);

            for (List<Integer> counter : counters) {
                for (int num : counter) arr[pos++] = num;
                counter.clear();
            }

            System.out.println(Arrays.toString(arr));

        }


    }

}
