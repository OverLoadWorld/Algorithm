package Greedy;

/**
 * @Description:
 * @Author: ZhaoZhenHua1 Administrator
 * @Date: 2020/8/4 17:24
 */
public class WiggleMaxLength {

    public static final int BEGIN = 0;
    public static final int UP = 1;
    public static final int DOWN = 2;

    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int result = 1;
        int state = BEGIN;
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            switch (state) {
                case BEGIN:

                    if (nums[i - 1] < num) {
                        result++;
                        state = UP;
                    } else if (nums[i - 1] > num) {
                        result++;
                        state = DOWN;
                    }
                    break;
                case UP:
                    if (nums[i - 1] > num) {
                        result++;
                        state = DOWN;
                    }
                    break;
                case DOWN:
                    if (nums[i - 1] < num) {
                        result++;
                        state = UP;
                    }
                    break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        WiggleMaxLength wiggleMaxLength = new WiggleMaxLength();

//        int[] g = new int[]{5, 10, 2, 9, 15 ,9};
//        int[] g = new int[]{1,7,4,9,2,5};
//        int[] g = new int[]{1,17,5,10,13,15,10,5,16,8};
//        int[] g = new int[]{1,2,3,4,5,6,7,8,9};
        int[] g = new int[]{0, 0};
//        int[] g = new int[]{0};
//        int[] g = new int[]{};
        System.out.println(wiggleMaxLength.wiggleMaxLength(g));
    }
}
