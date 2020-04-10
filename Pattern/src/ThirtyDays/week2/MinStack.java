package ThirtyDays.week2;

/**
 * Runtime: 3 ms
 * Memory Usage: 41.5 MB
 * Your runtime beats 100.00 % of java submissions.
 * Your memory usage beats 10.15 % of java submissions.
 */
public class MinStack {
    int caption = 2;
    int[] stackArray = new int[caption];
    int topIndex = 0;
    int minElement = Integer.MAX_VALUE;

    /**
     * initialize your data structure here.
     */
    public MinStack() {

    }

    public void push(int x) {
        //扩容
        if (topIndex >= caption) {
            int[] newArray = new int[caption * 2];
            System.arraycopy(stackArray, 0, newArray, 0, stackArray.length);
            caption *= 2;
            stackArray = newArray;
        }
        stackArray[topIndex++] = x;
        //设置最小元素
        if (x < minElement) {
            minElement = x;
        }
    }

    public void pop() {
        if (topIndex <= 0) {
            throw new UnsupportedOperationException();
        }
        topIndex--;
        //设置最小元素
        if (topIndex == 0) {
            minElement = Integer.MAX_VALUE;
        } else {
            minElement = stackArray[0];
        }

        for (int i = 1; i < topIndex; i++) {
            if (stackArray[i] < minElement) {
                minElement = stackArray[i];
            }
        }
    }

    public int top() {
        if (topIndex <= 0) {
            throw new UnsupportedOperationException();
        }
        return stackArray[topIndex - 1];
    }

    public int getMin() {
        return minElement;
    }

    public static void main(String[] args) {
/*        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());*/
/**
 * ["MinStack","push","push","push",
 * "top","pop","getMin","pop","getMin","pop",
 * "push",
 * "top","getMin",
 * "push",
 * "top","getMin","pop","getMin"]
 * [[],[2147483646],[2147483646],[2147483647],
 * [],[],[],[],[],[],
 * [2147483647],
 * [],[],
 * [-2147483648],
 * [],[],[],[]]
 */
        MinStack minStack = new MinStack();
        minStack.push(2147483646);
        minStack.push(2147483646);
        minStack.push(2147483647);
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();

        minStack.push(2147483647);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.push(-2147483648);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}
