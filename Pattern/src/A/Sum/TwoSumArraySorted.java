package A.Sum;

import java.util.Arrays;

public class TwoSumArraySorted {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum2(nums, target)));
    }

    /**
     * Runtime: 3 ms
     * Memory Usage: 40 MB
     * Your runtime beats 18.40 % of java submissions
     *
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int low = i + 1;
            int high = numbers.length - 1;
            while (low <= high) {
                int middle = (low + high) / 2;
                if (target - numbers[i] < numbers[middle]) {
                    high = middle - 1;
                } else if (target - numbers[i] > numbers[middle]) {
                    low = middle + 1;
                } else {
                    return new int[]{i + 1, middle + 1};
                }
            }
        }
        return new int[]{0, 0};
    }

    /**
     * Runtime: 1 ms, faster than 45.87% of Java online submissions for Two Sum II - Input array is sorted.
     * Memory Usage: 39.3 MB, less than 5.22% of Java online submissions for Two Sum II - Input array is sorted.
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] numbers, int target) {
        int head = 0, tail = numbers.length - 1;
        while (head < tail) {
            if (numbers[head] + numbers[tail] == target) {
                return new int[]{head + 1, tail + 1};
            } else if (numbers[head] + numbers[tail] > target) {
                tail--;
            } else {
                head++;
            }
        }
        return new int[]{0, 0};
    }
}
