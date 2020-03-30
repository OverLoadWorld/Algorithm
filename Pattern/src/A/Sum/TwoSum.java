package A.Sum;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,4};
        int target = 6;
        System.out.println(twoSum2(nums, target));
        System.out.println(Arrays.toString(twoSum2(nums, target)));
    }

    /**
     * Runtime: 66 ms, faster than 13.94% of Java online submissions for Two Sum.
     * Memory Usage: 39.8 MB, less than 5.65% of Java online submissions for Two Sum.
     * @param nums
     * @param target
     * @return
     */
    private static int[] twoSum(int[] nums, int target) {
        int[] ret = new int[2];
        for (int i = 0; i < nums.length; i++) {
            // 没考虑负数
//            if (nums[i] <= target) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] == target - nums[i]) {
                        ret[0] = i;
                        ret[1] = j;
                    }
                }
//            }
        }
        return ret;
    }

    /**
     * Runtime: 2 ms, faster than 75.07% of Java online submissions for Two Sum.
     * Memory Usage: 41.7 MB, less than 5.65% of Java online submissions for Two Sum.
     * @param nums
     * @param target
     * @return
     */
    private static int[] twoSum1(int[] nums, int target) {
        int[] ret = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            //没考虑本身不能用两次
            //if (map.containsKey(target - nums[i])) {
            if (map.containsKey(target - nums[i]) && i != map.get(target - nums[i])) {
                ret[0] = i;
                ret[1] = map.get(target - nums[i]);
                break;
            }
        }
        return ret;
    }

    /**
     * Runtime: 1 ms, faster than 99.88% of Java online submissions for Two Sum.
     * Memory Usage: 42.1 MB, less than 5.65% of Java online submissions for Two Sum.
     * @param nums
     * @param target
     * @return
     */
    private static int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                //map这里变成了必须维护的，所以，map.get道德index一定是小的
                //return new int[]{i, map.get(target - nums[i])};
                return new int[]{map.get(target - nums[i]), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[]{0, 0};
    }
}
