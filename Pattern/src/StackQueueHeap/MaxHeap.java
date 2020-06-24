package StackQueueHeap;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: ZhaoZhenHua1 Administrator
 * @Date: 2020/6/24 16:25
 */
public class MaxHeap {
    List<Integer> heap;

    public MaxHeap(int[] nums) {
        heap = new ArrayList<>(nums.length + 1);
        treeFormat(nums);
        maxHeapConstract(heap, heap.size());
    }

    private void maxHeapConstract(List<Integer> heap, int size) {
        //父节点下标
        int i = heap.get((heap.size() - 1) / 2);
        while (i > 0) {
            //判断与右节点的大小关系,根节点小于右子节点，则交换
            if (i * 2 + 1 < heap.size() && heap.get(i) < heap.get(i  * 2 +1)) {
                swap(heap, i, i * 2 + 1);
            }
            //判断与左节点的大小关系,根节点小于右子节点，则交换
/*            if () {
            }*/

            i--;
        }
    }

    private void swap(List<Integer> heap, int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);

    }

    private void treeFormat(int[] nums) {
        heap.add(0);
        for (int i = 0; i < nums.length; i++) {
            heap.add(nums[i]);
        }
    }
}
