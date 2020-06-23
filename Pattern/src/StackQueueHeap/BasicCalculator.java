package StackQueueHeap;

import java.util.Stack;

//224
public class BasicCalculator {

    public int calculate(String s) {
        Stack<Character> opStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        boolean canCalculate = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                continue;
            } else if (c >= '0' && c <= '9') {
                int num = getNextNumber(s, i);
                numStack.push(num);
                while (i != s.length() - 1 && c >= '0' && c <= '9') {
                    c = s.charAt(++i);
                }
                if (i != s.length() - 1) {
                    i--;
                } else {
                    calculateInStack(numStack, opStack);
                }
            } else if (c == '+' || c == '-') {
                calculateInStack(numStack, opStack);
                opStack.push(c);
            } else if (c == '(') {
                canCalculate = false;
                continue;
            } else if (c == ')') {
                calculateInStack(numStack, opStack);
            }
        }
        return numStack.pop();
    }

    private void calculateInStack(Stack<Integer> numStack, Stack<Character> opStack) {
        if (numStack.size() >= 2) {
            int num2 = numStack.pop();
            int num1 = numStack.pop();
            if (opStack.peek() == '+') {
                numStack.push(num1 + num2);
            } else if (opStack.peek() == '-') {
                numStack.push(num1 - num2);
            }
            opStack.pop();
        }
    }

    private int getNextNumber(String s, int i) {
        int result = 0;
        while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            result = result * 10 + s.charAt(i) - '0';
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
//        System.out.println(new BasicCalculator().calculate("1 + 1"));
//        System.out.println(new BasicCalculator().calculate(" 2-1 + 2 "));
//        System.out.println(new BasicCalculator().calculate("(1+(4+5+2)-3)+(6+8)"));
        System.out.println(new BasicCalculator().calculate("12 - (3 - 2)"));
//        System.out.println(new BasicCalculator().calculate("0 - 3"));
    }
}
