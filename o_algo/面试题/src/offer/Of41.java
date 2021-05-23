package offer;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 剑指 Offer 41. 数据流中的中位数
 * 小顶堆、大顶堆
 */
public class Of41 {

    Queue<Integer> A, B;

    public Of41() {
        A = new PriorityQueue<>(); // 小顶堆
        B = new PriorityQueue<>((x, y) -> (y - x)); // 大顶堆
    }

    public void addNum(int num) {
        if (A.size() == B.size()) {
            B.add(num);
            A.add(B.poll());
        } else {
            A.add(num);
            B.add(A.poll());
        }
    }

    public double findMedian() {
        return A.size() == B.size() ? (A.peek() + B.peek()) / 2.0 : A.peek();
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> a = new PriorityQueue<>();
        PriorityQueue<Integer> b = new PriorityQueue<>((x, y) -> (y - x));

        a.add(3);
        a.add(2);
        a.add(5);
        b.add(3);
        b.add(2);
        b.add(5);

        System.out.println(a);
        System.out.println(b);
    }


}
