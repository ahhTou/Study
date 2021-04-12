package problem;

import java.util.Stack;

/**
 * 面试题 03.02. 栈的最小值
 */
public class M0302MinStack {

    Stack<Integer> arr;
    Stack<Integer> min;
    int _min = Integer.MAX_VALUE;

    public M0302MinStack() {
        arr = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        _min = Math.min(_min, x);
        arr.push(x);
        min.push(_min);
    }

    public void pop() {
        arr.pop();
        min.pop();

        _min = arr.isEmpty() ? Integer.MAX_VALUE : min.peek();
    }

    public int top() {
        return arr.peek();
    }

    public int getMin() {
        return _min;
    }
}
