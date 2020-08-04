package Greedy;

import java.util.Stack;

/**
 * @Description:
 * @Author: ZhaoZhenHua1 Administrator
 * @Date: 2020/8/4 19:56
 */
public class RemoveKdigits {
    public String removeKdigits(String num, int k) {
        int newLength = num.length() - k;
        if (newLength == 0) {
            return "0";
        }
        Stack<Character> characterStack = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            char ch = num.charAt(i);
            characterStack.push(ch);
            int remainLength = newLength - characterStack.size();
            for (int j = i + 1; j < num.length(); j++) {
                if (num.length() - j > remainLength && characterStack.peek() > num.charAt(j)) {
                    characterStack.pop();
                    characterStack.push(num.charAt(j));
                    i = j - 2;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (characterStack.size() > 0) {
            Stack<Character> tempStack = new Stack<>();
            while (!characterStack.isEmpty()) {
                tempStack.push(characterStack.pop());
            }
            int preZeroMark = 0;
            while (!tempStack.isEmpty()) {
                if (tempStack.peek() == '0' && preZeroMark == 0) {
                    tempStack.pop();
                } else {
                    preZeroMark = 1;
                }
                stringBuilder.append(tempStack.pop());
            }
        }
        return stringBuilder.toString();
    }
    public static void main(String[] args) {
        RemoveKdigits removeKdigits = new RemoveKdigits();

        String num = "1432219";
        int k = 3;
        System.out.println(removeKdigits.removeKdigits(num, k));
    }
}
