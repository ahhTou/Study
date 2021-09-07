package problem;

import java.util.Stack;

/**
 * 面试题 03.05. 栈排序
 */
public class M0305SortedStack {

    Stack<Integer> stack;

    public M0305SortedStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if (stack.isEmpty() || val <= stack.peek()) stack.push(val);
        else stack = helper(val, stack);
    }

    public Stack<Integer> helper(int val, Stack<Integer> stack) {
        if (stack.isEmpty() || val <= stack.peek()) {
            stack.push(val);
            return stack;
        }
        int temp = stack.pop();
        Stack<Integer> helper = helper(val, stack);
        helper.push(temp);
        return helper;
    }

    public void pop() {
        if (!stack.isEmpty()) stack.pop();
    }

    public int peek() {
        return stack.isEmpty() ? -1 : stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
