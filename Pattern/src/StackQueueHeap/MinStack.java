package StackQueueHeap;

import java.util.Stack;

public class MinStack {

    /**
     *     执行耗时:4 ms,击败了90.61% 的Java用户
     *     内存消耗:41.2 MB,击败了69.43% 的Java用户
     */

    Stack<Integer> stack;
    Stack<Integer> minStack;


    /**
     * 执行耗时:5 ms,击败了59.83% 的Java用户
     * 		内存消耗:41.4 MB,击败了41.34% 的Java用户
     */
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack != null && minStack.size() > 0) {
            if (minStack.peek() > x) {
                minStack.push(x);
            } else {
                minStack.push(minStack.peek());
            }
        } else {
            minStack.push(x);
        }

    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        System.out.println(minStack.top());    // return 0
        System.out.println(minStack.getMin()); // return -2
    }
}
