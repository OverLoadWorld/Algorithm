package src.ThirtyDays.lacks;

/**
 * @Description:
 * @Author: ZhaoZhenHua1 Administrator
 * @Date: 2020/5/20 13:08
 */
public class StockSpanner {
    /**
     * Your runtime beats 7.57 % of java submissions.
     * Runtime: 1374 ms
     * Memory Usage: 49.1 MB
     */
/*
    int[] priceHistory;
    int length;

    public StockSpanner() {
        priceHistory = new int[10000];
        length = 0;
    }

    public int next(int price) {
        this.priceHistory[length] = price;
        this.length++;

        int span = 0;
        for (int i = 0; i < this.length; i++) {
            if (priceHistory[i] <= price) {
                span++;
            } else {
                span = 0;
            }
        }
        return span;
    }*/

    /**
     * Your runtime beats 13.63 % of java submissions.
     * Runtime: 215 ms
     * Memory Usage: 48.7 MB
     */
    /*int[] priceHistory;
    int length;

    public StockSpanner() {
        priceHistory = new int[10000];
        length = 0;
    }

    public int next(int price) {
        this.priceHistory[length] = price;
        this.length++;

        int span = 0;
        for (int i = length - 1; i >= 0; i--) {
            if (priceHistory[i] <= price) {
                span++;
            } else {
                break;
            }
        }
        return span;
    }*/

    /*Stack<Integer> prices, weights;

    public StockSpanner() {
        prices = new Stack();
        weights = new Stack();
    }

    public int next(int price) {
        int w = 1;
        while (!prices.isEmpty() && prices.peek() <= price) {
            prices.pop();
            w += weights.pop();
        }

        prices.push(price);
        weights.push(w);
        return w;
    }*/


    int[][] stack;
    int top;
    public StockSpanner()
    {
        stack = new int[2][10000];
        top = -1;
    }

    public int next(int price)
    {
        int span = 1;
        while(top>=0 && stack[0][top]<=price)
        {
            span+=stack[1][top--];
        }
        top++;
        stack[0][top] = price;
        stack[1][top] = span;
        return span;
    }

    public static void main(String[] args) {
/*        StockSpanner obj = new StockSpanner();
        int param_1 = obj.next(100);
        int param_2 = obj.next(80);
        int param_3 = obj.next(60);
        int param_4 = obj.next(70);
        int param_5 = obj.next(60);
        int param_6 = obj.next(75);
        int param_7 = obj.next(85);
        System.out.println(param_1);
        System.out.println(param_2);
        System.out.println(param_3);
        System.out.println(param_4);
        System.out.println(param_5);
        System.out.println(param_6);
        System.out.println(param_7);*/


    }
}
