package utils;

import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public ListNode(List<Integer> list) {
        if (list.size() == 0) {
            this.next = null;
        }
        this.val = list.get(0);

        if (list.size() > 1) {
            this.next = new ListNode(list.subList(1, list.size()));
        } else {
            this.next = null;
        }
    }

    @Override
    public String toString() {
        if (this.next == null)
            return this.val + "";
        return val + ", " + this.next.toString();
    }
}
