package problem;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 面试题 03.03. 堆盘子
 */
public class M0303StackOfPlates {

    List<Stack<Integer>> table;
    Stack<Integer> cur = null;
    int max_size;


    public M0303StackOfPlates(int cap) {
        max_size = cap;
        table = new ArrayList<>();
    }

    public void push(int val) {
        System.out.println(table);

        if (max_size <= 0) return;

        cur = (table.isEmpty() || cur.size() == max_size) ? new Stack<>() : cur;

        if (cur.isEmpty()) table.add(cur);

        cur.push(val);
    }

    public int pop() {
        System.out.println(table);

        if (cur == null) return -1;

        if (cur.isEmpty()) {
            table.remove(table.size() - 1);
            cur = table.size() == 0 ? null : table.get(table.size() - 1);
            if (cur == null) return -1;
        }

        int res = cur.pop();

        if (cur.isEmpty()) {
            table.remove(table.size() - 1);
            cur = table.size() == 0 ? null : table.get(table.size() - 1);
        }

        return res;
    }

    public int popAt(int index) {
        System.out.println(table);


        if (table.isEmpty() || index < 0 || index > table.size() - 1) return -1;

        Stack<Integer> stack = table.get(index);

        if (stack == cur) return this.pop();

        if (stack.isEmpty()) {
            table.remove(index);
            return -1;
        }

        int res = stack.pop();

        if (stack.isEmpty()) table.remove(index);

        return res;

    }
}
