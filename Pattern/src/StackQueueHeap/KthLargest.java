package StackQueueHeap;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: ZhaoZhenHua1 Administrator
 * @Date: 2020/6/24 11:18
 */
public class KthLargest {

    List<Integer> heapArray;

    int kThLargest = 0;

    public KthLargest(int k, int[] nums) {
        heapArray = new ArrayList<>(nums.length + 1);
        // i == 0 不放东西
        heapArray.add(0);
        //constract completed tree
        for (int i = 0; i < nums.length; i++) {
            heapArray.add(nums[i]);
        }
        //constract max heap
//        createMapHeap(heapArray);
    }

    public int add(int val) {
        return 0;
    }

    public static void main(String[] args) {
        int k = 3;
        int[] nums = new int[]{4,5,8,2};
        KthLargest obj = new KthLargest(k, nums);
        System.out.println(obj.add(3));
        System.out.println(obj.add(5));
        System.out.println(obj.add(10));
        System.out.println(obj.add(9));
        System.out.println(obj.add(4));
    }
}
