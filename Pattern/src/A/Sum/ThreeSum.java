package A.Sum;

import java.util.*;

public class ThreeSum {

    public static void main(String[] args) {
        //int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        //int[] nums = new int[]{1,2,-2,-1};
        int[] nums = new int[]{-15,13,6,-11,-4,5,-13,5,3,2,6,-1,4,12,-10,-13,-7,-4,-5,6,9,-14,1,-6,13,7,-8,10,-4,11,-8,-3,1,5,-7,4,-13,-13,-5,-3,4,-14,11,-14,5,-13,-12,13,-10,-10,-4,-15,13,13,-14,11,-3,-15,6,1,3,5,13,-11,-5,-9,1,-2,-14,11,10,5,4,-1,6,-6,-7,9,-15,-2,7,-12,-10,5,-14,13,-6,-9,6,7,7,-6,-2,-3,-9,0,-5,7,5,-4,-5,-7,-13,14,7,8,-15,7,-5,-15,-10,9};
        //int[] nums = new int[]{0, 14, -7, 2, 7, 11, -9, 11, -12, 6, -10, -8, 9, -3, 7, -6, 3, 4, 14, -10, -8, 5, -1, 6, 12, 9, 12, -11, -15, -5, 5, 0, -6, 13, 9, 9, 10, 7, 5, 13, -2, 11, -10, -15, -15, 4, -14, -4, -15, 7, -7, -15, -3, 8, -2, -13, -6, -5, -9, -14, 5, 12, 1, 6, 2, -12, -8, -11, 10, 13, -13, -14, 1, 14, 8, 1, -4, 9, 4, -12, -6, 13, 10, 6, 6, -7, 8, 7, 3, 7, 8, -15, -4, -14, -1, 13, -11, 6, -12, -15, 4, 12, 8, -10, 4, 1, -1, 7, -13, -12, 10, -4, 8, 6, 10, -1, 6, -5, 13, -13, 9, 6, -13, -10};
        System.out.println(threeSum2(nums));
        System.out.println(threeSum3(nums));
    }

