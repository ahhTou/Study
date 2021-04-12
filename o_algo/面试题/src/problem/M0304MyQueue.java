package problem;

import java.util.Stack;

/**
 * 面试题 03.04. 化栈为队
 */
public class M0304MyQueue {

    Stack<Integer> stack;
    Stack<Integer> queue;


    public M0304MyQueue() {
        stack = new Stack<>();
        queue = new Stack<>();
    }

    public void push(int x) {
        if (!queue.isEmpty()) stack = helper(queue);
        stack.push(x);
    }

    public int pop() {
        if (!stack.isEmpty()) queue = helper(stack);
        return queue.pop();
    }

    public int peek() {
        if (!stack.isEmpty()) queue = helper(stack);
        return queue.peek();
    }

    private Stack<Integer> helper(Stack<Integer> stack) {
        Stack<Integer> res = new Stack<>();
        while (!stack.isEmpty())
            res.push(stack.pop());
        return res;
    }

    public boolean empty() {
        return stack.isEmpty() && queue.isEmpty();
    }
}
