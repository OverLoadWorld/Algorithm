package ThirtyDays.week1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public static void main(String[] args) {
        int num = 99;
        System.out.println(isHappy(num));
        System.out.println(isHappy2(num));
    }

    /**
     * Runtime: 1 ms
     * Memory Usage: 36.8 MB
     * Your runtime beats 83.97 % of java submissions.
     * @param n
     * @return
     */
    public static boolean isHappy(int n) {
        int[] squareTable = new int[10];
        for (int i = 0; i < 10; i++) {
            squareTable[i] = i * i;
        }
        int sum = 0;
        Set alreadySum = new HashSet<>();
        while (true) {
            if (sum > 0) {
                n = sum;
                sum = 0;
            }
            while (n > 0) {
                sum += squareTable[n % 10];
                n /= 10;
            }
            if (sum == 1) {
                return true;
            }
            if (alreadySum.contains(sum)) {
                return false;
            }
            alreadySum.add(sum);
        }
    }

    /**
     * Runtime: 0 ms
     * Memory Usage: 36.5 MB
     * Your runtime beats 100.00 % of java submissions.
     * @param n
     * @return
     */
    public static boolean isHappy2(int n) {
        int[] squareTable = new int[10];
        for (int i = 0; i < 10; i++) {
            squareTable[i] = i * i;
        }
        int sum = 0;
        while (true) {
            if (sum > 0) {
                n = sum;
                sum = 0;
            }
            while (n > 0) {
                sum += squareTable[n % 10];
                n /= 10;
            }
            if (sum == 1) {
                return true;
            }
            if (sum == 4) {
                return false;
            }
        }
    }
}
