package StackQueueHeap;

import java.util.Stack;

//224
public class BasicCalculator {

    public int calculate(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                stack.push(s.charAt(i));
            }
        }

        return calculateStack(stack);
    }

    public int calculateStack(Stack<Character> stack) {
        int result = 0;

        while (stack.peek() != null) {
            if (stack.peek() >= '0' && stack.peek() <= '9') {

            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new BasicCalculator().calculate("1 + 1"));
        System.out.println(new BasicCalculator().calculate(" 2-1 + 2 "));
        System.out.println(new BasicCalculator().calculate("(1+(4+5+2)-3)+(6+8)"));
    }
}
