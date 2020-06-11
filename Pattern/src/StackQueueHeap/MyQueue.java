package StackQueueHeap;

import java.util.Stack;

public class MyQueue {

    Stack<Integer> stack;

    /** Initialize your data structure here. */
    public MyQueue() {
        this.stack = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if (this.stack == null || this.stack.size() == 0) {
            this.stack.push(x);
        } else {
            Stack<Integer> tempStack = new Stack<>();
            while (this.stack != null && this.stack.size() > 0) {
                tempStack.push(this.stack.pop());
            }
            tempStack.push(x);
            while (tempStack != null && tempStack.size() > 0) {
                this.stack.push(tempStack.pop());
            }
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return this.stack.pop();
    }

    /** Get the front element. */
    public int peek() {
        return this.stack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return this.stack == null || this.stack.size() == 0;
    }

    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        obj.push(4);
        obj.push(5);
        System.out.println(obj.peek());
        System.out.println(obj.pop());
        System.out.println(obj.peek());
        System.out.println(obj.pop());
        System.out.println(obj.peek());
        System.out.println(obj.pop());
        System.out.println(obj.peek());
        System.out.println(obj.pop());
        System.out.println(obj.peek());
        System.out.println(obj.pop());
        System.out.println(obj.empty());
    }
}
