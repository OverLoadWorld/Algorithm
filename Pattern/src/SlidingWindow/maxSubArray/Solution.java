package SlidingWindow.maxSubArray;

//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
// 示例:
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4],
// 输入: [-2,-1,-1,3,3,5,6,6,10],
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
//
//
// 进阶:
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
// Related Topics 数组 分治算法 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {
        int startCount = 0, endIndex = 0;
        int subArrayMax = nums[0], currySubArrayMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int nowNum = nums[i];
            // 如果遇到一个数字，比之前数字的总和都大，那最大的只可能产生在这个之后。
            if (currySubArrayMax + nums[i] > nums[i]) {
                currySubArrayMax += nums[i];
                startCount++;
            } else {
                currySubArrayMax = nums[i];
                startCount=0;
            }
            if (currySubArrayMax > subArrayMax) {
                subArrayMax = currySubArrayMax;
                endIndex = i;
            }
        }
        for (int i = endIndex - startCount; i <= endIndex; i++) {
            System.out.print(nums[i]+" ");
        }
        System.out.println("sum: " + subArrayMax);
        return subArrayMax;
    }

    /**
     * Runtime: 0 ms
     * Memory Usage: 39.7 MB
     * Your runtime beats 100.00 % of java submissions.
     * Your memory usage beats 7.04 % of java submissions.
     * @param nums
     * @return
     */
    public int maxSubArraySubmit(int[] nums) {
        int subArrayMax = nums[0], currySubArrayMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 如果遇到一个数字，比之前数字的总和都大，那最大的只可能产生在这个之后。
            if (currySubArrayMax + nums[i] > nums[i]) {
                currySubArrayMax += nums[i];
            } else {
                currySubArrayMax = nums[i];
            }
            if (currySubArrayMax > subArrayMax) {
                subArrayMax = currySubArrayMax;
            }
        }
        return subArrayMax;
    }

    public static void main(String[] args) {
        //int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int[] nums = new int[]{-6,-5,-4,3,-2,5};
        Solution solution = new Solution();
        System.out.println(solution.maxSubArray(nums));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

