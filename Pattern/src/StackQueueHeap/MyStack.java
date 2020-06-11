package StackQueueHeap;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MyStack {

    Queue<Integer> stack;

    /** Initialize your data structure here. */
    public MyStack() {
        this.stack = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        if (this.stack != null && this.stack.size() > 0) {
            Queue<Integer> tempQueue = new LinkedList<>();
            tempQueue.add(x);
            while (this.stack != null && this.stack.size() > 0) {
                Integer node = stack.poll();
                tempQueue.add(node);
            }
            this.stack = tempQueue;
        } else {
            if (this.stack == null) {
                this.stack = new LinkedList<>();
            }
            this.stack.add(x);
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return this.stack.poll();
    }

    /** Get the top element. */
    public int top() {
        return this.stack.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return this.stack == null || this.stack.size() == 0;
    }

    public static void main(String[] args) {
        MyStack obj = new MyStack();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        obj.push(4);
        obj.push(5);
        System.out.println(obj.top());
        System.out.println(obj.pop());
        System.out.println(obj.top());
        System.out.println(obj.pop());
        System.out.println(obj.top());
        System.out.println(obj.pop());
        System.out.println(obj.top());
        System.out.println(obj.pop());
        System.out.println(obj.top());
        System.out.println(obj.pop());
        System.out.println(obj.empty());
    }
}
