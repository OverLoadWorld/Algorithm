package ThirtyDays.week1;

import java.util.Arrays;

public class MoveZeroes {
    public static void main(String[] args) {
        int nums[] = new int[]{0,1,0,3,12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * Runtime: 0 ms
     * Memory Usage: 40.2 MB
     * Your runtime beats 100.00 % of java submissions.
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        int noneZeroLocation = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[noneZeroLocation];
                nums[noneZeroLocation] = temp;
                noneZeroLocation++;
            }
        }
    }
}
