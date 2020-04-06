package ThirtyDays.week1;

import java.util.Arrays;

public class MaxProfit {

    public static void main(String[] args) {
        int nums[] = new int[]{7,1,5,3,6,4};
        int nums1[] = new int[]{1,2,3,4,5};
        int nums2[] = new int[]{7,6,4,3,1};
        int nums3[] = new int[]{6,1,3,2,4,7};
        System.out.println(maxProfit(nums));
        System.out.println(maxProfit(nums1));
        System.out.println(maxProfit(nums2));
        System.out.println(maxProfit(nums3));
    }

    /**
     * Runtime: 1 ms
     * Memory Usage: 39.4 MB
     * Your runtime beats 91.24 % of java submissions.
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int zoneStart = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] - prices[i] < 0) {
                if (zoneStart < i) {
                    maxProfit += (prices[i] - prices[zoneStart]);
                }
                zoneStart = i + 1;
            } else {
                if (i == prices.length - 2) {
                    maxProfit += (prices[i + 1] - prices[zoneStart]);
                }
            }
        }
        return maxProfit;
    }
}
