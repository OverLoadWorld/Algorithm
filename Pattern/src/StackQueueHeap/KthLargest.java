package StackQueueHeap;

/**
 * @Description:
 * @Author: ZhaoZhenHua1 Administrator
 * @Date: 2020/6/24 11:18
 * Runtime: 11 ms, faster than 99.85% of Java online submissions for Kth Largest Element in a Stream.
 * Memory Usage: 43.6 MB, less than 90.68% of Java online submissions for Kth Largest Element in a Stream.
 */
public class KthLargest {

    int[] heapArray;
    int k;
    int count;

    public KthLargest(int k, int[] nums) {
        this.heapArray = new int[k + 1];
        this.count = 0;
        this.k = k;
        createMinHeapSizeK(heapArray, nums);
    }

    private void createMinHeapSizeK(int[] heapArray, int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            insertNumIntoMinHeap(heapArray, num);
        }
    }

    private void insertNumIntoMinHeap(int[] heapArray, int num) {
        if (count < k) {
            //构造时
            heapArray[++count] = num;
            //这是需要上浮
            heapUp(count);
        } else {
            if (num >= heapArray[1]) {
                heapArray[1] = num;
                heapDown2(k, 1);
            }
        }
    }

    private void heapUp(int index) {
        if (index <= k) {
            int nodeIndex = index;
            int value = this.heapArray[nodeIndex];
            while (nodeIndex > 0 && nodeIndex / 2 > 0
                    && heapArray[nodeIndex] < (heapArray[nodeIndex / 2])) {
                swap(heapArray, nodeIndex, nodeIndex / 2);
                nodeIndex = nodeIndex / 2;
            }
        }
    }

    private void heapDown(int k, int i) {
        while (true) {
            int minNode = i;
            int left = 2 * minNode;
            int right = 2 * minNode + 1;
            if (left <= k && heapArray[minNode] > heapArray[left]) {
                minNode = left;
            }
            if (right <= k && heapArray[minNode] > heapArray[right]) {
                minNode = right;
            }
            if (i == minNode) {
                break;
            }
            swap(heapArray, i, minNode);
            i = minNode;
        }
    }

    private void heapDown2(int k, int i) {
        int minNode = i;
        int left = 2 * minNode;
        int right = 2 * minNode + 1;
        if (left <= k && heapArray[minNode] > heapArray[left]) {
            minNode = left;
        }
        if (right <= k && heapArray[minNode] > heapArray[right]) {
            minNode = right;
        }
        if (minNode != i) {
            swap(heapArray, i, minNode);
            heapDown2(k, minNode);
        }
    }


    private void swap(int[] heapArray, int i, int j) {
        int temp = heapArray[i];
        heapArray[i] = heapArray[j];
        heapArray[j] = temp;
    }

    public int add(int val) {
        insertNumIntoMinHeap(heapArray, val);
        return heapArray[1];
    }

    public static void main(String[] args) {
        int k = 3;
        int[] arr = new int[]{4,5,8,2};
        KthLargest kthLargest = new KthLargest(k, arr);
        System.out.println(kthLargest.add(3));   // returns 4
        System.out.println(kthLargest.add(5));   // returns 5
        System.out.println(kthLargest.add(10));  // returns 5
        System.out.println(kthLargest.add(9));   // returns 8
        System.out.println(kthLargest.add(4));   // returns 8
    }
}
