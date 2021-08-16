package sort;

import sun.dc.pr.PRError;

public class HeapSort {

    public void sort(int[] arr) {

        // 1. 构建大顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--)
            adjustHeap(arr, i, arr.length); // 从第一个非叶子结点从下至上，从右至左调整结构

        // 2. 调整堆结构 + 交换堆顶元素与末尾元素
        for (int j = arr.length - 1; j > 0; j--) {

            // 将堆顶元素与末尾元素进行交换
            swapHead(arr, j);

            adjustHeap(arr, 0, j);//重新对堆进行调整
        }

    }

    private void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];//先取出当前元素i

        for (int k = left(i); k < length; k = left(k)) { // 从 i 结点的左子结点开始，也就是2i+1处开始

            // 如果左子结点小于右子结点，k指向右子结点
            if (k + 1 < length && arr[k] < arr[k + 1]) k++;

            // 如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
            if (arr[k] <= temp) break;

            arr[i] = arr[k];
            i = k;

        }

        arr[i] = temp; // 将temp值放到最终的位置

    }

    /**
     * 输入一个坐标，返回得到该节点的下一个左节点的坐标
     */
    private int left(int index) {
        return index * 2 + 1;
    }

    private void swapHead(int[] arr, int a) {
        int temp = arr[a];
        arr[a] = arr[0];
        arr[0] = temp;
    }

}