    /**
     * Time Limit Exceeded 超时
     * 太黛比了，暴力
     * [-15,13,6,-11,-4,5,-13,5,3,2,6,-1,4,12,-10,-13,-7,-4,-5,6,9,-14,1,-6,13,7,-8,10,-4,11,-8,-3,1,5,-7,4,-13,-13,-5,-3,4,-14,11,-14,5,-13,-12,13,-10,-10,-4,-15,13,13,-14,11,-3,-15,6,1,3,5,13,-11,-5,-9,1,-2,-14,11,10,5,4,-1,6,-6,-7,9,-15,-2,7,-12,-10,5,-14,13,-6,-9,6,7,7,-6,-2,-3,-9,0,-5,7,5,-4,-5,-7,-13,14,7,8,-15,7,-5,-15,-10,9]
     *
     * @param nums
     * @return
     */
    private static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> sum = new ArrayList<>();
        Set<Set<Integer>> record = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int needSum = -nums[i];
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (needSum == nums[j] + nums[k] && !ijkRepeated(record, nums[i], nums[j], nums[k])) {
                        List<Integer> sub = new ArrayList<>();
                        sub.add(nums[i]);
                        sub.add(nums[j]);
                        sub.add(nums[k]);
                        sum.add(sub);
                        Set itemSet = new HashSet<>();
                        itemSet.add(nums[i]);
                        itemSet.add(nums[j]);
                        itemSet.add(nums[k]);
                        record.add(itemSet);
                    }
                }
            }
        }
        return sum;
    }

    /**
     * Time Limit Exceeded 超时
     * [0,14,-7,2,7,11,-9,11,-12,6,-10,-8,9,-3,7,-6,3,4,14,-10,-8,5,-1,6,12,9,12,-11,-15,-5,5,0,-6,13,9,9,10,7,5,13,-2,11,-10,-15,-15,4,-14,-4,-15,7,-7,-15,-3,8,-2,-13,-6,-5,-9,-14,5,12,1,6,2,-12,-8,-11,10,13,-13,-14,1,14,8,1,-4,9,4,-12,-6,13,10,6,6,-7,8,7,3,7,8,-15,-4,-14,-1,13,-11,6,-12,-15,4,12,8,-10,4,1,-1,7,-13,-12,10,-4,8,6,10,-1,6,-5,13,-13,9,6,-13,-10]
     *
     * @param nums
     * @return
     */
    private static List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> sum = new ArrayList<>();
        Set<Set<Integer>> record = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length - 2; i++) {
            int needSum = -nums[i];
            for (int j = i + 1; j < nums.length - 1; j++) {
                int needSecondSum = needSum - nums[j];
                //这里可能出现单个数字用两次的情况[1,2,-2,-1]   Expected []   Output [[1,-2,1]]
                //if (map.containsKey(needSecondSum) && !ijkRepeated(record, nums[i], nums[j], needSecondSum)) {
                if (map.containsKey(needSecondSum) && map.get(needSecondSum) != i && map.get(needSecondSum) != j && !ijkRepeated(record, nums[i], nums[j], needSecondSum)) {
                    List<Integer> sub = new ArrayList<>();
                    sub.add(nums[i]);
                    sub.add(nums[j]);
                    sub.add(needSecondSum);
                    sum.add(sub);
                    Set itemSet = new HashSet<>();
                    itemSet.add(nums[i]);
                    itemSet.add(nums[j]);
                    itemSet.add(needSecondSum);
                    record.add(itemSet);
                }
            }
        }
        return sum;
    }

    /**
     * Runtime: 131 ms, faster than 29.46% of Java online submissions for 3Sum.
     * Memory Usage: 44 MB, less than 99.65% of Java online submissions for 3Sum.
     * @param nums
     * @return
     */
    private static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> sum = new ArrayList<>();
        //排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = nums.length - 1;
            while (i < j) {
                int c = nums[j];
                if (j < nums.length - 1 && nums[j] == nums[j + 1]) {
                    j--;
                    continue;
                }
                int target = -a - c;
                if (target >= a && target <= c) {
                    //二分查找
                    int low = i + 1;
                    int high = j - 1;
                    while (low <= high) {
                        int middle = (low + high) / 2;
                        if (nums[middle] < target) {
                            low = middle + 1;
                        } else if (nums[middle] > target) {
                            high = middle - 1;
                        } else {
                            List<Integer> sub = new ArrayList<>();
                            sub.add(a);
                            sub.add(c);
                            sub.add(target);
                            sum.add(sub);
                            break;
                        }
                    }
                }
                j--;
            }
        }
        return sum;
    }

    /**
     * Runtime: 23 ms, faster than 44.22% of Java online submissions for 3Sum.
     * Memory Usage: 43.5 MB, less than 100.00% of Java online submissions for 3Sum.
     * @param nums
     * @return
     */
    private static List<List<Integer>> threeSum3(int[] nums) {
        List<List<Integer>> sum = new ArrayList<>();
        //排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int low = i + 1;
                int high = nums.length - 1;
                int otherTwoSum = -nums[i];
                while (low < high) {
                    if (nums[low] + nums[high] == otherTwoSum) {
                        sum.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        while (low < high && nums[low] == nums[low + 1]) low++;
                        while (low < high && nums[high] == nums[high - 1]) high--;
                        low++;
                        high--;
                    } else if (nums[low] + nums[high] < otherTwoSum) {
                        while (low < high && nums[low] == nums[low + 1]) low++;
                        low++;
                    } else {
                        while (low < high && nums[high] == nums[high - 1]) high--;
                        high--;
                    }
                }

            }
        }
        return sum;
    }

    private static boolean ijkRepeated(Set<Set<Integer>> record, int i, int j, int k) {
        Set<Integer> target = new HashSet<>();
        target.add(i);
        target.add(j);
        target.add(k);
        if (record.contains(target)) {
            return true;
        }
        return false;
    }
}
