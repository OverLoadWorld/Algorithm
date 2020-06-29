package StackQueueHeap;

/**
 * @Description:
 * @Author: ZhaoZhenHua1 Administrator
 * @Date: 2020/6/29 10:44
 *
 * Runtime: 1 ms, faster than 97.97% of Java online submissions for Kth Largest Element in an Array.
 * Memory Usage: 39.9 MB, less than 57.01% of Java online submissions for Kth Largest Element in an Array.
 */
public class KthLargestInArray {
    int k;
    int[] minHeap;
    int count;
    public int findKthLargest(int[] nums, int k) {
        this.k = k;
        minHeap = new int[k + 1];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            insertIntoMinHeap(minHeap, num);
        }

        return minHeap[1];
    }

    private void insertIntoMinHeap(int[] minHeap, int num) {
        if (count < k) {
            minHeap[++count] = num;
            heapUp(count);
        } else {
            if (num > minHeap[1]) {
                minHeap[1] = num;
                heapDown(1);
            }
        }
    }

    private void heapUp(int i) {
        if (i <= k) {
            int nodeIndex = i;
            while (nodeIndex > 0 && nodeIndex / 2 > 0
                    && minHeap[nodeIndex] < minHeap[nodeIndex / 2]) {
                swap(minHeap, nodeIndex, nodeIndex / 2);
                nodeIndex = nodeIndex / 2;
            }
        }
    }

    private void heapDown(int i) {
        int minNodeIndex = i;
        int left = minNodeIndex * 2;
        int right = minNodeIndex * 2 + 1;
        if (minNodeIndex < k && left <= k && minHeap[minNodeIndex] > minHeap[left]) {
            minNodeIndex = left;
        }
        if (minNodeIndex < k && right <= k && minHeap[minNodeIndex] > minHeap[right]) {
            minNodeIndex = right;
        }
        if (i != minNodeIndex) {
            swap(minHeap, minNodeIndex, i);
            heapDown(minNodeIndex);
        }
    }

    private void swap(int[] heapArray, int i, int j) {
        int temp = heapArray[i];
        heapArray[i] = heapArray[j];
        heapArray[j] = temp;
    }

    public static void main(String[] args) {
/*        int[] nums = new int[]{3,2,1,5,6,4};
        int k = 2;*/
        int[] nums = new int[]{3,2,3,1,2,4,5,5,6};
        int k = 4;
        KthLargestInArray kthLargestInArray = new KthLargestInArray();
        System.out.println(kthLargestInArray.findKthLargest(nums, k));
    }
}
