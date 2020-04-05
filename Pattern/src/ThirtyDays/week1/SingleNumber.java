package ThirtyDays.week1;

import java.util.Arrays;

/**
 * Your algorithm should have a linear runtime complexity.
 * Could you implement it without using extra memory?
 */
public class SingleNumber {
    public static void main(String[] args) {
        int[] nums1 = new int[]{2,2,1};
        int[] nums2 = new int[]{4,1,2,1,2};
        System.out.println(singleNumber(nums1));
        System.out.println(singleNumber(nums2));
    }

    /**
     * Runtime: 3 ms
     * Memory Usage: 41.2 MB
     * @param nums
     * @return
     */
    private static int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i+=2) {
            if (i == nums.length - 1 || nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return 0;
    }

}
